/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
import com.infosgroup.planilla.modelo.entidades.DetPlanillaPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */

@Stateless
public class DetPlanillaFacade extends AbstractFacade<DetPlanilla, DetPlanillaPK> {
   
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetPlanillaFacade() {
        super(DetPlanilla.class);
    }
    
}
