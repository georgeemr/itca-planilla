/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "solicitudPermisoEdit")
@ViewScoped
public class SolicitudPermisoEdit extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<TiposPlanilla> listaTipos;
    private List<ProgramacionPla> listaPlanillas;
    private String planilla;
    private Short dias;
    private Short horas;
    private Double valorDescuento;
    private Date fechaInicial;
    private Date fechaFinal;
    private String observacion;
    private Short tipoPlanilla;
    
    public SolicitudPermisoEdit() {
    }
    
    @PostConstruct
    public void _init(){
        if (getSessionBeanPLA().getAccionSeleccionada()!=null){
            setPlanilla( getSessionBeanPLA().getAccionSeleccionada().getPlanillaToString() );
            setFechaInicial(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial());
            setFechaFinal(getSessionBeanPLA().getAccionSeleccionada().getFechaFinal());
            setDias(getSessionBeanPLA().getAccionSeleccionada().getDias());
            setHoras(getSessionBeanPLA().getAccionSeleccionada().getHoras());
            setTipoPlanilla(getSessionBeanPLA().getAccionSeleccionada().getCodTipopla() );
            if( getSessionBeanPLA().getAccionSeleccionada().getCantidad()!=null){
            setValorDescuento(getSessionBeanPLA().getAccionSeleccionada().getCantidad().doubleValue());
            }else{
                setValorDescuento(new Double("0"));
            }
            setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
        }
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }
    
    public List<TiposPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos(getSessionBeanADM().getCompania());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (getTipoPlanilla() != null && getTipoPlanilla() != -1) {
            listaPlanillas =planillaSessionBean.getProgramacionPlaByTipo(getSessionBeanADM().getCompania().getCodCia(), getTipoPlanilla());
        }
        return listaPlanillas != null ? listaPlanillas : new ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public Short getDias() {
        return dias;
    }

    public void setDias(Short dias) {
        this.dias = dias;
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

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    public PlanillaSessionBean getPlanillaSessionBean() {
        return planillaSessionBean;
    }

    public void setPlanillaSessionBean(PlanillaSessionBean planillaSessionBean) {
        this.planillaSessionBean = planillaSessionBean;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    @Override
    protected void limpiarCampos() {
        getSessionBeanPLA().setAccionSeleccionada(null);
    }

    public void handleFechaInicial(DateSelectEvent event) {
        setFechaInicial(event.getDate());
        setDias(calculaDias(getFechaInicial(), getFechaFinal()).shortValue());
    }

    public void handleFechaFinal(DateSelectEvent event) {
        setFechaFinal(event.getDate());
        setDias(calculaDias(getFechaInicial(), getFechaFinal()).shortValue());
    }
    
    public String guardarCambios() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null || !validarSolicitud() ) return null;
        try {
            a.setAnio(new Short(getPlanilla().split(":")[1].toString()));
            a.setMes(new Short(getPlanilla().split(":")[2].toString()));
            a.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
            a.setFechaInicial(getFechaInicial());
            a.setFechaFinal(getFechaFinal());
            a.setDias(getDias());
            a.setHoras(getHoras());
            a.setCodTipopla(getTipoPlanilla());
            a.setCantidad(new BigDecimal(getValorDescuento()));
            a.setObservacion(getObservacion());
            actualizarSolicitud(a);
            addMessage("Acciones de Personal", "Datos Guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Acciones de Personal", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.ERROR);
            looger.log(Level.SEVERE,"Ha ocurrido el siguiente error al intentar Actualizar.", e);
        }
        return null;
    }
    
        @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
        if (getTipoPlanilla() == null) {
            addMessage("Acciones de Personal", "Tipo de acción es un campo requerido", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaInicial() == null) {
            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaFinal() == null) {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getFechaInicial() != null && getFechaFinal() != null) {
            if (!validaFechas(getFechaInicial(), getFechaFinal())) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicia y Fecha fin no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }

        if (getHoras() != null) {
            if (getHoras() < 0 || getHoras()>23) {
                addMessage("Acciones de Personal", "La cantidad de horas no es valida.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
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
    public void actualizarSolicitud(AccionPersonal a) throws Exception {
        if (a == null) throw new Exception("No ha seleccionado ninguna solicitud.");
        try {
            planillaSessionBean.actualizarAccionPersonal(a);
        } catch (Exception e) {
            looger.log(Level.SEVERE,"Ha ocurrido el siguiente error al intentar Actualizar.", e);
        }
    }
}
