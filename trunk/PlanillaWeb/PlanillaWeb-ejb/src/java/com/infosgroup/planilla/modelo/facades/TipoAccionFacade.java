/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TipoAccionPK;
import java.util.ArrayList;
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
public class TipoAccionFacade extends AbstractFacade<TipoAccion, TipoAccionPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAccionFacade() {
        super(TipoAccion.class);
    }

    public List<TipoAccion> findByAfecta(Cias cias, String afecta) {
        List<TipoAccion> listaTipo = new ArrayList<TipoAccion>(0);        
        listaTipo = em.createQuery("SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia AND t.afectaSal = :afectaSal ", TipoAccion.class).setParameter("codCia", cias.getCodCia()).setParameter("afectaSal", afecta).getResultList();
        return listaTipo != null ? listaTipo : new ArrayList<TipoAccion>();
    }

    public List<TipoAccion> listarTipoAccionActivas(Cias cias) {
        List<TipoAccion> listaTipo = new ArrayList<TipoAccion>(0);
        listaTipo = em.createQuery("SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia AND t.estado = 'A'", TipoAccion.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return listaTipo != null ? listaTipo : new ArrayList<TipoAccion>();
    }

    public List<TipoAccion> listarTipoAccionByCias(Cias cias) {
        List<TipoAccion> listaTipo = new ArrayList<TipoAccion>(0);
        listaTipo = em.createQuery("SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia", TipoAccion.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return listaTipo != null ? listaTipo : new ArrayList<TipoAccion>();
    }
}
