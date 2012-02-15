/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.AccionPersonalPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class AccionPersonalFacade extends AbstractFacade<AccionPersonal, AccionPersonalPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccionPersonalFacade() {
        super(AccionPersonal.class);
    }

    public Integer max(Short codCia, Integer empleado) {
        Integer max = (Integer) getEntityManager().createQuery("select max(p.accionPersonalPK.correlativo) from AccionPersonal p where p.accionPersonalPK.codCia = :codCia AND p.accionPersonalPK.codEmp = :codEmp").setParameter("codCia", codCia).setParameter("codEmp", empleado).getSingleResult();
        return (max == null) ? 1 : ++max;
    }

    /**
     * Listado de solicitudes de accion de personal por jefe
     * @param jefe
     * @param cia
     * @return 
     */
    public List<AccionPersonal> findAprobacionJefe(Integer jefe, Short cia) {
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        Query acc = em.createQuery("select a from AccionPersonal a where a.accionPersonalPK.codCia = :cia "
                + "and a.empleado.empleadoPK.codEmp = :jefe and a.status = 'G'", AccionPersonal.class);
        acc.setParameter("cia", cia);
        acc.setParameter("jefe", jefe);
        listaAccion = (List<AccionPersonal>) acc.getResultList();
        return listaAccion;
    }

    /**
     * Listado a acccion de personal aprobadas
     * @return 
     */
    public List<AccionPersonal> findAccionesAprobadas() {
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);

        Query acc = em.createQuery("select a from AccionPersonal a "
                + "where a.status = 'B'", AccionPersonal.class);
        listaAccion = (List<AccionPersonal>) acc.getResultList();

        return listaAccion;
    }

    /**
     * Listado de acciones de personal segun tipo de acción
     * @param cia
     * @param tipo
     * @return 
     */
    public List<AccionPersonal> findByTipo(long cia, long tipo) {
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        Query acc = em.createQuery("select a from AccionPersonal a where a.tipoAccion.tipoAccionPK.codCia = :cia and a.tipoAccion.tipoAccionPK.codTipoaccion = :tipo", AccionPersonal.class);
        acc.setParameter("cia", cia);
        acc.setParameter("tipo", tipo);
        listaAccion = (List<AccionPersonal>) acc.getResultList();
        return listaAccion != null ? listaAccion : new ArrayList<AccionPersonal>(0);
    }

    public List<AccionPersonal> findByNoAfecta(long cia) {
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        Query acc = em.createQuery("select a from AccionPersonal a where a.tipoAccion.tipoAccionPK.codCia = :cia and a.tipoAccion.afectaSal = 'N'", AccionPersonal.class);
        acc.setParameter("cia", cia);
        listaAccion = (List<AccionPersonal>) acc.getResultList();
        return listaAccion != null ? listaAccion : new ArrayList<AccionPersonal>();
    }

    @PermitAll
    public List<AccionPersonal> findByTipoAccionEmpleadoAnio(Empleados empleado, TipoAccion tipoAccion, Long anio) {
        TypedQuery<AccionPersonal> tq = em.createQuery("SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.codCia = :codCia AND a.accionPersonalPK.anio = :anio AND a.accionPersonalPK.idEmpleado = :idEmpleado AND a.accionPersonalPK.codTipoaccion = :codTipoaccion AND a.status = :status", AccionPersonal.class);
        tq.setParameter("codCia", 1);
        tq.setParameter("anio", anio);
        tq.setParameter("idEmpleado", empleado.getEmpleadosPK().getCodEmp());
        tq.setParameter("codTipoaccion", tipoAccion.getTipoAccionPK().getCodTipoaccion());
        tq.setParameter("status", "B");
        return tq.getResultList();
    }

    @PermitAll
    public List<AccionPersonal> findByVacacionesEmpleadoAnio(Empleados empleado, Long anio) {
        List<AccionPersonal> l = new ArrayList<AccionPersonal>();
        TypedQuery<AccionPersonal> tq = em.createQuery("SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.codCia = :codCia AND a.accionPersonalPK.anio = :anio AND a.accionPersonalPK.idEmpleado = :idEmpleado AND (a.accionPersonalPK.codTipoaccion = 1 OR a.accionPersonalPK.codTipoaccion = 2) AND a.status = :status", AccionPersonal.class);
        tq.setParameter("codCia", 1);
        tq.setParameter("anio", anio);
        tq.setParameter("idEmpleado", empleado.getEmpleadosPK().getCodEmp());
        tq.setParameter("status", "B");
        l = tq.getResultList();
        return l != null ? l : new ArrayList<AccionPersonal>();
    }

    @RolesAllowed({"empleados"})
    public List<AccionPersonal> findSolicitudesByEmpleado(Empleados empleado) {
        List<AccionPersonal> l = new ArrayList<AccionPersonal>();
        TypedQuery<AccionPersonal> tq = em.createQuery("SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.codCia = :codCia AND a.accionPersonalPK.codEmp = :idEmpleado", AccionPersonal.class);
        tq.setParameter("codCia", empleado.getEmpleadosPK().getCodCia());
        tq.setParameter("idEmpleado", empleado.getEmpleadosPK().getCodEmp());
        l = tq.getResultList();
        return l != null ? l : new ArrayList<AccionPersonal>();
    }

    @RolesAllowed({"rrhh"})
    public List<AccionPersonal> findSolicitudesByRRHH(Empleados empleado) {
        List<AccionPersonal> l = new ArrayList<AccionPersonal>();
        TypedQuery<AccionPersonal> tq = em.createQuery("SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.codCia = :codCia AND a.status = 'G'", AccionPersonal.class);
        tq.setParameter("codCia", empleado.getEmpleadosPK().getCodCia());
        l = tq.getResultList();
        return l != null ? l : new ArrayList<AccionPersonal>();
    }

    @RolesAllowed({"jefes"})
    public List<AccionPersonal> findSolicitudesByJefe(Empleados empleado) {
        List<AccionPersonal> l = new ArrayList<AccionPersonal>();
        Query q = em.createNativeQuery("select * from accion_personal where cod_cia = ? and cod_emp in ( "
                + " select cod_emp from empleados where cod_cia = ? and cod_emp = ? union select cod_emp from empleados where cod_cia = ? and jefe = ? ) and aprobado_jefe is null",
                AccionPersonal.class);
        q.setParameter(1, empleado.getEmpleadosPK().getCodCia());
        q.setParameter(2, empleado.getEmpleadosPK().getCodCia());
        q.setParameter(3, empleado.getEmpleadosPK().getCodEmp());
        q.setParameter(4, empleado.getEmpleadosPK().getCodCia());
        q.setParameter(5, empleado.getEmpleadosPK().getCodEmp());
        l = q.getResultList();
        return l != null ? l : new ArrayList<AccionPersonal>();
    }
}
