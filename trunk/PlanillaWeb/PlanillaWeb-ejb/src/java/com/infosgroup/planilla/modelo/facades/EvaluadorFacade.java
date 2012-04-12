/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Evaluador;
import com.infosgroup.planilla.modelo.entidades.EvaluadorPK;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
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
public class EvaluadorFacade extends AbstractFacade<Evaluador, EvaluadorPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;
    
    public EvaluadorFacade(){
        super(Evaluador.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @PermitAll
    public List<Evaluador> findByPreEvaluacion(PreEvaluacion preEvaluacion){
        List<Evaluador> l = em.createQuery("SELECT p FROM Evaluador p WHERE p.preEvaluacion = :preEvaluacion", Evaluador.class).setParameter("preEvaluacion", preEvaluacion).getResultList();
        return l!=null?l:new ArrayList<Evaluador>();
    }
}
