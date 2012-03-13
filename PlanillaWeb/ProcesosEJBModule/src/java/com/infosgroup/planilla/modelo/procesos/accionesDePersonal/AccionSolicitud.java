package com.infosgroup.planilla.modelo.procesos.accionesDePersonal;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;

/**
 *
 * @author root
 */
public abstract class AccionSolicitud implements java.io.Serializable {

    public abstract void efectuar(AccionPersonal accionPersonal);

    protected abstract PlanillaSessionBean getSessionBeanPlanilla();
}
