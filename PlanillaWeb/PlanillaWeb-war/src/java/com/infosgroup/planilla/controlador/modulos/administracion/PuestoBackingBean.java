/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Puesto;
import com.infosgroup.planilla.modelo.entidades.PuestoPK;
import com.infosgroup.planilla.modelo.entidades.TipoPuesto;
import com.infosgroup.planilla.modelo.facades.PuestoFacade;
import com.infosgroup.planilla.modelo.facades.TipoPuestoFacade;
import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "administracionPuestoBackingBean")
@ViewScoped
public class PuestoBackingBean extends JSFUtil implements Serializable {

    @EJB
    private PuestoFacade puestoFacade;
    @EJB
    private TipoPuestoFacade tipoPuestoFacade;
    private List<TipoPuesto> listaTipoPuesto;
    private List<Puesto> listaPuesto;
    private Puesto puestoSeleccionado;
    private Integer codigoPuesto;
    private Integer codigoTipoPuesto;
    private String nombrePuesto;

    /** Creates a new instance of PuestoBackingBean */
    public PuestoBackingBean() {
    }

    public Integer getCodigoPuesto() {
        return codigoPuesto;
    }

    public void setCodigoPuesto(Integer codigoPuesto) {
        this.codigoPuesto = codigoPuesto;
    }

    public List<Puesto> getListaPuesto() {
        return puestoFacade.findAll();
    }

    public void setListaPuesto(List<Puesto> listaPuesto) {
        this.listaPuesto = listaPuesto;
    }

    public List<TipoPuesto> getListaTipoPuesto() {
        return tipoPuestoFacade.findAll();
    }

    public void setListaTipoPuesto(List<TipoPuesto> listaTipoPuesto) {
        this.listaTipoPuesto = listaTipoPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public Integer getCodigoTipoPuesto() {
        return codigoTipoPuesto;
    }

    public void setCodigoTipoPuesto(Integer codigoTipoPuesto) {
        this.codigoTipoPuesto = codigoTipoPuesto;
    }

    public Puesto getPuestoSeleccionado() {
        return puestoSeleccionado;
    }

    public void setPuestoSeleccionado(Puesto puestoSeleccionado) {
        this.puestoSeleccionado = puestoSeleccionado;
    }

    public String onRowSelect() {
        setCodigoPuesto(getPuestoSeleccionado().getPuestoPK().getIdPuesto());
        setNombrePuesto(getPuestoSeleccionado().getNomPuesto());
        setCodigoPuesto(getPuestoSeleccionado().getPuestoPK().getIdTipoPuesto());
        return null;
    }

    /* Acciones */
    public String action_guardar() {

        Puesto nuevoPuesto = new Puesto();
        PuestoPK pk = new PuestoPK();

        if (codigoPuesto == null) {
            addErrorMessage("Crear Puesto", "El Código de Puesto es un campo obligatorio.");
            return null;
        }

        if (nombrePuesto == null || nombrePuesto.length() <= 0) {
            addErrorMessage("Crear Puesto", "El Nombre de Puesto es un campo obligatorio.");
            return null;
        }

        if (codigoTipoPuesto == null ) {
            addErrorMessage("Crear Puesto", "El Codigo de Tipo de Puesto es un campo obligatorio.");
            return null;
        }

        pk.setIdPuesto(codigoPuesto);
        pk.setIdTipoPuesto(codigoTipoPuesto);
        /*
        if (sucursalFacade.find(pk) != null) {
        addErrorMessage("Crear Sucursal", "El codigo Ingresado ya esta siendo utilizado por otra Sucursal.");
        return null;
        }
         */
        nuevoPuesto.setPuestoPK(pk);
        nuevoPuesto.setNomPuesto(nombrePuesto);

        try {
            puestoFacade.edit(nuevoPuesto);
            addInfoMessage("Crear Sucursal", "Datos Guardados.");
            limpiarCampos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String action_cancelar() {
        limpiarCampos();
        return null;
    }

    public String action_eliminar() {

        try {
            puestoFacade.remove(puestoSeleccionado);
            addInfoMessage("Crear Puesto", "Datos Eliminados.");
            limpiarCampos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void limpiarCampos() {
        setCodigoPuesto(null);
        setNombrePuesto(null);
        setCodigoTipoPuesto(null);
        setPuestoSeleccionado(null);
    }
}
