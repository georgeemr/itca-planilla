/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.EstadoCivil;
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
public class EstadoCivilFacade extends AbstractFacade<EstadoCivil, Long> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public EstadoCivilFacade() {
        super(EstadoCivil.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
