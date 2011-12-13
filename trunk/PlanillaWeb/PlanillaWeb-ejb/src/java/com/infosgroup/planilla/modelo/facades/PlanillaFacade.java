/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PlanillaPK;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class PlanillaFacade extends AbstractFacade<Planilla, PlanillaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanillaFacade() {
        super(Planilla.class);
    }
    
    public List<Planilla> findByTipoPLanilla(TipoPlanilla tipo){
        List<Planilla> listPla = new ArrayList<Planilla>(0);
        
        Query q = em.createQuery("select p from planilla p" 
        +"where p.tipoPlanilla = :tipoPla", Planilla.class);
        q.setParameter("tipoPla", tipo);
        listPla = q.getResultList();
        
        return listPla;
    }
    
}