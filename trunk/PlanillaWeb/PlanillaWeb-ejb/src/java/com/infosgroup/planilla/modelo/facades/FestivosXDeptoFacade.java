/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.FestivosXDepto;
import com.infosgroup.planilla.modelo.entidades.FestivosXDeptoPK;
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
public class FestivosXDeptoFacade extends AbstractFacade<FestivosXDepto, FestivosXDeptoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FestivosXDeptoFacade() {
        super(FestivosXDepto.class);
    }

    public List<FestivosXDepto> listarPorAnio(Long anio) {
        TypedQuery<FestivosXDepto> tq = em.createQuery("SELECT f FROM FestivosXDepto f WHERE f.festivosXDeptoPK.anio = :anio ORDER BY f.festivosXDeptoPK.anio, f.festivosXDeptoPK.mes, f.festivosXDeptoPK.dia", FestivosXDepto.class);
        tq.setParameter("anio", anio);
        return tq.getResultList();
    }
}
