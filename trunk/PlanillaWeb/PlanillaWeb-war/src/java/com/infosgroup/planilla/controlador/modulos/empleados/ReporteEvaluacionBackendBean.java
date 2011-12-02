/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

private List<Empleado> listaEmpleados;

public List<Empleado> getListaEmpleados()
{
return listaEmpleados;
}

public void setListaEmpleados(List<Empleado> listaEmpleados)
{
this.listaEmpleados = listaEmpleados;
}

public String mostrarEmpleadosEvaluados$action()
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
    listaEmpleados = empleadosBean.listarEmpleadosEvaluados(sessionBeanEMP.getCampania());
    }
return null;
}

private Empleado empleadoSeleccionado;

public Empleado getEmpleadoSeleccionado()
{
return empleadoSeleccionado;
}

public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado)
{
this.empleadoSeleccionado = empleadoSeleccionado;
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

public String mostrarReporteEvaluacion$action()
{
return null;
}
}
