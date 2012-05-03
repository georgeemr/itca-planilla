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

    public List<AccionPersonal> findAprobacionJefe(Integer jefe, Short cia) {
        TypedQuery<AccionPersonal> acc = em.createQuery("select a from AccionPersonal a where a.accionPersonalPK.codCia = :cia and a.empleado.empleadoPK.codEmp = :jefe and a.status = 'G'", AccionPersonal.class);
        acc.setParameter("cia", cia);
        acc.setParameter("jefe", jefe);
        List<AccionPersonal> listaAccion = (List<AccionPersonal>) acc.getResultList();
        return listaAccion;
    }

    public List<AccionPersonal> findAccionesAprobadas() {
        TypedQuery<AccionPersonal> acc = em.createQuery("select a from AccionPersonal a where a.status = 'B'", AccionPersonal.class);
        List<AccionPersonal> listaAccion = (List<AccionPersonal>) acc.getResultList();
        return listaAccion;
    }

    @PermitAll
    public List<AccionPersonal> findByTipo(long cia, long tipo) {
        TypedQuery<AccionPersonal> acc = em.createQuery("select a from AccionPersonal a where a.tipoAccion.tipoAccionPK.codCia = :cia and a.tipoAccion.tipoAccionPK.codTipoaccion = :tipo", AccionPersonal.class);
        acc.setParameter("cia", cia);
        acc.setParameter("tipo", tipo);
        List<AccionPersonal> listaAccion  = (List<AccionPersonal>) acc.getResultList();
        return listaAccion != null ? listaAccion : new ArrayList<AccionPersonal>(0);
    }

    @PermitAll
    public List<AccionPersonal> findByNoAfecta(long cia) {
        TypedQuery<AccionPersonal> acc = em.createQuery("select a from AccionPersonal a where a.tipoAccion.tipoAccionPK.codCia = :cia and a.tipoAccion.afectaSal = 'N'", AccionPersonal.class);
        acc.setParameter("cia", cia);
        List<AccionPersonal> listaAccion  = acc.getResultList();
        return listaAccion != null ? listaAccion : new ArrayList<AccionPersonal>();
    }

    @PermitAll
    public List<AccionPersonal> findByTipoAccionEmpleadoAnio(Empleados empleado, TipoAccion tipoAccion, Long anio) {
        List<AccionPersonal> tq = em.createNativeQuery("select * from accion_personal where cod_cia = ? and cod_emp = ? and cod_tipoaccion = ? and status = 'A' and trunc(fecha_inicial) >= to_date('01/01/'|| ? , 'dd/MM/yyyy')", AccionPersonal.class).setParameter(1, empleado.getEmpleadosPK().getCodCia()).setParameter(2, empleado.getEmpleadosPK().getCodEmp()).setParameter(3, tipoAccion.getTipoAccionPK().getCodTipoaccion()).setParameter(4, anio).getResultList();
        return tq != null ? tq : new ArrayList<AccionPersonal>();
    }

    @PermitAll
    public List<AccionPersonal> findByVacacionesEmpleadoAnio(Empleados empleado, Long anio) {
        List<AccionPersonal> l = em.createNativeQuery("select * from accion_personal where cod_cia = ? and cod_emp = ? and cod_tipoaccion in (1,2) and status = 'A' and trunc(fecha_inicial) >= to_date('01/01/'|| ? , 'dd/MM/yyyy')", AccionPersonal.class).setParameter(1, empleado.getEmpleadosPK().getCodCia()).setParameter(2, empleado.getEmpleadosPK().getCodEmp()).setParameter(3, anio).getResultList();
        return l != null ? l : new ArrayList<AccionPersonal>();
    }

    @RolesAllowed({"empleados", "rrhh", "jefes"})
    public List<AccionPersonal> findSolicitudesByEmpleado(Empleados empleado) {
        TypedQuery<AccionPersonal> tq = em.createQuery("SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.codCia = :codCia AND a.accionPersonalPK.codEmp = :idEmpleado ORDER BY a.fecha DESC", AccionPersonal.class);
        tq.setParameter("codCia", empleado.getEmpleadosPK().getCodCia());
        tq.setParameter("idEmpleado", empleado.getEmpleadosPK().getCodEmp());
        List<AccionPersonal> l = tq.getResultList();
        return l != null ? l : new ArrayList<AccionPersonal>();
    }

    @RolesAllowed({"rrhh"})
    public List<AccionPersonal> findSolicitudesByRRHH(Empleados empleado) {
        StringBuilder query = new StringBuilder();
        query.append("select * from ( select a.* from accion_personal a, tipo_accion b where ");
        query.append("a.cod_cia = ? and b.cod_cia = a.cod_cia and b.cod_tipoaccion = a.cod_tipoaccion and b.firma_jefe = 'S' and b.firma_rh = 'S' and a.f_aprueba_jefe ");
        query.append("is not null and a.aprobado_jefe = 'A' and status = 'A' and a.f_aprueba_rh is null ");
        query.append("union ");
        query.append("select c.* from accion_personal c, tipo_accion d where c.cod_cia = ? and d.cod_cia = c.cod_cia and d.cod_tipoaccion = c.cod_tipoaccion ");
        query.append("and d.firma_jefe = 'N' and d.firma_rh = 'S' and c.status = 'G') order by fecha desc");
        Query q = em.createNativeQuery(query.toString(), AccionPersonal.class);
        q.setParameter(1, empleado.getEmpleadosPK().getCodCia());
        q.setParameter(2, empleado.getEmpleadosPK().getCodCia());
        List<AccionPersonal> l = (List<AccionPersonal>) q.getResultList();
        return l != null ? l : new ArrayList<AccionPersonal>();
    }

    @RolesAllowed({"jefes"})
    public List<AccionPersonal> findSolicitudesByJefe(Empleados empleado) {
        Query q = em.createNativeQuery("select a.* from accion_personal a, tipo_accion b where a.cod_cia = ? and  a.cod_emp in ( select cod_emp from empleados where cod_cia = a.cod_cia and jefe = ? ) and a.f_aprueba_jefe is null and a.aprobado_jefe != 'S' and b.cod_cia = a.cod_cia and b.cod_tipoaccion = a.cod_tipoaccion and b.firma_jefe = 'S' order by a.fecha desc", AccionPersonal.class);
        q.setParameter(1, empleado.getEmpleadosPK().getCodCia());
        q.setParameter(2, empleado.getEmpleadosPK().getCodEmp());
        List<AccionPersonal> l = q.getResultList();
        return l != null ? l : new ArrayList<AccionPersonal>();
    }
}
