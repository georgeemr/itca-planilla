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
@ManagedBean(name="solicitudConstanciaSueldo")
@ViewScoped
public class SolicitudConstanciaSueldo extends SolicitudDePersonal implements java.io.Serializable {

    public String guardarSolicitud$action() {
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getSessionBeanADM().getCompania(), getEmpleadosToAccionPersonal()));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getEmpleadosToAccionPersonal());
        accionPersonal.setEmpleados1( getEmpleadosToAccionPersonal().getEmpleados() );
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setDepartamentos(getEmpleadosToAccionPersonal().getDepartamentos());
        accionPersonal = getEstadoSolicitudByRol(accionPersonal); //accionPersonal.setStatus("G");
        accionPersonal.setUsuarioCreacion(getSessionBeanEMP().getEmpleadoSesion().getUsuario() );
        accionPersonal.setPuestos(getEmpleadosToAccionPersonal().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        //getEncabezadoSolicitud().setListaSolicitudes(getPlanillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        //getPlanillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }
    
    @Override
    boolean validarSolicitud() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void limpiarCampos() {
        setObservacion("");
    }
}
