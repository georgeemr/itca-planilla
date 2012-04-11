/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompletePlanillaConverter;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "planilla$reciboPorEmpleado")
@ViewScoped
public class ReciboPorEmpleadoBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    @EJB
    private ReportesStatelessBean reportesBean;
    private Empleados empleado;
    private Planilla planillaSeleccionada;
    private AutocompletePlanillaConverter planillaConverter;
    private List<MovDp> listaPrestaciones;
    private List<MovDp> listaDeducciones;
    private Short tipoPlanilla;
    private List<TiposPlanilla> listaTipos;

    @Override
    protected void limpiarCampos() {
        setListaPrestaciones(new ArrayList<MovDp>());
        setListaDeducciones(new ArrayList<MovDp>());
        setPlanillaSeleccionada(null);
    }

    @PostConstruct
    public void init() {
        empleado = getSessionBeanEMP().getEmpleadoSesion();
    }

    public void updateByTipoPlanilla(AjaxBehaviorEvent event) {
        limpiarCampos();
    }

    public List<TiposPlanilla> getListaTipos() {
        if ( isInRole("rrhh") ){
        listaTipos = planillaSessionBean.listarTipos(getSessionBeanADM().getCompania());
        }else{
        listaTipos = planillaSessionBean.listarTiposByEmpleado(getSessionBeanEMP().getEmpleadoSesion());
        }
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Planilla getPlanillaSeleccionada() {
        return planillaSeleccionada;
    }

    public void setPlanillaSeleccionada(Planilla planillaSeleccionada) {
        this.planillaSeleccionada = planillaSeleccionada;
    }

    public AutocompletePlanillaConverter getPlanillaConverter() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            planillaConverter = new AutocompletePlanillaConverter(planillaSessionBean.findPlaByEmp(empleado, tipoPlanilla));
        } else {
            planillaConverter = new AutocompletePlanillaConverter(new ArrayList<Planilla>());
        }
        return planillaConverter;
    }

    public void setPlanillaConverter(AutocompletePlanillaConverter planillaConverter) {
        this.planillaConverter = planillaConverter;
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

    public List<Planilla> completePlanillaEmpleado(String query) {
        List<Planilla> suggestions = new ArrayList<Planilla>();
        for (Planilla p : planillaConverter.listaPlanilla) {
            if (p.getPlanillaToString().contains(query)) {
                suggestions.add(p);
            }
        }
        return suggestions;
    }
    //Acciones------------------------------------------------------------------

    public void handleSelectPlanilla(SelectEvent event) {
        listaDeducciones = planillaSessionBean.findDeduccionesPresta(planillaSeleccionada, "R");
        listaPrestaciones = planillaSessionBean.findDeduccionesPresta(planillaSeleccionada, "S");
    }

    public String mostrar$reporte$action() {
        if (planillaSeleccionada == null) {
            addMessage("Reporte por Empleado", "No ha elegido ninguna planilla", TipoMensaje.INFORMACION);
            return null;
        } else {
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pAnio", String.valueOf(planillaSeleccionada.getPlanillaPK().getAnio()));
            parametros.put("pCia", String.valueOf(planillaSeleccionada.getPlanillaPK().getCodCia()));
            parametros.put("pCodDepto", String.valueOf(planillaSeleccionada.getCodDepto()));
            parametros.put("pCodPla", String.valueOf(planillaSeleccionada.getPlanillaPK().getCodTipopla()) );
            parametros.put("pMes", String.valueOf(planillaSeleccionada.getPlanillaPK().getMes()));
            parametros.put("pNumPla", String.valueOf( planillaSeleccionada.getPlanillaPK().getNumPlanilla() ));
            parametros.put("pEmp", String.valueOf( planillaSeleccionada.getPlanillaPK().getCodEmp()) );
            reportesBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "RPLA018", FormatoReporte.PDF);
        }
        return null;
    }
}
