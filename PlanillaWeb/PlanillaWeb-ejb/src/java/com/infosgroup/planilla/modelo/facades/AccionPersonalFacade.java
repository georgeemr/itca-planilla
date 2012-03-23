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
        TypedQuery<AccionPersonal> acc = em.createQuery("select a from AccionPersonal a where a.accionPersonalPK.codCia = :cia and a.empleado.empleadoPK.codEmp = :jefe and a.status = 'G'", AccionPersonal.class);
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
        TypedQuery<AccionPersonal> acc = em.createQuery("select a from AccionPersonal a where a.status = 'B'", AccionPersonal.class);
        listaAccion = (List<AccionPersonal>) acc.getResultList();

        return listaAccion;
    }

    /**
     * Listado de acciones de personal segun tipo de acción
     * @param cia
     * @param tipo
     * @return 
     */
    @PermitAll
    public List<AccionPersonal> findByTipo(long cia, long tipo) {
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        TypedQuery<AccionPersonal> acc = em.createQuery("select a from AccionPersonal a where a.tipoAccion.tipoAccionPK.codCia = :cia and a.tipoAccion.tipoAccionPK.codTipoaccion = :tipo", AccionPersonal.class);
        acc.setParameter("cia", cia);
        acc.setParameter("tipo", tipo);
        listaAccion = (List<AccionPersonal>) acc.getResultList();
        return listaAccion != null ? listaAccion : new ArrayList<AccionPersonal>(0);
    }
    
    @PermitAll
    public List<AccionPersonal> findByNoAfecta(long cia) {
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        TypedQuery<AccionPersonal> acc = em.createQuery("select a from AccionPersonal a where a.tipoAccion.tipoAccionPK.codCia = :cia and a.tipoAccion.afectaSal = 'N'", AccionPersonal.class);
        acc.setParameter("cia", cia);
        listaAccion = acc.getResultList();
        return listaAccion != null ? listaAccion : new ArrayList<AccionPersonal>();
    }

    @PermitAll
    public List<AccionPersonal> findByTipoAccionEmpleadoAnio(Empleados empleado, TipoAccion tipoAccion, Long anio) {
         List<AccionPersonal> tq = em.createNativeQuery("select * from accion_personal where cod_cia = ? and cod_emp = ? and cod_tipoaccion = ? and status = 'A' and trunc(fecha_inicial) >= to_date('01/01/'|| ? , 'dd/MM/yyyy')", AccionPersonal.class)
        .setParameter(1, empleado.getEmpleadosPK().getCodCia())
        .setParameter(2, empleado.getEmpleadosPK().getCodEmp())
        .setParameter(3, tipoAccion.getTipoAccionPK().getCodTipoaccion())
        .setParameter(4, anio)
        .getResultList();
        return tq != null ?tq:new ArrayList<AccionPersonal>();
    }

    @PermitAll
    public List<AccionPersonal> findByVacacionesEmpleadoAnio(Empleados empleado, Long anio) {
        List<AccionPersonal> l = em.createNativeQuery("select * from accion_personal where cod_cia = ? and cod_emp = ? and cod_tipoaccion in (1,2) and status = 'A' and trunc(fecha_inicial) >= to_date('01/01/'|| ? , 'dd/MM/yyyy')", AccionPersonal.class)
        .setParameter(1, empleado.getEmpleadosPK().getCodCia())
        .setParameter(2, empleado.getEmpleadosPK().getCodEmp())
        .setParameter(3, anio)
        .getResultList();
        return l != null ? l : new ArrayList<AccionPersonal>();
    }

    @RolesAllowed({"empleados", "rrhh", "jefes"})
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
        StringBuilder query = new StringBuilder();
        query.append("select * from accion_personal where ( cod_cia , cod_tipoaccion ) in ");
        query.append("( select cod_cia, cod_tipoaccion from planilla.tipo_accion a where a.cod_cia = ? and firma_jefe = 'S' and firma_rh = 'S' ) ");
        query.append("and f_aprueba_jefe is not null and aprobado_jefe = 'A' and status = 'A' ");
        query.append("union ");
        query.append("select * from accion_personal where ( cod_cia , cod_tipoaccion ) in ");
        query.append("( select cod_cia, cod_tipoaccion from planilla.tipo_accion a where a.cod_cia = ? and firma_jefe = 'N' and firma_rh = 'S' ) and status = 'G'");
        Query q = em.createNativeQuery(query.toString(), AccionPersonal.class);
        q.setParameter(1, empleado.getEmpleadosPK().getCodCia());
        q.setParameter(2, empleado.getEmpleadosPK().getCodCia());
        l = (List<AccionPersonal>) q.getResultList();
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
