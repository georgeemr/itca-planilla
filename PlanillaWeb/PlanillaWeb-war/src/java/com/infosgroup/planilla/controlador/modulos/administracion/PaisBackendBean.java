/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Pais;
import com.infosgroup.planilla.modelo.facades.PaisFacade;
import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "administracion$pais")
@ViewScoped
public class PaisBackendBean extends JSFUtil implements Serializable {

    /** Creates a new instance of PaisBackendBean */
    public PaisBackendBean() {
    }
    @EJB
    private PaisFacade paisFacade;
    private EstadoAccion estado = EstadoAccion.CREANDO;
    private String nomPais;
    private String detPais;
    private List<Pais> listaPaises;
    private Pais paisSeleccionado;

    public String getDetPais() {
        return detPais;
    }

    public void setDetPais(String detPais) {
        this.detPais = detPais;
    }

    public List<Pais> getListaPaises() {
        listaPaises = paisFacade.findAll();
        return listaPaises;
    }

    public void setListaPaises(List<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public Pais getPaisSeleccionado() {
        return paisSeleccionado;
    }

    public void setPaisSeleccionado(Pais paisSeleccionado) {
        this.paisSeleccionado = paisSeleccionado;
    }

    public String guardar_action() {
        Boolean hayError = false;

        if ((nomPais == null) || nomPais.trim().isEmpty()) {
            hayError = Boolean.TRUE;
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "Ingrese el nombre de la compañia");
        }

        if (hayError) {
            return null;
        }

        try {
            if (estado == EstadoAccion.CREANDO) {
                Pais p = new Pais();

                p.setIdPais(paisFacade.max() + 1);
                p.setNomPais(nomPais);
                p.setDetPais(detPais);

                paisFacade.create(p);
                paisSeleccionado = null;
                limpiarCampos();
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Compañia guardada exitosamente");
            } else if (estado == EstadoAccion.MODIFICANDO) {
                if (paisSeleccionado == null) {
                    mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se ha seleccionado la compañia");
                    return null;
                }
                Pais p = paisFacade.find(paisSeleccionado.getIdPais());
                if (p == null) {
                    mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se encontró la compañia");
                    return null;
                }

                p.setNomPais(nomPais);
                p.setDetPais(detPais);

                paisFacade.edit(p);
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Datos de la compañia modificados");
                paisSeleccionado = null;
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
        if (paisSeleccionado == null) {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se ha seleccionado la compañia");
            return null;
        }
        estado = EstadoAccion.MODIFICANDO;

        nomPais = paisSeleccionado.getNomPais();
        detPais = paisSeleccionado.getDetPais();

        return null;
    }

// =============================================================================================
    public String eliminar_action() {
        if (paisSeleccionado == null) {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se ha seleccionado la compañia");
            return null;
        }
        Pais p = paisFacade.find(paisSeleccionado.getIdPais());
        if (p == null) {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "Seleccione la compañia");
            return null;
        }
        paisFacade.remove(p);
        paisSeleccionado = null;
        estado = EstadoAccion.CREANDO;
        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Compañia eliminada");
        return null;
    }
// =============================================================================================

    @Override
    protected void limpiarCampos() {
        nomPais = null;
        detPais = null;
    }
}
