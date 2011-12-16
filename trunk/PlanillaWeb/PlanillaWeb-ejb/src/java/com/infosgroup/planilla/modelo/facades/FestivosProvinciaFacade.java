/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.FestivosProvincia;
import com.infosgroup.planilla.modelo.entidades.FestivosProvinciaPK;
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
public class FestivosProvinciaFacade extends AbstractFacade<FestivosProvincia, FestivosProvinciaPK>
{
@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
return em;
}

public FestivosProvinciaFacade()
{
super(FestivosProvincia.class);
}

public List<FestivosProvincia> listarPorAnio(Long anio)
{
TypedQuery<FestivosProvincia> tq = em.createQuery("SELECT f FROM FestivosProvincia f WHERE f.festivosProvinciaPK.anio = :anio ORDER BY f.festivosProvinciaPK.anio, f.festivosProvinciaPK.mes, f.festivosProvinciaPK.dia", FestivosProvincia.class);
tq.setParameter("anio", anio);
return tq.getResultList();
}
}
