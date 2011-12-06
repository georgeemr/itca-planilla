/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.TipoPuesto;
import com.infosgroup.planilla.modelo.entidades.TipoPuestoPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class TipoPuestoFacade extends AbstractFacade<TipoPuesto, TipoPuestoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<TipoPuesto> findTipoPuestoByEmpresa(Integer empresa) {
        List<TipoPuesto> lstConcurso = new ArrayList<TipoPuesto>();
        lstConcurso.addAll(getEntityManager().createNamedQuery("TipoPuesto.findByCodCia", TipoPuesto.class).setParameter("codCia", empresa).getResultList());
        return lstConcurso;
    }

    public TipoPuestoFacade() {
        super(TipoPuesto.class);
    }
}
