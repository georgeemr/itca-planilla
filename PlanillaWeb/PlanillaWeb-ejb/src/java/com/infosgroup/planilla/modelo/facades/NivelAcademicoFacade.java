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
public class NivelAcademicoFacade extends AbstractFacade<NivelAcademico, Long> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelAcademicoFacade() {
        super(NivelAcademico.class);
    }
    
        public Long max() {
        Long max = null;
        Query q = getEntityManager().createNamedQuery("NivelAcademico.max");
        max = (Long) q.getSingleResult();
        return (max == null) ? 0L : max;
    }
    
}
