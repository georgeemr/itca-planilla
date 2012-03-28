/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.*;
import java.math.BigDecimal;
import com.infosgroup.planilla.modelo.entidades.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@LocalBean
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleados, EmpleadosPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleados.class);
    }

    public List<Empleados> findEmpleadosEvaluados(Campania c) {
        List<Empleados> le = null;
        Query q = em.createNativeQuery("select em.* from empleados em where (cod_cia, em.cod_emp) in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleados.class);
        q.setParameter(1, c.getCampaniaPK().getCodCia());
        q.setParameter(2, c.getCampaniaPK().getPeriodo());
        q.setParameter(3, c.getCampaniaPK().getCodCampania());
        le = (List<Empleados>) q.getResultList();
        return le;
    }

    public List<Empleados> findEmpleadosNoEvaluados(Campania c) {
        List<Empleados> le = null;
        Query q = em.createNativeQuery("select em.* from empleados em where (cod_cia, em.cod_emp) not in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleados.class);
        q.setParameter(1, c.getCampaniaPK().getCodCia());
        q.setParameter(2, c.getCampaniaPK().getPeriodo());
        q.setParameter(3, c.getCampaniaPK().getCodCampania());
        le = (List<Empleados>) q.getResultList();
        return le;
    }

    public Empleados findByUsuario(String usuario) throws javax.persistence.NoResultException {
        Empleados e = null;
        TypedQuery tq = em.createQuery("SELECT e FROM Empleados e WHERE e.usuario = :usuario", Empleados.class);
        tq.setParameter("usuario", usuario);
        e = (Empleados) tq.getSingleResult();
        return e;
    }

    public List<Empleados> findByJefes() {
        List<Empleados> listaJefes = new ArrayList<Empleados>(0);
        TypedQuery<Empleados> pue = em.createQuery("select e from Empleado e, PuestoEmpleado p where p.puesto.jefatura = 1 ", Empleados.class);
        listaJefes = pue.getResultList();
        return listaJefes != null ? listaJefes : new ArrayList<Empleados>();
    }

    public Integer max(short empresa) {
        Integer max = (Integer) em.createQuery("SELECT max(e.empleadosPK.codEmp) FROM Empleados e WHERE e.empleadosPK.codCia = :codCia").setParameter("codCia", empresa).getSingleResult();
        return max != null ? (++max) : 1;
    }

    @PermitAll
    public Empleados toEmpleado(Candidato c) {
        Empleados e = new Empleados();
        EmpleadosPK pk = new EmpleadosPK(c.getCandidatoPK().getCodCia(), max(c.getCandidatoPK().getCodCia()).intValue());
        e.setEmpleadosPK(pk);
        if (c != null) {
            e.setNombres(c.getNombre());
            e.setApellidos(c.getApellido());
            e.setApCasada(c.getApCasada());
            e.setFechaNac(c.getFechaNac());
            e.setObservacion(c.getObservacion());
            e.setCodPais(c.getCodPaisNacimiento());
        }
        return e;
    }

    @PermitAll
    public String generaUsuario(Candidato c) {
        String nombre = "", apellido = "", user = "";
        int n = 0;
        nombre = c.getNombre() != null ? c.getNombre().split(" ")[0] : "";
        apellido = c.getApellido() != null ? c.getApellido().split(" ")[0] : "";
        user = nombre + apellido;
        for (;;) {
            if (em.createNamedQuery("Empleados.findByUsuario", Empleados.class).setParameter("usuario", user).getResultList().isEmpty()) {
                break;
            }
            user += n;
            n++;
        }
        return user;
    }

    @PermitAll
    public List<Empleados> findEmpleadosByUsuario(String usuario) {
        List<Empleados> lista = null;
        Query q = em.createNamedQuery("Empleados.findByUsuario", Empleados.class);
        q.setParameter("usuario", usuario);
        lista = q.getResultList();
        return lista != null ? lista : new ArrayList<Empleados>();
    }

    @PermitAll
    public Integer totalAfectadosDepartamentos(Departamentos departamento) {
        Long t = (Long) em.createQuery("SELECT count(e.empleadosPK.codEmp) FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.departamentos = :departamentos AND e.status = 'A' ").setParameter("codCia", departamento.getDepartamentosPK().getCodCia()).setParameter("departamentos", departamento).getSingleResult();
        return t != null ? t.intValue() : 0;
    }

    @PermitAll
    public Integer totalAfectadosTipoPlanilla(TiposPlanilla tipoPlanilla) {
        Long t = (Long) em.createQuery("SELECT count(e.empleadosPK.codEmp) FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.tiposPlanilla = :tiposPlanilla AND e.status = 'A' ").setParameter("codCia", tipoPlanilla.getTiposPlanillaPK().getCodCia()).setParameter("tiposPlanilla", tipoPlanilla).getSingleResult();
        return t != null ? t.intValue() : 0;
    }

    @PermitAll
    public Integer totalAfectadosRangosSalario(Cias cias, BigDecimal si, BigDecimal sf) {
        Long t = (Long) em.createQuery("SELECT count(e.empleadosPK.codEmp) FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.status = 'A' AND e.salario BETWEEN :si AND :sf ").setParameter("codCia", cias.getCodCia()).setParameter("si", si != null ? si : 0).setParameter("sf", sf != null ? sf : 0).getSingleResult();
        return t != null ? t.intValue() : 0;
    }

    @PermitAll
    public List<Empleados> afectadosRangosSalario(Cias cias, BigDecimal si, BigDecimal sf) {
        List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.status = 'A' AND e.salario BETWEEN :si AND :sf ").setParameter("codCia", cias.getCodCia()).setParameter("si", si != null ? si : 0).setParameter("sf", sf != null ? sf : 0).getResultList();
        return l != null ? l : new ArrayList<Empleados>();
    }

    @PermitAll
    public List<Empleados> afectadosDepartamentos(Departamentos departamento) {
        List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.departamentos = :departamentos AND e.status = 'A'").setParameter("codCia", departamento.getDepartamentosPK().getCodCia()).setParameter("departamentos", departamento).getResultList();
        return l != null ? l : new ArrayList<Empleados>();
    }

    @PermitAll
    public List<Empleados> findByDepartamentos(Departamentos departamento) {
        List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.departamentos = :departamentos AND e.status = 'A'").setParameter("codCia", departamento.getDepartamentosPK().getCodCia()).setParameter("departamentos", departamento).getResultList();
        return l != null ? l : new ArrayList<Empleados>();
    }

    @PermitAll
    public List<Empleados> findByPuestos(Puestos puesto) {
        List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.puestos = :puestos AND e.status = 'A'").setParameter("codCia", puesto.getPuestosPK().getCodCia()).setParameter("puestos", puesto).getResultList();
        return l != null ? l : new ArrayList<Empleados>();
    }

    @PermitAll
    public List<Empleados> afectadosTipoPlanilla(TiposPlanilla tipoPlanilla) {
        List<Empleados> l = em.createQuery("SELECT e FROM Empleados e where e.empleadosPK.codCia = :codCia AND e.tiposPlanilla = :tiposPlanilla AND e.status = 'A'").setParameter("codCia", tipoPlanilla.getTiposPlanillaPK().getCodCia()).setParameter("tiposPlanilla", tipoPlanilla).getResultList();
        return l != null ? l : new ArrayList<Empleados>();
    }

    @PermitAll
    public List<Empleados> findEmpleadosByCias(Cias cias) {
        List<Empleados> l = new ArrayList<Empleados>(0);
        l = em.createQuery("SELECT e FROM Empleados e WHERE e.empleadosPK.codCia = :codCia", Empleados.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return l != null ? l : new ArrayList<Empleados>();
    }

    @PermitAll
    public List<Empleados> findJefesByDepto(Departamentos depto) {
        List<Empleados> l = em.createQuery("SELECT e FROM Empleados e WHERE e.empleadosPK.codCia = :codCia AND e.departamentos = :departamentos AND e.puestos.jefatura = 'SI'", Empleados.class).setParameter("departamentos", depto).setParameter("codCia", depto.getDepartamentosPK().getCodCia()).getResultList();
        return l != null ? l : new ArrayList<Empleados>();
    }
}
