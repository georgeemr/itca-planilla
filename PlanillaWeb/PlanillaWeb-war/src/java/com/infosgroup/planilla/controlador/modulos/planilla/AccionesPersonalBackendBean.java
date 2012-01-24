/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PlanillaPK;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
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
import javax.faces.event.ValueChangeEvent;
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
    private List<Compania> listaCias;
    private List<AccionPersonal> listaSolicitudes;
    private long tipo;
    private List<TipoAccion> listaTipo;
    private List<TipoAccion> listaTipoNoAfecta;
    private List<Sucursal> listaSucursales;
    private List<Empleado> listaJefes;
    private List<Empleado> listaEmp;
    private List<TipoPlanilla> listaTipos;
    private List<Planilla> listaPlanillas;
    private Long empresa;
    private Long sucursal;
    private Long tipoPlanilla;
    private String planilla;
    private Long tipoAccion;
    private Long dias;
    private DataTable tablaEmpleado;
    private Empleado empleadoSeleccionado;
    private Planilla planillaSeleccionada;
    private String observacion;
    private String devengadas;
    private Date fecha;
    private Date fechaInicial;
    private Date fechaFinal;
    private Date periodoFechaInicio;
    private Date periodoFechaFin;
    private Date fechaIngreso;
    private long detAccion;
    private String nombreEmpleado;
    private String nombreJefe;

    public AccionesPersonalBackendBean() {
    }

    @PostConstruct
    public void init() {
        listaEmp = planillaSessionBean.listaEmpleados();
        listaPlanillas = planillaSessionBean.listarPlanilla();
        listaSolicitudes = planillaSessionBean.findSolicitudesPendientes(getSessionBeanADM().getCompania().getIdCompania())/*planillaSessionBean.listarAccionporTipo(empresa, tipoPlanilla)*/;
        empresa = getSessionBeanADM().getCompania().getIdCompania();
        fecha = new Date();
    }

    public List<Sucursal> getListaSucursales() {
        listaSucursales = planillaSessionBean.listarSucursal();
        return listaSucursales;
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public long getTipo() {
        return tipo;
    }

    public void setTipo(long tipo) {
        this.tipo = tipo;
    }

    public long getDetAccion() {
        return detAccion;
    }

    public Long getSucursal() {
        return sucursal;
    }

    public void setSucursal(Long sucursal) {
        this.sucursal = sucursal;
    }

    public void setDetAccion(long detAccion) {
        this.detAccion = detAccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getPeriodoFechaFin() {
        return periodoFechaFin;
    }

    public void setPeriodoFechaFin(Date periodoFechaFin) {
        this.periodoFechaFin = periodoFechaFin;
    }

    public Date getPeriodoFechaInicio() {
        return periodoFechaInicio;
    }

    public void setPeriodoFechaInicio(Date periodoFechaInicio) {
        this.periodoFechaInicio = periodoFechaInicio;
    }

    public Date getFechaIngreso() {
        fechaIngreso = (empleadoSeleccionado != null) ? empleadoSeleccionado.getFecIngreso() : null;
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDevengadas() {
        return devengadas;
    }

    public void setDevengadas(String devengadas) {
        this.devengadas = devengadas;
    }

    public Empleado getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public Planilla getPlanillaSeleccionada() {
        return planillaSeleccionada;
    }

    public void setPlanillaSeleccionada(Planilla planillaSeleccionada) {
        this.planillaSeleccionada = planillaSeleccionada;
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

    public long getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(long tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public long getEmpresa() {
        return empresa;
    }

    public void setCia(long empresa) {
        this.empresa = empresa;
    }

    public long getDias() {
        if ((fechaInicial != null) && (fechaFinal != null)) {
            dias = new Long((validaFechas(fechaInicial, fechaFinal)) ? fechaFinal.compareTo(fechaInicial) : null);
        }
        return dias;
    }

    public void setDias(long dias) {
        this.dias = dias;
    }

    public List<Compania> getListaCias() {
        listaCias = planillaSessionBean.listarCias();
        return listaCias;
    }

    public void setListaCias(List<Compania> listaCias) {
        this.listaCias = listaCias;
    }

    public List<AccionPersonal> getListaSolicitudes() {
        //listaSolicitudes = planillaSessionBean.listarAccionporTipo(empresa, tipoPlanilla);
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
        listaSolicitudes = planillaSessionBean.listarAccionporTipo(empresa, tipoPlanilla);
        return null;
    }

    public void lstTiposChangeListener(ValueChangeEvent event) {
    }

    public void cmdEmpActionListener(ActionEvent event) {
        sessionBeanPLA.setTbEmp(Boolean.TRUE);
    }

    public void cmdJefeActionListener(ActionEvent event) {
        sessionBeanPLA.setTbJefes(Boolean.TRUE);
    }

    public String getNombreEmpleado() {
        nombreEmpleado = (empleadoSeleccionado != null) ? empleadoSeleccionado.getNombreCompleto() : "";
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public String getNombreJefe() {
        nombreJefe = "Ninguno";
        if (empleadoSeleccionado != null) {
            if (empleadoSeleccionado.getEmpleado() != null) {
                nombreJefe = empleadoSeleccionado.getEmpleado().getNombreCompleto();
            }
        } 
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    public String nuevaAccionNoAfecta$action() {
        if (validaFormulario()) {
            return null;
        }
        TipoAccion tipoAccionSeleccionada = planillaSessionBean.buscarTipoAccion(empresa, tipoAccion);
        planillaSeleccionada = planillaSessionBean.findPlanillaById(new PlanillaPK(planilla));

        planillaSessionBean.guardarSolVacaciones$action(empresa,
                empleadoSeleccionado,
                tipoAccionSeleccionada,
                observacion,
                fechaInicial,
                fechaFinal,
                devengadas,
                planillaSeleccionada);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        limpiarCampos();
        listaSolicitudes = planillaSessionBean.listarAccionporTipo(empresa, tipo);
        return null;
    }

    public Boolean validaFormulario() {
        Boolean error = Boolean.FALSE;

        if (empleadoSeleccionado == null) {
            addMessage("Acciones de Personal", "No ha seleccionado ningún Empleado", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (tipoAccion == null) {
            addMessage("Acciones de Personal", "Tipo de acción es un campo requerido", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (fechaInicial == null) {
            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (fechaFinal == null) {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (fechaInicial != null || fechaFinal != null) {
            if (!validaFechas(fechaInicial, fechaFinal)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicia y Fecha fin no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
        }

        if (tipoPlanilla == null) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (planilla == null) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (empleadoSeleccionado.getPuestoEmpleadoList() == null || empleadoSeleccionado.getPuestoEmpleadoList().isEmpty()) {
            addMessage("Acciones de Personal", "El empleado no tiene asignado ningún puesto.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        return error;
    }

    public String cancelar$action() {
        limpiarCampos();
        return null;
    }

    public void pruebaListener(AjaxBehaviorEvent evt) {
        if (tipo != 0) {
            listaTipoNoAfecta = planillaSessionBean.listarTipoAccionAfecta();
            detAccion = tipo;
            tipoPlanilla = tipo;
        } else {
            listaTipoNoAfecta = planillaSessionBean.listarTipoAccionNoAfecta();
            detAccion = 0;
        }
    }

    @Override
    protected void limpiarCampos() {
        tipoAccion = 0L;
        empleadoSeleccionado = null;
        observacion = null;
        planillaSeleccionada = null;
        fechaInicial = null;
        fechaFinal = null;
        nombreEmpleado = null;
        nombreJefe = "Seleccione un Empleado";
    }

    public void onEditAccionPersonal(RowEditEvent event) {
        try {
            AccionPersonal accionPersonal = (AccionPersonal) event.getObject();
            planillaSessionBean.editAccionPersonal(accionPersonal);
            addMessage("Evaluacion de Candidato", "Datos Guardados", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Evaluacion de Candidato", "Ocurrio un error al intentar guardar.", TipoMensaje.INFORMACION);
        }
    }
}
