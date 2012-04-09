/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.ModelEvaluadorEvaluado;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
    private List<Empleados> evaluadores;
    private Empleados evaluadorSeleccionado;
    private List<ModelEvaluadorEvaluado> evaluados;
    private ModelEvaluadorEvaluado evaluadoSeleccionado;
    private List<Empleados> listaEmpleados;
    private String tituloMensajes = "Definir Evaluaciones";
    private Boolean modoBusqueda = Boolean.FALSE;
    private String filtroBusqueda = "N";
    private List<Departamentos> listaDepartamentos;
    private List<Puestos> listaPuestos;
    private Short departamento;
    private Short departamentoEvaluado;
    private Short puesto;
    private Empleados[] empleadosSeleccionados;

    @PostConstruct
    public void init() {
        listaPreEvaluacion = empleadosBean.findPreevaluacionByCias(getSessionBeanADM().getCompania());
        listaDepartamentos = planillaSessionBean.findDepartamentos(getSessionBeanADM().getCompania());
        listaPuestos = planillaSessionBean.findPuestos(getSessionBeanADM().getCompania());
        getSessionBeanEMP().setPreEvaluacionSeleccionada(null);
    }

    public Empleados[] getEmpleadosSeleccionados() {
        return empleadosSeleccionados;
    }

    public void setEmpleadosSeleccionados(Empleados[] empleadosSeleccionados) {
        this.empleadosSeleccionados = empleadosSeleccionados;
    }

    public Short getDepartamentoEvaluado() {
        return departamentoEvaluado;
    }

    public void setDepartamentoEvaluado(Short departamentoEvaluado) {
        this.departamentoEvaluado = departamentoEvaluado;
    }

    public ModelEvaluadorEvaluado getEvaluadoSeleccionado() {
        return evaluadoSeleccionado;
    }

    public void setEvaluadoSeleccionado(ModelEvaluadorEvaluado evaluadoSeleccionado) {
        this.evaluadoSeleccionado = evaluadoSeleccionado;
    }

    public List<ModelEvaluadorEvaluado> getEvaluados() {
        return evaluados;
    }

    public void setEvaluados(List<ModelEvaluadorEvaluado> evaluados) {
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
        if (evaluados == null && evaluados.isEmpty()) {
            addMessage(tituloMensajes, "No hay datos que guardar.", TipoMensaje.INFORMACION);
            return null;
        }
        
        if( getSessionBeanEMP().getPreEvaluacionSeleccionada() == null){
            addMessage(tituloMensajes, "Seleccione una evaluación.", TipoMensaje.INFORMACION);
            return null;
        }
        
        for (ModelEvaluadorEvaluado e : evaluados) {
            if (e.getCantidad().equals(0)) {
                addMessage(tituloMensajes, e.getEvaluador().getNombreCompleto() + " no tiene personal a evaluar.", TipoMensaje.INFORMACION);
                break;
            }
        }

        try {

            for (ModelEvaluadorEvaluado e : evaluados) {
                List<Evaluacion> evaluacion = new ArrayList<Evaluacion>();
                for (Empleados z : e.getListaEvaluados()) {
                    Evaluacion v = new Evaluacion();
                    EvaluacionPK pk = new EvaluacionPK();
                    pk.setCodCia( z.getEmpleadosPK().getCodCia());
                    pk.setCodEmp(z.getEmpleadosPK().getCodEmp());
                    pk.setCodCampania(getSessionBeanEMP().getPreEvaluacionSeleccionada().getPreEvaluacionPK().getCodCampania());
                    pk.setPeriodo(getSessionBeanEMP().getPreEvaluacionSeleccionada().getPreEvaluacionPK().getPeriodo());
                    pk.setPlantilla(getSessionBeanEMP().getPreEvaluacionSeleccionada().getPreEvaluacionPK().getPlantilla());
                    pk.setTipoEvaluacion(getSessionBeanEMP().getPreEvaluacionSeleccionada().getPreEvaluacionPK().getTipoEvaluacion());
                    v.setEvaluacionPK(pk);
                    v.setFecha(new Date());
                    v.setFinalizada(0L);
                    evaluacion.add(v);
                }
                
                List<Evaluacion> en = e.getEvaluador().getEvaluacionList();
                if (en != null &&  !en.isEmpty() ) {                  
                    for ( Evaluacion n: evaluacion ) {
                        if ( !en.contains(n) ){
                            e.getEvaluador().getEvaluacionList().add(n);
                        }
                    }
                }else{
                    e.getEvaluador().setEvaluacionList( new ArrayList<Evaluacion>() );
                    e.getEvaluador().getEvaluacionList().addAll(evaluacion);
                }   
                planillaSessionBean.actualizarEmpleado(e.getEvaluador());
            }
            addMessage(tituloMensajes, "Datos guardados.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage(tituloMensajes, "Ocurrio un error al intentar guardar.", TipoMensaje.INFORMACION);
            e.printStackTrace();
        }
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
    
    public void rowSelectListener(SelectEvent event){
        getSessionBeanEMP().setPreEvaluacionSeleccionada((PreEvaluacion) event.getObject() );
    }
    
    public void rowUnSelectListener(UnselectEvent event){
        getSessionBeanEMP().setPreEvaluacionSeleccionada(null);
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

    public String calcularEvaluados() {
        if (evaluadoSeleccionado == null) {
            return null;
        }
        ModelEvaluadorEvaluado m = evaluadoSeleccionado;
        if (evaluadoSeleccionado.getFiltroEvaluados().equals("D")) {
            if (departamentoEvaluado == null || departamentoEvaluado.equals(new Short("-1"))) {
                addMessage(tituloMensajes, "Seleccione un departamento.", TipoMensaje.ERROR);
                return null;
            }
            m.setListaEvaluados(planillaSessionBean.findEmpleadosByDepartamentos(new Departamentos(new DepartamentosPK(getSessionBeanADM().getCompania().getCodCia(), departamentoEvaluado))));
            evaluados.set(evaluados.indexOf(evaluadoSeleccionado), m);
        } else if (evaluadoSeleccionado.getFiltroEvaluados().equals("C")) {
            m.setListaEvaluados(empleadosBean.findEmpleadosByJefe(evaluadoSeleccionado.getEvaluador()));
            evaluados.set(evaluados.indexOf(evaluadoSeleccionado), m);
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
                break;
            case 1:
                if ((evaluadores == null) || (evaluadores.isEmpty())) {
                    hayError = Boolean.TRUE;
                } else {
                    setEvaluados(new ArrayList<ModelEvaluadorEvaluado>());
                    if (evaluadores != null && !evaluadores.isEmpty()) {
                        for (Empleados e : evaluadores) {
                            evaluados.add(new ModelEvaluadorEvaluado(e, new ArrayList<Empleados>()));
                        }
                    }
                }
                setListaEmpleados(planillaSessionBean.listaEmpleados(getSessionBeanADM().getCompania()));
                break;
            case 2:
                hayError = ((evaluados == null) || (evaluados.isEmpty()));
                break;
        }
        return hayError ? flowEvt.getOldStep() : flowEvt.getNewStep();
    }

    public String aceptarSeleccion() {
        if (evaluadoSeleccionado == null) {
            return null;
        }
        ModelEvaluadorEvaluado m = evaluadoSeleccionado;
        List<Empleados> e = Arrays.asList(empleadosSeleccionados);
        if (e != null) {
            m.setListaEvaluados(e);
            evaluados.set(evaluados.indexOf(evaluadoSeleccionado), m);
        }
        return null;
    }

    public String removerEvaluado() {
        if (evaluadoSeleccionado == null) {
            return null;
        }
        if (evaluados != null && !evaluados.isEmpty()) {
            if (evaluados.contains(evaluadoSeleccionado)) {
                evaluados.remove(evaluadoSeleccionado);
                addMessage(tituloMensajes, "Evaluado Eliminado", TipoMensaje.INFORMACION);
            }
        }
        return null;
    }

    public String limpiarSeleccion() {
        setEmpleadosSeleccionados(null);
        return null;
    }

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
//227
