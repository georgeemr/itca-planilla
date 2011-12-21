/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.entidades.SucursalPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class SucursalFacade extends AbstractFacade<Sucursal, SucursalPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalFacade() {
        super(Sucursal.class);
    }

    @PermitAll
    public List<Sucursal> findByCompania(Compania compania) {
        List<Sucursal> lista = null;
        Query q = getEntityManager().createNamedQuery("Sucursal.findByIdCompania", Sucursal.class);
        q.setParameter("idCompania", compania.getIdCompania());
        lista = q.getResultList();
        return lista != null ? lista : new ArrayList<Sucursal>(0);
    }
}
