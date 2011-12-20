/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Contrato;
import com.infosgroup.planilla.modelo.entidades.ContratoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class ContratoFacade extends AbstractFacade<Contrato, ContratoPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratoFacade() {
        super(Contrato.class);
    }
    
    public Long getMax( Candidato c ){
        Long max = (Long) em.createQuery("SELECT max(c.contratoPK.codigo) FROM Contrato c WHERE c.candidato1 = :candidato").setParameter("candidato", c).getSingleResult();
        return max != null ? ( ++max ): 1L;
    }
}
