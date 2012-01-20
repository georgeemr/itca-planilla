/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.entidades.Respuesta;
import com.infosgroup.planilla.modelo.entidades.RespuestaPK;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.PreguntaRespuesta;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.List;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FlowEvent;

/**
*
* @author root
*/
@ManagedBean(name = "empleados$evaluacionEmpleado")
@ViewScoped
public class EvaluacionEmpleadoBackendBean extends AbstractJSFPage implements Serializable
{
@EJB
private EmpleadosSessionBean empleadosBean;

private List<Pregunta> listaPreguntas;

/** Creates a new instance of EvaluacionEmpleadoBackendBean */
public EvaluacionEmpleadoBackendBean()
{
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

public List<Pregunta> getListaPreguntas()
{
listaPreguntas = empleadosBean.listarPreguntasPorFactor(getSessionBeanEMP().getFactorActual());
return listaPreguntas;
}

public void setListaPreguntas(List<Pregunta> listaPreguntas)
{
this.listaPreguntas = listaPreguntas;
}

public String defaultFlowListener(FlowEvent event)
{
List<DetalleEvaluacion> listaDetalleEvaluacion = sessionBeanEMP.getDetalleEvaluacionTemporal();
Integer actual = Integer.parseInt(event.getOldStep().replaceAll("tab", "")) - 1;
Integer nuevo = Integer.parseInt(event.getNewStep().replaceAll("tab", "")) - 1;
List<PreguntaRespuesta> l = new ArrayList<PreguntaRespuesta>(0);

if (actual < nuevo)
    {
    DataTable tabla = wizardTable[actual];
    Integer filas = tabla.getRowCount();
    for (int fila = 0; fila < filas; fila++)
        {
        tabla.setRowIndex(fila);
        Pregunta p = (Pregunta) tabla.getRowData();
        String respuesta = p.getRespuestaSeleccionada();
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
        l.add(pr);
        }
    sessionBeanEMP.getDetalleEvaluacionTemporal().get(actual).setRespuestas(l);
    if (nuevo < 999)
        {
        DetalleEvaluacion detalle = listaDetalleEvaluacion.get(nuevo);
        //getSessionBeanEMP().setFactor(getSessionBeanEMP().getListaFactores().get(nuevo));
        getSessionBeanEMP().setFactorActual(detalle.getFactor());
        }
    }
return event.getNewStep();
}

public String cerrarEvaluacion$action()
{
return empleadosBean.cerrarEvaluacion(sessionBeanEMP.getEvaluacionSeleccionada(), sessionBeanEMP.getDetalleEvaluacionTemporal()) ? "seleccionEvaluacion?faces-redirect=true" : null;
}

@Override
protected void limpiarCampos()
{
}

}
