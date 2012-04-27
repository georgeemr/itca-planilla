/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompleteProgramacionPlaConverter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

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
    private List<Planilla> listaPlanillas;
    private List<MovDp> listaPrestaciones;
    private List<MovDp> listaDeducciones;
    private Cias empresa;

    @PostConstruct
    public void init() {
        setEmpresa(getSessionBeanADM().getCompania());
    }

    public Cias getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public List<TiposPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos(getEmpresa());
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
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(planillaSessionBean.getProgramacionPlaByTipo(getEmpresa().getCodCia(), tipoPlanilla));
        } else {
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(new ArrayList<ProgramacionPla>());
        }
        return programacionPlaConverter;
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

    public List<Planilla> getListaPlanillas() {
        setListaPlanillas( new ArrayList<Planilla>());
        if (getProPlaSeleccionada()!=null){
        setListaPlanillas(planillaSessionBean.findByProgramacionPla(getProPlaSeleccionada()));
        }
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

    public void seleccionarTipoPlanilla(AjaxBehaviorEvent event) {
        limpiarCampos();
    }

    public String selectEmpleado$Action() {
        setListaDeducciones (planillaSessionBean.findDeduccionesPresta(planillaSeleccionada, "R"));
        setListaPrestaciones(new ArrayList<MovDp>());
        Double salario = (getPlanillaSeleccionada().getSueldoBase()!=null)?new Double(getPlanillaSeleccionada().getSueldoBase().doubleValue()):new Double("0");
        Double diasLaborados = (getPlanillaSeleccionada().getSueldoBase()!=null)?new Double(getPlanillaSeleccionada().getDLaborados().doubleValue()) : new Double("0");
        salario = (salario/30)*diasLaborados;        
        setListaPrestaciones( planillaSessionBean.findDeduccionesPresta(planillaSeleccionada, "S"));
        listaPrestaciones.add( new MovDp(new DeducPresta("SALARIO"), null, BigDecimal.ZERO, new BigDecimal(salario), BigDecimal.ZERO, null, null, null) );
        return null;
    }

    public String cancelSelectEmpleado$Action() {
        setPlanillaSeleccionada(null);
        limpiarCampos();
        return null;
    }
    
    private Double totalPrestaciones;
    private Double totalDeducciones;

    public Double getTotalDeducciones() {
        totalDeducciones = 0.0;
        if( listaDeducciones!=null ){
            for (MovDp d: listaDeducciones){
                if ( d.getValor()!=null ) totalDeducciones += d.getValor().doubleValue();
            }    
        }
        return totalDeducciones;
    }

    public void setTotalDeducciones(Double totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
    }

    public Double getTotalPrestaciones() {
        totalPrestaciones = 0.0;
        if( listaPrestaciones!=null ){
            for (MovDp d: listaPrestaciones){
                if ( d.getValor()!=null ) totalPrestaciones += d.getValor().doubleValue();
            }    
        }
        return totalPrestaciones;
    }

    public void setTotalPrestaciones(Double totalPrestaciones) {
        this.totalPrestaciones = totalPrestaciones;
    }
    
}
