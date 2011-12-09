/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
*
* @author root
*/
@ManagedBean(name = "SessionBeanEMP")
@SessionScoped
public class SessionBeanEMP
{
@EJB
private EmpleadosSessionBean empleadosBean;

private Empleado empleadoSesion;

public Empleado getEmpleadoSesion()
{
return empleadoSesion;
}

public void setEmpleadoSesion(Empleado empleadoSesion)
{
this.empleadoSesion = empleadoSesion;
}

@PostConstruct
public void postConstruct()
{
empleadoSesion = (FacesContext.getCurrentInstance().getExternalContext().getRemoteUser() != null) ? empleadosBean.buscarEmpleadoPorUsuario(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser()) : null;
}
}
