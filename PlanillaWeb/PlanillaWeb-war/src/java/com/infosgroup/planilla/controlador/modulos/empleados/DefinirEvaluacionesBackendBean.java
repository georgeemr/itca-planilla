/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "empleados$definirEvaluaciones")
@ViewScoped
public class DefinirEvaluacionesBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private EmpleadosSessionBean empleadosBean;
    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<PreEvaluacion> listaPreEvaluacion;
    private PreEvaluacion preEvaluacionSeleccionada;
    private List<Empleados> evaluadores;
    private Empleados evaluadorSeleccionado;
    private List<Empleados> evaluados;
    private List<Empleados> listaEmpleados;
    private String tituloMensajes = "Definir Evaluaciones";
    private Boolean modoBusqueda = Boolean.FALSE;
    private String filtroBusqueda = "N";
    private List<Departamentos> listaDepartamentos;
    private List<Puestos> listaPuestos;
    private Short departamento;
    private Short puesto;
    private String fase = "1";
    
    @PostConstruct
    public void init() {
        listaPreEvaluacion = empleadosBean.findPreevaluacionByCias(getSessionBeanADM().getCompania());
        listaDepartamentos = planillaSessionBean.findDepartamentos(getSessionBeanADM().getCompania());
        listaPuestos = planillaSessionBean.findPuestos(getSessionBeanADM().getCompania());
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public List<Empleados> getEvaluados() {
        return evaluados;
    }

    public void setEvaluados(List<Empleados> evaluados) {
        this.evaluados = evaluados;
    }

    public Short getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Short departamento) {
        this.departamento = departamento;
    }

    public Short getPuesto() {
        return puesto;
    }

    public void setPuesto(Short puesto) {
        this.puesto = puesto;
    }

    public List<Departamentos> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<Puestos> getListaPuestos() {
        return listaPuestos;
    }

    public void setListaPuestos(List<Puestos> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public String getFiltroBusqueda() {
        return filtroBusqueda;
    }

    public void setFiltroBusqueda(String filtroBusqueda) {
        this.filtroBusqueda = filtroBusqueda;
    }

    public Boolean getModoBusqueda() {
        return modoBusqueda;
    }

    public void setModoBusqueda(Boolean modoBusqueda) {
        this.modoBusqueda = modoBusqueda;
    }

    public Empleados getEvaluadorSeleccionado() {
        return evaluadorSeleccionado;
    }

    public void setEvaluadorSeleccionado(Empleados evaluadorSeleccionado) {
        this.evaluadorSeleccionado = evaluadorSeleccionado;
    }

    public List<PreEvaluacion> getListaPreEvaluacion() {
        return listaPreEvaluacion;
    }

    public void setListaPreEvaluacion(List<PreEvaluacion> listaPreEvaluacion) {
        this.listaPreEvaluacion = listaPreEvaluacion;
    }

    public PreEvaluacion getPreEvaluacionSeleccionada() {
        return preEvaluacionSeleccionada;
    }

    public void setPreEvaluacionSeleccionada(PreEvaluacion preEvaluacionSeleccionada) {
        this.preEvaluacionSeleccionada = preEvaluacionSeleccionada;
    }

    public List<Empleados> getEvaluadores() {
        return evaluadores;
    }

    public void setEvaluadores(List<Empleados> evaluadores) {
        this.evaluadores = evaluadores;
    }

    public List<Empleados> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String definirEvaluaciones$action() {
//        Integer excepciones = 0;
//        Boolean HayError = Boolean.FALSE;
//        String mensaje = null;
//        if (preEvaluacionSeleccionada == null) {
//            addMessage("PlanillaWeb", "Seleccione la campa&ntilde;a", TipoMensaje.ADVERTENCIA);
//            HayError = Boolean.TRUE;
//        }
//
//        if ((sessionBeanEMP.getPuestosEmpleadosEvaluadores() == null) || (sessionBeanEMP.getPuestosEmpleadosEvaluadores().length == 0)) {
//            addMessage("PlanillaWeb", "Seleccione al menos un empleado como evaluador", TipoMensaje.ADVERTENCIA);
//            HayError = Boolean.TRUE;
//        }
//        if ((sessionBeanEMP.getPuestosEmpleadosEvaluados() == null) || (sessionBeanEMP.getPuestosEmpleadosEvaluados().length == 0)) {
//            addMessage("PlanillaWeb", "Seleccione al menos un empleado a evaluar", TipoMensaje.ADVERTENCIA);
//            HayError = Boolean.TRUE;
//        }
//
//        if (HayError) {
//            return null;
//        }
//
//        List<Evaluacion> evaluaciones = null;
//
//        if (empleadosBean.tieneEvaluaciones(preEvaluacionSeleccionada)) {
//            addMessage("PlanillaWeb", "La campa&ntilde;a seleccionada ya tiene definidos tipo de evaluaci&oacute;n y plantilla", TipoMensaje.ADVERTENCIA);
//            evaluaciones = campaniaSeleccionada.getEvaluacionList();
//        } else {
//            evaluaciones = new ArrayList<Evaluacion>(0);
//            for (Empleados puestoEmpleado : sessionBeanEMP.getPuestosEmpleadosEvaluados()) {
//                EvaluacionPK evaluacionPK = new EvaluacionPK();
//                evaluacionPK.setCodCia(campaniaSeleccionada.getCampaniaPK().getCodCia());
//                evaluacionPK.setPeriodo(campaniaSeleccionada.getCampaniaPK().getPeriodo());
//                evaluacionPK.setCodCampania(campaniaSeleccionada.getCampaniaPK().getCodCampania());
////                evaluacionPK.setTipoEvaluacion(plantillaSeleccionada.getPlantillaPK().getCodTipoEvaluacion());
////                evaluacionPK.setPlantilla(plantillaSeleccionada.getPlantillaPK().getCodPlantilla());
//                evaluacionPK.setCodEmp(puestoEmpleado.getEmpleadosPK().getCodEmp());
//
//                Evaluacion evaluacion = new Evaluacion();
//                evaluacion.setEvaluacionPK(evaluacionPK);
//                evaluacion.setCampania(campaniaSeleccionada);
////                evaluacion.setPlantilla1(plantillaSeleccionada);
//                evaluacion.setEmpleados(puestoEmpleado);
//                evaluacion.setFecha(Calendar.getInstance().getTime());
//                evaluacion.setFinalizada(0L);
//                evaluaciones.add(evaluacion);
//            }
//            excepciones = empleadosBean.crearEvaluaciones(evaluaciones);
//            mensaje = (excepciones == 0) ? "Todas las evaluaciones han sido creadas exitosamente" : "Ya se han definido " + excepciones + " de " + evaluaciones.size() + " evaluaciones para la campa&ntilde;a, plantilla y empleados seleccionados";
//            addMessage("PlanillaWeb", mensaje, TipoMensaje.INFORMACION);
//
//            excepciones = 0;
//            for (Empleados puestoEmpleadoEvaluador : sessionBeanEMP.getPuestosEmpleadosEvaluadores()) {
//                excepciones += empleadosBean.asignarEvaluaciones(evaluaciones, puestoEmpleadoEvaluador);
//            }
//            mensaje = (excepciones == 0) ? "Todas las asignaciones de evaluaciones han sido creadas y/o modificadas exitosamente" : "Ya se habian definido " + excepciones + " de " + evaluaciones.size() + " asignaciones a evaluadores para la campa&ntilde;a y plantilla seleccionados";
//            addMessage("PlanillaWeb", mensaje, TipoMensaje.INFORMACION);
//        }
        return null;
    }

    public String mostrarEvaluadores() {
        setFiltroBusqueda("N");
        setModoBusqueda(Boolean.FALSE);
        setListaEmpleados(new ArrayList<Empleados>());
        return null;
    }

    public String buscarEvaluadoresPorPuesto() {
        setFiltroBusqueda("P");
        setModoBusqueda(Boolean.TRUE);
        setListaEmpleados(new ArrayList<Empleados>());
        return null;
    }

    public String buscarEvaluadoresPorDepartamento() {
        setFiltroBusqueda("D");
        setModoBusqueda(Boolean.TRUE);
        setListaEmpleados(new ArrayList<Empleados>());
        return null;
    }

    public String buscarEvaluadoresPorNombre() {
        setFiltroBusqueda("N");
        setModoBusqueda(Boolean.TRUE);
        setListaEmpleados(planillaSessionBean.listaEmpleados(getSessionBeanADM().getCompania()));
        return null;
    }

    public String volverACampanias() {
        return "definirEvaluaciones?faces-redirect=true";
    }

    public void listarEmpleadosByDepartamento(AjaxBehaviorEvent event) {
        setListaEmpleados(planillaSessionBean.findEmpleadosByDepartamentos(new Departamentos(new DepartamentosPK(getSessionBeanADM().getCompania().getCodCia(), departamento))));
    }

    public void listarEmpleadosByPuesto(AjaxBehaviorEvent event) {
        setListaEmpleados(planillaSessionBean.findEmpleadosByPuestos(new Puestos(new PuestosPK(getSessionBeanADM().getCompania().getCodCia(), puesto))));
    }

    public String eliminarEvaluador() {
        if (evaluadores != null && !evaluadores.isEmpty()) {
            if (evaluadores.contains(evaluadorSeleccionado)) {
                evaluadores.remove(evaluadorSeleccionado);
                addMessage(tituloMensajes, "Evaluador Eliminado", TipoMensaje.INFORMACION);
            }
        }
        return null;
    }

    public String agregarEvaluador() {
        if (evaluadorSeleccionado == null) {
            addMessage(tituloMensajes, "Seleccione un evaluador.", TipoMensaje.INFORMACION);
        }
        if (evaluadores == null || evaluadores.isEmpty()) {
            evaluadores = new ArrayList<Empleados>();
        }
        if (!evaluadores.contains(evaluadorSeleccionado)) {
            evaluadores.add(evaluadorSeleccionado);
            addMessage(tituloMensajes, "Evaluador Agregado." + evaluadorSeleccionado.getNombreCompleto(), TipoMensaje.INFORMACION);
        } else {
            addMessage(tituloMensajes, "Este evaluador ya ha sido seleccionado.", TipoMensaje.INFORMACION);
        }
        return null;
    }

    public String wizardFlowListener(FlowEvent flowEvt) {
        Boolean hayError = Boolean.FALSE;
        String anterior = flowEvt.getOldStep();
        Integer a = Integer.parseInt(anterior.replaceAll("tab", ""));
        switch (a) {
            case 0:
                hayError = (preEvaluacionSeleccionada == null);
                break;
            case 1:
                hayError = ((evaluadores == null) || (evaluadores.isEmpty()));
                break;
            case 2:
                hayError = ((evaluados == null) || (evaluados.isEmpty()));
                break;
        }
        return hayError ? flowEvt.getOldStep() : flowEvt.getNewStep();
    }

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
//227