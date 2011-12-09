/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "planilla$horasExtras")
@ViewScoped
public class horasExtrasBackendBean extends JSFUtil implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Integer cia = 1;
    private int tipo;
    private int planilla;
    private int sucursal;
    private List<ResumenAsistencia> horasExtras;
    private DataTable tablaHorasExtras;
    private List<Compania> listaCias;
    private List<TipoPlanilla> listaTipos;
    private List<Planilla> listaPlanillas;
    private List<Sucursal> listaSucursales;

    public List<Sucursal> getListaSucursales() {
        listaSucursales = planillaSessionBean.listarSucursal();
        return listaSucursales;
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public List<Planilla> getListaPlanillas() {
        listaPlanillas = planillaSessionBean.listarPlanilla();
        return listaPlanillas;
    }

    public void setListaPlanillas(List<Planilla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public List<TipoPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos();
        return listaTipos;
    }

    public void setListaTipos(List<TipoPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public List<Compania> getListaCias() {
        listaCias = planillaSessionBean.listarCias();
        return listaCias;
    }

    public void setListaCias(List<Compania> listaCias) {
        this.listaCias = listaCias;
    }

    public Integer getCia() {
        return cia;
    }

    public void setCia(Integer cia) {
        this.cia = cia;
    }

    public int getPlanilla() {
        return planilla;
    }

    public void setPlanilla(int planilla) {
        this.planilla = planilla;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<ResumenAsistencia> getHorasExtras() {

        return horasExtras;
    }

    public void setHorasExtras(List<ResumenAsistencia> horasExtras) {
        this.horasExtras = horasExtras;
    }

    public DataTable getTablaHorasExtras() {
        return tablaHorasExtras;
    }

    public void setTablaHorasExtras(DataTable tablaHorasExtras) {
        this.tablaHorasExtras = tablaHorasExtras;
    }

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//    public void onRowSelectDetalle(SelectEvent event){
//        setHorasExtras(planillaSessionBean.getResumen((ResumenAsistencia)event.getObject()));
//    }
    public void rowEditListener(RowEditEvent event) {
        boolean hayError = false;
        ResumenAsistencia resumen = (ResumenAsistencia) event.getObject();
        //setHorasExtras(planillaSessionBean.getResumen(resumen));
        if(resumen.getEstadoPla().equals('G')){
            hayError = true;
        }
        if (hayError) {
            planillaSessionBean.editar$action(resumen);
        } else {
            addMessage("Registro de Resumen de Asistencias", "La planilla no está en estado gravado", TipoMensaje.INFORMACION);
        }
        mostrar$action();
    }

    public String mostrar$action() {
        horasExtras = planillaSessionBean.getAsistencia();
        return null;
    }

}
