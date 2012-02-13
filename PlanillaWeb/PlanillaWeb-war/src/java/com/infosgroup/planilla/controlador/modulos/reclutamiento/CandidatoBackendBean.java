/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Deptos;
import com.infosgroup.planilla.modelo.entidades.Municipios;
import com.infosgroup.planilla.modelo.entidades.NivelAcademico;
import com.infosgroup.planilla.modelo.entidades.Paises;
import com.infosgroup.planilla.modelo.entidades.Profesion;
import com.infosgroup.planilla.modelo.entidades.TipoDocumento;
import com.infosgroup.planilla.modelo.entidades.TipoSangre;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.modelo.procesos.SessionBeanParametros;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$candidato")
@ViewScoped
public class CandidatoBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private ReclutamientoSessionBean reclutamientoFacade;
    @EJB
    private SessionBeanParametros sessionBeanParametros;
    private String nombre;
    private String apellido;
    private String apellidoDeCasada;
    private Date fechaNacimiento;
    private String sexo;
    private String observaciones;
    private Long tipoDocumentoSeleccionado;
    private List<SelectItem> selectSexo;
    private List<TipoDocumento> listaTipoDocumentos;
    private List<Candidato> listaCandidatos;
    private List<Paises> listaPaises;
    private List<Deptos> listaDepartamentos;
    private List<Municipios> listaMunicipios;
    private List<TipoSangre> listaTipoSangre;
    private List<NivelAcademico> listaNivelAcademico;
    private List<Profesion> listaProfesiones;
    private Boolean isError;

    public CandidatoBackendBean() {
    }

    @PostConstruct
    public void initComponents() {
        listaCandidatos = reclutamientoFacade.getCandidatosByEmpresa(getSessionBeanADM().getCompania());
    }

    public List<Paises> getListaPaises() {
        listaPaises = sessionBeanParametros.getListaPaises();
        return listaPaises != null ? listaPaises : new ArrayList<Paises>();
    }

    public void setListaPaises(List<Paises> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public List<Deptos> getListaDepartamentos() {
        listaDepartamentos = sessionBeanParametros.getListaDepartamentos();
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Deptos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<Municipios> getListaMunicipios() {
        listaMunicipios = sessionBeanParametros.getListaMunicipios();
        return listaMunicipios;
    }

    public void setListaMunicipios(List<Municipios> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public List<NivelAcademico> getListaNivelAcademico() {
        listaNivelAcademico = sessionBeanParametros.getListaNivelAcademicos();
        return listaNivelAcademico;
    }

    public void setListaNivelAcademico(List<NivelAcademico> listaNivelAcademico) {
        this.listaNivelAcademico = listaNivelAcademico;
    }

    public List<TipoSangre> getListaTipoSangre() {
        listaTipoSangre = sessionBeanParametros.getListaTipoSangre();
        return listaTipoSangre != null ? listaTipoSangre : new ArrayList<TipoSangre>();
    }

    public void setListaTipoSangre(List<TipoSangre> listaTipoSangre) {
        this.listaTipoSangre = listaTipoSangre;
    }

    public List<Profesion> getListaProfesiones() {
        listaProfesiones = sessionBeanParametros.getListaProfesiones();
        return listaProfesiones;
    }

    public void setListaProfesiones(List<Profesion> listaProfesiones) {
        this.listaProfesiones = listaProfesiones;
    }

    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    public List<TipoDocumento> getListaTipoDocumentos() {
        listaTipoDocumentos = reclutamientoFacade.findAllTipoDocumento();
        return listaTipoDocumentos;
    }

    public void setListaTipoDocumentos(List<TipoDocumento> listaTipoDocumentos) {
        this.listaTipoDocumentos = listaTipoDocumentos;
    }

    public Long getTipoDocumentoSeleccionado() {
        return tipoDocumentoSeleccionado;
    }

    public void setTipoDocumentoSeleccionado(Long tipoDocumentoSeleccionado) {
        this.tipoDocumentoSeleccionado = tipoDocumentoSeleccionado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellidoDeCasada() {
        return apellidoDeCasada;
    }

    public void setApellidoDeCasada(String apellidoDeCasada) {
        this.apellidoDeCasada = apellidoDeCasada;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SelectItem> getSelectSexo() {
        selectSexo = new ArrayList<SelectItem>();
        selectSexo.add(new SelectItem("1", "Masculino"));
        selectSexo.add(new SelectItem("2", "Femenino"));
        return selectSexo;
    }

    public void setSelectSexo(List<SelectItem> selectSexo) {
        this.selectSexo = selectSexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String guardarDatos$action() {

        Candidato candidato = new Candidato();
        CandidatoPK pkCandidato = new CandidatoPK();
        Short c = getSessionBeanADM().getCompania().getCodCia();
        Date hoy = new Date();
        Integer anioHoy = hoy.getYear();
        Integer nac = fechaNacimiento.getYear();
        Integer edad = anioHoy - nac;
        try {

            pkCandidato.setCodCia(c);
            pkCandidato.setCodCandidato(reclutamientoFacade.getMaxCandidato(getSessionBeanADM().getCompania()).intValue());
            candidato.setCandidatoPK(pkCandidato);
            candidato.setNombre(nombre);
            candidato.setFechaExpDui(fechaNacimiento);
            candidato.setApellido(apellido);
            candidato.setApCasada(apellidoDeCasada);
            candidato.setSexo(new Short(sexo));
            candidato.setObservacion(observaciones);
            candidato.setEstado("A");
            reclutamientoFacade.guardarCandidato(candidato);

            addMessage("Registro de Candidatos", "Datos guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        } catch (javax.persistence.EntityExistsException e) {
            addMessage("Registro de Candidatos", "El candidato ingresado ya existe.", TipoMensaje.ERROR_FATAL);
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void nuevo$vh$action() {
        setEstadoAccion(0);
    }

    public void consultar$vh$action() {
        setEstadoAccion(2);
    }

    public String editar$crud$action() {
        getSessionBeanADM().setEstadoAccion(1);
        return null;
    }

    public void setEstadoAccion(Integer estadoAccion) {
        getSessionBeanADM().setEstadoAccion(estadoAccion);
        limpiarCampos();
    }

    public String guardar$crud$action() {
        isError = Boolean.FALSE;
        return null;
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    @Override
    protected void limpiarCampos() {
        nombre = null;
        apellido = null;
        apellidoDeCasada = null;;
        fechaNacimiento = null;
        sexo = null;
        observaciones = null;
    }
}
