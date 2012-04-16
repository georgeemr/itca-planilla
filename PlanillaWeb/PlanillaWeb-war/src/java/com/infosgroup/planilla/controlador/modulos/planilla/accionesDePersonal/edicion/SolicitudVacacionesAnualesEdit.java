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

/**
 *
 * @author root
 */
@ManagedBean(name = "solicitudVacacionesAnualesEdit")
@ViewScoped
public class SolicitudVacacionesAnualesEdit extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Cias empresa;
    private Date fechaInicial;
    private Date fechaFinal;
    private Date fechaInicialPeriodo;
    private Date fechaFinalPeriodo;
    private String devengadas;
    private String observacion;

    public SolicitudVacacionesAnualesEdit() {
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDevengadas() {
        return devengadas;
    }

    public void setDevengadas(String devengadas) {
        this.devengadas = devengadas;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaFinalPeriodo() {
        return fechaFinalPeriodo;
    }

    public void setFechaFinalPeriodo(Date fechaFinalPeriodo) {
        this.fechaFinalPeriodo = fechaFinalPeriodo;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicialPeriodo() {
        return fechaInicialPeriodo;
    }

    public void setFechaInicialPeriodo(Date fechaInicialPeriodo) {
        this.fechaInicialPeriodo = fechaInicialPeriodo;
    }

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
            a.setObservacion(getObservacion());
            a.setDevengadas(getDevengadas());
            a.setPeriodo(getFechaInicial());
            a.setPeriodoFinal(getFechaFinal());
            a.setFechaFinal(getFechaFinalPeriodo());
            a.setFechaInicial(getFechaInicialPeriodo());
            actualizarSolicitud(a);
            addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Acciones de Personal", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.ERROR);
            looger.log(Level.SEVERE, "Ha ocurrido el siguiente error al intentar Actualizar.", e);
        }

        return null;
    }

    @PostConstruct
    public void _init() {
        setEmpresa(getSessionBeanADM().getCompania());
        setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
        setDevengadas(getSessionBeanPLA().getAccionSeleccionada().getDevengadas());
        setFechaInicialPeriodo(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial());
        setFechaFinalPeriodo(getSessionBeanPLA().getAccionSeleccionada().getFechaFinal());
        setFechaFinal(getSessionBeanPLA().getAccionSeleccionada().getPeriodoFinal());
        setFechaInicial(getSessionBeanPLA().getAccionSeleccionada().getPeriodo());
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;

        if (getFechaInicial() == null) {
            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaFinal() == null) {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaInicial() != null && getFechaFinal() != null) {
            if (!validaFechas(getFechaInicial(), getFechaFinal())) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicial y Fecha fin no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }

        if (getFechaInicialPeriodo() == null) {
            addMessage("Acciones de Personal", "Fecha inicial del Periodo de Goce es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaFinalPeriodo() == null) {
            addMessage("Acciones de Personal", "Fecha final del Periodo de goce es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaInicialPeriodo() != null && getFechaFinalPeriodo() != null) {
            if (!validaFechas(getFechaInicialPeriodo(), getFechaFinalPeriodo())) {
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

    @Override
    protected PlanillaSessionBean getPlanillaSessionBean() {
        return planillaSessionBean;
    }

    @Override
    public Cias getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }

    @Override
    protected void limpiarCampos() {
        getSessionBeanPLA().setAccionSeleccionada(null);
    }
}
