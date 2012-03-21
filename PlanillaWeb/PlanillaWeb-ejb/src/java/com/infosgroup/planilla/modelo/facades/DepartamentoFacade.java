/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.DepartamentosPK;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

    @PermitAll
    public List<Departamentos> findDepartamentosByPlanilla(ProgramacionPla pla) {
        List<Departamentos> l = null;
            Query q = em.createNativeQuery("SELECT D.* FROM DEPARTAMENTOS D "
                    + "WHERE (D.COD_CIA, D.COD_DEPTO) "
                    + "IN (SELECT DISTINCT P.COD_CIA, P.COD_DEPTO FROM PLANILLA P "
                    + "WHERE P.COD_CIA = ? AND P.NUM_PLANILLA = ? AND P.ANIO = ? AND P.MES = ? AND P.COD_TIPOPLA = ?) ORDER BY D.NOM_DEPTO", Departamentos.class);
            q.setParameter(1, pla.getProgramacionPlaPK().getCodCia());
            q.setParameter(2, pla.getNumPlanilla());
            q.setParameter(3, pla.getAnio());
            q.setParameter(4, pla.getMes());
            q.setParameter(5, pla.getProgramacionPlaPK().getCodTipopla());
            l = (List<Departamentos>)q.getResultList();
        return l != null ? l : new ArrayList<Departamentos>();
    }
}
