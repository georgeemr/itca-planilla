/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAsistencia;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleado;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "SessionBeanCAP")
@SessionScoped
public class SessionBeanCAP implements Serializable {

    //@EJB
    //private CapacitacionesSessionBean capacitacionesSessionBean;
    private Capacitacion capacitacionSeleccionada;
    private CapacitacionXEmpleado detalleCapSeleccionada;
    private Empleados empleadoSeleccionado;
    private CapacitacionAsistencia asistenciaSeleccionada;

    public Capacitacion getCapacitacionSeleccionada() {
        return capacitacionSeleccionada;
    }

    public void setCapacitacionSeleccionada(Capacitacion capacitacionSeleccionada) {
        this.capacitacionSeleccionada = capacitacionSeleccionada;
    }

    public CapacitacionXEmpleado getDetalleCapSeleccionada() {
        return detalleCapSeleccionada;
    }

    public void setDetalleCapSeleccionada(CapacitacionXEmpleado detalleCapSeleccionada) {
        this.detalleCapSeleccionada = detalleCapSeleccionada;
    }

    public Empleados getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Empleados empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public CapacitacionAsistencia getAsistenciaSeleccionada() {
        return asistenciaSeleccionada;
    }

    public void setAsistenciaSeleccionada(CapacitacionAsistencia asistenciaSeleccionada) {
        this.asistenciaSeleccionada = asistenciaSeleccionada;
    }
}
