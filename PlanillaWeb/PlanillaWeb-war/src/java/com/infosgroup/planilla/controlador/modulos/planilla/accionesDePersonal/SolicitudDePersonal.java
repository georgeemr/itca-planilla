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
import com.infosgroup.planilla.modelo.facades.AccionPersonalFacade;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Gabriel Bran
 */
public abstract class SolicitudDePersonal extends AbstractJSFPage implements java.io.Serializable {

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
            nuevaPK.setCodCia(planilla.getPlanillaPK().getIdCompania());
            nuevaPK.setAnio(planilla.getPlanillaPK().getAnio());
            nuevaPK.setMes(planilla.getPlanillaPK().getMes());
            nuevaPK.setNumPlanilla(planilla.getPlanillaPK().getNumPlanilla());
            nuevaPK.setIdSucursal(encabezadoSolicitud.getSessionBeanEMP().getEmpleadoSesion().getSucursal().getSucursalPK().getIdSucursal());
            nuevaPK.setCodTipoaccion(encabezadoSolicitud.getAccionSeleccionada().getTipoAccionPK().getCodTipoaccion());
            nuevaPK.setIdEmpleado(encabezadoSolicitud.getSessionBeanEMP().getEmpleadoSesion().getEmpleadoPK().getCodEmp());
            nuevaPK.setIdPuesto(encabezadoSolicitud.getSessionBeanEMP().getPuestoEmpleadoSession().getPuesto().getPuestoPK().getCodPuesto());            
            nuevaPK.setIdTipoPuesto(encabezadoSolicitud.getSessionBeanEMP().getPuestoEmpleadoSession().getPuestoEmpleadoPK().getIdTipoPuesto());
            nuevaPK.setCorrelativo(accionPersonalFacade().max(encabezadoSolicitud.getSessionBeanEMP().getEmpleadoSesion().getEmpleadoPK().getCodEmp()));
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

    public boolean enviarCorreo(AccionPersonal accionPersonal) {
        
        String mensaje = "";
        if ( accionPersonal.getEmpleado().getCorreo() == null ) return false;
        mailStatelessBean().enviarCorreoElectronico("Acciones de Personal - " +accionPersonal.getTipoAccion().getNomTipoaccion() , mensaje, accionPersonal.getEmpleado().getCorreo() );
        
                
        return Boolean.FALSE;
    }

    private MailStatelessBean mailStatelessBean() {
        try {
            Context c = new InitialContext();
            return (MailStatelessBean) c.lookup("java:global/PlanillaWeb/ProcesosEJBModule/MailStatelessBean!com.infosgroup.planilla.modelo.procesos.MailStatelessBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}