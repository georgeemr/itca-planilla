/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.Date;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "solicitudIncapacidad")
@ViewScoped
public class SolicitudIncapacidad extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Cias empresa;
    private Date fechaPlanilla;
    private Date fechaRealPlanilla;
    private Date fechaInicioIncapacidad;
    private Date fechaFinIncapacidad;
    private String observacion;
    private Short dias;
    
    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }

    public Short getDias() {
        return dias;
    }

    public void setDias(Short dias) {
        this.dias = dias;
    }

    public Date getFechaFinIncapacidad() {
        return fechaFinIncapacidad;
    }

    public void setFechaFinIncapacidad(Date fechaFinIncapacidad) {
        this.fechaFinIncapacidad = fechaFinIncapacidad;
    }

    public Date getFechaInicioIncapacidad() {
        return fechaInicioIncapacidad;
    }

    public void setFechaInicioIncapacidad(Date fechaInicioIncapacidad) {
        this.fechaInicioIncapacidad = fechaInicioIncapacidad;
    }

    public Date getFechaPlanilla() {
        return fechaPlanilla;
    }

    public void setFechaPlanilla(Date fechaPlanilla) {
        this.fechaPlanilla = fechaPlanilla;
    }

    public Date getFechaRealPlanilla() {
        return fechaRealPlanilla;
    }

    public void setFechaRealPlanilla(Date fechaRealPlanilla) {
        this.fechaRealPlanilla = fechaRealPlanilla;
    }

    public SolicitudIncapacidad() {
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String guardarCambios() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null || !validarSolicitud())return null;
        try {
            a.setAnio(new Short(getPlanilla().split(":")[1].toString()));
            a.setMes(new Short(getPlanilla().split(":")[2].toString()));
            a.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
            a.setCodTipopla(getTipoPlanilla());
            a.setDias(getDias());
            a.setObservacion(getObservacion());
            a.setPeriodo(getFechaInicioIncapacidad());
            a.setPeriodoFinal(getFechaFinIncapacidad());
            a.setFechaInicial(getFechaPlanilla());
            a.setFechaFinal(getFechaRealPlanilla());
            actualizarSolicitud(a);
            addMessage("Acciones de Personal", "Datos Guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Acciones de Personal", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.ERROR);
            looger.log(Level.SEVERE, "Ha ocurrido el siguiente error al intentar Actualizar.", e);
        }
        return null;
    }
    
    @PostConstruct
    public void _init(){
        setEmpresa( getSessionBeanADM().getCompania() );
        if (getSessionBeanPLA().getAccionSeleccionada() != null) {
            setPlanilla(getSessionBeanPLA().getAccionSeleccionada().getPlanillaToString());
            setTipoPlanilla(getSessionBeanPLA().getAccionSeleccionada().getCodTipopla());
            setFechaInicioIncapacidad(getSessionBeanPLA().getAccionSeleccionada().getPeriodo() );
            setFechaFinIncapacidad(getSessionBeanPLA().getAccionSeleccionada().getPeriodoFinal() );
            setFechaPlanilla(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial());
            setFechaRealPlanilla(getSessionBeanPLA().getAccionSeleccionada().getFechaFinal());
            setDias(getSessionBeanPLA().getAccionSeleccionada().getDias());
            setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
        }
    }
    
    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;

        if (getFechaPlanilla() == null) {
            addMessage("Acciones de Personal", "Fecha Planilla es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaRealPlanilla() == null) {
            addMessage("Acciones de Personal", "Fecha Real Planilla es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaInicioIncapacidad() == null) {
            addMessage("Acciones de Personal", "Fecha inicial del Periodo de Incapacidad es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaFinIncapacidad() == null) {
            addMessage("Acciones de Personal", "Fecha final del Periodo de Incapacidad es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaInicioIncapacidad() != null || getFechaFinIncapacidad()  != null) {
            if (!validaFechas(getFechaInicioIncapacidad(), getFechaFinIncapacidad() )) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicial y final de Incapacidad no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }

        if (getTipoPlanilla() == null || getTipoPlanilla() == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if ((getTipoPlanilla() != null && getTipoPlanilla() != -1) && (getTipoPlanilla() == null || getTipoPlanilla().equals(new Short("-1")))) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        return error;
    }
    
    public void handleFechaInicial(DateSelectEvent event) {
        setFechaInicioIncapacidad(event.getDate());
        setDias(calculaDias(getFechaInicioIncapacidad(), getFechaFinIncapacidad()).shortValue());
    }

    public void handleFechaFinal(DateSelectEvent event) {
        setFechaFinIncapacidad(event.getDate());
        setDias(calculaDias(getFechaInicioIncapacidad(), getFechaFinIncapacidad()).shortValue());
    }

    @Override
    protected PlanillaSessionBean getPlanillaSessionBean() {
        return planillaSessionBean;
    }

    @Override
    public Cias getEmpresa() {
        return empresa;
    }

    @Override
    protected void limpiarCampos() {
        getSessionBeanPLA().setAccionSeleccionada(null);
    }
}
