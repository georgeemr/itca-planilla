/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Evaluado;
import com.infosgroup.planilla.modelo.entidades.EvaluadoPK;
import com.infosgroup.planilla.modelo.entidades.Evaluador;
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
public class EvaluadoFacade extends AbstractFacade<Evaluado, EvaluadoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public EvaluadoFacade() {
        super(Evaluado.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @PermitAll
    public void eliminarEvaluados(Evaluador evaluador){
        if ( evaluador == null )return;
        if ( evaluador.getEvaluadoList() == null )return;
        for ( Evaluado e:evaluador.getEvaluadoList() ){
            remove(e);
        }
    }
}
