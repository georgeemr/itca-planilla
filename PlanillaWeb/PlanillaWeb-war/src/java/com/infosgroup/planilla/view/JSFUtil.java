/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.controlador.sessionbean.SessionBeanADM;
import com.infosgroup.planilla.controlador.sessionbean.SessionBeanEMP;
import com.infosgroup.planilla.controlador.sessionbean.SessionBeanREC;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
*
* @author root
*/
public abstract class JSFUtil
{
public JSFUtil()
{
}

public void addMessage(String titulo, String mensaje, TipoMensaje tipoMensaje)
{
FacesMessage.Severity severidad = null;
switch (tipoMensaje)
    {
    case INFORMACION:
        severidad = FacesMessage.SEVERITY_INFO;
        break;
    case ADVERTENCIA:
        severidad = FacesMessage.SEVERITY_WARN;
        break;
    case ERROR:
        severidad = FacesMessage.SEVERITY_ERROR;
        break;
    case ERROR_FATAL:
        severidad = FacesMessage.SEVERITY_FATAL;
        break;
    }
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, titulo, mensaje));
}

protected boolean validaFechas(Date f1, Date f2)
{
return !f1.after(f2);
}

protected abstract void limpiarCampos();

protected enum EstadoAccion
{
CREANDO,
MODIFICANDO
}

public static void mostrarMensaje(FacesMessage.Severity severidad, String textoMensaje)
{
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, "Planilla web", textoMensaje));
}

@ManagedProperty(value = "#{SessionBeanADM}")
protected SessionBeanADM sessionBeanADM;

@ManagedProperty(value = "#{SessionBeanREC}")
protected SessionBeanREC sessionBeanREC;

@ManagedProperty(value = "#{SessionBeanEMP}")
protected SessionBeanEMP sessionBeanEMP;

public SessionBeanADM getSessionBeanADM()
{
return sessionBeanADM;
}

public void setSessionBeanADM(SessionBeanADM sessionBeanADM)
{
this.sessionBeanADM = sessionBeanADM;
}

public SessionBeanREC getSessionBeanREC()
{
return sessionBeanREC;
}

public void setSessionBeanREC(SessionBeanREC sessionBeanREC)
{
this.sessionBeanREC = sessionBeanREC;
}

public SessionBeanEMP getSessionBeanEMP()
{
return sessionBeanEMP;
}

public void setSessionBeanEMP(SessionBeanEMP sessionBeanEMP)
{
this.sessionBeanEMP = sessionBeanEMP;
}

// =================================================================================================
public String inicio$action()
{
return "/modulos/inicio.xhtml?faces-redirect=true";
}
}
