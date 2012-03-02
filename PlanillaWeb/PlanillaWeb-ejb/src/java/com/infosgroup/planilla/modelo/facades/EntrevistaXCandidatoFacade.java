/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.EntrevistaXCandidato;
import com.infosgroup.planilla.modelo.entidades.EntrevistaXCandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Puestos;
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
public class EntrevistaXCandidatoFacade extends AbstractFacade<EntrevistaXCandidato, EntrevistaXCandidatoPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

public EntrevistaXCandidatoFacade()
{
    super(EntrevistaXCandidato.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Short max(Puestos p, Candidato c)
{
    Query q = getEntityManager().createQuery("SELECT max(e.entrevistaXCandidatoPK.codEntrevista) FROM EntrevistaXCandidato e WHERE e.entrevistaXCandidatoPK.codCia = :codCia AND e.entrevistaXCandidatoPK.codCandidato = :codCandidato AND e.entrevistaXCandidatoPK.codPuesto = :codPuesto");
    q.setParameter("codCia", c.getCandidatoPK().getCodCia());
    q.setParameter("codCandidato", c.getCandidatoPK().getCodCandidato());
    q.setParameter("codPuesto", p.getPuestosPK().getCodPuesto());
    Short max = (Short) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}
}
