/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.controlador.sessionbean.SessionBeanADM;
import com.infosgroup.planilla.controlador.sessionbean.SessionBeanREC;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
public abstract class JSFUtil {

    public JSFUtil() {
    }

    public void addMessage(String titulo, String mensaje, TipoMensaje tipoMensaje) {

        switch (tipoMensaje) {
            case INFORMACION:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje));
                break;
            case ADVERTENCIA:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensaje));
                break;
            case ERROR:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensaje));
                break;
            case ERROR_FATAL:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensaje));
                break;
        }
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

    protected static SessionBeanADM getSessionBeanADM() {
        return (SessionBeanADM) getBean("SessionBeanADM");
    }

    protected static SessionBeanREC getSessionBeanREC() {
        return (SessionBeanREC) getBean("SessionBeanREC");
    }

    public boolean validaFechas(Date f1, Date f2) {
        return !f1.after(f2);
    }

    public String inicio$action() {
        return "/modulos/inicio.xhtml?faces-redirect=true";
    }
}
