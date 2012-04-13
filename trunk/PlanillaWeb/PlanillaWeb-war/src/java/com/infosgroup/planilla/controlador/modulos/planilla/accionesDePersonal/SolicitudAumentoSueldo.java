/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.view.TipoMensaje;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author root
 */
public class SolicitudAumentoSueldo extends SolicitudDePersonal implements java.io.Serializable {

    private Double sueldoAnterior;
    private Double sueldoNuevo;
    private String formaAumento = "V";
    private java.util.Date fechaInicial;
    private Short tipoPlanilla;
    private String planilla;
    private Double porcentaje;
    private java.util.List<ProgramacionPla> listaPlanillas;
    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public SolicitudAumentoSueldo(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            listaPlanillas = planillaSessionBean().getProgramacionPlaByTipo(getEncabezadoSolicitud().getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla);
        }
        return listaPlanillas != null ? listaPlanillas : new java.util.ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
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

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
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

        if (tipoPlanilla == null || tipoPlanilla == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        if ((tipoPlanilla != null && tipoPlanilla != -1) && (planilla == null || planilla.equals("-1"))) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }

        return error;
    }

    public String guardarSolicitud$action() {
        if (validarSolicitud()) return null;
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getEncabezadoSolicitud().getSessionBeanADM().getCompania(), getEmpleadosToAccionPersonal()));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(getEmpleadosToAccionPersonal());      
        accionPersonal.setEmpleados1( getEmpleadosToAccionPersonal().getEmpleados() );
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(observacion);
        accionPersonal.setDepartamentos(getEmpleadosToAccionPersonal().getDepartamentos());
        accionPersonal.setStatus("G");
        accionPersonal.setUsuarioCreacion( getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getUsuario() );
        accionPersonal.setFechaInicial(fechaInicial);
        accionPersonal.setAnio(new Short(planilla.split(":")[1].toString()));
        accionPersonal.setMes(new Short(planilla.split(":")[2].toString()));
        accionPersonal.setNumPlanilla(new Short(planilla.split(":")[3].toString()));
        accionPersonal.setCodTipopla(tipoPlanilla);
        accionPersonal.setSueldoAnterior( getEmpleadosToAccionPersonal().getSalario() );
        accionPersonal.setCantidad( formaAumento.equals("V") ? new BigDecimal( sueldoNuevo ): new BigDecimal(porcentaje) ) ;
        accionPersonal.setPorcentaje(formaAumento.equals("P") ? new BigDecimal( sueldoNuevo ): BigDecimal.ZERO );
        accionPersonal.setPuestos(getEmpleadosToAccionPersonal().getPuestos());
        guardarAccionPersonal(accionPersonal);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        getEncabezadoSolicitud().setListaSolicitudes(planillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
        planillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        limpiarCampos();
        return null;
    }

    public void calculoSueldo() {
        if (sueldoNuevo != null && getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getSalario() != null) {
            porcentaje = getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getSalario().doubleValue() + ((sueldoNuevo / 100) * getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion().getSalario().doubleValue());
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
