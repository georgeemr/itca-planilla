/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.PreEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
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
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Usuario no encontrado en la base de datos. ");
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
            listaFactores = empleadosBean.listarFactoresPorPlantilla(evaluacionSeleccionada.getPlantilla1());
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
    private Empleados[] puestosEmpleadosEvaluadores;

    public Empleados[] getPuestosEmpleadosEvaluadores() {
        return puestosEmpleadosEvaluadores;
    }

    public void setPuestosEmpleadosEvaluadores(Empleados[] puestosEmpleadosEvaluadores) {
        this.puestosEmpleadosEvaluadores = puestosEmpleadosEvaluadores;
    }
    private Empleados[] puestosEmpleadosEvaluados;

    public Empleados[] getPuestosEmpleadosEvaluados() {
        return puestosEmpleadosEvaluados;
    }

    public void setPuestosEmpleadosEvaluados(Empleados[] puestosEmpleadosEvaluados) {
        this.puestosEmpleadosEvaluados = puestosEmpleadosEvaluados;
    }
    private Empleados puestoEmpleadoSession;

    public void setPuestoEmpleadoSession(Empleados puestoEmpleadoSession) {
        this.puestoEmpleadoSession = puestoEmpleadoSession;
    }
    
    private PreEvaluacion preEvaluacionSeleccionada;

    public PreEvaluacion getPreEvaluacionSeleccionada() {
        return preEvaluacionSeleccionada;
    }

    public void setPreEvaluacionSeleccionada(PreEvaluacion preEvaluacionSeleccionada) {
        this.preEvaluacionSeleccionada = preEvaluacionSeleccionada;
    }
    
}
