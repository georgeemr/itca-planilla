/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.Date;
import java.util.List;

/**
 *
 * @author root
 */
public class SolicitudNoAfectaPlanilla extends SolicitudDePersonal implements java.io.Serializable {
    
    private Short tipoAccionSeleccionada;
    private java.util.Date fechaInicial;
    private java.util.Date fechaFinal;
    private java.util.List<TipoAccion> listaTipoAccionNoAfecta;
    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public SolicitudNoAfectaPlanilla(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
    }
    
    public Short getTipoAccionSeleccionada() {
        return tipoAccionSeleccionada;
    }
    
    public void setTipoAccionSeleccionada(Short tipoAccionSeleccionada) {
        this.tipoAccionSeleccionada = tipoAccionSeleccionada;
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
    
    public List<TipoAccion> getListaTipoAccionNoAfecta() {
        listaTipoAccionNoAfecta = planillaSessionBean().listarTipoAccionNoAfectaPlanilla(getEncabezadoSolicitud().getSessionBeanADM().getCompania());
        return listaTipoAccionNoAfecta;
    }
    
    public void setListaTipoAccionNoAfecta(List<TipoAccion> listaTipoAccionNoAfecta) {
        this.listaTipoAccionNoAfecta = listaTipoAccionNoAfecta;
    }
    
    public String guardarSolicitud$action() {
        if (validarSolicitud()) {
            return null;
        }
        AccionPersonal accionPersonal = new AccionPersonal();
        TipoAccion tipoAccion = new TipoAccion(new TipoAccionPK(getEncabezadoSolicitud().getEmpresa(), tipoAccionSeleccionada));
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getEncabezadoSolicitud().getSessionBeanADM().getCompania(), tipoAccion));
        accionPersonal.setTipoAccion(tipoAccion);
        accionPersonal.setEmpleados(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion());
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setStatus("G");
        accionPersonal.setDepartamentos(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getDepartamentos());
        accionPersonal.setFechaInicial(fechaInicial);
        accionPersonal.setFechaFinal(fechaInicial);
        accionPersonal.setPuestos(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        getEncabezadoSolicitud().setListaSolicitudes(planillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        planillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }
    
    @Override
    boolean validarSolicitud() {
        Boolean error = Boolean.FALSE;
        
        if (tipoAccionSeleccionada == null || tipoAccionSeleccionada.equals(new Short("-1"))) {
            addMessage("Acciones de Personal", "Seleccione un tipo de Acción.", TipoMensaje.ERROR);
            return Boolean.TRUE;
        }
        
        if (fechaInicial == null) {
            addMessage("Acciones de Personal", "Fecha Inicial es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }
        if (fechaFinal == null) {
            addMessage("Acciones de Personal", "Fecha Final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }
        if (fechaInicial != null && fechaFinal != null) {
            if (!validaFechas(fechaInicial, fechaFinal)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicial y final no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
        }
        
        return error;
    }
    
    @Override
    protected void limpiarCampos() {
        setFechaInicial(null);
        setFechaFinal(null);
        setTipoAccionSeleccionada(new Short("-1"));
        setObservacion("");
    }
}
