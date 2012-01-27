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
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedProperty;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Gabriel Bran
 */
public abstract class SolicitudDePersonal extends AbstractJSFPage implements java.io.Serializable {

    @ManagedProperty(value = "#{planilla$accionesPersonal}")
    private AccionesPersonalBackendBean encabezadoSolicitud;

    abstract boolean validarSolicitud();

    public AccionesPersonalBackendBean getEncabezadoSolicitud() {
        return encabezadoSolicitud;
    }

    public AccionPersonalPK getAccionPersonalPK(Planilla planilla) {
        AccionPersonalPK nuevaPK = new AccionPersonalPK();
        try {
            nuevaPK.setCodCia(planilla.getPlanillaPK().getIdCompania());
            nuevaPK.setAnio(planilla.getPlanillaPK().getAnio());
            nuevaPK.setMes(planilla.getPlanillaPK().getMes());
            nuevaPK.setNumPlanilla(planilla.getPlanillaPK().getNumPlanilla());
            nuevaPK.setIdSucursal(getSessionBeanEMP().getEmpleadoSesion().getSucursal().getSucursalPK().getIdSucursal());
            nuevaPK.setCodTipoaccion(getEncabezadoSolicitud().getAccionSeleccionada().getTipoAccionPK().getCodTipoaccion());
            nuevaPK.setIdEmpleado(getSessionBeanEMP().getEmpleadoSesion().getEmpleadoPK().getCodEmp());
            nuevaPK.setIdPuesto(getSessionBeanEMP().getEmpleadoSesion().getUltimoPuesto().getPuestoPK().getCodPuesto());
            nuevaPK.setIdTipoPuesto(getSessionBeanEMP().getEmpleadoSesion().getUltimoPuesto().getTipoPuesto().getTipoPuestoPK().getCodTipoPuesto());
            nuevaPK.setCorrelativo(accionPersonalFacade().max(getSessionBeanEMP().getEmpleadoSesion().getEmpleadoPK().getCodEmp()));
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
        return planillaSessionBean().buscarTipoAccion(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
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
}