/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.Date;
import java.util.List;

/**
 *
 * @author root
 */
public class SolicitudNombramiento extends SolicitudDePersonal implements java.io.Serializable {

    private java.util.List<Departamentos> listaDepartamentos;
    private java.util.List<Puestos> listaPuestos;
    private Short departamento;
    private Short puesto;
    private java.util.Date fechaInicial;

    public SolicitudNombramiento(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
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
        listaDepartamentos = planillaSessionBean().findDepartamentos(getEncabezadoSolicitud().getSessionBeanADM().getCompania());
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<Puestos> getListaPuestos() {
        listaPuestos = planillaSessionBean().findPuestos(getEncabezadoSolicitud().getSessionBeanADM().getCompania());
        return listaPuestos;
    }

    public void setListaPuestos(List<Puestos> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public String guardarSolicitud$action() {
        if (validarSolicitud()) {
            return null;
        }
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getEncabezadoSolicitud().getSessionBeanADM().getCompania()));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion());
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getEncabezadoSolicitud().getObservacion());
        accionPersonal.setStatus("G");
        accionPersonal.setDepartamentos(new Departamentos(new DepartamentosPK(getEncabezadoSolicitud().getEmpresa(), departamento)));
        accionPersonal.setFechaInicial(fechaInicial);
        accionPersonal.setPuestos(new Puestos(new PuestosPK(getEncabezadoSolicitud().getEmpresa(), puesto)));
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        getEncabezadoSolicitud().setListaSolicitudes(planillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        planillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }

    @Override
    boolean validarSolicitud() {
        Boolean error = Boolean.FALSE;
        if (departamento == null || departamento==-1) {
            addMessage("Acciones de Personal", "Departamento es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }
        if (puesto == null || puesto == -1) {
            addMessage("Acciones de Personal", "Puesto es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (fechaInicial == null) {
            addMessage("Acciones de Personal", "Fecha Inicial es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }
        return error;
    }

    @Override
    protected void limpiarCampos() {
        setDepartamento(null);
        setPuesto(null);
        setFechaInicial(null);
        getEncabezadoSolicitud().setObservacion(null);
    }
}
