/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.CampaniaPK;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
*
* @author root
*/
@Stateless
public class CampaniaFacade extends AbstractFacade<Campania, CampaniaPK>
{
@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
return em;
}

public CampaniaFacade()
{
super(Campania.class);
}

public List<Campania> findByEmpleadoEvaluador(Empleado empleado)
{
//TypedQuery<Campania> tq = em.createQuery("SELECT c FROM Campania c JOIN Evaluacion e JOIN Empleado em", Campania.class);
Query q = em.createNativeQuery("select distinct c.* from campania c where (cod_cia, periodo, cod_campania) in (select distinct eva.cod_cia, eva.periodo, eva.campania from evaluador_evaluaciones eva where cod_cia = ? and evaluador = ?)", Campania.class);
q.setParameter(1, empleado.getEmpleadoPK().getCodCia());
q.setParameter(2, empleado.getEmpleadoPK().getCodEmp());
return (List<Campania>) q.getResultList();
}
}
