/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class CiasFacade extends AbstractFacade<Cias, Short> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiasFacade() {
        super(Cias.class);
    }

    public short max() {
        Short max = (Short) getEntityManager().createQuery("SELECT max(c.codCia) FROM Cias c").getSingleResult();
        return (max == null) ? 1 : ++max;
    }
}
