/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
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
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public DetPlanilla getDetalleSeleccionado() {
        return detalleSeleccionado;
    }

    public void setDetalleSeleccionado(DetPlanilla detalleSeleccionado) {
        this.detalleSeleccionado = detalleSeleccionado;
    }
}
