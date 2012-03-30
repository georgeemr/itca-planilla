/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoXCargo;
import com.infosgroup.planilla.modelo.entidades.CandidatoXCargoPK;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**

 @author root
 */
@Stateless
@LocalBean
public class CandidatoXCargoFacade extends AbstractFacade<CandidatoXCargo, CandidatoXCargoPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

public CandidatoXCargoFacade()
{
    super(CandidatoXCargo.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}
//@PermitAll
//public Integer max(Candidato c)
//{
//    Query q = getEntityManager().createQuery("SELECT max(r.referenciaPK.codReferencia) FROM Referencia r WHERE r.candidato = :candidato");
//    q.setParameter("candidato", c);
//    Integer max = (Integer) q.getSingleResult();
//    return (max == null) ? 1 : ++max;
//}

@PermitAll
public List<CandidatoXCargo> findByCandidato(Candidato c)
{
TypedQuery<CandidatoXCargo> tq = getEntityManager().createQuery("SELECT c FROM CandidatoXCargo c WHERE c.candidato = :candidato", CandidatoXCargo.class);
tq.setParameter("candidato", c);
return tq.getResultList();
}
        
}
