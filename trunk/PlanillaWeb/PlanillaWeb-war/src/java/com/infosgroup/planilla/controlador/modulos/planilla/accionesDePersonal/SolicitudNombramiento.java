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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name="solicitudNombramiento")
@ViewScoped
public class SolicitudNombramiento extends SolicitudDePersonal implements java.io.Serializable {

    private List<Departamentos> listaDepartamentos;
    private List<Puestos> listaPuestos;
    private Short departamento;
    private Short puesto;
    private Date fechaInicial;

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
        listaDepartamentos = getPlanillaSessionBean().findDepartamentos(getSessionBeanADM().getCompania());
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<Puestos> getListaPuestos() {
        listaPuestos = getPlanillaSessionBean().findPuestos(getSessionBeanADM().getCompania());
        return listaPuestos;
    }

    public void setListaPuestos(List<Puestos> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public String guardarSolicitud$action() {
        if (validarSolicitud()) return null;
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getSessionBeanADM().getCompania(),getEmpleadosToAccionPersonal()));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getEmpleadosToAccionPersonal());
        accionPersonal.setEmpleados1( getEmpleadosToAccionPersonal().getEmpleados() );
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal = getEstadoSolicitudByRol(accionPersonal); //accionPersonal.setStatus("G");
        accionPersonal.setUsuarioCreacion( getSessionBeanEMP().getEmpleadoSesion().getUsuario() );
        accionPersonal.setDepartamentos(getEmpleadosToAccionPersonal().getDepartamentos());
        accionPersonal.setNuevoDepartamento(new Departamentos(new DepartamentosPK(getSessionBeanADM().getCompania().getCodCia(), departamento)));
        accionPersonal.setPuestos(getEmpleadosToAccionPersonal().getPuestos());
        accionPersonal.setNuevoPuesto(new Puestos(new PuestosPK(getSessionBeanADM().getCompania().getCodCia(), puesto)));
        accionPersonal.setFechaInicial(fechaInicial);
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        //getEncabezadoSolicitud().setListaSolicitudes(getPlanillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        //getPlanillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
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
        setDepartamento(new Short("-1"));
        setPuesto(new Short("-1"));
        setFechaInicial(null);
        setObservacion("");
    }
}
