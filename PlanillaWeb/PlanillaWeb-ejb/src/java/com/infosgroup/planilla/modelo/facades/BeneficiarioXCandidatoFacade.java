/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.BeneficiarioXCandidato;
import com.infosgroup.planilla.modelo.entidades.BeneficiarioXCandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Candidato;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
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
public class BeneficiarioXCandidatoFacade extends AbstractFacade<BeneficiarioXCandidato, BeneficiarioXCandidatoPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

public BeneficiarioXCandidatoFacade()
{
    super(BeneficiarioXCandidato.class);
}

@PermitAll
public List<BeneficiarioXCandidato> findByCandidato(Candidato c)
{
    List<BeneficiarioXCandidato> l = new ArrayList<BeneficiarioXCandidato>();
    l = em.createQuery("SELECT b FROM BeneficiarioXCandidato b WHERE b.beneficiarioXCandidatoPK.codCia = :codCia AND b.beneficiarioXCandidatoPK.codCandidato = :codCandidato", BeneficiarioXCandidato.class).setParameter("codCia", c.getCandidatoPK().getCodCia()).setParameter("codCandidato", c.getCandidatoPK().getCodCandidato()).getResultList();
    return l != null ? l : new ArrayList<BeneficiarioXCandidato>();
}

@PermitAll
public Integer max(Candidato c)
{
    Query q = em.createQuery("SELECT max(b.beneficiarioXCandidatoPK.codBeneficiario) FROM BeneficiarioXCandidato b WHERE b.beneficiarioXCandidatoPK.codCia = :codCia AND b.beneficiarioXCandidatoPK.codCandidato = :codCandidato");
    q.setParameter("codCia", c.getCandidatoPK().getCodCia());
    q.setParameter("codCandidato", c.getCandidatoPK().getCodCandidato());
    Integer i = (Integer) q.getSingleResult();
    return i != null ? ++i : 1;
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}
}
