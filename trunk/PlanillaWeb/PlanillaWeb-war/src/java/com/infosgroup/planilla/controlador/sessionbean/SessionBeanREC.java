/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Concurso;
//import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.faces.bean.ManagedProperty;

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
//    private CriteriosXPuesto[] criteriosSeleccionados;
//    private CriteriosXPuesto[] criteriosAdicionales;
    private Candidato[] candidatosSeleccionados;
    private List<Candidato> listaCandidatos;
    @ManagedProperty(value="#{SessionBeanEMP}")
    private SessionBeanEMP sessionBeanEMP;
    private Integer maxResultados;
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

//    public CriteriosXPuesto[] getCriteriosSeleccionados() {
//        return criteriosSeleccionados;
//    }
//
//    public void setCriteriosSeleccionados(CriteriosXPuesto[] criteriosSeleccionados) {
//        this.criteriosSeleccionados = criteriosSeleccionados;
//    }

    public List<Candidato> getListaCandidatos() {
//        if (criteriosSeleccionados == null || criteriosSeleccionados.length <= 0) {
//            listaCandidatos = new java.util.ArrayList<Candidato>()/*reclutamientoSessionBean.findCandidatosAPreseleccionar(concursoSeleccionado)*/;
//        } else {
//            listaCandidatos = reclutamientoSessionBean.getCandidatoConCriteriosPuesto(concursoSeleccionado, getSessionBeanEMP().getEmpleadoSesion().getUsuario(), maxResultados);
//        }
        return listaCandidatos;
    }

    public Integer getMaxResultados() {
        return maxResultados;
    }

    public void setMaxResultados(Integer maxResultados) {
        this.maxResultados = maxResultados;
    }
    
    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    public SessionBeanEMP getSessionBeanEMP() {
        return sessionBeanEMP;
    }

    public void setSessionBeanEMP(SessionBeanEMP sessionBeanEMP) {
        this.sessionBeanEMP = sessionBeanEMP;
    }

//    public CriteriosXPuesto[] getCriteriosAdicionales() {
//        return criteriosAdicionales;
//    }
//
//    public void setCriteriosAdicionales(CriteriosXPuesto[] criteriosAdicionales) {
//        this.criteriosAdicionales = criteriosAdicionales;
//    }
    
}