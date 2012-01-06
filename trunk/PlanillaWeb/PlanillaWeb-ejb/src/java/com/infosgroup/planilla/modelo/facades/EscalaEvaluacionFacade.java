/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.EscalaEvaluacion;
import com.infosgroup.planilla.modelo.entidades.EscalaEvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EscalaEvaluacionFacade extends AbstractFacade<EscalaEvaluacion, EscalaEvaluacionPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public EscalaEvaluacionFacade() {
        super(EscalaEvaluacion.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @PermitAll
    public String getEscalaByEvaluacion( Evaluacion evaluacion ){
        EscalaEvaluacion e = new EscalaEvaluacion();
        
        e = em.createQuery("SELECT e FROM EscalaEvaluacion e WHERE e.escalaEvaluacionPK.codCia = :codCia", EscalaEvaluacion.class).setParameter("", e).getSingleResult();
        
        return "";
    }
    
}
