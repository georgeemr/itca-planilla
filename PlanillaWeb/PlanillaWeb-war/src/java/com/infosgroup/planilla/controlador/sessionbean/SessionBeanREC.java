/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import java.io.Serializable;
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

    /**
     * Comun a todos los flujos de Reclutamiento 
     */
    private Concurso concursoSeleccionado;

    public SessionBeanREC() {
    }

    public Concurso getConcursoSeleccionado() {
        return concursoSeleccionado;
    }

    public void setConcursoSeleccionado(Concurso concursoSeleccionado) {
        this.concursoSeleccionado = concursoSeleccionado;
    }

    public List<CriteriosXPuesto> criteriosSeleccionados;
    public List<Candidato> candidatosSeleccionados;

    public List<Candidato> getCandidatosSeleccionados() {
        return candidatosSeleccionados;
    }

    public void setCandidatosSeleccionados(List<Candidato> candidatosSeleccionados) {
        this.candidatosSeleccionados = candidatosSeleccionados;
    }

    public List<CriteriosXPuesto> getCriteriosSeleccionados() {
        return criteriosSeleccionados;
    }

    public void setCriteriosSeleccionados(List<CriteriosXPuesto> criteriosSeleccionados) {
        this.criteriosSeleccionados = criteriosSeleccionados;
    }
   
}