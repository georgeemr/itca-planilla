/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Concurso;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root
 * <pre>Bean de Session utilizado para almacenar los datos 
 * de Reclutamiento y preseleccion de candidatos.</pre>
 */
@ManagedBean(name="SessionBeanREC")
@SessionScoped
public class SessionBeanREC {

    private Concurso concursoSeleccionado;
    
    public SessionBeanREC() {
    }
    
    public Concurso getConcursoSeleccionado() {
        return concursoSeleccionado;
    }

    public void setConcursoSeleccionado(Concurso concursoSeleccionado) {
        this.concursoSeleccionado = concursoSeleccionado;
    }

}