/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.List;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "empleados$evaluacionEmpleado")
@ViewScoped
public class EvaluacionEmpleadoBackendBean extends JSFUtil implements Serializable {

    @EJB
    EmpleadosSessionBean empleadosBean;
    private List<Pregunta> listaPreguntas;

    /** Creates a new instance of EvaluacionEmpleadoBackendBean */
    public EvaluacionEmpleadoBackendBean() {
    }

    public List<Pregunta> getListaPreguntas() {
        listaPreguntas = empleadosBean.listarPreguntasPorFactor(getSessionBeanEMP().getFactor());
        return listaPreguntas;
    }

    public void setListaPreguntas(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public String defaultFlowListener(FlowEvent event) {
        Integer i = Integer.parseInt(event.getNewStep().replaceAll("tab", "")) - 1;
        if (i >= 0) {
            getSessionBeanEMP().setFactor(getSessionBeanEMP().getListaFactores().get(i));
        }
        return event.getNewStep();
    }

    @Override
    protected void limpiarCampos() {
    }
    
    
}
