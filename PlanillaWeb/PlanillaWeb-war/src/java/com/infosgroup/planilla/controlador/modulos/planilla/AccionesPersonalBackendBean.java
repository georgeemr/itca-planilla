/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author root
 */
@ManagedBean(name = "planilla$accionesPersonal")
@ViewScoped
public class AccionesPersonalBackendBean extends JSFUtil implements Serializable {

    @PostConstruct
    public void init() {
        listaEmp = planillaSessionBean.listaEmpleados();
        listaPlanillas = planillaSessionBean.listarPlanilla();
    }

    @Override
    protected void limpiarCampos() {
        tipoSec = 0;
        empleadoSeleccionado = null;
        jefeSeleccionado = null;
        obsv = null;
        fecha = null;
        planillaSeleccionada = null;
    }
    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<Compania> listaCias;
    private List<Sucursal> listaSucursales;
    private List<AccionPersonal> listaSolicitudes;
    private List<TipoAccion> listaTipo;
    private List<TipoAccion> listaTipoNoAfecta;
    private List<Empleado> listaJefes;
    private List<Empleado> listaEmp;
    private List<TipoPlanilla> listaTipos;
    private List<Planilla> listaPlanillas;
    private long cia = 1;
    private long suc;
    private long tipo;
    private long tipoSec;
    private long dias;
    private DataTable tablaEmpleado;
    private Empleado empleadoSeleccionado;
    private Empleado jefeSeleccionado;
    private Planilla planillaSeleccionada;
    private String obsv;
    private String devengadas;
    private Date fecha;
    private Date fechaInicial;
    private Date fechaFinal;
    private Date periodoFechaInicio;
    private Date periodoFechaFin;
    private Date fechaIngreso;
    private long detAccion;

    public long getDetAccion() {
        return detAccion;
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

    public String getObsv() {
        return obsv;
    }

    public void setObsv(String obsv) {
        this.obsv = obsv;
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

    public Empleado getJefeSeleccionado() {
        return jefeSeleccionado;
    }

    public void setJefeSeleccionado(Empleado jefeSeleccionado) {
        this.jefeSeleccionado = jefeSeleccionado;
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

    public long getTipoSec() {
        return tipoSec;
    }

    public void setTipoSec(long tipoSec) {
        this.tipoSec = tipoSec;
    }

    public long getTipo() {
        return tipo;
    }

    public void setTipo(long tipo) {
        this.tipo = tipo;
    }

    public long getCia() {
        return cia;
    }

    public void setCia(long cia) {
        this.cia = cia;
    }

    public long getDias() {
        if ((fechaInicial != null) && (fechaFinal != null)) {
            dias = (validaFechas(fechaInicial, fechaFinal)) ? fechaFinal.compareTo(fechaInicial) : null;
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
        listaSolicitudes = planillaSessionBean.listarAccionporTipo(cia, tipo);
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<AccionPersonal> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public List<Sucursal> getListaSucursales() {
        listaSucursales = planillaSessionBean.listarSucursal();
        return listaSucursales;
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public List<TipoAccion> getListaTipo() {
        listaTipo = planillaSessionBean.listarTipoAccionAfecta();
        //listaTipo = planillaSessionBean.listarTiposAcciones();
        return listaTipo;
    }

    public void setListaTipo(List<TipoAccion> listaTipo) {
        this.listaTipo = listaTipo;
    }

    public List<TipoAccion> getListaTipoNoAfecta() {
        //listaTipoNoAfecta = planillaSessionBean.listarTipoAccionNoAfecta();
        return listaTipoNoAfecta;
    }

    public void setListaTipoNoAfecta(List<TipoAccion> listaTipoNoAfecta) {
        this.listaTipoNoAfecta = listaTipoNoAfecta;
    }

    public long getSuc() {
        return suc;
    }

    public void setSuc(long suc) {
        this.suc = suc;
    }

    public String consulta$action() {
        listaSolicitudes = planillaSessionBean.listarAccionporTipo(cia, tipo);
        return null;
    }

    public void lstTiposChangeListener(ValueChangeEvent event) {
    }

    public void pruebaListener(AjaxBehaviorEvent evt) {
        // tipo = (Long) evt.getSource();
        if (tipo != 0) {
            listaTipoNoAfecta = planillaSessionBean.listarTipoAccionAfecta();
            detAccion = tipo;
            tipoSec = tipo;
        } else {
            listaTipoNoAfecta = planillaSessionBean.listarTipoAccionNoAfecta();
            detAccion = 0;
        }
    }

    public void cmdEmpActionListener(ActionEvent event) {
        sessionBeanPLA.setTbEmp(Boolean.TRUE);
    }

    public void cmdJefeActionListener(ActionEvent event) {
        sessionBeanPLA.setTbJefes(Boolean.TRUE);
    }
    private String nombreEmpleado;

    public String getNombreEmpleado() {
        nombreEmpleado = (empleadoSeleccionado != null) ? empleadoSeleccionado.getNombreCompleto() : "";
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreJefe() {
        nombreJefe = (jefeSeleccionado != null) ? jefeSeleccionado.getNombreCompleto() : "";
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }
    private String nombreJefe;

    public String nuevaAccionNoAfecta$action() {
        TipoAccion tipoAcc = planillaSessionBean.buscarTipoAccion(tipoSec);
        planillaSessionBean.guardarSolAcc$action(tipoAcc, empleadoSeleccionado, jefeSeleccionado, fecha, obsv, null, null, dias, null, fechaFinal, fechaFinal, null, periodoFechaInicio, periodoFechaFin, null, null, planillaSeleccionada);
        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Solicitud de accion guardada exitosamente");
        limpiarCampos();
        listaSolicitudes = planillaSessionBean.listarAccionporTipo(cia, tipo);
        return null;
    }

    public String cancelar$action() {
        limpiarCampos();
        return null;
    }
}
