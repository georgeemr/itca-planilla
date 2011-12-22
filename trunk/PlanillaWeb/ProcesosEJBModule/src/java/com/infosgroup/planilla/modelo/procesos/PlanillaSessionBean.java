/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.AccionPersonalPK;
import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.FestivosProvincia;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleado;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TipoAccionPK;
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

    public List<DetallePlanilla> getDetallesPla(Planilla planilla) {
        return (planilla != null) ? detPlanillaFacade.findPlaDetalles(planilla.getPlanillaPK()) : new ArrayList<DetallePlanilla>(0);
//return (planilla != null) ? planilla.getDetPlanillaList() : new ArrayList<DetallePlanilla>(0);
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

    public List<ResumenAsistencia> listarResumenByPlanillaSucursal(Planilla planilla, Sucursal sucursal) {
        return resumenFacade.findAsistenciasByPlanillaSucursal(planilla, sucursal);
    }

    public List<Empleado> listarJefes() {
        return empleadoFacade.findByJefes();
    }

    public List<Empleado> listaEmpleados() {
        return empleadoFacade.findAll();
    }

    public TipoAccion buscarTipoAccion(long tipo) {
        TipoAccionPK pk = new TipoAccionPK();
        pk.setCodCia(1);
        pk.setCodTipoaccion(tipo);
        return tipoAccionFacade.find(pk);
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
            mailBean.enviarCorreoElectronico("Sobre Solicitud de Personal", "Se ha aprobado una solicitud a nombre de: " + accion.getPuestoEmpleado().getEmpleado().getNombreCompleto(), accion.getPuestoEmpleado().getEmpleado().getCorreo() + ":" + accion.getEmpleado().getCorreo());
        }
        return null;
    }

    public String rechazarSolicitud$action(AccionPersonal accion) {
        accion.setStatus("R");
        accionPersonalFacade.edit(accion);
        return null;
    }

    @PermitAll
    public String cadenaDiasCalendario(Integer tipo, Empleado empleado, Long anio) {
        GregorianCalendar calendario = null;
        List<FestivosProvincia> listaFestivos = null;
        List<AccionPersonal> listaAccionesPersonal = null;
        List<Date> listaFechas = null;

        TipoAccionPK tipoAccionPK = null;
        TipoAccion tipoAccion = null;

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
                tipoAccionPK.setCodCia(1L);
                tipoAccionPK.setCodTipoaccion(5L); // Pemiso sin goce de sueldo
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
                tipoAccionPK.setCodCia(1L);
                tipoAccionPK.setCodTipoaccion(11L); // Capacitaciones
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

    public List<AccionPersonal> listarAccionporTipo(Long cia, Long tipo) {
        return (tipo != 0) ? accionPersonalFacade.findByTipo(cia, tipo) : accionPersonalFacade.findByNoAfecta(cia);
    }

    public List<TipoAccion> listarTiposAcciones() {
        return tipoAccionFacade.findAll();
    }

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

    public String guardarSolAcc$action(TipoAccion tipo, Empleado emp, Empleado jefe, Date fecha, String obsv, Long cantidad, String devengadas, Long dias, Date fechaCaja, Date fechaFinal, Date fechaInicial, Long hora, Date periodo, Date periodoFinal, Long sueldoAnterior, String tipoPermiso) {
        long cia = 1;
        PuestoEmpleado pueEmp = puestoEmpleadoFacade.findByEmpleado(emp.getEmpleadoPK().getCodEmp(), cia);
        AccionPersonal nuevaAccion = new AccionPersonal();
        AccionPersonalPK nuevaPK = new AccionPersonalPK();
        Calendar c = Calendar.getInstance();
        Integer anio = c.get(Calendar.YEAR);
        Integer mes = c.get(Calendar.MONTH);
        try {
            nuevaPK.setAnio(Long.parseLong(anio.toString()));
            nuevaPK.setMes(1);
            nuevaPK.setCodCia(cia);
            nuevaPK.setNumPlanilla(1);
            nuevaPK.setCodTipoaccion(tipo.getTipoAccionPK().getCodTipoaccion());
            nuevaPK.setIdEmpleado(emp.getEmpleadoPK().getCodEmp());
            nuevaPK.setIdPuesto(pueEmp.getPuestoEmpleadoPK().getIdPuesto());
            nuevaPK.setIdSucursal(pueEmp.getPuestoEmpleadoPK().getIdSucursal());
            nuevaPK.setIdTipoPuesto(pueEmp.getPuestoEmpleadoPK().getIdTipoPuesto());
            nuevaPK.setCorrelativo(accionPersonalFacade.max() + 1);

            nuevaAccion.setAccionPersonalPK(nuevaPK);
            nuevaAccion.setPuestoEmpleado(pueEmp);
            nuevaAccion.setTipoAccion(tipo);
            nuevaAccion.setEmpleado(jefe);
            nuevaAccion.setFecha(fecha);
            nuevaAccion.setObservacion(obsv);
            nuevaAccion.setStatus("G");
            nuevaAccion.setCantidad(cantidad);
            nuevaAccion.setDevengadas(devengadas);
            nuevaAccion.setDias(dias);
            nuevaAccion.setFechaCanje(fechaCaja);
            nuevaAccion.setFechaFinal(fechaFinal);
            nuevaAccion.setFechaInicial(fechaInicial);
            nuevaAccion.setHoras(hora);
            nuevaAccion.setPeriodo(periodo);
            nuevaAccion.setPeriodoFinal(periodoFinal);
            nuevaAccion.setSueldoAnterior(sueldoAnterior);
            nuevaAccion.setTipoPermiso(tipoPermiso);

            accionPersonalFacade.create(nuevaAccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
