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
import java.util.ArrayList;
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
    private List<DetallePlanilla> listaPlaDetalles;
    private DataTable tablaDetalles;
    private DataTable tablaPrueba;
    private Long pla;
    private Long anio;
    private Long mes;

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    public Long getPla() {
        return pla;
    }

    public void setPla(Long pla) {
        this.pla = pla;
    }

    public DataTable getTablaDetalles() {
        return tablaDetalles;
    }

    public void setTablaDetalles(DataTable tablaDetalles) {
        this.tablaDetalles = tablaDetalles;
    }

    public DataTable getTablaPrueba() {
        return tablaPrueba;
    }

    public void setTablaPrueba(DataTable tablaPrueba) {
        this.tablaPrueba = tablaPrueba;
    }

    public List<DetallePlanilla> getListaPlaDetalles() {
        return listaPlaDetalles;
    }

    public void setListaPlaDetalles(List<DetallePlanilla> listaPlaDetalles) {
        this.listaPlaDetalles = listaPlaDetalles;
    }

//    public void onRowSelectDetalle(SelectEvent event){
//        setListaDetalles(planillaSessionBean.getDetalle((DetallePlanilla) event.getObject()));
//    }
    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String buscarPlanilla$action() {
        listaPlaDetalles = planillaSessionBean.getDetallesPla(pla, anio, mes);
//        getListaPlaDetalles();
        return null;
    }
}
