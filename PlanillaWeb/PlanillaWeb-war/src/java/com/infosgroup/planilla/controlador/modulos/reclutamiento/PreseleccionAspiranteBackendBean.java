/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$preseleccionAspirante")
@ViewScoped
public class PreseleccionAspiranteBackendBean extends JSFUtil {

    @EJB
    private ReclutamientoSessionBean reclutamientoSessionBean;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Concurso> listaConcurso;
    private List<Candidato> listaCandidato;
    private Candidato[] candidatosSeleccionados;

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

    public Candidato[] getCandidatosSeleccionados() {
        return candidatosSeleccionados;
    }

    public void setCandidatosSeleccionados(Candidato[] candidatosSeleccionados) {
        this.candidatosSeleccionados = candidatosSeleccionados;
    }

    public String buscarConcurso$action() {

        if (fechaInicial != null && fechaFinal != null) {
            if (validaFechas(fechaInicial, fechaFinal) == true) {
                setListaConcurso(reclutamientoSessionBean.getListaConcursos(fechaInicial, fechaFinal));
            } else {
                addMessage("Buscar concurso", "Los rangos de fecha Ingresados no son consistentes.", TipoMensaje.ERROR);
            }
        } else {
            setListaConcurso(reclutamientoSessionBean.getAllConcursos());
            addMessage("Buscar concurso", "Mostrando todos los concursos", TipoMensaje.INFORMACION);
        }
        return null;
    }

    public String preseleccionarCandidato$action() {
        if (getCandidatosSeleccionados() == null) {
            addMessage("Preselección de Candidatos.", "No ha seleccionado ningún candidato.", TipoMensaje.ERROR);
        }
        return null;
    }

    public void onRowSelectConcurso(SelectEvent event) {
        Concurso c = (Concurso) event.getObject();
        setListaCandidato(reclutamientoSessionBean.getCandidatosByConcurso(c));
    }

    public void onRowSelectCandidato(SelectEvent event) {
        Candidato c = (Candidato) event.getObject();
        if (candidatosSeleccionados.length == 0) {
            candidatosSeleccionados[0] = c;
        } else {
            candidatosSeleccionados[candidatosSeleccionados.length + 1] = c;
        }
        addMessage("Agregarndo fulano", c.getNombreCompleto(), TipoMensaje.INFORMACION);
    }

    @Override
    protected void limpiarCampos() {
        setFechaInicial(null);
        setFechaFinal(null);
    }
}