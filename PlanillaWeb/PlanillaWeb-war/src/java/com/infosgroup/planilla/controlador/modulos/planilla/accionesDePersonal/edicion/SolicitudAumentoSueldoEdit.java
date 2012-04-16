/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "solicitudAumentoSueldoEdit")
@ViewScoped
public class SolicitudAumentoSueldoEdit extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Cias empresa;
    private Double sueldoAnterior;
    private Double sueldoNuevo;
    private String formaAumento = "V";
    private Date fechaInicial;
    private Double porcentaje;
    private String observacion;

    public SolicitudAumentoSueldoEdit() {
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFormaAumento() {
        return formaAumento;
    }

    public void setFormaAumento(String formaAumento) {
        this.formaAumento = formaAumento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
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

    @PostConstruct
    public void _init() {
        setEmpresa(getSessionBeanADM().getCompania());
        if (getSessionBeanPLA().getAccionSeleccionada() != null) {
            setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
            setFechaInicial(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial());
            setPlanilla(getSessionBeanPLA().getAccionSeleccionada().getPlanillaToString());
            setTipoPlanilla(getSessionBeanPLA().getAccionSeleccionada().getCodTipopla());
            if(getSessionBeanPLA().getAccionSeleccionada().getFormaAumento().equals("V")){
                setFormaAumento(getSessionBeanPLA().getAccionSeleccionada().getFormaAumento());
                setSueldoNuevo( getSessionBeanPLA().getAccionSeleccionada().getCantidad().doubleValue() );
                setPorcentaje(new Double("0.0"));
            }else if (getSessionBeanPLA().getAccionSeleccionada().getFormaAumento().equals("P")){
                setFormaAumento(getSessionBeanPLA().getAccionSeleccionada().getFormaAumento());
                setPorcentaje( getSueldoNuevo() );
            }
        }
    }
    
    public void calculoSueldo() {
        if (sueldoNuevo != null && getSessionBeanPLA().getAccionSeleccionada().getEmpleados().getSalario() != null) {
            porcentaje = getSessionBeanPLA().getAccionSeleccionada().getEmpleados().getSalario().doubleValue() + ((sueldoNuevo / 100) * getSessionBeanPLA().getAccionSeleccionada().getEmpleados().getSalario().doubleValue());
        } else {
            porcentaje = 0.0;
        }
    }
    
    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;

        if (getFormaAumento().equals("V")) {
            if (getSueldoNuevo() == null || getSueldoNuevo() <= 0) {
                addMessage("Acciones de Personal", "EL nuevo valor del salario es requerido.", TipoMensaje.ERROR);
                return Boolean.FALSE;
            }
        } else if (getFormaAumento().equals("P")) {
            if (getPorcentaje() == null || getPorcentaje() <= 0) {
                addMessage("Acciones de Personal", "EL nuevo valor del salario es requerido.", TipoMensaje.ERROR);
                return Boolean.FALSE;
            }
        }

        if (getFechaInicial() == null) {
            addMessage("Acciones de Personal", "Fecha inicial es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getTipoPlanilla() == null || getTipoPlanilla() == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if ((getTipoPlanilla() != null && getTipoPlanilla() != -1) && (getPlanilla() == null || getPlanilla().equals("-1"))) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
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
        if (a == null || !validarSolicitud()) {
            return null;
        }
        try {
            a.setObservacion(getObservacion());
            a.setFechaInicial(getFechaInicial());
            a.setAnio(new Short(getPlanilla().split(":")[1].toString()));
            a.setMes(new Short(getPlanilla().split(":")[2].toString()));
            a.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
            a.setCodTipopla(getTipoPlanilla());
            a.setFormaAumento(getFormaAumento());
            a.setCantidad(getFormaAumento().equals("V") ? new BigDecimal(getSueldoNuevo()) : new BigDecimal(getPorcentaje()));
            a.setPorcentaje(getFormaAumento().equals("P") ? new BigDecimal(getSueldoNuevo()) : BigDecimal.ZERO);
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
