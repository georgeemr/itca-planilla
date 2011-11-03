/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.facades.CandidatoFacade;
import com.infosgroup.planilla.modelo.facades.ConcursoFacade;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.Date;
import java.util.List;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class ReclutamientoSessionBean {

    @EJB
    private ConcursoFacade concursoFacade;

    public List<Concurso> getListaConcursos(Date fechaInicial, Date fechaFinal) {
        return concursoFacade.getConcursosByDate(fechaInicial, fechaFinal);
    }

    public List<Concurso> getAllConcursos() {
        return concursoFacade.findAll();
    }

    public List<Candidato> getCandidatosByConcurso(Concurso c) {
        if (c != null) {
            return concursoFacade.find(c.getConcursoPK()).getCandidatoList();
        } else {
            return new ArrayList<Candidato>();
        }
    }
}
