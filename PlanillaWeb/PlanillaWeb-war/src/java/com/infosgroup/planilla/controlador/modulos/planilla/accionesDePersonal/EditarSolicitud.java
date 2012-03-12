/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "editarSolicitud")
@ViewScoped
public class EditarSolicitud extends AbstractJSFPage implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    public final long MILISEGUNDOS_POR_DIA = 24 * 60 * 60 * 1000;
    private boolean usuarioAutorizado = Boolean.FALSE;

    public EditarSolicitud() {
    }

    public boolean isUsuarioAutorizado() {
        usuarioAutorizado = Boolean.FALSE;
        if (getSessionBeanPLA().getAccionSeleccionada()!=null && getSessionBeanPLA().getAccionSeleccionada().getEmpleados() != null) {
            usuarioAutorizado = getSessionBeanEMP().getEmpleadoSesion().getEmpleadosPK().getCodEmp().equals(getSessionBeanPLA().getAccionSeleccionada().getEmpleados().getEmpleadosPK().getCodEmp());
        }
        return usuarioAutorizado;
    }

    public void setUsuarioAutorizado(boolean usuarioAutorizado) {
        this.usuarioAutorizado = usuarioAutorizado;
    }

    public boolean validaDatos(AccionPersonal a) {
        Boolean error = Boolean.TRUE;
        if (a == null) {
            addMessage("Editar Solicitud", "No ha seleccionado ninguna solicitud.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }
        if (!validaAccionPersonal(a.getFechaInicial(), a.getFechaFinal())) {
            error = Boolean.FALSE;
        }
        return error;
    }

    public String regresar() {
        limpiarCampos();
        return "./../accionesPersonal.xhtml?faces-redirect=true";
    }

    @Override
    protected void limpiarCampos() {
        getSessionBeanPLA().setAccionSeleccionada(null);
    }

    public void handleFechaFinal(DateSelectEvent event) {
        AccionPersonal ap = getSessionBeanPLA().getAccionSeleccionada();
        ap.setFechaFinal(event.getDate());
        if (ap.getFechaInicial() != null && ap.getFechaFinal() != null) {
            if (validaAccionPersonal(ap.getFechaInicial(), ap.getFechaFinal())) {
                ap.setDias(new Long((ap.getFechaFinal().getTime() - ap.getFechaInicial().getTime()) / MILISEGUNDOS_POR_DIA).shortValue());
                getSessionBeanPLA().setAccionSeleccionada(ap);
            }
        }
    }

    public boolean validaAccionPersonal(java.util.Date f1, java.util.Date f2) {
        Boolean error = Boolean.TRUE;
        if (f1 == null) {
            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }
        if (f2 == null) {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }
        if (f1 != null && f2 != null) {
            if (!validaFechas(f1, f2)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicia y Fecha fin no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }
        return error;
    }

    public String actualizarSolicitud() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if ( a==null )return null;
//        if (!validaDatos(a)) { return null; }
        try {
            planillaSessionBean.editarSolicitud(a);
            addMessage("Acciones de Personal", "Datos Guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Acciones de Personal", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.ERROR);
        }

        return null;
    }
}