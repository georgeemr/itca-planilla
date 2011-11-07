/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.PlantillaPK;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author root
 */
@Stateless
public class PlantillaFacade extends AbstractFacade<Plantilla, PlantillaPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PlantillaFacade() {
        super(Plantilla.class);
    }
    
}
