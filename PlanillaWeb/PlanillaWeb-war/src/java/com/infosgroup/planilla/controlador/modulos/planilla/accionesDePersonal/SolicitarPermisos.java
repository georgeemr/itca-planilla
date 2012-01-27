/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.view.TipoMensaje;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "accionesPersonal$solicitarPermisos")
@ViewScoped
public class SolicitarPermisos extends SolicitudDePersonal implements java.io.Serializable {

    public SolicitarPermisos() {
    }

    public String guardarSolicitud$action() {
        addMessage("Solicitar Permisos", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
        return null;
    }

    @PostConstruct
    public void _init() {
    }

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean validarSolicitud() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
