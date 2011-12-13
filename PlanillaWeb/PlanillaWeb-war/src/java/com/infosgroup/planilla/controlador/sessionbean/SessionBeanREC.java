/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 *
 * @author root
 * <pre>Bean de Session utilizado para almacenar los datos 
 * de Reclutamiento y preseleccion de candidatos.</pre>
 */
@ManagedBean(name = "SessionBeanREC")
@SessionScoped
public class SessionBeanREC implements Serializable {

    @EJB
    private ReclutamientoSessionBean reclutamientoSessionBean;
    private Concurso concursoSeleccionado;
    private CriteriosXPuesto[] criteriosSeleccionados;
    private Candidato[] candidatosSeleccionados;
    private List<Candidato> listaCandidatos;

    public SessionBeanREC() {
    }

    public Concurso getConcursoSeleccionado() {
        return concursoSeleccionado;
    }

    public void setConcursoSeleccionado(Concurso concursoSeleccionado) {
        this.concursoSeleccionado = concursoSeleccionado;
    }

    public Candidato[] getCandidatosSeleccionados() {
        return candidatosSeleccionados;
    }

    public void setCandidatosSeleccionados(Candidato[] candidatosSeleccionados) {
        this.candidatosSeleccionados = candidatosSeleccionados;
    }

    public CriteriosXPuesto[] getCriteriosSeleccionados() {
        return criteriosSeleccionados;
    }

    public void setCriteriosSeleccionados(CriteriosXPuesto[] criteriosSeleccionados) {
        this.criteriosSeleccionados = criteriosSeleccionados;
    }

    public List<Candidato> getListaCandidatos() {
        if (criteriosSeleccionados == null || criteriosSeleccionados.length <= 0) {
            listaCandidatos = reclutamientoSessionBean.getCandidatosByEmpresa(1L);
        } else {
            listaCandidatos = new ArrayList<Candidato>();
        }
        return listaCandidatos;
    }

    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }
}