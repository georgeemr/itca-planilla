/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.TipoRespuesta;
import com.infosgroup.planilla.modelo.entidades.TipoRespuestaPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class TipoRespuestaFacade extends AbstractFacade<TipoRespuesta, TipoRespuestaPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoRespuestaFacade() {
        super(TipoRespuesta.class);
    }
    
}
