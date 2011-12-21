/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.entidades.TipoPlanillaPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class TipoPlanillaFacade extends AbstractFacade<TipoPlanilla, TipoPlanillaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPlanillaFacade() {
        super(TipoPlanilla.class);
    }

    @PermitAll
    public List<TipoPlanilla> findByCompania(Compania compania) {
        List<TipoPlanilla> lista = null;
        Query q =em.createNamedQuery("TipoPlanilla.findByIdCompania", TipoPlanilla.class).setParameter("idCompania", compania.getIdCompania());
        lista = q.getResultList();
        return lista != null ? lista : new ArrayList<TipoPlanilla>(0);
    }
}
