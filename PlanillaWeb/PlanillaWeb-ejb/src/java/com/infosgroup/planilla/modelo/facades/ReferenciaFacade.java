/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Referencia;
import com.infosgroup.planilla.modelo.entidades.ReferenciaPK;
import java.util.List;
import javax.annotation.security.PermitAll;
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
public class ReferenciaFacade extends AbstractFacade<Referencia, ReferenciaPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

public ReferenciaFacade()
{
    super(Referencia.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

@PermitAll
public Integer max(Candidato c)
{
    Query q = getEntityManager().createQuery("SELECT max(r.referenciaPK.codReferencia) FROM Referencia r WHERE r.candidato = :candidato");
    q.setParameter("candidato", c);
    Integer max = (Integer) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

@PermitAll
public List<Referencia> findByCandidato(Candidato candidato)
{
    String jpql = "SELECT r FROM Referencia r WHERE r.candidato = :candidato";
    TypedQuery<Referencia> tq = getEntityManager().createQuery(jpql, Referencia.class);
    tq.setParameter("candidato", candidato);
    return tq.getResultList();
}
}
