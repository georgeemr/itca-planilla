/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.SolicitudDePersonal;
import com.infosgroup.planilla.controlador.sessionbean.*;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.estructuras.DetalleAdjuntoCorreo;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

/**
 *
 * @author root
 */
public abstract class AbstractJSFPage implements java.io.Serializable {

    public static final Logger logger = Logger.getLogger(AbstractJSFPage.class.getPackage().getName());
    public final long MILISEGUNDOS_POR_DIA = 24 * 60 * 60 * 1000;

    public AbstractJSFPage() {
    }

    public void addMessage(String titulo, String mensaje, TipoMensaje tipoMensaje) {
        FacesMessage.Severity severidad = null;
        switch (tipoMensaje) {
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

    protected boolean validaFechas(Date f1, Date f2) {
        return !f1.after(f2);
    }

    protected abstract void limpiarCampos();

    protected enum EstadoAccion {

        CREANDO,
        MODIFICANDO
    }

    public static void mostrarMensaje(FacesMessage.Severity severidad, String textoMensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, "Planilla web", textoMensaje));
    }
    @ManagedProperty(value = "#{SessionBeanADM}")
    protected SessionBeanADM sessionBeanADM;
    @ManagedProperty(value = "#{SessionBeanREC}")
    protected SessionBeanREC sessionBeanREC;
    @ManagedProperty(value = "#{SessionBeanEMP}")
    protected SessionBeanEMP sessionBeanEMP;
    @ManagedProperty(value = "#{SessionBeanPLA}")
    protected SessionBeanPLA sessionBeanPLA;
    @ManagedProperty(value = "#{SessionBeanCAP}")
    protected SessionBeanCAP sessionBeanCAP;

    public SessionBeanCAP getSessionBeanCAP() {
        return sessionBeanCAP;
    }

    public void setSessionBeanCAP(SessionBeanCAP sessionBeanCAP) {
        this.sessionBeanCAP = sessionBeanCAP;
    }

    public SessionBeanADM getSessionBeanADM() {
        return sessionBeanADM;
    }

    public void setSessionBeanADM(SessionBeanADM sessionBeanADM) {
        this.sessionBeanADM = sessionBeanADM;
    }

    public SessionBeanREC getSessionBeanREC() {
        return sessionBeanREC;
    }

    public void setSessionBeanREC(SessionBeanREC sessionBeanREC) {
        this.sessionBeanREC = sessionBeanREC;
    }

    public SessionBeanEMP getSessionBeanEMP() {
        return sessionBeanEMP;
    }

    public void setSessionBeanEMP(SessionBeanEMP sessionBeanEMP) {
        this.sessionBeanEMP = sessionBeanEMP;
    }

    public SessionBeanPLA getSessionBeanPLA() {
        return sessionBeanPLA;
    }

    public void setSessionBeanPLA(SessionBeanPLA sessionBeanPLA) {
        this.sessionBeanPLA = sessionBeanPLA;
    }

    public String inicio$action() {
        return "/modulos/inicio.xhtml?faces-redirect=true";
    }

    public String cerrarSesion$action() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/modulos/inicio.xhtml?faces-redirect=true";
    }

    public boolean isInRole(String rol) {
        return FacesContext.getCurrentInstance().getExternalContext().isUserInRole(rol);
    }

    public Integer calculaDias(java.util.Date f1, java.util.Date f2) {
        if (f1 != null && f2 != null) {
            Long d = ((f2.getTime() - f1.getTime()) / MILISEGUNDOS_POR_DIA) + 1L;
            return d.intValue();
        } else {
            return 0;
        }
    }

    @EJB
    private MailStatelessBean mailStatelessBean;
        
    public boolean enviarCorreoAccionPersonal(AccionPersonal accionPersonal, String mensaje) {
        if (accionPersonal.getEmpleados().getCorreo() == null) {
            return false;
        }
        byte[] bytesImagen = new byte[(int) getImage("infosgroup.png").length()];
        try {
            ImageIO.createImageInputStream(getImage("infosgroup.png")).read(bytesImagen);
        } catch (IOException ex) {
            Logger.getLogger(SolicitudDePersonal.class.getName()).log(Level.SEVERE, null, ex);
        }

        DetalleAdjuntoCorreo detalleAdjunto = new DetalleAdjuntoCorreo("infosgroup.png", "image/png", bytesImagen);
        List<DetalleAdjuntoCorreo> adjuntos = new ArrayList<DetalleAdjuntoCorreo>();
        adjuntos.add(detalleAdjunto);
        mailStatelessBean.enviarCorreoElectronicoAdjuntos("Acciones de Personal - " + accionPersonal.getTipoAccion().getNomTipoaccion(), mensaje, accionPersonal.getEmpleados().getCorreo(), adjuntos);
        return Boolean.TRUE;
    }

    public static File getImage(String archivo) {
        File f;
        String r = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/");
        String ruta = r + "resources" + java.io.File.separator + "imagenes" + java.io.File.separator + archivo;
        f = new File(ruta);
        return f;
    }
}
