/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
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
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author root
 */
@ManagedBean(name = "planilla$accionesPersonal")
@ViewScoped
public class AccionesPersonalBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    @EJB
    private ReportesStatelessBean reportesStatelessBean;
    private List<AccionPersonal> listaSolicitudes;
    private List<TipoAccion> listaTipo;
    private List<Empleados> listaEmp;
    private Short empresa;
    private Long tipoAccion;
    private Date fecha;
    private String urlPlantilla;
    private String urlPlantillaDefault = "/modulos/planilla/acciones/ninguna.xhtml";
    private TipoAccion accionSeleccionada;
    private String solicitudesMostradas;
    private SelectItem[] estados = {new SelectItem("G", "Solicitada"), new SelectItem("A", "Aprobada"), new SelectItem("R", "Rechazada"), new SelectItem("J", "Pre-Aprobada")};
    private Boolean renderReportePagos = Boolean.FALSE;

    public Boolean getRenderReportePagos() {
        renderReportePagos = Boolean.FALSE;
        if (getSessionBeanPLA().getAccionSeleccionada() != null) {
            if (getSessionBeanPLA().getAccionSeleccionada().getStatus().equals("A") && getSessionBeanPLA().getAccionSeleccionada().getfApruebaRh()!=null) {
                if (getSessionBeanPLA().getAccionSeleccionada().getAccionPersonalPK().getCodTipoaccion().equals(new Short("20"))) {
                    renderReportePagos = Boolean.TRUE;
                }
            }
        }
        return renderReportePagos;
    }

    public void setRenderReportePagos(Boolean renderReportePagos) {
        this.renderReportePagos = renderReportePagos;
    }

    public SelectItem[] getEstados() {
        return estados;
    }

    public void setEstados(SelectItem[] estados) {
        this.estados = estados;
    }

    public AccionesPersonalBackendBean() {
    }

    public void seleccionarAccion(AjaxBehaviorEvent event) {
        accionSeleccionada = planillaSessionBean.buscarTipoAccion(empresa, getSessionBeanEMP().getTipo());       
        urlPlantilla = accionSeleccionada != null ? accionSeleccionada.getUrlPlantilla() : null;
        getSessionBeanEMP().setEmpleadoAccionPersonal(getSessionBeanEMP().getEmpleadoSesion());
    }

    @PostConstruct
    public void init() {
        if (isInRole("rrhh")) {
            setListaSolicitudes( planillaSessionBean.findSolicitudesByRRHH(getSessionBeanEMP().getEmpleadoSesion()));
            setListaEmp( planillaSessionBean.listaEmpleados(getSessionBeanADM().getCompania()) );
        } else if (isInRole("jefes")) {
            setListaSolicitudes(planillaSessionBean.findSolicitudesByJefe(getSessionBeanEMP().getEmpleadoSesion()));
            setListaEmp( planillaSessionBean.findEmpleadosByJefe(getSessionBeanEMP().getEmpleadoSesion()) );
        } else if (isInRole("empleados")) {
            setListaSolicitudes( planillaSessionBean.findSolicitudesByEmpleado(getSessionBeanEMP().getEmpleadoSesion()));
            setListaEmp(new ArrayList<Empleados>());
        } else {
            setListaSolicitudes( new ArrayList<AccionPersonal>() );
            setListaEmp(new ArrayList<Empleados>());
        }
        getSessionBeanEMP().setTipo(null);
        setEmpresa( getSessionBeanADM().getCompania().getCodCia());
        setSolicitudesMostradas( "E" );
        getSessionBeanEMP().setEmpleadoAccionPersonal(getSessionBeanEMP().getEmpleadoSesion());
        getSessionBeanPLA().setAccionSeleccionada(null);
        listar();
        setFecha( new Date() );
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

    public Long getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(Long tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public Short getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Short empresa) {
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

    public String cancelar$action() {
        limpiarCampos();
        return null;
    }

    public void listarSolicitudes(AjaxBehaviorEvent event) {
        listar();
    }

    public void listar() {
        if (solicitudesMostradas.equals("E")) {
            if (isInRole("rrhh")) {
                listaSolicitudes = planillaSessionBean.findSolicitudesByRRHH(getSessionBeanEMP().getEmpleadoSesion());
            } else if (isInRole("jefes")) {
                listaSolicitudes = planillaSessionBean.findSolicitudesByJefe(getSessionBeanEMP().getEmpleadoSesion());
            }else if (isInRole("empleados")) {
                listaSolicitudes = planillaSessionBean.findSolicitudesByEmpleado(getSessionBeanEMP().getEmpleadoSesion());
            }else {
                listaSolicitudes = new ArrayList<AccionPersonal>();
            }
        } else {
            listaSolicitudes = planillaSessionBean.findSolicitudesByEmpleado(getSessionBeanEMP().getEmpleadoSesion());
        }
    }

    public String seleccionarEmpleado() {
        addMessage("Acciones de Personal", "Empleado seleccionado " + getSessionBeanEMP().getEmpleadoAccionPersonal().getNombreCompleto(), TipoMensaje.INFORMACION);
        return null;
    }

    public String cancelSeleccionarEmpleado() {
        getSessionBeanEMP().setEmpleadoAccionPersonal(getSessionBeanEMP().getEmpleadoSesion());
        return null;
    }

    public String navigateAprobarAction() {
        if (getSessionBeanPLA().getAccionSeleccionada() == null) {
            addMessage("Acciones de Personal", "Seleccione una Acción para aprobar.", TipoMensaje.ERROR);
            return null;
        }
        return "acciones/aprobarSolicitud?faces-redirect=true";
    }

    public String navigateEditAction() {
        if (getSessionBeanPLA().getAccionSeleccionada() == null) {
            addMessage("Acciones de Personal", "Seleccione una Acción para editar.", TipoMensaje.ERROR);
            return null;
        }
        switch (getSessionBeanPLA().getAccionSeleccionada().getAccionPersonalPK().getCodTipoaccion()) {
            case 1:
                return "acciones/vacacionesAnuales?faces-redirect=true";
            case 2:
                return "acciones/diaDeVacacion?faces-redirect=true";
            case 4:
                return "acciones/incapacidad?faces-redirect=true";
            case 5:
                return "acciones/permisos?faces-redirect=true";
            case 6:
                return "acciones/nombramiento?faces-redirect=true";
            case 7:
                return "acciones/aumentoSueldo?faces-redirect=true";
            case 8:
                return "acciones/noAfectaPlanilla?faces-redirect=true";
            case 9:
                return "acciones/noAfectaPlanilla?faces-redirect=true";
            case 10:
                return "acciones/retiro?faces-redirect=true";
            case 15:
                return "acciones/retiro?faces-redirect=true";
            case 20:
                return "acciones/constanciaDeSueldo?faces-redirect=true";
            default:
                return null;
        }
    }

    public String imprimirConstancia() {
        if (getSessionBeanPLA().getAccionSeleccionada() == null) {
            addMessage("Reclutamiento y Selección", "No ha seleccionado ninguna acción.", TipoMensaje.ERROR);
            return null;
        }
        reportesStatelessBean.generarConstanciaSueldo(getSessionBeanPLA().getAccionSeleccionada().getEmpleados().getEmpleadosPK());
        return null;
    }

    @Override
    protected void limpiarCampos() {
        tipoAccion = 0L;
    }
}