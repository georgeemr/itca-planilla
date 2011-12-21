/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoConcurso;
import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.Contrato;
import com.infosgroup.planilla.modelo.entidades.ContratoPK;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.EstadoConcurso;
import com.infosgroup.planilla.modelo.entidades.EstadoConcursoPK;
import com.infosgroup.planilla.modelo.entidades.EstadoContrato;
import com.infosgroup.planilla.modelo.entidades.EstadoContratoPK;
import com.infosgroup.planilla.modelo.entidades.EvaluacionCandidato;
import com.infosgroup.planilla.modelo.entidades.Puesto;
import com.infosgroup.planilla.modelo.entidades.PuestoPK;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.entidades.SucursalPK;
import com.infosgroup.planilla.modelo.entidades.TipoContrato;
import com.infosgroup.planilla.modelo.entidades.TipoContratoPK;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.entidades.TipoPlanillaPK;
import com.infosgroup.planilla.modelo.entidades.TipoPuesto;
import com.infosgroup.planilla.modelo.entidades.TipoPuestoPK;
import com.infosgroup.planilla.modelo.facades.CandidatoConcursoFacade;
import com.infosgroup.planilla.modelo.facades.CandidatoFacade;
import com.infosgroup.planilla.modelo.facades.ConcursoFacade;
import com.infosgroup.planilla.modelo.facades.ContratoFacade;
import com.infosgroup.planilla.modelo.facades.CriterioSeleccionadoFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.EstadoConcursoFacade;
import com.infosgroup.planilla.modelo.facades.EstadoContratoFacade;
import com.infosgroup.planilla.modelo.facades.EvaluacionCandidatoFacade;
import com.infosgroup.planilla.modelo.facades.PuestoFacade;
import com.infosgroup.planilla.modelo.facades.SucursalFacade;
import com.infosgroup.planilla.modelo.facades.TipoContratoFacade;
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
    private SucursalFacade sucursalFacade;
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
    private TipoContratoFacade tipoContratoFacade;
    @EJB
    private EmpleadoFacade empleadoFacade;
    @EJB
    private ContratoFacade contratoFacade;
    @EJB
    private EstadoContratoFacade estadoContratoFacade;
    

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

    public List<Candidato> getCandidatosByEmpresa(Long empresa) {
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

    public void editarCandidatoConcurso(CandidatoConcurso c) {
        candidatoConcursoFacade.edit(c);
    }

    public void editarEvaluacionCandidato(EvaluacionCandidato ec) {
        evaluacionCandidatoFacade.edit(ec);
    }

    public void editarCandidato(Candidato c) {
        candidatoFacade.edit(c);
    }

    public void preseleccionarCandidato(Concurso concurso, List<Candidato> listaCandidatos) {
        candidatoFacade.preseleccionarCandidato(concurso, listaCandidatos);
    }

    public List<Candidato> getCandidatoConCriteriosPuesto(Concurso c, String empleado) {
        return candidatoFacade.getCandidatoConCriteriosPuesto(c, empleado);
    }

    public void eliminarCriteriosSeleccionados(Long empresa, String usuario) {
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

    @PermitAll
    public List<TipoContrato> getTipoContratoByEmpresa(Long empresa) {
        return tipoContratoFacade.getTipoContratoByEmpresa(empresa);
    }

    public void guardarEmpleado(Empleado e) {
        empleadoFacade.create(e);
    }

    public void guardarContrato(Contrato c) {
        contratoFacade.create(c);
    }

    public Empleado toEmpleado(Candidato c) {
        return empleadoFacade.toEmpleado(c);
    }

    public String generaUsuario(Candidato c) {
        return empleadoFacade.generaUsuario(c);
    }

    public EstadoContrato findEstadoContratoById(EstadoContratoPK pk) {
        return estadoContratoFacade.find(pk);
    }

    @PermitAll
    public List<EstadoContrato> findEstadoContratoByEmpresa(Long empresa) {
        return estadoContratoFacade.findEstadoContratoByEmpresa(empresa);
    }

    public void contratarCandidato(CandidatoConcurso c, Contrato contrato, String usuario) {
        Empleado e = toEmpleado(c.getCandidato1());
        e.setUsuario(usuario);
        guardarEmpleado(e);
        contrato.setCandidato1(c.getCandidato1());
        contrato.setEmpleado(e);
        contrato.setContratoPK(new ContratoPK(c.getCandidatoConcursoPK().getCodCia(), contratoFacade.getMax(c.getCandidato1()), c.getCandidato1().getCandidatoPK().getCodCandidato()));
        guardarContrato(contrato);
        c.setEstado("C");
        editarCandidatoConcurso(c);
    }

    public TipoContrato findTipoContratoById(TipoContratoPK pk) {
        return tipoContratoFacade.find(pk);
    }

    public List<CriteriosXPuesto> criteriosDisponibles() {
        return null;
    }
   
    public List<Empleado> findByUsuario(String usuario){
        return empleadoFacade.findEmpleadosByUsuario(usuario);
    }
    
    @PermitAll
    public List<Sucursal> findSucursalByEmpresa(Compania empresa){
        return  sucursalFacade.findByCompania(empresa);
    }
    @PermitAll
    public List<TipoPlanilla> findTipoPlanillaByEmpresa(Compania empresa){
        return tipoPlanillaFacade.findByCompania(empresa);
    }
    
    public Sucursal findSucursalById(SucursalPK id){
        return sucursalFacade.find(id);
    }
    
    public TipoPlanilla findTipoPlanillaById(TipoPlanillaPK id){
        return tipoPlanillaFacade.find(id);
    }
}
