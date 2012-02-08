/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TipoAccionPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class TipoAccionFacade extends AbstractFacade<TipoAccion, TipoAccionPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAccionFacade() {
        super(TipoAccion.class);
    }
    
    public List<TipoAccion> findByAfecta(String afecta){
        List<TipoAccion> listaTipo = new ArrayList<TipoAccion>(0);
        
        Query tip = em.createQuery("select a from TipoAccion a where a.afectaSal = :af ", TipoAccion.class);
        tip.setParameter("af", afecta);
        listaTipo = (List<TipoAccion>)tip.getResultList();
        
        if(afecta.matches("S")){
            TipoAccion noAfecta = new TipoAccion();
            TipoAccionPK pk = new TipoAccionPK();
//            pk.setCodCia(1);
//            pk.setCodTipoaccion(0);
            noAfecta.setTipoAccionPK(pk);
            noAfecta.setNomTipoaccion("NO AFECTA PLANILLA");
            listaTipo.add(noAfecta);
        }
        
        return listaTipo;
    }
    
}
