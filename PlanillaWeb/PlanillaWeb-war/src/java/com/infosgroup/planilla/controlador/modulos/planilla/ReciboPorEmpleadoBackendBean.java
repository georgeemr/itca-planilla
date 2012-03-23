/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.EmpleadosPK;
import com.infosgroup.planilla.modelo.entidades.MovDp;
import com.infosgroup.planilla.modelo.entidades.Planilla;
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
    private EmpleadosSessionBean empleadoSession;
    @EJB
    private ReportesStatelessBean reportesBean;
    
    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostConstruct
    public void init() {
        empleado = getSessionBeanEMP().getEmpleadoSesion();
        /*EmpleadosPK pk = new EmpleadosPK();
        pk.setCodCia(getSessionBeanADM().getCompania().getCodCia());
        pk.setCodEmp(169);
        empleado = empleadoSession.buscarEmpleadoPorPK(pk);*/
    }
    //Variables-----------------------------------------------------------------
    private Empleados empleado;
    private Planilla planillaSeleccionada;
    private AutocompletePlanillaConverter planillaConverter;
    private List<MovDp> listaPrestaciones;
    private List<MovDp> listaDeducciones;

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
        planillaConverter = new AutocompletePlanillaConverter(planillaSessionBean.findPlaByEmp(empleado));
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
            Short anio = planillaSeleccionada.getPlanillaPK().getAnio();
            Short cia = planillaSeleccionada.getPlanillaPK().getCodCia();
            Short depto = planillaSeleccionada.getCodDepto();
            Short tipo = planillaSeleccionada.getPlanillaPK().getCodTipopla();
            Short mes = planillaSeleccionada.getPlanillaPK().getMes();
            Short numPla = planillaSeleccionada.getPlanillaPK().getNumPlanilla();
            Integer codEmp = planillaSeleccionada.getPlanillaPK().getCodEmp();

            HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pAnio", anio.toString());
            parametros.put("pCia", cia.toString());
            parametros.put("pCodDepto", depto.toString());
            parametros.put("pCodPla", tipo.toString());
            parametros.put("pMes", mes.toString());
            parametros.put("pNumPla", numPla.toString());
            parametros.put("pEmp", codEmp.toString());
            reportesBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "RPLA018", FormatoReporte.PDF);
        }
        return null;
    }
}
