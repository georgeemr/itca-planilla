/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import com.infosgroup.planilla.modelo.entidades.TipoPruebaXCandidato;
import com.infosgroup.planilla.modelo.entidades.TipoPruebaXCandidatoPK;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**

 @author root
 */
@Stateless
@LocalBean
public class TipoPruebaXCandidatoFacade extends AbstractFacade<TipoPruebaXCandidato, TipoPruebaXCandidatoPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

public TipoPruebaXCandidatoFacade()
{
    super(TipoPruebaXCandidato.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Short max(Candidato c)
{
    Query q = getEntityManager().createQuery("SELECT max(t.tipoPruebaXCandidatoPK.codTipoPrueba) FROM TipoPruebaXCandidato t WHERE t.tipoPruebaXCandidatoPK.codCia = :codCia AND t.tipoPruebaXCandidatoPK.codCandidato = :codCandidato");
    q.setParameter("codCia", c.getCandidatoPK().getCodCia());
    q.setParameter("codCandidato", c.getCandidatoPK().getCodCandidato());
    Short max = (Short) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

public List<TipoPruebaXCandidato> findByCandidato(Candidato c)
{
    TypedQuery<TipoPruebaXCandidato> tq = getEntityManager().createQuery("SELECT t FROM TipoPruebaXCandidato t WHERE t.candidato = :candidato", TipoPruebaXCandidato.class);
    tq.setParameter("candidato", c);
    return tq.getResultList();
}
}
