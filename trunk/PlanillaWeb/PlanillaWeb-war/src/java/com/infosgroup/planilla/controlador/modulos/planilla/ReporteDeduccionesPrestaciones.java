/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompleteProgramacionPlaConverter;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "reporteDeduccionesPrestaciones")
@ViewScoped
public class ReporteDeduccionesPrestaciones extends AbstractJSFPage implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    @EJB
    private ReportesStatelessBean reportesStatelessBean;
    private List<TiposPlanilla> listaTipos;
    private Short tipoPlanilla;
    private Cias empresa;
    private ProgramacionPla proPlaSeleccionada;
    private AutocompleteProgramacionPlaConverter programacionPlaConverter;
    private String deducPresta;

    public ReporteDeduccionesPrestaciones() {
    }

    @PostConstruct
    public void _init() {
        setEmpresa(getSessionBeanADM().getCompania());
    }

    public Cias getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }

    public List<TiposPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos(getEmpresa());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public ProgramacionPla getProPlaSeleccionada() {
        return proPlaSeleccionada;
    }

    public void setProPlaSeleccionada(ProgramacionPla proPlaSeleccionada) {
        this.proPlaSeleccionada = proPlaSeleccionada;
    }

    public void seleccionarTipoPlanilla(AjaxBehaviorEvent event) {
        limpiarCampos();
    }

    public AutocompleteProgramacionPlaConverter getProgramacionPlaConverter() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(planillaSessionBean.getProgramacionPlaByTipo(getEmpresa().getCodCia(), tipoPlanilla));
        } else {
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(new ArrayList<ProgramacionPla>());
        }
        return programacionPlaConverter;
    }

    public void setProgramacionPlaConverter(AutocompleteProgramacionPlaConverter programacionPlaConverter) {
        this.programacionPlaConverter = programacionPlaConverter;
    }

    public String getDeducPresta() {
        return deducPresta;
    }

    public void setDeducPresta(String deducPresta) {
        this.deducPresta = deducPresta;
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

    public String imprimirReporte() {
        if (getProPlaSeleccionada() == null) {
            addMessage("Reporte de Deducciones/Prestaciones", "No ha elegido ninguna planilla", TipoMensaje.INFORMACION);
            return null;
        } else {
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("anio", String.valueOf(getProPlaSeleccionada().getAnio()));
            parametros.put("empresa", String.valueOf(getProPlaSeleccionada().getProgramacionPlaPK().getCodCia()));
            parametros.put("tipo", deducPresta);
            parametros.put("tipo_planilla", String.valueOf(getProPlaSeleccionada().getProgramacionPlaPK().getCodTipopla()));
            parametros.put("mes", String.valueOf(getProPlaSeleccionada().getMes()));
            parametros.put("planilla", String.valueOf(getProPlaSeleccionada().getNumPlanilla()));
            reportesStatelessBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "RPLA012", FormatoReporte.PDF);
        }
        return null;
    }

    @Override
    protected void limpiarCampos() {
        setProPlaSeleccionada(null);
    }
}
