/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name="solicitudRetiro")
@ViewScoped
public class SolicitudRetiro extends SolicitudDePersonal implements java.io.Serializable {

    private java.util.List<CausasRenuncia> listaCausasRenuncia;
    private Short tipoRenuncia;
    private java.util.Date fechaRetiro;
    private Short accion;
    private List<TipoAccion> listaTipoAccion;

    public List<TipoAccion> getListaTipoAccion() {
        listaTipoAccion = getPlanillaSessionBean().listaTipoAccionRetiro( getSessionBeanADM().getCompania());
        return listaTipoAccion;
    }

    public void setListaTipoAccion(List<TipoAccion> listaTipoAccion) {
        this.listaTipoAccion = listaTipoAccion;
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
        listaCausasRenuncia = getPlanillaSessionBean().findCausasRenunciasByCias(getSessionBeanADM().getCompania());
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
        if (validarSolicitud()) return null;
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getSessionBeanADM().getCompania(), new TipoAccion(new TipoAccionPK(getSessionBeanADM().getCompania().getCodCia(), accion)),getEmpleadosToAccionPersonal()));
        accionPersonal.setTipoAccion(new TipoAccion(new TipoAccionPK(getSessionBeanADM().getCompania().getCodCia(), accion)));
        accionPersonal.setEmpleados(getEmpleadosToAccionPersonal());
        accionPersonal.setEmpleados1( getEmpleadosToAccionPersonal().getEmpleados() );
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setDepartamentos(getEmpleadosToAccionPersonal().getDepartamentos());
        accionPersonal.setCausasRenuncia(new CausasRenuncia(new CausasRenunciaPK(getSessionBeanADM().getCompania().getCodCia(), tipoRenuncia)));
        accionPersonal = getEstadoSolicitudByRol(accionPersonal);//accionPersonal.setStatus("G");
        accionPersonal.setUsuarioCreacion( getSessionBeanEMP().getEmpleadoSesion().getUsuario() );
        accionPersonal.setFechaInicial(fechaRetiro);
        accionPersonal.setCodTipopla(getTipoPlanilla());
        accionPersonal.setPuestos(getEmpleadosToAccionPersonal().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        //getEncabezadoSolicitud().setListaSolicitudes(getPlanillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        //getPlanillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }

    @Override
    public boolean validarSolicitud() {
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

        if (getTipoPlanilla() == null || getTipoPlanilla() == -1) {
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
