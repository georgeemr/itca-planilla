/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.DeducPresta;
import com.infosgroup.planilla.modelo.entidades.DeducPrestaPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DeduccionesPrestacionesFacade extends AbstractFacade<DeducPresta, DeducPrestaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeduccionesPrestacionesFacade() {
        super(DeducPresta.class);
    }
}
