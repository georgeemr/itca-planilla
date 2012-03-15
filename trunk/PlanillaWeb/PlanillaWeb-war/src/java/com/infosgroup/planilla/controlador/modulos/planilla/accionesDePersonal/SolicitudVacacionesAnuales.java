/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author root
 */
public class SolicitudVacacionesAnuales extends SolicitudDePersonal implements java.io.Serializable {

    private Date fechaInicialPeriodoPagar;
    private Date fechaFinalPeriodoPagar;
    private Date fechaInicialPeriodoGozar;
    private Date fechaFinalPeriodoGozar;
    private Short tipoPlanilla;
    private String planilla;
    private String devengadas;
    private List<ProgramacionPla> listaPlanillas;
    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public SolicitudVacacionesAnuales(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            listaPlanillas = planillaSessionBean().getProgramacionPlaByTipo(getEncabezadoSolicitud().getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla);
        }
        return listaPlanillas != null ? listaPlanillas : new ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public Date getFechaFinalPeriodoPagar() {
        return fechaFinalPeriodoPagar;
    }

    public void setFechaFinalPeriodoPagar(Date fechaFinalPeriodoPagar) {
        this.fechaFinalPeriodoPagar = fechaFinalPeriodoPagar;
    }

    public Date getFechaInicialPeriodoPagar() {
        return fechaInicialPeriodoPagar;
    }

    public void setFechaInicialPeriodoPagar(Date fechaInicialPeriodoPagar) {
        this.fechaInicialPeriodoPagar = fechaInicialPeriodoPagar;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public String getDevengadas() {
        return devengadas;
    }

    public void setDevengadas(String devengadas) {
        this.devengadas = devengadas;
    }

    public Date getFechaFinalPeriodoGozar() {
        return fechaFinalPeriodoGozar;
    }

    public void setFechaFinalPeriodoGozar(Date fechaFinalPeriodoGozar) {
        this.fechaFinalPeriodoGozar = fechaFinalPeriodoGozar;
    }

    public Date getFechaInicialPeriodoGozar() {
        return fechaInicialPeriodoGozar;
    }

    public void setFechaInicialPeriodoGozar(Date fechaInicialPeriodoGozar) {
        this.fechaInicialPeriodoGozar = fechaInicialPeriodoGozar;
    }

    @Override
    protected void limpiarCampos() {
        fechaInicialPeriodoPagar = null;
        fechaFinalPeriodoPagar = null;
        fechaInicialPeriodoGozar = null;
        fechaFinalPeriodoGozar = null;
        tipoPlanilla = null;
        planilla = null;
        setObservacion("");
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
        if (getEncabezadoSolicitud().getTipo() == null) {
            addMessage("Acciones de Personal", "Tipo de acción es un campo requerido", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicialPeriodoPagar == null) {
            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaFinalPeriodoPagar == null) {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicialPeriodoPagar != null && fechaFinalPeriodoPagar != null) {
            if (!validaFechas(fechaInicialPeriodoPagar, fechaFinalPeriodoPagar)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicial y Fecha fin no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }

        if (fechaInicialPeriodoGozar == null) {
            addMessage("Acciones de Personal", "Fecha inicial del Periodo de Goce es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaFinalPeriodoGozar == null) {
            addMessage("Acciones de Personal", "Fecha final del Periodo de goce es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicialPeriodoGozar != null && fechaFinalPeriodoGozar != null) {
            if (!validaFechas(fechaInicialPeriodoGozar, fechaFinalPeriodoGozar)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicial y final de periodo de goce no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }

        if (tipoPlanilla == null || tipoPlanilla == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if ((tipoPlanilla != null && tipoPlanilla != -1) && (planilla == null || planilla.equals("-1"))) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        return error;
    }

    public String guardarSolicitud$action() {
        if (!validarSolicitud()) return null;
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getEncabezadoSolicitud().getSessionBeanADM().getCompania(),getEmpleadosToAccionPersonal()));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getEmpleadosToAccionPersonal());
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setDepartamentos(getEmpleadosToAccionPersonal().getDepartamentos());
        accionPersonal.setStatus("G");
        accionPersonal.setUsuarioCreacion( getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getUsuario() );
        accionPersonal.setDevengadas(devengadas);
        accionPersonal.setPeriodo(fechaInicialPeriodoPagar);
        accionPersonal.setPeriodoFinal(fechaFinalPeriodoPagar);
        accionPersonal.setFechaFinal(fechaFinalPeriodoGozar);
        accionPersonal.setFechaInicial(fechaInicialPeriodoGozar);
        accionPersonal.setAnio(new Short(planilla.split(":")[1].toString()));
        accionPersonal.setMes(new Short(planilla.split(":")[2].toString()));
        accionPersonal.setNumPlanilla(new Short(planilla.split(":")[3].toString()));
        accionPersonal.setCodTipopla(tipoPlanilla);
        accionPersonal.setPuestos(getEmpleadosToAccionPersonal().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        getEncabezadoSolicitud().setListaSolicitudes(planillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        planillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }

}