/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.entidades.TipoPlanillaPK;
import com.infosgroup.planilla.modelo.facades.CompaniaFacade;
import com.infosgroup.planilla.modelo.facades.TipoPlanillaFacade;
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
@ManagedBean(name="administracion$tipoPlanilla")
@ViewScoped
public class TipoPlanillaBackendBean implements Serializable{

    /** Creates a new instance of TipoPlanillaBackendBean */
    public TipoPlanillaBackendBean() {
    }
    
 @EJB
 private CompaniaFacade companiasFacade; 
 
    @EJB
      private TipoPlanillaFacade tipoPlanillaFacade;
      private Integer idTipoPlanilla;

    public Integer getCompania() {
        return compania;
    }

    public void setCompania(Integer compania) {
        this.compania = compania;
    }
      private Integer compania;

    public Integer getIdTipoPlanilla() {
        return idTipoPlanilla;
    }

    public void setIdTipoPlanilla(Integer idTipoPlanilla) {
        this.idTipoPlanilla = idTipoPlanilla;
    }

    public String getNombreTipoPlanilla() {
        return nombreTipoPlanilla;
    }

    public void setNombreTipoPlanilla(String nombreTipoPlanilla) {
        this.nombreTipoPlanilla = nombreTipoPlanilla;
    }
      private String nombreTipoPlanilla;
      
      private List<Compania> listaCompanias;

    public List<Compania> getListaCompanias() {
        listaCompanias = companiasFacade.findAll();
        return listaCompanias;
    }

    public void setListaCompanias(List<Compania> listaCompanias) {
        this.listaCompanias = listaCompanias;
    }
      
      
      
      private List<TipoPlanilla> ListaTiposPlanilla;

    public List<TipoPlanilla> getListaTiposPlanilla() {
        ListaTiposPlanilla = tipoPlanillaFacade.findAll();
        return ListaTiposPlanilla;
    }

    public void setListaTiposPLanilla(List<TipoPlanilla> ListaTiposPlanilla) {
        this.ListaTiposPlanilla = ListaTiposPlanilla;
    }
      //-------
    
    private TipoPlanilla tipoPlanillaSeleccionado;

    public TipoPlanilla getTipoPlanillaSeleccionado() {
        return tipoPlanillaSeleccionado;
    }

    public void setTipoPlanillaSeleccionado(TipoPlanilla tipoPlanillaSeleccionado) {
        this.tipoPlanillaSeleccionado = tipoPlanillaSeleccionado;
    }
    
    // =============================================================================================
      public String guardar_action(){
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ha guardado el Tipo Planilla", ""));
      TipoPlanilla e = new TipoPlanilla();
      e.setNomTipoPlanilla(nombreTipoPlanilla);
      e.setTipoPlanillaPK(new TipoPlanillaPK(1 ,idTipoPlanilla) );
      tipoPlanillaFacade.create(e);
      idTipoPlanilla = null;
      nombreTipoPlanilla = null;
      e.setNomTipoPlanilla(null);
      e.setTipoPlanillaPK(null);
      
      return null;
      }
            
      
            
            
    
}
