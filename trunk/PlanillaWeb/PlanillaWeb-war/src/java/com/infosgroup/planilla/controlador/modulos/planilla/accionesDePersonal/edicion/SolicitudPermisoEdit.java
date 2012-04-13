/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "solicitudPermisoEdit")
@ViewScoped
public class SolicitudPermisoEdit extends AbstractEditAccionPersonal implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<TiposPlanilla> listaTipos;
    private List<ProgramacionPla> listaPlanillas;
    
    public SolicitudPermisoEdit() {
    }
    
    public List<TiposPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos(getSessionBeanADM().getCompania());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (getSessionBeanPLA().getAccionSeleccionada() != null && getSessionBeanPLA().getAccionSeleccionada().getCodTipopla() != -1) {
            listaPlanillas =planillaSessionBean.getProgramacionPlaByTipo(getSessionBeanADM().getCompania().getCodCia(), getSessionBeanPLA().getAccionSeleccionada().getCodTipopla());
        }
        return listaPlanillas != null ? listaPlanillas : new ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }
    
    @Override
    protected void limpiarCampos() {
        getSessionBeanPLA().setAccionSeleccionada(null);
    }

    public void handleFechaInicial(DateSelectEvent event) {
        getSessionBeanPLA().getAccionSeleccionada().setFechaInicial(event.getDate());
        getSessionBeanPLA().getAccionSeleccionada().setDias(
        calculaDias(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial(), getSessionBeanPLA().getAccionSeleccionada().getFechaFinal()).shortValue());
    }

    public void handleFechaFinal(DateSelectEvent event) {
        getSessionBeanPLA().getAccionSeleccionada().setFechaFinal(event.getDate());
        getSessionBeanPLA().getAccionSeleccionada().setDias(
        calculaDias(getSessionBeanPLA().getAccionSeleccionada().getFechaInicial(), getSessionBeanPLA().getAccionSeleccionada().getFechaFinal()).shortValue());
    }
    
    public String guardarCambios() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null) return null;
        try {
            a.setAnio(new Short(a.getPlanillaToString().split(":")[1].toString()));
            a.setMes(new Short(a.getPlanillaToString().split(":")[2].toString()));
            a.setNumPlanilla(new Short(a.getPlanillaToString().split(":")[3].toString()));
            actualizarSolicitud(a);
            addMessage("Acciones de Personal", "Datos Guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Acciones de Personal", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.ERROR);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarSolicitud(AccionPersonal a) throws Exception {
        if (a == null) throw new Exception("No ha seleccionado ninguna solicitud.");
        try {
            planillaSessionBean.actualizarAccionPersonal(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
