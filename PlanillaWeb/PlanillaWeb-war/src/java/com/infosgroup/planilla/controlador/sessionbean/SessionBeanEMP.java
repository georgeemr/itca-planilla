/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@ManagedBean(name = "SessionBeanEMP")
@SessionScoped
public class SessionBeanEMP implements java.io.Serializable {

    @EJB
    private EmpleadoFacade empleadoFacade;
    @EJB
    private EmpleadosSessionBean empleadosBean;
    private Empleados empleadoSesion;

    public Empleados getEmpleadoSesion() {
        return empleadoSesion;
    }

    public void setEmpleadoSesion(Empleados empleadoSesion) {
        this.empleadoSesion = empleadoSesion;
    }

    @PostConstruct
    public void postConstruct() {
        try {
            empleadoSesion = (FacesContext.getCurrentInstance().getExternalContext().getRemoteUser() != null) ? empleadosBean.buscarEmpleadoPorUsuario(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser()) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Evaluacion evaluacionSeleccionada;

    public Evaluacion getEvaluacionSeleccionada() {
        return evaluacionSeleccionada;
    }

    public void setEvaluacionSeleccionada(Evaluacion evaluacionSeleccionada) {
        this.evaluacionSeleccionada = evaluacionSeleccionada;
    }
    private List<Factor> listaFactores;

    public List<Factor> getListaFactores() {
        if (evaluacionSeleccionada != null) {
            listaFactores = empleadosBean.listarFactoresPorPlantilla(evaluacionSeleccionada.getPlantilla());
        }
        return listaFactores;
    }

    public void setListaFactores(List<Factor> listaFactores) {
        this.listaFactores = listaFactores;
    }
    private Factor factorActual;

    public Factor getFactorActual() {
        return factorActual;
    }

    public void setFactorActual(Factor factorActual) {
        this.factorActual = factorActual;
    }
    private List<DetalleEvaluacion> detalleEvaluacionTemporal;

    public List<DetalleEvaluacion> getDetalleEvaluacionTemporal() {
        return detalleEvaluacionTemporal;
    }

    public void setDetalleEvaluacionTemporal(List<DetalleEvaluacion> detalleEvaluacionTemporal) {
        this.detalleEvaluacionTemporal = detalleEvaluacionTemporal;
    }
// 13022012    
//    private PuestoEmpleado[] puestosEmpleadosEvaluadores;
//
//    public PuestoEmpleado[] getPuestosEmpleadosEvaluadores() {
//        return puestosEmpleadosEvaluadores;
//    }
// 13022012      
//    public void setPuestosEmpleadosEvaluadores(PuestoEmpleado[] puestosEmpleadosEvaluadores) {
//        this.puestosEmpleadosEvaluadores = puestosEmpleadosEvaluadores;
//    }
//    private PuestoEmpleado[] puestosEmpleadosEvaluados;
//
//    public PuestoEmpleado[] getPuestosEmpleadosEvaluados() {
//        return puestosEmpleadosEvaluados;
//    }
//
//    public void setPuestosEmpleadosEvaluados(PuestoEmpleado[] puestosEmpleadosEvaluados) {
//        this.puestosEmpleadosEvaluados = puestosEmpleadosEvaluados;
//    }
//    private PuestoEmpleado puestoEmpleadoSession;
//
//    @PermitAll
//    public PuestoEmpleado getPuestoEmpleadoSession() {
//        if (empleadoSesion != null) {
//            puestoEmpleadoSession = empleadoFacade.getUltimoPuesto(empleadoSesion);
//        }
//        return puestoEmpleadoSession;
//    }
//
//    public void setPuestoEmpleadoSession(PuestoEmpleado puestoEmpleadoSession) {
//        this.puestoEmpleadoSession = puestoEmpleadoSession;
//    }
}
