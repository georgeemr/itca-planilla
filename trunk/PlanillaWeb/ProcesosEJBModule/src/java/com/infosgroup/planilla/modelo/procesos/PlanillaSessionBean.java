/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.facades.*;
import com.infosgroup.planilla.modelo.procesos.accionesDePersonal.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @EJB
    private EmpleadoFacade empleadoFacade;
    @EJB
    private MailStatelessBean mailBean;
    @EJB
    private TipoAccionFacade tipoAccionFacade;
    @EJB
    private ProgramacionPlaFacade programacionPlaFacade;
    @EJB
    private FestivosXDeptoFacade festivosProvinciafacade;
    @EJB
    private DepartamentoFacade departamentoFacade;
    @EJB
    private PuestoFacade puestosFacade;
    @EJB
    private CausasRenunciaFacade causasRenunciaFacade;
    @EJB
    private DeduccionesPrestacionesFacade deduccionesPrestacionesFacade;
    @EJB
    private MovDpFacade movDpFacade;
    @EJB
    private TipoAusentFacade tipoAusentFacade;

    @PermitAll
    public List<TipoAusent> findListaTipoAusent() {
        List<TipoAusent> t = tipoAusentFacade.findAll();
        return t != null ? t : new ArrayList<TipoAusent>();
    }

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

    public List<TiposPlanilla> listarTiposByEmpleado(Empleados empleado) {
        return tipoPlanillaFacade.findByEmpleados(empleado);
    }

    public List<Planilla> listarPlanilla(Cias cia) {
        return planillaFacade.findPlanillaByCias(cia);
    }

    public List<Planilla> listarPlanillaByTipoPlanilla(Cias cia, Short tipoPlanilla) {
        return planillaFacade.findPlanillaByTipoPlanilla(cia, tipoPlanilla);
    }

    @PermitAll
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

    public String aprobarSolicitud$action(AccionPersonal accion) {
        if (accion.getStatus().matches("G")) {
            accion.setStatus("J");
            accionPersonalFacade.edit(accion);
        } else {
            accion.setStatus("B");
            accionPersonalFacade.edit(accion);
            mailBean.enviarCorreoElectronico(
                    "Sobre Solicitud de Personal",
                    "Se ha aprobado una solicitud a nombre de: " + accion.getEmpleados().getNombreCompleto(), accion.getEmpleados().getCorreo() + ":" + accion.getEmpleados()./*
                     * getJefe()
                     */getEmpleados().getCorreo());
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

    @PermitAll
    public List<AccionPersonal> listarAccionporTipo(Short cia, Short tipo) {
        return (tipo != null) ? accionPersonalFacade.findByTipo(cia, tipo) : accionPersonalFacade.findByNoAfecta(cia);
    }

    @PermitAll
    public List<TipoAccion> listarTiposAcciones(Cias cias) {
        return tipoAccionFacade.listarTipoAccionByCias(cias);
    }

    @PermitAll
    public List<TipoAccion> listarTipoAccionActivas(Cias cias) {
        return tipoAccionFacade.listarTipoAccionActivas(cias);
    }

    @PermitAll
    public void editarResumenAsistencia(ResumenAsistencia resumen) {
        try {
            resumenFacade.edit(resumen);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PermitAll
    public Planilla findPlanillaById(PlanillaPK planillaPK) {
        return planillaFacade.find(planillaPK);
    }

    @RolesAllowed({"empleados", "rrhh", "jefes"})
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
    public void jefeEditaSolicitud(AccionPersonal a, String estado) throws Exception {
        a.setAprobadoJefe(estado);
        a.setfApruebaJefe(new java.util.Date());
        a.setStatus(estado);
        accionPersonalFacade.edit(a);
        verificarAprobacion(a);
    }

    @RolesAllowed({"rrhh"})
    public void rrhhEditaSolicitud(AccionPersonal a, String estado) throws Exception {
        a.setAprobadoRh(estado);
        a.setfApruebaRh(new java.util.Date());
        a.setStatus(estado);
        accionPersonalFacade.edit(a);
        verificarAprobacion(a);
    }

    @RolesAllowed({"rrhh", "jefes", "empleados"})
    public void editarSolicitud(AccionPersonal a) {
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

    @PermitAll
    public List<ProgramacionPla> getProgramacionPlaByTipo(Short empresa, Short tipoPlanilla) {
        return programacionPlaFacade.getProgramacionPlaByTipo(empresa, tipoPlanilla);
    }

    @PermitAll
    public List<ProgramacionPla> getProgramacionPlaSinEstado(Short empresa, Short tipoPlanilla) {
        return programacionPlaFacade.getProgramacionPlaSinEstado(empresa, tipoPlanilla);
    }

    public List<Departamentos> findDepartamentos(Cias cias) {
        return departamentoFacade.findDepartamentosByCias(cias);
    }

    public List<Puestos> findPuestos(Cias cias) {
        return puestosFacade.findPuestoByEmpresa(cias);
    }

    @PermitAll
    public Integer totalAfectadosDepartamentos(Departamentos departamento) {
        return empleadoFacade.totalAfectadosDepartamentos(departamento);
    }

    @PermitAll
    public Integer totalAfectadosTipoPlanilla(TiposPlanilla tipoPlanilla) {
        return empleadoFacade.totalAfectadosTipoPlanilla(tipoPlanilla);
    }

    @PermitAll
    public Integer totalAfectadosRangoSalarios(Cias cias, BigDecimal s1, BigDecimal s2) {
        return empleadoFacade.totalAfectadosRangosSalario(cias, s1, s2);
    }

    @PermitAll
    public List<Empleados> listaAfectadosDepartamentos(Departamentos departamento) {
        return empleadoFacade.afectadosDepartamentos(departamento);
    }

    @PermitAll
    public List<Empleados> findEmpleadosByDepartamentos(Departamentos departamento) {
        return empleadoFacade.findByDepartamentos(departamento);
    }

    @PermitAll
    public List<Empleados> findEmpleadosByPuestos(Puestos puesto) {
        return empleadoFacade.findByPuestos(puesto);
    }

    @PermitAll
    public List<Empleados> listaAfectadosTipoPlanilla(TiposPlanilla tipoPlanilla) {
        return empleadoFacade.afectadosTipoPlanilla(tipoPlanilla);
    }

    @PermitAll
    public List<Empleados> listarAfectadosRangoSalarios(Cias cias, BigDecimal s1, BigDecimal s2) {
        return empleadoFacade.afectadosRangosSalario(cias, s1, s2);
    }

    @PermitAll
    public void registrarAccionPersonalColectiva(List<AccionPersonal> solicitudes) {
        for (AccionPersonal a : solicitudes) {
            a.setAprobadoRh("N");
            a.setAprobadoJefe("N");
            accionPersonalFacade.create(a);
        }
    }

    @PermitAll
    public List<CausasRenuncia> findCausasRenunciasByCias(Cias cias) {
        return causasRenunciaFacade.findByCias(cias);
    }

    @PermitAll
    public List<TipoAccion> listarTipoAccionAfectaPlanilla(Cias cias, String rol) {
        return tipoAccionFacade.listarTipoAccionAfectaPlanilla(cias, rol);
    }

    @PermitAll
    public List<TipoAccion> listarTipoAccionNoAfectaPlanilla(Cias cias, String rol) {
        return tipoAccionFacade.listarTipoAccionNoAfectaPlanilla(cias, rol);
    }

    @PermitAll
    public ProgramacionPla findProgramacionPlaByPK(ProgramacionPlaPK pk) {
        return programacionPlaFacade.find(pk);
    }

    @PermitAll
    public List<DeducPresta> findDeducPrestaByCias(Cias cias) {
        return deduccionesPrestacionesFacade.findByCias(cias);
    }

    @PermitAll
    public DeducPresta findDeducPrestaByPK(DeducPrestaPK pk) {
        return deduccionesPrestacionesFacade.find(pk);
    }

    @PermitAll
    public ResumenAsistencia existeEnResumen(ResumenAsistenciaPK pk) {
        return resumenFacade.find(pk);
    }

    @PermitAll
    public void guardarResumenAsistencia(ResumenAsistencia resumenAsistencia) {
        resumenFacade.create(resumenAsistencia);
    }

    @PermitAll
    public void cargarDatosResumenAsistencia(List<MovDp> listMovdp, Short empresa, Short anio, Short mes, Short tipoPlanilla, Short numeroplanilla, Short deduccionPrestacion) {
        // Eliminando movimientos existentes
        for (MovDp e : movimientosEliminarDP(empresa, anio, mes, tipoPlanilla, numeroplanilla, deduccionPrestacion)) {
            eliminarMovimientosDP(e);
        }
        // Insertando los movimientos
        for (MovDp m : listMovdp) {
            m.setMovDpPK(getMovDpPK(new MovDpPK(empresa, anio, mes, numeroplanilla, 0)));
            guardarMovimientosDP(m);
        }
    }

    @PermitAll
    public List<MovDp> movimientosEliminarDP(Short empresa, Short anio, Short mes, Short tipoPlanilla, Short numeroPlanilla, Short deduccionPrestacion) {
        return movDpFacade.movimientosEliminarDP(empresa, anio, mes, tipoPlanilla, numeroPlanilla, deduccionPrestacion);
    }

    @PermitAll
    public void guardarMovimientosDP(MovDp movDP) {
        movDpFacade.create(movDP);
    }

    @PermitAll
    public void eliminarMovimientosDP(MovDp movDP) {
        movDpFacade.remove(movDP);
    }

    @PermitAll
    public MovDpPK getMovDpPK(MovDpPK movDP) {
        return movDpFacade.getMovDpPK(movDP);
    }

    @PermitAll
    public List<ResumenAsistencia> findResumenAsistenciaByTipoPlanilla(short codCia, short anio, short mes, short numPlanilla, short codTipopla) {
        return findResumenAsistenciaByTipoPlanilla(codCia, anio, mes, numPlanilla, codTipopla);
    }

    @PermitAll
    public Empleados findEmpleadosByID(EmpleadosPK pk) {
        return empleadoFacade.find(pk);
    }

    @PermitAll
    public List<TipoAccion> listaTipoAccionRetiro(Cias cias) {
        return tipoAccionFacade.findByTipoAccionRetiro(cias);
    }

    @PermitAll
    public String verificarAprobacion(AccionPersonal accionPersonal) throws Exception {
        String mensaje = "Solicitud Aplicada.";
        try {
            if (accionPersonal.getTipoAccion().getFirmaJefe().equals("S") && accionPersonal.getTipoAccion().getFirmaRh().equals("S")) {
                if (accionPersonal.getAprobadoJefe().equals("A") && accionPersonal.getAprobadoRh().equals("A")) {
                    ejecutarAccionSolicitud(accionPersonal);
                    return mensaje;
                } else {
                    mensaje = "Aun existe una aprobación pendiente para efectuar esta acción";
                }
            } else if (accionPersonal.getTipoAccion().getFirmaJefe().equals("S") && accionPersonal.getTipoAccion().getFirmaRh().equals("N")) {
                if (accionPersonal.getAprobadoJefe().equals("A")) {
                    ejecutarAccionSolicitud(accionPersonal);
                    return mensaje;
                } else {
                    mensaje = "";
                }
            } else if (accionPersonal.getTipoAccion().getFirmaJefe().equals("N") && accionPersonal.getTipoAccion().getFirmaRh().equals("S")) {
                if (accionPersonal.getAprobadoRh().equals("A")) {
                    ejecutarAccionSolicitud(accionPersonal);
                    return mensaje;
                } else {
                    mensaje = "";
                }
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            e.printStackTrace();
        }
        return mensaje;
    }

    @PermitAll
    public void ejecutarAccionSolicitud(AccionPersonal accionPersonal) throws Exception {
        AccionSolicitud accionSolicitud = null;
        switch (accionPersonal.getAccionPersonalPK().getCodTipoaccion()) {
            case 6:// 6	NOMBRAMIENTO INTERNO
                accionSolicitud = new NombramientoAction(accionPersonal);
                break;
            default:
                break;
        }
        accionSolicitud.efectuar();
    }

    @PermitAll
    public void actualizarEmpleado(Empleados empleados) {
        empleadoFacade.edit(empleados);
    }

    @PermitAll
    public List<MovDp> findDeduccionesPresta(Planilla planilla, String sumaResta) {
        return movDpFacade.movimientosByPlanilla(planilla, sumaResta);
    }

    @PermitAll
    public List<ProgramacionPla> findProPlaByCia(Cias cia) {
        return programacionPlaFacade.getProgramacionPlaByCia(cia);
    }

    @PermitAll
    public List<Planilla> findByProPla(ProgramacionPla proPla) {
        return planillaFacade.findPlanillaByUnidad(proPla);
    }

    @PermitAll
    public List<Planilla> findByProgramacionPla(ProgramacionPla programacionPla) {
        return planillaFacade.findPlanillaByProgramacion(programacionPla);
    }

    @PermitAll
    public List<ResumenAsistencia> findResumenAsistencia(ProgramacionPla programacionPla, Short departamento, Short sucursal) {
        return resumenFacade.findResumenAsistencia(programacionPla, departamento, sucursal);
    }

    @PermitAll
    public List<Planilla> findByProPlaAndDepto(ProgramacionPla proPla, Short depto) {
        return planillaFacade.findPlanillaByProAndDep(proPla, depto);
    }

    @PermitAll
    public List<Departamentos> findDepByPla(ProgramacionPla proPla) {
        return departamentoFacade.findDepartamentosByPlanilla(proPla);
    }

    @PermitAll
    public List<Empleados> findJefesByDepto(Departamentos depto) {
        return empleadoFacade.findJefesByDepto(depto);
    }

    @PermitAll
    public Departamentos findDeptoById(DepartamentosPK pk) {
        return departamentoFacade.find(pk);
    }

    @PermitAll
    public void eliminarResumenAsistencia(ResumenAsistencia resumenAsistencia) {
        resumenFacade.remove(resumenAsistencia);
    }

    @PermitAll
    public void eliminarPlanilla(List<ResumenAsistencia> l) {
        resumenFacade.eliminarPlanilla(l);
    }

    @PermitAll
    public List<Planilla> findPlaByEmp(Empleados emp, Short tipoPlanilla) {
        return planillaFacade.findByEmpleado(emp, tipoPlanilla);
    }
}