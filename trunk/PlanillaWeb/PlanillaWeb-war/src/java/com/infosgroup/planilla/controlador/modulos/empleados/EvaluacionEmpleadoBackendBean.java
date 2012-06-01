/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Respuesta;
import com.infosgroup.planilla.modelo.entidades.RespuestaPK;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.Pregunta;
import com.infosgroup.planilla.modelo.estructuras.PreguntaRespuesta;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
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
@ManagedBean(name = "empleados$evaluacionEmpleado")
@ViewScoped
public class EvaluacionEmpleadoBackendBean extends AbstractJSFPage implements Serializable
{

    @EJB
    private EmpleadosSessionBean empleadosBean;
    // ==
    private List<Pregunta> listaPreguntas;
    private transient DataTable[] wizardTable;
    private Integer ultimoTab;

    public Integer getUltimoTab()
    {
        return ultimoTab;
    }

    public void setUltimoTab(Integer ultimoTab)
    {
        this.ultimoTab = ultimoTab;
    }

    public EvaluacionEmpleadoBackendBean()
    {
    }

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
        List<PreguntaRespuesta> l = new ArrayList<PreguntaRespuesta>();

        if ((actual > nuevo) && (actual >= wizardTable.length))
            {
            actual = wizardTable.length - 1;
            }

        DataTable tabla = wizardTable[actual];
        Integer filas = tabla.getRowCount();
        for (int fila = 0; fila < filas; fila++)
            {
            tabla.setRowIndex(fila);
            Pregunta p = (Pregunta) tabla.getRowData();
            String respuesta = p.getRespuesta();

            if (respuesta == null)
                continue;

            RespuestaPK respuestaPK = new RespuestaPK();
            PreguntaRespuesta pr = new PreguntaRespuesta();
            if ((p.getTipo() != 1) || (p.getTipo() == null))
                {
                respuestaPK.setCodCia(getSessionBeanADM().getCompania().getCodCia());
                respuestaPK.setCodTipoRespuesta(2L);
                respuestaPK.setCodRespuesta(1);
                pr.setValor(p.getRespuesta());
                }
            else
                {
                String[] desco = respuesta.split(":");
                respuestaPK.setCodCia(Short.parseShort(desco[0]));
                respuestaPK.setCodTipoRespuesta(Integer.parseInt(desco[1]));
                respuestaPK.setCodRespuesta(Integer.parseInt(desco[2]));
                }
            pr.setPregunta(p);
            Respuesta r = empleadosBean.findRespuestaById(respuestaPK);
            pr.setRespuesta(r);

            l.add(pr);

            }
        sessionBeanEMP.getDetalleEvaluacionTemporal().get(actual).setRespuestas(l);
        //if (nuevo < 999)
        if (nuevo < (ultimoTab - 1))
            {
            DetalleEvaluacion detalle = listaDetalleEvaluacion.get(nuevo);
            //getSessionBeanEMP().setFactor(getSessionBeanEMP().getListaFactores().get(nuevo));
            getSessionBeanEMP().setFactorActual(detalle.getFactor());
            }

        listaPreguntas = new ArrayList<Pregunta>();
        List<com.infosgroup.planilla.modelo.entidades.Pregunta> lPregs = empleadosBean.listarPreguntasPorFactor(getSessionBeanEMP().getFactorActual());
        for (com.infosgroup.planilla.modelo.entidades.Pregunta p : lPregs)
            {
            Pregunta pr = new Pregunta();
            pr.setPreguntaPK(p.getPreguntaPK());
            pr.setFactor(p.getFactor());
            pr.setDescripcion(p.getDescripcion());
            pr.setRespuestaList(p.getRespuestaList());
            pr.setTipo(((p.getRespuestaList() != null) && (!p.getRespuestaList().isEmpty())) ? p.getRespuestaList().get(0).getRespuestaPK().getCodTipoRespuesta() : 0);
            listaPreguntas.add(pr);
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

    @PostConstruct
    public void init()
    {
        ultimoTab = getSessionBeanEMP().getListaFactores().size() + 1;
        wizardTable = new DataTable[getSessionBeanEMP().getListaFactores().size()];
        listaPreguntas = new ArrayList<Pregunta>();
        List<com.infosgroup.planilla.modelo.entidades.Pregunta> lPregs = empleadosBean.listarPreguntasPorFactor(getSessionBeanEMP().getFactorActual());
        for (com.infosgroup.planilla.modelo.entidades.Pregunta p : lPregs)
            {
            Pregunta pr = new Pregunta();
            pr.setPreguntaPK(p.getPreguntaPK());
            pr.setFactor(p.getFactor());
            pr.setDescripcion(p.getDescripcion());
            pr.setTipo(((p.getRespuestaList() != null) && (!p.getRespuestaList().isEmpty())) ? p.getRespuestaList().get(0).getRespuestaPK().getCodTipoRespuesta() : 0);
            pr.setRespuestaList(p.getRespuestaList());
            listaPreguntas.add(pr);
            }
    }
}
