/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.EmpleadosPK;
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
        Query q = em.createNativeQuery("select em.* from empleado em where (cod_cia, em.cod_emp) in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleados.class);
        q.setParameter(1, c.getCampaniaPK().getCodCia());
        q.setParameter(2, c.getCampaniaPK().getPeriodo());
        q.setParameter(3, c.getCampaniaPK().getCodCampania());
        le = (List<Empleados>) q.getResultList();
        return le;
    }

    public List<Empleados> findEmpleadosNoEvaluados(Campania c) {
        List<Empleados> le = null;
        Query q = em.createNativeQuery("select em.* from empleado em where (cod_cia, em.cod_emp) not in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleados.class);
        q.setParameter(1, c.getCampaniaPK().getCodCia());
        q.setParameter(2, c.getCampaniaPK().getPeriodo());
        q.setParameter(3, c.getCampaniaPK().getCodCampania());
        le = (List<Empleados>) q.getResultList();
        return le;
    }

    public Empleados findByUsuario(String usuario) {
        Empleados e = null;
        TypedQuery tq = em.createQuery("SELECT e FROM Empleados e WHERE e.usuario = :usuario", Empleados.class);
        tq.setParameter("usuario", usuario);
        e = (Empleados) tq.getSingleResult();
        return e;
    }

    public List<Empleados> findByJefes() {
        List<Empleados> listaJefes = new ArrayList<Empleados>(0);

        Query pue = em.createQuery("select e from Empleado e, PuestoEmpleado p "
                + "where p.puesto.jefatura = 1 "
                + "and p.empleado.empleadoPK = e.empleadoPK", Empleados.class);
        listaJefes = pue.getResultList();

        return listaJefes;
    }

    public Long max(short empresa) {
        Long max = (Long) em.createQuery("SELECT max(e.empleadoPK.codEmp) FROM Empleado e WHERE e.empleadoPK.codCia = :codCia").setParameter("codCia", empresa).getSingleResult();
        return max != null ? (++max) : 1L;
    }

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
            if (em.createNamedQuery("Empleado.findByUsuario", Empleados.class).setParameter("usuario", user).getResultList().isEmpty()) {
                break;
            }
            user += n;
            n++;
        }
        return user;
    }

    public List<Empleados> findEmpleadosByUsuario(String usuario) {
        List<Empleados> lista = null;
        Query q = em.createNamedQuery("Empleado.findByUsuario", Empleados.class);
        q.setParameter("usuario", usuario);
        lista = q.getResultList();
        return lista != null ? lista : new ArrayList<Empleados>();
    }
}
