/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacion;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacionPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PreEvaluacionFacade extends AbstractFacade<PreEvaluacion, PreEvaluacionPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public PreEvaluacionFacade() {
        super(PreEvaluacion.class);
    }

    @PermitAll
    public List<PreEvaluacion> findPreevaluacionByCias(Cias cias){
        List<PreEvaluacion> l = em.createQuery("SELECT p FROM PreEvaluacion p WHERE p.campania.campaniaPK.codCia = :codCia AND p.campania.estado = 'G'", PreEvaluacion.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return l!=null?l:new ArrayList<PreEvaluacion>();
    }
}
