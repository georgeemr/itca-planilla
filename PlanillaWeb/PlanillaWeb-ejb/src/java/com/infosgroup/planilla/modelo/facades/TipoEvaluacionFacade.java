/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacionPK;
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
public class TipoEvaluacionFacade extends AbstractFacade<TipoEvaluacion, TipoEvaluacionPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEvaluacionFacade() {
        super(TipoEvaluacion.class);
    }
    
    public List<TipoEvaluacion> findByCompania(Cias c)
    {
        TypedQuery<TipoEvaluacion> tq = getEntityManager().createQuery("SELECT t FROM TipoEvaluacion t WHERE t.tipoEvaluacionPK.codCia = :cia", TipoEvaluacion.class);
        tq.setParameter("cia", c.getCodCia());
        return  tq.getResultList();
    }
    
}
