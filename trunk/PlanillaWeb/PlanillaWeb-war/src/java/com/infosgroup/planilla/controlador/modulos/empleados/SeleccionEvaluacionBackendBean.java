/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "empleados$seleccionEvaluacion")
@ViewScoped
public class SeleccionEvaluacionBackendBean extends JSFUtil implements Serializable {

    @EJB
    private EmpleadosSessionBean empleadosBean;

    /** Creates a new instance of SeleccionEvaluacionBackendBean */
    public SeleccionEvaluacionBackendBean() {
    }
    private List<Campania> listaCampanias;

    public List<Campania> getListaCampanias() {
        listaCampanias = empleadosBean.listarCampanias();
        return listaCampanias;
    }

    public void setListaCampanias(List<Campania> listaCampanias) {
        this.listaCampanias = listaCampanias;
    }
    private List<TipoEvaluacion> listaTiposEvaluacion;

    public List<TipoEvaluacion> getListaTiposEvaluacion() {
        listaTiposEvaluacion = empleadosBean.listarTiposEvaluacion();
        return listaTiposEvaluacion;
    }

    public void setListaTiposEvaluacion(List<TipoEvaluacion> listaTiposEvaluacion) {
        this.listaTiposEvaluacion = listaTiposEvaluacion;
    }
    private List<Plantilla> listaPlantillas;

    public List<Plantilla> getListaPlantillas() {
        listaPlantillas = empleadosBean.listarPlantillas();
        return listaPlantillas;
    }

    public void setListaPlantillas(List<Plantilla> listaPlantillas) {
        this.listaPlantillas = listaPlantillas;
    }
    private List<Empleado> listaEmpleados;

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String mostrarEmpleados() {
        listaEmpleados = empleadosBean.listarEmpleados();
        return null;
    }

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String evaluarEmpleado$action()
    {
        return "evaluacionEmpleado?faces-redirect=true";
    }
}
