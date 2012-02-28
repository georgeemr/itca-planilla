/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Idioma;
import com.infosgroup.planilla.modelo.entidades.IdiomaPK;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
*
* @author root
*/
@Stateless
public class IdiomaFacade extends AbstractFacade<Idioma, IdiomaPK>
{
@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
return em;
}

public IdiomaFacade()
{
super(Idioma.class);
}

@PermitAll
public List<Idioma> findAllByCia(Cias cia)
{
TypedQuery<Idioma> tq = getEntityManager().createNamedQuery("Idioma.findByCodCia", Idioma.class);
tq.setParameter("codCia", cia.getCodCia());
return tq.getResultList();
}

}
