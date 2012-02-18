/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.AreasStaff;
import com.infosgroup.planilla.modelo.entidades.AreasStaffPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import java.util.ArrayList;
import javax.annotation.security.PermitAll;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class AreasStaffFacade extends AbstractFacade<AreasStaff, AreasStaffPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public AreasStaffFacade() {
        super(AreasStaff.class);
    }

    @PermitAll
    public List<AreasStaff> findAreasByCias(Cias cia) {
        List<AreasStaff> l = new ArrayList<AreasStaff>(0);
        Query acc = em.createQuery("SELECT a FROM AreasStaff a WHERE a.areasStaffPK.codCia = :codCia", AreasStaff.class);
        acc.setParameter("codCia", cia.getCodCia());
        l = (List<AreasStaff>) acc.getResultList();
        return l != null ? l : new ArrayList<AreasStaff>();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
