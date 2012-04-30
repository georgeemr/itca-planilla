/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
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
@ManagedBean(name = "solicitudNoAfectaPlanillaEdit")
@ViewScoped
public class SolicitudNoAfectaPlanillaEdit extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Cias empresa;
    private Date fechaInicial;
    private Date fechaFinal;
    private TipoAccion tipoAccion;

    public SolicitudNoAfectaPlanillaEdit() {
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
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

    public TipoAccion getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(TipoAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    @PostConstruct
    public void _init() {
        setEmpresa(getSessionBeanADM().getCompania());
        if (getSessionBeanPLA().getAccionSeleccionada() != null) {
            setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
            setTipoAccion(getSessionBeanPLA().getAccionSeleccionada().getTipoAccion());
            setFechaInicial(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial());
            setFechaFinal(getSessionBeanPLA().getAccionSeleccionada().getFechaFinal());
        }
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
        if (getTipoAccion().getTipoAccionPK().getCodTipoaccion().equals(new Short("8"))) {
            if (getFechaInicial() == null) {
                addMessage("Acciones de Personal", "Fecha Inicial es un campo requerido.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
            if (getFechaFinal() == null) {
                addMessage("Acciones de Personal", "Fecha Final es un campo requerido.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
            if (getFechaInicial() != null && getFechaFinal() != null) {
                if (!validaFechas(getFechaInicial(), getFechaFinal())) {
                    addMessage("Acciones de Personal", "Los datos de Fecha inicial y final no son consistentes.", TipoMensaje.ERROR);
                    error = Boolean.FALSE;
                }
            }
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
        a.setObservacion(getObservacion());
        a.setFechaInicial(getFechaInicial());
        a.setFechaFinal(getFechaFinal());
        try {
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
