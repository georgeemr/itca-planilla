/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.EvaluacionPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
*
* @author root
*/
@Stateless
public class EvaluacionFacade extends AbstractFacade<Evaluacion, EvaluacionPK>
{
@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
return em;
}

public EvaluacionFacade()
{
super(Evaluacion.class);
}

public List<Evaluacion> findEvaluacionesAbiertasByCampania(Campania campania)
{
TypedQuery<Evaluacion> tq = em.createQuery("SELECT e FROM Evaluacion e WHERE e.campania = :campania and e.finalizada = 0", Evaluacion.class);
tq.setParameter("campania", campania);
return tq.getResultList();
}

public Integer findEvaluacionesByCampania(Campania campania)
{
TypedQuery<Evaluacion> tq = em.createQuery("SELECT e FROM Evaluacion e WHERE e.campania = :campania", Evaluacion.class);
tq.setParameter("campania", campania);
return (tq.getResultList() != null) ? tq.getResultList().size() : 0;
}
}
