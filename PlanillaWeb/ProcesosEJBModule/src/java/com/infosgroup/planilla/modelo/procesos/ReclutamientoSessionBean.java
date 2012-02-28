/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.facades.*;
import com.infosgroup.planilla.modelo.facades.PruebaXPuestoFacade;
import com.infosgroup.planilla.modelo.entidades.Criterio;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuestoPK;
import com.infosgroup.planilla.modelo.entidades.PruebaXPuesto;
import com.infosgroup.planilla.modelo.facades.CriterioFacade;
import java.util.Date;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**

 @author root
 */
@Stateless
@LocalBean
public class ReclutamientoSessionBean
{

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

public List<Concurso> getListaConcursos(Cias empresa, Date fechaInicial, Date fechaFinal)
{
    return concursoFacade.getConcursosByDate(empresa, fechaInicial, fechaFinal);
}

public List<Concurso> getConcursosEvaluados(Cias empresa)
{
    return concursoFacade.getConcursosActivos(empresa);
}

public List<Concurso> getConcursoByEmpresa(Cias empresa)
{
    return concursoFacade.findConcursoByEmpresa(empresa);
}

public List<EstadoConcurso> getEstadoConcursosByEmpresa(Cias empresa)
{
    return estadoConcursoFacade.findEstadoConcursoByEmpresa(empresa);
}

public List<Puestos> getPuestosByEmpresa(Cias empresa)
{
    return puestoFacade.findPuestoByEmpresa(empresa);
}

public List<TipoPuesto> getTipoPuestosByEmpresa(Cias empresa)
{
    return tipoPuestoFacade.findTipoPuestoByEmpresa(empresa);
}

public Integer getMaxConcurso(Cias empresa)
{
    return concursoFacade.max(empresa).intValue();
}

@PermitAll
public Integer getMaxEmergenciaCandidato(Candidato c)
{
    return emergenciaCandidatoFacade.max(c);
}

@PermitAll
public List<Candidato> getCandidatosByEmpresa(Cias empresa)
{
    return candidatoFacade.findByCanditadoByEmpresa(empresa);
}

public List<Candidato> getCandidatosByConcurso(Concurso c)
{
    return candidatoFacade.findByConcurso(c);
}

public List<CandidatoConcurso> getListaCandidatoConcurso(Concurso c, String estado)
{
    return candidatoConcursoFacade.getCandidatoConcurso(c, estado);
}

@PermitAll
public List<CandidatoConcurso> getListaCandidatoSeleccionado(Concurso c, List<String> estado)
{
    return candidatoConcursoFacade.getCandidatoConcursoSeleccionado(c, estado);
}

public List<Candidato> findCandidatosAPreseleccionar(Concurso s)
{
    return candidatoFacade.findCandidatosAPreseleccionar(s);
}

public Puestos findPuestoById(PuestosPK pkPuesto)
{
    return puestoFacade.find(pkPuesto);
}

public EstadoConcurso findEstadoConcursoById(EstadoConcursoPK estadoConcursoPK)
{
    return estadoConcursoFacade.find(estadoConcursoPK);
}

public TipoPuesto findTipoPuestoById(TipoPuestoPK tipoPuestoPK)
{
    return tipoPuestoFacade.find(tipoPuestoPK);
}

public void guardarConcurso(Concurso c)
{
    concursoFacade.create(c);
}

public void eliminarConcurso(Concurso c)
{
    concursoFacade.remove(c);
}

public void editarConcurso(Concurso c)
{
    concursoFacade.edit(c);
}

public void editarCandidatoConcurso(CandidatoConcurso c)
{
    candidatoConcursoFacade.edit(c);
}

public void editarEvaluacionCandidato(EvaluacionCandidato ec)
{
    evaluacionCandidatoFacade.edit(ec);
}

public Integer getMaxCandidato(Cias empresa)
{
    return candidatoFacade.max(empresa);
}

public void editarCandidato(Candidato c)
{
    candidatoFacade.edit(c);
}

public Candidato findCandidatoById(CandidatoPK candidatoPK)
{
    return candidatoFacade.find(candidatoPK);
}

public void preseleccionarCandidato(Concurso concurso, List<Candidato> listaCandidatos)
{
    candidatoFacade.preseleccionarCandidato(concurso, listaCandidatos);
}

    @PermitAll
    public List<Candidato> getCandidatoConCriteriosPuesto(Concurso c, String empleado, Integer maxResultado) {
        return candidatoFacade.getCandidatoConCriteriosPuesto(c, empleado, maxResultado);
}

public void eliminarCriteriosSeleccionados(Cias empresa, String usuario)
{
    criterioSeleccionadoFacade.eliminarCriteriosSeleccionados(empresa, usuario);
}

public void guardarCriterioSeleccionado(CriteriosXPuesto c, String usuario)
{
    criterioSeleccionadoFacade.guardarCriterio(c, usuario);
}

public void eliminarCriterioSeleccionado(CriteriosXPuesto c, String usuario)
{
    criterioSeleccionadoFacade.eliminarCriterio(c, usuario);
}

@PermitAll
public void registraPruebasPorCandidato(CandidatoConcurso c)
{
    evaluacionCandidatoFacade.registraPruebasPorCandidato(c);
}

@PermitAll
public List<EvaluacionCandidato> getListEvaluacionCandidato(CandidatoConcurso c)
{
    return evaluacionCandidatoFacade.getListEvaluacionCandidato(c);
}

@PermitAll
public void actualizarNotaCandidato(List<EvaluacionCandidato> lc)
{
    evaluacionCandidatoFacade.actualizarNotaCandidato(lc);
}

public void guardarEmpleado(Empleados e)
{
    empleadoFacade.create(e);
}

public void guardarContrato(Contrato c)
{
    contratoFacade.create(c);
}

public Empleados toEmpleado(Candidato c)
{
    return empleadoFacade.toEmpleado(c);
}

public String generaUsuario(Candidato c)
{
    return empleadoFacade.generaUsuario(c);
}

public void contratarCandidato(CandidatoConcurso c, Contrato contrato, String usuario)
{
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
public List<CriteriosXPuesto> criteriosDisponibles(Cias empresa)
{
    return criteriosXPuestoFacade.getListaCriteriosByEmpresa(empresa);
}

    @PermitAll
    public List<CriteriosXPuesto> criteriosPorPuesto(PuestosPK puestos) {
        return criteriosXPuestoFacade.getListaCriteriosByPuestos(puestos);
    }

    return empleadoFacade.findEmpleadosByUsuario(usuario);
}

@PermitAll
public List<Agencias> findAgenciasByEmpresa(Cias empresa)
{
    return agenciasFacade.findByCompania(empresa);
}

@PermitAll
public List<TiposPlanilla> findTipoPlanillaByEmpresa(Cias empresa)
{
    return tipoPlanillaFacade.findByCompania(empresa);
}

public Agencias findAgenciasById(AgenciasPK id)
{
    return agenciasFacade.find(id);
}

public TiposPlanilla findTipoPlanillaById(TiposPlanillaPK id)
{
    return tipoPlanillaFacade.find(id);
}

public List<Departamentos> findDepartamentosByCias(Cias cias)
{
    return depatamentosFacade.findDepartamentosByCias(cias);
}

@PermitAll
public TipoDocumento findTipoDocumentoById(TipoDocumentoPK tipoDocumentoPK)
{
return tipoDocumentoFacade.find(tipoDocumentoPK);
}

@PermitAll
public List<TipoDocumento> findAllTipoDocumento()
{
    return tipoDocumentoFacade.findAll();
}

@PermitAll
public void guardarPuesto(Puestos puestos, Cias cias)
{
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

    candidatoFacade.create(c);
}

@PermitAll
public List<AreasStaff> findAreasStaffByCias(Cias cias)
{
    return areasStaffFacade.findAreasByCias(cias);
}

@PermitAll
public List<Locaciones> findLocacionesByCias(Cias cias)
{
    return locacionesFacade.findLocacionesByCias(cias);
}

// ===========================================================================
@PermitAll
public void crearEmergenciaCandidato(EmergenciaXCandidato exc)
{
    emergenciaCandidatoFacade.create(exc);
}

// ===========================================================================
@PermitAll
public Short maxNivelXCandidato(Candidato c)
{
    return nivelesCandidatoFacade.max(c);
}

@PermitAll
public NivelesXCandidato findNivelCandidatoById(NivelesXCandidatoPK nivelCandidatoPK)
{
    return nivelesCandidatoFacade.find(nivelCandidatoPK);
}

@PermitAll
public void crearNivelXCandidato(NivelesXCandidato nivelCandidato)
{
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
    public List<Candidato> findCandidatosLikeEmpleados(Cias cias){
        return candidatoFacade.findCandidatosLikeEmpleados(cias);
    }
    

// ===========================================================================
@PermitAll
public Integer maxReferencia(Candidato c)
{
    return referenciaFacade.max(c);
}

@PermitAll
public Referencia findReferenciaById(ReferenciaPK referenciaPK)
{
    return referenciaFacade.find(referenciaPK);
}

@PermitAll
public void crearRererencia(Referencia referencia)
{
    referenciaFacade.create(referencia);
}
// ================================================================
}
