/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reportes;

/**
 *
 * @author Soporte
 */

import com.infosgroup.planilla.modelo.entidades.Indicador;
import com.infosgroup.planilla.modelo.entidades.IndicadorPK;
import com.infosgroup.planilla.modelo.facades.IndicadorFacade;
import com.infosgroup.planilla.modelo.procesos.IndicadorSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="reportes$indicador")
@ViewScoped


public class IndicadorBackendBean extends AbstractJSFPage implements Serializable {
  @EJB
  private IndicadorSessionBean indicadorBean;
            
    private List <Indicador> indicadores;

    public List<Indicador> getIndicadores() {
        indicadores = indicadorBean.listarIndicadores();
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
            
}


