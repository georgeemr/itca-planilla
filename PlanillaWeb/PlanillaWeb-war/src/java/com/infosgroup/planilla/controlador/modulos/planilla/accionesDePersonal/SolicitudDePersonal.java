/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;

/**
 *
 * @author root
 */
public interface SolicitudDePersonal {

    void guardarSolicitud(AccionPersonal accionPersonal);

    boolean validarSolicitud();
    
    AccionesPersonalBackendBean getEncabezadoSolicitud();
}
