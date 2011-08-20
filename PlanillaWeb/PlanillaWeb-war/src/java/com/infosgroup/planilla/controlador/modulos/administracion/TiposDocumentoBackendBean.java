/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.TipoDocumento;
import com.infosgroup.planilla.modelo.facades.TipoDocumentoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@ManagedBean(name = "administracion$tiposDocumento")
@ViewScoped
public class TiposDocumentoBackendBean {

    /** Creates a new instance of TiposDocumentoBackendBean */
    public TiposDocumentoBackendBean() {
    }
    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
    private List<TipoDocumento> listaTiposDocumento;

    public List<TipoDocumento> getListaTiposDocumento() {
        listaTiposDocumento = tipoDocumentoFacade.findAll();
        return listaTiposDocumento;
    }

    public void setListaTiposDocumento(List<TipoDocumento> listaTiposDocumento) {
        this.listaTiposDocumento = listaTiposDocumento;
    }
    private Integer idTipoDocumento;
    private String nombreTipoDocumento;

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }

    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }

    public String guardar_action() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, nombreTipoDocumento, nombreTipoDocumento));
        TipoDocumento t = new TipoDocumento();
        t.setIdTipoDocumento(idTipoDocumento);
        t.setNomTipoDocumento(nombreTipoDocumento);
        tipoDocumentoFacade.create(t);
        idTipoDocumento = null;
        nombreTipoDocumento = null;
        return null;
    }
}
