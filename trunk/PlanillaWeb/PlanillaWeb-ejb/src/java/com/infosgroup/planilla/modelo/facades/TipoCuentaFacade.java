/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.TipoCuenta;
import com.infosgroup.planilla.modelo.entidades.TipoCuentaPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class TipoCuentaFacade extends AbstractFacade<TipoCuenta, TipoCuentaPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCuentaFacade() {
        super(TipoCuenta.class);
    }
    
}
