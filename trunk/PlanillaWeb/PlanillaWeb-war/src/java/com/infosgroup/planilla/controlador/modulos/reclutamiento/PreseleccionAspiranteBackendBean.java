/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompletePruebaConverter;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$preseleccionAspirante")
@ViewScoped
public class PreseleccionAspiranteBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private ReclutamientoSessionBean reclutamientoSessionBean;
    @EJB
    private ReportesStatelessBean reportesStatelessBean;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Concurso> listaConcurso;
    private DataTable tableConcursos;
    private DataTable tableCandidatos;
    private DataTable tableSeleccion;
    private DataTable tableContratacion;
    private CandidatoConcurso candidatoSeleccionado;
    private List<EvaluacionCandidato> evaluacionCandidatos;
    private List<CandidatoConcurso> candidatosGuardados;
    private List<CandidatoConcurso> candidatosContratar;
    private List<CriterioGb> criteriosDisponibles;
    //  Criterios adicionales
    private CriterioGb criterio;
    private List<CriterioGb> criteriosPrincipales;
    private String actaOAcuerdo;
    private Date dia;
    private Date fechaInicio;
    private Date fechaFin;
    private String dui;
    private String tipoContratoSeleccionado;
    private String comentarioFinal;
    private String estadoContrato;
    private Double salario;
    private Boolean error;
    private String observaciones;
    private String usuario;
    private List<Agencias> listaAgencias;
    private List<TiposPlanilla> listaTipoPlanilla;
    private Short agencia;
    private Short tipoPlanilla;
    private List<Candidato> listaCandidatos;
    private Concurso concursoSeleccionado;
    private Candidato[] candidatosSeleccionados;
    private CriterioGb[] criteriosAdicionales;
    private PruebaXPuesto pruebaXPuestoSeleccionada;
    private AutocompletePruebaConverter pruebaConverter;
    private EvaluacionCandidato pruebaEliminar;
    private List<BeneficiarioXCandidato> listaBeneficiarios;
    private List<Parentesco> listaParentesco;
    private String nombreBeneficiario;
    private Short parentesco;
    private BeneficiarioXCandidato beneficiarioSeleccionado;
    private Short parentescoEdit;
    private String accionSeleccion = "A";
    private Candidato preCandidatoSeleccionado;

    public PreseleccionAspiranteBackendBean() {
    }

    public CriterioGb getCriterio() {
        return criterio;
    }

    public void setCriterio(CriterioGb criterio) {
        this.criterio = criterio;
    }

    public String agregarCriterio(){
        if (criteriosPrincipales == null) {
            criteriosPrincipales = new ArrayList<CriterioGb>();
        }
        if (!criteriosPrincipales.contains(criterio)) {
            criteriosPrincipales.add(criterio);
        } else {
            addMessage("Agregar criterio", "Este criterio ya ha sido seleccionado.", TipoMensaje.INFORMACION);
        }
        return null;
    }
    
    public String eliminarCriterio() {
        if (criteriosPrincipales != null && !criteriosPrincipales.isEmpty()) {
            if (criteriosPrincipales.contains(criterio)) {
                criteriosPrincipales.remove(criterio);
            }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        setDia(new Date());
        pruebaConverter = new AutocompletePruebaConverter(reclutamientoSessionBean.finPruebaXPuestosByCias(getSessionBeanADM().getCompania()));
        listaParentesco = reclutamientoSessionBean.findParentescoByCias(getSessionBeanADM().getCompania());
    }

    public Candidato getPreCandidatoSeleccionado() {
        return preCandidatoSeleccionado;
    }

    public void setPreCandidatoSeleccionado(Candidato preCandidatoSeleccionado) {
        this.preCandidatoSeleccionado = preCandidatoSeleccionado;
    }

    public String getAccionSeleccion() {
        return accionSeleccion;
    }

    public void setAccionSeleccion(String accionSeleccion) {
        this.accionSeleccion = accionSeleccion;
    }

    public List<Parentesco> getListaParentesco() {
        return listaParentesco;
    }

    public void setListaParentesco(List<Parentesco> listaParentesco) {
        this.listaParentesco = listaParentesco;
    }

    public List<BeneficiarioXCandidato> getListaBeneficiarios() {
        return listaBeneficiarios;
    }

    public void setListaBeneficiarios(List<BeneficiarioXCandidato> listaBeneficiarios) {
        this.listaBeneficiarios = listaBeneficiarios;
    }

    public CandidatoConcurso getCandidatoSeleccionado() {
        return candidatoSeleccionado;
    }

    public void setCandidatoSeleccionado(CandidatoConcurso candidatoSeleccionado) {
        this.candidatoSeleccionado = candidatoSeleccionado;
    }

    public DataTable getTableConcursos() {
        return tableConcursos;
    }

    public void setTableConcursos(DataTable tableConcursos) {
        this.tableConcursos = tableConcursos;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public List<Concurso> getListaConcurso() {
        return listaConcurso;
    }

    public void setListaConcurso(List<Concurso> listaConcurso) {
        this.listaConcurso = listaConcurso;
    }

    public List<Candidato> getListaCandidato() {
        return reclutamientoSessionBean.getCandidatosByEmpresa(getSessionBeanADM().getCompania());
    }

    public DataTable getTableCandidatos() {
        return tableCandidatos;
    }

    public void setTableCandidatos(DataTable tableCandidatos) {
        this.tableCandidatos = tableCandidatos;
    }

    public DataTable getTableContratacion() {
        return tableContratacion;
    }

    public void setTableContratacion(DataTable tableContratacion) {
        this.tableContratacion = tableContratacion;
    }

    public List<CandidatoConcurso> getCandidatosGuardados() {
        return candidatosGuardados;
    }

    public void setCandidatosGuardados(List<CandidatoConcurso> candidatoConcurso) {
        this.candidatosGuardados = candidatoConcurso;
    }

    public DataTable getTableSeleccion() {
        return tableSeleccion;
    }

    public void setTableSeleccion(DataTable tableSeleccion) {
        this.tableSeleccion = tableSeleccion;
    }

    public List<EvaluacionCandidato> getEvaluacionCandidatos() {
        return evaluacionCandidatos;
    }

    public void setEvaluacionCandidatos(List<EvaluacionCandidato> evaluacionCandidatos) {
        this.evaluacionCandidatos = evaluacionCandidatos;
    }

    public List<CandidatoConcurso> getCandidatosContratar() {
        return candidatosContratar;
    }

    public void setCandidatosContratar(List<CandidatoConcurso> candidatosContratar) {
        this.candidatosContratar = candidatosContratar;
    }

    public List<Agencias> getListaAgencias() {
        listaAgencias = reclutamientoSessionBean.findAgenciasByEmpresa(getSessionBeanADM().getCompania());
        return listaAgencias;
    }

    public void setListaSucursales(List<Agencias> listaAgencias) {
        this.listaAgencias = listaAgencias;
    }

    public List<TiposPlanilla> getListaTipoPlanilla() {
        listaTipoPlanilla = reclutamientoSessionBean.findTipoPlanillaByEmpresa(getSessionBeanADM().getCompania());
        return listaTipoPlanilla;
    }

    public void setListaTipoPlanilla(List<TiposPlanilla> listaTipoPlanilla) {
        this.listaTipoPlanilla = listaTipoPlanilla;
    }

    public Short getAgencia() {
        return agencia;
    }

    public void setAgencia(Short agencia) {
        this.agencia = agencia;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public List<CriterioGb> getCriteriosDisponibles() {
        return criteriosDisponibles;
    }

    public void setCriteriosDisponibles(List<CriterioGb> criteriosDisponibles) {
        this.criteriosDisponibles = criteriosDisponibles;
    }

    public String getTipoContratoSeleccionado() {
        return tipoContratoSeleccionado;
    }

    public void setTipoContratoSeleccionado(String tipoContratoSeleccionado) {
        this.tipoContratoSeleccionado = tipoContratoSeleccionado;
    }

    public String getComentarioFinal() {
        return comentarioFinal;
    }

    public void setComentarioFinal(String comentarioFinal) {
        this.comentarioFinal = comentarioFinal;
    }

    public String getActaOAcuerdo() {
        return actaOAcuerdo;
    }

    public void setActaOAcuerdo(String actaOAcuerdo) {
        this.actaOAcuerdo = actaOAcuerdo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(String estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<CriterioGb> getCriteriosPrincipales() {
        return criteriosPrincipales;
    }

    public void setCriteriosPrincipales(List<CriterioGb> criteriosPrincipales) {
        this.criteriosPrincipales = criteriosPrincipales;
    }

    public String getUsuario() {
        if (candidatoSeleccionado != null) {
            if (candidatoSeleccionado.getCandidato1() != null) {
                usuario = reclutamientoSessionBean.generaUsuario(candidatoSeleccionado.getCandidato1());
            }
        }
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String buscarConcurso$action() {
        setConcursoSeleccionado(null);
        if (fechaInicial != null && fechaFinal != null) {
            if (validaFechas(fechaInicial, fechaFinal) == true) {
                setListaConcurso(reclutamientoSessionBean.getListaConcursos(getSessionBeanADM().getCompania(), fechaInicial, fechaFinal));
            } else {
                addMessage("Buscar concurso", "Los rangos de fecha Ingresados no son consistentes.", TipoMensaje.ERROR);
            }
        }
        setListaConcurso(reclutamientoSessionBean.getListaConcursos(getSessionBeanADM().getCompania(), fechaInicial, fechaFinal));
        limpiarCampos();
        return null;
    }

    public String iniciar() {
        if (comentarioFinal == null || comentarioFinal.length() <= 0) {
            addMessage("Cerrar Concurso", "Debe ingresar un comentario final antes de cerrar el concurso.", TipoMensaje.ERROR);
            return null;
        }
        cerrarConcurso();
        setListaConcurso(new ArrayList<Concurso>());
        limpiarCampos();
        return "concursoSeleccionado";
    }

    public void cerrarConcurso() {
        EstadoConcurso ec = reclutamientoSessionBean.findEstadoConcursoById(new EstadoConcursoPK(getSessionBeanADM().getCompania().getCodCia(), "C"));
        if (ec == null) {
            addMessage("Cerrar Concurso", "No esta registrado el estado de concurso para guardar los cambios.", TipoMensaje.INFORMACION);
            return;
        }
        if (getConcursoSeleccionado() != null) {
            getConcursoSeleccionado().setEstadoConcurso(ec);
            getConcursoSeleccionado().setComentarioFinal(comentarioFinal);
            reclutamientoSessionBean.editarConcurso(getConcursoSeleccionado());
            addMessage("Cerrar Concurso", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
        }
    }

    public void onEditCandidato(RowEditEvent event) {
        reclutamientoSessionBean.editarCandidatoConcurso((CandidatoConcurso) event.getObject());
        actualizaListas();
    }

    public void onEditNotasCandidato(RowEditEvent event) {
        EvaluacionCandidato c = (EvaluacionCandidato) event.getObject();
        if (c.getNota() == null) {
            c.setNota(BigDecimal.ZERO);
        }
        reclutamientoSessionBean.editarEvaluacionCandidato(c);
        if (evaluacionCandidatos != null && evaluacionCandidatos.size() > 0) {
            reclutamientoSessionBean.actualizarNotaCandidato(evaluacionCandidatos,candidatoSeleccionado);
        }
        actualizaListas();
        addMessage("Evaluacion de Candidato", "Datos Guardados", TipoMensaje.INFORMACION);
    }

    public void onEditUpdate(RowEditEvent event) {
        reclutamientoSessionBean.editarCandidatoConcurso((CandidatoConcurso) event.getObject());
        actualizaListas();
    }

    public String onFlowListener(FlowEvent event) {
        if (getConcursoSeleccionado() == null) {
            addMessage("Contratar Candidato", "No ha seleccionado ningún concurso", TipoMensaje.INFORMACION);
            return "concursoSeleccionado";
        }
        if (event.getOldStep().equals("concursoSeleccionado")) {
            if (getConcursoSeleccionado() != null) {
                setCriteriosPrincipales( reclutamientoSessionBean.getListaCriteriosPorPuesto(getConcursoSeleccionado().getPuestos().getPuestosPK()));            
                setCriteriosDisponibles( reclutamientoSessionBean.getListaCriteriosAdicionales(concursoSeleccionado.getPuestos().getPuestosPK()));
            }
        }
        actualizaListas();
        if (event.getNewStep().equals("tabSeleccion")) {
            ordenarLista();
        }
        return event.getNewStep();
    }

    public void ordenarLista() {
        if (candidatosGuardados != null) {
            Collections.sort(candidatosGuardados);
            for (int i = 0; i <= candidatosGuardados.size() - 1; i++) {
                candidatosGuardados.get(i).setOrden(i);
                if (i == 5) {
                    break;
                }
            }
        }
    }

    public String aplicarCriterios() {
        if (getConcursoSeleccionado() != null) {
            if (getCandidatosSeleccionados() != null) {
                for (Candidato n : getCandidatosSeleccionados()) {
                    if (n.getConcursoList() == null) {
                        n.setConcursoList(new ArrayList<Concurso>());
                        n.getConcursoList().add(getConcursoSeleccionado());
                    } else if (!n.getConcursoList().contains(getConcursoSeleccionado())) {
                        n.getConcursoList().add(getConcursoSeleccionado());
                    }
                    reclutamientoSessionBean.editarCandidato(n);
                }
                addMessage("Preselección de Candidatos", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
                return "concursoSeleccionado";
            }
        }
        addMessage("Preselección de Candidatos", "No ha seleccionado ningún concurso, de clic en Atrás para reiniciar el asistente.", TipoMensaje.INFORMACION);
        return "concursoSeleccionado";
    }

    public String seleccionarCandidato() {
        cambioEstadoCandidato("S");
        return null;
    }

    public String deseleccionarCandidato() {
        cambioEstadoCandidato("P");
        return null;
    }

    public String contratarCandidato() {
        if (candidatoSeleccionado != null) {
            if (getConcursoSeleccionado() == null) {
                addMessage("Contratar Candidato", "No ha seleccionado ningún concurso", TipoMensaje.INFORMACION);
                return null;
            }
            error = Boolean.FALSE;
            Contrato contrato = new Contrato();
            if (actaOAcuerdo == null || actaOAcuerdo.length() <= 0) {
                addMessage("Contratar Candidato", "El campo Acta o Acuerdo es requerido", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            if (dia == null) {
                addMessage("Contratar Candidato", "El campo Fecha Acuerdo es requerido", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            if (fechaInicio == null) {
                addMessage("Contratar Candidato", "El campo Fecha Inicio es requerido", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            if (fechaInicio != null && fechaFin != null) {
                if (validaFechas(fechaInicio, fechaInicio) == false) {
                    addMessage("Buscar concurso", "Los rangos de fecha Ingresados no son consistentes.", TipoMensaje.ERROR);
                    error = Boolean.TRUE;
                }
            }
            if (salario == null) {
                addMessage("Contratar Candidato", "El campo Salario es requerido", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            if (dui == null || dui.length() <= 0) {
                addMessage("Contratar Candidato", "El campo DUI es requerido", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            if (usuario == null || usuario.length() <= 0) {
                addMessage("Contratar Candidato", "El campo Usuario es requerido", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            if (usuario != null) {
                if (!reclutamientoSessionBean.findByUsuario(usuario).isEmpty()) {
                    addMessage("Contratar Candidato", "El usuario ingresado ya esta siendo usado por otra persona.", TipoMensaje.ERROR);
                    error = Boolean.TRUE;
                }
            }
            if (agencia == null) {
                addMessage("Contratar Candidato", "Seleccione una Sucursal", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            if (tipoPlanilla == null) {
                addMessage("Contratar Candidato", "Seleccione el Tipo de Planilla", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }

            if (getSessionBeanADM().getRepresentantePatronal() == null) {
                addMessage("Contratar Candidato", "No se ha configurado el representante patronal", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }

            if (error) {
                return null;
            }
            contrato.setNumActa(getActaOAcuerdo());
            contrato.setEstado(estadoContrato);
            contrato.setTipo(tipoContratoSeleccionado);
            contrato.setFechaAcuerdo(getDia());
            contrato.setFechaInicio(getFechaInicio());
            contrato.setFechaFinal(getFechaFin());
            contrato.setPuestos(getConcursoSeleccionado().getPuestos());
            contrato.setSalario(new BigDecimal(getSalario()));
            contrato.setCodAgencia(agencia);
            contrato.setTiposPlanilla(new TiposPlanilla(new TiposPlanillaPK(getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla)));
            contrato.setObservacion(getObservaciones());
            reclutamientoSessionBean.contratarCandidato(candidatoSeleccionado, contrato, usuario, getSessionBeanADM().getRepresentantePatronal(), dui);
            limpiarDatosContratacion();
            addMessage("Contratar Candidato", "Datos Guardados ", TipoMensaje.INFORMACION);
            actualizaListas();
        }
        return null;
    }

    public void limpiarDatosContratacion() {
        setActaOAcuerdo(null);
        setFechaInicio(null);
        setFechaFin(null);
        setDui(null);
        setTipoContratoSeleccionado(null);
        setComentarioFinal(null);
        setEstadoContrato(null);
        setSalario(null);
        setObservaciones(null);
        error = Boolean.FALSE;
    }

    public String noContratarCandidato() {
        if (tableContratacion.getRowIndex() != -1) {
            CandidatoConcurso c = candidatosContratar.get(tableContratacion.getRowIndex());
            c.setEstado("S");
            reclutamientoSessionBean.editarCandidatoConcurso(c);
            addMessage("Seleccionar Candidato", "Datos Guardados ", TipoMensaje.INFORMACION);
            actualizaListas();
        }
        return null;
    }

    public void cambioEstadoCandidato(String estado) {
        if (tableSeleccion.getRowIndex() != -1) {
            CandidatoConcurso c = candidatosGuardados.get(tableSeleccion.getRowIndex());
            c.setEstado(estado);
            reclutamientoSessionBean.editarCandidatoConcurso(c);
            addMessage("Seleccionar Candidato", "Datos Guardados " + candidatosGuardados.get(tableSeleccion.getRowIndex()).getCandidato1().getNombreCompleto(), TipoMensaje.INFORMACION);
            actualizaListas();
            ordenarLista();
        }
    }

    public void handleCloseEvaluacionCandidato(CloseEvent event) {
        reclutamientoSessionBean.actualizarNotaCandidato(evaluacionCandidatos,candidatoSeleccionado);
        setCandidatoSeleccionado(null);
    }

    public void handleCloseCriterioAdicional(CloseEvent event) {
        if (getCriteriosAdicionales() != null && getCriteriosAdicionales().length > 0) {
            for (CriterioGb criterio : getCriteriosAdicionales()) {
                if (getCriteriosPrincipales() == null) {
                    setCriteriosPrincipales(new ArrayList<CriterioGb>());
                }
                if (!getCriteriosPrincipales().contains(criterio)) {
                    getCriteriosPrincipales().add(criterio);
                }
            }
        }
    }

    public String listarEvaluaciones() {
        setEvaluacionCandidatos(reclutamientoSessionBean.getListEvaluacionCandidato(candidatoSeleccionado));//registrarPruebasPorCandidato();
        return null;
    }

    public void actualizaListas() {
        if (getConcursoSeleccionado() != null) {
            listaCandidatos = reclutamientoSessionBean.getCandidatosByConcurso(getConcursoSeleccionado());
            setCandidatosGuardados(reclutamientoSessionBean.getListaCandidatoConcurso(getConcursoSeleccionado(), "P"));
            setCandidatosContratar(reclutamientoSessionBean.getListaCandidatoSeleccionado(getConcursoSeleccionado(), Arrays.asList("S", "C")));
        }
    }

    @Override
    protected void limpiarCampos() {
        setFechaInicial(null);
        setFechaFinal(null);
        tableConcursos.setSelection(null);
        tableCandidatos.setSelection(null);
        setComentarioFinal(null);
        setConcursoSeleccionado(null);
        setCriteriosAdicionales(new CriterioGb[0]);
        setAccionSeleccion("A");
    }

    public String buscarCandidatosXCriterios() {
        if (concursoSeleccionado == null) {
            addMessage("Reclutamiento y Selección", "Aun no ha seleccionado un Concurso.", TipoMensaje.ERROR);
            return null;
        }
        setAccionSeleccion("C");
        setCandidatosSeleccionados(null);
        if (criteriosPrincipales!= null && !criteriosPrincipales.isEmpty()){
            listaCandidatos = reclutamientoSessionBean.findCandidatosMatchCriteria( /*Arrays.asList(*/criteriosPrincipales/*criteriosSeleccionados) */);
        }else{
            listaCandidatos= new ArrayList<Candidato>();
        }
        
        return null;
    }

    public String buscarAllCandidatos() {
        if (concursoSeleccionado == null) {
            addMessage("Reclutamiento y Selección", "Aun no ha seleccionado un Concurso.", TipoMensaje.ERROR);
            return null;
        }
        setAccionSeleccion("M");
        setCandidatosSeleccionados(null);
        listaCandidatos = reclutamientoSessionBean.getCandidatosByEmpresa(getSessionBeanADM().getCompania());
        return null;
    }

    public String buscarAllEmpleados() {
        if (concursoSeleccionado == null) {
            addMessage("Reclutamiento y Selección", "Aun no ha seleccionado un Concurso.", TipoMensaje.ERROR);
            return null;
        }
        setAccionSeleccion("M");
        setCandidatosSeleccionados(null);
        listaCandidatos = reclutamientoSessionBean.findCandidatosLikeEmpleados(getSessionBeanADM().getCompania());
        return null;
    }

    public String mostrarCandidatos() {
        setAccionSeleccion("A");
        actualizaListas();
        setCandidatosSeleccionados(null);
        return null;
    }

    public EvaluacionCandidato getPruebaEliminar() {
        return pruebaEliminar;
    }

    public void setPruebaEliminar(EvaluacionCandidato pruebaEliminar) {
        this.pruebaEliminar = pruebaEliminar;
    }

    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
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

    public void onRowSelectConcurso(SelectEvent event) {
        setConcursoSeleccionado((Concurso) event.getObject());
    }

    public void onRowUnSelectConcurso(UnselectEvent event) {
        setConcursoSeleccionado(null);
    }

    public CriterioGb[] getCriteriosAdicionales() {
        return criteriosAdicionales;
    }

    public void setCriteriosAdicionales(CriterioGb[] criteriosAdicionales) {
        this.criteriosAdicionales = criteriosAdicionales;
    }

    public AutocompletePruebaConverter getPruebaConverter() {
        return pruebaConverter;
    }

    public void setPruebaConverter(AutocompletePruebaConverter pruebaConverter) {
        this.pruebaConverter = pruebaConverter;
    }

    public PruebaXPuesto getPruebaXPuestoSeleccionada() {
        return pruebaXPuestoSeleccionada;
    }

    public void setPruebaXPuestoSeleccionada(PruebaXPuesto pruebaXPuestoSeleccionada) {
        this.pruebaXPuestoSeleccionada = pruebaXPuestoSeleccionada;
    }

    public List<PruebaXPuesto> completePrueba(String query) {
        List<PruebaXPuesto> suggestions = new ArrayList<PruebaXPuesto>();
        for (PruebaXPuesto p : pruebaConverter.listaPruebaXPuesto) {
            if (p.getNombre().contains(query)) {
                suggestions.add(p);
            }
        }
        return suggestions;
    }

    public String agregarPrueba() {
        if (pruebaXPuestoSeleccionada != null) {
            addMessage("Reclutamiento y Selección", "Ha Seleccionado " + pruebaXPuestoSeleccionada.getNombre(), TipoMensaje.INFORMACION);
            return null;
        }
        addMessage("Reclutamiento y Selección", "No ha Seleccionado ninguna Prueba", TipoMensaje.ERROR);
        return null;
    }

    public String eliminarPruebaCandidato() {
        if (pruebaEliminar == null) {
            addMessage("Reclutamiento y Selección", "No ha Seleccionado ninguna Prueba", TipoMensaje.ERROR);
            return null;
        }
        reclutamientoSessionBean.eliminarEvaluacionCandidato(pruebaEliminar);
        addMessage("Reclutamiento y Selección", "Datos eliminados con éxito.", TipoMensaje.INFORMACION);
        setEvaluacionCandidatos(reclutamientoSessionBean.getListEvaluacionCandidato(candidatoSeleccionado));
        reclutamientoSessionBean.actualizarNotaCandidato(evaluacionCandidatos,candidatoSeleccionado);
        return null;
    }

    public String agregarPruebaCandidato() {
        if (candidatoSeleccionado == null) {
            addMessage("Reclutamiento y Selección", "No ha Seleccionado ningun Candidato", TipoMensaje.ERROR);
            return null;
        }
        if (pruebaXPuestoSeleccionada == null) {
            addMessage("Reclutamiento y Selección", "No ha Seleccionado ninguna Prueba", TipoMensaje.ERROR);
            return null;
        }
        EvaluacionCandidato nuevaEvaluacion = new EvaluacionCandidato();
        EvaluacionCandidatoPK pk = new EvaluacionCandidatoPK();
        nuevaEvaluacion.setCandidatoConcurso(candidatoSeleccionado);
        nuevaEvaluacion.setFecha(new Date());
        nuevaEvaluacion.setNota(BigDecimal.ZERO);
        nuevaEvaluacion.setObservacion("Ninguna");
        nuevaEvaluacion.setPruebaXPuesto(pruebaXPuestoSeleccionada);
        pk.setCodCia(pruebaXPuestoSeleccionada.getPruebaXPuestoPK().getCodCia());
        pk.setPrueba(pruebaXPuestoSeleccionada.getPruebaXPuestoPK().getCodigo());
        pk.setCandidato(candidatoSeleccionado.getCandidato1().getCandidatoPK().getCodCandidato());
        pk.setConcurso(getConcursoSeleccionado().getConcursoPK().getCodConcurso());
        nuevaEvaluacion.setEvaluacionCandidatoPK(pk);
        for (EvaluacionCandidato a : evaluacionCandidatos) {
            if (a.getEvaluacionCandidatoPK().equals(pk)) {
                addMessage("Reclutamiento y Selección", "Ya se ha registrado una evaluación de este tipo.", TipoMensaje.ERROR);
                return null;
            }
        }
        try {
            reclutamientoSessionBean.guardarEvaluacionCandidato(nuevaEvaluacion);
            addMessage("Reclutamiento y Selección", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
            setEvaluacionCandidatos(reclutamientoSessionBean.getListEvaluacionCandidato(candidatoSeleccionado));
            setPruebaXPuestoSeleccionada(null);
        } catch (Exception e) {
            addMessage("Reclutamiento y Selección", "Ocurrio un error al intentar guardar.", TipoMensaje.ERROR);
        }
        return null;
    }

    public String imprimirContrato() {
        if (candidatoSeleccionado == null) {
            addMessage("Reclutamiento y Selección", "No ha seleccionado ningun candidato.", TipoMensaje.ERROR);
            return null;
        }
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("COD_CIA", candidatoSeleccionado.getCandidatoConcursoPK().getCodCia().intValue());
        parametros.put("COD_EMP", candidatoSeleccionado.getCandidato1().getEmpleados().getEmpleadosPK().getCodEmp());
        reportesStatelessBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "reporteContrato");
        return null;
    }

    public String listarBeneficiarios() {
        listaBeneficiarios = candidatoSeleccionado != null ? reclutamientoSessionBean.findBeneficiariosByCandidato(candidatoSeleccionado.getCandidato1()) : new ArrayList<BeneficiarioXCandidato>();
        return null;
    }

    public String guardarBeneficiario() {
        Boolean _error = Boolean.FALSE;
        if (candidatoSeleccionado == null) {
            addMessage("Reclutamiento y Selección", "No ha seleccionado ningun candidato.", TipoMensaje.ERROR);
            _error = Boolean.TRUE;
        }
        if (nombreBeneficiario == null || nombreBeneficiario.length() <= 0) {
            addMessage("Reclutamiento y Selección", "Ingrese el nombre del beneficiario.", TipoMensaje.ERROR);
            _error = Boolean.TRUE;
        }
        if (parentesco == null || parentesco == -1) {
            addMessage("Reclutamiento y Selección", "Seleccione el parentesco.", TipoMensaje.ERROR);
            _error = Boolean.TRUE;
        }
        if (_error) {
            return null;
        }
        BeneficiarioXCandidato bc = new BeneficiarioXCandidato();
        BeneficiarioXCandidatoPK pk = reclutamientoSessionBean.getPkBeneficiarioCandiato(candidatoSeleccionado.getCandidato1());
        bc.setBeneficiarioXCandidatoPK(pk);
        bc.setCandidato(candidatoSeleccionado.getCandidato1());
        bc.setNombre(nombreBeneficiario);
        bc.setParentesco(new Parentesco(candidatoSeleccionado.getCandidatoConcursoPK().getCodCia(), parentesco));

        try {
            reclutamientoSessionBean.guardarBeneficiarioCandidato(bc);
            addMessage("Reclutamiento y Selección", "Datos Guardados con exito.", TipoMensaje.INFORMACION);
            listaBeneficiarios = candidatoSeleccionado != null ? reclutamientoSessionBean.findBeneficiariosByCandidato(candidatoSeleccionado.getCandidato1()) : new ArrayList<BeneficiarioXCandidato>();
        } catch (Exception e) {
            addMessage("Reclutamiento y Selección", "Ocurrio un error al intentar guardar.", TipoMensaje.ERROR);
        }
        nombreBeneficiario = null;
        parentesco = null;
        return null;
    }

    public void onEditarBeneficiario(RowEditEvent event) {
        BeneficiarioXCandidato c = (BeneficiarioXCandidato) event.getObject();
        if (c.getNombre() == null || c.getNombre().length() <= 0) {
            addMessage("Reclutamiento y Selección", "Ingrese el nombre de beneficiario.", TipoMensaje.ERROR);
            return;
        }
        c.setParentesco(new Parentesco(getSessionBeanADM().getCompania().getCodCia(), parentescoEdit));
        try {
            reclutamientoSessionBean.editarBeneficiarioCandidato(c);
            listaBeneficiarios = candidatoSeleccionado != null ? reclutamientoSessionBean.findBeneficiariosByCandidato(candidatoSeleccionado.getCandidato1()) : new ArrayList<BeneficiarioXCandidato>();
            addMessage("Reclutamiento y Selección", "Datos Guardados con exito.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String eliminarBeneficiario() {
        if (beneficiarioSeleccionado == null) {
            addMessage("Reclutamiento y Selección", "No ha seleccionado ningun beneficiario.", TipoMensaje.ERROR);
            return null;
        }
        try {
            reclutamientoSessionBean.eliminarBeneficiarioCandidato(beneficiarioSeleccionado);
            addMessage("Reclutamiento y Selección", "Datos Eliminados con exito.", TipoMensaje.INFORMACION);
            listaBeneficiarios = candidatoSeleccionado != null ? reclutamientoSessionBean.findBeneficiariosByCandidato(candidatoSeleccionado.getCandidato1()) : new ArrayList<BeneficiarioXCandidato>();
        } catch (Exception e) {
            addMessage("Reclutamiento y Selección", "Ocurrio un error al intentar eliminar.", TipoMensaje.ERROR);
        }

        return null;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public Short getParentesco() {
        return parentesco;
    }

    public void setParentesco(Short parentesco) {
        this.parentesco = parentesco;
    }

    public BeneficiarioXCandidato getBeneficiarioSeleccionado() {
        return beneficiarioSeleccionado;
    }

    public void setBeneficiarioSeleccionado(BeneficiarioXCandidato beneficiarioSeleccionado) {
        this.beneficiarioSeleccionado = beneficiarioSeleccionado;
    }

    public Short getParentescoEdit() {
        return parentescoEdit;
    }

    public void setParentescoEdit(Short parentescoEdit) {
        this.parentescoEdit = parentescoEdit;
    }

    public String eliminarCandidato() {

        try {
            if (candidatoSeleccionado == null) {
                addMessage("Reclutamiento y Selección", "No ha seleccionado ningún candidato.", TipoMensaje.ERROR);
                return null;
            }
            for (EvaluacionCandidato e : candidatoSeleccionado.getEvaluacionCandidatoList()) {
                reclutamientoSessionBean.eliminarEvaluacionCandidato(e);
            }
            candidatoSeleccionado.getCandidato1().getConcursoList().remove(concursoSeleccionado);
            reclutamientoSessionBean.editarCandidato(candidatoSeleccionado.getCandidato1());
            reclutamientoSessionBean.removerCandidatoConcurso(candidatoSeleccionado);
            addMessage("Reclutamiento y Selección", "Datos Eliminados con exito.", TipoMensaje.INFORMACION);
            actualizaListas();
            setCandidatoSeleccionado(null);
        } catch (Exception e) {
            addMessage("Reclutamiento y Selección", "Ocurrio un error al intentar eliminar.", TipoMensaje.ERROR);
            e.printStackTrace();
        }

        return null;
    }
}