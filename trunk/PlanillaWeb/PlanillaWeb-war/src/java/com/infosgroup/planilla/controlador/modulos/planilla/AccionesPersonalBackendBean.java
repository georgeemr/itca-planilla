/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
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
    }

    @Override
    protected void limpiarCampos() {
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
    long cia = 1;
    long suc;
    long tipo;
    long tipoSec;
    private DataTable tablaEmpleado;
    private Empleado empleadoSeleccionado;
    private Empleado jefeSeleccionado;

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
        listaTipoNoAfecta = planillaSessionBean.listarTipoAccionNoAfecta();
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

    public void cmdEmpActionListener(ActionEvent event) {
        sessionBeanPLA.setTbEmp(Boolean.TRUE);
    }

    public void cmdJefeActionListener(ActionEvent event) {
        sessionBeanPLA.setTbJefes(Boolean.TRUE);
    }

    private String nombreEmpleado;

    public String getNombreEmpleado() {
        nombreEmpleado = (empleadoSeleccionado != null) ? empleadoSeleccionado.getNombreCompleto() : "" ;
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreJefe() {
        nombreJefe = (jefeSeleccionado != null) ? jefeSeleccionado.getNombreCompleto() : "" ;
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }
    
    private String nombreJefe ;
    
    
}
