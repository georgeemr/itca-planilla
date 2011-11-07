/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.facades.CampaniaFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.PlantillaFacade;
import com.infosgroup.planilla.modelo.facades.TipoEvaluacionFacade;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class EmpleadosSessionBean {

    @EJB
    private CampaniaFacade campaniasFacade;
    @EJB
    private TipoEvaluacionFacade tipoEvaluacionFacade;
    @EJB
    private EmpleadoFacade empleadosFacade;

    public List<Campania> listarCampanias() {
        return campaniasFacade.findAll();
    }

    public List<TipoEvaluacion> listarTiposEvaluacion() {
        return tipoEvaluacionFacade.findAll();
    }

    public List<Plantilla> listarPlantillasPorTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
        return (tipoEvaluacion != null) ? tipoEvaluacion.getPlantillaList() : null;
    }

    public List<Empleado> listarEmpleados() {
        return empleadosFacade.findAll();
    }
}
