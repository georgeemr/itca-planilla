/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos.accionesDePersonal;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import javax.ejb.EJB;

/**
 *
 * @author root
 */
public class SolicitudPermisoAction extends AccionSolicitud implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean sessionBeanPlanilla;
    
    @Override
    public void efectuar(AccionPersonal accionPersonal) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected PlanillaSessionBean getSessionBeanPlanilla() {
        return sessionBeanPlanilla;
    }
}
