/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.MovDp;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.estructuras.DetallePlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class InformacionPagosBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<DetallePlanilla> listaPlaDetalles;
    private List<MovDp> listaPrestaciones;
    private List<MovDp> listaDeducciones;
    private DataTable tablaDetalles;
    private DataTable tablaPrueba;

    @PostConstruct
    public void init() {
        listaPlanillas = planillaSessionBean.listarPlanilla(getSessionBeanADM().getCompania());
    }
    private List<Planilla> listaPlanillas;

    public List<Planilla> getListaPlanillas() {
        return listaPlanillas;
    }

    public void setListaPlanillas(List<Planilla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public List<MovDp> getListaDeducciones() {
        return listaDeducciones;
    }

    public void setListaDeducciones(List<MovDp> listaDeducciones) {
        this.listaDeducciones = listaDeducciones;
    }

    public List<MovDp> getListaPrestaciones() {
        return listaPrestaciones;
    }

    public void setListaPrestaciones(List<MovDp> listaPrestaciones) {
        this.listaPrestaciones = listaPrestaciones;
    }
    
    private Planilla planillaSeleccionada;

    public Planilla getPlanillaSeleccionada() {
        return planillaSeleccionada;
    }

    public void setPlanillaSeleccionada(Planilla planillaSeleccionada) {
        this.planillaSeleccionada = planillaSeleccionada;
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

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String buscarPlanilla$action() {
        if (planillaSeleccionada == null) {
            addMessage("RRHH", "Seleccione la planilla", TipoMensaje.INFORMACION);
            return null;
        }
//        listaPlaDetalles = planillaSessionBean.getDetallesPla(planillaSeleccionada);
        return null;
    }
    
    public void onRowSelectPlanilla(SelectEvent event) {
        setPlanillaSeleccionada((Planilla) event.getObject());
        listaDeducciones = planillaSessionBean.findDeduccionesPresta(planillaSeleccionada, "R");
        listaPrestaciones = planillaSessionBean.findDeduccionesPresta(planillaSeleccionada, "S");
    }
}
