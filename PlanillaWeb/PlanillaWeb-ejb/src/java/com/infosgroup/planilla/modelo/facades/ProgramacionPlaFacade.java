/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPlaPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class ProgramacionPlaFacade extends AbstractFacade<ProgramacionPla, ProgramacionPlaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public ProgramacionPlaFacade() {
        super(ProgramacionPla.class);
    }

    public List<ProgramacionPla> getProgramacionPlaByTipo(Short empresa, Short tipoPlanilla) {
        List<ProgramacionPla> l = new ArrayList<ProgramacionPla>();
        TypedQuery<ProgramacionPla> q = em.createQuery("SELECT p FROM ProgramacionPla p WHERE p.programacionPlaPK.codCia = :codCia AND p.programacionPlaPK.codTipopla = :codTipopla AND p.status != 'C'", ProgramacionPla.class);
        q.setParameter("codCia", empresa);
        q.setParameter("codTipopla", tipoPlanilla);
        l=q.getResultList();
        return l != null ? l: new ArrayList<ProgramacionPla>();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<ProgramacionPla> getProgramacionPlaByCia(Cias cia) {
        List<ProgramacionPla> l = new ArrayList<ProgramacionPla>();
        TypedQuery<ProgramacionPla> q = em.createQuery("SELECT p FROM ProgramacionPla p WHERE p.programacionPlaPK.codCia = :codCia", ProgramacionPla.class);
        q.setParameter("codCia", cia.getCodCia());
        l=q.getResultList();
        return l != null ? l: new ArrayList<ProgramacionPla>();
    }
}
