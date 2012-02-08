/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.AccionPersonalPK;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.estructuras.DetalleAdjuntoCorreo;
import com.infosgroup.planilla.modelo.facades.AccionPersonalFacade;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

/**
 *
 * @author Gabriel Bran
 */
public abstract class SolicitudDePersonal extends AbstractJSFPage implements java.io.Serializable {

    public static long MILISEGUNDOS_POR_DIA = 24 * 60 * 60 * 1000;
    private AccionesPersonalBackendBean encabezadoSolicitud;

    public AccionesPersonalBackendBean getEncabezadoSolicitud() {
        return encabezadoSolicitud;
    }

    public SolicitudDePersonal(AccionesPersonalBackendBean formularioSolicitud) {
        this.encabezadoSolicitud = formularioSolicitud;
    }

    abstract boolean validarSolicitud();

    public AccionPersonalPK getAccionPersonalPK(Planilla planilla) {
        AccionPersonalPK nuevaPK = new AccionPersonalPK();
        try {
            nuevaPK.setCodCia(planilla.getPlanillaPK().getCodCia());
            nuevaPK.setCodTipoaccion(encabezadoSolicitud.getAccionSeleccionada().getTipoAccionPK().getCodTipoaccion());
            nuevaPK.setCodEmp(encabezadoSolicitud.getSessionBeanEMP().getEmpleadoSesion().getEmpleadosPK().getCodEmp());
            nuevaPK.setCorrelativo(accionPersonalFacade().max(encabezadoSolicitud.getSessionBeanEMP().getEmpleadoSesion().getEmpleadosPK().getCodEmp()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nuevaPK;
    }

    public void guardarAccionPersonal(AccionPersonal accionPersonal) {
        try {
            accionPersonalFacade().create(accionPersonal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TipoAccion getTipoAccion() {
        return planillaSessionBean().buscarTipoAccion(encabezadoSolicitud.getEmpresa(), encabezadoSolicitud.getTipo());
    }

    private AccionPersonalFacade accionPersonalFacade() {
        try {
            Context c = new InitialContext();
            return (AccionPersonalFacade) c.lookup("java:global/PlanillaWeb/PlanillaWeb-ejb/AccionPersonalFacade!com.infosgroup.planilla.modelo.facades.AccionPersonalFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PlanillaSessionBean planillaSessionBean() {
        try {
            Context c = new InitialContext();
            return (PlanillaSessionBean) c.lookup("java:global/PlanillaWeb/ProcesosEJBModule/PlanillaSessionBean!com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public static boolean enviarCorreo(AccionPersonal accionPersonal, String mensaje) {
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
        mailStatelessBean().enviarCorreoElectronicoAdjuntos("Acciones de Personal - " + accionPersonal.getTipoAccion().getNomTipoaccion(), mensaje, accionPersonal.getEmpleados().getCorreo(), adjuntos);
        return Boolean.TRUE;
    }

    public static File getImage(String archivo) {
        File f = null;
        String r = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/");
        String ruta = r + "resources" + java.io.File.separator + "imagenes" + java.io.File.separator + archivo;
        f = new File(ruta);
        return f;
    }

    private static MailStatelessBean mailStatelessBean() {
        try {
            Context c = new InitialContext();
            return (MailStatelessBean) c.lookup("java:global/PlanillaWeb/ProcesosEJBModule/MailStatelessBean!com.infosgroup.planilla.modelo.procesos.MailStatelessBean");
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException(ne);
        }
    }
}