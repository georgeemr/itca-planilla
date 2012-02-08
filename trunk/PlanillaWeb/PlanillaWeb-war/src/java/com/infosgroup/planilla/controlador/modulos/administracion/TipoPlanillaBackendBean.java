/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanillaPK;
import com.infosgroup.planilla.modelo.facades.CiasFacade;
import com.infosgroup.planilla.modelo.facades.TipoPlanillaFacade;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

/**
 *
 * @author root
 */
@ManagedBean(name = "administracion$tipoPlanilla")
@ViewScoped
public class TipoPlanillaBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private CiasFacade companiasFacade;
    @EJB
    private TipoPlanillaFacade tipoPlanillaFacade;
    private Short idTipoPlanilla;
    private String nombreTipoPlanilla;
    private List<Cias> listaCompanias;
    private Integer compania;
    private List<TiposPlanilla> ListaTiposPlanilla;
    private TiposPlanilla tipoPlanillaSeleccionado;

    public TipoPlanillaBackendBean() {
    }

    public Integer getCompania() {
        return compania;
    }

    public void setCompania(Integer compania) {
        this.compania = compania;
    }

    public Short getIdTipoPlanilla() {
        return idTipoPlanilla;
    }

    public void setIdTipoPlanilla(Short idTipoPlanilla) {
        this.idTipoPlanilla = idTipoPlanilla;
    }

    public String getNombreTipoPlanilla() {
        return nombreTipoPlanilla;
    }

    public void setNombreTipoPlanilla(String nombreTipoPlanilla) {
        this.nombreTipoPlanilla = nombreTipoPlanilla;
    }

    public List<Cias> getListaCompanias() {
        listaCompanias = companiasFacade.findAll();
        return listaCompanias;
    }

    public void setListaCompanias(List<Cias> listaCompanias) {
        this.listaCompanias = listaCompanias;
    }

    public List<TiposPlanilla> getListaTiposPlanilla() {
        ListaTiposPlanilla = tipoPlanillaFacade.findAll();
        return ListaTiposPlanilla;
    }

    public void setListaTiposPLanilla(List<TiposPlanilla> ListaTiposPlanilla) {
        this.ListaTiposPlanilla = ListaTiposPlanilla;
    }

    public TiposPlanilla getTipoPlanillaSeleccionado() {
        return tipoPlanillaSeleccionado;
    }

    public void setTipoPlanillaSeleccionado(TiposPlanilla tipoPlanillaSeleccionado) {
        this.tipoPlanillaSeleccionado = tipoPlanillaSeleccionado;
    }

    public String guardar_action() {
        TiposPlanilla e = new TiposPlanilla();
        e.setNomTipopla(nombreTipoPlanilla);
        e.setTiposPlanillaPK(new TiposPlanillaPK(getSessionBeanADM().getCompania().getCodCia(), idTipoPlanilla));
        tipoPlanillaFacade.create(e);
        idTipoPlanilla = null;
        limpiarCampos();
        addMessage("Tipo Planilla", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
        return null;
    }

    public String eliminar_action() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ha eliminado el registro", ""));
        if (tipoPlanillaSeleccionado == null) {
            return null;
        }
        TiposPlanilla e = tipoPlanillaFacade.find(tipoPlanillaSeleccionado.getTiposPlanillaPK());

        tipoPlanillaFacade.remove(e);

        return null;
    }

    @Override
    protected void limpiarCampos() {
        nombreTipoPlanilla = null;
    }
}
