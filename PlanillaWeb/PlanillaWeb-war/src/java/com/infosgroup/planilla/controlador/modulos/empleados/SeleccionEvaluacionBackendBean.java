/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.entidades.Respuesta;
import com.infosgroup.planilla.modelo.entidades.RespuestaPK;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.PreguntaRespuesta;
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
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FlowEvent;

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

@PostConstruct
public void init()
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

private List<Evaluacion> listaEvaluaciones;

public List<Evaluacion> getListaEvaluaciones()
{
listaEvaluaciones = (campaniaSeleccionada != null) ? campaniaSeleccionada.getEvaluacionList() : null;
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

public String evaluarEmpleado$action()
{
boolean hayError = false;
if (evaluacionSeleccionada == null)
    {
    addMessage("Evaluacion de empleados", "Seleccione un empleado para evaluarlo", TipoMensaje.ADVERTENCIA);
    hayError = true;
    }

if (!hayError)
    {
    listaFactores = empleadosBean.listarFactoresPorPlantilla(evaluacionSeleccionada.getPlantilla1());
    factorActual = ((listaFactores != null) && !listaFactores.isEmpty()) ? listaFactores.get(0) : null;
    detalleEvaluacionTemporal = new ArrayList<DetalleEvaluacion>(0);
    for (Factor f : listaFactores)
        {
        DetalleEvaluacion d = new DetalleEvaluacion();
        d.setFactor(f);
        d.setRespuestas(null);
        detalleEvaluacionTemporal.add(d);
        }
    }
return null;
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

private Evaluacion evaluacionSeleccionada;

public Evaluacion getEvaluacionSeleccionada()
{
return evaluacionSeleccionada;
}

public void setEvaluacionSeleccionada(Evaluacion evaluacionSeleccionada)
{
this.evaluacionSeleccionada = evaluacionSeleccionada;
}

private Factor factorActual;

public Factor getFactorActual()
{
return factorActual;
}

public void setFactorActual(Factor factorActual)
{
this.factorActual = factorActual;
}

private List<Factor> listaFactores;

public List<Factor> getListaFactores()
{
if (evaluacionSeleccionada != null)
    {
    listaFactores = empleadosBean.listarFactoresPorPlantilla(evaluacionSeleccionada.getPlantilla1());
    }
return listaFactores;
}

public void setListaFactores(List<Factor> listaFactores)
{
this.listaFactores = listaFactores;
}

private List<DetalleEvaluacion> detalleEvaluacionTemporal;

public List<DetalleEvaluacion> getDetalleEvaluacionTemporal()
{
return detalleEvaluacionTemporal;
}

public void setDetalleEvaluacionTemporal(List<DetalleEvaluacion> detalleEvaluacionTemporal)
{
this.detalleEvaluacionTemporal = detalleEvaluacionTemporal;
}

// ==============================================================================================================
private List<Pregunta> listaPreguntas;

public List<Pregunta> getListaPreguntas()
{
listaPreguntas = empleadosBean.listarPreguntasPorFactor(factorActual);
return listaPreguntas;
}

public void setListaPreguntas(List<Pregunta> listaPreguntas)
{
this.listaPreguntas = listaPreguntas;
}

private DataTable[] wizardTable = new DataTable[15];

public DataTable[] getWizardTable()
{
return wizardTable;
}

public void setWizardTable(DataTable[] wizardTable)
{
this.wizardTable = wizardTable;
}

public String defaultFlowListener(FlowEvent event)
{
Integer actual = Integer.parseInt(event.getOldStep().replaceAll("tab", "")) - 1;
Integer nuevo = Integer.parseInt(event.getNewStep().replaceAll("tab", "")) - 1;
List<PreguntaRespuesta> preguntas_respuestas = new ArrayList<PreguntaRespuesta>(0);

if (actual < nuevo)
    {
    DataTable tabla = wizardTable[actual];
    Integer filas = tabla.getRowCount();
    for (int fila = 0; fila < filas; fila++)
        {
        tabla.setRowIndex(fila);
        Pregunta p = (Pregunta) tabla.getRowData();
        String respuesta = p.getRespuestaSeleccionada();
        if (respuesta != null)
            {
            String[] desco = respuesta.split(":");
            RespuestaPK respuestaPK = new RespuestaPK();
            respuestaPK.setCodCia(Integer.parseInt(desco[0]));
            respuestaPK.setCodTipoRespuesta(Integer.parseInt(desco[1]));
            respuestaPK.setGrupoRespuesta(Integer.parseInt(desco[2]));
            respuestaPK.setCodRespuesta(Integer.parseInt(desco[3]));

            PreguntaRespuesta pr = new PreguntaRespuesta();
            pr.setPregunta(p);
            Respuesta r = empleadosBean.findRespuestaById(respuestaPK);
            pr.setRespuesta(r);

            preguntas_respuestas.add(pr);
            }
        }
    detalleEvaluacionTemporal.get(actual).setRespuestas(preguntas_respuestas);
    if (nuevo < 999)
        {
        DetalleEvaluacion detalle = detalleEvaluacionTemporal.get(nuevo);
        factorActual = detalle.getFactor();
        }
    }
return event.getNewStep();
}

public String cerrarEvaluacion$action()
{
return empleadosBean.cerrarEvaluacion(campaniaSeleccionada, null, null, null, detalleEvaluacionTemporal) ? inicio$action() : null;
}
}
