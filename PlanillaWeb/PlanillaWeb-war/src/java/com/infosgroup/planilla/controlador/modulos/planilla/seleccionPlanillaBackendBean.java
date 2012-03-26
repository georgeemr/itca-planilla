/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompleteProgramacionPlaConverter;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "planilla$seleccionPlanilla")
@ViewScoped
public class seleccionPlanillaBackendBean extends AbstractJSFPage implements Serializable{

    @Override
    protected void limpiarCampos() {
        setProPlaSeleccionada(null);
    }
    
    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Short tipoPlanilla;
    private List<TiposPlanilla> listaTipos;
    private ProgramacionPla proPlaSeleccionada;
    private AutocompleteProgramacionPlaConverter programacionPlaConverter;

    public List<TiposPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos(getSessionBeanADM().getCompania());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public ProgramacionPla getProPlaSeleccionada() {
        return proPlaSeleccionada;
    }

    public void setProPlaSeleccionada(ProgramacionPla proPlaSeleccionada) {
        this.proPlaSeleccionada = proPlaSeleccionada;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public AutocompleteProgramacionPlaConverter getProgramacionPlaConverter() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(planillaSessionBean.getProgramacionPlaByTipo(getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla));
        } else {
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(new ArrayList<ProgramacionPla>());
        }
        return programacionPlaConverter;
    }

    public void setProgramacionPlaConverter(AutocompleteProgramacionPlaConverter programacionPlaConverter) {
        this.programacionPlaConverter = programacionPlaConverter;
    }
    
    public List<ProgramacionPla> completeProgramacionPla(String query) {
        List<ProgramacionPla> suggestions = new ArrayList<ProgramacionPla>();
        for (ProgramacionPla p : programacionPlaConverter.listaProgramacionPla) {
            if (p.getStringProgramacionPla().startsWith(query)) {
                suggestions.add(p);
            }
        }
        return suggestions;
    }
    
    public void seleccionarTipoPlanilla(AjaxBehaviorEvent event) {
        limpiarCampos();
    }
    
    public void cargarPlanilla$action(){
        getSessionBeanPLA().setProgramacionPlaSeleccionado(proPlaSeleccionada);
        if(getSessionBeanPLA().getProgramacionPlaSeleccionado() != null){
            addMessage("Cargar Planilla", "La planilla ha sido cargada en el sistema", TipoMensaje.INFORMACION);
        }
    }
    
}
