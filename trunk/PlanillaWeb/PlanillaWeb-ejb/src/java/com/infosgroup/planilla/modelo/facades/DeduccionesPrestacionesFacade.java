/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.DeduccionesPrestaciones;
import com.infosgroup.planilla.modelo.entidades.DeduccionesPrestacionesPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DeduccionesPrestacionesFacade extends AbstractFacade<DeduccionesPrestaciones, DeduccionesPrestacionesPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeduccionesPrestacionesFacade() {
        super(DeduccionesPrestaciones.class);
    }
    
}