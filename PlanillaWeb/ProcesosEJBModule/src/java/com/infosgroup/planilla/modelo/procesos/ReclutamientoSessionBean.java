/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoConcurso;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.Contrato;
import com.infosgroup.planilla.modelo.entidades.ContratoPK;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.EstadoConcurso;
import com.infosgroup.planilla.modelo.entidades.EstadoConcursoPK;
import com.infosgroup.planilla.modelo.entidades.EvaluacionCandidato;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import com.infosgroup.planilla.modelo.entidades.PuestosPK;
import com.infosgroup.planilla.modelo.entidades.TipoDocumento;
import com.infosgroup.planilla.modelo.entidades.TipoPuesto;
import com.infosgroup.planilla.modelo.entidades.TipoPuestoPK;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanillaPK;
import com.infosgroup.planilla.modelo.entidades.Agencias;
import com.infosgroup.planilla.modelo.facades.CandidatoConcursoFacade;
import com.infosgroup.planilla.modelo.facades.CandidatoFacade;
import com.infosgroup.planilla.modelo.facades.ConcursoFacade;
import com.infosgroup.planilla.modelo.facades.ContratoFacade;
import com.infosgroup.planilla.modelo.facades.CriterioSeleccionadoFacade;
import com.infosgroup.planilla.modelo.facades.CriteriosXPuestoFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.EstadoConcursoFacade;
import com.infosgroup.planilla.modelo.facades.EvaluacionCandidatoFacade;
import com.infosgroup.planilla.modelo.facades.PruebaXPuestoFacade;
import com.infosgroup.planilla.modelo.facades.PuestoFacade;
import com.infosgroup.planilla.modelo.facades.AgenciasFacade;
import com.infosgroup.planilla.modelo.entidades.AgenciasPK;
import com.infosgroup.planilla.modelo.entidades.AreasStaff;
import com.infosgroup.planilla.modelo.entidades.Criterio;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuestoPK;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.Locaciones;
import com.infosgroup.planilla.modelo.entidades.PruebaXPuesto;
import com.infosgroup.planilla.modelo.facades.AreasStaffFacade;
import com.infosgroup.planilla.modelo.facades.CriterioFacade;
import com.infosgroup.planilla.modelo.facades.DepartamentoFacade;
import com.infosgroup.planilla.modelo.facades.LocacionesFacade;
import com.infosgroup.planilla.modelo.facades.TipoDocumentoFacade;
import com.infosgroup.planilla.modelo.facades.TipoPlanillaFacade;
import com.infosgroup.planilla.modelo.facades.TipoPuestoFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.Date;
import java.util.List;
import javax.annotation.security.PermitAll;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class ReclutamientoSessionBean {

    @EJB
    private TipoPlanillaFacade tipoPlanillaFacade;
    @EJB
    private AgenciasFacade agenciasFacade;
    @EJB
    private EvaluacionCandidatoFacade evaluacionCandidatoFacade;
    @EJB
    private CandidatoConcursoFacade candidatoConcursoFacade;
    @EJB
    private CriterioSeleccionadoFacade criterioSeleccionadoFacade;
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
    @EJB
    private EmpleadoFacade empleadoFacade;
    @EJB
    private ContratoFacade contratoFacade;
    @EJB
    private CriteriosXPuestoFacade criteriosXPuestoFacade;
    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
    @EJB
    private DepartamentoFacade depatamentosFacade;
    @EJB
    private AreasStaffFacade areasStaffFacade;
    @EJB
    private LocacionesFacade locacionesFacade;
    @EJB
    private CriterioFacade criterioFacade;
    @EJB
    private PruebaXPuestoFacade pruebaXPuestoFacade;

    public List<Concurso> getListaConcursos(Cias empresa, Date fechaInicial, Date fechaFinal) {
        return concursoFacade.getConcursosByDate(empresa, fechaInicial, fechaFinal);
    }

    public List<Concurso> getConcursosEvaluados(Cias empresa) {
        return concursoFacade.getConcursosActivos(empresa);
    }

    public List<Concurso> getConcursoByEmpresa(Cias empresa) {
        return concursoFacade.findConcursoByEmpresa(empresa);
    }

    public List<EstadoConcurso> getEstadoConcursosByEmpresa(Cias empresa) {
        return estadoConcursoFacade.findEstadoConcursoByEmpresa(empresa);
    }

    public List<Puestos> getPuestosByEmpresa(Cias empresa) {
        return puestoFacade.findPuestoByEmpresa(empresa);
    }

    public List<TipoPuesto> getTipoPuestosByEmpresa(Cias empresa) {
        return tipoPuestoFacade.findTipoPuestoByEmpresa(empresa);
    }

    public Integer getMaxConcurso(Cias empresa) {
        return concursoFacade.max(empresa).intValue();
    }

    @PermitAll
    public List<Candidato> getCandidatosByEmpresa(Cias empresa) {
        return candidatoFacade.findByCanditadoByEmpresa(empresa);
    }

    public List<Candidato> getCandidatosByConcurso(Concurso c) {
        return candidatoFacade.findByConcurso(c);
    }

    public List<CandidatoConcurso> getListaCandidatoConcurso(Concurso c, String estado) {
        return candidatoConcursoFacade.getCandidatoConcurso(c, estado);
    }

    @PermitAll
    public List<CandidatoConcurso> getListaCandidatoSeleccionado(Concurso c, List<String> estado) {
        return candidatoConcursoFacade.getCandidatoConcursoSeleccionado(c, estado);
    }

    public List<Candidato> findCandidatosAPreseleccionar(Concurso s) {
        return candidatoFacade.findCandidatosAPreseleccionar(s);
    }

    public Puestos findPuestoById(PuestosPK pkPuesto) {
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

    public void editarCandidatoConcurso(CandidatoConcurso c) {
        candidatoConcursoFacade.edit(c);
    }

    public void editarEvaluacionCandidato(EvaluacionCandidato ec) {
        evaluacionCandidatoFacade.edit(ec);
    }

    public Long getMaxCandidato(Cias empresa) {
        return candidatoFacade.max(empresa).longValue();
    }

    public void editarCandidato(Candidato c) {
        candidatoFacade.edit(c);
    }

    public void preseleccionarCandidato(Concurso concurso, List<Candidato> listaCandidatos) {
        candidatoFacade.preseleccionarCandidato(concurso, listaCandidatos);
    }

    @PermitAll
    public List<Candidato> getCandidatoConCriteriosPuesto(Concurso c, String empleado, Integer maxResultado) {
        return candidatoFacade.getCandidatoConCriteriosPuesto(c, empleado, maxResultado);
    }

    public void eliminarCriteriosSeleccionados(Cias empresa, String usuario) {
        criterioSeleccionadoFacade.eliminarCriteriosSeleccionados(empresa, usuario);
    }

    public void guardarCriterioSeleccionado(CriteriosXPuesto c, String usuario) {
        criterioSeleccionadoFacade.guardarCriterio(c, usuario);
    }

    public void eliminarCriterioSeleccionado(CriteriosXPuesto c, String usuario) {
        criterioSeleccionadoFacade.eliminarCriterio(c, usuario);
    }

    @PermitAll
    public void registraPruebasPorCandidato(CandidatoConcurso c) {
        evaluacionCandidatoFacade.registraPruebasPorCandidato(c);
    }

    @PermitAll
    public List<EvaluacionCandidato> getListEvaluacionCandidato(CandidatoConcurso c) {
        return evaluacionCandidatoFacade.getListEvaluacionCandidato(c);
    }

    @PermitAll
    public void actualizarNotaCandidato(List<EvaluacionCandidato> lc) {
        evaluacionCandidatoFacade.actualizarNotaCandidato(lc);
    }

    public void guardarEmpleado(Empleados e) {
        empleadoFacade.create(e);
    }

    public void guardarContrato(Contrato c) {
        contratoFacade.create(c);
    }

    public Empleados toEmpleado(Candidato c) {
        return empleadoFacade.toEmpleado(c);
    }

    public String generaUsuario(Candidato c) {
        return empleadoFacade.generaUsuario(c);
    }

    public void contratarCandidato(CandidatoConcurso c, Contrato contrato, String usuario) {
        Empleados e = toEmpleado(c.getCandidato1());
        e.setUsuario(usuario);
        guardarEmpleado(e);
        contrato.setCandidato(c.getCandidato1());
        contrato.setEmpleados(e);
        contrato.setContratoPK(new ContratoPK(c.getCandidatoConcursoPK().getCodCia(), contratoFacade.max(c.getCandidato1()), c.getCandidato1().getCandidatoPK().getCodCandidato()));
        guardarContrato(contrato);
        c.setEstado("C");
        editarCandidatoConcurso(c);
    }

    @PermitAll
    public List<CriteriosXPuesto> criteriosDisponibles(Cias empresa) {
        return criteriosXPuestoFacade.getListaCriteriosByEmpresa(empresa);
    }

    @PermitAll
    public List<CriteriosXPuesto> criteriosPorPuesto(PuestosPK puestos) {
        return criteriosXPuestoFacade.getListaCriteriosByPuestos(puestos);
    }

    public List<Empleados> findByUsuario(String usuario) {
        return empleadoFacade.findEmpleadosByUsuario(usuario);
    }

    @PermitAll
    public List<Agencias> findAgenciasByEmpresa(Cias empresa) {
        return agenciasFacade.findByCompania(empresa);
    }

    @PermitAll
    public List<TiposPlanilla> findTipoPlanillaByEmpresa(Cias empresa) {
        return tipoPlanillaFacade.findByCompania(empresa);
    }

    public Agencias findAgenciasById(AgenciasPK id) {
        return agenciasFacade.find(id);
    }

    public TiposPlanilla findTipoPlanillaById(TiposPlanillaPK id) {
        return tipoPlanillaFacade.find(id);
    }

    public List<Departamentos> findDepartamentosByCias(Cias cias) {
        return depatamentosFacade.findDepartamentosByCias(cias);
    }

    @PermitAll
    public List<TipoDocumento> findAllTipoDocumento() {
        return tipoDocumentoFacade.findAll();
    }

    @PermitAll
    public void guardarPuesto(Puestos puestos, Cias cias) {
        PuestosPK pk = new PuestosPK(cias.getCodCia(), puestoFacade.max(cias));
        puestos.setPuestosPK(pk);
        puestoFacade.create(puestos);
    }

    @PermitAll
    public void editarPuesto(Puestos puestos) {
        puestoFacade.edit(puestos);
    }

    @PermitAll
    public void eliminarPuesto(Puestos puestos) {
        puestoFacade.remove(puestos);
    }

    @PermitAll
    public void eliminarCriterioXPuesto(CriteriosXPuesto criterio) {
        criteriosXPuestoFacade.remove(criterio);
    }

    @PermitAll
    public List<Criterio> findListaCriteriosByCias(Cias cias) {
        return criterioFacade.findCriteriosByCias(cias);
    }

    @PermitAll
    public void guardarCriterioXPuesto(CriteriosXPuesto criterioXPuesto) {
        criteriosXPuestoFacade.create(criteriosXPuestoFacade.getWithId(criterioXPuesto));
    }

    public void guardarCandidato(Candidato c) throws javax.persistence.EntityExistsException {
        candidatoFacade.create(c);
    }

    @PermitAll
    public List<AreasStaff> findAreasStaffByCias(Cias cias) {
        return areasStaffFacade.findAreasByCias(cias);
    }

    @PermitAll
    public List<Locaciones> findLocacionesByCias(Cias cias) {
        return locacionesFacade.findLocacionesByCias(cias);
    }

    @PermitAll
    public List<PruebaXPuesto> finPruebaXPuestosByCias(Cias cias) {
        return pruebaXPuestoFacade.findPruebaXPuestoByCias(cias);
    }

    @PermitAll
    public void eliminarPruebaXPuesto(PruebaXPuesto pruebaXPuesto) {
        pruebaXPuestoFacade.remove(pruebaXPuesto);
    }

    @PermitAll
    public void eliminarEvaluacionCandidato(EvaluacionCandidato evaluacionCandidato) {
        evaluacionCandidatoFacade.remove(evaluacionCandidato);
    }

    @PermitAll
    public void guardarEvaluacionCandidato(EvaluacionCandidato evaluacionCandidato) {
        evaluacionCandidatoFacade.create(evaluacionCandidato);
    }
    
    @PermitAll
    public List<Candidato> findCandidatosLikeEmpleados(Cias cias){
        return candidatoFacade.findCandidatosLikeEmpleados(cias);
    }
    
}
