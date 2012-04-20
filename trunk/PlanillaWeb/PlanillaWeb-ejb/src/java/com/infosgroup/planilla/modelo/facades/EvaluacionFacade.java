/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.EvaluacionPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class EvaluacionFacade extends AbstractFacade<Evaluacion, EvaluacionPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacionFacade() {
        super(Evaluacion.class);
    }

    public List<Evaluacion> findEvaluacionesAbiertasByCampania(Campania campania, Empleados empleado) {
        String query = "select unique b.* from evaluador_evaluaciones a, evaluacion b "
                + "where a.cod_cia = ? and a.periodo = ? and a.campania = ? and a.tipo_evaluacion = ? and a.plantilla = ? "
                + "and a.evaluador = ? "
                + "and b.cod_cia = a.cod_cia and b.periodo = a.periodo and b.cod_campania = a.campania "
                + "and b.tipo_evaluacion = a.tipo_evaluacion "
                + "and b.plantilla = a.plantilla and b.cod_emp = a.empleado";
        List<Evaluacion> l = em.createNativeQuery(query, Evaluacion.class)
                .setParameter(1, campania.getCampaniaPK().getCodCia())
                .setParameter(2, campania.getCampaniaPK().getPeriodo())
                .setParameter(3, campania.getCampaniaPK().getCodCampania())
                .setParameter(4, campania.getPreEvaluacionList().get(0).getTipoEvaluacion1().getTipoEvaluacionPK().getCodTipoEvaluacion())
                .setParameter(5, campania.getPreEvaluacionList().get(0).getPlantilla1().getPlantillaPK().getCodPlantilla())
                .setParameter(6, empleado.getEmpleadosPK().getCodEmp())
                .getResultList();
        
        return l!=null?l:new ArrayList<Evaluacion>();
    }

    public List<Evaluacion> findEvaluacionesAbiertasByCampania(Campania campania){
        TypedQuery<Evaluacion> tq = em.createQuery("SELECT e FROM Evaluacion e WHERE e.campania = :campania"/* and e.finalizada = 0"*/, Evaluacion.class);
        tq.setParameter("campania", campania);
        List<Evaluacion> l = tq.getResultList();
        return l!=null?l:new ArrayList<Evaluacion>();
    }
    public Integer findEvaluacionesByCampania(Campania campania) {
        TypedQuery<Evaluacion> tq = em.createQuery("SELECT e FROM Evaluacion e WHERE e.campania = :campania", Evaluacion.class);
        tq.setParameter("campania", campania);
        return (tq.getResultList() != null) ? tq.getResultList().size() : 0;
    }
}
