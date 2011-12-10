/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.EstadoConcurso;
import com.infosgroup.planilla.modelo.entidades.EstadoConcursoPK;
import com.infosgroup.planilla.modelo.entidades.Puesto;
import com.infosgroup.planilla.modelo.entidades.PuestoPK;
import com.infosgroup.planilla.modelo.entidades.TipoPuesto;
import com.infosgroup.planilla.modelo.entidades.TipoPuestoPK;
import com.infosgroup.planilla.modelo.facades.CandidatoFacade;
import com.infosgroup.planilla.modelo.facades.ConcursoFacade;
import com.infosgroup.planilla.modelo.facades.EstadoConcursoFacade;
import com.infosgroup.planilla.modelo.facades.PuestoFacade;
import com.infosgroup.planilla.modelo.facades.TipoPuestoFacade;
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
    private EstadoConcursoFacade estadoConcursoFacade;
    @EJB
    private TipoPuestoFacade tipoPuestoFacade;
    @EJB
    private PuestoFacade puestoFacade;
    @EJB
    private CandidatoFacade candidatoFacade;
    @EJB
    private ConcursoFacade concursoFacade;

    public List<Concurso> getListaConcursos(Date fechaInicial, Date fechaFinal) {
        return concursoFacade.getConcursosByDate(fechaInicial, fechaFinal);
    }

    public List<Concurso> getConcursosEvaluados(Long empresa) {
        return concursoFacade.getConcursosActivos(empresa);
    }

    public List<Concurso> getConcursoByEmpresa(Long empresa) {
        return concursoFacade.findConcursoByEmpresa(empresa);
    }

    public List<EstadoConcurso> getEstadoConcursosByEmpresa(Long empresa) {
        return estadoConcursoFacade.findEstadoConcursoByEmpresa(empresa);
    }

    public List<Puesto> getPuestosByEmpresa(Long empresa) {
        return puestoFacade.findPuestoByEmpresa(empresa);
    }

    public List<TipoPuesto> getTipoPuestosByEmpresa(Long empresa) {
        return tipoPuestoFacade.findTipoPuestoByEmpresa(empresa);
    }

    public Integer getMaxConcurso(Long empresa) {
        return concursoFacade.getMax(empresa).intValue();
    }

    public Puesto findPuestoById(PuestoPK pkPuesto) {
        return puestoFacade.find(pkPuesto);
    }

    public EstadoConcurso findEstadoConcursoById(EstadoConcursoPK estadoConcursoPK) {
        return estadoConcursoFacade.find(estadoConcursoPK);
    }

    public TipoPuesto findTipoPuestoById(TipoPuestoPK tipoPuestoPK) {
        return tipoPuestoFacade.find(tipoPuestoPK);
    }

    public void guardarConcurso(Concurso c) {
        concursoFacade.create(c);
    }

    public void eliminarConcurso(Concurso c) {
        concursoFacade.remove(c);
    }

    public void editarConcurso(Concurso c) {
        concursoFacade.edit(c);
    }

    public List<Candidato> getCandidatosByConcurso(Concurso c) {
        return (c != null) ? concursoFacade.find(c.getConcursoPK()).getCandidatoList() : new ArrayList<Candidato>();
    }

    public void CambioEstadoCandidato(Concurso concurso, List<Candidato> listaCandidatos, String estado) {
        for (Candidato c : concurso.getCandidatoList()) {
            c.setEstado("A");
            candidatoFacade.edit(c);
        }
        for (Candidato c : listaCandidatos) {
            c.setEstado(estado);
            candidatoFacade.edit(c);
        }
    }
}
