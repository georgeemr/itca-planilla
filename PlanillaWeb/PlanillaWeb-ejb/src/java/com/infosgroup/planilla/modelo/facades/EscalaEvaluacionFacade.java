/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.EscalaEvaluacion;
import com.infosgroup.planilla.modelo.entidades.EscalaEvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
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
public class EscalaEvaluacionFacade extends AbstractFacade<EscalaEvaluacion, EscalaEvaluacionPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public EscalaEvaluacionFacade() {
        super(EscalaEvaluacion.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @PermitAll
    public String getEscalaByEvaluacion( Evaluacion ev, Integer valor ){
        List<EscalaEvaluacion> e = new ArrayList<EscalaEvaluacion>();
        e = em.createNativeQuery("select * from escala_evaluacion where cod_cia = ? and tipo_evaluacion = ? and " + valor +" between rango_inicial and rango_final ", EscalaEvaluacion.class)
                .setParameter(1, ev.getEvaluacionPK().getCodCia()).setParameter(2, ev.getTipoEvaluacion1().getTipoEvaluacionPK().getCodTipoEvaluacion()).getResultList();
        if (e!= null && e.size() > 0){
            return e.get(0).getCalificacion();
        }
        return "Nota en un rango indefinido.";
    }
    
}
