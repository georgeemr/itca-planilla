/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Puestos;
import com.infosgroup.planilla.modelo.entidades.PuestosPK;
import com.infosgroup.planilla.modelo.entidades.TipoPuesto;
import com.infosgroup.planilla.modelo.facades.PuestoFacade;
import com.infosgroup.planilla.modelo.facades.TipoPuestoFacade;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
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
public class PuestoBackingBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PuestoFacade puestoFacade;
    @EJB
    private TipoPuestoFacade tipoPuestoFacade;
    private List<TipoPuesto> listaTipoPuesto;
    private List<Puestos> listaPuesto;
    private Puestos puestoSeleccionado;
    private Short codigoPuesto;
    private Integer codigoTipoPuesto;
    private String nombrePuesto;

    public PuestoBackingBean() {
    }

    public Short getCodigoPuesto() {
        return codigoPuesto;
    }

    public void setCodigoPuesto(Short codigoPuesto) {
        this.codigoPuesto = codigoPuesto;
    }

    public List<Puestos> getListaPuesto() {
        return puestoFacade.findPuestoByEmpresa(getSessionBeanADM().getCompania());
    }

    public void setListaPuesto(List<Puestos> listaPuesto) {
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

    public Puestos getPuestoSeleccionado() {
        return puestoSeleccionado;
    }

    public void setPuestoSeleccionado(Puestos puestoSeleccionado) {
        this.puestoSeleccionado = puestoSeleccionado;
    }

    public String onRowSelect() {
        setCodigoPuesto(getPuestoSeleccionado().getPuestosPK().getCodPuesto());
        setNombrePuesto(getPuestoSeleccionado().getNomPuesto());

        return null;
    }

    /* Acciones */
    public String action_guardar() {

        Puestos nuevoPuesto = new Puestos();
        PuestosPK pk = new PuestosPK();

        if (codigoPuesto == null) {
            addMessage("Crear Puesto", "El Código de Puesto es un campo obligatorio.", TipoMensaje.ERROR);
            return null;
        }

        if (nombrePuesto == null || nombrePuesto.length() <= 0) {
            addMessage("Crear Puesto", "El Nombre de Puesto es un campo obligatorio.", TipoMensaje.ERROR);
            return null;
        }

        if (codigoTipoPuesto == null ) {
            addMessage("Crear Puesto", "El Codigo de Tipo de Puesto es un campo obligatorio.", TipoMensaje.ERROR);
            return null;
        }

        pk.setCodPuesto(codigoPuesto);
        
        /*
        if (sucursalFacade.find(pk) != null) {
        addErrorMessage("Crear Sucursal", "El codigo Ingresado ya esta siendo utilizado por otra Sucursal.");
        return null;
        }
         */
        nuevoPuesto.setPuestosPK(pk);
        nuevoPuesto.setNomPuesto(nombrePuesto);

        try {
            puestoFacade.edit(nuevoPuesto);
            addMessage("Crear Sucursal", "Datos Guardados.", TipoMensaje.ERROR);
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
            addMessage("Crear Puesto", "Datos Eliminados.", TipoMensaje.ERROR);
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