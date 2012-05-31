/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TipoAccionPK;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name="solicitudNoAfectaPlanilla")
@ViewScoped
public class SolicitudNoAfectaPlanilla extends SolicitudDePersonal implements java.io.Serializable {

    private Short tipoAccionSeleccionada;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<TipoAccion> listaTipoAccionNoAfecta;

    @PostConstruct
    public void _init(){
        if (isInRole("rrhh")) {
            listaTipoAccionNoAfecta = getPlanillaSessionBean().listarTipoAccionNoAfectaPlanilla(getSessionBeanADM().getCompania(), "rrhh");
        } else if (isInRole("jefes")) {
            listaTipoAccionNoAfecta = getPlanillaSessionBean().listarTipoAccionNoAfectaPlanilla(getSessionBeanADM().getCompania(), "jefes");
        } else if (isInRole("empleados")) {
            listaTipoAccionNoAfecta = getPlanillaSessionBean().listarTipoAccionNoAfectaPlanilla(getSessionBeanADM().getCompania(), "empleados");
        } else {
            listaTipoAccionNoAfecta = new ArrayList<TipoAccion>();
        }
    }

    public Short getTipoAccionSeleccionada() {
        return tipoAccionSeleccionada;
    }

    public void setTipoAccionSeleccionada(Short tipoAccionSeleccionada) {
        this.tipoAccionSeleccionada = tipoAccionSeleccionada;
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

    public List<TipoAccion> getListaTipoAccionNoAfecta() {
        return listaTipoAccionNoAfecta;
    }

    public void setListaTipoAccionNoAfecta(List<TipoAccion> listaTipoAccionNoAfecta) {
        this.listaTipoAccionNoAfecta = listaTipoAccionNoAfecta;
    }

    public String guardarSolicitud$action() {
        if (validarSolicitud()) return null;
        AccionPersonal accionPersonal = new AccionPersonal();       
        TipoAccion tipoAccion = new TipoAccion(new TipoAccionPK(getSessionBeanADM().getCompania().getCodCia(), tipoAccionSeleccionada));
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getSessionBeanADM().getCompania(), tipoAccion, getEmpleadosToAccionPersonal()));
        accionPersonal.setTipoAccion(tipoAccion);
        accionPersonal.setEmpleados(getEmpleadosToAccionPersonal());
        accionPersonal.setEmpleados1( getEmpleadosToAccionPersonal().getEmpleados() );
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal = getEstadoSolicitudByRol(accionPersonal);//accionPersonal.setStatus("G");
        accionPersonal.setUsuarioCreacion(getSessionBeanEMP().getEmpleadoSesion().getUsuario());
        accionPersonal.setDepartamentos(getEmpleadosToAccionPersonal().getDepartamentos());
        accionPersonal.setFechaInicial(fechaInicial);
        accionPersonal.setFechaFinal(fechaInicial);
        accionPersonal.setPuestos(getEmpleadosToAccionPersonal().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        //getEncabezadoSolicitud().setListaSolicitudes(getPlanillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        //getPlanillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.FALSE;

        if (tipoAccionSeleccionada == null || tipoAccionSeleccionada.equals(new Short("-1"))) {
            addMessage("Acciones de Personal", "Seleccione un tipo de Acción.", TipoMensaje.ERROR);
            return Boolean.TRUE;
        }

        if (tipoAccionSeleccionada.equals(new Short("8"))) {
            if (fechaInicial == null) {
                addMessage("Acciones de Personal", "Fecha Inicial es un campo requerido.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            if (fechaFinal == null) {
                addMessage("Acciones de Personal", "Fecha Final es un campo requerido.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            if (fechaInicial != null && fechaFinal != null) {
                if (!validaFechas(fechaInicial, fechaFinal)) {
                    addMessage("Acciones de Personal", "Los datos de Fecha inicial y final no son consistentes.", TipoMensaje.ERROR);
                    error = Boolean.TRUE;
                }
            }
        }

        return error;
    }

    @Override
    protected void limpiarCampos() {
        setFechaInicial(null);
        setFechaFinal(null);
        setTipoAccionSeleccionada(new Short("-1"));
        setObservacion("");
    }
}
