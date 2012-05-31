/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.facades.AccionPersonalFacade;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Gabriel Bran
 */
public abstract class SolicitudDePersonal extends AbstractJSFPage implements java.io.Serializable {

    @ManagedProperty(value="#{planilla$accionesPersonal}")
    protected AccionesPersonalBackendBean accionesPersonalBackendBean;
    //
    @EJB
    private PlanillaSessionBean planillaSessionBean;
    @EJB
    private AccionPersonalFacade accionPersonalFacade;
    //
    private Short tipoPlanilla;
    private String planilla;
    private String observacion;
    private List<ProgramacionPla> listaPlanillas;
    private List<TiposPlanilla> listaTipos;

    public PlanillaSessionBean getPlanillaSessionBean() {
        return planillaSessionBean;
    }

    public AccionesPersonalBackendBean getAccionesPersonalBackendBean() {
        return accionesPersonalBackendBean;
    }

    public void setAccionesPersonalBackendBean(AccionesPersonalBackendBean accionesPersonalBackendBean) {
        this.accionesPersonalBackendBean = accionesPersonalBackendBean;
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            listaPlanillas = getPlanillaSessionBean().getProgramacionPlaByTipo(getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla);
        }
        return listaPlanillas != null ? listaPlanillas : new java.util.ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<TiposPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos(getSessionBeanADM().getCompania());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public abstract boolean validarSolicitud();

    public AccionPersonalPK getAccionPersonalPK(Cias cias) {
        AccionPersonalPK nuevaPK = new AccionPersonalPK();
        try {
            nuevaPK.setCodCia(cias.getCodCia());
            nuevaPK.setCodTipoaccion(getSessionBeanEMP().getAccionSeleccionada().getTipoAccionPK().getCodTipoaccion());
            nuevaPK.setCodEmp(getSessionBeanEMP().getEmpleadoSesion().getEmpleadosPK().getCodEmp());
            nuevaPK.setCorrelativo(accionPersonalFacade.max(cias.getCodCia(), getSessionBeanEMP().getEmpleadoSesion().getEmpleadosPK().getCodEmp()));
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Se desencadeno la siguiente excepcion: ", e);
        }
        return nuevaPK;
    }

    public AccionPersonalPK getAccionPersonalPK(Cias cias, TipoAccion tipoAccion) {
        AccionPersonalPK nuevaPK = new AccionPersonalPK();
        try {
            nuevaPK.setCodCia(cias.getCodCia());
            nuevaPK.setCodTipoaccion(tipoAccion.getTipoAccionPK().getCodTipoaccion());
            nuevaPK.setCodEmp(getSessionBeanEMP().getEmpleadoSesion().getEmpleadosPK().getCodEmp());
            nuevaPK.setCorrelativo(accionPersonalFacade.max(cias.getCodCia(), getSessionBeanEMP().getEmpleadoSesion().getEmpleadosPK().getCodEmp()));
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Se desencadeno la siguiente excepcion: ", e);
        }
        return nuevaPK;
    }

    public AccionPersonalPK getAccionPersonalPK(Cias cias, Empleados e) {
        AccionPersonalPK nuevaPK = new AccionPersonalPK();
        try {
            nuevaPK.setCodCia(cias.getCodCia());
            //nuevaPK.setCodTipoaccion(getSessionBeanEMP().getTipo());
            nuevaPK.setCodTipoaccion(accionesPersonalBackendBean.getTipoAccionPersonal());
            nuevaPK.setCodEmp(e.getEmpleadosPK().getCodEmp());
            nuevaPK.setCorrelativo(accionPersonalFacade.max(cias.getCodCia(), e.getEmpleadosPK().getCodEmp()));
        } catch (Exception exception) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Se desencadeno la siguiente excepcion: ", exception);
        }
        return nuevaPK;
    }

    public AccionPersonalPK getAccionPersonalPK(Cias cias, TipoAccion tipoAccion, Empleados empleado) {
        AccionPersonalPK nuevaPK = new AccionPersonalPK();
        try {
            nuevaPK.setCodCia(cias.getCodCia());
            nuevaPK.setCodTipoaccion(tipoAccion.getTipoAccionPK().getCodTipoaccion());
            nuevaPK.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
            nuevaPK.setCorrelativo(accionPersonalFacade.max(cias.getCodCia(), empleado.getEmpleadosPK().getCodEmp()));
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Se desencadeno la siguiente excepcion: ", e);
        }
        return nuevaPK;
    }

    public void guardarAccionPersonal(AccionPersonal accionPersonal) {
        try {
            accionPersonalFacade.create(accionPersonal);
            if (getAccionesPersonalBackendBean() != null) {
                getAccionesPersonalBackendBean().listar();
            }
            if (isInRole("rrhh")) {//Si quien guarda la solicitud es RRHH implica que esta autorizada y se envia el correo.
                planillaSessionBean.ejecutarAccionSolicitud(accionPersonal);
                enviarCorreoAccionPersonal(accionPersonal, getManifiestoCorreo(AprobarSolicitud.APRUEBA.RECURSOS_HUMANOS, accionPersonal));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Se desencadeno la siguiente excepcion: ", e);
        }
    }

    public TipoAccion getTipoAccion() {
        //return planillaSessionBean.buscarTipoAccion(getSessionBeanADM().getCompania().getCodCia(), getSessionBeanEMP().getTipo());
        return planillaSessionBean.buscarTipoAccion(getSessionBeanADM().getCompania().getCodCia(), accionesPersonalBackendBean.getTipoAccionPersonal());
    }

    public Empleados getEmpleadosToAccionPersonal() {
        //if (getSessionBeanEMP().getEmpleadoAccionPersonal() != null && !getSessionBeanEMP().getEmpleadoAccionPersonal().equals(getSessionBeanEMP().getEmpleadoSesion())) {
        if (accionesPersonalBackendBean.getEmpleadoAccionPersonal() != null && !accionesPersonalBackendBean.getEmpleadoAccionPersonal().equals(getSessionBeanEMP().getEmpleadoSesion())) {        
            //return getSessionBeanEMP().getEmpleadoAccionPersonal();
            return accionesPersonalBackendBean.getEmpleadoAccionPersonal();
            
        } else {
            return getSessionBeanEMP().getEmpleadoSesion();
        }
    }

    public AccionPersonal getEstadoSolicitudByRol(AccionPersonal accionPersonal) {
        accionPersonal.setAprobadoJefe("N");
        accionPersonal.setAprobadoRh("N");
        if (isInRole("rrhh")) {
            if (getTipoAccion().getFirmaJefe() != null && getTipoAccion().getFirmaJefe().equals("S")) {
                accionPersonal.setAprobadoJefe("J");
                accionPersonal.setfApruebaJefe(new Date());
            }
            accionPersonal.setAprobadoRh("A");
            accionPersonal.setfApruebaRh(new Date());
            accionPersonal.setStatus("A");
        } else if (isInRole("jefes")) {
            // Si el jefe registra una Accion a uno de sus colaboradores.
            //if (getSessionBeanEMP().getEmpleadoAccionPersonal() != null && !getSessionBeanEMP().getEmpleadoAccionPersonal().equals(getSessionBeanEMP().getEmpleadoSesion())) {
                if (accionesPersonalBackendBean.getEmpleadoAccionPersonal() != null && !accionesPersonalBackendBean.getEmpleadoAccionPersonal().equals(getSessionBeanEMP().getEmpleadoSesion())) {
                if (getTipoAccion().getFirmaRh() != null && (getTipoAccion().getFirmaRh().equals("S") && (getTipoAccion().getFirmaJefe().equals("S")))) {
                    accionPersonal.setAprobadoJefe("J");
                    accionPersonal.setfApruebaJefe(new Date());
                    accionPersonal.setStatus("J");
                } else if (getTipoAccion().getFirmaRh() != null && (getTipoAccion().getFirmaRh().equals("S") && (getTipoAccion().getFirmaJefe().equals("N")))) {
                    accionPersonal.setStatus("G");
                } else {
                    accionPersonal.setfApruebaJefe(new Date());
                    accionPersonal.setStatus("A");
                }
            } else {
                accionPersonal.setStatus("G");
            }

        } else {
            accionPersonal.setStatus("G");
        }
        return accionPersonal;
    }
}