/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.FuncionXPuesto;
import com.infosgroup.planilla.modelo.entidades.FuncionXPuestoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class FuncionXPuestoFacade extends AbstractFacade<FuncionXPuesto, FuncionXPuestoPK> {

    @PersistenceContext(unitName="PlanillaWeb-ejbPU")
    private EntityManager em;
    
    public FuncionXPuestoFacade(){
        super(FuncionXPuesto.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
