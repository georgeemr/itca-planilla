/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.FactorPK;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Parameter;
import javax.persistence.Query;

/**
*
* @author root
*/
@Stateless
public class FactorFacade extends AbstractFacade<Factor, FactorPK>
{
@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
return em;
}

public FactorFacade()
{
super(Factor.class);
}

public List<Factor> findByPlantilla(Plantilla plantilla)
{
Query consulta = em.createNativeQuery("select f.* from factor f where (cod_cia, cod_factor) in (select distinct dp.cod_cia, dp.factor from det_plantilla dp, plantilla p where dp.cod_cia = p.cod_cia and dp.cod_tipo_evaluacion = p.cod_tipo_evaluacion and dp.cod_plantilla = p.cod_plantilla and p.cod_cia = ?1 and p.cod_tipo_evaluacion = ?2 and p.cod_plantilla = ?3)", Factor.class);
consulta.setParameter(1, plantilla.getPlantillaPK().getCodCia());
consulta.setParameter(2, plantilla.getPlantillaPK().getCodTipoEvaluacion());
consulta.setParameter(3, plantilla.getPlantillaPK().getCodPlantilla());
return (List<Factor>) consulta.getResultList();
}
}
