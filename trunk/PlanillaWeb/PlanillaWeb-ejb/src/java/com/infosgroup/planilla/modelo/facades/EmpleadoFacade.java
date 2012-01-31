/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.google.common.base.Strings;
import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.EmpleadoPK;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleado;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado, EmpleadoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    public List<Empleado> findEmpleadosEvaluados(Campania c) {
        List<Empleado> le = null;
        Query q = em.createNativeQuery("select em.* from empleado em where (cod_cia, em.cod_emp) in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleado.class);
        q.setParameter(1, c.getCampaniaPK().getCodCia());
        q.setParameter(2, c.getCampaniaPK().getPeriodo());
        q.setParameter(3, c.getCampaniaPK().getCodCampania());
        le = (List<Empleado>) q.getResultList();
        return le;
    }

    public List<Empleado> findEmpleadosNoEvaluados(Campania c) {
        List<Empleado> le = null;
        Query q = em.createNativeQuery("select em.* from empleado em where (cod_cia, em.cod_emp) not in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleado.class);
        q.setParameter(1, c.getCampaniaPK().getCodCia());
        q.setParameter(2, c.getCampaniaPK().getPeriodo());
        q.setParameter(3, c.getCampaniaPK().getCodCampania());
        le = (List<Empleado>) q.getResultList();
        return le;
    }

    public Empleado findByUsuario(String usuario) {
        Empleado e = null;
        TypedQuery tq = em.createNamedQuery("Empleado.findByUsuario", Empleado.class);
        tq.setParameter("usuario", usuario);
        e = (Empleado) tq.getSingleResult();
        return e;
    }

    public List<Empleado> findByJefes() {
        List<Empleado> listaJefes = new ArrayList<Empleado>(0);

        Query pue = em.createQuery("select e from Empleado e, PuestoEmpleado p "
                + "where p.puesto.jefatura = 1 "
                + "and p.empleado.empleadoPK = e.empleadoPK", Empleado.class);
        listaJefes = pue.getResultList();

        return listaJefes;
    }

    public Long getMax(Long empresa) {
        Long max = (Long) em.createQuery("SELECT max(e.empleadoPK.codEmp) FROM Empleado e WHERE e.empleadoPK.codCia = :codCia").setParameter("codCia", empresa).getSingleResult();
        return max != null ? (++max) : 1L;
    }

    public Empleado toEmpleado(Candidato c) {
        Empleado e = new Empleado();
        EmpleadoPK pk = new EmpleadoPK(c.getCandidatoPK().getCodCia(), getMax(c.getCandidatoPK().getCodCia()));
        e.setEmpleadoPK(pk);
        if (c != null) {
            e.setNombres(c.getNombre());
            e.setApellidos(c.getApellido());
            e.setApCasada(c.getApCasada());
            e.setFechaNac(c.getFechaNacimiento());
            e.setObservacion(c.getObservacion());
            e.setCandidato(c);
        }
        return e;
    }

    public String generaUsuario(Candidato c) {
        String nombre = "", apellido = "", user = "";
        int n = 0;
        nombre = c.getNombre() != null ? c.getNombre().split(" ")[0] : "";
        apellido = c.getApellido() != null ? c.getApellido().split(" ")[0] : "";
        user = nombre + apellido;
        for (;;) {
            if (em.createNamedQuery("Empleado.findByUsuario", Empleado.class).setParameter("usuario", user).getResultList().isEmpty()) {
                break;
            }
            user += n;
            n++;
        }
        return user;
    }

    public List<Empleado> findEmpleadosByUsuario(String usuario) {
        List<Empleado> lista = null;
        Query q = em.createNamedQuery("Empleado.findByUsuario", Empleado.class);
        q.setParameter("usuario", usuario);
        lista = q.getResultList();
        return lista != null ? lista : new ArrayList<Empleado>();
    }

    @PermitAll
    public PuestoEmpleado getUltimoPuesto(Empleado empleado) {
        PuestoEmpleado puestoEmpleado =  new PuestoEmpleado();
        Query q = em.createNativeQuery("select * from PLANILLA.PUESTO_EMPLEADO where id_compania = ? and id_sucursal = ? and id_empleado = ? and rownum = 1 order by fecha_asignacion desc", PuestoEmpleado.class);
        q.setParameter(1, empleado.getEmpleadoPK().getCodCia());
        q.setParameter(2, empleado.getSucursal().getSucursalPK().getIdSucursal());
        q.setParameter(3, empleado.getEmpleadoPK().getCodEmp());
        puestoEmpleado = (PuestoEmpleado)q.getSingleResult();        
        return puestoEmpleado;
    }

}
