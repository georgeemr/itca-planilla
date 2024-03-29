/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal.edicion;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public abstract class AbstractEditAccionPersonal extends AbstractJSFPage implements java.io.Serializable {

    public static final Logger looger = Logger.getLogger(AbstractEditAccionPersonal.class.getPackage().getName());
    private List<TiposPlanilla> listaTipos;
    private List<ProgramacionPla> listaPlanillas;
    private String planilla;
    private Short tipoPlanilla;
    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public List<TiposPlanilla> getListaTipos() {
        listaTipos = getPlanillaSessionBean().listarTipos(getEmpresa());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (getTipoPlanilla() != null && getTipoPlanilla() != -1) {
            listaPlanillas = getPlanillaSessionBean().getProgramacionPlaByTipo(getEmpresa().getCodCia(), getTipoPlanilla());
        }
        return listaPlanillas != null ? listaPlanillas : new ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }
    
    public String regresar() {
        limpiarCampos();
        return "./../accionesPersonal.xhtml?faces-redirect=true";
    }

    public void actualizarSolicitud(AccionPersonal a) throws Exception{
        if (a == null) throw new Exception("No ha seleccionado ninguna solicitud.");
        try {
            getPlanillaSessionBean().actualizarAccionPersonal(a);
        } catch (Exception e) {
            looger.log(Level.SEVERE, "Ha ocurrido el siguiente error al intentar Actualizar.", e);
        }
    }
    
    public abstract boolean validarSolicitud();
    protected abstract PlanillaSessionBean getPlanillaSessionBean();
    public abstract Cias getEmpresa();
    public abstract String guardarCambios();
    
}
