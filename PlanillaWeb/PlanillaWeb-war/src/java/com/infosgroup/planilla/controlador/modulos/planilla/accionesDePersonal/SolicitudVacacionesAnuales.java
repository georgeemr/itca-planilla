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

/**
 *
 * @author root
 */
@ManagedBean(name="solicitudVacacionesAnuales")
@ViewScoped
public class SolicitudVacacionesAnuales extends SolicitudDePersonal implements java.io.Serializable {

    private Date fechaInicialPeriodoPagar;
    private Date fechaFinalPeriodoPagar;
    private Date fechaInicialPeriodoGozar;
    private Date fechaFinalPeriodoGozar;
    private String devengadas;

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
        setObservacion("");
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
//        if (getEncabezadoSolicitud().getTipo() == null) {
//            addMessage("Acciones de Personal", "Tipo de acción es un campo requerido", TipoMensaje.ERROR);
//            error = Boolean.FALSE;
//        }

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
        return error;
    }

    public String guardarSolicitud$action() {
        if (!validarSolicitud()) return null;
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getSessionBeanADM().getCompania(),getEmpleadosToAccionPersonal()));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getEmpleadosToAccionPersonal());
        accionPersonal.setEmpleados1( getEmpleadosToAccionPersonal().getEmpleados() );
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setDepartamentos(getEmpleadosToAccionPersonal().getDepartamentos());
        accionPersonal = getEstadoSolicitudByRol(accionPersonal);//accionPersonal.setStatus("G");
        accionPersonal.setUsuarioCreacion( getSessionBeanEMP().getEmpleadoSesion().getUsuario() );
        accionPersonal.setDevengadas(devengadas);
        accionPersonal.setPeriodo(fechaInicialPeriodoPagar);
        accionPersonal.setPeriodoFinal(fechaFinalPeriodoPagar);
        accionPersonal.setFechaFinal(fechaFinalPeriodoGozar);
        accionPersonal.setFechaInicial(fechaInicialPeriodoGozar);
        accionPersonal.setPuestos(getEmpleadosToAccionPersonal().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        //getEncabezadoSolicitud().setListaSolicitudes(getPlanillaSessionBean().getAccionesByRol(getSessionBeanEMP().getEmpleadoSesion()));
        //getPlanillaSessionBean().listarAccionporTipo(getSessionBeanADM().getCompania(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }

}