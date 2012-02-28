/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Locaciones;
import com.infosgroup.planilla.modelo.entidades.LocacionesPK;
import java.util.ArrayList;
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
public class LocacionesFacade extends AbstractFacade<Locaciones, LocacionesPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

public LocacionesFacade()
{
    super(Locaciones.class);
}

@PermitAll
public List<Locaciones> findLocacionesByCias(Cias cia)
{
    List<Locaciones> l = new ArrayList<Locaciones>(0);
    TypedQuery<Locaciones> acc = em.createQuery("SELECT l FROM Locaciones l WHERE l.locacionesPK.codCia = :codCia", Locaciones.class);
    acc.setParameter("codCia", cia.getCodCia());
    l = (List<Locaciones>) acc.getResultList();
    return l != null ? l : new ArrayList<Locaciones>();
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}
}
