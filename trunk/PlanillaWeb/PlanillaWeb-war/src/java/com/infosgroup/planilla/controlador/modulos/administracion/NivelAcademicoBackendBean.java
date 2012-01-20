/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.NivelAcademico;
import com.infosgroup.planilla.modelo.facades.NivelAcademicoFacade;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

/**
 *
 * @author root
 */
@ManagedBean(name = "administracion$nivelAcademico")
@ViewScoped
public class NivelAcademicoBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private NivelAcademicoFacade nivelAcademicoFacade;
    private List<NivelAcademico> listaNivelesAcademicos;
    private String nomNivelAcademico;
    private String detNivelAcademico;
    private NivelAcademico nivelAcademicoSeleccionado;

    public String getNomNivelAcademico() {
        return nomNivelAcademico;
    }

    public void setNomNivelAcademico(String nomNivelAcademico) {
        this.nomNivelAcademico = nomNivelAcademico;
    }

    public String getDetNivelAcademico() {
        return detNivelAcademico;
    }

    public void setDetNivelAcademico(String detNivelAcademico) {
        this.detNivelAcademico = detNivelAcademico;
    }

    /** Creates a new instance of NivelAcademicoBackendBean */
    public NivelAcademicoBackendBean() {
    }

    public List<NivelAcademico> getListaNivelesAcademicos() {
        listaNivelesAcademicos = nivelAcademicoFacade.findAll();
        return listaNivelesAcademicos;
    }

    public void setListaNivelesAcademicos(List<NivelAcademico> listaNivelesAcademicos) {
        this.listaNivelesAcademicos = listaNivelesAcademicos;
    }

    public NivelAcademico getNivelAcademicoSeleccionado() {
        return nivelAcademicoSeleccionado;
    }

    public void setNivelAcademicoSeleccionado(NivelAcademico nivelAcademicoSeleccionado) {
        this.nivelAcademicoSeleccionado = nivelAcademicoSeleccionado;
    }
    // =============================================================================================
    private EstadoAccion estado = EstadoAccion.CREANDO;
    // =============================================================================================

    @Override
    protected void limpiarCampos() {
        nomNivelAcademico = null;
        detNivelAcademico = null;
    }

    public String guardar_action() {
        Boolean hayError = false;
        if ((nomNivelAcademico == null) || nomNivelAcademico.trim().isEmpty()) {
            hayError = Boolean.TRUE;
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "Ingrese el nombre del nivel academico");
        }
        if (hayError) {
            return null;
        }
        try {
            if (estado == EstadoAccion.CREANDO) {
                NivelAcademico n = new NivelAcademico();
                n.setIdNivelAcademico(nivelAcademicoFacade.max() + 1L);
                n.setNomNivelAcademico(nomNivelAcademico);
                n.setDetNivelAcademico(detNivelAcademico);
                nivelAcademicoFacade.create(n);
                nivelAcademicoSeleccionado = null;
                limpiarCampos();
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Nivel academico guardado exitosamente");
            } else if (estado == EstadoAccion.MODIFICANDO) {
                if (nivelAcademicoSeleccionado == null) {
                    mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se ha seleccionado el nivel academico");
                    return null;
                }
                NivelAcademico n = nivelAcademicoFacade.find(nivelAcademicoSeleccionado.getIdNivelAcademico());
                if (n == null) {
                    mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se encontró el nivel academico");
                    return null;
                }
                n.setNomNivelAcademico(nomNivelAcademico);
                n.setDetNivelAcademico(detNivelAcademico);
                nivelAcademicoFacade.edit(n);
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Datos del nivel academico modificados");
                nivelAcademicoSeleccionado = null;
                limpiarCampos();
            }
        } catch (Exception excpt) {
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, excpt.toString());
        }
        estado = EstadoAccion.CREANDO;
        return null;
    }

    public String cancelar_action() {
        estado = EstadoAccion.CREANDO;
        limpiarCampos();
        return null;
    }

    public String modificar_action() {
        if (nivelAcademicoSeleccionado == null) {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se ha seleccionado el nivel academico");
            return null;
        }
        estado = EstadoAccion.MODIFICANDO;
        nomNivelAcademico = nivelAcademicoSeleccionado.getNomNivelAcademico();
        detNivelAcademico = nivelAcademicoSeleccionado.getDetNivelAcademico();
        return null;
    }

    public String eliminar_action() {
        if (nivelAcademicoSeleccionado == null) {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se ha seleccionado el nivel academico");
            return null;
        }
        NivelAcademico n = nivelAcademicoFacade.find(nivelAcademicoSeleccionado.getIdNivelAcademico());
        if (n == null) {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "Seleccione el nivel nivel academico");
            return null;
        }
        nivelAcademicoFacade.remove(n);
        nivelAcademicoSeleccionado = null;
        estado = EstadoAccion.CREANDO;
        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Nivel academico eliminada");
        return null;
    }
}
