/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.PruebaXPuesto;
import com.infosgroup.planilla.modelo.entidades.PruebaXPuestoPK;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.security.PermitAll;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class PruebaXPuestoFacade extends AbstractFacade<PruebaXPuesto, PruebaXPuestoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public PruebaXPuestoFacade() {
        super(PruebaXPuesto.class);
    }

    @PermitAll
    public List<PruebaXPuesto> findPruebaXPuestoByCias(Cias cias) {
        List<PruebaXPuesto> l = new ArrayList<PruebaXPuesto>();
        l = em.createQuery("SELECT p FROM PruebaXPuesto p WHERE p.pruebaXPuestoPK.codCia = :codCia", PruebaXPuesto.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return l != null ? l : new ArrayList<PruebaXPuesto>();
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
