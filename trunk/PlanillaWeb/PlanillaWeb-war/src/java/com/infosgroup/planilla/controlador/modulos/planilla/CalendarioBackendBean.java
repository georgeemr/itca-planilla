/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.Empleados;
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
import javax.faces.model.SelectItem;

/**
 *
 * @author root
 */
@ManagedBean(name = "planilla$calendario")
@ViewScoped
public class CalendarioBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private EmpleadosSessionBean empleadosBean;
    @EJB
    private PlanillaSessionBean planillaBean;
    private String anio;
    private String estilo;
    private List<SelectItem> listaAniosModel;
    private List<Empleados> listaEmpleados;
    private String fechas;
    private Empleados empleadoSeleccionado;

    @PostConstruct
    public void init() {
        anio = "" + Calendar.getInstance().get(Calendar.YEAR);
        if (isInRole("rrhh")) {
            setListaEmpleados( empleadosBean.findEmpleadosByCias(getSessionBeanADM().getCompania()));
            getListaEmpleados().add(getSessionBeanEMP().getEmpleadoSesion());
        } else if (isInRole("jefes")) {
            setListaEmpleados( empleadosBean.findEmpleadosByJefe(getSessionBeanEMP().getEmpleadoSesion()));
            getListaEmpleados().add(getSessionBeanEMP().getEmpleadoSesion());
        } else if (isInRole("empleados")) {
            setListaEmpleados( new ArrayList<Empleados>());
        }
    }

    @Override
    protected void limpiarCampos() {
        setEmpleadoSeleccionado(null);
        setListaEmpleados( new ArrayList<Empleados>());
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String mostrarAcciones$action() {
        
        if( isInRole("empleados") ){
            setEmpleadoSeleccionado(getSessionBeanEMP().getEmpleadoSesion());
        }
        
        if (empleadoSeleccionado == null) {
            addMessage("RRHH", "Seleccione un empleado", TipoMensaje.INFORMACION);
            return null;
        }

        Integer tipo = null;
        if (estilo == null) {
            addMessage("RRHH", "Seleccione la acci&oacute;n que desea mostrar en el calendario", TipoMensaje.INFORMACION);
            return null;
        }

        if (estilo.equals("festivos")) {
            tipo = 1;
        } else if (estilo.equals("laborales")) {
            tipo = 2;
        } else if (estilo.equals("vacaciones")) {
            tipo = 3;
        } else if (estilo.equals("permisos")) {
            tipo = 4;
        } else if (estilo.equals("capacitaciones")) {
            tipo = 5;
        }
        fechas = planillaBean.cadenaDiasCalendario(tipo, empleadoSeleccionado, Long.parseLong(anio));
        System.out.println(fechas);
        return null;
    }

    public List<SelectItem> getListaAniosModel() {
        listaAniosModel = new ArrayList<SelectItem>(0);
        for (Integer i = 2000; i < 2100; i++) {
            listaAniosModel.add(new SelectItem(i.toString()));
        }
        return listaAniosModel;
    }

    public void setListaAniosModel(List<SelectItem> listaAniosModel) {
        this.listaAniosModel = listaAniosModel;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public List<Empleados> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Empleados getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Empleados empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }
}
