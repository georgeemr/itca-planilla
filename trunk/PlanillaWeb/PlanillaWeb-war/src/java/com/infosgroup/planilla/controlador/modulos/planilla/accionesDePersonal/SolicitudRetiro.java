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
public class SolicitudRetiro extends SolicitudDePersonal implements java.io.Serializable {

    private java.util.List<CausasRenuncia> listaCausasRenuncia;
    private Short tipoRenuncia;
    private java.util.Date fechaRetiro;
    private Short tipoPlanilla;
    private String observacion;
    private Short accion;
    private List<TipoAccion> listaTipoAccion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<TipoAccion> getListaTipoAccion() {
        listaTipoAccion = planillaSessionBean().listaTipoAccionRetiro( getEncabezadoSolicitud().getSessionBeanADM().getCompania());
        return listaTipoAccion;
    }

    public void setListaTipoAccion(List<TipoAccion> listaTipoAccion) {
        this.listaTipoAccion = listaTipoAccion;
    }

    public SolicitudRetiro(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Short getTipoRenuncia() {
        return tipoRenuncia;
    }

    public void setTipoRenuncia(Short tipoRenuncia) {
        this.tipoRenuncia = tipoRenuncia;
    }

    public List<CausasRenuncia> getListaCausasRenuncia() {
        listaCausasRenuncia = planillaSessionBean().findCausasRenunciasByCias(getEncabezadoSolicitud().getSessionBeanADM().getCompania());
        return listaCausasRenuncia;
    }

    public void setListaCausasRenuncia(List<CausasRenuncia> listaCausasRenuncia) {
        this.listaCausasRenuncia = listaCausasRenuncia;
    }

    public Short getAccion() {
        return accion;
    }

    public void setAccion(Short accion) {
        this.accion = accion;
    }

    public String guardarSolicitud$action() {
        if (validarSolicitud()) {
            return null;
        }
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getEncabezadoSolicitud().getSessionBeanADM().getCompania()));
        accionPersonal.setTipoAccion(new TipoAccion(new TipoAccionPK(getEncabezadoSolicitud().getSessionBeanADM().getCompania().getCodCia(), accion)));
        accionPersonal.setEmpleados(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion());
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setDepartamentos(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getDepartamentos());
        accionPersonal.setCausasRenuncia(new CausasRenuncia(new CausasRenunciaPK(getEncabezadoSolicitud().getEmpresa(), tipoRenuncia)));
        accionPersonal.setStatus("G");
        accionPersonal.setFechaInicial(fechaRetiro);
        accionPersonal.setCodTipopla(tipoPlanilla);
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
        if (fechaRetiro == null) {
            addMessage("Acciones de Personal", "Fecha de retiro es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }
        
        if (accion == null || accion == -1) {
            addMessage("Acciones de Personal", "Tipo de Acción campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (tipoRenuncia == null || tipoRenuncia == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el motivo de retiro.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (tipoPlanilla == null || tipoPlanilla == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }
        return error;
    }

    @Override
    protected void limpiarCampos() {
        setTipoRenuncia(new Short("-1"));
        setFechaRetiro(null);
        setTipoPlanilla(new Short("-1"));
        setObservacion("");
        setAccion(new Short("-1"));
    }
}
