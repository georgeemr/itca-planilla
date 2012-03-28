/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.PreEvaluacion;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacionPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PreEvaluacionFacade extends AbstractFacade<PreEvaluacion, PreEvaluacionPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public PreEvaluacionFacade() {
        super(PreEvaluacion.class);
    }


}
