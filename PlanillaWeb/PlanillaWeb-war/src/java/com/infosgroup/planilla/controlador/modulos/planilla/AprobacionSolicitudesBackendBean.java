/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "planilla$aprobacionSolicitudes")
@ViewScoped
public class AprobacionSolicitudesBackendBean extends AbstractJSFPage implements Serializable {

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<Empleados> listaJefes;
    private List<AccionPersonal> listaSolicitudes;
    private long emp = 0;

    @PostConstruct
    public void listarSolicitudesPendientes() {
        if (isInRole("rrhh")) {
            listaSolicitudes = planillaSessionBean.findSolicitudesByRRHH(getSessionBeanEMP().getEmpleadoSesion());
        } else if (isInRole("jefes")) {
            listaSolicitudes = planillaSessionBean.findSolicitudesByJefe(getSessionBeanEMP().getEmpleadoSesion());
        } else if (isInRole("empleados")) {
            listaSolicitudes = planillaSessionBean.findSolicitudesByEmpleado(getSessionBeanEMP().getEmpleadoSesion());
        } else {
            listaSolicitudes = new ArrayList<AccionPersonal>();
        }
    }

    public long getEmp() {
        return emp;
    }

    public void setEmp(long emp) {
        this.emp = emp;
    }

    public List<Empleados> getListaJefes() {
        listaJefes = planillaSessionBean.listarJefes();
        return listaJefes;
    }

    public void setListaJefes(List<Empleados> listaJefes) {
        this.listaJefes = listaJefes;
    }

    public List<AccionPersonal> getListaSolicitudes() {
//        if (emp != 0) {
//            listaSolicitudes = planillaSessionBean.listaPorAprobar(emp);
//        } 
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<AccionPersonal> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public String aprobar$action() {
        AccionPersonal accion = sessionBeanPLA.getAccionSeleccionada();
        planillaSessionBean.aprobarSolicitud$action(accion);
        mostrarMensaje(FacesMessage.SEVERITY_INFO, "La solicitud ha sido aprobada");
        return null;
    }

    public String rechazar$action() {
        AccionPersonal accion = sessionBeanPLA.getAccionSeleccionada();
        planillaSessionBean.rechazarSolicitud$action(accion);
        mostrarMensaje(FacesMessage.SEVERITY_INFO, "La solicitud ha sido rechazada");
        return null;
    }

    public String mostrar$action() {
//        listaSolicitudes = planillaSessionBean.listaPorAprobar(emp);
        sessionBeanPLA.setAprobados(planillaSessionBean.getRrhh());
        return null;
    }
}
