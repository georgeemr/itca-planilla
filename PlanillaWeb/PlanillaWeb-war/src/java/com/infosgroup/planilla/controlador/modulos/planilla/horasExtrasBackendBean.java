/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
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
    private int cia;
    private int tipo;
    private int planilla;
    private int sucursal;
    private List<ResumenAsistencia> horasExtras;
    private DataTable tablaHorasExtras;

    public int getCia() {
        return cia;
    }

    public void setCia(int cia) {
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

    public void rowEditListener(RowEditEvent event) {
        ResumenAsistencia resumen = (ResumenAsistencia) event.getObject();
        planillaSessionBean.editar$action(resumen);
    }

    public String mostrar$action() {
        horasExtras = planillaSessionBean.getAsistencia();
        return null;
    }

}
