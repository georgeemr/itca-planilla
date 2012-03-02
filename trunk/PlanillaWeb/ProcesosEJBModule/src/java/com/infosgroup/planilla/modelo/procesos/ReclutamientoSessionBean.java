/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.facades.*;
import java.util.Date;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
    private EmergenciaXCandidatoFacade emergenciaCandidatoFacade;
    @EJB
    private NivelesXCandidatoFacade nivelesCandidatoFacade;
    @EJB
    private CriterioFacade criterioFacade;
    @EJB
    private PruebaXPuestoFacade pruebaXPuestoFacade;
    @EJB
    private ReferenciaFacade referenciaFacade;
    @EJB
    private DocumentoPresentadoFacade documentoPresentadoFacade;
    @EJB
    private DependienteXCandidatoFacade dependienteXCandidatoFacade;
    @EJB
    private BeneficiarioXCandidatoFacade beneficiarioXCandidatoFacade;
    @EJB
    private ParentescoFacade parentescoFacade;
    @EJB
    private CapacitacionXCandidatoFacade capacitacionXCandidatoFacade;
    @EJB
    private IdiomaXCandidatoFacade idiomaXCandidatoFacade;

    @PermitAll
    public List<Concurso> getListaConcursos(Cias empresa, Date fechaInicial, Date fechaFinal) {
        return concursoFacade.getConcursosByDate(empresa, fechaInicial, fechaFinal);
    }

    @PermitAll
    public List<Concurso> getConcursosEvaluados(Cias empresa) {
        return concursoFacade.getConcursosActivos(empresa);
    }

    @PermitAll
    public List<Concurso> getConcursoByEmpresa(Cias empresa) {
        return concursoFacade.findConcursoByEmpresa(empresa);
    }

    @PermitAll
    public List<EstadoConcurso> getEstadoConcursosByEmpresa(Cias empresa) {
        return estadoConcursoFacade.findEstadoConcursoByEmpresa(empresa);
    }

    @PermitAll
    public List<Puestos> getPuestosByEmpresa(Cias empresa) {
        return puestoFacade.findPuestoByEmpresa(empresa);
    }

    @PermitAll
    public List<TipoPuesto> getTipoPuestosByEmpresa(Cias empresa) {
        return tipoPuestoFacade.findTipoPuestoByEmpresa(empresa);
    }

    @PermitAll
    public Integer getMaxConcurso(Cias empresa) {
        return concursoFacade.max(empresa).intValue();
    }

    @PermitAll
    public Integer getMaxEmergenciaCandidato(Candidato c) {
        return emergenciaCandidatoFacade.max(c);
    }

    @PermitAll
    public List<Candidato> getCandidatosByEmpresa(Cias empresa) {
        return candidatoFacade.findByCanditadoByEmpresa(empresa);
    }

    @PermitAll
    public List<Candidato> getCandidatosByConcurso(Concurso c) {
        return candidatoFacade.findByConcurso(c);
    }

    @PermitAll
    public List<CandidatoConcurso> getListaCandidatoConcurso(Concurso c, String estado) {
        return candidatoConcursoFacade.getCandidatoConcurso(c, estado);
    }

    @PermitAll
    public List<CandidatoConcurso> getListaCandidatoSeleccionado(Concurso c, List<String> estado) {
        return candidatoConcursoFacade.getCandidatoConcursoSeleccionado(c, estado);
    }

    @PermitAll
    public List<Candidato> findCandidatosAPreseleccionar(Concurso s) {
        return candidatoFacade.findCandidatosAPreseleccionar(s);
    }

    @PermitAll
    public Puestos findPuestoById(PuestosPK pkPuesto) {
        return puestoFacade.find(pkPuesto);
    }

    @PermitAll
    public EstadoConcurso findEstadoConcursoById(EstadoConcursoPK estadoConcursoPK) {
        return estadoConcursoFacade.find(estadoConcursoPK);
    }

    @PermitAll
    public TipoPuesto findTipoPuestoById(TipoPuestoPK tipoPuestoPK) {
        return tipoPuestoFacade.find(tipoPuestoPK);
    }
    
    @PermitAll
    public void guardarConcurso(Concurso c) {
        concursoFacade.create(c);
    }

    @PermitAll
    public void eliminarConcurso(Concurso c) {
        concursoFacade.remove(c);
    }

    @PermitAll
    public void editarConcurso(Concurso c) {
        concursoFacade.edit(c);
    }

    @PermitAll
    public void editarCandidatoConcurso(CandidatoConcurso c) {
        candidatoConcursoFacade.edit(c);
    }

    @PermitAll
    public void removerCandidatoConcurso(CandidatoConcurso c) {
        candidatoConcursoFacade.remove(c);
    }

    @PermitAll
    public void editarEvaluacionCandidato(EvaluacionCandidato ec) {
        evaluacionCandidatoFacade.edit(ec);
    }

    @PermitAll
    public Integer getMaxCandidato(Cias empresa) {
        return candidatoFacade.max(empresa);
    }

    @PermitAll
    public void editarCandidato(Candidato c) {
        candidatoFacade.edit(c);
    }

    @PermitAll
    public Candidato findCandidatoById(CandidatoPK candidatoPK) {
        return candidatoFacade.find(candidatoPK);
    }

    @PermitAll
    public void preseleccionarCandidato(Concurso concurso, List<Candidato> listaCandidatos) {
        candidatoFacade.preseleccionarCandidato(concurso, listaCandidatos);
    }

    @PermitAll
    public List<Candidato> getCandidatoConCriteriosPuesto(Concurso c, String empleado, Integer maxResultado) {
        return candidatoFacade.getCandidatoConCriteriosPuesto(c, empleado, maxResultado);
    }

    @PermitAll
    public void eliminarCriteriosSeleccionados(Cias empresa, String usuario) {
        criterioSeleccionadoFacade.eliminarCriteriosSeleccionados(empresa, usuario);
    }

    @PermitAll
    public void guardarCriterioSeleccionado(CriteriosXPuesto c, String usuario) {
        criterioSeleccionadoFacade.guardarCriterio(c, usuario);
    }

    @PermitAll
    public void eliminarCriterioSeleccionado(CriteriosXPuesto c, String usuario) {
        criterioSeleccionadoFacade.eliminarCriterio(c, usuario);
    }

//    @PermitAll
//    public void registraPruebasPorCandidato(CandidatoConcurso c) {
//        evaluacionCandidatoFacade.registraPruebasPorCandidato(c);
//    }

    @PermitAll
    public List<EvaluacionCandidato> getListEvaluacionCandidato(CandidatoConcurso c) {
        return evaluacionCandidatoFacade.getListEvaluacionCandidato(c);
    }

    @PermitAll
    public void actualizarNotaCandidato(List<EvaluacionCandidato> lc) {
        evaluacionCandidatoFacade.actualizarNotaCandidato(lc);
    }

    @PermitAll
    public void guardarEmpleado(Empleados e) {
        empleadoFacade.create(e);
    }

    @PermitAll
    public void editarEmpleado(Empleados e) {
        empleadoFacade.edit(e);
    }
    
    @PermitAll
    public void guardarContrato(Contrato c) {
        contratoFacade.create(c);
    }

    @PermitAll
    public Empleados toEmpleado(Candidato c) {
        return empleadoFacade.toEmpleado(c);
    }

    @PermitAll
    public String generaUsuario(Candidato c) {
        return empleadoFacade.generaUsuario(c);
    }

    @PermitAll
    public void contratarCandidato(CandidatoConcurso c, Contrato contrato, String usuario, Empleados representantePatronal, String dui) {

        Empleados e = toEmpleado(c.getCandidato1());
        e.setUsuario(usuario);
        e.setDui(dui);
        e.setSexo(c.getCandidato1().getSexo());
        e.setPuestos(c.getConcurso1().getPuestos());
        e.setRepresentantePatronal(representantePatronal);
        e.setSalario(contrato.getSalario());
        e.setFechaNac(c.getCandidato1().getFechaNac());
        e.setStatus("A");
        e.setEstadoCivil(c.getCandidato1().getEstadoCivil());
        e.setCodPais(c.getCandidato1().getCodPaisNacionalidad());
        e.setFecIngreso(c.getCandidato1().getFecIngreso());
        e.setTiposPlanilla(contrato.getTiposPlanilla());
        e.setTipoContra(contrato.getTipo());
        e.setTitulo(c.getCandidato1().getProfesion() != null ? c.getCandidato1().getProfesion().getNomProfesion() : "");
        guardarEmpleado(e);
        contrato.setCandidato(c.getCandidato1());
        contrato.setEmpleados(e);
        contrato.setContratoPK(new ContratoPK(c.getCandidatoConcursoPK().getCodCia(), contratoFacade.max(c.getCandidato1()), c.getCandidato1().getCandidatoPK().getCodCandidato()));
        guardarContrato(contrato);
        c.setEstado("C");
        editarCandidatoConcurso(c);
        c.getCandidato1().setEmpleados(e);
        editarCandidato(c.getCandidato1());
        e.setCodContratacion(contrato.getContratoPK().getCodContrato().shortValue());
        editarEmpleado(e);
    }

    @PermitAll
    public List<CriteriosXPuesto> criteriosDisponibles(Cias empresa) {
        return criteriosXPuestoFacade.getListaCriteriosByEmpresa(empresa);
    }

    @PermitAll
    public List<CriteriosXPuesto> criteriosPorPuesto(PuestosPK puestos) {
        return criteriosXPuestoFacade.getListaCriteriosByPuestos(puestos);
    }

    @PermitAll
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

    @PermitAll
    public Agencias findAgenciasById(AgenciasPK id) {
        return agenciasFacade.find(id);
    }

    @PermitAll
    public TiposPlanilla findTipoPlanillaById(TiposPlanillaPK id) {
        return tipoPlanillaFacade.find(id);
    }

    @PermitAll
    public List<Departamentos> findDepartamentosByCias(Cias cias) {
        return depatamentosFacade.findDepartamentosByCias(cias);
    }

    @PermitAll
    public TipoDocumento findTipoDocumentoById(TipoDocumentoPK tipoDocumentoPK) {
        return tipoDocumentoFacade.find(tipoDocumentoPK);
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

    @PermitAll
    public void guardarCandidato(Candidato c) {
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
    public void crearEmergenciaCandidato(EmergenciaXCandidato exc) {
        emergenciaCandidatoFacade.create(exc);
    }

    @PermitAll
    public Short maxNivelXCandidato(Candidato c) {
        return nivelesCandidatoFacade.max(c);
    }

    @PermitAll
    public NivelesXCandidato findNivelCandidatoById(NivelesXCandidatoPK nivelCandidatoPK) {
        return nivelesCandidatoFacade.find(nivelCandidatoPK);
    }

    @PermitAll
    public void crearNivelXCandidato(NivelesXCandidato nivelCandidato) {
        nivelesCandidatoFacade.create(nivelCandidato);
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
    public List<Candidato> findCandidatosLikeEmpleados(Cias cias) {
        return candidatoFacade.findCandidatosLikeEmpleados(cias);
    }

    @PermitAll
    public List<Parentesco> findParentescoByCias(Cias cias) {
        return parentescoFacade.findParentescoByCias(cias);
    }

    @PermitAll
    public List<BeneficiarioXCandidato> findBeneficiariosByCandidato(Candidato c) {
        return beneficiarioXCandidatoFacade.findByCandidato(c);
    }

    @PermitAll
    public BeneficiarioXCandidatoPK getPkBeneficiarioCandiato(Candidato c) {
        return new BeneficiarioXCandidatoPK(c.getCandidatoPK().getCodCia(), c.getCandidatoPK().getCodCandidato(), beneficiarioXCandidatoFacade.max(c));
    }

    @PermitAll
    public void guardarBeneficiarioCandidato(BeneficiarioXCandidato bc) {
        beneficiarioXCandidatoFacade.create(bc);
    }

    @PermitAll
    public Integer maxReferencia(Candidato c) {
        return referenciaFacade.max(c);
    }

    @PermitAll
    public Referencia findReferenciaById(ReferenciaPK referenciaPK) {
        return referenciaFacade.find(referenciaPK);
    }

    @PermitAll
    public void crearRererencia(Referencia referencia) {
        referenciaFacade.create(referencia);
    }

    @PermitAll
    public void eliminarBeneficiarioCandidato(BeneficiarioXCandidato bc) {
        beneficiarioXCandidatoFacade.remove(bc);
    }

    @PermitAll
    public void editarBeneficiarioCandidato(BeneficiarioXCandidato bc) {
        beneficiarioXCandidatoFacade.edit(bc);
    }

    @PermitAll
    public Integer getMaxDocumentoPresentado(Candidato c) {
        return documentoPresentadoFacade.max(c);
    }

    @PermitAll
    public void crearDocumentoCandidato(DocumentoPresentado d) {
        documentoPresentadoFacade.create(d);
    }

    @PermitAll
    public Integer getMaxDependienteXCandidato(Candidato c) {
        return dependienteXCandidatoFacade.max(c);
    }

    @PermitAll
    public void crearDependienteXCandidato(DependienteXCandidato d) {
        dependienteXCandidatoFacade.create(d);
    }

    @PermitAll
    public Integer getMaxCapacitacionXCandidato(Candidato c) {
        return capacitacionXCandidatoFacade.max(c);
    }

    @PermitAll
    public void crearCapacitacionXCandidato(CapacitacionXCandidato c) {
        capacitacionXCandidatoFacade.create(c);
    }

    @PermitAll
    public Integer getMaxIdiomaXCandidato(Candidato c) {
        return idiomaXCandidatoFacade.max(c);
    }

    @PermitAll
    public void crearIdiomaXCandidato(IdiomaXCandidato i) {
        idiomaXCandidatoFacade.create(i);
    }

    @PermitAll
    public Integer getMaxBeneficiarioXCandidato(Candidato c) {
        return beneficiarioXCandidatoFacade.max(c);
    }

    @PermitAll
    public void crearBeneficiarioXCandidato(BeneficiarioXCandidato b) {
        beneficiarioXCandidatoFacade.create(b);
    }
}
