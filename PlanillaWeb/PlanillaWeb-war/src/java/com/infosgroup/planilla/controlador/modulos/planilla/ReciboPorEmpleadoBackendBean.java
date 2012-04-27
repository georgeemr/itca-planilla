/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompletePlanillaConverter;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.List;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private AutocompletePlanillaConverter planillaConverter = new AutocompletePlanillaConverter(new ArrayList<Planilla>());
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
        setEmpleado(getSessionBeanEMP().getEmpleadoSesion());
    }

    public void updateByTipoPlanilla(AjaxBehaviorEvent event) {
        limpiarCampos();
    }

    public List<TiposPlanilla> getListaTipos() {
        if (isInRole("rrhh")) {
            setListaTipos(planillaSessionBean.listarTipos(getSessionBeanADM().getCompania()));
        } else {
            setListaTipos(planillaSessionBean.listarTiposByEmpleado(getEmpleado()));
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
            setPlanillaConverter(new AutocompletePlanillaConverter(planillaSessionBean.findPlaByEmp(getEmpleado(), getTipoPlanilla())));
        } else {
            setPlanillaConverter(new AutocompletePlanillaConverter(new ArrayList<Planilla>()));
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
        for (Planilla p : getPlanillaConverter().listaPlanilla) {
            if (p.getPlanillaToString().contains(query)) {
                suggestions.add(p);
            }
        }
        return suggestions;
    }

    public void handleSelectPlanilla(SelectEvent event) {
        setListaDeducciones(planillaSessionBean.findDeduccionesPresta(getPlanillaSeleccionada(), "R"));
        setListaPrestaciones(new ArrayList<MovDp>());
        Double salario = (getPlanillaSeleccionada().getSueldoBase() != null) ? new Double(getPlanillaSeleccionada().getSueldoBase().doubleValue()) : new Double("0");
        Double diasLaborados = (getPlanillaSeleccionada().getSueldoBase() != null) ? new Double(getPlanillaSeleccionada().getDLaborados().doubleValue()) : new Double("0");
        salario = (salario / 30) * diasLaborados;
        setListaPrestaciones(planillaSessionBean.findDeduccionesPresta(getPlanillaSeleccionada(), "S"));
        listaPrestaciones.add(new MovDp(new DeducPresta("SALARIO"), null, BigDecimal.ZERO, new BigDecimal(salario), BigDecimal.ZERO, null, null, null));
    }

    public String okActionDialogEmpleado() {
        return null;
    }

    public String cancelActionDialogEmpleado() {
        setEmpleado(getSessionBeanEMP().getEmpleadoSesion());
        limpiarCampos();
        return null;
    }

    public String mostrar$reporte$action() {
        if (getPlanillaSeleccionada() == null) {
            addMessage("Reporte por Empleado", "No ha elegido ninguna planilla", TipoMensaje.INFORMACION);
            return null;
        } else {
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pAnio", String.valueOf(getPlanillaSeleccionada().getPlanillaPK().getAnio()));
            parametros.put("pCia", String.valueOf(getPlanillaSeleccionada().getPlanillaPK().getCodCia()));
            parametros.put("pCodDepto", String.valueOf(getPlanillaSeleccionada().getCodDepto()));
            parametros.put("pCodPla", String.valueOf(getPlanillaSeleccionada().getPlanillaPK().getCodTipopla()));
            parametros.put("pMes", String.valueOf(getPlanillaSeleccionada().getPlanillaPK().getMes()));
            parametros.put("pNumPla", String.valueOf(getPlanillaSeleccionada().getPlanillaPK().getNumPlanilla()));
            parametros.put("pEmp", String.valueOf(getPlanillaSeleccionada().getPlanillaPK().getCodEmp()));
            reportesBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "RPLA018", FormatoReporte.PDF);
        }
        return null;
    }
    private Double totalPrestaciones;
    private Double totalDeducciones;

    public Double getTotalDeducciones() {
        totalDeducciones = 0.0;
        if (listaDeducciones != null) {
            for (MovDp d : listaDeducciones) {
                if (d.getValor() != null) {
                    totalDeducciones += d.getValor().doubleValue();
                }
            }
        }
        return totalDeducciones;
    }

    public void setTotalDeducciones(Double totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
    }

    public Double getTotalPrestaciones() {
        totalPrestaciones = 0.0;
        if (listaPrestaciones != null) {
            for (MovDp d : listaPrestaciones) {
                if (d.getValor() != null) {
                    totalPrestaciones += d.getValor().doubleValue();
                }
            }
        }
        return totalPrestaciones;
    }

    public void setTotalPrestaciones(Double totalPrestaciones) {
        this.totalPrestaciones = totalPrestaciones;
    }
}
