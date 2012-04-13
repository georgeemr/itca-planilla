/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public abstract class AbstractEditAccionPersonal extends AbstractJSFPage implements java.io.Serializable {

    public final long MILISEGUNDOS_POR_DIA = 24 * 60 * 60 * 1000;
    public Logger looger = Logger.getLogger(AbstractEditAccionPersonal.class.getPackage().getName());
    
    public Integer calculaDias(java.util.Date f1, java.util.Date f2) {
        if (f1 != null && f2 != null) {
            Long d = ((f2.getTime() - f1.getTime()) / MILISEGUNDOS_POR_DIA) + 1L;
            return d.intValue();
        } else {
            return 0;
        }
    }

    public String regresar() {
        limpiarCampos();
        return "./../accionesPersonal.xhtml?faces-redirect=true";
    }

    public abstract void actualizarSolicitud(AccionPersonal a) throws Exception;
    public abstract boolean validarSolicitud();
}
