/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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

///** Creates a new instance of SeleccionEvaluacionBackendBean */
//public SeleccionEvaluacionBackendBean()
//{
//}

@PostConstruct
public void init()
{
listaCampanias = empleadosBean.listarCampaniasPorEmpleado(sessionBeanEMP.getEmpleadoSesion());
}

private List<Campania> listaCampanias;

public List<Campania> getListaCampanias()
{
return listaCampanias;
}

public void setListaCampanias(List<Campania> listaCampanias)
{
this.listaCampanias = listaCampanias;
}

private List<Evaluacion> listaEvaluaciones;

public List<Evaluacion> getListaEvaluaciones()
{
listaEvaluaciones = (campaniaSeleccionada != null) ? empleadosBean.listarEvaluacionesAbiertasPorCampania(campaniaSeleccionada) : null;
return listaEvaluaciones;
}

public void setListaEvaluaciones(List<Evaluacion> listaEvaluaciones)
{
this.listaEvaluaciones = listaEvaluaciones;
}

@Override
protected void limpiarCampos()
{
throw new UnsupportedOperationException("Not supported yet.");
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

public String evaluarEmpleado$action()
{
boolean hayError = false;
String outcome = null;

if (getSessionBeanEMP().getEvaluacionSeleccionada() == null)
    {
    addMessage("Seleccion de evaluacion", "Seleccione un tipo de evaluaci&oacute;n", TipoMensaje.ADVERTENCIA);
    hayError = true;
    }
if (!hayError)
    {
    List<Factor> listaFactores = empleadosBean.listarFactoresPorPlantilla(getSessionBeanEMP().getEvaluacionSeleccionada().getPlantilla1());
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
    sessionBeanEMP.setListaFactores(listaFactores);
    sessionBeanEMP.setFactorActual(primerFactor);
    outcome = "evaluacionEmpleado?faces-redirect=true";
    }
return outcome;
}
}
