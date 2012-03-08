/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Agencias;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistenciaPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
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
public class ResumenAsistenciaFacade extends AbstractFacade<ResumenAsistencia, ResumenAsistenciaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResumenAsistenciaFacade() {
        super(ResumenAsistencia.class);
    }

    @PermitAll
    public List<ResumenAsistencia> findAsistenciasByPlanillaAgencia(Planilla planilla, Agencias sucursal) {
        TypedQuery<ResumenAsistencia> tq = em.createQuery("SELECT r FROM ResumenAsistencia r WHERE r.planilla = :planilla and r.codSucursal = :sucursal", ResumenAsistencia.class);
        tq.setParameter("planilla", planilla);
        tq.setParameter("sucursal", sucursal);
        return tq.getResultList();
    }

    public List<ResumenAsistencia> findResumenAsistenciaByTipoPlanilla(short codCia, short anio, short mes, short numPlanilla, short codTipopla) {
        List<ResumenAsistencia> r;
        Query q = em.createQuery("SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.codCia = :codCia AND r.resumenAsistenciaPK.anio = :anio AND r.resumenAsistenciaPK.mes = :mes AND r.resumenAsistenciaPK.numPlanilla = :numPlanilla AND r.resumenAsistenciaPK.codTipopla = :codTipopla", ResumenAsistencia.class);
        q.setParameter("codCia", codCia);
        q.setParameter("anio", anio);
        q.setParameter("mes", mes);
        q.setParameter("numPlanilla", numPlanilla);
        q.setParameter("codTipopla", codTipopla);
        r = q.getResultList();
        return r != null ? r : new ArrayList<ResumenAsistencia>();
    }
}
