/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.SalarioBase;
import com.infosgroup.planilla.modelo.entidades.SalarioBasePK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class SalarioBaseFacade extends AbstractFacade<SalarioBase, SalarioBasePK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SalarioBaseFacade() {
        super(SalarioBase.class);
    }
    
}
