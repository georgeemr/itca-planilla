/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.CausasRenuncia;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
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
@ManagedBean(name = "solicitudRetiroEdit")
@ViewScoped
public class SolicitudRetiroEdit extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Cias empresa;
    private String observacion;
    private TipoAccion tipoAccion;
    private Short tipoRenuncia;
    private Date fechaRetiro;
    private List<CausasRenuncia> listaCausasRenuncia;

    public SolicitudRetiroEdit() {
    }

    public Short getTipoRenuncia() {
        return tipoRenuncia;
    }

    public void setTipoRenuncia(Short tipoRenuncia) {
        this.tipoRenuncia = tipoRenuncia;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public TipoAccion getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(TipoAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<CausasRenuncia> getListaCausasRenuncia() {
        listaCausasRenuncia = planillaSessionBean.findCausasRenunciasByCias(getSessionBeanADM().getCompania());
        return listaCausasRenuncia;
    }

    public void setListaCausasRenuncia(List<CausasRenuncia> listaCausasRenuncia) {
        this.listaCausasRenuncia = listaCausasRenuncia;
    }

    @PostConstruct
    public void _init() {
        setEmpresa(getSessionBeanADM().getCompania());
        if (getSessionBeanPLA().getAccionSeleccionada() != null) {
            setPlanilla(getSessionBeanPLA().getAccionSeleccionada().getPlanillaToString());
            setTipoPlanilla(getSessionBeanPLA().getAccionSeleccionada().getCodTipopla());
            setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
            setTipoRenuncia(getSessionBeanPLA().getAccionSeleccionada().getCausasRenuncia().getCausasRenunciaPK().getCodTiporenuncia());
            setFechaRetiro(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial());
            setTipoAccion(getSessionBeanPLA().getAccionSeleccionada().getTipoAccion());
        }
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
        if (getFechaRetiro() == null) {
            addMessage("Acciones de Personal", "Fecha de retiro es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getTipoRenuncia() == null || getTipoRenuncia() == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el motivo de retiro.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getTipoPlanilla() == null || getTipoPlanilla() == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
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
            a.setCausasRenuncia(new CausasRenuncia(getEmpresa().getCodCia(), getTipoRenuncia()));
            a.setCodTipopla(getTipoPlanilla());
            a.setFechaInicial(getFechaRetiro());
            a.setObservacion(getObservacion());
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
