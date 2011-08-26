/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.NivelAcademico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class NivelAcademicoFacade extends AbstractFacade<NivelAcademico, Integer> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelAcademicoFacade() {
        super(NivelAcademico.class);
    }
    
        public Integer max() {
        Integer max = null;
        Query q = getEntityManager().createNamedQuery("NivelAcademico.max");
        max = (Integer) q.getSingleResult();
        return (max == null) ? 0 : max;
    }
    
}
