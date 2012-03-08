/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.DeducPresta;
import com.infosgroup.planilla.modelo.entidades.DeducPrestaPK;
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
public class DeduccionesPrestacionesFacade extends AbstractFacade<DeducPresta, DeducPrestaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeduccionesPrestacionesFacade() {
        super(DeducPresta.class);
    }

    @PermitAll
    public List<DeducPresta> findByCias(Cias cias) {
        List<DeducPresta> l = em.createQuery("SELECT d FROM DeducPresta d WHERE d.deducPrestaPK.codCia = :codCia ORDER BY d.desDp", DeducPresta.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return l != null ? l : new ArrayList<DeducPresta>();
    }
}
