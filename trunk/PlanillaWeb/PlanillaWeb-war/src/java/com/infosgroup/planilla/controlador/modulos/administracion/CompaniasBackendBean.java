/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.facades.CompaniaFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@ManagedBean(name = "administracion$companias")
@ViewScoped
public class CompaniasBackendBean implements Serializable {

    /** Creates a new instance of CompaniasBackendBean */
    public CompaniasBackendBean() {
    }
// ===================================================================================================
    @EJB
    private CompaniaFacade companiaFacade;
// ===================================================================================================
    private Integer idCompania;

    public Integer getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(Integer idCompania) {
        this.idCompania = idCompania;
    }
    private String nomCompania;

    public String getNomCompania() {
        return nomCompania;
    }

    public void setNomCompania(String nomCompania) {
        this.nomCompania = nomCompania;
    }
    private String detCompania;

    public String getDetCompania() {
        return detCompania;
    }

    public void setDetCompania(String detCompania) {
        this.detCompania = detCompania;
    }
    private String razonSocial;

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
// ===================================================================================================
    private List<Compania> listaCompanias;

    public List<Compania> getListaCompanias() {
        listaCompanias = companiaFacade.findAll();
        return listaCompanias;
    }

    public void setListaCompanias(List<Compania> listaCompanias) {
        this.listaCompanias = listaCompanias;
    }
// =============================================================================================
    private Compania companiaSeleccionada;

    public Compania getCompaniaSeleccionada() {
        return companiaSeleccionada;
    }

    public void setCompaniaSeleccionada(Compania companiaSeleccionada) {
        this.companiaSeleccionada = companiaSeleccionada;
    }
// =============================================================================================

    public String guardar_action() {
        Compania c = new Compania();
        c.setIdCompania(idCompania);
        c.setNomCompania(nomCompania);
        c.setDetCompania(detCompania);
        c.setRazonSocial(razonSocial);
        companiaFacade.create(c);
        idCompania = null;
        nomCompania = null;
        detCompania = null;
        razonSocial = null;
        return null;
    }

    public String modificar_action() {
        if (companiaSeleccionada == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "No he seleccionado ninguna compañia"));
            return null;
        }
        idCompania = companiaSeleccionada.getIdCompania();
        nomCompania = companiaSeleccionada.getNomCompania();
        detCompania = companiaSeleccionada.getDetCompania();
        razonSocial = companiaSeleccionada.getRazonSocial();
        return null;
    }

    public String eliminar_action() {
        if (companiaSeleccionada == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "No he seleccionado ninguna compañia"));
            return null;
        }
        Compania c = companiaFacade.find(companiaSeleccionada.getIdCompania());
        companiaFacade.remove(c);
        return null;
    }
}
