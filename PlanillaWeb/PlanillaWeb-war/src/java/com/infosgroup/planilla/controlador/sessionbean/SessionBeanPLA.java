/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
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
    
    private DetPlanilla detalleSeleccionado;
    private ResumenAsistencia resumenSeleccionado;
    
    public DetPlanilla getDetalleSeleccionado() {
        return detalleSeleccionado;
    }

    public void setDetalleSeleccionado(DetPlanilla detalleSeleccionado) {
        this.detalleSeleccionado = detalleSeleccionado;
    }

    public ResumenAsistencia getResumenSeleccionado() {
        return resumenSeleccionado;
    }

    public void setResumenSeleccionado(ResumenAsistencia resumenSeleccionado) {
        this.resumenSeleccionado = resumenSeleccionado;
    }
    
}
