/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.EmpleadoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

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
Query q = em.createNativeQuery("select em.* from empleado em where (cod_cia, em.cod_emp) not in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleado.class);
q.setParameter(1, c.getCampaniaPK().getCodCia());
q.setParameter(2, c.getCampaniaPK().getPeriodo());
q.setParameter(3, c.getCampaniaPK().getCodCampania());
le = (List<Empleado>) q.getResultList();
return le;
}
}
