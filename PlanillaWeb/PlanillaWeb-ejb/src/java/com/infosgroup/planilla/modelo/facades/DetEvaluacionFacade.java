/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.DetEvaluacion;
import com.infosgroup.planilla.modelo.entidades.DetEvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.EvaluacionPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class DetEvaluacionFacade extends AbstractFacade<DetEvaluacion, DetEvaluacionPK>
{
@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
    return em;
}

public DetEvaluacionFacade()
{
    super(DetEvaluacion.class);
}

/*public Integer max(EvaluacionPK evPK)
{
    Query q = em.createNamedQuery("DetEvaluacion.max");
    q.setParameter("codCia", evPK.getCodCia());
    q.setParameter("periodo", evPK.getPeriodo());
    q.setParameter("codCampania", evPK.getCodCampania());
    q.setParameter("empleado", evPK.getEmpleado());
    q.setParameter("tipoEvaluacion", evPK.getTipoEvaluacion());
    Object o = q.getSingleResult();
    Integer i = (Integer) ((o != null) ? o : 0);
    return i ;
}*/
}
