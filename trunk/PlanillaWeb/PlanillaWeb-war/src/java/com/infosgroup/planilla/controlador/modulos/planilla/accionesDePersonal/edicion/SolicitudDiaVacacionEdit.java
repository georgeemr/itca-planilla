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
@ManagedBean(name = "solicitudDiaVacacionEdit")
@ViewScoped
public class SolicitudDiaVacacionEdit extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Date fechaInicial;
    private Date fechaFinal;
    private String observacion;
    private Short dias = 0;

    public SolicitudDiaVacacionEdit() {
    }
    
    @PostConstruct
    public void _init() {
        if (getSessionBeanPLA().getAccionSeleccionada() != null) {
            setPlanilla(getSessionBeanPLA().getAccionSeleccionada().getPlanillaToString());
            setTipoPlanilla(getSessionBeanPLA().getAccionSeleccionada().getCodTipopla());
            setFechaInicial(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial());
            setFechaFinal(getSessionBeanPLA().getAccionSeleccionada().getFechaFinal());
            setDias(getSessionBeanPLA().getAccionSeleccionada().getDias());
            setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
        }
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Short getDias() {
        return dias;
    }

    public void setDias(Short dias) {
        this.dias = dias;
    }

    @Override
    public String guardarCambios() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null || !validarSolicitud()) return null;
        try {
            if (isInRole("rrhh")) {
                a.setAnio(new Short(getPlanilla().split(":")[1].toString()));
                a.setMes(new Short(getPlanilla().split(":")[2].toString()));
                a.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
                a.setCodTipopla(getTipoPlanilla());
            }
            a.setFechaInicial(getFechaInicial());
            a.setFechaFinal(getFechaFinal());
            a.setDias(getDias());
            a.setObservacion(getObservacion());
            actualizarSolicitud(a);
            addMessage("Acciones de Personal", "Datos Guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Acciones de Personal", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.ERROR);
            looger.log(Level.SEVERE, "Ha ocurrido el siguiente error al intentar Actualizar.", e);
        }
        return null;
    }
    
    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
        if (fechaInicial == null) {
            addMessage("Acciones de Personal", "Fecha inicial es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaFinal == null) {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicial != null && fechaFinal != null) {
            if (!validaFechas(fechaInicial, fechaFinal)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicial y final de periodo de goce no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }
        if (isInRole("rrhh")) {
            if (getTipoPlanilla() == null || getTipoPlanilla() == -1) {
                addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }

            if ((getTipoPlanilla() != null && getTipoPlanilla() != -1) && (getPlanilla() == null || getPlanilla().equals("-1"))) {
                addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }
        return error;
    }

    public void handleFechaInicial(DateSelectEvent event) {
        setFechaInicial(event.getDate());
        setDias(calculaDias(getFechaInicial(), getFechaFinal()).shortValue());
    }

    public void handleFechaFinal(DateSelectEvent event) {
        setFechaFinal(event.getDate());
        setDias(calculaDias(getFechaInicial(), getFechaFinal()).shortValue());
    }
    
    @Override
    protected void limpiarCampos() {
        getSessionBeanPLA().setAccionSeleccionada(null);
    }

    @Override
    protected PlanillaSessionBean getPlanillaSessionBean() {
        return planillaSessionBean;
    }

    @Override
    public Cias getEmpresa() {
        return getSessionBeanADM().getCompania();
    }
}
