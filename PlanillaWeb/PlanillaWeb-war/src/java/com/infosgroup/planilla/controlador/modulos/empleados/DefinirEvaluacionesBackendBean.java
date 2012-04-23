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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

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
    private List<Evaluador> evaluadores;
    private Evaluador evaluadorSeleccionado;
    private List<Evaluador> listaEmpleados;
    private String tituloMensajes = "Definir Evaluaciones";
    private Boolean modoBusqueda = Boolean.FALSE;
    private String filtroBusqueda = "N";
    private List<Departamentos> listaDepartamentos;
    private List<Puestos> listaPuestos;
    private Short departamento;
    private Short puesto;
    private Empleados[] empleadosSeleccionados;
    private List<Empleados> empleados;
    private Boolean editSeleccion = Boolean.FALSE;
    private Empleados empleadoSeleccionado;

    @PostConstruct
    public void init() {
        //setListaPreEvaluacion(empleadosBean.findPreevaluacionByCias(getSessionBeanADM().getCompania()));
        setListaDepartamentos(planillaSessionBean.findDepartamentos(getSessionBeanADM().getCompania()));
        setListaPuestos(planillaSessionBean.findPuestos(getSessionBeanADM().getCompania()));
        getSessionBeanEMP().setPreEvaluacionSeleccionada(null);
    }

    public Empleados getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Empleados empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public Boolean getEditSeleccion() {
        return editSeleccion;
    }

    public void setEditSeleccion(Boolean editSeleccion) {
        this.editSeleccion = editSeleccion;
    }

    public List<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }

    public Empleados[] getEmpleadosSeleccionados() {
        return empleadosSeleccionados;
    }

    public void setEmpleadosSeleccionados(Empleados[] empleadosSeleccionados) {
        this.empleadosSeleccionados = empleadosSeleccionados;
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

    public Evaluador getEvaluadorSeleccionado() {
        return evaluadorSeleccionado;
    }

    public void setEvaluadorSeleccionado(Evaluador evaluadorSeleccionado) {
        this.evaluadorSeleccionado = evaluadorSeleccionado;
    }

    public List<PreEvaluacion> getListaPreEvaluacion() {
        setListaPreEvaluacion(empleadosBean.findPreevaluacionByCias(getSessionBeanADM().getCompania()));
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

    public List<Evaluador> getEvaluadores() {
        return evaluadores;
    }

    public void setEvaluadores(List<Evaluador> evaluadores) {
        this.evaluadores = evaluadores;
    }

    public List<Evaluador> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Evaluador> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String definirEvaluaciones$action() {
        if (getEvaluadores() == null && getEvaluadores().isEmpty()) {
            addMessage(tituloMensajes, "No hay datos que guardar.", TipoMensaje.INFORMACION);
            return null;
        }

        if (getSessionBeanEMP().getPreEvaluacionSeleccionada() == null) {
            addMessage(tituloMensajes, "Seleccione una evaluación.", TipoMensaje.INFORMACION);
            return null;
        }

        for (Evaluador e : evaluadores) {
            if (e.getCantidad().equals(new Integer(0))) {
                addMessage(tituloMensajes, e.getEmpleados().getNombreCompleto() + " no tiene personal a evaluar.", TipoMensaje.ERROR);
                return null;
            }
        }

        try {

            for (Evaluador e : evaluadores) {
                List<Evaluacion> evaluacion = new ArrayList<Evaluacion>();
                planillaSessionBean.eliminarEvaluadorEvaluaciones(e.getPreEvaluacion(), e.getEmpleados());
                for (Evaluado z : e.getEvaluadoList()) {
                    Evaluacion v = new Evaluacion();
                    EvaluacionPK pk = new EvaluacionPK();
                    pk.setCodCia(z.getEmpleados().getEmpleadosPK().getCodCia());
                    pk.setCodEmp(z.getEmpleados().getEmpleadosPK().getCodEmp());
                    pk.setCodCampania(getSessionBeanEMP().getPreEvaluacionSeleccionada().getPreEvaluacionPK().getCodCampania());
                    pk.setPeriodo(getSessionBeanEMP().getPreEvaluacionSeleccionada().getPreEvaluacionPK().getPeriodo());
                    pk.setPlantilla(getSessionBeanEMP().getPreEvaluacionSeleccionada().getPreEvaluacionPK().getPlantilla());
                    pk.setTipoEvaluacion(getSessionBeanEMP().getPreEvaluacionSeleccionada().getPreEvaluacionPK().getTipoEvaluacion());
                    v.setFecha(new Date());
                    v.setFinalizada(0L);
                    v.setTipoEvaluacion1(getSessionBeanEMP().getPreEvaluacionSeleccionada().getTipoEvaluacion1());
                    v.setPlantilla1(getSessionBeanEMP().getPreEvaluacionSeleccionada().getPlantilla1());
                    v.setEmpleados(z.getEmpleados());
                    v.setCampania(getSessionBeanEMP().getPreEvaluacionSeleccionada().getCampania());
                    v.setEvaluacionPK(pk);
                    evaluacion.add(v);
                    //empleadosBean.editarEvaluacion(v);
                    //empleadosBean.EliminarEvaluacion(v);
                }
                Empleados empleado = empleadosBean.buscarEmpleadoPorPK( e.getEmpleados().getEmpleadosPK() );
//                List<Evaluacion> en = empleado.getEvaluacionList();
//                if (en != null && !en.isEmpty()) {
//                    for (Evaluacion n : evaluacion) {
//                        if (!en.contains(n)) {
//                            empleado.getEvaluacionList().add(n);
//                            logger.log(Level.SEVERE, "Agregando {0} a {1}", new Object[]{empleado.getNombreCompleto(), e.getEmpleados().getNombreCompleto()});
//                        }
//                    }
//                } else {
                empleado.setEvaluacionList(new ArrayList<Evaluacion>());
                empleado.getEvaluacionList().addAll(evaluacion);
                logger.log(Level.SEVERE, "Se agregaron todos a {0}", new Object[]{ e.getEmpleados().getNombreCompleto()});
//                }

                planillaSessionBean.actualizarEmpleado(empleado);
                e.setEstado("A");
                e.setEmpleados(empleado);
                empleadosBean.editarEvaluador(e);

            }
            addMessage(tituloMensajes, "Datos guardados.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage(tituloMensajes, "Ocurrio un error al intentar guardar.", TipoMensaje.INFORMACION);
            logger.log(Level.SEVERE, "Ocurrio un error al intentar guardar: ", e);
        }
        return null;
    }

    public void removerEvaluaciones( PreEvaluacion preevaluacion, Empleados empleado){
        
    }
    
    public String mostrarEvaluadores() {
        setFiltroBusqueda("N");
        setModoBusqueda(Boolean.FALSE);
        setListaEmpleados(new ArrayList<Evaluador>());
        return null;
    }

    public String buscarEvaluadoresPorPuesto() {
        setFiltroBusqueda("P");
        setModoBusqueda(Boolean.TRUE);
        setListaEmpleados(new ArrayList<Evaluador>());
        return null;
    }

    public String buscarEvaluadoresPorDepartamento() {
        setFiltroBusqueda("D");
        setModoBusqueda(Boolean.TRUE);
        setListaEmpleados(new ArrayList<Evaluador>());
        return null;
    }

    public String buscarEvaluadoresPorNombre() {
        setFiltroBusqueda("N");
        setModoBusqueda(Boolean.TRUE);
        castListaEmpleadosToEvaluador(planillaSessionBean.listaEmpleados(getSessionBeanADM().getCompania()));
        return null;
    }

    public String volverACampanias() {
        getSessionBeanEMP().setPreEvaluacionSeleccionada(null);
        return "definirEvaluaciones?faces-redirect=true";
    }

    public void castListaEmpleadosToEvaluador(List<Empleados> empleados) {
        setListaEmpleados(new ArrayList<Evaluador>());
        for (Empleados e : empleados) {
            getListaEmpleados().add(new Evaluador(getSessionBeanEMP().getPreEvaluacionSeleccionada(), e));
        }
    }

    public void listarEmpleadosByDepartamento(AjaxBehaviorEvent event) {
        castListaEmpleadosToEvaluador(planillaSessionBean.findEmpleadosByDepartamentos(new Departamentos(new DepartamentosPK(getSessionBeanADM().getCompania().getCodCia(), departamento))));
    }

    public void listarEmpleadosByPuesto(AjaxBehaviorEvent event) {
        castListaEmpleadosToEvaluador(planillaSessionBean.findEmpleadosByPuestos(new Puestos(new PuestosPK(getSessionBeanADM().getCompania().getCodCia(), puesto))));
    }

//    public void rowSelectListener(SelectEvent event) {
//        getSessionBeanEMP().setPreEvaluacionSeleccionada((PreEvaluacion) event.getObject());
//    }
//
//    public void rowUnSelectListener(UnselectEvent event) {
//        getSessionBeanEMP().setPreEvaluacionSeleccionada(null);
//    }

    public String eliminarEvaluador() {
        if (evaluadores != null && !evaluadores.isEmpty()) {
            if (evaluadores.contains(evaluadorSeleccionado)) {
                empleadosBean.eliminarEvaluador(evaluadorSeleccionado);
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
            evaluadores = new ArrayList<Evaluador>();
        }
        if (!evaluadores.contains(evaluadorSeleccionado)) {
            evaluadorSeleccionado.setEstado("G");
            empleadosBean.guardarEvaluador(evaluadorSeleccionado);
            evaluadores.add(evaluadorSeleccionado);
            addMessage(tituloMensajes, "Evaluador Agregado." + evaluadorSeleccionado.getEmpleados().getNombreCompleto(), TipoMensaje.INFORMACION);
        } else {
            addMessage(tituloMensajes, "Este evaluador ya ha sido seleccionado.", TipoMensaje.INFORMACION);
        }
        return null;
    }

    public String calcularEvaluados() {
        if (evaluadorSeleccionado == null) {
            return null;
        }
        Integer indice = evaluadores.indexOf(evaluadorSeleccionado);
        if (evaluadorSeleccionado.getCriterioEvaluacion().equals("D")) {
            if (evaluadorSeleccionado.getDepartamento() == null || evaluadorSeleccionado.getDepartamento().equals(new Short("-1"))) {
                addMessage(tituloMensajes, "Seleccione un departamento.", TipoMensaje.ERROR);
                return null;
            }
            empleadosBean.eliminarEvaluados(evaluadorSeleccionado);
            evaluadorSeleccionado.setEvaluadoList(planillaSessionBean.findEvaluadosByDepartamentos(evaluadorSeleccionado, new Departamentos(new DepartamentosPK(getSessionBeanADM().getCompania().getCodCia(), evaluadorSeleccionado.getDepartamento()))));
            for (Evaluado e : evaluadorSeleccionado.getEvaluadoList()) {
                empleadosBean.guardarEvaluado(e);
            }
            empleadosBean.editarEvaluador(evaluadorSeleccionado);
            evaluadores.set(indice, evaluadorSeleccionado);
        } else if (evaluadorSeleccionado.getCriterioEvaluacion().equals("C")) {
            empleadosBean.eliminarEvaluados(evaluadorSeleccionado);
            evaluadorSeleccionado.setEvaluadoList(empleadosBean.findEvaluadosByJefe(evaluadorSeleccionado));
            for (Evaluado e : evaluadorSeleccionado.getEvaluadoList()) {
                empleadosBean.guardarEvaluado(e);
            }
            empleadosBean.editarEvaluador(evaluadorSeleccionado);
            evaluadores.set(indice, evaluadorSeleccionado);
        }
        return null;
    }

    public String wizardFlowListener(FlowEvent flowEvt) {
        Boolean hayError = Boolean.FALSE;
        String anterior = flowEvt.getOldStep();
        Integer a = Integer.parseInt(anterior.replaceAll("tab", ""));
        switch (a) {
            case 0:
                hayError = (getSessionBeanEMP().getPreEvaluacionSeleccionada() == null);
                setEvaluadores(empleadosBean.findEvaluadoresByPreEvaluacion(getSessionBeanEMP().getPreEvaluacionSeleccionada()));
                break;
            case 1:
                setEvaluadores(empleadosBean.findEvaluadoresByPreEvaluacion(getSessionBeanEMP().getPreEvaluacionSeleccionada()));
                if ((evaluadores == null) || (evaluadores.isEmpty())) {
                    hayError = Boolean.TRUE;
                }
                setEmpleados(planillaSessionBean.listaEmpleados(getSessionBeanADM().getCompania()));
                break;
            case 2:
                setEvaluadores(empleadosBean.findEvaluadoresByPreEvaluacion(getSessionBeanEMP().getPreEvaluacionSeleccionada()));
                hayError = ((evaluadores == null) || (evaluadores.isEmpty()));
                break;
        }
        return hayError ? flowEvt.getOldStep() : flowEvt.getNewStep();
    }

    public String aceptarSeleccion() {
        if (evaluadorSeleccionado == null) {
            return null;
        }
        Integer indice = evaluadores.indexOf(evaluadorSeleccionado);
        List<Empleados> e = Arrays.asList(empleadosSeleccionados);
        List<Evaluado> evls = new ArrayList<Evaluado>();
        for (Empleados z : e) {
            evls.add(new Evaluado(evaluadorSeleccionado, z));
        }
        if (e != null) {
            empleadosBean.eliminarEvaluados(evaluadorSeleccionado);
            evaluadorSeleccionado.setEvaluadoList(evls);
            for (Evaluado q : evaluadorSeleccionado.getEvaluadoList()) {
                empleadosBean.guardarEvaluado(q);
            }
            evaluadores.set(indice, evaluadorSeleccionado);
            empleadosBean.editarEvaluador(evaluadorSeleccionado);
        }
        return null;
    }

    public String actualizarEvaluados() {
        if (evaluadorSeleccionado == null) {
            logger.log(Level.SEVERE, "Evaluador seleccionado esta nulo.");
            return null;
        }
        if (evaluadorSeleccionado.getEvaluadoList() != null) {
            setEmpleados(new ArrayList<Empleados>());
            for (Evaluado a : evaluadorSeleccionado.getEvaluadoList()) {
                getEmpleados().add(a.getEmpleados());
            }
        }
        setEditSeleccion(Boolean.TRUE);
        return null;
    }

    public String limpiarSeleccion() {
        setEmpleadosSeleccionados(null);
        setEditSeleccion(Boolean.FALSE);
        setEmpleados(empleadosBean.findEmpleadosByCias(getSessionBeanADM().getCompania()));
        return null;
    }

    public String eliminarEvaluado() {
        if (evaluadorSeleccionado == null) {
            logger.log(Level.SEVERE, "No ha seleccionado un evaluador");
            return null;
        }
        Integer indice = evaluadores.indexOf(evaluadorSeleccionado);
        Evaluado evaluado = new Evaluado(evaluadorSeleccionado, empleadoSeleccionado);
        if (evaluadorSeleccionado.getEvaluadoList().contains(evaluado)) {
            empleadosBean.eliminarEvaluado(evaluado);
            evaluadorSeleccionado.getEvaluadoList().remove(evaluado);
            evaluadores.set(indice, evaluadorSeleccionado);
            empleadosBean.editarEvaluador(evaluadorSeleccionado);
            setEmpleados(new ArrayList<Empleados>());
            for (Evaluado a : evaluadorSeleccionado.getEvaluadoList()) {
                getEmpleados().add(a.getEmpleados());
            }
            addMessage(tituloMensajes, "Datos Eliminados con éxito.", TipoMensaje.INFORMACION);
        }

        return null;
    }

    @Override
    protected void limpiarCampos() {
    }
    
    public String seleccionarAction(){
        getSessionBeanEMP().setPreEvaluacionSeleccionada(getPreEvaluacionSeleccionada());
        return null;
    }
}
