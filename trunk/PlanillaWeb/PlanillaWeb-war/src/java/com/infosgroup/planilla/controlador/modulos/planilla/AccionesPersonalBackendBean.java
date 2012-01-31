/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.SolicitudPermiso;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "planilla$accionesPersonal")
@ViewScoped
public class AccionesPersonalBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<AccionPersonal> listaSolicitudes;
    private Long tipo;
    private List<TipoAccion> listaTipo;
    private List<TipoAccion> listaTipoNoAfecta;
    private List<Empleado> listaJefes;
    private List<Empleado> listaEmp;
    private List<TipoPlanilla> listaTipos;
    private List<Planilla> listaPlanillas;
    private Long empresa;
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

    public SolicitudPermiso getSolicitudPermiso() {
        return solicitudPermiso;
    }

    public void setSolicitudPermiso(SolicitudPermiso solicitudPermiso) {
        this.solicitudPermiso = solicitudPermiso;
    }

    public AccionesPersonalBackendBean() {}

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
        listaEmp = planillaSessionBean.listaEmpleados();
        listaPlanillas = planillaSessionBean.listarPlanilla();
        listaSolicitudes = planillaSessionBean.findSolicitudesPendientes(getSessionBeanADM().getCompania().getIdCompania());
        empresa = getSessionBeanADM().getCompania().getIdCompania();
        solicitudPermiso = new SolicitudPermiso( this );
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

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Empleado> getListaEmp() {
        return listaEmp;
    }

    public void setListaEmp(List<Empleado> listaEmp) {
        this.listaEmp = listaEmp;
    }

    public List<Empleado> getListaJefes() {
        listaJefes = planillaSessionBean.listarJefes();
        return listaJefes;
    }

    public void setListaJefes(List<Empleado> listaJefes) {
        this.listaJefes = listaJefes;
    }

    public List<TipoPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos();
        return listaTipos;
    }

    public void setListaTipos(List<TipoPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public List<Planilla> getListaPlanillas() {
        listaPlanillas = planillaSessionBean.listarPlanilla();
        return listaPlanillas;
    }

    public void setListaPlanillas(List<Planilla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
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

    public long getEmpresa() {
        return empresa;
    }

    public void setCia(long empresa) {
        this.empresa = empresa;
    }

    public List<AccionPersonal> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<AccionPersonal> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public List<TipoAccion> getListaTipo() {
        listaTipo = planillaSessionBean.listarTipoAccionAfecta();
        return listaTipo;
    }

    public void setListaTipo(List<TipoAccion> listaTipo) {
        this.listaTipo = listaTipo;
    }

    public List<TipoAccion> getListaTipoNoAfecta() {
        return listaTipoNoAfecta;
    }

    public void setListaTipoNoAfecta(List<TipoAccion> listaTipoNoAfecta) {
        this.listaTipoNoAfecta = listaTipoNoAfecta;
    }

    public String consulta$action() {
        listaSolicitudes = planillaSessionBean.listarAccionporTipo(empresa, /*tipoPlanilla*/ tipo);
        return null;
    }

    public void cmdEmpActionListener(ActionEvent event) {
        sessionBeanPLA.setTbEmp(Boolean.TRUE);
    }

    public void cmdJefeActionListener(ActionEvent event) {
        sessionBeanPLA.setTbJefes(Boolean.TRUE);
    }

    public String getNombreJefe() {
        nombreJefe = "Ninguno";
        if (getSessionBeanEMP().getEmpleadoSesion() != null) {
            if (getSessionBeanEMP().getEmpleadoSesion().getEmpleado() != null) {
                nombreJefe = getSessionBeanEMP().getEmpleadoSesion().getEmpleado().getNombreCompleto();
            }
        }
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    public String cancelar$action() {
        limpiarCampos();
        if (solicitudPermiso != null) solicitudPermiso.limpiarCampos() ;
        return null;
    }

    @Override
    protected void limpiarCampos() {
        tipoAccion = 0L;
        observacion = null;
        nombreJefe = "Seleccione un Empleado";
    }

    public void onEditAccionPersonal(RowEditEvent event) {
        try {
            AccionPersonal accionPersonal = (AccionPersonal) event.getObject();
            planillaSessionBean.editAccionPersonal(accionPersonal);
            solicitudPermiso.enviarCorreo(accionPersonal, "Solicitud Procesada.\n\nResultado: Solicitud " + accionPersonal.getAccEstado()
                    + "\n\nAtte. \n\nDepartamento de Recursos Humanos " + getSessionBeanADM().getCompania().getNomCompania());
            addMessage("Evaluacion de Candidato", "Datos Guardados", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Evaluacion de Candidato", "Ocurrio un error al intentar guardar.", TipoMensaje.INFORMACION);
        }
    }
}
