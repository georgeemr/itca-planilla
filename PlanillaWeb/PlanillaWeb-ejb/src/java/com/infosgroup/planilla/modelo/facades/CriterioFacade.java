/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Criterio;
import com.infosgroup.planilla.modelo.entidades.CriterioPK;
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
public class CriterioFacade extends AbstractFacade<Criterio, CriterioPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public CriterioFacade() {
        super(Criterio.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Criterio> getCriteriosByString(List<String> s) {
        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        for (String z : s) {
            try {
                listaCriterios.add(find(new CriterioPK(new Short(z.split(":")[0]), new Integer(z.split(":")[1]), new Integer(z.split(":")[2]))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaCriterios;
    }
    
    @PermitAll
    public List<Criterio> findCriteriosByCias(Cias cias){
        List<Criterio> l = new ArrayList<Criterio>();
        l = em.createQuery("SELECT c FROM Criterio c WHERE c.criterioPK.codCia = :codCia", Criterio.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return l!= null? l : new ArrayList<Criterio>();
    }
    
}
