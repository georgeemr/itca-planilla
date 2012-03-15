/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.*;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
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
    private List<Empleados> listaEmp;
    private List<TiposPlanilla> listaTipos;
    private Short empresa;
    private Long tipoAccion;
    private DataTable tablaEmpleado;
    private Date fecha;
    private String urlPlantilla;
    private String urlPlantillaDefault = "/modulos/planilla/acciones/ninguna.xhtml";
    private TipoAccion accionSeleccionada;
    private String solicitudesMostradas;
    /*
     * Campos de Detalle de Solicitud
     */
    private SolicitudPermiso solicitudPermiso;
    private SolicitudVacacionesAnuales solicitudVacacionesAnuales;
    private SolicitudIncapacidad solicitudIncapacidad;
    private SolicitudNombramiento solicitudNombramiento;
    private SolicitudVacacionColectiva solicitudVacacionColectiva;
    private SolicitudAumentoSueldo solicitudAumentoSueldo;
    private SolicitudAumentoSueldoColectivo solicitudAumentoSueldoColectivo;
    private SolicitudRetiro solicitudRetiro;
    private SolicitudNoAfectaPlanilla solicitudNoAfectaPlanilla;
    private Empleados empleadoAccionPersonal;

    public Empleados getEmpleadoAccionPersonal() {
        if (empleadoAccionPersonal == null) {
           // empleadoAccionPersonal = getSessionBeanEMP().getEmpleadoSesion();
        }
        return empleadoAccionPersonal;
    }

    public void setEmpleadoAccionPersonal(Empleados empleadoAccionPersonal) {
        this.empleadoAccionPersonal = empleadoAccionPersonal;
    }

    public SolicitudNoAfectaPlanilla getSolicitudNoAfectaPlanilla() {
        return solicitudNoAfectaPlanilla;
    }

    public void setSolicitudNoAfectaPlanilla(SolicitudNoAfectaPlanilla solicitudNoAfectaPlanilla) {
        this.solicitudNoAfectaPlanilla = solicitudNoAfectaPlanilla;
    }

    public SolicitudRetiro getSolicitudRetiro() {
        return solicitudRetiro;
    }

    public void setSolicitudRetiro(SolicitudRetiro solicitudRetiro) {
        this.solicitudRetiro = solicitudRetiro;
    }

    public SolicitudAumentoSueldoColectivo getSolicitudAumentoSueldoColectivo() {
        return solicitudAumentoSueldoColectivo;
    }

    public void setSolicitudAumentoSueldoColectivo(SolicitudAumentoSueldoColectivo solicitudAumentoSueldoColectivo) {
        this.solicitudAumentoSueldoColectivo = solicitudAumentoSueldoColectivo;
    }

    public SolicitudAumentoSueldo getSolicitudAumentoSueldo() {
        return solicitudAumentoSueldo;
    }

    public void setSolicitudAumentoSueldo(SolicitudAumentoSueldo solicitudAumentoSueldo) {
        this.solicitudAumentoSueldo = solicitudAumentoSueldo;
    }

    public SolicitudVacacionColectiva getSolicitudVacacionColectiva() {
        return solicitudVacacionColectiva;
    }

    public void setSolicitudVacacionColectiva(SolicitudVacacionColectiva solicitudVacacionColectiva) {
        this.solicitudVacacionColectiva = solicitudVacacionColectiva;
    }

    public SolicitudNombramiento getSolicitudNombramiento() {
        return solicitudNombramiento;
    }

    public void setSolicitudNombramiento(SolicitudNombramiento solicitudNombramiento) {
        this.solicitudNombramiento = solicitudNombramiento;
    }

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
        solicitudPermiso = new SolicitudPermiso(this);
        solicitudVacacionesAnuales = new SolicitudVacacionesAnuales(this);
        solicitudIncapacidad = new SolicitudIncapacidad(this);
        solicitudNombramiento = new SolicitudNombramiento(this);
        solicitudVacacionColectiva = new SolicitudVacacionColectiva(this);
        solicitudAumentoSueldo = new SolicitudAumentoSueldo(this);
        solicitudAumentoSueldoColectivo = new SolicitudAumentoSueldoColectivo(this);
        solicitudRetiro = new SolicitudRetiro(this);
        solicitudNoAfectaPlanilla = new SolicitudNoAfectaPlanilla(this);
        empleadoAccionPersonal = getSessionBeanEMP().getEmpleadoSesion();
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
        //listaSolicitudes = planillaSessionBean.getAccionesByRol(getSessionBeanEMP().getEmpleadoSesion());
        empresa = getSessionBeanADM().getCompania().getCodCia();
        solicitudPermiso = new SolicitudPermiso(this);
        solicitudVacacionesAnuales = new SolicitudVacacionesAnuales(this);
        solicitudIncapacidad = new SolicitudIncapacidad(this);
        solicitudNombramiento = new SolicitudNombramiento(this);
        solicitudVacacionColectiva = new SolicitudVacacionColectiva(this);
        solicitudAumentoSueldo = new SolicitudAumentoSueldo(this);
        solicitudAumentoSueldoColectivo = new SolicitudAumentoSueldoColectivo(this);
        solicitudRetiro = new SolicitudRetiro(this);
        solicitudNoAfectaPlanilla = new SolicitudNoAfectaPlanilla(this);
        solicitudesMostradas = "E";
        empleadoAccionPersonal = getSessionBeanEMP().getEmpleadoSesion();
        getSessionBeanPLA().setAccionSeleccionada(null);
        fecha = new Date();
    }

    public String getSolicitudesMostradas() {
        return solicitudesMostradas;
    }

    public void setSolicitudesMostradas(String solicitudesMostradas) {
        this.solicitudesMostradas = solicitudesMostradas;
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
        if (isInRole("rrhh")) {
            listaTipo = planillaSessionBean.listarTipoAccionAfectaPlanilla(getSessionBeanADM().getCompania(), "rrhh");
        } else if (isInRole("jefes")) {
            listaTipo = planillaSessionBean.listarTipoAccionAfectaPlanilla(getSessionBeanADM().getCompania(), "jefes");
        } else if (isInRole("empleados")) {
            listaTipo = planillaSessionBean.listarTipoAccionAfectaPlanilla(getSessionBeanADM().getCompania(), "empleados");
        } else {
            listaTipo = new ArrayList<TipoAccion>();
        }
        return listaTipo;
    }

    public void setListaTipo(List<TipoAccion> listaTipo) {
        this.listaTipo = listaTipo;
    }

    public String consulta$action() {
        listaSolicitudes = planillaSessionBean.getAccionesByRol(getSessionBeanEMP().getEmpleadoSesion());
        return null;
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

    public void listarSolicitudes(ValueChangeEvent event) {
        if (solicitudesMostradas.equals("E")) {
            listaSolicitudes = planillaSessionBean.findSolicitudesByEmpleado(getSessionBeanEMP().getEmpleadoSesion());
        } else {
            if (isInRole("rrhh")) {
                listaSolicitudes = planillaSessionBean.findSolicitudesByRRHH(getSessionBeanEMP().getEmpleadoSesion());
            } else if (isInRole("jefes")) {
                listaSolicitudes = planillaSessionBean.findSolicitudesByJefe(getSessionBeanEMP().getEmpleadoSesion());
            }
        }
    }

    public String seleccionarEmpleado() {
        addMessage("Acciones de Personal", "Empleado seleccionado " + empleadoAccionPersonal.getNombreCompleto(), TipoMensaje.INFORMACION);
        return null;
    }

    public String cancelSeleccionarEmpleado() {
        setEmpleadoAccionPersonal(getSessionBeanEMP().getEmpleadoSesion());
        return null;
    }

    @Override
    protected void limpiarCampos() {
        tipoAccion = 0L;
    }
}
