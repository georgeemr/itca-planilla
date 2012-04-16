/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "solicitudConstaciaSueldoEdit")
@ViewScoped
public class SolicitudConstaciaSueldoEdit extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Cias empresa;
    private String observacion;

    public SolicitudConstaciaSueldoEdit() {
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }

    public String guardarCambios() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null || !validarSolicitud()) {
            return null;
        }
        try {
            a.setObservacion(getObservacion());
            actualizarSolicitud(a);
            addMessage("Acciones de Personal", "Datos Guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Acciones de Personal", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.ERROR);
            looger.log(Level.SEVERE, "Ha ocurrido el siguiente error al intentar Actualizar.", e);
        }
        return null;
    }

    @PostConstruct
    public void _init() {
        setEmpresa(getSessionBeanADM().getCompania());
        setObservacion(getSessionBeanPLA().getAccionSeleccionada().getObservacion());
    }

    @Override
    public boolean validarSolicitud() {
        return Boolean.TRUE;
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
    protected void limpiarCampos() {
        getSessionBeanPLA().setAccionSeleccionada(null);
    }
}
