/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.NivelesXCandidato;
import com.infosgroup.planilla.modelo.entidades.NivelesXCandidatoPK;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**

 @author root
 */
@Stateless
@LocalBean
public class NivelesXCandidatoFacade extends AbstractFacade<NivelesXCandidato, NivelesXCandidatoPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public NivelesXCandidatoFacade()
{
    super(NivelesXCandidato.class);
}

public Short max(Candidato c)
{
    Query q = getEntityManager().createQuery("SELECT max(n.nivelesXCandidatoPK.codNivel) FROM NivelesXCandidato n WHERE n.nivelesXCandidatoPK.codCia = :codCia AND n.nivelesXCandidatoPK.codCandidato = :codCandidato");
    q.setParameter("codCia", c.getCandidatoPK().getCodCia());
    q.setParameter("codCandidato", c.getCandidatoPK().getCodCandidato());
    Short max = (Short) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}
}
