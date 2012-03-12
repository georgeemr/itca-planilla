/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.reportes.ReporteEvaluacion;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**

 @author root
 */
@ManagedBean(name = "empleados$reporteEvaluacion")
@ViewScoped
public class ReporteEvaluacionBackendBean extends AbstractJSFPage implements Serializable
{

@EJB
private EmpleadosSessionBean empleadosSessionBean;
@EJB
private ReportesStatelessBean reportesBean;

public ReporteEvaluacionBackendBean()
{
}
private List<Campania> listaCampanias;

public List<Campania> getListaCampanias()
{
    listaCampanias = empleadosSessionBean.findAllByCia(getSessionBeanADM().getCompania().getCodCia());
    return listaCampanias;
}

public void setListaCampanias(List<Campania> listaCampanias)
{
    this.listaCampanias = listaCampanias;
}
private List<TipoEvaluacion> listaTiposEvaluacion;

public List<TipoEvaluacion> getListaTiposEvaluacion()
{
//listaTiposEvaluacion = empleadosBean.listarTiposEvaluacion();
    return listaTiposEvaluacion;
}

public void setListaTiposEvaluacion(List<TipoEvaluacion> listaTiposEvaluacion)
{
    this.listaTiposEvaluacion = listaTiposEvaluacion;
}
private List<Evaluacion> listaEvaluaciones;

public List<Evaluacion> getListaEvaluaciones()
{
    listaEvaluaciones = (campaniaSeleccionada != null) ? empleadosSessionBean.listarEvaluacionesAbiertasPorCampania(campaniaSeleccionada) : null;
    return listaEvaluaciones;
}

public void setListaEvaluaciones(List<Evaluacion> listaEvaluaciones)
{
    this.listaEvaluaciones = listaEvaluaciones;
}

public String mostrarEvaluaciones$action()
{
    return null;
}
private Evaluacion evaluacionSeleccionada;

public Evaluacion getEvaluacionSeleccionada()
{
    return evaluacionSeleccionada;
}

public void setEvaluacionSeleccionada(Evaluacion evaluacionSeleccionada)
{
    this.evaluacionSeleccionada = evaluacionSeleccionada;
}

@Override
protected void limpiarCampos()
{
    throw new UnsupportedOperationException("Not supported yet.");
}

public String seleccionTipoEvaluacion$action()
{
    return null;
}

@PermitAll
public String mostrarReporteEvaluacion$action()
{
    Evaluacion ev = evaluacionSeleccionada;
    if (ev == null)
        {
        addMessage("Reporte de Evalución", "No ha seleccionado ninguna evaluación", TipoMensaje.ERROR);
        return null;
        }

    HashMap<String, Object> parametros = new HashMap<String, Object>();

    List<ReporteEvaluacion> lr = reportesBean.listarReporteEvaluacion(ev);
    for (ReporteEvaluacion r : lr)
        r.setDetalleEvaluacion(reportesBean.getDetalleReporteEvaluacion(ev.getDetEvaluacionList()));
    reportesBean.generarReporteBean(FacesContext.getCurrentInstance(), parametros, "reporteEvaluacion", lr);
    return null;
}

@PermitAll
public static List<ReporteEvaluacion> listarReporteEvaluacion()
{
    return new ArrayList<ReporteEvaluacion>(10);
}
private Campania campaniaSeleccionada;

public Campania getCampaniaSeleccionada()
{
    return campaniaSeleccionada;
}

public void setCampaniaSeleccionada(Campania campaniaSeleccionada)
{
    this.campaniaSeleccionada = campaniaSeleccionada;
}
}