/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$preseleccionAspirante")
@ViewScoped
public class PreseleccionAspiranteBackendBean extends JSFUtil implements Serializable {

    @EJB
    private ReclutamientoSessionBean reclutamientoSessionBean;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Concurso> listaConcurso;
    private List<Candidato> listaCandidato;
    private Candidato[] candidatosSeleccionados;
    private DataTable tableCandidatos;
    private DataTable tableConcursos;
    private List<CriteriosXPuesto> fuente = new ArrayList<CriteriosXPuesto>();
    private List<CriteriosXPuesto> objetivo = new ArrayList<CriteriosXPuesto>();
    private DualListModel<CriteriosXPuesto> listModelCriterios = new DualListModel<CriteriosXPuesto>();

    public DualListModel<CriteriosXPuesto> getListModelCriterios() {
        return listModelCriterios;
    }

    public void setListModelCriterios(DualListModel<CriteriosXPuesto> listModelCriterios) {
        this.listModelCriterios = listModelCriterios;
    }

    public List<CriteriosXPuesto> getFuente() {
        return fuente;
    }

    public void setFuente(List<CriteriosXPuesto> fuente) {
        this.fuente = fuente;
    }

    public List<CriteriosXPuesto> getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(List<CriteriosXPuesto> objetivo) {
        this.objetivo = objetivo;
    }

    public DataTable getTableConcursos() {
        return tableConcursos;
    }

    public void setTableConcursos(DataTable tableConcursos) {
        this.tableConcursos = tableConcursos;
    }

    public DataTable getTableCandidatos() {
        return tableCandidatos;
    }

    public void setTableCandidatos(DataTable tableCandidatos) {
        this.tableCandidatos = tableCandidatos;
    }

    public Candidato[] getCandidatosSeleccionados() {
        return candidatosSeleccionados;
    }

    public void setCandidatosSeleccionados(Candidato[] candidatosSeleccionados) {
        this.candidatosSeleccionados = candidatosSeleccionados;
    }

    public PreseleccionAspiranteBackendBean() {
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public List<Concurso> getListaConcurso() {
        return listaConcurso;
    }

    public void setListaConcurso(List<Concurso> listaConcurso) {
        this.listaConcurso = listaConcurso;
    }

    public List<Candidato> getListaCandidato() {
        return listaCandidato;
    }

    public void setListaCandidato(List<Candidato> listaCandidato) {
        this.listaCandidato = listaCandidato;
    }

    public String buscarConcurso$action() {
        if (fechaInicial != null && fechaFinal != null) {
            if (validaFechas(fechaInicial, fechaFinal) == true) {
                setListaConcurso(reclutamientoSessionBean.getListaConcursos(fechaInicial, fechaFinal));
            } else {
                addMessage("Buscar concurso", "Los rangos de fecha Ingresados no son consistentes.", TipoMensaje.ERROR);
            }
        }
        setListaConcurso(reclutamientoSessionBean.getListaConcursos(fechaInicial, fechaFinal));
        limpiarCampos();
        return null;
    }

    public String preseleccionarCandidato$action() {
        if (candidatosSeleccionados == null || candidatosSeleccionados.length <= 0) {
            addMessage("Preselección de Candidatos.", "No ha seleccionado ningún Candidato.", TipoMensaje.ERROR);
            return null;
        }
        if (getSessionBeanREC().getConcursoSeleccionado() == null) {
            addMessage("Preselección de Candidatos.", "No ha seleccionado ningún Concurso.", TipoMensaje.ERROR);
            return null;
        }

        reclutamientoSessionBean.CambioEstadoCandidato(getSessionBeanREC().getConcursoSeleccionado(), Arrays.asList(candidatosSeleccionados), "P");
        addMessage("Preselección de Candidatos.", "Datos Guardados. Total de elementos agregados: " + candidatosSeleccionados.length, TipoMensaje.INFORMACION);
        return null;
    }

    public void onRowSelectConcurso(SelectEvent event) {
        getSessionBeanREC().setConcursoSeleccionado((Concurso) event.getObject());
        setListaCandidato(reclutamientoSessionBean.getCandidatosByConcurso(getSessionBeanREC().getConcursoSeleccionado()));
        DualListModel<CriteriosXPuesto> c = new DualListModel<CriteriosXPuesto>();
        c.setSource(getSessionBeanREC().getConcursoSeleccionado().getPuesto().getCriteriosXPuestoList()); //getCriteriosXPuestoList()
        c.setTarget(new ArrayList<CriteriosXPuesto>());
        setListModelCriterios(c);
    }

    public String onFlowListener(FlowEvent event) {

        if (event.getOldStep().equals("concursoSeleccionado")) {
            if (getSessionBeanREC().getConcursoSeleccionado() == null) {
                addMessage("Contrataciones", "Seleccione un curso", TipoMensaje.ERROR);
                return event.getOldStep();
            }
        }

        return event.getNewStep();
    }

    @Override
    protected void limpiarCampos() {
        setFechaInicial(null);
        setFechaFinal(null);
        tableConcursos.setSelection(null);
        candidatosSeleccionados = null;
        tableConcursos.setSelection(null);
        listaCandidato = new ArrayList<Candidato>();
        getSessionBeanREC().setConcursoSeleccionado(null);
    }
}