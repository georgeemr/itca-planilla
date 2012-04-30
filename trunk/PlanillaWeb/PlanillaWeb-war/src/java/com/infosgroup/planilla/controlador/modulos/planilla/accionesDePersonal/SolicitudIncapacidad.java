/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name="solicitudIncapacidad")
@ViewScoped
public class SolicitudIncapacidad extends SolicitudDePersonal implements java.io.Serializable {

    private Date fechaPlanilla;
    private Date fechaRealPlanilla;
    private Date fechaInicial;
    private Date fechaFinal;
    private Short dias = 0;

    public Short getDias() {
        return dias;
    }

    public void setDias(Short dias) {
        this.dias = dias;
    }

    public Date getFechaRealPlanilla() {
        return fechaRealPlanilla;
    }

    public void setFechaRealPlanilla(Date fechaRealPlanilla) {
        this.fechaRealPlanilla = fechaRealPlanilla;
    }

    public Date getFechaPlanilla() {
        return fechaPlanilla;
    }

    public void setFechaPlanilla(Date fechaPlanilla) {
        this.fechaPlanilla = fechaPlanilla;
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

    @Override
    protected void limpiarCampos() {
        fechaPlanilla = null;
        fechaRealPlanilla = null;
        fechaInicial = null;
        fechaFinal = null;
        setTipoPlanilla(null);
        setPlanilla(null);
        dias = new Short("0");
        setObservacion("");
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
//        if (getEncabezadoSolicitud().getTipo() == null) {
//            addMessage("Acciones de Personal", "Tipo de acción es un campo requerido", TipoMensaje.ERROR);
//            error = Boolean.FALSE;
//        }

        if (fechaPlanilla == null) {
            addMessage("Acciones de Personal", "Fecha Planilla es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaRealPlanilla == null) {
            addMessage("Acciones de Personal", "Fecha Real Planilla es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicial == null) {
            addMessage("Acciones de Personal", "Fecha inicial del Periodo de Incapacidad es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaFinal == null) {
            addMessage("Acciones de Personal", "Fecha final del Periodo de Incapacidad es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicial != null || fechaFinal != null) {
            if (!validaFechas(fechaInicial, fechaFinal)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicial y final de Incapacidad no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }

        if (getTipoPlanilla() == null || getTipoPlanilla() == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if ((getTipoPlanilla() != null && getTipoPlanilla() != -1) && (getPlanilla() == null || getPlanilla().equals("-1"))) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        return error;
    }

    public String guardarSolicitud$action() {
        if (!validarSolicitud()) return null;
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getSessionBeanADM().getCompania(), getEmpleadosToAccionPersonal()));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getEmpleadosToAccionPersonal());
        accionPersonal.setEmpleados1( getEmpleadosToAccionPersonal().getEmpleados() );
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setDepartamentos(getEmpleadosToAccionPersonal().getDepartamentos());
        accionPersonal.setStatus("G");
        accionPersonal.setUsuarioCreacion( getSessionBeanEMP().getEmpleadoSesion().getUsuario() );
        accionPersonal.setDias(dias != null ? dias : 0);
        accionPersonal.setPeriodo(fechaInicial);
        accionPersonal.setPeriodoFinal(fechaFinal);
        accionPersonal.setFechaInicial(fechaPlanilla);
        accionPersonal.setFechaFinal(fechaRealPlanilla);
        accionPersonal.setAnio(new Short(getPlanilla().split(":")[1].toString()));
        accionPersonal.setMes(new Short(getPlanilla().split(":")[2].toString()));
        accionPersonal.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
        accionPersonal.setCodTipopla(getTipoPlanilla());
        accionPersonal.setPuestos(getEmpleadosToAccionPersonal().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        //getEncabezadoSolicitud().setListaSolicitudes(getPlanillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        //getPlanillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }

    public void handleFechaInicial(DateSelectEvent event) {
        setFechaInicial(event.getDate());
        setDias( calculaDias(getFechaInicial(), getFechaFinal()).shortValue() );
    }

    public void handleFechaFinal(DateSelectEvent event) {
        setFechaFinal(event.getDate());
        setDias( calculaDias(getFechaInicial(), getFechaFinal()).shortValue() );
    }

}