/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "solicitudNombramientoEdit")
@ViewScoped
public class SolicitudNombramientoEdit extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Cias empresa;
    private List<Departamentos> listaDepartamentos;
    private List<Puestos> listaPuestos;
    private Short departamento;
    private Short puesto;
    private Date fechaInicial;

    public SolicitudNombramientoEdit() {
    }

    public Short getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Short departamento) {
        this.departamento = departamento;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Short getPuesto() {
        return puesto;
    }

    public void setPuesto(Short puesto) {
        this.puesto = puesto;
    }

    public List<Departamentos> getListaDepartamentos() {
        listaDepartamentos = planillaSessionBean.findDepartamentos(getSessionBeanADM().getCompania());
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<Puestos> getListaPuestos() {
        listaPuestos = planillaSessionBean.findPuestos(getSessionBeanADM().getCompania());
        return listaPuestos;
    }

    public void setListaPuestos(List<Puestos> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }

    @PostConstruct
    public void _init() {
        setEmpresa(getSessionBeanADM().getCompania());
        if (getSessionBeanPLA().getAccionSeleccionada() != null) {
            setDepartamento(getSessionBeanPLA().getAccionSeleccionada(). getNuevoDepartamento().getDepartamentosPK().getCodDepto());
            setPuesto(getSessionBeanPLA().getAccionSeleccionada().getNuevoPuesto().getPuestosPK().getCodPuesto());
            setFechaInicial(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial());
            setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
        }
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
        if (getDepartamento() == null || getDepartamento() == -1) {
            addMessage("Acciones de Personal", "Departamento es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }
        if (getPuesto() == null || getPuesto() == -1) {
            addMessage("Acciones de Personal", "Puesto es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaInicial() == null) {
            addMessage("Acciones de Personal", "Fecha Inicial es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }
        return error;
    }

    @Override
    protected PlanillaSessionBean getPlanillaSessionBean() {
        return planillaSessionBean;
    }

    @Override
    public Cias getEmpresa() {
        return empresa;
    }

    @Override
    public String guardarCambios() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null || !validarSolicitud()) return null;
        try {
            a.setObservacion(getObservacion());
            a.setFechaInicial(getFechaInicial());
            a.setNuevoDepartamento(new Departamentos(new DepartamentosPK(getEmpresa().getCodCia(), getDepartamento())));
            a.setNuevoPuesto(new Puestos(new PuestosPK(getEmpresa().getCodCia(), getPuesto())));
            actualizarSolicitud(a);
            addMessage("Acciones de Personal", "Datos Guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Acciones de Personal", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.ERROR);
            looger.log(Level.SEVERE, "Ha ocurrido el siguiente error al intentar Actualizar.", e);
        }
        return null;
    }

    @Override
    protected void limpiarCampos() {
        getSessionBeanPLA().setAccionSeleccionada(null);
    }
}
