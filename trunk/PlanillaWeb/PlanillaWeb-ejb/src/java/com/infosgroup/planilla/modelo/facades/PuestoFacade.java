/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Puesto;
import com.infosgroup.planilla.modelo.entidades.PuestoPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class PuestoFacade extends AbstractFacade<Puesto, PuestoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Puesto> findPuestoByEmpresa(Long empresa) {
        List<Puesto> puestos = new ArrayList<Puesto>();
        puestos.addAll(getEntityManager().createNamedQuery("Puesto.findByCodCia", Puesto.class).setParameter("codCia", empresa).getResultList());
        return puestos;
    }

    public PuestoFacade() {
        super(Puesto.class);
    }
}
