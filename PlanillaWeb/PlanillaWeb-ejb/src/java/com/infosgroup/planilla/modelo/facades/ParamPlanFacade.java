/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.ParamPlan;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class ParamPlanFacade extends AbstractFacade<ParamPlan, Short> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public ParamPlanFacade() {
        super(ParamPlan.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
