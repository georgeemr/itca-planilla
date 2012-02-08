/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuestoPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
}
