/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleado;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.entidades.TipoPlanillaPK;
import com.infosgroup.planilla.modelo.estructuras.DetallePlanilla;
import com.infosgroup.planilla.modelo.facades.AccionPersonalFacade;
import com.infosgroup.planilla.modelo.facades.CompaniaFacade;
import com.infosgroup.planilla.modelo.facades.DetPlanillaFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.PlanillaFacade;
import com.infosgroup.planilla.modelo.facades.PuestoEmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.ResumenAsistenciaFacade;
import com.infosgroup.planilla.modelo.facades.SucursalFacade;
import com.infosgroup.planilla.modelo.facades.TipoPlanillaFacade;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author root
 */
@Stateless(name = "PlanillaSessionBean")
@LocalBean
public class PlanillaSessionBean {

    @EJB
    private DetPlanillaFacade detPlanillaFacade;
    @EJB
    private PlanillaFacade planillaFacade;
    @EJB
    private TipoPlanillaFacade tipoPlaFacade;
    @EJB
    private ResumenAsistenciaFacade resumenFacade;
    @EJB
    private CompaniaFacade companiaFacade;
    @EJB
    private TipoPlanillaFacade tipoPlanillaFacade;
    @EJB
    private SucursalFacade sucursalFacade;
    @EJB
    private AccionPersonalFacade accionPersonalFacade;
    @EJB
    private PuestoEmpleadoFacade puestoEmpleadoFacade;
    @EJB
    private EmpleadoFacade empleadoFacade;
    @EJB
    private MailStatelessBean mailBean;
    private Boolean rrhh = false;

    public Boolean getRrhh() {
        return rrhh;
    }

    public void setRrhh(Boolean rrhh) {
        this.rrhh = rrhh;
    }

    public List<DetallePlanilla> getDetallesPla(Long pla, Long anio, Long mes) {
        return (pla != 0) ? detPlanillaFacade.findPlaDetalles(pla, anio, mes) : new ArrayList<DetallePlanilla>(0);
    }

    public List<ResumenAsistencia> getResumen(ResumenAsistencia c) {
        return (c != null) ? resumenFacade.findAll() : new ArrayList<ResumenAsistencia>();
    }

    public TipoPlanilla findByTipoID(TipoPlanillaPK tipoId) {
        return tipoPlaFacade.find(tipoId);
    }

    public List<Planilla> getPlaByTipo(TipoPlanilla tipo) {
        return planillaFacade.findByTipoPLanilla(tipo);
    }

    public List<ResumenAsistencia> getAsistencia() {
        return resumenFacade.findAll();
    }

    public List<Compania> listarCias() {
        return companiaFacade.findAll();
    }

    public List<TipoPlanilla> listarTipos() {
        return tipoPlanillaFacade.findAll();
    }

    public List<Planilla> listarPlanilla() {
        return planillaFacade.findAll();
    }

    public List<Sucursal> listarSucursal() {
        return sucursalFacade.findAll();
    }

    public List<ResumenAsistencia> listarResumenByParam(Integer empresa, Integer sucursal, Integer planilla) {
        return resumenFacade.findAsistencias(empresa, sucursal, planilla);
    }

    public List<Empleado> listarJefes() {
        return empleadoFacade.findByJefes();
    }
    
    public List<Empleado> listaEmpleados(){
        return empleadoFacade.findAll();
    }

    public List<AccionPersonal> listaPorAprobar(Long emp) {
        List<AccionPersonal> listaSolicitud = new ArrayList<AccionPersonal>(0);
        long cia = 1;
        PuestoEmpleado pueEmp = puestoEmpleadoFacade.findByEmpleado(emp, cia);
        if (pueEmp.getPuesto().getPuestoPK().getCodPuesto() == 9) {
            listaSolicitud = accionPersonalFacade.findAprobacionRRHH();
            setRrhh(false);
        } else {
            listaSolicitud = accionPersonalFacade.findAprobacionJefe(emp, cia);
            setRrhh(true);
        }
        return listaSolicitud;
    }

    public String editar$action(ResumenAsistencia resumen) {
        try {
            resumenFacade.edit(resumen);
            //resumenFacade.refresh(resumen);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String aprobarSolicitud$action(AccionPersonal accion) {
        if (accion.getStatus().matches("G")) {
            accion.setStatus("J");
            accionPersonalFacade.edit(accion);
        } else {
            accion.setStatus("B");
            accionPersonalFacade.edit(accion);
            mailBean.enviarCorreoElectronico("Sobre Solicitud de Personal", "Se ha aprobado una solicitud a nombre de: " 
                    + accion.getPuestoEmpleado().getEmpleado().getNombreCompleto(), 
                    accion.getPuestoEmpleado().getEmpleado().getCorreo() + ":" + accion.getEmpleado().getCorreo());
        }
        return null;
    }

    public String rechazarSolicitud$action(AccionPersonal accion) {
        accion.setStatus("R");
        accionPersonalFacade.edit(accion);
        return null;
    }
}
