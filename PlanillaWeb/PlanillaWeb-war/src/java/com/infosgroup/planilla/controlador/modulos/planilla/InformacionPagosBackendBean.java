/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
import com.infosgroup.planilla.modelo.estructuras.DetallePlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "planilla$informacionPagos")
@ViewScoped
public class InformacionPagosBackendBean extends JSFUtil implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<DetallePlanilla> listaDetalles;
    private DataTable tablaDetalles;
    private int pla;
    private int anio;
    private int mes;

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getPla() {
        return pla;
    }

    public void setPla(int pla) {
        this.pla = pla;
    }

    public DataTable getTablaDetalles() {
        return tablaDetalles;
    }

    public void setTablaDetalles(DataTable tablaDetalles) {
        this.tablaDetalles = tablaDetalles;
    }
 
    public List<DetallePlanilla> getListaDetalles() {
        //listaDetalles = planillaSessionBean.lisDetalle();
        listaDetalles = planillaSessionBean.listarDetalle(/*pla, anio, mes*/);
        return listaDetalles;
    }

    public void setListaDetalles(List<DetallePlanilla> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
    
    public void onRowSelectDetalle(SelectEvent event){
        setListaDetalles(planillaSessionBean.getDetalle((DetallePlanilla) event.getObject()));
    }
    
    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String buscarPlanilla$action(){
        getListaDetalles();
        return null;
    }
}
