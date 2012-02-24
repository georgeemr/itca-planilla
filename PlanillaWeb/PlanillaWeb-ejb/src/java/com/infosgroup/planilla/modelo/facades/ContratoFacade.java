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

    public Integer max(Candidato c) {
        Integer max = (Integer) em.createQuery("SELECT max(c.contratoPK.codContrato) FROM Contrato c WHERE c.candidato = :candidato").setParameter("candidato", c).getSingleResult();
        return max != null ? (++max) : 1;
    }
}
