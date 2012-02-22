/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.SolicitudIncapacidad;
import com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.SolicitudPermiso;
import com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.SolicitudVacacionesAnuales;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author root
 */
@ManagedBean(name = "planilla$accionesPersonal")
@ViewScoped
public class AccionesPersonalBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private DataTable tablaSolicitudes;
    private List<AccionPersonal> listaSolicitudes;
    private Short tipo;
    private List<TipoAccion> listaTipo;
//    private List<TipoAccion> listaTipoNoAfecta;
    private List<Empleados> listaJefes;
    private List<Empleados> listaEmp;
    private List<TiposPlanilla> listaTipos;
    private Short empresa;
    private Long tipoAccion;
    private DataTable tablaEmpleado;
    private String observacion;
    private Date fecha;
    private String nombreJefe;
    private String urlPlantilla;
    private String urlPlantillaDefault = "/modulos/planilla/acciones/ninguna.xhtml";
    private TipoAccion accionSeleccionada;
    /* Campos de Detalle de Solicitud */
    private SolicitudPermiso solicitudPermiso;
    private SolicitudVacacionesAnuales solicitudVacacionesAnuales;
    private SolicitudIncapacidad solicitudIncapacidad;

    public SolicitudPermiso getSolicitudPermiso() {
        return solicitudPermiso;
    }

    public void setSolicitudPermiso(SolicitudPermiso solicitudPermiso) {
        this.solicitudPermiso = solicitudPermiso;
    }

    public SolicitudVacacionesAnuales getSolicitudVacacionesAnuales() {
        return solicitudVacacionesAnuales;
    }

    public void setSolicitudVacacionesAnuales(SolicitudVacacionesAnuales solicitudVacacionesAnuales) {
        this.solicitudVacacionesAnuales = solicitudVacacionesAnuales;
    }

    public SolicitudIncapacidad getSolicitudIncapacidad() {
        return solicitudIncapacidad;
    }

    public void setSolicitudIncapacidad(SolicitudIncapacidad solicitudIncapacidad) {
        this.solicitudIncapacidad = solicitudIncapacidad;
    }

    public AccionesPersonalBackendBean() {
    }

    public void seleccionarAccion(AjaxBehaviorEvent event) {
        accionSeleccionada = null;
        for (TipoAccion a : listaTipo) {
            if (a.getTipoAccionPK().getCodCia() == empresa && a.getTipoAccionPK().getCodTipoaccion() == tipo) {
                accionSeleccionada = a;
                continue;
            }
        }
        urlPlantilla = accionSeleccionada != null ? accionSeleccionada.getUrlPlantilla() : null;
    }

    @PostConstruct
    public void init() {
        listaEmp = planillaSessionBean.listaEmpleados(getSessionBeanADM().getCompania());
        if (isInRole("rrhh")) {
            listaSolicitudes = planillaSessionBean.findSolicitudesByRRHH(getSessionBeanEMP().getEmpleadoSesion());
        } else if (isInRole("jefes")) {
            listaSolicitudes = planillaSessionBean.findSolicitudesByJefe(getSessionBeanEMP().getEmpleadoSesion());
        } else if (isInRole("empleados")) {
            listaSolicitudes = planillaSessionBean.findSolicitudesByEmpleado(getSessionBeanEMP().getEmpleadoSesion());
        } else {
            listaSolicitudes = new ArrayList<AccionPersonal>();
        }
        listaSolicitudes = planillaSessionBean.getAccionesByRol(getSessionBeanEMP().getEmpleadoSesion());
        empresa = getSessionBeanADM().getCompania().getCodCia();
        solicitudPermiso = new SolicitudPermiso(this);
        solicitudVacacionesAnuales = new SolicitudVacacionesAnuales(this);
        solicitudIncapacidad = new SolicitudIncapacidad(this);
        fecha = new Date();
    }

    public String getUrlPlantilla() {
        if (urlPlantilla == null) {
            urlPlantilla = urlPlantillaDefault;
        }
        return urlPlantilla;
    }

    public void setUrlPlantilla(String urlPlantilla) {
        this.urlPlantilla = urlPlantilla;
    }

    public TipoAccion getAccionSeleccionada() {
        return accionSeleccionada;
    }

    public void setAccionSeleccionada(TipoAccion accionSeleccionada) {
        this.accionSeleccionada = accionSeleccionada;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Empleados> getListaEmp() {
        return listaEmp;
    }

    public void setListaEmp(List<Empleados> listaEmp) {
        this.listaEmp = listaEmp;
    }

    public List<Empleados> getListaJefes() {
        listaJefes = planillaSessionBean.listarJefes();
        return listaJefes;
    }

    public void setListaJefes(List<Empleados> listaJefes) {
        this.listaJefes = listaJefes;
    }

    public List<TiposPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos(getSessionBeanADM().getCompania());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public DataTable getTablaEmpleado() {
        return tablaEmpleado;
    }

    public void setTablaEmpleado(DataTable tablaEmpleado) {
        this.tablaEmpleado = tablaEmpleado;
    }

    public Long getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(Long tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Short getEmpresa() {
        return empresa;
    }

    public void setCia(Short empresa) {
        this.empresa = empresa;
    }

    public List<AccionPersonal> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<AccionPersonal> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public List<TipoAccion> getListaTipo() {
        listaTipo = planillaSessionBean.listarTipoAccionActivas(getSessionBeanADM().getCompania())/*listarTipoAccionAfecta()*/;
        return listaTipo;
    }

    public void setListaTipo(List<TipoAccion> listaTipo) {
        this.listaTipo = listaTipo;
    }

//    public List<TipoAccion> getListaTipoNoAfecta() {
//        return listaTipoNoAfecta;
//    }
//
//    public void setListaTipoNoAfecta(List<TipoAccion> listaTipoNoAfecta) {
//        this.listaTipoNoAfecta = listaTipoNoAfecta;
//    }

    public String consulta$action() {
        listaSolicitudes = planillaSessionBean.getAccionesByRol(getSessionBeanEMP().getEmpleadoSesion());
        return null;
    }

//    public void cmdEmpActionListener(ActionEvent event) {
//        sessionBeanPLA.setTbEmp(Boolean.TRUE);
//    }
//
//    public void cmdJefeActionListener(ActionEvent event) {
//        sessionBeanPLA.setTbJefes(Boolean.TRUE);
//    }

    public String getNombreJefe() {
        nombreJefe = "Ninguno";
        if (getSessionBeanEMP().getEmpleadoSesion() != null) {
            if (getSessionBeanEMP().getEmpleadoSesion().getEmpleados()/*getJefe()*/ != null) {
                nombreJefe = getSessionBeanEMP().getEmpleadoSesion().getEmpleados()/*getJefe()*/.getNombreCompleto();
            }
        }
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    public String cancelar$action() {
        limpiarCampos();
        if (solicitudPermiso != null) {
            solicitudPermiso.limpiarCampos();
        }
        return null;
    }

    public DataTable getTablaSolicitudes() {
        return tablaSolicitudes;
    }

    public void setTablaSolicitudes(DataTable tablaSolicitudes) {
        this.tablaSolicitudes = tablaSolicitudes;
    }

    @Override
    protected void limpiarCampos() {
        tipoAccion = 0L;
        observacion = null;
        nombreJefe = "Seleccione un Empleado";
    }
}
