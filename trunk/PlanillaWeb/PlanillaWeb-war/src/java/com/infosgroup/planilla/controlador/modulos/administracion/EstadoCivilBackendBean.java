/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.EstadoCivil;
import com.infosgroup.planilla.modelo.facades.EstadoCivilFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ralarcon
 */
@ManagedBean(name = "administracion$estadoCivil")
@ViewScoped
public class EstadoCivilBackendBean implements Serializable {

    public EstadoCivilBackendBean() {
    }
    @EJB
    private EstadoCivilFacade estadoCivilFacade;
    private Long idEstadoCivil;
    private String nombreEstadoCivil;

    public Long getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Long idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getNombreEstadoCivil() {
        return nombreEstadoCivil;
    }

    public void setNombreEstadoCivil(String nombreEstadoCivil) {
        this.nombreEstadoCivil = nombreEstadoCivil;
    }
    // =============================================================================================

    public String guardar_action() {
        EstadoCivil e = new EstadoCivil();
        e.setCodEstadoCivil(idEstadoCivil);
        e.setNomEstadoCivil(nombreEstadoCivil);
        estadoCivilFacade.create(e);
        idEstadoCivil = null;
        nombreEstadoCivil = null;
        return null;
    }
    // =============================================================================================
    private List<EstadoCivil> listaEstadoCivil;

    public List<EstadoCivil> getListaEstadoCivil() {
        listaEstadoCivil = estadoCivilFacade.findAll();
        return listaEstadoCivil;
    }

    public void setListaEstadoCivil(List<EstadoCivil> listaEstadoCivil) {
        this.listaEstadoCivil = listaEstadoCivil;
    }
    // =============================================================================================
    private EstadoCivil estadoCivilSeleccionado;

    public EstadoCivil getEstadoCivilSeleccionado() {
        return estadoCivilSeleccionado;
    }

    public void setEstadoCivilSeleccionado(EstadoCivil estadoCivilSeleccionado) {
        this.estadoCivilSeleccionado = estadoCivilSeleccionado;
    }
    // =============================================================================================

    public String eliminar_action() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ha eliminado el registro", ""));
        if (estadoCivilSeleccionado == null) {
            return null;
        }
        EstadoCivil e = estadoCivilFacade.find(estadoCivilSeleccionado.getCodEstadoCivil());
        estadoCivilFacade.remove(e);
        return null;
    }
}
