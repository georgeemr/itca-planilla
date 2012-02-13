/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Agencias;
import com.infosgroup.planilla.modelo.entidades.AgenciasPK;
import com.infosgroup.planilla.modelo.facades.AgenciasFacade;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
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
public class AgenciasBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private AgenciasFacade sucursalFacade;
    private List<Agencias> listaSucursales;
    private Short sucursal;
    private String nombre;
    private Agencias sucursalSeleccionada;

    public AgenciasBackendBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getSucursal() {
        return sucursal;
    }

    public void setSucursal(Short sucursal) {
        this.sucursal = sucursal;
    }

    public List<Agencias> getListaSucursales() {
        listaSucursales = sucursalFacade.findByCompania(getSessionBeanADM().getCompania());
        return listaSucursales;
    }

    public void setListaSucursales(List<Agencias> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public Agencias getSucursalSeleccionada() {
        return sucursalSeleccionada;
    }

    public void setSucursalSeleccionada(Agencias sucursalSeleccionada) {
        this.sucursalSeleccionada = sucursalSeleccionada;
    }

    /* Acciones */
    public String action_guardar() {

        Agencias nuevaSucursal = new Agencias();
        AgenciasPK pk = new AgenciasPK();

        if (sucursal == null) {
            addMessage("Crear Sucursal", "El Código de Sucursal es un campo obligatorio.", TipoMensaje.ERROR);
            return null;
        }

        if (nombre == null || nombre.length() <= 0) {
            addMessage("Crear Sucursal", "El Nombre de Sucursal es un campo obligatorio.", TipoMensaje.ERROR);
            return null;
        }

        pk.setCodCia(getSessionBeanADM().getCompania().getCodCia());
        pk.setCodAgencia(sucursal);
        nuevaSucursal.setAgenciasPK(pk);
        nuevaSucursal.setNomAgencia(nombre);

        try {
            sucursalFacade.edit(nuevaSucursal);
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
            sucursalFacade.remove(sucursalSeleccionada);
            addMessage("Crear Sucursal", "Datos Eliminados.", TipoMensaje.ERROR);
            limpiarCampos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void onRowSelect(SelectEvent event) {
        Agencias s = (Agencias) event.getObject();
        setSucursalSeleccionada(s);
        setSucursal(getSucursalSeleccionada().getAgenciasPK().getCodAgencia());
        setNombre(getSucursalSeleccionada().getNomAgencia());
    }

    public String onRowSelect() {
        setSucursal(getSucursalSeleccionada().getAgenciasPK().getCodAgencia());
        setNombre(getSucursalSeleccionada().getNomAgencia());
        return null;
    }

    public String action_editar() {
        setSucursal(getSucursalSeleccionada().getAgenciasPK().getCodAgencia());
        setNombre(getSucursalSeleccionada().getNomAgencia());
        return null;
    }

    @Override
    public void limpiarCampos() {
        setSucursal(null);
        setNombre(null);
        setSucursalSeleccionada(null);
    }
}