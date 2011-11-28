/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.EmpleadoPK;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
*
* @author root
*/
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado, EmpleadoPK>
{
@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
return em;
}

public EmpleadoFacade()
{
super(Empleado.class);
}

public List<Empleado> findEmpleadosNoEvaluados(Campania c)
{
List<Empleado> le = null ;
//TypedQuery<Empleado> tq = em.createQuery("SELECT em FROM Empleado em, Evaluacion ev, Campania c WHERE ev NOT MEMBER OF c.evaluacionList AND ev.campania = :campania", Empleado.class);
TypedQuery<Empleado> tq = em.createQuery("SELECT em FROM Empleado em WHERE NOT EXISTS(SELECT ev.empleado1 FROM Evaluacion ev WHERE ev.campania = :campania)", Empleado.class);
tq.setParameter("campania", c);
le = tq.getResultList();
return le;
}
}
