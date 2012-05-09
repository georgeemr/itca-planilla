/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reportes;

/**
 *
 * @author Soporte
 */
import com.infosgroup.planilla.modelo.estructuras.ModelIndicadores;
import com.infosgroup.planilla.modelo.procesos.IndicadorSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "reportes$indicador")
@ViewScoped
public class IndicadorBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private IndicadorSessionBean indicadorBean;
    private List<ModelIndicadores> modelIndicadores;
    private Date fechaInicial;
    private Date fechaFinal;
    
//    @PostConstruct
//    public void _init(){
//        setFechaInicial(new Date());
//        setFechaFinal(new Date());
//    }

    public List<ModelIndicadores> getModelIndicadores() {
        return modelIndicadores;
    }

    public void setModelIndicadores(List<ModelIndicadores> modelIndicadores) {
        this.modelIndicadores = modelIndicadores;
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
    
    public String aplicar(){
        
        if (!validaFechas(fechaInicial, fechaFinal)) {
            addMessage("Indicadores", "Los rangos de fecha no son consistentes.", TipoMensaje.ERROR);
            return null;
        }
        setModelIndicadores(new ArrayList<ModelIndicadores>());
        indicadorBean.calcularIndicadores(getSessionBeanADM().getCompania(), fechaInicial, fechaFinal);
        setModelIndicadores ( indicadorBean.listaIndicadores(getSessionBeanADM().getCompania()));
        return null;
    }
    
    @Override
    protected void limpiarCampos() {
        setFechaInicial(new Date());
        setFechaFinal(new Date());
        setModelIndicadores(new ArrayList<ModelIndicadores>());
    }
}
