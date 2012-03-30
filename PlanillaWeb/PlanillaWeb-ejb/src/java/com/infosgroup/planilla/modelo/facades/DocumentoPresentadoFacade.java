/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.DocumentoPresentado;
import com.infosgroup.planilla.modelo.entidades.DocumentoPresentadoPK;
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
public class DocumentoPresentadoFacade extends AbstractFacade<DocumentoPresentado, DocumentoPresentadoPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

public DocumentoPresentadoFacade()
{
    super(DocumentoPresentado.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public Integer max(Candidato c)
{
    Query q = getEntityManager().createQuery("SELECT max(d.documentoPresentadoPK.codDocumentoPres) FROM DocumentoPresentado d WHERE d.documentoPresentadoPK.codCia = :codCia AND d.documentoPresentadoPK.codCandidato = :codCandidato");
    q.setParameter("codCia", c.getCandidatoPK().getCodCia());
    q.setParameter("codCandidato", c.getCandidatoPK().getCodCandidato());
    Integer max = (Integer) q.getSingleResult();
    return (max == null) ? 1 : ++max;
}

@PermitAll
public List<DocumentoPresentado> findByCandidato(Candidato candidato)
{
    TypedQuery<DocumentoPresentado> tq = getEntityManager().createQuery("SELECT d FROM DocumentoPresentado d WHERE d.candidato = :candidato", DocumentoPresentado.class);
    tq.setParameter("candidato", candidato);
    return tq.getResultList();
}
}
