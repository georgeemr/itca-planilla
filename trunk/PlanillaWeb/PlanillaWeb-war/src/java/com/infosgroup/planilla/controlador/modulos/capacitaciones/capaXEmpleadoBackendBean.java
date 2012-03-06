/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.capacitaciones;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleado;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleadoPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.procesos.CapacitacionesSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "capacitaciones$capaXEmpleado")
@ViewScoped
public class capaXEmpleadoBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private CapacitacionesSessionBean capacitacionSessionBean;
    private Boolean isError;
    private String nomCapacitacion;
    private Short inst;
    private Date fechaInicial;
    private Date fechaFinal;
    private String impartido;
    private String status;
    private String nomInst;
    private String nomEmp;
    private String nomArea;
    private String nomTema;
    private String nomCapacitador;
    private BigDecimal notaCapacitacion;
    private List<Capacitacion> listaCap;
    private List<CapacitacionXEmpleado> listaDetalle;
    private List<Empleados> listaEmpleado;
    private BigDecimal nota;
    private DataTable tableCapacitaciones;
    private DataTable tableDetalles;
    private Dialog dialogBuscaEmp;

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
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

    public String getImpartido() {
        return impartido;
    }

    public void setImpartido(String impartido) {
        this.impartido = impartido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getInst() {
        return inst;
    }

    public void setInst(Short inst) {
        this.inst = inst;
    }

    public String getNomInst() {
        return nomInst;
    }

    public void setNomInst(String nomInst) {
        this.nomInst = nomInst;
    }

    public String getNomCapacitacion() {
        return nomCapacitacion;
    }

    public void setNomCapacitacion(String nomCapacitacion) {
        this.nomCapacitacion = nomCapacitacion;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getNomArea() {
        return nomArea;
    }

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
    }

    public String getNomCapacitador() {
        return nomCapacitador;
    }

    public void setNomCapacitador(String nomCapacitador) {
        this.nomCapacitador = nomCapacitador;
    }

    public String getNomTema() {
        return nomTema;
    }

    public void setNomTema(String nomTema) {
        this.nomTema = nomTema;
    }

    public BigDecimal getNotaCapacitacion() {
        return notaCapacitacion;
    }

    public void setNotaCapacitacion(BigDecimal notaCapacitacion) {
        this.notaCapacitacion = notaCapacitacion;
    }

    public List<Capacitacion> getListaCap() {
        listaCap = capacitacionSessionBean.findCapByEmpresa(getSessionBeanADM().getCompania());
        return listaCap;
    }

    public void setListaCap(List<Capacitacion> listaCap) {
        this.listaCap = listaCap;
    }

    public List<CapacitacionXEmpleado> getListaDetalle() {
        //listaDetalle = capacitacionSessionBean.findDetByCap(getSessionBeanADM().getCompania(), getSessionBeanCAP().getCapacitacionSeleccionada());
        return listaDetalle;
    }

    public void setListaDetalle(List<CapacitacionXEmpleado> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public List<Empleados> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleados> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public DataTable getTableCapacitaciones() {
        return tableCapacitaciones;
    }

    public void setTableCapacitaciones(DataTable tableCapacitaciones) {
        this.tableCapacitaciones = tableCapacitaciones;
    }

    public DataTable getTableDetalles() {
        return tableDetalles;
    }

    public void setTableDetalles(DataTable tableDetalles) {
        this.tableDetalles = tableDetalles;
    }

    public Dialog getDialogBuscaEmp() {
        return dialogBuscaEmp;
    }

    public void setDialogBuscaEmp(Dialog dialogBuscaEmp) {
        this.dialogBuscaEmp = dialogBuscaEmp;
    }

    @Override
    protected void limpiarCampos() {
        getSessionBeanCAP().setEmpleadoSeleccionado(null);
        setNota(null);
    }

    public void nuevo$vh$action() {
        setEstadoAccion(2);
    }

    public void consultar$vh$action() {
        setEstadoAccion(0);
        getSessionBeanCAP().setCapacitacionSeleccionada(null);
        setNotaCapacitacion(null);
    }

    public void setEstadoAccion(Integer estadoAccion) {
        getSessionBeanADM().setEstadoAccion(estadoAccion);
        limpiarCampos();
    }

    public void validaCampos$action() {
        if (!validaFechas(fechaInicial, fechaFinal)) {
            addMessage("Mantenimiento de Capacitaciones", "Los rangos de fecha ingresados no son consistentes.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
        }
    }
    
    public void guardar$notaCap$action(){
        isError = false;
        if(notaCapacitacion == null){
            isError = true;
        }
        if(isError)
            return;
        try{
            Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        cap.setNotaCapacitacion(notaCapacitacion);
        capacitacionSessionBean.editarCapacitacion(cap);
        addMessage("Mantenimiento de Detalle de Capacitacion.", "Nota general actualizada con éxito", TipoMensaje.INFORMACION);
        }catch (Exception e) {
            addMessage("Mantenimiento de Detalle de Capacitacion.", "Ha ocurrido un error al intentar actualizar la nota general.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
        
    }

    public void onRowSelectCapacitacion(SelectEvent event) {
        getSessionBeanCAP().setCapacitacionSeleccionada((Capacitacion) event.getObject());
    }

    public void onRowUnSelectCapacitacion(UnselectEvent event) {
        getSessionBeanCAP().setCapacitacionSeleccionada(null);
    }

    public void onRowSelectEmpleado(SelectEvent event) {
        getSessionBeanCAP().setEmpleadoSeleccionado((Empleados) event.getObject());
        nomEmp = getSessionBeanCAP().getEmpleadoSeleccionado().getNombreCompleto();
    }

    public String editar$Det$action() {
        if (getSessionBeanCAP().getCapacitacionSeleccionada() == null) {
            addMessage("Mantenimiento de Capacitaciones.", "No ha seleccionado ninguna capacitacion para editar.", TipoMensaje.ERROR);
            return null;
        }
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        setStatus(cap.getStatus());
        setInst(cap.getInstituciones().getInstitucionesPK().getCodInsti());
        setNomCapacitacion(cap.getNomCapacitacion());
        setNomInst(cap.getInstituciones().getDesInsti());
        setFechaInicial(cap.getFechaDesde());
        setFechaFinal(cap.getFechaHasta());
        setImpartido(cap.getImpartidaPor());
        setNomArea(cap.getCapacitacionAreas().getNomArea());
        setNomTema(cap.getCapacitacionTemas().getNomTema());
        setNomCapacitador(cap.getCapacitadores().getNombre());
        setNotaCapacitacion(cap.getNotaCapacitacion());
        Cias comp = getSessionBeanADM().getCompania();
        listaEmpleado = capacitacionSessionBean.findEmpByEmpresa(comp);
        listaDetalle = capacitacionSessionBean.findDetByCap(getSessionBeanADM().getCompania(), cap);
        getSessionBeanADM().setEstadoAccion(2);
        return null;
    }

    public void rowEditListener(RowEditEvent event) {
        boolean hayError = false;
        CapacitacionXEmpleado detalle = (CapacitacionXEmpleado) event.getObject();
        //detalle.setNota(nota);
        try {
            capacitacionSessionBean.editarDetalleCapacitacion(detalle);
            addMessage("Mantenimiento de Detalle de Capacitacion.", "Datos actualizados con éxito", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Mantenimiento de Detalle de Capacitacion.", "Ha ocurrido un error al intentar actualizar el Detallle Capacitacion.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
    }
}
