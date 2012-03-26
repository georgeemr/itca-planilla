/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PlanillaPK;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
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
public class PlanillaFacade extends AbstractFacade<Planilla, PlanillaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanillaFacade() {
        super(Planilla.class);
    }

    @PermitAll
    public List<Planilla> findByTipoPLanilla(TiposPlanilla tipo) {
        List<Planilla> listPla = new ArrayList<Planilla>(0);
        TypedQuery<Planilla> q = em.createQuery("select p from planilla p where p.tipoPlanilla = :tipoPla", Planilla.class);
        q.setParameter("tipoPla", tipo);
        listPla = q.getResultList();
        return listPla != null ? listPla : new ArrayList<Planilla>();
    }

    @PermitAll
    public List<Planilla> findPlanillaByCias(Cias cia) {
        List<Planilla> listPla = new ArrayList<Planilla>(0);
        TypedQuery<Planilla> q = em.createQuery("SELECT p FROM Planilla p WHERE p.planillaPK.codCia = :codCia", Planilla.class).setParameter("codCia", cia.getCodCia());
        listPla = q.getResultList();
        return listPla != null ? listPla : new ArrayList<Planilla>();
    }

    @PermitAll
    public List<Planilla> findPlanillaByTipoPlanilla(Cias cia, Short codTipopla) {
        List<Planilla> listPla = new ArrayList<Planilla>(0);
        TypedQuery<Planilla> q = em.createQuery("SELECT p FROM Planilla p WHERE p.planillaPK.codCia = :codCia AND p.codTipopla = :codTipopla", Planilla.class).setParameter("codCia", cia.getCodCia()).setParameter("codTipopla", codTipopla);
        listPla = q.getResultList();
        return listPla != null ? listPla : new ArrayList<Planilla>();
    }

    @PermitAll
    public Long max() {
        Long max = null;
        Query q = getEntityManager().createNamedQuery("Planilla.max");
        max = (Long) q.getSingleResult();
        return (max == null) ? 0L : max;
    }

    @PermitAll
    public List<Planilla> findPlanillaByUnidad(ProgramacionPla proPla) {
        Short cia = proPla.getProgramacionPlaPK().getCodCia();
        Short anio = proPla.getAnio();
        Short mes = proPla.getMes();
        Short num = proPla.getNumPlanilla();
        Short tipo = proPla.getProgramacionPlaPK().getCodTipopla();
        List<Planilla> l = new ArrayList<Planilla>();
        TypedQuery<Planilla> q = em.createQuery("SELECT p FROM Planilla p "
                + "WHERE p.planillaPK.codCia = :codCia "
                + "AND p.planillaPK.anio = :anio "
                + "AND p.planillaPK.mes = :mes "
                + "AND p.planillaPK.numPlanilla = :numPlanilla "
                + "AND p.planillaPK.codTipopla = :codTipopla", Planilla.class);
        q.setParameter("codCia", cia);
        q.setParameter("anio", anio);
        q.setParameter("mes", mes);
        q.setParameter("numPlanilla", num);
        q.setParameter("codTipopla", tipo);
        l = q.getResultList();
        return l != null ? l : new ArrayList<Planilla>();
    }

    @PermitAll
    public List<Planilla> findPlanillaByProAndDep(ProgramacionPla proPla, Short depto) {
        Short cia = proPla.getProgramacionPlaPK().getCodCia();
        Short anio = proPla.getAnio();
        Short mes = proPla.getMes();
        Short num = proPla.getNumPlanilla();
        Short tipo = proPla.getProgramacionPlaPK().getCodTipopla();
        List<Planilla> l = new ArrayList<Planilla>();
        TypedQuery<Planilla> q = em.createQuery("SELECT p FROM Planilla p "
                + "WHERE p.planillaPK.codCia = :codCia "
                + "AND p.planillaPK.anio = :anio "
                + "AND p.planillaPK.mes = :mes "
                + "AND p.planillaPK.numPlanilla = :numPlanilla "
                + "AND p.planillaPK.codTipopla = :codTipopla "
                + "AND p.codDepto = :codDepto  ", Planilla.class);
        q.setParameter("codCia", cia);
        q.setParameter("anio", anio);
        q.setParameter("mes", mes);
        q.setParameter("numPlanilla", num);
        q.setParameter("codTipopla", tipo);
        q.setParameter("codDepto", depto);
        l = q.getResultList();
        return l != null ? l : new ArrayList<Planilla>();
    }

    @PermitAll
    public List<Planilla> findPlanillaByProgramacion(ProgramacionPla programacionPla) {
        List<Planilla> l = em.createQuery("SELECT p FROM Planilla p WHERE p.planillaPK.codCia = :codCia "
                + "AND p.planillaPK.anio = :anio AND p.planillaPK.mes = :mes "
                + "AND p.planillaPK.numPlanilla = :numPlanilla AND p.planillaPK.codTipopla = :codTipopla ", Planilla.class)
        .setParameter("codCia", programacionPla.getProgramacionPlaPK().getCodCia())
        .setParameter("anio", programacionPla.getAnio())
        .setParameter("mes", programacionPla.getMes())
        .setParameter("numPlanilla", programacionPla.getNumPlanilla())
        .setParameter("codTipopla", programacionPla.getTiposPlanilla().getTiposPlanillaPK().getCodTipopla())
        .getResultList();
        return l != null ? l : new ArrayList<Planilla>();
    }
    
    @PermitAll
    public List<Planilla> findByEmpleado(Empleados emp, Short tipoPlanilla) {
        List<Planilla> listPla = em.createQuery("SELECT p FROM Planilla p WHERE p.planillaPK.codCia = :codCia AND p.planillaPK.codEmp = :codEmp AND p.planillaPK.codTipopla = :codTipopla", Planilla.class)
        .setParameter("codCia", emp.getEmpleadosPK().getCodCia())
        .setParameter("codEmp", emp.getEmpleadosPK().getCodEmp())
        .setParameter("codTipopla", tipoPlanilla)
        .getResultList();
        return listPla != null ? listPla : new ArrayList<Planilla>();        
    }
}
