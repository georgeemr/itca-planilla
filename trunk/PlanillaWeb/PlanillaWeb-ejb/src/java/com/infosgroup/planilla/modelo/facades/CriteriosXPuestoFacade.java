/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuestoPK;
import com.infosgroup.planilla.modelo.entidades.PuestosPK;
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
 * @author Gabriel Bran
 */
@Stateless
@LocalBean
public class CriteriosXPuestoFacade extends AbstractFacade<CriteriosXPuesto, CriteriosXPuestoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public CriteriosXPuestoFacade() {
        super(CriteriosXPuesto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PermitAll
    public List<CriteriosXPuesto> getListaCriteriosByEmpresa(Cias empresa) {
        List<CriteriosXPuesto> l = new ArrayList<CriteriosXPuesto>();
        Query q = em.createQuery("SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.codCia = :codCia", CriteriosXPuesto.class).setParameter("codCia", empresa.getCodCia());
        l = q.getResultList();
        return l != null ? l : new ArrayList<CriteriosXPuesto>();
    }

    @PermitAll
    public List<CriteriosXPuesto> getListaCriteriosByPuestos(PuestosPK puesto) {
        List<CriteriosXPuesto> l = new ArrayList<CriteriosXPuesto>();
        Query q = em.createQuery("SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.codCia = :codCia AND c.criteriosXPuestoPK.puesto = :puesto", CriteriosXPuesto.class).setParameter("codCia", puesto.getCodCia()).setParameter("puesto", puesto.getCodPuesto());
        l = q.getResultList();
        return l != null ? l : new ArrayList<CriteriosXPuesto>();
    }

    @PermitAll
    public CriteriosXPuesto getWithId(CriteriosXPuesto cxp) {
        CriteriosXPuestoPK pk = new CriteriosXPuestoPK();
        pk.setCodCia(cxp.getPuestos().getPuestosPK().getCodCia());
        pk.setCriterio(cxp.getCriterio1().getCriterioPK().getCodigo());
        pk.setTipoCriterio(cxp.getCriterio1().getCriterioPK().getTipo());
        pk.setPuesto(cxp.getPuestos().getPuestosPK().getCodPuesto());
        pk.setCorrelativo(max(pk));
        cxp.setCriteriosXPuestoPK(pk);
        return cxp;
    }

    public Long max(CriteriosXPuestoPK pk) {
        Long max = (Long) getEntityManager().createQuery("select max(c.criteriosXPuestoPK.correlativo) from CriteriosXPuesto c where c.criteriosXPuestoPK.codCia = :codCia AND c.criteriosXPuestoPK.puesto = :puesto").setParameter("codCia", pk.getCodCia()).setParameter("puesto", pk.getPuesto()).getSingleResult();
        return (max == null) ? 1 : ++max;
    }
}
