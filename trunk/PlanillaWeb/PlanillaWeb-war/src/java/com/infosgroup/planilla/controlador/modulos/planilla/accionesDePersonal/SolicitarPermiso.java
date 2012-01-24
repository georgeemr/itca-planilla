/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PlanillaPK;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "accionesPersonal$solicitarPermiso")
@ViewScoped
public class SolicitarPermiso extends AbstractJSFPage implements Serializable, SolicitudDePersonal {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    @ManagedProperty(value = "#{planilla$accionesPersonal}")
    private AccionesPersonalBackendBean encabezadoSolicitud;
    private Date fechaInicial;
    private Date fechaFinal;
    private Long tipoPlanilla;
    private String planilla;
    private Long empresa;
    private Planilla planillaSeleccionada;
    private String afectaPlanilla;

    public SolicitarPermiso() {
        empresa = empresa = getSessionBeanADM().getCompania().getIdCompania();
    }

    /* Acciones */
    public String guardarSolicitud$action() {

        if (!validarSolicitud()) {
            return null;
        }

        TipoAccion tipoAccionSeleccionada = planillaSessionBean.buscarTipoAccion(empresa, getEncabezadoSolicitud().getTipoAccion());
        planillaSeleccionada = planillaSessionBean.findPlanillaById(new PlanillaPK(planilla));

        planillaSessionBean.guardarSolVacaciones$action(empresa,
                getSessionBeanEMP().getEmpleadoSesion(),
                tipoAccionSeleccionada,
                getEncabezadoSolicitud().getObservacion(),
                fechaInicial,
                fechaFinal,
                afectaPlanilla,
                planillaSeleccionada);
        addMessage("Acciones de Personal", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
        limpiarCampos();
        getEncabezadoSolicitud().setListaSolicitudes(planillaSessionBean.listarAccionporTipo(empresa, getEncabezadoSolicitud().getTipoAccion()));

        return null;
    }

    /* Getter & Setter */
    public void setEncabezadoSolicitud(AccionesPersonalBackendBean encabezadoSolicitud) {
        this.encabezadoSolicitud = encabezadoSolicitud;
    }

    @Override
    public AccionesPersonalBackendBean getEncabezadoSolicitud() {
        return encabezadoSolicitud;
    }

    /* - */
    @Override
    protected void limpiarCampos() {
        fechaInicial = null;
        fechaFinal = null;
        tipoPlanilla = null;
        planilla = null;
        empresa = null;
        planillaSeleccionada = null;
        afectaPlanilla = null;
    }

    @Override
    public void guardarSolicitud(AccionPersonal accionPersonal) {
        throw new UnsupportedOperationException("No soportado aun.");
    }

    @Override
    public boolean validarSolicitud() {
        Boolean error = Boolean.TRUE;
        if (encabezadoSolicitud.getTipoAccion() == null) {
            addMessage("Acciones de Personal", "Tipo de acción es un campo requerido", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicial == null) {
            addMessage("Acciones de Personal", "Fecha inicio es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaFinal == null) {
            addMessage("Acciones de Personal", "Fecha final es un campo requerido.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (fechaInicial != null || fechaFinal != null) {
            if (!validaFechas(fechaInicial, fechaFinal)) {
                addMessage("Acciones de Personal", "Los datos de Fecha inicia y Fecha fin no son consistentes.", TipoMensaje.ERROR);
                error = Boolean.FALSE;
            }
        }

        if (tipoPlanilla == null) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (planilla == null) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        if (getSessionBeanEMP().getEmpleadoSesion().getPuestoEmpleadoList() == null || getSessionBeanEMP().getEmpleadoSesion().getPuestoEmpleadoList().isEmpty()) {
            addMessage("Acciones de Personal", "Usted no tiene ningún puesto asignado.", TipoMensaje.ERROR);
            error = Boolean.FALSE;
        }

        return error;
    }
}
