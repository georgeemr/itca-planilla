/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.view.JSFUtil;
import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$concursos")
@ViewScoped
public class ConcursoBackendBean extends JSFUtil implements Serializable {

    @EJB
    private ReclutamientoSessionBean reclutamientoFacade;
    private String nombreConcurso;
    private Date fechaInicial;
    private Date fechaFinal;
    private Integer numeroPlazas;
    private Integer puesto;
    private String estadoConcurso;
    private List<Puesto> listaPuestos;
    private List<EstadoConcurso> listaEstadoConcurso;
    private Boolean isError;

    public ConcursoBackendBean() {
    }

    /* getter & setter */
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

    public String getNombreConcurso() {
        return nombreConcurso;
    }

    public void setNombreConcurso(String nombreConcurso) {
        this.nombreConcurso = nombreConcurso;
    }

    public Integer getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(Integer numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public Integer getPuesto() {
        return puesto;
    }

    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    public List<Puesto> getListaPuestos() {
        listaPuestos = reclutamientoFacade.getPuestosByEmpresa(1);
        return listaPuestos;
    }

    public void setListaPuestos(List<Puesto> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public String getEstadoConcurso() {
        return estadoConcurso;
    }

    public void setEstadoConcurso(String estadoConcurso) {
        this.estadoConcurso = estadoConcurso;
    }

    public List<EstadoConcurso> getListaEstadoConcurso() {
        listaEstadoConcurso = reclutamientoFacade.getEstadoConcursosByEmpresa(1);
        return listaEstadoConcurso;
    }

    public void setListaEstadoConcurso(List<EstadoConcurso> listaEstadoConcurso) {
        this.listaEstadoConcurso = listaEstadoConcurso;
    }

    public String guardar$action() {
        isError = Boolean.FALSE;
        validaCampos$action();
        if (isError) {
            return null;
        }

        Concurso nuevoConcurso = new Concurso();
        ConcursoPK pk = new ConcursoPK();
        pk.setCodCia(1);
        pk.setCodConcurso(reclutamientoFacade.getMaxConcurso(1));
        nuevoConcurso.setConcursoPK(pk);
        nuevoConcurso.setNombre(nombreConcurso);
        nuevoConcurso.setFechaInicial(fechaInicial);
        nuevoConcurso.setFechaFinal(fechaFinal);
        nuevoConcurso.setNumeroPlazas(numeroPlazas);
        nuevoConcurso.setPuesto(reclutamientoFacade.findPuestoById(new PuestoPK(1, puesto)));
        nuevoConcurso.setEstadoConcurso(reclutamientoFacade.findEstadoConcursoById(new EstadoConcursoPK(1, estadoConcurso)));

        try {
            reclutamientoFacade.guardarConcurso(nuevoConcurso);
            limpiarCampos();
        } catch (Exception e) {
        }

        return null;
    }

    public void validaCampos$action() {
        if (!validaFechas(fechaInicial, fechaFinal)) {
            addMessage("Mantenimiento de Concursos", "Los rangos de fecha ingresados no son consistentes.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
        }
    }

    private void editar$action() {
    }

    private void eliminar$action() {
    }

    private void consultar$action() {
    }

    @Override
    protected void limpiarCampos() {
        setNombreConcurso(null);
        setFechaInicial(null);
        setFechaFinal(null);
        setNumeroPlazas(null);
        setPuesto(null);
        setEstadoConcurso(null);
        getSessionBeanREC().setConcursoSeleccionado(null);
    }
}
