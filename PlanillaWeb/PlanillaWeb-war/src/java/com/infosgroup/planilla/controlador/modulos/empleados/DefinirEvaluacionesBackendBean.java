/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.EvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.Puesto;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleado;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.primefaces.event.FlowEvent;

/**
*
* @author root
*/
@ManagedBean(name = "empleados$definirEvaluaciones")
@ViewScoped
public class DefinirEvaluacionesBackendBean extends AbstractJSFPage implements Serializable
{

@EJB
private EmpleadosSessionBean empleadosBean;

@Override
protected void limpiarCampos()
{
throw new UnsupportedOperationException( "Not supported yet." );
}
private List<PuestoEmpleado> listaPuestosEmpleados;

public List<PuestoEmpleado> getListaPuestosEmpleados()
{
return listaPuestosEmpleados;
}

public void setListaPuestosEmpleados(List<PuestoEmpleado> listaPuestosEmpleados)
{
this.listaPuestosEmpleados = listaPuestosEmpleados;
}

// =========================================================================================================
@PostConstruct
public void init()
{
listaCampanias = empleadosBean.listarCampanias();
listaPuestosEmpleados = empleadosBean.listarPuestosEmpleados();
}
private List<SelectItem> puestosOptions;

public List<SelectItem> getPuestosOptions()
{
List<Puesto> listaPuestos = empleadosBean.listarPuestos();
List<SelectItem> nuevaLista = new ArrayList<SelectItem>( 0 );
for (Puesto p : listaPuestos)
    {
    nuevaLista.add( new SelectItem( p.getNombre(), p.getNombre() ) );
    }
puestosOptions = new ArrayList<SelectItem>( 0 );
puestosOptions.addAll( nuevaLista );
return puestosOptions;
}

public void setPuestosOptions(List<SelectItem> puestosOptions)
{
this.puestosOptions = puestosOptions;
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
private Campania campaniaSeleccionada;

public Campania getCampaniaSeleccionada()
{
return campaniaSeleccionada;
}

public void setCampaniaSeleccionada(Campania campaniaSeleccionada)
{
this.campaniaSeleccionada = campaniaSeleccionada;
}
private List<TipoEvaluacion> listaTiposEvaluaciones;

public List<TipoEvaluacion> getListaTiposEvaluaciones()
{
listaTiposEvaluaciones = empleadosBean.listarTiposEvaluacion();
return listaTiposEvaluaciones;
}

public void setListaTiposEvaluaciones(List<TipoEvaluacion> listaTiposEvaluaciones)
{
this.listaTiposEvaluaciones = listaTiposEvaluaciones;
}
private TipoEvaluacion tipoEvaluacionSeleccionada;

public TipoEvaluacion getTipoEvaluacionSeleccionada()
{
return tipoEvaluacionSeleccionada;
}

public void setTipoEvaluacionSeleccionada(TipoEvaluacion tipoEvaluacionSeleccionada)
{
this.tipoEvaluacionSeleccionada = tipoEvaluacionSeleccionada;
}
private List<Plantilla> listaPlantillas;

public List<Plantilla> getListaPlantillas()
{
listaPlantillas = empleadosBean.listarPlantillasPorTipoEvaluacion( tipoEvaluacionSeleccionada );
return listaPlantillas;
}

public void setListaPlantillas(List<Plantilla> listaPlantillas)
{
this.listaPlantillas = listaPlantillas;
}
private Plantilla plantillaSeleccionada;

public Plantilla getPlantillaSeleccionada()
{
return plantillaSeleccionada;
}

public void setPlantillaSeleccionada(Plantilla plantillaSeleccionada)
{
this.plantillaSeleccionada = plantillaSeleccionada;
}

public String definirEvaluaciones$action()
{
Integer excepciones = 0;
Boolean HayError = Boolean.FALSE;
String mensaje = null;
if ( campaniaSeleccionada == null )
    {
    addMessage( "PlanillaWeb", "Seleccione la campa&ntilde;a", TipoMensaje.ADVERTENCIA );
    HayError = Boolean.TRUE;
    }
if ( tipoEvaluacionSeleccionada == null )
    {
    addMessage( "PlanillaWeb", "Seleccione el tipo de evaluaci&oacute;n", TipoMensaje.ADVERTENCIA );
    HayError = Boolean.TRUE;
    }
if ( plantillaSeleccionada == null )
    {
    addMessage( "PlanillaWeb", "Seleccione la plantilla", TipoMensaje.ADVERTENCIA );
    HayError = Boolean.TRUE;
    }
if ( (sessionBeanEMP.getPuestosEmpleadosEvaluadores() == null) || (sessionBeanEMP.getPuestosEmpleadosEvaluadores().length == 0) )
    {
    addMessage( "PlanillaWeb", "Seleccione al menos un empleado como evaluador", TipoMensaje.ADVERTENCIA );
    HayError = Boolean.TRUE;
    }
if ( (sessionBeanEMP.getPuestosEmpleadosEvaluados() == null) || (sessionBeanEMP.getPuestosEmpleadosEvaluados().length == 0) )
    {
    addMessage( "PlanillaWeb", "Seleccione al menos un empleado a evaluar", TipoMensaje.ADVERTENCIA );
    HayError = Boolean.TRUE;
    }

if ( HayError )
    {
    return null;
    }

List<Evaluacion> evaluaciones = null;

if ( empleadosBean.tieneEvaluaciones( campaniaSeleccionada ) )
    {
    addMessage( "PlanillaWeb", "La campa&ntilde;a seleccionada ya tiene definidos tipo de evaluaci&oacute;n y plantilla", TipoMensaje.ADVERTENCIA );
    evaluaciones = campaniaSeleccionada.getEvaluacionList();
    }
else
    {
    evaluaciones = new ArrayList<Evaluacion>( 0 );
    for (PuestoEmpleado puestoEmpleado : sessionBeanEMP.getPuestosEmpleadosEvaluados())
        {
        EvaluacionPK evaluacionPK = new EvaluacionPK();
        evaluacionPK.setCodCia( campaniaSeleccionada.getCampaniaPK().getCodCia() );
        evaluacionPK.setPeriodo( campaniaSeleccionada.getCampaniaPK().getPeriodo() );
        evaluacionPK.setCodCampania( campaniaSeleccionada.getCampaniaPK().getCodCampania() );
        evaluacionPK.setTipoEvaluacion( plantillaSeleccionada.getPlantillaPK().getCodTipoEvaluacion() );
        evaluacionPK.setPlantilla( plantillaSeleccionada.getPlantillaPK().getCodPlantilla() );
        evaluacionPK.setEmpleado( puestoEmpleado.getEmpleado().getEmpleadoPK().getCodEmp() );

        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setEvaluacionPK( evaluacionPK );
        evaluacion.setCampania( campaniaSeleccionada );
        evaluacion.setPlantilla1( plantillaSeleccionada );
        evaluacion.setEmpleado1( puestoEmpleado.getEmpleado() );
        evaluacion.setFecha( Calendar.getInstance().getTime() );
        evaluacion.setFinalizada( 0L );
        evaluaciones.add( evaluacion );
        }
    excepciones = empleadosBean.crearEvaluaciones( evaluaciones );
    mensaje = (excepciones == 0) ? "Todas las evaluaciones han sido creadas exitosamente" : "Ya se han definido " + excepciones + " de " + evaluaciones.size() + " evaluaciones para la campa&ntilde;a, plantilla y empleados seleccionados";
    addMessage( "PlanillaWeb", mensaje, TipoMensaje.INFORMACION );

    excepciones = 0;
    for (PuestoEmpleado puestoEmpleadoEvaluador : sessionBeanEMP.getPuestosEmpleadosEvaluadores())
        {
        excepciones += empleadosBean.asignarEvaluaciones( evaluaciones, puestoEmpleadoEvaluador.getEmpleado() );
        }
    mensaje = (excepciones == 0) ? "Todas las asignaciones de evaluaciones han sido creadas y/o modificadas exitosamente" : "Ya se habian definido " + excepciones + " de " + evaluaciones.size() + " asignaciones a evaluadores para la campa&ntilde;a y plantilla seleccionados";
    addMessage( "PlanillaWeb", mensaje, TipoMensaje.INFORMACION );
    }
return null;
}

public String defaultFlowListener(FlowEvent flowEvt)
{
Boolean HayError = Boolean.FALSE;
String anterior = flowEvt.getOldStep();
Integer a = Integer.parseInt( anterior.replaceAll( "tab", "" ) );
switch (a)
    {
case 0:
    HayError = (campaniaSeleccionada == null);
    HayError = (tipoEvaluacionSeleccionada == null);
    HayError = (plantillaSeleccionada == null);
    break;
case 1:
    HayError = ((puestosEmpleadosEvaluadores == null) || (puestosEmpleadosEvaluadores.length == 0));
    if (!HayError)
        sessionBeanEMP.setPuestosEmpleadosEvaluadores( puestosEmpleadosEvaluadores );
    break;
case 2:
    HayError = ((sessionBeanEMP.getPuestosEmpleadosEvaluados() == null) || (sessionBeanEMP.getPuestosEmpleadosEvaluados().length == 0));
    break;
    }
return HayError ? flowEvt.getOldStep() : flowEvt.getNewStep();
}

private PuestoEmpleado[] puestosEmpleadosEvaluadores;

public PuestoEmpleado[] getPuestosEmpleadosEvaluadores()
{
return puestosEmpleadosEvaluadores;
}

public void setPuestosEmpleadosEvaluadores(PuestoEmpleado[] puestosEmpleadosEvaluadores)
{
this.puestosEmpleadosEvaluadores = puestosEmpleadosEvaluadores;
}

//private PuestoEmpleado[] puestosEmpleadosEvaluados;
//
//public PuestoEmpleado[] getPuestosEmpleadosEvaluados()
//{
//return puestosEmpleadosEvaluados;
//}
//
//public void setPuestosEmpleadosEvaluados(PuestoEmpleado[] puestosEmpleadosEvaluados)
//{
//this.puestosEmpleadosEvaluados = puestosEmpleadosEvaluados;
//}
}
