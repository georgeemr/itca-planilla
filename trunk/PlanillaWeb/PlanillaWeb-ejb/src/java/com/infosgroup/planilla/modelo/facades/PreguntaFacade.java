/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.entidades.PreguntaPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**

 @author root
 */
@Stateless
public class PreguntaFacade extends AbstractFacade<Pregunta, PreguntaPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
    return em;
}

public PreguntaFacade()
{
    super(Pregunta.class);
}

public List<Pregunta> findPreguntasByFactor(Factor factor)
{
TypedQuery<Pregunta> tq = getEntityManager().createQuery("SELECT p FROM Pregunta p WHERE p.preguntaPK.codCia = :codCia AND p.preguntaPK.codFactor = :codFactor", Pregunta.class);
tq.setParameter("codCia", factor.getFactorPK().getCodCia());
tq.setParameter("codFactor", factor.getFactorPK().getCodFactor());
return tq.getResultList();
}
}
