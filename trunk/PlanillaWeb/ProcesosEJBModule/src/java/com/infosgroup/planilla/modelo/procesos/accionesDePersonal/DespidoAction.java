/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos.accionesDePersonal;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;

/**
 *
 * @author root
 */
public class DespidoAction extends AccionSolicitud implements java.io.Serializable {

    public DespidoAction(AccionPersonal accionPersonal) {
        super(accionPersonal);
    }

    @Override
    public void efectuar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}