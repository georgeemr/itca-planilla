/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import java.util.List;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author root
 */
public class SolicitudPermiso extends SolicitudDePersonal implements java.io.Serializable {

    private java.util.Date fechaInicial;
    private java.util.Date fechaFinal;
    private Short tipoPlanilla;
    private String planilla;
    private Short dias = 0;
    private Short horas = 0;
    private Double descuento = 0.0;
    private List<ProgramacionPla> listaPlanillas;

    public SolicitudPermiso(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            listaPlanillas = planillaSessionBean().getProgramacionPlaByTipo(getEncabezadoSolicitud().getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla);
        }
        return listaPlanillas != null ? listaPlanillas:new ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Short getDias() {
        return dias;
    }

    public void setDias(Short dias) {
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

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
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

    public String guardarSolicitud$action() {
        if (!validarSolicitud()) {
            return null;
        }

        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getEncabezadoSolicitud().getSessionBeanADM().getCompania()));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion());
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getEncabezadoSolicitud().getObservacion());
        accionPersonal.setStatus("G");
        accionPersonal.setFechaFinal(fechaFinal);
        accionPersonal.setFechaInicial(fechaInicial);
        accionPersonal.setDepartamentos(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getDepartamentos());
        accionPersonal.setAnio(new Short(planilla.split(":")[1].toString()));
        accionPersonal.setMes(new Short(planilla.split(":")[2].toString()));
        accionPersonal.setNumPlanilla(new Short(planilla.split(":")[3].toString()));
        accionPersonal.setCodTipopla(tipoPlanilla);
        accionPersonal.setDias(dias.shortValue());
        accionPersonal.setCantidad(descuento != null ? new BigDecimal(descuento) : BigDecimal.ZERO);
        accionPersonal.setHoras(horas != null ? horas.shortValue() : null);
        accionPersonal.setPuestos(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        getEncabezadoSolicitud().setListaSolicitudes(planillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        planillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        StringBuilder mensaje = new StringBuilder();

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
        dias = 0;
        horas = 0;
        descuento = 0.0;
        getEncabezadoSolicitud().setObservacion(null);
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

        if (horas != null) {
            if (horas < 0) {
                addMessage("Acciones de Personal", "La cantidad de horas no es valida.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }

        if (tipoPlanilla == null || tipoPlanilla == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el tipo planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if ((tipoPlanilla != null && tipoPlanilla != -1) && (planilla == null || planilla.equals("-1"))) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getPuestos() == null) {
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

    public void handleFechaInicial(DateSelectEvent event) {
        setFechaInicial(event.getDate());
    }

    public void handleFechaFinal(DateSelectEvent event) {
        setFechaFinal(event.getDate());
        if (getFechaInicial() != null && getFechaFinal() != null) {
            Long d = (getFechaFinal().getTime() - getFechaInicial().getTime()) / MILISEGUNDOS_POR_DIA;
            setDias(d.shortValue());
            d.intValue();
        } else {
            addMessage("Acciones de Personal", "Complete los campos de Fecha Inicial y Final", TipoMensaje.ERROR);
        }
    }

    public boolean validaAccionPersonal(java.util.Date f1, java.util.Date f2) {
        Boolean error = Boolean.TRUE;
        if (f1 == null) {
            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (f2 == null) {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (f1 != null && f2 != null) {
            if (!validaFechas(f1, f2)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicia y Fecha fin no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }
        return error;
    }
}
