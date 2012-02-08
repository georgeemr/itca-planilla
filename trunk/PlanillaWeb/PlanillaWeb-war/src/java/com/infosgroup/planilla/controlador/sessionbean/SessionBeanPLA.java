/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
//import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "SessionBeanPLA")
@SessionScoped
public class SessionBeanPLA {

    public SessionBeanPLA() {
    }
    
//    private DetPlanilla detalleSeleccionado;
    private ResumenAsistencia resumenSeleccionado;
    private AccionPersonal accionSeleccionada;
    private Boolean aprobados;
    private Boolean tbEmp = false;
    private Boolean tbJefes;

//    public DetPlanilla getDetalleSeleccionado() {
//        return detalleSeleccionado;
//    }
//
//    public void setDetalleSeleccionado(DetPlanilla detalleSeleccionado) {
//        this.detalleSeleccionado = detalleSeleccionado;
//    }

    public ResumenAsistencia getResumenSeleccionado() {
        return resumenSeleccionado;
    }

    public void setResumenSeleccionado(ResumenAsistencia resumenSeleccionado) {
        this.resumenSeleccionado = resumenSeleccionado;
    }

    public AccionPersonal getAccionSeleccionada() {
        return accionSeleccionada;
    }

    public void setAccionSeleccionada(AccionPersonal accionSeleccionada) {
        this.accionSeleccionada = accionSeleccionada;
    }

    public Boolean getAprobados() {
        return aprobados;
    }

    public void setAprobados(Boolean aprobados) {
        this.aprobados = aprobados;
    }

    public Boolean getTbEmp() {
        return tbEmp;
    }

    public void setTbEmp(Boolean tbEmp) {
        this.tbEmp = tbEmp;
    }

    public Boolean getTbJefes() {
        return tbJefes;
    }

    public void setTbJefes(Boolean tbJefes) {
        this.tbJefes = tbJefes;
    }
    
}