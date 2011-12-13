/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
import com.infosgroup.planilla.modelo.entidades.DetPlanillaPK;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleado;
import com.infosgroup.planilla.modelo.estructuras.DetallePlanilla;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence
//import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class DetPlanillaFacade extends AbstractFacade<DetPlanilla, DetPlanillaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetPlanillaFacade() {
        super(DetPlanilla.class);
    }

    public List<DetPlanilla> findIngresos(int cia, int anio, int mes, int pla, int emp) {
        List<DetPlanilla> listaDetalle = new ArrayList<DetPlanilla>(0);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetPlanilla> det = cb.createQuery(DetPlanilla.class);

        return listaDetalle;
    }

    public List<DetallePlanilla> findPlaDetalles(Long pla, Long anio, Long mes) {
        List<Object[]> det = null;
        List<DetallePlanilla> listaDeta = new ArrayList<DetallePlanilla>(0);
        Integer cia = 1;

        Query dt = em.createQuery("select distinct D.planilla, P "
                + "from DetPlanilla D, PuestoEmpleado P "
                + "where D.empleado.empleadoPK = P.empleado.empleadoPK "
                + "and D.detPlanillaPK.idCompania = :codCia "
                + "and D.detPlanillaPK.numPlanilla = :pla "
                + "and D.detPlanillaPK.anio = :anio "
                + "and D.detPlanillaPK.mes = :mes");
        dt.setParameter("codCia", 1);
        dt.setParameter("pla", pla);
        dt.setParameter("anio", anio);
        dt.setParameter("mes", mes);
        det = (List<Object[]>) dt.getResultList();

        for (Object[] o : det) {
            DetallePlanilla d = new DetallePlanilla();
            d.setPlanilla((Planilla) o[0]);
            d.setPuestoEmpleado((PuestoEmpleado) o[1]);

            Query pres = em.createQuery("select sum (det.monto) "
                    + "from DetPlanilla det, DeduccionesPrestaciones ded "
                    + "where ded.tipo = 'S' "
                    + "and ded.deduccionesPrestacionesPK = det.deduccionesPrestaciones.deduccionesPrestacionesPK "
                    + "and det.detPlanillaPK.numPlanilla = :pla "
                    + "and det.detPlanillaPK.idCompania = :cia "
                    + "and det.detPlanillaPK.idEmpleado = :emp");
            pres.setParameter("pla", d.getPlanilla().getPlanillaPK().getNumPlanilla());
            pres.setParameter("cia", d.getPlanilla().getPlanillaPK().getIdCompania());
            pres.setParameter("emp", d.getPuestoEmpleado().getEmpleado().getEmpleadoPK().getCodEmp());
            BigDecimal pres1 = (BigDecimal) pres.getSingleResult();
            d.setPrestaciones(pres1);

            Query ded = em.createQuery("select sum (deta.monto) "
                    + "from DetPlanilla deta, DeduccionesPrestaciones deduc "
                    + "where deduc.tipo = 'R' "
                    + "and deduc.deduccionesPrestacionesPK = deta.deduccionesPrestaciones.deduccionesPrestacionesPK "
                    + "and deta.detPlanillaPK.numPlanilla = :pla "
                    + "and deta.detPlanillaPK.idCompania = :cia "
                    + "and deta.detPlanillaPK.idEmpleado = :emp");
            ded.setParameter("pla", d.getPlanilla().getPlanillaPK().getNumPlanilla());
            ded.setParameter("cia", d.getPlanilla().getPlanillaPK().getIdCompania());
            ded.setParameter("emp", d.getPuestoEmpleado().getEmpleado().getEmpleadoPK().getCodEmp());
            BigDecimal ded1 = (BigDecimal) ded.getSingleResult();
            d.setDeducciones(ded1);
            d.setTotal(d.getPuestoEmpleado().getPuesto().getSalarioMinimo().add(pres1).subtract(ded1));

            List<DetPlanilla> ingresos = new ArrayList<DetPlanilla>(0);
            Query ing = em.createQuery("select dp from DetPlanilla dp, DeduccionesPrestaciones ded "
                    + "where ded.tipo = 'S' "
                    + "and dp.deduccionesPrestaciones.deduccionesPrestacionesPK = ded.deduccionesPrestacionesPK "
                    + "and dp.detPlanillaPK.idCompania = :cia "
                    + "and dp.detPlanillaPK.anio = :anio "
                    + "and dp.detPlanillaPK.mes = :mes "
                    + "and dp.detPlanillaPK.numPlanilla = :pla "
                    + "and dp.detPlanillaPK.idEmpleado = :emp ", DetPlanilla.class);
            ing.setParameter("pla", d.getPlanilla().getPlanillaPK().getNumPlanilla());
            ing.setParameter("cia", d.getPlanilla().getPlanillaPK().getIdCompania());
            ing.setParameter("anio", d.getPlanilla().getPlanillaPK().getAnio());
            ing.setParameter("mes", d.getPlanilla().getPlanillaPK().getMes());
            ing.setParameter("emp", d.getPuestoEmpleado().getEmpleado().getEmpleadoPK().getCodEmp());
            ingresos = (List<DetPlanilla>) ing.getResultList();
            d.setListaIng(ingresos);

            List<Object[]> listEgreso = null;
            List<DetPlanilla> egresos = new ArrayList<DetPlanilla>(0);
            Query egr = em.createQuery("select dp from DetPlanilla dp, DeduccionesPrestaciones ded "
                    + "where ded.tipo = 'S' "
                    + "and dp.deduccionesPrestaciones.deduccionesPrestacionesPK = ded.deduccionesPrestacionesPK "
                    + "and dp.detPlanillaPK.idCompania = :cia "
                    + "and dp.detPlanillaPK.anio = :anio "
                    + "and dp.detPlanillaPK.mes = :mes "
                    + "and dp.detPlanillaPK.numPlanilla = :pla "
                    + "and dp.detPlanillaPK.idEmpleado = :emp ", DetPlanilla.class);
            egr.setParameter("pla", d.getPlanilla().getPlanillaPK().getNumPlanilla());
            egr.setParameter("cia", d.getPlanilla().getPlanillaPK().getIdCompania());
            egr.setParameter("anio", d.getPlanilla().getPlanillaPK().getAnio());
            egr.setParameter("mes", d.getPlanilla().getPlanillaPK().getMes());
            egr.setParameter("emp", d.getPuestoEmpleado().getEmpleado().getEmpleadoPK().getCodEmp());
            egresos = (List<DetPlanilla>) egr.getResultList();
//            for (Object[] e : listEgreso){
//                DetPlanilla deta = new DetPlanilla();
//                deta = (DetPlanilla) e[0];
//                egresos.add(deta);
//            }
            d.setListaEgr(egresos);

            listaDeta.add(d);
        }

        return listaDeta;
    }
}
