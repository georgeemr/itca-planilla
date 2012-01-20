/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.DetalleAdjuntoCorreo;
import com.infosgroup.planilla.modelo.estructuras.reportes.ReporteEvaluacion;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@ManagedBean(name = "empleados$reporteEvaluacion")
@ViewScoped
public class ReporteEvaluacionBackendBean extends AbstractJSFPage implements Serializable {
    
    @EJB
    private EmpleadosSessionBean empleadosSessionBean;
    @EJB
    private ReportesStatelessBean reportesBean;
    @EJB
    private MailStatelessBean mailBean;

    /** Creates a new instance of SeleccionEvaluacionBackendBean */
    public ReporteEvaluacionBackendBean() {
    }
    private List<Campania> listaCampanias;

    public List<Campania> getListaCampanias() {
        listaCampanias = empleadosSessionBean.findAllByCia( getSessionBeanADM().getCompania().getIdCompania() );
        return listaCampanias;
    }

    public void setListaCampanias(List<Campania> listaCampanias) {
        this.listaCampanias = listaCampanias;
    }
    private List<TipoEvaluacion> listaTiposEvaluacion;

    public List<TipoEvaluacion> getListaTiposEvaluacion() {
//listaTiposEvaluacion = empleadosBean.listarTiposEvaluacion();
        return listaTiposEvaluacion;
    }

    public void setListaTiposEvaluacion(List<TipoEvaluacion> listaTiposEvaluacion) {
        this.listaTiposEvaluacion = listaTiposEvaluacion;
    }
    private List<Evaluacion> listaEvaluaciones;

    public List<Evaluacion> getListaEvaluaciones() {
        listaEvaluaciones = (campaniaSeleccionada != null) ? empleadosSessionBean.listarEvaluacionesAbiertasPorCampania(campaniaSeleccionada) : null;
        return listaEvaluaciones;
    }

    public void setListaEvaluaciones(List<Evaluacion> listaEvaluaciones) {
        this.listaEvaluaciones = listaEvaluaciones;
    }

    public String mostrarEvaluaciones$action() {
        return null;
    }
    private Evaluacion evaluacionSeleccionada;

    public Evaluacion getEvaluacionSeleccionada() {
        return evaluacionSeleccionada;
    }

    public void setEvaluacionSeleccionada(Evaluacion evaluacionSeleccionada) {
        this.evaluacionSeleccionada = evaluacionSeleccionada;
    }

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String seleccionTipoEvaluacion$action() {
        return null;
    }

    @PermitAll
    public String mostrarReporteEvaluacion$action() {
        Evaluacion ev = evaluacionSeleccionada;
        if ( ev == null ){
            addMessage("Reporte de Evalución", "No ha seleccionado ninguna evalución", TipoMensaje.ERROR);
            return null;
        }
        
        List<ReporteEvaluacion> lr = reportesBean.listarReporteEvaluacion(ev);
        reportesBean.generarReporteBean(FacesContext.getCurrentInstance(), new HashMap<String, Object>(), "reporteEvaluacion", lr) ;
        //mailBean.enviarCorreoElectronico("Correo de prueba", "Esta es una prueba de envio de correo electronico via GMail XD", "echopin@infosgroup.com");
        List<DetalleAdjuntoCorreo> listaAdjuntos = new ArrayList<DetalleAdjuntoCorreo>(0);
        //listaAdjuntos.add(new DetalleAdjuntoCorreo("reporteprueba1.pdf", "application/pdf", reportesBean.generarDatosReporteBean(FacesContext.getCurrentInstance(), new HashMap<String, Object>(), "reporteEvaluacion", lr)));
        //listaAdjuntos.add(new DetalleAdjuntoCorreo("reporteprueba2.pdf", "application/pdf", reportesBean.generarDatosReporteBean(FacesContext.getCurrentInstance(), new HashMap<String, Object>(), "reporteEvaluacion", lr)));

        String destinatarios = "echopin@infosgroup.com:vmercado@infosgroup.com:gsalazar@infosgroup.com";
        mailBean.enviarCorreoElectronicoAdjuntos("Correo de prueba", "Prueba de correo con adjuntos", destinatarios, listaAdjuntos);
        //reportesBean.generarReporteBean(FacesContext.getCurrentInstance(), new HashMap<String, Object>(), "reporteEvaluacion", lr);
        return null;
    }

    @PermitAll
    public static List<ReporteEvaluacion> listarReporteEvaluacion() {
        return new ArrayList<ReporteEvaluacion>(10);
    }
    
    private Campania campaniaSeleccionada;

    public Campania getCampaniaSeleccionada() {
        return campaniaSeleccionada;
    }

    public void setCampaniaSeleccionada(Campania campaniaSeleccionada) {
        this.campaniaSeleccionada = campaniaSeleccionada;
    }
    
}
