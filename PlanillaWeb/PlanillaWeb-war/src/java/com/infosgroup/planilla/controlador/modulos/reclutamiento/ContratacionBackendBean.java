/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import javax.ejb.EJB;
import java.util.List;
import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$contratacion")
@ViewScoped
public class ContratacionBackendBean extends JSFUtil implements Serializable {

    @EJB
    private ReclutamientoSessionBean reclutamientoSessionBean;
    private DataTable tableConcursos;
    private DataTable tableEvaluados;
    private List<Concurso> listaConcurso;
    private List<Candidato> listaCandidatos;
    private Candidato[] candidatosSeleccionados;

    public ContratacionBackendBean() {
    }

    public String onFlowListener(FlowEvent event) {

        if (event.getOldStep().equals("concursoEvaluado")) {
            if (getSessionBeanREC().getConcursoSeleccionado() == null) {
                addMessage("Contrataciones", "Seleccione un curso", TipoMensaje.ERROR);
                return event.getOldStep();
            }
        }

        return event.getNewStep();
    }

    @Override
    protected void limpiarCampos() {
        getSessionBeanREC().setConcursoSeleccionado(null);
    }

    public DataTable getTableConcursos() {
        return tableConcursos;
    }

    public void setTableConcursos(DataTable tableConcursos) {
        this.tableConcursos = tableConcursos;
    }

    public DataTable getTableEvaluados() {
        return tableEvaluados;
    }

    public void setTableEvaluados(DataTable tableEvaluados) {
        this.tableEvaluados = tableEvaluados;
    }

    public List<Concurso> getListaConcurso() {
        return reclutamientoSessionBean.getConcursosEvaluados(1L);
    }

    public void setListaConcurso(List<Concurso> listaConcursos) {
        this.listaConcurso = listaConcursos;
    }

    public List<Candidato> getListaCandidatos() {
        listaCandidatos = new ArrayList<Candidato>();
        if (getSessionBeanREC().getConcursoSeleccionado() != null) {
            listaCandidatos.addAll(getSessionBeanREC().getConcursoSeleccionado().getCandidatoList());
        }
        return listaCandidatos;
    }

    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    public Candidato[] getCandidatosSeleccionados() {
        return candidatosSeleccionados;
    }

    public void setCandidatosSeleccionados(Candidato[] candidatosSeleccionados) {
        this.candidatosSeleccionados = candidatosSeleccionados;
    }
}