/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.facades.CiasFacade;
import com.infosgroup.planilla.modelo.facades.ParamPlanFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "SessionBeanADM")
@SessionScoped
public class SessionBeanADM implements Serializable {

    @EJB
    private CiasFacade companiaFacade;
    @EJB
    private ParamPlanFacade paramPlanFacade;
    private Integer estadoAccion;

    /**
     * Creates a new instance of SessionBeanADM
     */
    public SessionBeanADM() {
    }

    public Cias getCompania() {
        return companiaFacade.find(new Short("1"));
    }

    public /*Integer*/ Empleados getRepresentantePatronal() {
        return paramPlanFacade.find(getCompania().getCodCia()).getEmpleados()/*.getEmpleadosPK().getCodEmp()*/;
    }

    public Integer getEstadoAccion() {
        return estadoAccion;
    }

    /**
     *
     * @param estadoAccion 0 - crear 1 - editar 2 - consultar
     */
    public void setEstadoAccion(Integer estadoAccion) {
        this.estadoAccion = estadoAccion;
    }
}
