/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.DepartamentosPK;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<Departamentos, DepartamentosPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamentos.class);
    }

    @PermitAll
    public List<Departamentos> findDepartamentosByCias(Cias cias) {
        List<Departamentos> l = new ArrayList<Departamentos>();
        l = em.createQuery("SELECT d FROM Departamentos d WHERE d.departamentosPK.codCia = :codCia ORDER BY d.nomDepto ASC", Departamentos.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return l != null ? l : new ArrayList<Departamentos>();
    }
    
}
