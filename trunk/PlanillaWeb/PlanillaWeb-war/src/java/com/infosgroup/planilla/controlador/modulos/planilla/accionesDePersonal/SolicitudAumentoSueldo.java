/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.view.TipoMensaje;
import java.math.BigDecimal;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name="solicitudAumentoSueldo")
@ViewScoped
public class SolicitudAumentoSueldo extends SolicitudDePersonal implements java.io.Serializable {

    private Double sueldoAnterior;
    private Double sueldoNuevo;
    private String formaAumento = "V";
    private java.util.Date fechaInicial;
    private Double porcentaje;

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getFormaAumento() {
        return formaAumento;
    }

    public void setFormaAumento(String formaAumento) {
        this.formaAumento = formaAumento;
    }

    public Double getSueldoAnterior() {
        return sueldoAnterior;
    }

    public void setSueldoAnterior(Double sueldoAnterior) {
        this.sueldoAnterior = sueldoAnterior;
    }

    public Double getSueldoNuevo() {
        return sueldoNuevo;
    }

    public void setSueldoNuevo(Double sueldoNuevo) {
        this.sueldoNuevo = sueldoNuevo;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    @Override
    boolean validarSolicitud() {

        Boolean error = Boolean.FALSE;

        if (formaAumento.equals("V")) {
            if (sueldoNuevo == null || sueldoNuevo <= 0) {
                addMessage("Acciones de Personal", "EL nuevo valor del salario es requerido.", TipoMensaje.ERROR);
                return Boolean.TRUE;
            }
        } else if (formaAumento.equals("P")) {
            if (porcentaje == null || porcentaje <= 0) {
                addMessage("Acciones de Personal", "EL nuevo valor del salario es requerido.", TipoMensaje.ERROR);
                return Boolean.TRUE;
            }
        }

        if (fechaInicial == null) {
            addMessage("Acciones de Personal", "Fecha inicial es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if (getTipoPlanilla() == null || getTipoPlanilla() == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if ((getTipoPlanilla() != null && getTipoPlanilla() != -1) && (getPlanilla() == null || getPlanilla().equals("-1"))) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        return error;
    }

    public String guardarSolicitud$action() {
        if (validarSolicitud()) return null;
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getSessionBeanADM().getCompania(), getEmpleadosToAccionPersonal()));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getEmpleadosToAccionPersonal());      
        accionPersonal.setEmpleados1( getEmpleadosToAccionPersonal().getEmpleados() );
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setDepartamentos(getEmpleadosToAccionPersonal().getDepartamentos());
        accionPersonal.setStatus("G");
        accionPersonal.setFormaAumento(formaAumento);
        accionPersonal.setUsuarioCreacion( getSessionBeanEMP().getEmpleadoSesion().getUsuario() );
        accionPersonal.setFechaInicial(fechaInicial);
        accionPersonal.setAnio(new Short(getPlanilla().split(":")[1].toString()));
        accionPersonal.setMes(new Short(getPlanilla().split(":")[2].toString()));
        accionPersonal.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
        accionPersonal.setCodTipopla(getTipoPlanilla());
        accionPersonal.setSueldoAnterior( getEmpleadosToAccionPersonal().getSalario() );
        accionPersonal.setCantidad( formaAumento.equals("V") ? new BigDecimal( sueldoNuevo ): new BigDecimal(porcentaje) ) ;
        accionPersonal.setPorcentaje(formaAumento.equals("P") ? new BigDecimal( sueldoNuevo ): BigDecimal.ZERO );
        accionPersonal.setPuestos(getEmpleadosToAccionPersonal().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        //setListaSolicitudes(getPlanillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        //getPlanillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }

    public void calculoSueldo() {
        if (sueldoNuevo != null && getEmpleadosToAccionPersonal().getSalario() != null) {
            porcentaje = getEmpleadosToAccionPersonal().getSalario().doubleValue() + ((sueldoNuevo / 100) * getEmpleadosToAccionPersonal().getSalario().doubleValue());
        } else {
            porcentaje = 0.0;
        }
    }

    @Override
    protected void limpiarCampos() {
        setSueldoAnterior(0.0);
        setSueldoNuevo(0.0);
        setFormaAumento("V");
        setObservacion("");
        setTipoPlanilla(new Short("-1"));
        setPlanilla("-1");
        setFechaInicial(null);
        setPorcentaje(0.0);
    }
}
