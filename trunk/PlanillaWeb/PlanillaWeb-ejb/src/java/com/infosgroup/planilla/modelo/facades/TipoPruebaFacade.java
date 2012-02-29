/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.TipoPrueba;
import com.infosgroup.planilla.modelo.entidades.TipoPruebaPK;
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
public class TipoPruebaFacade extends AbstractFacade<TipoPrueba, TipoPruebaPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

public TipoPruebaFacade()
{
    super(TipoPrueba.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

@PermitAll
public List<TipoPrueba> findAllByCia(Cias cia)
{
    TypedQuery<TipoPrueba> tq = getEntityManager().createNamedQuery("TipoPrueba.findByCodCia", TipoPrueba.class);
    tq.setParameter("codCia", cia.getCodCia());
    return tq.getResultList();
}
}
