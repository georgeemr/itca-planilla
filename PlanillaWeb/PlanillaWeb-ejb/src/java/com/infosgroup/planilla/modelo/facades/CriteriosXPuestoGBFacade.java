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
public class CriteriosXPuestoGBFacade extends AbstractFacade<CriteriosXPuestoGb, CriteriosXPuestoGbPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public CriteriosXPuestoGBFacade() {
        super(CriteriosXPuestoGb.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PermitAll
    public List<CriteriosXPuestoGb> getListaCriteriosByEmpresa(Cias empresa) {
        List<CriteriosXPuestoGb> l = em.createNamedQuery("CriteriosXPuestoGb.findByCodCia").setParameter("codCia", empresa.getCodCia()).getResultList();
        return l != null ? l : new ArrayList<CriteriosXPuestoGb>();
    }

    @PermitAll
    public List<CriteriosXPuestoGb> getListaCriteriosByPuestos(PuestosPK puesto) {
        List<CriteriosXPuestoGb> l = em.createNamedQuery("CriteriosXPuestoGb.findByPuesto").setParameter("codCia", puesto.getCodCia()).setParameter("codPuesto", puesto.getCodPuesto()).getResultList();
        return l != null ? l : new ArrayList<CriteriosXPuestoGb>();
    }

}
