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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author root
 */
public class SolicitudPermiso extends SolicitudDePersonal implements java.io.Serializable {
    
    private java.util.Date fechaInicial;
    private java.util.Date fechaFinal;
    private Long tipoPlanilla;
    private String planilla;
    private Planilla planillaSeleccionada;
    private Integer dias = 0;
    private Integer horas = 0;
    private double descuento = 0.0;

    public SolicitudPermiso(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
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

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
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

    public String guardarSolicitud$action() {
        if (!validarSolicitud()) { return null; }
        planillaSeleccionada = planillaSessionBean().findPlanillaById(new PlanillaPK(planilla));
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(planillaSeleccionada));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleado(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion());
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getEncabezadoSolicitud().getObservacion());
        accionPersonal.setStatus("G");
        accionPersonal.setFechaFinal(fechaFinal);
        accionPersonal.setFechaInicial(fechaInicial);
        accionPersonal.setPlanilla(planillaSeleccionada);
        accionPersonal.setPuesto( getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getUltimoPuesto() );
        accionPersonal.setPuestoEmpleado( getEncabezadoSolicitud().getSessionBeanEMP().getPuestoEmpleadoSession() );
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        getEncabezadoSolicitud().setListaSolicitudes(planillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo()));
        enviarCorreo(accionPersonal, "Mensaje de Prueba de accion de personal");
        limpiarCampos();
        return null;
    }

    @Override
    public void limpiarCampos() {
        fechaInicial = null;
        fechaFinal = null;
        tipoPlanilla = null;
        planilla = null;
        planillaSeleccionada = null;
        dias = 0;
        horas = 0;
        descuento = 0.0;
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

        if (fechaInicial != null && fechaFinal != null) {
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

        if (getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getPuestoEmpleadoList() == null || getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getPuestoEmpleadoList().isEmpty()) {
            addMessage("Acciones de Personal", "Usted no tiene ningún puesto asignado.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }
        return error;
    }

    private PlanillaSessionBean planillaSessionBean() {
        try {
            Context c = new InitialContext();
            return (PlanillaSessionBean) c.lookup("java:global/PlanillaWeb/ProcesosEJBModule/PlanillaSessionBean!com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
