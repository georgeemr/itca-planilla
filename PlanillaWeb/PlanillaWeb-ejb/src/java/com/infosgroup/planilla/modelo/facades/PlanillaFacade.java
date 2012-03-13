/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PlanillaPK;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import java.util.ArrayList;
import java.util.List;
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
public class PlanillaFacade extends AbstractFacade<Planilla, PlanillaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanillaFacade() {
        super(Planilla.class);
    }

    public List<Planilla> findByTipoPLanilla(TiposPlanilla tipo) {
        List<Planilla> listPla = new ArrayList<Planilla>(0);
        TypedQuery<Planilla> q = em.createQuery("select p from planilla p where p.tipoPlanilla = :tipoPla", Planilla.class);
        q.setParameter("tipoPla", tipo);
        listPla = q.getResultList();
        return listPla != null ? listPla : new ArrayList<Planilla>();
    }

    public List<Planilla> findPlanillaByCias(Cias cia) {
        List<Planilla> listPla = new ArrayList<Planilla>(0);
        TypedQuery<Planilla> q = em.createQuery("SELECT p FROM Planilla p WHERE p.planillaPK.codCia = :codCia", Planilla.class).setParameter("codCia", cia.getCodCia());
        listPla = q.getResultList();
        return listPla != null ? listPla : new ArrayList<Planilla>();
    }

    public List<Planilla> findPlanillaByTipoPlanilla(Cias cia, Short codTipopla) {
        List<Planilla> listPla = new ArrayList<Planilla>(0);
        TypedQuery<Planilla> q = em.createQuery("SELECT p FROM Planilla p WHERE p.planillaPK.codCia = :codCia AND p.codTipopla = :codTipopla", Planilla.class).setParameter("codCia", cia.getCodCia()).setParameter("codTipopla", codTipopla);
        listPla = q.getResultList();
        return listPla != null ? listPla : new ArrayList<Planilla>();
    }

    public Long max() {
        Long max = null;
        Query q = getEntityManager().createNamedQuery("Planilla.max");
        max = (Long) q.getSingleResult();
        return (max == null) ? 0L : max;
    }
    
    public List<Planilla> findPlanillaByUnidad(Cias cia) {
        List<Planilla> listPla = new ArrayList<Planilla>(0);
        TypedQuery<Planilla> q = em.createQuery("SELECT p FROM Planilla p WHERE p.planillaPK.codCia = :codCia AND (p.planillaPK.codCia, p.planillaPK.anio, p.planillaPK.mes, p.planillaPK.numPlanilla, p.planillaPK.codEmp,  p.planillaPK.codTipopla)"+
                                                " IN (SELECT m.movDpPK.codCia, m.movDpPK.anio, m.movDpPK.mes, m.movDpPK.numPlanilla, m.resumenAsistencia.resumenAsistenciaPK.codEmp, m.resumenAsistencia.resumenAsistenciaPK.codTipopla FROM MovDp m)", Planilla.class).setParameter("codCia", cia.getCodCia());
        listPla = q.getResultList();
        return listPla != null ? listPla : new ArrayList<Planilla>();
    }
}
