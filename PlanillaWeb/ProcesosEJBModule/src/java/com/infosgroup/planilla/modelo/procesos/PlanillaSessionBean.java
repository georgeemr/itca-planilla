/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.Departamento;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.FestivosProvincia;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleado;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.entidades.TipoPlanillaPK;
import com.infosgroup.planilla.modelo.estructuras.DetallePlanilla;
import com.infosgroup.planilla.modelo.facades.AccionPersonalFacade;
import com.infosgroup.planilla.modelo.facades.CompaniaFacade;
import com.infosgroup.planilla.modelo.facades.DetPlanillaFacade;
import com.infosgroup.planilla.modelo.facades.FestivosProvinciaFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.PlanillaFacade;
import com.infosgroup.planilla.modelo.facades.PuestoEmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.ResumenAsistenciaFacade;
import com.infosgroup.planilla.modelo.facades.SucursalFacade;
import com.infosgroup.planilla.modelo.facades.TipoAccionFacade;
import com.infosgroup.planilla.modelo.facades.TipoPlanillaFacade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.security.PermitAll;
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
    @EJB
    private TipoAccionFacade tipoAccionFacade;
    private Boolean rrhh = false;

    public Boolean getRrhh() {
        return rrhh;
    }

    public void setRrhh(Boolean rrhh) {
        this.rrhh = rrhh;
    }
    @EJB
    private FestivosProvinciaFacade festivosProvinciafacade;

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

    public List<Empleado> listaEmpleados() {
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

    @PermitAll
    public String cadenaDiasCalendario(Integer tipo, Empleado empleado, TipoAccion tipoAccion, Departamento departamento, Long anio) {
        GregorianCalendar calendario = null;
        List<FestivosProvincia> listaFestivos = null;

        listaFestivos = festivosProvinciafacade.listarPorAnio(anio);
        List<String> listaDiasFestivos = new ArrayList<String>(0);
        for (Integer i = 0; i < listaFestivos.size(); i++) {
            listaDiasFestivos.add("" + listaFestivos.get(i).getFestivosProvinciaPK().getMes() + "/" + listaFestivos.get(i).getFestivosProvinciaPK().getDia() + "/" + listaFestivos.get(i).getFestivosProvinciaPK().getAnio());
        }

        String fechas = "";
        switch (tipo) {
            case 1: // Dias festivos
                List<String> listaFinesSemana = new ArrayList<String>(0);
                calendario = (GregorianCalendar) Calendar.getInstance();
                calendario.set(Calendar.YEAR, anio.intValue());
                calendario.set(Calendar.DAY_OF_YEAR, 1);
                while (calendario.get(Calendar.YEAR) == anio.intValue()) {
                    if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        listaFinesSemana.add("" + (calendario.get(Calendar.MONTH) + 1) + "/" + calendario.get(Calendar.DAY_OF_MONTH) + "/" + calendario.get(Calendar.YEAR));
                    }
                    calendario.add(Calendar.DAY_OF_YEAR, 1);
                }

                for (Integer i = 0; i < listaFinesSemana.size(); i++) {
                    fechas += "'" + listaFinesSemana.get(i) + "'";
                    if (i < listaFinesSemana.size() - 1) {
                        fechas += ", ";
                    }
                }

//            listaFestivos = festivosProvinciafacade.listarPorAnio(anio);
                if (!listaDiasFestivos.isEmpty()) {
                    fechas += ", ";
                }
                for (Integer i = 0; i < listaDiasFestivos.size(); i++) {
                    //fechas += "'" + listaFestivos.get(i).getFestivosProvinciaPK().getMes() + "/" + listaFestivos.get(i).getFestivosProvinciaPK().getDia() + "/" + listaFestivos.get(i).getFestivosProvinciaPK().getAnio() + "'";
                    fechas += "'" + listaDiasFestivos.get(i) + "'";
                    if (i < listaFestivos.size() - 1) {
                        fechas += ", ";
                    }
                }
                break;
            case 2: // Dias laborales            
                List<String> listaDiasSemana = new ArrayList<String>(0);
                calendario = (GregorianCalendar) Calendar.getInstance();
                calendario.set(Calendar.YEAR, anio.intValue());
                calendario.set(Calendar.DAY_OF_YEAR, 1);
                while (calendario.get(Calendar.YEAR) == anio.intValue()) {
                    if (!((calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))) {
                        listaDiasSemana.add("" + (calendario.get(Calendar.MONTH) + 1) + "/" + calendario.get(Calendar.DAY_OF_MONTH) + "/" + calendario.get(Calendar.YEAR));
                    }
                    calendario.add(Calendar.DAY_OF_YEAR, 1);
                }

                listaDiasSemana.removeAll(listaDiasFestivos);

                for (Integer i = 0; i < listaDiasSemana.size(); i++) {
                    fechas += "'" + listaDiasSemana.get(i) + "'";
                    if (i < listaDiasSemana.size() - 1) {
                        fechas += ", ";
                    }
                }
                break;
        }
        return fechas;
    }

    
    
     public List<AccionPersonal> listarAccionporTipo(Long cia, Long tipo){
        return (tipo != 0) ? accionPersonalFacade.findByTipo(cia, tipo): accionPersonalFacade.findByNoAfecta(cia);
    }
    
    public List<TipoAccion> listarTiposAcciones(){
        return tipoAccionFacade.findAll();
    }
    
    public List<TipoAccion> listarTipoAccionAfecta(){
        return tipoAccionFacade.findByAfecta("S");
    }
    
    public List<TipoAccion> listarTipoAccionNoAfecta(){
        return tipoAccionFacade.findByAfecta("N");
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
    public String guardarSolAcc$action(AccionPersonal accion){
        try{
            accionPersonalFacade.create(accion);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
