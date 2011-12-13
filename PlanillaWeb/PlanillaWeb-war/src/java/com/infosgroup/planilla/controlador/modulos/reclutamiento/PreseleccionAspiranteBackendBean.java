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
import java.util.Arrays;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

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
    private DataTable tableConcursos;
    private DataTable tableCriterios;
    private DataTable tableCandidatos;

    public DataTable getTableConcursos() {
        return tableConcursos;
    }

    public void setTableConcursos(DataTable tableConcursos) {
        this.tableConcursos = tableConcursos;
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
        return reclutamientoSessionBean.getCandidatosByEmpresa(1L);
    }

    public DataTable getTableCandidatos() {
        return tableCandidatos;
    }

    public void setTableCandidatos(DataTable tableCandidatos) {
        this.tableCandidatos = tableCandidatos;
    }

    public DataTable getTableCriterios() {
        return tableCriterios;
    }

    public void setTableCriterios(DataTable tableCriterios) {
        this.tableCriterios = tableCriterios;
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
        return null;
    }

    public void onRowSelectConcurso(SelectEvent event) {
        getSessionBeanREC().setConcursoSeleccionado((Concurso) event.getObject());
    }

    public void onRowSelectCriterio(SelectEvent event) {
        reclutamientoSessionBean.guardarCriterioSeleccionado((CriteriosXPuesto) event.getObject(), getSessionBeanEMP().getEmpleadoSesion().getUsuario());
    }

    public void onRowUnSelectCriterio(UnselectEvent event) {
        reclutamientoSessionBean.eliminarCriterioSeleccionado((CriteriosXPuesto) event.getObject(), getSessionBeanEMP().getEmpleadoSesion().getUsuario());
    }

    public String onFlowListener(FlowEvent event) {
        if (getSessionBeanREC().getConcursoSeleccionado() == null) {
            return "concursoSeleccionado";
        }
        return event.getNewStep();
    }

    public String aplicarCriterios() {
        if (getSessionBeanREC().getConcursoSeleccionado() != null) {
            if (getSessionBeanREC().getCandidatosSeleccionados() != null) {
                reclutamientoSessionBean.preseleccionarCandidato(getSessionBeanREC().getConcursoSeleccionado(), Arrays.asList(getSessionBeanREC().getCandidatosSeleccionados()));
                addMessage("Preselección de Candidatos", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
                limpiarCampos();
                return "concursoSeleccionado";
            }
        }
        addMessage("Preselección de Candidatos", "No ha seleccionado ningún concurso, reinicie el asistente.", TipoMensaje.INFORMACION);
        return "concursoSeleccionado";
    }

    @Override
    protected void limpiarCampos() {
        setFechaInicial(null);
        setFechaFinal(null);
        tableConcursos.setSelection(null);
        tableCriterios.setSelection(null);
        tableCandidatos.setSelection(null);
        reclutamientoSessionBean.eliminarCriteriosSeleccionados(getSessionBeanADM().getCompania().getIdCompania(), getSessionBeanEMP().getEmpleadoSesion().getUsuario());
        getSessionBeanREC().setConcursoSeleccionado(null);
    }
}