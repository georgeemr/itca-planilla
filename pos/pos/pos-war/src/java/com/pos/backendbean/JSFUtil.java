/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.backendbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Soporte
 */
public class JSFUtil {

    public static Object getBean(String nombreBean) {
        Object o = null;
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            javax.el.ELContext elContext = facesContext.getELContext();
            javax.el.ExpressionFactory ef = facesContext.getApplication().getExpressionFactory();
            javax.el.ValueExpression ve = ef.createValueExpression(elContext, "#{" + nombreBean + "}", Object.class);
            o = ve.getValue(elContext);
        } catch (Exception excpt) {
            excpt.printStackTrace();
        }
        return o;
    }

    public HttpSession getSesion() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getSession();
    }

    public static void addMensaje(String titulo, String mensaje) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje));
    }

    public static void addInfo(String titulo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje));
    }

    public static void addWarn(String titulo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensaje));
    }

    public static void addError(String titulo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensaje));
    }

    public static void addFatal(String titulo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensaje));
    }
}
