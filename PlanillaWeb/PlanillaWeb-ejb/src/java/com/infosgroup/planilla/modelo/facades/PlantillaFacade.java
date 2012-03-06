/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.PlantillaPK;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.persistence.TypedQuery;

/**

 @author root
 */
@Stateless
public class PlantillaFacade extends AbstractFacade<Plantilla, PlantillaPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
    return em;
}

public PlantillaFacade()
{
    super(Plantilla.class);
}

@PermitAll
public List<Plantilla> findPlantillasByTipoEvaluacion(TipoEvaluacion tipoEvaluacion)
{
    if (tipoEvaluacion != null)
        {
        TypedQuery<Plantilla> tq = getEntityManager().createQuery("SELECT p FROM Plantilla p WHERE p.plantillaPK.codCia = :codCia AND p.plantillaPK.codTipoEvaluacion = :codTipoEvaluacion", Plantilla.class);
        tq.setParameter("codCia", tipoEvaluacion.getTipoEvaluacionPK().getCodCia());
        tq.setParameter("codTipoEvaluacion", tipoEvaluacion.getTipoEvaluacionPK().getCodTipoEvaluacion());
        return tq.getResultList();
        }
    else
        return new ArrayList<Plantilla>();
}
}
