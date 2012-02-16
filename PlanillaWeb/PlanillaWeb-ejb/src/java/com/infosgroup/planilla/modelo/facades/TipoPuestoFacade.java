/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
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

    public List<TipoPuesto> findTipoPuestoByEmpresa(Cias cias) {
        List<TipoPuesto> lstConcurso = new ArrayList<TipoPuesto>();
        lstConcurso = getEntityManager().createQuery("SELECT t FROM TipoPuesto t WHERE t.tipoPuestoPK.codCia = :codCia", TipoPuesto.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return lstConcurso != null ? lstConcurso : new ArrayList<TipoPuesto>();
    }

    public TipoPuestoFacade() {
        super(TipoPuesto.class);
    }
}
