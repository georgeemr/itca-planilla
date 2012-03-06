/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.*;
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

 @author root
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
    throw new UnsupportedOperationException("Not supported yet.");
}
private List<Empleados> listaPuestosEmpleados;

public List<Empleados> getListaPuestosEmpleados()
{
    return listaPuestosEmpleados;
}

public void setListaPuestosEmpleados(List<Empleados> listaPuestosEmpleados)
{
    this.listaPuestosEmpleados = listaPuestosEmpleados;
}

// =========================================================================================================
@PostConstruct
public void init()
{
    listaCampanias = empleadosBean.listarCampanias(getSessionBeanADM().getCompania());
    listaPuestosEmpleados = empleadosBean.listarPuestosEmpleados(getSessionBeanADM().getCompania());
}
private List<SelectItem> puestosOptions;

public List<SelectItem> getPuestosOptions()
{
    List<Puestos> listaPuestos = empleadosBean.listarPuestos();
    List<SelectItem> nuevaLista = new ArrayList<SelectItem>(0);
    for (Puestos p : listaPuestos)
        {
        nuevaLista.add(new SelectItem(p.getNomPuesto(), p.getNomPuesto()));
        }
    puestosOptions = new ArrayList<SelectItem>(0);
    puestosOptions.addAll(nuevaLista);
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
    listaPlantillas = empleadosBean.listarPlantillasPorTipoEvaluacion(tipoEvaluacionSeleccionada);
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
    if (campaniaSeleccionada == null)
        {
        addMessage("PlanillaWeb", "Seleccione la campa&ntilde;a", TipoMensaje.ADVERTENCIA);
        HayError = Boolean.TRUE;
        }
    if (tipoEvaluacionSeleccionada == null)
        {
        addMessage("PlanillaWeb", "Seleccione el tipo de evaluaci&oacute;n", TipoMensaje.ADVERTENCIA);
        HayError = Boolean.TRUE;
        }
    if (plantillaSeleccionada == null)
        {
        addMessage("PlanillaWeb", "Seleccione la plantilla", TipoMensaje.ADVERTENCIA);
        HayError = Boolean.TRUE;
        }
    if ((sessionBeanEMP.getPuestosEmpleadosEvaluadores() == null) || (sessionBeanEMP.getPuestosEmpleadosEvaluadores().length == 0))
        {
        addMessage("PlanillaWeb", "Seleccione al menos un empleado como evaluador", TipoMensaje.ADVERTENCIA);
        HayError = Boolean.TRUE;
        }
    if ((sessionBeanEMP.getPuestosEmpleadosEvaluados() == null) || (sessionBeanEMP.getPuestosEmpleadosEvaluados().length == 0))
        {
        addMessage("PlanillaWeb", "Seleccione al menos un empleado a evaluar", TipoMensaje.ADVERTENCIA);
        HayError = Boolean.TRUE;
        }

    if (HayError)
        {
        return null;
        }

    List<Evaluacion> evaluaciones = null;

    if (empleadosBean.tieneEvaluaciones(campaniaSeleccionada))
        {
        addMessage("PlanillaWeb", "La campa&ntilde;a seleccionada ya tiene definidos tipo de evaluaci&oacute;n y plantilla", TipoMensaje.ADVERTENCIA);
        evaluaciones = campaniaSeleccionada.getEvaluacionList();
        }
    else
        {
        evaluaciones = new ArrayList<Evaluacion>(0);
        for (Empleados puestoEmpleado : sessionBeanEMP.getPuestosEmpleadosEvaluados())
            {
            EvaluacionPK evaluacionPK = new EvaluacionPK();
            evaluacionPK.setCodCia(campaniaSeleccionada.getCampaniaPK().getCodCia());
            evaluacionPK.setPeriodo(campaniaSeleccionada.getCampaniaPK().getPeriodo());
            evaluacionPK.setCodCampania(campaniaSeleccionada.getCampaniaPK().getCodCampania());
            evaluacionPK.setTipoEvaluacion(plantillaSeleccionada.getPlantillaPK().getCodTipoEvaluacion());
            evaluacionPK.setPlantilla(plantillaSeleccionada.getPlantillaPK().getCodPlantilla());
            evaluacionPK.setCodEmp(puestoEmpleado.getEmpleadosPK().getCodEmp());

            Evaluacion evaluacion = new Evaluacion();
            evaluacion.setEvaluacionPK(evaluacionPK);
            evaluacion.setCampania(campaniaSeleccionada);
            evaluacion.setPlantilla1(plantillaSeleccionada);
            evaluacion.setEmpleados(puestoEmpleado);
            evaluacion.setFecha(Calendar.getInstance().getTime());
            evaluacion.setFinalizada(0L);
            evaluaciones.add(evaluacion);
            }
        excepciones = empleadosBean.crearEvaluaciones(evaluaciones);
        mensaje = (excepciones == 0) ? "Todas las evaluaciones han sido creadas exitosamente" : "Ya se han definido " + excepciones + " de " + evaluaciones.size() + " evaluaciones para la campa&ntilde;a, plantilla y empleados seleccionados";
        addMessage("PlanillaWeb", mensaje, TipoMensaje.INFORMACION);

        excepciones = 0;
        for (Empleados puestoEmpleadoEvaluador : sessionBeanEMP.getPuestosEmpleadosEvaluadores())
            excepciones += empleadosBean.asignarEvaluaciones(evaluaciones, puestoEmpleadoEvaluador);
        mensaje = (excepciones == 0) ? "Todas las asignaciones de evaluaciones han sido creadas y/o modificadas exitosamente" : "Ya se habian definido " + excepciones + " de " + evaluaciones.size() + " asignaciones a evaluadores para la campa&ntilde;a y plantilla seleccionados";
        addMessage("PlanillaWeb", mensaje, TipoMensaje.INFORMACION);
        }
    return null;
}

public String defaultFlowListener(FlowEvent flowEvt)
{
    Boolean hayError = Boolean.FALSE;
    String anterior = flowEvt.getOldStep();
    Integer a = Integer.parseInt(anterior.replaceAll("tab", ""));
    switch (a)
        {
        case 0:
            hayError = (campaniaSeleccionada == null);
            hayError = (tipoEvaluacionSeleccionada == null);
            hayError = (plantillaSeleccionada == null);
            break;
        case 1:
            hayError = ((puestosEmpleadosEvaluadores == null) || (puestosEmpleadosEvaluadores.length == 0));
            if (!hayError)
                {
                sessionBeanEMP.setPuestosEmpleadosEvaluadores(puestosEmpleadosEvaluadores);
                }
            break;
        case 2:
            hayError = ((sessionBeanEMP.getPuestosEmpleadosEvaluados() == null) || (sessionBeanEMP.getPuestosEmpleadosEvaluados().length == 0));
            break;
        }
    return hayError ? flowEvt.getOldStep() : flowEvt.getNewStep();
}
private Empleados[] puestosEmpleadosEvaluadores;

public Empleados[] getPuestosEmpleadosEvaluadores()
{
    return puestosEmpleadosEvaluadores;
}

public void setPuestosEmpleadosEvaluadores(Empleados[] puestosEmpleadosEvaluadores)
{
    this.puestosEmpleadosEvaluadores = puestosEmpleadosEvaluadores;
}
}