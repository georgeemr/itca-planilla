/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompleteProgramacionPlaConverter;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Gabriel Bran
 */
@ManagedBean(name = "planilla$horasExtras")
@ViewScoped
public class HorasExtrasBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private Short tipoPlanilla;
    private List<TiposPlanilla> listaTipos;
    private ProgramacionPla proPlaSeleccionada;
    private AutocompleteProgramacionPlaConverter programacionPlaConverter;
    private List<Agencias> listaAgencias;
    private Short agenciaSeleccionada;
    private List<Departamentos> listaDepartamentos;
    private Short departamentoSeleccionado;
    private List<ResumenAsistencia> listaResumenAsistencia;
    private List<TipoAusent> listaEstados;
    private List<Empleados> listaEmpleados;
    private Empleados empleadoSeleccionado;
    private String estadoSeleccionado;

    @PostConstruct
    public void init() {
        programacionPlaConverter = new AutocompleteProgramacionPlaConverter(new ArrayList<ProgramacionPla>());
        listaEmpleados = planillaSessionBean.listaEmpleados(getSessionBeanADM().getCompania());
        listaAgencias = planillaSessionBean.listarAgencias(getSessionBeanADM().getCompania());
        listaDepartamentos = planillaSessionBean.findDepartamentos(getSessionBeanADM().getCompania());
        listaEstados = planillaSessionBean.findListaTipoAusent();
    }

    public String getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(String estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }

    public Empleados getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Empleados empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public List<Empleados> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<TipoAusent> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<TipoAusent> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public List<ResumenAsistencia> getListaResumenAsistencia() {
        return listaResumenAsistencia;
    }

    public void setListaResumenAsistencia(List<ResumenAsistencia> listaResumenAsistencia) {
        this.listaResumenAsistencia = listaResumenAsistencia;
    }

    public Short getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(Short departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }

    public List<Departamentos> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public Short getAgenciaSeleccionada() {
        return agenciaSeleccionada;
    }

    public void setAgenciaSeleccionada(Short agenciaSeleccionada) {
        this.agenciaSeleccionada = agenciaSeleccionada;
    }

    public List<Agencias> getListaAgencias() {
        return listaAgencias;
    }

    public void setListaAgencias(List<Agencias> listaAgencias) {
        this.listaAgencias = listaAgencias;
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

    public void setProgramacionPlaConverter(AutocompleteProgramacionPlaConverter programacionPlaConverter) {
        this.programacionPlaConverter = programacionPlaConverter;
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

    public List<ProgramacionPla> completeProgramacionPla(String query) {
        List<ProgramacionPla> suggestions = new ArrayList<ProgramacionPla>();
        for (ProgramacionPla p : programacionPlaConverter.listaProgramacionPla) {
            if (p.getStringProgramacionPla().startsWith(query)) {
                suggestions.add(p);
            }
        }
        return suggestions;
    }

    public void updateByTipoPlanilla(AjaxBehaviorEvent event) {
        limpiarCampos();
    }

    @Override
    protected void limpiarCampos() {
        setProPlaSeleccionada(null);
        setAgenciaSeleccionada(new Short("-1"));
        setDepartamentoSeleccionado(new Short("-1"));
        setListaResumenAsistencia(new ArrayList<ResumenAsistencia>());
    }

    public void rowEditListener(RowEditEvent event) {
        ResumenAsistencia resumen = (ResumenAsistencia) event.getObject();
        try {
            planillaSessionBean.editarResumenAsistencia(resumen);
            addMessage("Registro de Resumen de Asistencias", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Registro de Resumen de Asistencias", "Ha ocurrido un error al intentar guardar los cambios.", TipoMensaje.INFORMACION);
            e.printStackTrace();
        }
    }

    public String mostrarResumenAsistencia$action() {
        if (proPlaSeleccionada == null) {
            addMessage("Registro de Resumen de Asistencias", "Seleccione una Programación Planilla.", TipoMensaje.ERROR);
            return null;
        }
        listaResumenAsistencia = planillaSessionBean.findResumenAsistencia(proPlaSeleccionada, departamentoSeleccionado, agenciaSeleccionada);

        if (listaResumenAsistencia.size() <= 0) {
            addMessage("Registro de Resumen de Asistencias", "No se han encontrado datos.", TipoMensaje.ERROR);
        }
        return null;
    }

    public String seleccionarEmpleado() {
        if (proPlaSeleccionada == null) {
            addMessage("Registro de Resumen de Asistencias", "Seleccione una Programación Planilla.", TipoMensaje.ERROR);
            return null;
        }
        try {
            ResumenAsistencia resumen = new ResumenAsistencia();
            ResumenAsistenciaPK pk = new ResumenAsistenciaPK();
            pk.setCodCia(proPlaSeleccionada.getProgramacionPlaPK().getCodCia());
            pk.setCodTipopla(proPlaSeleccionada.getProgramacionPlaPK().getCodTipopla());
            pk.setAnio(proPlaSeleccionada.getAnio());
            pk.setMes(proPlaSeleccionada.getMes());
            pk.setNumPlanilla(proPlaSeleccionada.getNumPlanilla());
            pk.setCodEmp(empleadoSeleccionado.getEmpleadosPK().getCodEmp());
            resumen.setEmpleados(empleadoSeleccionado);
            resumen.setDLaborados(new Short("0"));
            resumen.setDnLaborados(new Short("0"));
            resumen.setHXsencillas(BigDecimal.ZERO);
            resumen.setHXdobles(BigDecimal.ZERO);
            resumen.setViaticos(BigDecimal.ZERO);
            resumen.setStatus("G");
            resumen.setHXf250(BigDecimal.ZERO);
            resumen.setHHora(BigDecimal.ZERO);
            resumen.setDAguinaldo(new Integer("0"));
            resumen.setVacaciones(BigDecimal.ZERO);
            resumen.setHXf150(new Integer("0"));
            resumen.setOtros(BigDecimal.ZERO);
            resumen.setEstado(new TipoAusent(estadoSeleccionado));
            resumen.setHorasAusencia(BigDecimal.ZERO);
            resumen.setDNocturnidad(new Short("0"));
            resumen.setResumenAsistenciaPK(pk);
            resumen.setAgencias(empleadoSeleccionado.getAgencias());
            resumen.setDepartamentos(empleadoSeleccionado.getDepartamentos());
            planillaSessionBean.editarResumenAsistencia(resumen);
            addMessage("Acciones de Personal", "Empleado seleccionado " + empleadoSeleccionado.getNombreCompleto(), TipoMensaje.INFORMACION);
            listaResumenAsistencia = planillaSessionBean.findResumenAsistencia(proPlaSeleccionada, departamentoSeleccionado, agenciaSeleccionada);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String cancelSeleccionarEmpleado() {
        setEmpleadoSeleccionado(null);
        return null;
    }
}
