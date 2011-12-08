/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
import com.infosgroup.planilla.modelo.entidades.DetPlanillaPK;
import com.infosgroup.planilla.modelo.estructuras.DetallePlanilla;
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

    public List<DetPlanilla> findIngresos(int cia, int anio, int mes, int pla, int emp){
        List<DetPlanilla> listaDetalle = new ArrayList<DetPlanilla>(0);
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetPlanilla> det = cb.createQuery(DetPlanilla.class);
        
        return listaDetalle;
    }
    
//    public List<DetallePlanilla> findInfo(Empleado emp, Planilla pla){
//        List<DetallePlanilla> listaDeta = new ArrayList<DetallePlanilla>(0);
//        List<DetPlanilla> listaDetalle = new ArrayList<DetPlanilla>(0);
//        List<Empleado> listEmp = new ArrayList<Empleado>(0);
//        List<Planilla> listPla = new ArrayList<Planilla>(0);
//        Puesto puesto = new Puesto();
//        PuestoEmpleado pueEmp = new PuestoEmpleado();
//        Integer m;
//        
////        CriteriaQuery crit = Query
////        CriteriaBuilder.
//        
//        return listaDeta;
//    }
    public List<DetallePlanilla> findDetalles(/*int pla, int anio, int mes*/) {
        List<Object[]> det = null;
//        Empleado em = new Empleado();
//        em.getDetPlanillaList();
        
//        for ( DetPlanilla e : em.getDetPlanillaList() ){
//            e.getDeduccionesPrestaciones().getTipo().equals("S") ;
//        }
//        
        List<DetallePlanilla> listaDeta = new ArrayList<DetallePlanilla>(0) {
        };

        Query td = em.createNativeQuery("select distinct det.id_compania, pla.num_planilla, emp.cod_emp codigo, emp.apellidos apellido, emp.nombres nombre, pue.salario_minimo base,"
        +"(select sum (det.monto) "
                +"from det_planilla det, deducciones_prestaciones ded "
                +"where ded.tipo = 'S' "
                +"and ded.id_prestacion = det.id_prestacion) prestaciones, "
        +"(select sum(det.monto) "
                +"from det_planilla det, deducciones_prestaciones ded "
                +"where ded.tipo = 'R' "
                +"and ded.id_prestacion = det.id_prestacion) deducciones "
        +"from empleado emp, det_planilla det, planilla pla, puesto pue, "
        +"puesto_empleado pemp "
        +"where det.id_empleado = emp.cod_emp "
        +"and det.id_compania = emp.cod_cia "
        +"and det.id_compania = pla.id_compania "
        +"and det.num_planilla = pla.num_planilla "
        +"and emp.cod_emp = pemp.id_empleado "
        +"and emp.cod_cia = pemp.id_compania "
        +"and pemp.id_compania = pue.cod_cia "
        +"and pemp.id_puesto = pue.cod_puesto ");
//        +"and pla.num_planilla = ${pla}$ "
//        +"and pla.mes = ${mes}$ "
//        +"and pla.anio = ${anio}$");
//        td.setParameter(1, anio);
//        td.setParameter(2, mes);
//        td.setParameter(3, pla);
        det = (List<Object[]>) td.getResultList();
        for (Object[] o : det) {
            DetallePlanilla d = new DetallePlanilla();
            d.setCod_cia((Integer) o[0]);
            d.setNum_pla((Integer) o[1]);
            d.setCod_emp((Integer) o[2]);
            d.setApellido((String) o[3]);
            d.setNombre((String) o[4]);
            d.setBase((Double) o[5]);
            d.setPrestaciones((Double) o[6]);
            d.setDeducciones((Double) o[7]);
//            Double tot = bas + pres - ded;
//            d.setTotal(tot);
            listaDeta.add(d);
        }
        return listaDeta;
    }
}
