/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gabriel Bran
 */
@Stateless
@LocalBean
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

    @PermitAll
    public List<Criterio> findByCias(Short cia) {
        List<Criterio> l = getEntityManager().createNamedQuery("Criterio.findByCodCia").setParameter("codCia", cia).getResultList();
        return l != null ? l : new ArrayList<Criterio>();
    }

    @PermitAll
    public List<Criterio> getListaCriteriosByPuestos(PuestosPK puesto) {
        List<Criterio> l = em.createNativeQuery(
                "select a.* from criterio a, criterios_x_puesto b "
                + " where a.cod_cia = ? and b.cod_cia = a.cod_cia and b.criterio = a.codigo and b.cod_puesto = ?", Criterio.class)
                .setParameter(1, puesto.getCodCia())
                .setParameter(2, puesto.getCodPuesto())
                .getResultList();
        return l != null ? l : new ArrayList<Criterio>();
    }
    
}
