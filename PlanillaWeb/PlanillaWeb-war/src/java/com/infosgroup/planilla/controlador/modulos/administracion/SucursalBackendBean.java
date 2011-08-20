/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.controlador.sessionbean.SessionBeanADM;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.entidades.SucursalPK;
import com.infosgroup.planilla.modelo.facades.SucursalFacade;
import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "administracion$sucursalBackendBean")
@ViewScoped
public class SucursalBackendBean extends JSFUtil implements Serializable {

    @EJB
    private SucursalFacade sucursalFacade;
    private List<Sucursal> listaSucursales;
    private Integer sucursal;
    private String nombre;
    private Sucursal sucursalSeleccionada;

    public SucursalBackendBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public List<Sucursal> getListaSucursales() {
        return sucursalFacade.findByCompania(getSessionBeanADM().getCompania());
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public Sucursal getSucursalSeleccionada() {
        return sucursalSeleccionada;
    }

    public void setSucursalSeleccionada(Sucursal sucursalSeleccionada) {
        this.sucursalSeleccionada = sucursalSeleccionada;
    }

    /* Acciones */
    public String action_guardar() {

        Sucursal nuevaSucursal = new Sucursal();
        SucursalPK pk = new SucursalPK();

        if (sucursal == null) {
            addErrorMessage("Crear Sucursal", "El Código de Sucursal es un campo obligatorio.");
            return null;
        }

        if (nombre == null || nombre.length() <= 0) {
            addErrorMessage("Crear Sucursal", "El Nombre de Sucursal es un campo obligatorio.");
            return null;
        }

        pk.setIdCompania(getSessionBeanADM().getCompania().getIdCompania());
        pk.setIdSucursal(sucursal);
        /*
        if (sucursalFacade.find(pk) != null) {
        addErrorMessage("Crear Sucursal", "El codigo Ingresado ya esta siendo utilizado por otra Sucursal.");
        return null;
        }
         */
        nuevaSucursal.setSucursalPK(pk);
        nuevaSucursal.setNomSucursal(nombre);

        try {
            sucursalFacade.edit(nuevaSucursal);
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
            sucursalFacade.remove(sucursalSeleccionada);
            addInfoMessage("Crear Sucursal", "Datos Eliminados.");
            limpiarCampos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static SessionBeanADM getSessionBeanADM() {
        return (SessionBeanADM) getBean("SessionBeanADM");
    }

    public void onRowSelect(SelectEvent event) {
        Sucursal s = (Sucursal) event.getObject();
        setSucursalSeleccionada(s);
        setSucursal(getSucursalSeleccionada().getSucursalPK().getIdSucursal());
        setNombre(getSucursalSeleccionada().getNomSucursal());
    }

    public String action_editar() {
        setSucursal(getSucursalSeleccionada().getSucursalPK().getIdSucursal());
        setNombre(getSucursalSeleccionada().getNomSucursal());
        return null;
    }

    @Override
    public void limpiarCampos() {
        setSucursal(null);
        setNombre(null);
        setSucursalSeleccionada(null);
    }
}