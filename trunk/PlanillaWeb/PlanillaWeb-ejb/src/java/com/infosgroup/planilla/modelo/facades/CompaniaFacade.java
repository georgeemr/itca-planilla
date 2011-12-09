/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Compania;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class CompaniaFacade extends AbstractFacade<Compania, Long> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CompaniaFacade() {
        super(Compania.class);
    }

    public Long max() {
        Long max = null;
        Query q = getEntityManager().createNamedQuery("Compania.max");
        max = (Long) q.getSingleResult();
        return (max == null) ? 0L : max;
    }
}
