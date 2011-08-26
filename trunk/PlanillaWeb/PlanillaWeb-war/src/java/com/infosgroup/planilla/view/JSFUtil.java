/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.controlador.sessionbean.SessionBeanADM;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
public abstract class JSFUtil {

    public JSFUtil() {
    }

    public void addInfoMessage(String titulo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje));
    }

    public void addWarnMessage(String titulo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensaje));
    }

    public void addErrorMessage(String titulo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensaje));
    }

    public void addFatalMessage(String titulo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensaje));
    }

    public static Object getBean(String beanName) {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
    }

    protected abstract void limpiarCampos();
    
      protected enum EstadoAccion {
        CREANDO,
        MODIFICANDO
    }

    public static void mostrarMensaje(FacesMessage.Severity severidad, String textoMensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, "Planilla web", textoMensaje));
    }
}
