/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.capacitaciones;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAsistencia;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleado;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.procesos.CapacitacionesSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "capacitaciones$asistenciaCapacitacion")
@ViewScoped
public class asistenciaCapBackendBean extends AbstractJSFPage implements Serializable {

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
    private CapacitacionXEmpleado detalleSelec;
    private List<Capacitacion> listaCap;
    private List<CapacitacionAsistencia> listaAsistencia;
    private List<CapacitacionXEmpleado> listaDetalle;
    private Dialog dialogBuscaEmp;

    public Dialog getDialogBuscaEmp() {
        return dialogBuscaEmp;
    }

    public void setDialogBuscaEmp(Dialog dialogBuscaEmp) {
        this.dialogBuscaEmp = dialogBuscaEmp;
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

    public Short getInst() {
        return inst;
    }

    public void setInst(Short inst) {
        this.inst = inst;
    }

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    public CapacitacionXEmpleado getDetalleSelec() {
        return detalleSelec;
    }

    public void setDetalleSelec(CapacitacionXEmpleado detalleSelec) {
        this.detalleSelec = detalleSelec;
    }

    public List<CapacitacionAsistencia> getListaAsistencia() {
        return listaAsistencia;
    }

    public void setListaAsistencia(List<CapacitacionAsistencia> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    public List<Capacitacion> getListaCap() {
        return listaCap;
    }

    public void setListaCap(List<Capacitacion> listaCap) {
        this.listaCap = listaCap;
    }

    public List<CapacitacionXEmpleado> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<CapacitacionXEmpleado> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public String getNomArea() {
        return nomArea;
    }

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
    }

    public String getNomCapacitacion() {
        return nomCapacitacion;
    }

    public void setNomCapacitacion(String nomCapacitacion) {
        this.nomCapacitacion = nomCapacitacion;
    }

    public String getNomCapacitador() {
        return nomCapacitador;
    }

    public void setNomCapacitador(String nomCapacitador) {
        this.nomCapacitador = nomCapacitador;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getNomInst() {
        return nomInst;
    }

    public void setNomInst(String nomInst) {
        this.nomInst = nomInst;
    }

    public String getNomTema() {
        return nomTema;
    }

    public void setNomTema(String nomTema) {
        this.nomTema = nomTema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    protected void limpiarCampos() {
        getSessionBeanCAP().setDetalleCapSeleccionada(null);
        setDetalleSelec(null);
        setNomEmp(null);
    }

    public void nuevo$vh$action() {
        setEstadoAccion(2);
    }

    public void consultar$vh$action() {
        setEstadoAccion(0);
        getSessionBeanCAP().setCapacitacionSeleccionada(null);
    }

    public void setEstadoAccion(Integer estadoAccion) {
        getSessionBeanADM().setEstadoAccion(estadoAccion);
        limpiarCampos();
    }
    
    public void onRowSelectCapacitacion(SelectEvent event) {
        getSessionBeanCAP().setCapacitacionSeleccionada((Capacitacion) event.getObject());
        listaDetalle = capacitacionSessionBean.findDetByCap(getSessionBeanADM().getCompania(), getSessionBeanCAP().getCapacitacionSeleccionada());
    }

    public void onRowUnSelectCapacitacion(UnselectEvent event) {
        getSessionBeanCAP().setCapacitacionSeleccionada(null);
    }

    public void onRowSelectDetalle(SelectEvent event) {
        setDetalleSelec((CapacitacionXEmpleado) event.getObject());
        //getSessionBeanCAP().setDetalleCapSeleccionada((CapacitacionXEmpleado) event.getObject());
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        CapacitacionXEmpleado detalle = detalleSelec;
        Empleados empleado = detalle.getEmpleados();
        listaAsistencia = capacitacionSessionBean.findAsistenciaByDet(getSessionBeanADM().getCompania(), cap, empleado);
        nomEmp = detalleSelec.getEmpleados().getNombreCompleto();
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
        Cias comp = getSessionBeanADM().getCompania();
        listaDetalle = capacitacionSessionBean.findDetByCap(getSessionBeanADM().getCompania(), cap);
        getSessionBeanADM().setEstadoAccion(2);
        return null;
    }

    public void rowEditListener(RowEditEvent event) {
        boolean hayError = false;
        CapacitacionAsistencia asistencia = (CapacitacionAsistencia) event.getObject();
        try {
            asistencia.setAsistio((asistencia.getAsiste()) ? "N" : "S");
            capacitacionSessionBean.editarAsistencia(asistencia);
            addMessage("Mantenimiento de Asistencia de Capacitacion.", "Asistencias actualizadas con éxito", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Mantenimiento de Asistencia de Capacitacion.", "Ha ocurrido un error al intentar actualizar la Asistencia de Capacitacion.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
    }

    
}
