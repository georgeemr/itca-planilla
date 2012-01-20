/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.facades.CompaniaFacade;
import com.infosgroup.planilla.view.AbstractJSFPage;
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
@ManagedBean(name = "administracion$companias")
@ViewScoped
public class CompaniasBackendBean extends AbstractJSFPage implements Serializable {

    /** Creates a new instance of CompaniasBackendBean */
    public CompaniasBackendBean() {
    }
// ===================================================================================================
    @EJB
    private CompaniaFacade companiaFacade;
// ===================================================================================================
    private Long idCompania;

    public Long getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(Long idCompania) {
        this.idCompania = idCompania;
    }
    private String nomCompania;

    public String getNomCompania() {
        return nomCompania;
    }

    public void setNomCompania(String nomCompania) {
        this.nomCompania = nomCompania;
    }
    private String detCompania;

    public String getDetCompania() {
        return detCompania;
    }

    public void setDetCompania(String detCompania) {
        this.detCompania = detCompania;
    }
    private String razonSocial;

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
// ===================================================================================================
    private List<Compania> listaCompanias;

    public List<Compania> getListaCompanias() {
        listaCompanias = companiaFacade.findAll();
        return listaCompanias;
    }

    public void setListaCompanias(List<Compania> listaCompanias) {
        this.listaCompanias = listaCompanias;
    }
// =============================================================================================
    private EstadoAccion estado = EstadoAccion.CREANDO;
// =============================================================================================

    public String guardar_action() {
        Boolean hayError = false;

        if ((nomCompania == null) || nomCompania.trim().isEmpty()) {
            hayError = Boolean.TRUE;
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "Ingrese el nombre de la compañia");
        }

        if (hayError) {
            return null;
        }

        try {
                if (estado == EstadoAccion.CREANDO) {
                Compania c = new Compania();
               
                c.setIdCompania(companiaFacade.max() + 1L);
                c.setNomCompania(nomCompania);
                c.setDetCompania(detCompania);
                c.setRazonSocial(razonSocial);
                companiaFacade.create(c);
                companiaSeleccionada = null;
                limpiarCampos();
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Compañia guardada exitosamente");
            } else if (estado == EstadoAccion.MODIFICANDO) {
                if (companiaSeleccionada == null) {
                    mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se ha seleccionado la compañia");
                    return null;
                }
                Compania c = companiaFacade.find(companiaSeleccionada.getIdCompania());
                if (c == null) {
                    mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se encontró la compañia");
                    return null;
                }
               
                c.setNomCompania(nomCompania);
                c.setDetCompania(detCompania);
                c.setRazonSocial(razonSocial);
                companiaFacade.edit(c);
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Datos de la compañia modificados");
                companiaSeleccionada = null;
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
        if (companiaSeleccionada == null) {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se ha seleccionado la compañia");
            return null;
        }
        estado = EstadoAccion.MODIFICANDO;
        idCompania = companiaSeleccionada.getIdCompania();
        nomCompania = companiaSeleccionada.getNomCompania();
        detCompania = companiaSeleccionada.getDetCompania();
        razonSocial = companiaSeleccionada.getRazonSocial();
        return null;
    }

// =============================================================================================
    public String eliminar_action() {
        if (companiaSeleccionada == null) {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "No se ha seleccionado la compañia");
            return null;
        }
        Compania c = companiaFacade.find(companiaSeleccionada.getIdCompania());
        if (c == null) {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "Seleccione la compañia");
            return null;
        }
        companiaFacade.remove(c);
        companiaSeleccionada = null;
        estado = EstadoAccion.CREANDO;
        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Compañia eliminada");
        return null;
    }
// =============================================================================================
    private Compania companiaSeleccionada;

    public Compania getCompaniaSeleccionada() {
        return companiaSeleccionada;
    }

    public void setCompaniaSeleccionada(Compania companiaSeleccionada) {
        this.companiaSeleccionada = companiaSeleccionada;
    }

    @Override
    protected void limpiarCampos() {
        idCompania = null;
        nomCompania = null;
        detCompania = null;
        razonSocial = null;
    }
}
