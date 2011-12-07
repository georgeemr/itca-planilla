/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.DetalleAdjuntoCorreo;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.modelo.reportes.ReporteEvaluacion;
import com.infosgroup.planilla.view.JSFUtil;
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

;

/**
*
* @author root
*/
@ManagedBean(name = "empleados$reporteEvaluacion")
@ViewScoped
public class ReporteEvaluacionBackendBean extends JSFUtil implements Serializable
{
@EJB
private EmpleadosSessionBean empleadosBean;

@EJB
private ReportesStatelessBean reportesBean;

@EJB
private MailStatelessBean mailBean;

/** Creates a new instance of SeleccionEvaluacionBackendBean */
public ReporteEvaluacionBackendBean()
{
}

private List<Campania> listaCampanias;

public List<Campania> getListaCampanias()
{
listaCampanias = empleadosBean.listarCampanias();
return listaCampanias;
}

public void setListaCampanias(List<Campania> listaCampanias)
{
this.listaCampanias = listaCampanias;
}

private List<TipoEvaluacion> listaTiposEvaluacion;

public List<TipoEvaluacion> getListaTiposEvaluacion()
{
listaTiposEvaluacion = empleadosBean.listarTiposEvaluacion();
return listaTiposEvaluacion;
}

public void setListaTiposEvaluacion(List<TipoEvaluacion> listaTiposEvaluacion)
{
this.listaTiposEvaluacion = listaTiposEvaluacion;
}

private List<Evaluacion> listaEvaluaciones;

public List<Evaluacion> getListaEvaluaciones()
{
return listaEvaluaciones;
}

public void setListaEvaluaciones(List<Evaluacion> listaEvaluaciones)
{
this.listaEvaluaciones = listaEvaluaciones;
}

public String mostrarEvaluaciones$action()
{
boolean hayError = false;
if (sessionBeanEMP.getCampania() == null)
    {
    addMessage("Seleccion de evaluacion", "Seleccione una campa&ntilde;a", TipoMensaje.ADVERTENCIA);
    hayError = true;
    }
if (!hayError)
    {
    addMessage("Seleccion de evaluacion", "Mostrando los empleados evaluados en la campa&ntilde;a " + sessionBeanEMP.getCampania().getNombre(), TipoMensaje.INFORMACION);
    listaEvaluaciones = sessionBeanEMP.getCampania().getEvaluacionList(); //empleadosBean.listarEmpleadosEvaluados(sessionBeanEMP.getCampania());
    }
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

public String seleccionCampania$action()
{
addMessage("", "Seleccionada campa&ntilde;a: " + getSessionBeanEMP().getCampania().getNombre(), TipoMensaje.INFORMACION);
return null;
}

public String seleccionTipoEvaluacion$action()
{
addMessage("", "Seleccionado Tipo de evaluaci&oacute;n: " + getSessionBeanEMP().getTipoEvaluacion().getNomTipoEvaluacion(), TipoMensaje.INFORMACION);
return null;
}

@PermitAll
public String mostrarReporteEvaluacion$action()
{
List<ReporteEvaluacion> lr = reportesBean.listarReporteEvaluacion(evaluacionSeleccionada);
//mailBean.enviarCorreoElectronico("Correo de prueba", "Esta es una prueba de envio de correo electronico via GMail XD", "echopin@infosgroup.com");
List<DetalleAdjuntoCorreo> listaAdjuntos = new ArrayList<DetalleAdjuntoCorreo>(0);
listaAdjuntos.add(new DetalleAdjuntoCorreo("reporteprueba1.pdf", "application/pdf", reportesBean.generarDatosReporteBean(FacesContext.getCurrentInstance(), new HashMap<String, Object>(), "reporteEvaluacion", lr)));
listaAdjuntos.add(new DetalleAdjuntoCorreo("reporteprueba2.pdf", "application/pdf", reportesBean.generarDatosReporteBean(FacesContext.getCurrentInstance(), new HashMap<String, Object>(), "reporteEvaluacion", lr)));

String destinatarios = "gbran@infosgroup.com:echopin@infosgroup.com:vmercado@infosgroup.com:gsalazar@infosgroup.com";
mailBean.enviarCorreoElectronicoAdjuntos("Correo de prueba", "Prueba de correo con adjuntos", destinatarios, listaAdjuntos);
//reportesBean.generarReporteBean(FacesContext.getCurrentInstance(), new HashMap<String, Object>(), "reporteEvaluacion", lr);
return null;
}
}
