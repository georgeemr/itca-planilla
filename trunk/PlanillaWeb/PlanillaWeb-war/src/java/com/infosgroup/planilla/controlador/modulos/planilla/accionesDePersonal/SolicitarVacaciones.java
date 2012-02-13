/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PlanillaPK;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.Date;

/**
 *
 * @author root
 */
public class SolicitarVacaciones extends SolicitudDePersonal implements java.io.Serializable {

    private PlanillaSessionBean planillaSessionBean;
    private Date fechaInicial;
    private Date fechaFinal;
    private Long tipoPlanilla;
    private String planilla;
    private Planilla planillaSeleccionada;
    private String afectaPlanilla;
    private String devengadas;

    public SolicitarVacaciones(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
    }

    public String getAfectaPlanilla() {
        return afectaPlanilla;
    }

    public void setAfectaPlanilla(String afectaPlanilla) {
        this.afectaPlanilla = afectaPlanilla;
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

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public Planilla getPlanillaSeleccionada() {
        return planillaSeleccionada;
    }

    public void setPlanillaSeleccionada(Planilla planillaSeleccionada) {
        this.planillaSeleccionada = planillaSeleccionada;
    }

    public Long getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Long tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public String getDevengadas() {
        return devengadas;
    }

    public void setDevengadas(String devengadas) {
        this.devengadas = devengadas;
    }

    @Override
    protected void limpiarCampos() {
        fechaInicial = null;
        fechaFinal = null;
        tipoPlanilla = null;
        planilla = null;
        planillaSeleccionada = null;
        afectaPlanilla = null;
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
        if (getEncabezadoSolicitud().getTipo() == null) {
            addMessage("Acciones de Personal", "Tipo de acción es un campo requerido", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicial == null) {
            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaFinal == null) {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicial != null || fechaFinal != null) {
            if (!validaFechas(fechaInicial, fechaFinal)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicia y Fecha fin no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }

        if (tipoPlanilla == null) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (planilla == null) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }
// 13022012
//        if (getSessionBeanEMP().getEmpleadoSesion().getPuestoEmpleadoList() == null || getSessionBeanEMP().getEmpleadoSesion().getPuestoEmpleadoList().isEmpty()) {
//            addMessage("Acciones de Personal", "Usted no tiene ningún puesto asignado.", TipoMensaje.ERROR);
//            error = Boolean.FALSE;
//        }

        return error;
    }

    public String guardarSolicitud$action() {
        if (!validarSolicitud()) {
            return null;
        }
        planillaSeleccionada = planillaSessionBean.findPlanillaById(new PlanillaPK(planilla, getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getEmpleadosPK().getCodEmp()));
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(planillaSeleccionada));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getSessionBeanEMP().getEmpleadoSesion());
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getEncabezadoSolicitud().getObservacion());
        accionPersonal.setStatus("G");
        accionPersonal.setDevengadas(devengadas);
        accionPersonal.setFechaFinal(fechaFinal);
        accionPersonal.setFechaInicial(fechaInicial);
// 13022012
//        accionPersonal.setPlanilla(planillaSeleccionada);
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        getEncabezadoSolicitud().setListaSolicitudes(planillaSessionBean.listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo()));
        limpiarCampos();
        return null;
    }
}