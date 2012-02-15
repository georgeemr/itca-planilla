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
@ManagedBean(name="aprobarSolicitud")
@ViewScoped
public class AprobarSolicitud extends AbstractJSFPage implements java.io.Serializable{
    
    @EJB
    private PlanillaSessionBean planillaSessionBean;
    public final long MILISEGUNDOS_POR_DIA = 24 * 60 * 60 * 1000;

    enum APRUEBA { JEFE, RECURSOS_HUMANOS };
    
    public AprobarSolicitud() {
    }
    
    public String aprobarSolicitudJefe() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (!validaDatos(a)) {
            return null;
        }
        try {
            planillaSessionBean.jefeEditaSolicitud(a, "A");
            addMessage("Editar Solicitud", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
            SolicitudPermiso.enviarCorreo(a, getManifiestoSolicitudPermiso(APRUEBA.JEFE, a));
        } catch (Exception e) {
            addMessage("Editar Solicitud", "Usted no esta autorizado para realizar esta acción", TipoMensaje.ERROR);
        }
        return null;
    }

    public String aprobarSolicitudRH() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (!validaDatos(a)) {
            return null;
        }
        try {
            planillaSessionBean.rrhhEditaSolicitud(a, "A");
            addMessage("Editar Solicitud", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
            SolicitudPermiso.enviarCorreo(a, getManifiestoSolicitudPermiso(APRUEBA.RECURSOS_HUMANOS, a));
        } catch (Exception e) {
            addMessage("Editar Solicitud", "Usted no esta autorizado para realizar esta acción", TipoMensaje.ERROR);
        }
        return null;
    }

    public String rechazarSolicitudRH() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        try {
            planillaSessionBean.rrhhEditaSolicitud(a, "R");
            addMessage("Editar Solicitud", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
            SolicitudPermiso.enviarCorreo(a, getManifiestoSolicitudPermiso(APRUEBA.RECURSOS_HUMANOS, a));
        } catch (Exception e) {
            addMessage("Editar Solicitud", "Usted no esta autorizado para realizar esta acción", TipoMensaje.ERROR);
        }
        return null;
    }

    public String rechazarSolicitudJefe() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        try {
            planillaSessionBean.jefeEditaSolicitud(a, "R");
            addMessage("Editar Solicitud", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
            SolicitudPermiso.enviarCorreo(a, getManifiestoSolicitudPermiso(APRUEBA.RECURSOS_HUMANOS, a));
        } catch (Exception e) {
            addMessage("Editar Solicitud", "Usted no esta autorizado para realizar esta acción", TipoMensaje.ERROR);
        }
        return null;
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

    public String getManifiestoSolicitudPermiso(APRUEBA eaprueba, AccionPersonal a) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Solicitud Procesada.\n\n");
        mensaje.append("\n\nFecha: ").append(a.getFecha());
        mensaje.append("Detalle:\n\n\n\n");
        mensaje.append("\n\nResultado: Solicitud ").append(a.getAccEstado());
        if (eaprueba.equals(APRUEBA.JEFE)) {
            mensaje.append("\n\nProcesado por: ").append(getSessionBeanEMP().getEmpleadoSesion().getNombreCompleto()).append(" ( Jefe Inmediato ) ");
        } else {
            mensaje.append("\n\nProcesado por: ").append(getSessionBeanEMP().getEmpleadoSesion().getNombreCompleto()).append(" ( Recursos Humanos ) ");
        }
        mensaje.append("\n\nAtte. \n\nDepartamento de Recursos Humanos ").append(getSessionBeanADM().getCompania().getNomComercial());
        return mensaje.toString();
    }
}
