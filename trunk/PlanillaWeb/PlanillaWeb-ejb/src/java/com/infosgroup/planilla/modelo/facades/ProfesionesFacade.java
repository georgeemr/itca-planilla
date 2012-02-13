/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Profesion;
import com.infosgroup.planilla.modelo.entidades.ProfesionPK;
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
public class ProfesionesFacade extends AbstractFacade<Profesion, ProfesionPK> {

    @PersistenceContext(unitName="PlanillaWeb-ejbPU")
    private EntityManager em;
    
    public ProfesionesFacade(){
        super(Profesion.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
