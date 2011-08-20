/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.entidades.TipoPlanillaPK;
import com.infosgroup.planilla.modelo.facades.TipoPlanillaFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
      private TipoPlanillaFacade tipoPlanillaFacade;
      private Integer idTipoPlanilla;

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

    // =============================================================================================
      public String guardar_action(){
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
