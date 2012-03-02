/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Deptos;
import com.infosgroup.planilla.modelo.entidades.DeptosPK;
import com.infosgroup.planilla.modelo.entidades.Paises;
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
public class DeptosFacade extends AbstractFacade<Deptos, DeptosPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public DeptosFacade()
{
    super(Deptos.class);
}

@PermitAll
public List<Deptos> findByPais(Paises pais)
{
    //java.util.List<Deptos> l = new ArrayList<Deptos>();
    //l = em.createQuery("SELECT d FROM Deptos d WHERE d.deptosPK.codPais = :codPais", Deptos.class).getResultList();
    //return l != null ? l : new ArrayList<Deptos>();
    TypedQuery<Deptos> tq = getEntityManager().createNamedQuery("Deptos.findByCodPais", Deptos.class);
    tq.setParameter("codPais", pais.getCodPais());
    return tq.getResultList();
}
}
