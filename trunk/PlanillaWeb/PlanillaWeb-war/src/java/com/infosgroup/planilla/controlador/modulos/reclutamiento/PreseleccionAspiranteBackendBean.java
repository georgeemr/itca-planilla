/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoConcurso;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.Contrato;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import com.infosgroup.planilla.modelo.entidades.EstadoConcurso;
import com.infosgroup.planilla.modelo.entidades.EstadoConcursoPK;
import com.infosgroup.planilla.modelo.entidades.EvaluacionCandidato;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanillaPK;
import com.infosgroup.planilla.modelo.entidades.Agencias;
import com.infosgroup.planilla.modelo.entidades.AgenciasPK;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.modelo.procesos.SeguridadSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private SeguridadSessionBean seguridadSessionBean;
    @EJB
    private ReclutamientoSessionBean reclutamientoSessionBean;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Concurso> listaConcurso;
    private DataTable tableConcursos;
    private DataTable tableCriterios;
    private DataTable tableCandidatos;
    private DataTable tableSeleccion;
    private DataTable tableContratacion;
    private DataTable tableCriteriosAdicionales;
    private CandidatoConcurso candidatoSeleccionado;
    private List<EvaluacionCandidato> evaluacionCandidatos;
    private List<CandidatoConcurso> candidatosGuardados;
    private List<CandidatoConcurso> candidatosContratar;
    private List<CriteriosXPuesto> criteriosDisponibles; /* Criterios adicionales*/

    private List<CriteriosXPuesto> criteriosPrincipales;

    private String actaOAcuerdo;
    private Date dia;
    private Date fechaInicio;
    private Date fechaFin;
    private String representantePatronal;
    private Long tipoContratoSeleccionado;
    private String comentarioFinal;
    private Long estadoContrato;
    private Double salario;
    private Boolean error;
    private String observaciones;
    private String usuario;
    private List<Agencias> listaAgencias;
    private List<TiposPlanilla> listaTipoPlanilla;
    private Short agencia;
    private Short tipoPlanilla;

    public PreseleccionAspiranteBackendBean() {
    }

    @PostConstruct
    public void init() {
        setDia(new Date());
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

    public DataTable getTableCriterios() {
        return tableCriterios;
    }

    public void setTableCriterios(DataTable tableCriterios) {
        this.tableCriterios = tableCriterios;
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

    public List<CriteriosXPuesto> getCriteriosDisponibles() {
        criteriosDisponibles = reclutamientoSessionBean.criteriosDisponibles(getSessionBeanADM().getCompania());
        return criteriosDisponibles;
    }

    public void setCriteriosDisponibles(List<CriteriosXPuesto> criteriosDisponibles) {
        this.criteriosDisponibles = criteriosDisponibles;
    }

    public Long getTipoContratoSeleccionado() {
        return tipoContratoSeleccionado;
    }

    public void setTipoContratoSeleccionado(Long tipoContratoSeleccionado) {
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

    public String getRepresentantePatronal() {
        return representantePatronal;
    }

    public void setRepresentantePatronal(String representantePatronal) {
        this.representantePatronal = representantePatronal;
    }

    public Long getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(Long estadoContrato) {
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

    public List<CriteriosXPuesto> getCriteriosPrincipales() {
        return criteriosPrincipales;
    }

    public void setCriteriosPrincipales(List<CriteriosXPuesto> criteriosPrincipales) {
        this.criteriosPrincipales = criteriosPrincipales;
    }

    public DataTable getTableCriteriosAdicionales() {
        return tableCriteriosAdicionales;
    }

    public void setTableCriteriosAdicionales(DataTable tableCriteriosAdicionales) {
        this.tableCriteriosAdicionales = tableCriteriosAdicionales;
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
        if (fechaInicial != null && fechaFinal != null) {
            if (validaFechas(fechaInicial, fechaFinal) == true) {
                setListaConcurso(reclutamientoSessionBean.getListaConcursos( getSessionBeanADM().getCompania(), fechaInicial, fechaFinal));
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
        if (getSessionBeanREC().getConcursoSeleccionado() != null) {
            getSessionBeanREC().getConcursoSeleccionado().setEstadoConcurso(ec);
            getSessionBeanREC().getConcursoSeleccionado().setComentarioFinal(comentarioFinal);
            reclutamientoSessionBean.editarConcurso(getSessionBeanREC().getConcursoSeleccionado());
            addMessage("Cerrar Concurso", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
        }
    }

    public void onRowSelectConcurso(SelectEvent event) {
        getSessionBeanREC().setConcursoSeleccionado((Concurso) event.getObject());
    }

    public void onRowSelectCriterio(SelectEvent event) {
        reclutamientoSessionBean.guardarCriterioSeleccionado((CriteriosXPuesto) event.getObject(), getSessionBeanEMP().getEmpleadoSesion().getUsuario());
    }

    public void onRowUnSelectCriterio(UnselectEvent event) {
        reclutamientoSessionBean.eliminarCriterioSeleccionado((CriteriosXPuesto) event.getObject(), getSessionBeanEMP().getEmpleadoSesion().getUsuario());
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
            reclutamientoSessionBean.actualizarNotaCandidato(evaluacionCandidatos);
        }
        actualizaListas();
        addMessage("Evaluacion de Candidato", "Datos Guardados", TipoMensaje.INFORMACION);
    }

    public void onEditUpdate(RowEditEvent event) {
        reclutamientoSessionBean.editarCandidatoConcurso((CandidatoConcurso) event.getObject());
        actualizaListas();
    }

    public String onFlowListener(FlowEvent event) {
        if (getSessionBeanREC().getConcursoSeleccionado() == null) {
            return "concursoSeleccionado";
        }
        if (event.getOldStep().equals("concursoSeleccionado")) {
            if (getSessionBeanREC().getConcursoSeleccionado() != null) {
                setCriteriosPrincipales(getSessionBeanREC().getConcursoSeleccionado().getPuestos().getCriteriosXPuestoList());
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
        if (sessionBeanREC.getConcursoSeleccionado() != null) {
            if (sessionBeanREC.getCandidatosSeleccionados() != null) {
                for (Candidato n : sessionBeanREC.getCandidatosSeleccionados()) {
//                    if (n.getConcursoList() == null) {
//                        n.setConcursoList(new ArrayList<Concurso>());
//                        n.getConcursoList().add(sessionBeanREC.getConcursoSeleccionado());
//                    } else if (!n.getConcursoList().contains(sessionBeanREC.getConcursoSeleccionado())) {
//                        n.getConcursoList().add(sessionBeanREC.getConcursoSeleccionado());
//                    }
                    reclutamientoSessionBean.editarCandidato(n);
                }
                addMessage("Preselección de Candidatos", "No implementado actualmente.", TipoMensaje.INFORMACION);
                //addMessage("Preselección de Candidatos", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
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

            if (getSessionBeanREC().getConcursoSeleccionado() == null) {
                addMessage("Contratar Candidato", "No ha seleccionado ningún concurso", TipoMensaje.INFORMACION);
                return null;
            }

            error = Boolean.FALSE;
            Contrato contrato = new Contrato();
            Agencias s = reclutamientoSessionBean.findAgenciasById(new AgenciasPK(getSessionBeanADM().getCompania().getCodCia(), agencia));
            TiposPlanilla t = reclutamientoSessionBean.findTipoPlanillaById(new TiposPlanillaPK(getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla));

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
            if (representantePatronal == null || representantePatronal.length() <= 0) {
                addMessage("Contratar Candidato", "El campo Representante Patronal es requerido", TipoMensaje.ERROR);
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

            if (s == null) {
                addMessage("Contratar Candidato", "Seleccione una Sucursal", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }

            if (t == null) {
                addMessage("Contratar Candidato", "Seleccione el Tipo de Planilla", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }

            if (error) {
                return null;
            }

            // 13062012 contrato.setActa(getActaOAcuerdo());
            // 13062012 contrato.setEstadoContrato(  );
            // 13062012 contrato.setTipoContrato(tc);
            contrato.setFechaAcuerdo(getDia());
            contrato.setFechaInicio(getFechaInicio());
            contrato.setFechaFinal(getFechaFin());
            contrato.setPuestos(getSessionBeanREC().getConcursoSeleccionado().getPuestos());
            contrato.setSalario(new BigDecimal(getSalario()));
            // 13062012 contrato.setAgencias(s);
            contrato.setTiposPlanilla(t);
            contrato.setObservacion(getObservaciones());
            reclutamientoSessionBean.contratarCandidato(candidatoSeleccionado, contrato, usuario);
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
        setRepresentantePatronal(null);
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
             addMessage("Seleccionar Candidato", "FALTA ESTA FUNCIONALIDAD HA SIDO  COMENTADA, TERMINAR INTEGRACION", TipoMensaje.ERROR_FATAL);
     //       addMessage("Seleccionar Candidato", "Datos Guardados " + candidatosGuardados.get(tableSeleccion.getRowIndex()).getCandidato1().getNombreCompleto(), TipoMensaje.INFORMACION);
            actualizaListas();
            ordenarLista();
        }
    }

    public void registrarPruebasPorCandidato() {
        reclutamientoSessionBean.registraPruebasPorCandidato(candidatoSeleccionado);
    }

    public void handleCloseEvaluacionCandidato(CloseEvent event) {
        if (evaluacionCandidatos != null && evaluacionCandidatos.size() > 0) {
            reclutamientoSessionBean.actualizarNotaCandidato(evaluacionCandidatos);
        }
        setCandidatoSeleccionado(null);
    }

    public void handleCloseCriterioAdicional(CloseEvent event) {
        if (getSessionBeanREC().getCriteriosAdicionales() != null && getSessionBeanREC().getCriteriosAdicionales().length > 0) {
            for (CriteriosXPuesto criterio : getSessionBeanREC().getCriteriosAdicionales()) {
                if (getCriteriosPrincipales() == null) {
                    setCriteriosPrincipales(new ArrayList<CriteriosXPuesto>());
                }
                if (!getCriteriosPrincipales().contains(criterio)) {
                    getCriteriosPrincipales().add(criterio);
                }
            }
        }
    }

    public String crearEvaluaciones() {
        registrarPruebasPorCandidato();
        setEvaluacionCandidatos(reclutamientoSessionBean.getListEvaluacionCandidato(candidatoSeleccionado));
        return null;
    }

    public void actualizaListas() {
        if (getSessionBeanREC().getConcursoSeleccionado() != null) {
            List<String> l = new ArrayList<String>();
            l.add("S");
            l.add("C");
            setCandidatosGuardados(reclutamientoSessionBean.getListaCandidatoConcurso(getSessionBeanREC().getConcursoSeleccionado(), "P"));
            setCandidatosContratar(reclutamientoSessionBean.getListaCandidatoSeleccionado(getSessionBeanREC().getConcursoSeleccionado(), l));
        }
    }

    @Override
    protected void limpiarCampos() {
        setFechaInicial(null);
        setFechaFinal(null);
        tableConcursos.setSelection(null);
        tableCriterios.setSelection(null);
        tableCandidatos.setSelection(null);
        tableCriteriosAdicionales.setSelection(null);
        setComentarioFinal(null);
        reclutamientoSessionBean.eliminarCriteriosSeleccionados(getSessionBeanADM().getCompania(), getSessionBeanEMP().getEmpleadoSesion().getUsuario());
        getSessionBeanREC().setConcursoSeleccionado(null);
        getSessionBeanREC().setCriteriosAdicionales(new CriteriosXPuesto[0]);
    }
}
