/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
*
* @author root
*/
@ManagedBean(name = "planilla$accionesPersonal")
@ViewScoped
public class AccionesPersonalBackendBean extends JSFUtil implements Serializable
{
@PostConstruct
public void init()
{
}

@Override
protected void limpiarCampos()
{
}

public String calendario$action()
{
return "calendario?faces-redirect=true";
}
}
