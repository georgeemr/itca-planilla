/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
*
* @author root
*/
@ManagedBean(name = "empleados$seleccionEvaluacion")
@ViewScoped
public class SeleccionEvaluacionBackendBean extends JSFUtil implements Serializable
{
@EJB
private EmpleadosSessionBean empleadosBean;

/** Creates a new instance of SeleccionEvaluacionBackendBean */
public SeleccionEvaluacionBackendBean()
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

private List<Plantilla> listaPlantillas;

public List<Plantilla> getListaPlantillas()
{
listaPlantillas = empleadosBean.listarPlantillasPorTipoEvaluacion(sessionBeanEMP.getTipoEvaluacion()); //(getSessionBeanEMP().getTipoEvaluacion() != null) ? getSessionBeanEMP().getTipoEvaluacion().getPlantillaList() : null; //empleadosBean.listarPlantillasPorTipoEvaluacion(sessionBeanEMP.getTipoEvaluacion());
return listaPlantillas;
}

public void setListaPlantillas(List<Plantilla> listaPlantillas)
{
this.listaPlantillas = listaPlantillas;
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

public String mostrarEmpleadosNoEvaluados$action()
{
boolean hayError = false;
if (sessionBeanEMP.getCampania() == null)
    {
    addMessage("Seleccion de evaluacion", "Seleccione una campa&ntilde;a", TipoMensaje.ADVERTENCIA);
    hayError = true;
    }
if (!hayError)
    {
    addMessage("Seleccion de evaluacion", "Mostrando los empleados no evaluados para la campa&ntilde;a " + sessionBeanEMP.getCampania().getNombre(), TipoMensaje.INFORMACION);
    //listaEmpleados = empleadosBean.listarEmpleados();
    listaEmpleados = empleadosBean.listarEmpleadosNoEvaluados(sessionBeanEMP.getCampania());
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

public String evaluarEmpleado$action()
{
boolean hayError = false;
String outcome = null;

if (getSessionBeanEMP().getTipoEvaluacion() == null)
    {
    addMessage("Seleccion de evaluacion", "Seleccione un tipo de evaluaci&oacute;n", TipoMensaje.ADVERTENCIA);
    hayError = true;
    }

if (getSessionBeanEMP().getPlantilla() == null)
    {
    addMessage("Seleccion de evaluacion", "Seleccione una plantilla", TipoMensaje.ADVERTENCIA);
    hayError = true;
    }

if (empleadoSeleccionado == null)
    {
    addMessage("Evaluacion de empleados", "Seleccione un empleado para evaluarlo", TipoMensaje.ADVERTENCIA);
    hayError = true;
    }

if (!hayError)
    {
    // TODO: Listar los factores por la plantilla que el usuario ha seleccionado ;)
    List<Factor> listaFactores = empleadosBean.listarFactoresPorPlantilla(getSessionBeanEMP().getPlantilla());
    Factor primerFactor = ((listaFactores != null) && !listaFactores.isEmpty()) ? listaFactores.get(0) : null;

    List<DetalleEvaluacion> listaDetalleTemporal = new ArrayList<DetalleEvaluacion>(0);
    for (Factor f : listaFactores)
        {
        DetalleEvaluacion d = new DetalleEvaluacion();
        d.setFactor(f);
        d.setRespuestas(null);
        listaDetalleTemporal.add(d);
        }
    sessionBeanEMP.setDetalleEvaluacionTemporal(listaDetalleTemporal);

    sessionBeanEMP.setEmpleado(empleadoSeleccionado);
    sessionBeanEMP.setListaFactores(listaFactores);
    sessionBeanEMP.setFactor(primerFactor);
    //outcome = "evaluacionEmpleado?faces-redirect=true&includeViewParams=true";
    outcome = "evaluacionEmpleado?faces-redirect=true";
    }
return outcome;
}

public String seleccionCampania$action()
{
addMessage("", "Seleccionada campa&ntilde;a: " + getSessionBeanEMP().getCampania().getNombre(), TipoMensaje.INFORMACION);
return null;
}

public String seleccionTipoEvaluacion$action()
{
getSessionBeanEMP().setPlantilla(null);
addMessage("", "Seleccionado Tipo de evaluaci&oacute;n: " + getSessionBeanEMP().getTipoEvaluacion().getNomTipoEvaluacion(), TipoMensaje.INFORMACION);
return null;
}

public String seleccionPlantilla$action()
{
addMessage("", "Seleccionada plantilla: " + getSessionBeanEMP().getPlantilla().getNombre(), TipoMensaje.INFORMACION);
return null;
}
}
