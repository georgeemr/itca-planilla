/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.EmergenciaXCandidato;
import com.infosgroup.planilla.modelo.entidades.EmergenciaXCandidatoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**

 @author Soporte
 */
@Stateless
public class EmergenciaXCandidatoFacade extends AbstractFacade<EmergenciaXCandidato, EmergenciaXCandidatoPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public EmergenciaXCandidatoFacade()
{
    super(EmergenciaXCandidato.class);
}

public Integer max(Candidato c)
{
    TypedQuery<Integer> tq = em.createQuery("SELECT max(e.emergenciaXCandidatoPK.codEmergencia) FROM EmergenciaXCandidato e WHERE e.emergenciaXCandidatoPK.codCia = :codCia AND e.emergenciaXCandidatoPK.codCandidato = :codCandidato", Integer.class);
    tq.setParameter("codCia", c.getCandidatoPK().getCodCia());
    tq.setParameter("codCandidato", c.getCandidatoPK().getCodCandidato());
    Integer max = tq.getSingleResult();
    return (max != null) ? (++max) : 1;
}
}
