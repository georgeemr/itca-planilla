/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Agencias;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.FestivosXDepto;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PlanillaPK;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TipoAccionPK;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanillaPK;
import com.infosgroup.planilla.modelo.facades.AccionPersonalFacade;
import com.infosgroup.planilla.modelo.facades.CiasFacade;
import com.infosgroup.planilla.modelo.facades.FestivosXDeptoFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.PlanillaFacade;
import com.infosgroup.planilla.modelo.facades.ResumenAsistenciaFacade;
import com.infosgroup.planilla.modelo.facades.AgenciasFacade;
import com.infosgroup.planilla.modelo.facades.TipoAccionFacade;
import com.infosgroup.planilla.modelo.facades.TipoPlanillaFacade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@Stateless(name = "PlanillaSessionBean")
@LocalBean
public class PlanillaSessionBean {

    @EJB
    private PlanillaFacade planillaFacade;
    @EJB
    private TipoPlanillaFacade tipoPlaFacade;
    @EJB
    private ResumenAsistenciaFacade resumenFacade;
    @EJB
    private CiasFacade companiaFacade;
    @EJB
    private TipoPlanillaFacade tipoPlanillaFacade;
    @EJB
    private AgenciasFacade agenciasFacade;
    @EJB
    private AccionPersonalFacade accionPersonalFacade;
    /**
     * Comentado pq esta entidad ya no existe 13022012
     */
//    @EJB
//    private PuestoEmpleadoFacade puestoEmpleadoFacade;
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
    private FestivosXDeptoFacade festivosProvinciafacade;

//    public List<DetallePlanilla> getDetallesPla(Planilla planilla) {
//        return (planilla != null) ? detPlanillaFacade.findPlaDetalles(planilla.getPlanillaPK()) : new ArrayList<DetallePlanilla>(0);
//    }
    public List<ResumenAsistencia> getResumen(ResumenAsistencia c) {
        return (c != null) ? resumenFacade.findAll() : new ArrayList<ResumenAsistencia>();
    }

    public TiposPlanilla findByTipoID(TiposPlanillaPK tipoId) {
        return tipoPlaFacade.find(tipoId);
    }

    public List<Planilla> getPlaByTipo(TiposPlanilla tipo) {
        return planillaFacade.findByTipoPLanilla(tipo);
    }

    public List<ResumenAsistencia> getAsistencia() {
        return resumenFacade.findAll();
    }

    public List<Cias> listarCias() {
        return companiaFacade.findAll();
    }

    public List<TiposPlanilla> listarTipos(Cias cia) {
        return tipoPlanillaFacade.findByCompania(cia);
    }

    public List<Planilla> listarPlanilla(Cias cia) {
        return planillaFacade.findPlanillaByCias(cia);
    }

    public List<Planilla> listarPlanillaByTipoPlanilla(Cias cia, Short tipoPlanilla) {
        return planillaFacade.findPlanillaByTipoPlanilla(cia, tipoPlanilla);
    }

    public List<Agencias> listarAgencias(Cias cia) {
        return agenciasFacade.findByCompania(cia);
    }

    public List<ResumenAsistencia> listarResumenByPlanillaSucursal(Planilla planilla, Agencias agencia) {
        return resumenFacade.findAsistenciasByPlanillaAgencia(planilla, agencia);
    }

    public List<Empleados> listarJefes() {
        return empleadoFacade.findByJefes();
    }

    public List<Empleados> listaEmpleados(Cias cia) {
        return empleadoFacade.findEmpleadosByCias(cia);
    }

    public TipoAccion buscarTipoAccion(Short empresa, Short tipo) {
        TipoAccionPK pk = new TipoAccionPK();
        pk.setCodCia(empresa);
        pk.setCodTipoaccion(tipo);
        return tipoAccionFacade.find(pk);
    }

    public List<AccionPersonal> listaPorAprobar(Empleados empleado) {
        List<AccionPersonal> listaSolicitud = new ArrayList<AccionPersonal>(0);
        //13022012
//        PuestoEmpleado pueEmp = puestoEmpleadoFacade.findByEmpleado(empleado.getEmpleadosPK().getCodEmp(), empleado.getEmpleadosPK().getCodCia());
//        if (pueEmp.getPuestos().getPuestosPK().getCodPuesto() == 9) {
//            setRrhh(false);
//        } else {
//            listaSolicitud = accionPersonalFacade.findAprobacionJefe(empleado.getEmpleadosPK().getCodEmp(), empleado.getEmpleadosPK().getCodCia());
//            setRrhh(true);
//        }
        return listaSolicitud;
    }

    public String aprobarSolicitud$action(AccionPersonal accion) {
        if (accion.getStatus().matches("G")) {
            accion.setStatus("J");
            accionPersonalFacade.edit(accion);
        } else {
            accion.setStatus("B");
            accionPersonalFacade.edit(accion);
            mailBean.enviarCorreoElectronico(
                    "Sobre Solicitud de Personal",
                    "Se ha aprobado una solicitud a nombre de: " + accion.getEmpleados().getNombreCompleto(), accion.getEmpleados().getCorreo() + ":" + accion.getEmpleados()./*getJefe()*/getEmpleados().getCorreo());
        }
        return null;
    }

    public String rechazarSolicitud$action(AccionPersonal accion) {
        accion.setStatus("R");
        accionPersonalFacade.edit(accion);
        return null;
    }

    @PermitAll
    public String cadenaDiasCalendario(Integer tipo, Empleados empleado, Long anio) {
        GregorianCalendar calendario = null;
        List<FestivosXDepto> listaFestivos = null;
        List<AccionPersonal> listaAccionesPersonal = null;
        List<Date> listaFechas = null;

        TipoAccionPK tipoAccionPK = null;
        TipoAccion tipoAccion = null;

        listaFestivos = festivosProvinciafacade.listarPorAnio(anio);
        List<String> listaDiasFestivos = new ArrayList<String>(0);
        for (Integer i = 0; i < listaFestivos.size(); i++) {
            listaDiasFestivos.add("" + listaFestivos.get(i).getFestivosXDeptoPK().getMes() + "/" + listaFestivos.get(i).getFestivosXDeptoPK().getDia() + "/" + listaFestivos.get(i).getFestivosXDeptoPK().getAnio());
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

                if (!listaDiasFestivos.isEmpty()) {
                    fechas += ", ";
                }
                for (Integer i = 0; i < listaDiasFestivos.size(); i++) {
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
            case 3: // Vacaciones
                listaFechas = new ArrayList<Date>(0);
                listaAccionesPersonal = accionPersonalFacade.findByVacacionesEmpleadoAnio(empleado, anio);
                for (Integer i = 0; i < listaAccionesPersonal.size(); i++) {
                    AccionPersonal accionPersonal = listaAccionesPersonal.get(i);
                    Date fechaInicial = accionPersonal.getFechaInicial();
                    Date fechaFinal = accionPersonal.getFechaFinal();

                    if ((fechaInicial == null) || ((fechaInicial == null) && (fechaFinal == null))) // en el caso de que por alguna razon la fecha inicial sea nula :(
                    {
                        continue;
                    }

                    calendario = (GregorianCalendar) Calendar.getInstance();
                    calendario.setTime(fechaInicial);
                    do {
                        listaFechas.add(calendario.getTime());
                        calendario.add(Calendar.DAY_OF_YEAR, 1);
                    } while ((fechaFinal != null) && (calendario.getTime().before(fechaFinal) || calendario.getTime().equals(fechaFinal)));
                }

                for (Integer i = 0; i < listaFechas.size(); i++) {
                    calendario.setTime(listaFechas.get(i));
                    fechas += "'" + (calendario.get(Calendar.MONTH) + 1) + "/" + calendario.get(Calendar.DAY_OF_MONTH) + "/" + calendario.get(Calendar.YEAR) + "'";
                    if (i < listaFechas.size() - 1) {
                        fechas += ", ";
                    }
                }
                break;
            case 4: // Permisos
                listaFechas = new ArrayList<Date>(0);
                tipoAccionPK = new TipoAccionPK();
                tipoAccionPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                tipoAccionPK.setCodTipoaccion(new Short("5")); // Pemiso sin goce de sueldo
                tipoAccion = tipoAccionFacade.find(tipoAccionPK);

                listaAccionesPersonal = accionPersonalFacade.findByTipoAccionEmpleadoAnio(empleado, tipoAccion, anio);
                for (Integer i = 0; i < listaAccionesPersonal.size(); i++) {
                    AccionPersonal accionPersonal = listaAccionesPersonal.get(i);
                    Date fechaInicial = accionPersonal.getFechaInicial();
                    Date fechaFinal = accionPersonal.getFechaFinal();

                    if ((fechaInicial == null) || ((fechaInicial == null) && (fechaFinal == null))) // en el caso de que por alguna razon la fecha inicial sea nula :(
                    {
                        continue;
                    }

                    calendario = (GregorianCalendar) Calendar.getInstance();
                    calendario.setTime(fechaInicial);
                    do {
                        listaFechas.add(calendario.getTime());
                        calendario.add(Calendar.DAY_OF_YEAR, 1);
                    } while ((fechaFinal != null) && (calendario.getTime().before(fechaFinal) || calendario.getTime().equals(fechaFinal)));
                }

                for (Integer i = 0; i < listaFechas.size(); i++) {
                    calendario.setTime(listaFechas.get(i));
                    fechas += "'" + (calendario.get(Calendar.MONTH) + 1) + "/" + calendario.get(Calendar.DAY_OF_MONTH) + "/" + calendario.get(Calendar.YEAR) + "'";
                    if (i < listaFechas.size() - 1) {
                        fechas += ", ";
                    }
                }
                break;
            case 5: // Capacitaciones
                listaFechas = new ArrayList<Date>(0);
                tipoAccionPK = new TipoAccionPK();
                tipoAccionPK.setCodCia(empleado.getEmpleadosPK().getCodCia());
                tipoAccionPK.setCodTipoaccion(new Short("11")); // Capacitaciones
                tipoAccion = tipoAccionFacade.find(tipoAccionPK);

                listaAccionesPersonal = accionPersonalFacade.findByTipoAccionEmpleadoAnio(empleado, tipoAccion, anio);
                for (Integer i = 0; i < listaAccionesPersonal.size(); i++) {
                    AccionPersonal accionPersonal = listaAccionesPersonal.get(i);
                    Date fechaInicial = accionPersonal.getFechaInicial();
                    Date fechaFinal = accionPersonal.getFechaFinal();

                    calendario = (GregorianCalendar) Calendar.getInstance();
                    calendario.setTime(fechaInicial);
                    do {
                        listaFechas.add(calendario.getTime());
                        calendario.add(Calendar.DAY_OF_YEAR, 1);
                    } while ((fechaFinal != null) && (calendario.getTime().before(fechaFinal) || calendario.getTime().equals(fechaFinal)));
                }

                for (Integer i = 0; i < listaFechas.size(); i++) {
                    calendario.setTime(listaFechas.get(i));
                    fechas += "'" + (calendario.get(Calendar.MONTH) + 1) + "/" + calendario.get(Calendar.DAY_OF_MONTH) + "/" + calendario.get(Calendar.YEAR) + "'";
                    if (i < listaFechas.size() - 1) {
                        fechas += ", ";
                    }
                }
                break;
        }
        return fechas;
    }

    public List<AccionPersonal> listarAccionporTipo(Short cia, Short tipo) {
        return (tipo != null /*||tipo != 0 */) ? accionPersonalFacade.findByTipo(cia, tipo) : accionPersonalFacade.findByNoAfecta(cia);
    }

    public List<TipoAccion> listarTiposAcciones() {
        return tipoAccionFacade.findAll();
    }

    @PermitAll
    public List<TipoAccion> listarTipoAccionAfecta() {
        return tipoAccionFacade.findByAfecta("S");
    }

    @PermitAll
    public List<TipoAccion> listarTipoAccionNoAfecta() {
        return tipoAccionFacade.findByAfecta("N");
    }

    public String editar$action(ResumenAsistencia resumen) {
        try {
            resumenFacade.edit(resumen);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PermitAll
    public Planilla findPlanillaById(PlanillaPK planillaPK) {
        return planillaFacade.find(planillaPK);
    }

    @RolesAllowed({"empleados"})
    public List<AccionPersonal> findSolicitudesByEmpleado(Empleados empleado) {
        return accionPersonalFacade.findSolicitudesByEmpleado(empleado);
    }

    @RolesAllowed({"rrhh"})
    public List<AccionPersonal> findSolicitudesByRRHH(Empleados empleado) {
        return accionPersonalFacade.findSolicitudesByRRHH(empleado);
    }

    @RolesAllowed({"jefes"})
    public List<AccionPersonal> findSolicitudesByJefe(Empleados empleado) {
        return accionPersonalFacade.findSolicitudesByJefe(empleado);
    }

    @RolesAllowed({"jefes"})
    public void jefeEditaSolicitud(AccionPersonal a, String estado) {
        a.setAprobadoJefe(new java.util.Date());
        a.setStatus(estado);
        accionPersonalFacade.edit(a);
    }

    @RolesAllowed({"rrhh"})
    public void rrhhEditaSolicitud(AccionPersonal a, String estado) {
        a.setAprobadoRh(new java.util.Date());
        a.setStatus(estado);
        accionPersonalFacade.edit(a);
    }

    @PermitAll
    public List<AccionPersonal> getAccionesByRol(Empleados empleado) {
        if (FacesContext.getCurrentInstance().getExternalContext().isUserInRole("rrhh")) {
            return findSolicitudesByRRHH(empleado);
        } else if (FacesContext.getCurrentInstance().getExternalContext().isUserInRole("jefes")) {
            return findSolicitudesByJefe(empleado);
        } else if (FacesContext.getCurrentInstance().getExternalContext().isUserInRole("empleados")) {
            return findSolicitudesByEmpleado(empleado);
        } else {
            return new ArrayList<AccionPersonal>();
        }
    }
}
