/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.MovDp;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompletePlanillaConverter;
import com.infosgroup.planilla.view.AutocompleteProgramacionPlaConverter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "planilla$informacionPagos")
@ViewScoped
public class InformacionPagosBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Short tipoPlanilla;
    private List<TiposPlanilla> listaTipos;
    private ProgramacionPla proPlaSeleccionada;
    private Planilla planillaSeleccionada;
    private AutocompleteProgramacionPlaConverter programacionPlaConverter;
    private AutocompletePlanillaConverter planillaConverter;
    private List<Planilla> listaPlanillas;
    private List<MovDp> listaPrestaciones;
    private List<MovDp> listaDeducciones;

    @PostConstruct
    public void init() {
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

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

    public Planilla getPlanillaSeleccionada() {
        return planillaSeleccionada;
    }

    public void setPlanillaSeleccionada(Planilla planillaSeleccionada) {
        this.planillaSeleccionada = planillaSeleccionada;
    }

    public AutocompleteProgramacionPlaConverter getProgramacionPlaConverter() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(planillaSessionBean.getProgramacionPlaByTipo(getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla));
        } else {
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(new ArrayList<ProgramacionPla>());
        }
        return programacionPlaConverter;
    }

    public AutocompletePlanillaConverter getPlanillaConverter() {
        if (proPlaSeleccionada != null) {
            planillaConverter = new AutocompletePlanillaConverter(planillaSessionBean.findByProgramacionPla(proPlaSeleccionada));
        } else {
            planillaConverter = new AutocompletePlanillaConverter(new ArrayList<Planilla>());
        }
        return planillaConverter;
    }

    public void setPlanillaConverter(AutocompletePlanillaConverter planillaConverter) {
        this.planillaConverter = planillaConverter;
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

    public List<Planilla> completePlanillaEmpleado(String query) {
        List<Planilla> suggestions = new ArrayList<Planilla>();
        for (Planilla p : planillaConverter.listaPlanilla) {
            if (p.getEmpleados().getNombreCompleto().contains(query)) {
                suggestions.add(p);
            }
        }
        return suggestions;
    }

    public List<Planilla> getListaPlanillas() {
        return listaPlanillas;
    }

    public void setListaPlanillas(List<Planilla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public void setProgramacionPlaConverter(AutocompleteProgramacionPlaConverter programacionPlaConverter) {
        this.programacionPlaConverter = programacionPlaConverter;
    }

    public List<MovDp> getListaDeducciones() {
        return listaDeducciones;
    }

    public void setListaDeducciones(List<MovDp> listaDeducciones) {
        this.listaDeducciones = listaDeducciones;
    }

    public List<MovDp> getListaPrestaciones() {
        return listaPrestaciones;
    }

    public void setListaPrestaciones(List<MovDp> listaPrestaciones) {
        this.listaPrestaciones = listaPrestaciones;
    }

    @Override
    protected void limpiarCampos() {
        setListaDeducciones(new ArrayList<MovDp>());
        setListaPrestaciones(new ArrayList<MovDp>());
        setProPlaSeleccionada(null);
        setPlanillaSeleccionada(null);
    }

    public void handleSelectEmpleado(SelectEvent event) {
        listaDeducciones = planillaSessionBean.findDeduccionesPresta(planillaSeleccionada, "R");
        listaPrestaciones = planillaSessionBean.findDeduccionesPresta(planillaSeleccionada, "S");
    }

    public void seleccionarTipoPlanilla(AjaxBehaviorEvent event) {
        limpiarCampos();
    }
}
