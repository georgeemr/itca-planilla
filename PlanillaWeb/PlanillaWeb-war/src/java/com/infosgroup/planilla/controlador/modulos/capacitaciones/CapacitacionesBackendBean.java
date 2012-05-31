/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.capacitaciones;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.CapacitacionesSessionBean;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "capacitaciones$capacitaciones")
@ViewScoped
public class CapacitacionesBackendBean extends AbstractJSFPage implements Serializable
{

    @EJB
    private CapacitacionesSessionBean capacitacionSessionBean;
    @EJB
    private MailStatelessBean mailStatelessBean;
// ==
    @EJB
    private ReclutamientoSessionBean reclutamientoFacade;
    // ==    
    private Boolean isError;
    private String status = "G";
    private String nombre;
    private Date fechaInicial;
    private Date fechaFinal;
    private BigDecimal duracion;
    private String impartido;
    private String razon;
//private BigDecimal costoRazon;
    private String codCap;
    private Short inst;
    private Integer codArea;
    private Integer codTema;
    private Long codCapacitador;
//planilla para otras acciones
    private String nomCapacitacion;
    private String nomInst;
    private String nomEmp;
    private String nomArea;
    private String nomTema;
    private String nomCapacitador;
    private BigDecimal notaCapacitacion;
    private List<CapacitacionXEmpleado> listaDetalle;
    private List<Empleados> listaEmpleado;
    private List<CapacitacionAsistencia> listaAsistencia;
    private CapacitacionXEmpleado detalleSelec;
    private List<Instituciones> listaInst;
    private List<Capacitacion> listaCap;
    private List<CapacitacionAreas> listaArea;
    private List<CapacitacionTemas> listaTemas;
    private List<Capacitadores> listaCapacitadores;
//    private DataTable tableCapacitaciones;
    private SelectItem[] estadoCapacitacion =
        {
        new SelectItem("G", "Grabado"), new SelectItem("A", "Aprobado"), new SelectItem("R", "Rechazado"), new SelectItem("RE", "Realizado"), new SelectItem("N", "Notificado")
        };
    private Capacitacion capacitacionSeleccionada;
    private Cias empresa;
    private Integer estadoAccion;
    private Empleados empleadoSeleccionado;
    private CapacitacionXEmpleado detalleCapSeleccionada;
    private CapacitacionAsistencia asistenciaSeleccionada;

    public CapacitacionesBackendBean()
    {
    }

    @PostConstruct
    public void _init()
    {
        setEmpresa(getSessionBeanADM().getCompania());
        setListaEmpleado(capacitacionSessionBean.findEmpByEmpresa(getEmpresa()));
    }

    public CapacitacionAsistencia getAsistenciaSeleccionada()
    {
        return asistenciaSeleccionada;
    }

    public void setAsistenciaSeleccionada(CapacitacionAsistencia asistenciaSeleccionada)
    {
        this.asistenciaSeleccionada = asistenciaSeleccionada;
    }

    public Empleados getEmpleadoSeleccionado()
    {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Empleados empleadoSeleccionado)
    {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public CapacitacionXEmpleado getDetalleCapSeleccionada()
    {
        return detalleCapSeleccionada;
    }

    public void setDetalleCapSeleccionada(CapacitacionXEmpleado detalleCapSeleccionada)
    {
        this.detalleCapSeleccionada = detalleCapSeleccionada;
    }

//    public Integer getEstadoAccion() {
//        return estadoAccion;
//    }
//
//    public void setEstadoAccion(Integer estadoAccion) {
//        this.estadoAccion = estadoAccion;
//    }
    public Cias getEmpresa()
    {
        return empresa;
    }

    public void setEmpresa(Cias empresa)
    {
        this.empresa = empresa;
    }

    public Capacitacion getCapacitacionSeleccionada()
    {
        return capacitacionSeleccionada;
    }

    public void setCapacitacionSeleccionada(Capacitacion capacitacionSeleccionada)
    {
        this.capacitacionSeleccionada = capacitacionSeleccionada;
    }

    public SelectItem[] getEstadoCapacitacion()
    {
        return estadoCapacitacion;
    }

    public void setEstadoCapacitacion(SelectItem[] estadoCapacitacion)
    {
        this.estadoCapacitacion = estadoCapacitacion;
    }

    public String getCodCap()
    {
        return codCap;
    }

    public void setCodCap(String codCap)
    {
        this.codCap = codCap;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

//    public BigDecimal getCostoRazon() {
//        return costoRazon;
//    }
//
//    public void setCostoRazon(BigDecimal costoRazon) {
//        this.costoRazon = costoRazon;
//    }
    public BigDecimal getDuracion()
    {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion)
    {
        this.duracion = duracion;
    }

    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial()
    {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial)
    {
        this.fechaInicial = fechaInicial;
    }

    public String getImpartido()
    {
        return impartido;
    }

    public void setImpartido(String impartido)
    {
        this.impartido = impartido;
    }

    public Short getInst()
    {
        return inst;
    }

    public void setInst(Short inst)
    {
        this.inst = inst;
    }

    public Boolean getIsError()
    {
        return isError;
    }

    public void setIsError(Boolean isError)
    {
        this.isError = isError;
    }

    public Integer getCodArea()
    {
        return codArea;
    }

    public void setCodArea(Integer codArea)
    {
        this.codArea = codArea;
    }

    public Integer getCodTema()
    {
        return codTema;
    }

    public void setCodTema(Integer codTema)
    {
        this.codTema = codTema;
    }

    public Long getCodCapacitador()
    {
        return codCapacitador;
    }

    public void setCodCapacitador(Long codCapacitador)
    {
        this.codCapacitador = codCapacitador;
    }

    public CapacitacionXEmpleado getDetalleSelec()
    {
        return detalleSelec;
    }

    public void setDetalleSelec(CapacitacionXEmpleado detalleSelec)
    {
        this.detalleSelec = detalleSelec;
    }

    public List<CapacitacionAsistencia> getListaAsistencia()
    {
        return listaAsistencia;
    }

    public void setListaAsistencia(List<CapacitacionAsistencia> listaAsistencia)
    {
        this.listaAsistencia = listaAsistencia;
    }

    public List<CapacitacionXEmpleado> getListaDetalle()
    {
        return listaDetalle;
    }

    public void setListaDetalle(List<CapacitacionXEmpleado> listaDetalle)
    {
        this.listaDetalle = listaDetalle;
    }

    public List<Empleados> getListaEmpleado()
    {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleados> listaEmpleado)
    {
        this.listaEmpleado = listaEmpleado;
    }

    public String getNomArea()
    {
        return nomArea;
    }

    public void setNomArea(String nomArea)
    {
        this.nomArea = nomArea;
    }

    public String getNomCapacitacion()
    {
        return nomCapacitacion;
    }

    public void setNomCapacitacion(String nomCapacitacion)
    {
        this.nomCapacitacion = nomCapacitacion;
    }

    public String getNomCapacitador()
    {
        return nomCapacitador;
    }

    public void setNomCapacitador(String nomCapacitador)
    {
        this.nomCapacitador = nomCapacitador;
    }

    public String getNomEmp()
    {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp)
    {
        this.nomEmp = nomEmp;
    }

    public String getNomInst()
    {
        return nomInst;
    }

    public void setNomInst(String nomInst)
    {
        this.nomInst = nomInst;
    }

    public String getNomTema()
    {
        return nomTema;
    }

    public void setNomTema(String nomTema)
    {
        this.nomTema = nomTema;
    }

    public BigDecimal getNotaCapacitacion()
    {
        return notaCapacitacion;
    }

    public void setNotaCapacitacion(BigDecimal notaCapacitacion)
    {
        this.notaCapacitacion = notaCapacitacion;
    }

    public List<Instituciones> getListaInst()
    {
        listaInst = capacitacionSessionBean.findInstByEmpresa(getEmpresa());
        return listaInst;
    }

    public void setListaInst(List<Instituciones> listaInst)
    {
        this.listaInst = listaInst;
    }

    public List<Capacitacion> getListaCap()
    {
        listaCap = capacitacionSessionBean.findCapByEmpresa(getEmpresa());
        return listaCap;
    }

    public void setListaCap(List<Capacitacion> listaCap)
    {
        this.listaCap = listaCap;
    }

    public List<CapacitacionAreas> getListaArea()
    {
        listaArea = capacitacionSessionBean.findAreaByCap(getEmpresa());
        return listaArea;
    }

    public void setListaArea(List<CapacitacionAreas> listaArea)
    {
        this.listaArea = listaArea;
    }

    public List<Capacitadores> getListaCapacitadores()
    {
        listaCapacitadores = capacitacionSessionBean.findCapacitadoresByCap(getEmpresa());
        return listaCapacitadores;
    }

    public void setListaCapacitadores(List<Capacitadores> listaCapacitadores)
    {
        this.listaCapacitadores = listaCapacitadores;
    }

    public List<CapacitacionTemas> getListaTemas()
    {
        if (codArea != null && codArea != -1)
            {
            listaTemas = capacitacionSessionBean.findTemaByArea(getEmpresa(), codArea);
            }

        listaTemas = listaTemas != null ? listaTemas : new ArrayList<CapacitacionTemas>();
        return listaTemas;
    }

    public void setListaTemas(List<CapacitacionTemas> listaTemas)
    {
        this.listaTemas = listaTemas;
    }

//    public DataTable getTableCapacitaciones() {
//        return tableCapacitaciones;
//    }
//
//    public void setTableCapacitaciones(DataTable tableCapacitaciones) {
//        this.tableCapacitaciones = tableCapacitaciones;
//    }
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getRazon()
    {
        return razon;
    }

    public void setRazon(String razon)
    {
        this.razon = razon;
    }

    @Override
    protected void limpiarCampos()
    {
        setNombre(null);
        setInst(null);
        setImpartido(null);
        setStatus(null);
        setFechaFinal(null);
        setFechaInicial(null);
        setRazon(null);
        setDuracion(null);
        setCodArea(null);
        setCodCapacitador(null);
        setCodTema(null);
        setCapacitacionSeleccionada(null);
    }

    public void consultar$vh$action()
    {
        setCapacitacionSeleccionada(null);
        setEstadoAccion(0);
        setDetalleSelec(null);
        setNomEmp(null);
    }

    public void nuevo$vh$action()
    {
        setCapacitacionSeleccionada(null);
        setEstadoAccion(2);
        setStatus("G");
        limpiarCampos();
    }

    public void participante$ver$action()
    {
        setEstadoAccion(3);
        //participantes$vh$action();
        setListaDetalle(capacitacionSessionBean.findDetByCap(getEmpresa(), getCapacitacionSeleccionada()));
        setListaEmpleado(capacitacionSessionBean.findEmpByEmpresa(getEmpresa()));
    }

    public void asistencia$ver$action()
    {
        setEstadoAccion(4);
        //participantes$vh$action();
        setListaDetalle(capacitacionSessionBean.findDetByCap(getEmpresa(), getCapacitacionSeleccionada()));
        setListaAsistencia(new ArrayList<CapacitacionAsistencia>());
    }

    public void notas$ver$action()
    {
        setEstadoAccion(5);
        setNotaCapacitacion(getCapacitacionSeleccionada().getNotaCapacitacion());
        //participantes$vh$action();
        setListaDetalle(capacitacionSessionBean.findDetByCap(getEmpresa(), getCapacitacionSeleccionada()));
        //setListaEmpleado(capacitacionSessionBean.findEmpByEmpresa(getEmpresa()));
    }

    public String editar$cap$action()
    {
        if (getCapacitacionSeleccionada() == null)
            {
            addMessage("Mantenimiento de Capacitaciones.", "No ha seleccionado ninguna Capacitación para editar.", TipoMensaje.ERROR);
            return null;
            }
        Capacitacion cap = getCapacitacionSeleccionada();
        setStatus(cap.getStatus());
        setInst(cap.getInstituciones().getInstitucionesPK().getCodInsti());
        setNombre(cap.getNomCapacitacion());
        setFechaInicial(cap.getFechaDesde());
        setFechaFinal(cap.getFechaHasta());
        setDuracion(cap.getDuracion());
        setImpartido(cap.getImpartidaPor());
        setRazon(cap.getRazon());
        setCodArea(cap.getCapacitacionAreas().getCapacitacionAreasPK().getCodArea());
        setCodTema(cap.getCapacitacionTemas().getCapacitacionTemasPK().getCodTema());
        setCodCapacitador(cap.getCapacitadores().getCapacitadoresPK().getCodCapacitador());
        setEstadoAccion(1);
        return null;
    }

    public Integer getEstadoAccion()
    {
        return estadoAccion;
    }

    public void setEstadoAccion(Integer estadoAccion)
    {
        this.estadoAccion = estadoAccion;
    }

    public void validaCampos$action()
    {
        if (!validaFechas(fechaInicial, fechaFinal))
            {
            addMessage("Mantenimiento de Capacitaciones", "Los rangos de fecha ingresados no son consistentes.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
            }

        if (nombre == null || nombre.length() <= 0)
            {
            addMessage("Mantenimiento de Capacitaciones", "Debe ingresar el nombre de la Capacitación.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
            }

        if (inst == null || inst.equals(new Short("0")))
            {
            addMessage("Mantenimiento de Capacitaciones", "Debe seleccionar una Institución.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
            }

        if (codArea == null || codArea.equals(new Integer("0")))
            {
            addMessage("Mantenimiento de Capacitaciones", "Debe seleccionar el Área de la Capacitación.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
            }

        if (codTema == null || codTema.equals(new Integer("0")))
            {
            addMessage("Mantenimiento de Capacitaciones", "Debe seleccionar el Área de la Capacitación.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
            }

        if (codCapacitador == null || codCapacitador.equals(new Long("0")))
            {
            addMessage("Mantenimiento de Capacitaciones", "Debe seleccionar el Capacitador.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
            }
    }

    public String guardar$cap$action()
    {
        isError = Boolean.FALSE;
        validaCampos$action();
        if (isError)
            {
            return null;
            }

        // Crear Capacitacion
        if (getEstadoAccion().equals(2))
            {
            Capacitacion capacitacion = new Capacitacion();
            CapacitacionPK pk = new CapacitacionPK(getEmpresa().getCodCia(), capacitacionSessionBean.getMaxCapacitacion(getEmpresa()));
            capacitacion.setCapacitacionPK(pk);
            capacitacion.setCapacitacionAreas(capacitacionSessionBean.findByAreaId(new CapacitacionAreasPK(getEmpresa().getCodCia(), codArea)));
            capacitacion.setCapacitacionTemas(capacitacionSessionBean.findByTemaId(new CapacitacionTemasPK(getEmpresa().getCodCia(), codArea, codTema)));
            capacitacion.setCapacitadores(capacitacionSessionBean.findByCapId(new CapacitadoresPK(getEmpresa().getCodCia(), codCapacitador)));
            capacitacion.setInstituciones(capacitacionSessionBean.findByInstId(new InstitucionesPK(getEmpresa().getCodCia(), inst)));
            capacitacion.setStatus("G");
            capacitacion.setNomCapacitacion(nombre.toUpperCase());
            capacitacion.setFechaDesde(fechaInicial);
            capacitacion.setFechaHasta(fechaFinal);
            capacitacion.setDuracion(duracion);
            capacitacion.setImpartidaPor(impartido);
            capacitacion.setRazon(razon);
            try
                {
                capacitacionSessionBean.guardarCapacitacion(capacitacion);
                addMessage("Mantenimiento de Capacitaciones.", "Datos guardados con éxito", TipoMensaje.INFORMACION);
                limpiarCampos();
                }
            catch (Exception e)
                {
                addMessage("Mantenimiento de Capacitaciones.", "Ha ocurrido un error al intentar guardar la Capacitación.", TipoMensaje.ERROR);
                logger.log(Level.SEVERE, "Ha ocurrido un error al intentar guardar la capacitacion.", e);
                }
            }
        else if (getEstadoAccion().equals(1))
            {

            // Modificar Concurso
            if (getCapacitacionSeleccionada() == null)
                {
                addMessage("Mantenimiento de Concursos.", "No ha seleccionado ningún concurso para editar.", TipoMensaje.ERROR);
                return null;
                }

            getCapacitacionSeleccionada().setCapacitacionAreas(capacitacionSessionBean.findByAreaId(new CapacitacionAreasPK(getEmpresa().getCodCia(), codArea)));
            getCapacitacionSeleccionada().setCapacitacionTemas(capacitacionSessionBean.findByTemaId(new CapacitacionTemasPK(getEmpresa().getCodCia(), codArea, codTema)));
            getCapacitacionSeleccionada().setCapacitadores(capacitacionSessionBean.findByCapId(new CapacitadoresPK(getEmpresa().getCodCia(), codCapacitador)));
            getCapacitacionSeleccionada().setInstituciones(capacitacionSessionBean.findByInstId(new InstitucionesPK(getEmpresa().getCodCia(), inst)));
            getCapacitacionSeleccionada().setNomCapacitacion(nombre);
            getCapacitacionSeleccionada().setFechaDesde(fechaInicial);
            getCapacitacionSeleccionada().setFechaHasta(fechaFinal);
            getCapacitacionSeleccionada().setDuracion(duracion);
            getCapacitacionSeleccionada().setImpartidaPor(impartido);
            getCapacitacionSeleccionada().setRazon(razon);
            getCapacitacionSeleccionada().setStatus(status);
            try
                {
                capacitacionSessionBean.editarCapacitacion(getCapacitacionSeleccionada());
                addMessage("Mantenimiento de Capacitacion.", "Datos actualizados con éxito", TipoMensaje.INFORMACION);
                limpiarCampos();
                }
            catch (Exception e)
                {
                addMessage("Mantenimiento de Capacitacion.", "Ha ocurrido un error al intentar actualizar la Capacitación.", TipoMensaje.ERROR);
                logger.log(Level.SEVERE, "Ha ocurrido un error al intentar actualizar la Capacitación.", e);
                }
            }

        return null;
    }

    public String eliminar$crud$action()
    {
        if (getCapacitacionSeleccionada() == null)
            {
            addMessage("Mantenimiento de Capacitaciones", "Primero seleccione una Capacitación", TipoMensaje.ERROR);
            return null;
            }
        try
            {
            capacitacionSessionBean.eliminarCapacitacion(getCapacitacionSeleccionada());
            addMessage("Mantenimiento de Capacitaciones.", "Datos eliminados con éxito", TipoMensaje.INFORMACION);
            setListaCap(capacitacionSessionBean.findCapByEmpresa(getEmpresa()));
            limpiarCampos();
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Capacitaciones.", "Ha ocurrido un error al intentar remover la Capacitación.", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Ha ocurrido un error al intentar remover la Capacitación.", e);
            }
        return null;
    }

//participantes-------------------------------------------------------------
    public String participantes$vh$action()
    {
        if (getCapacitacionSeleccionada() == null)
            {
            addMessage("Mantenimiento de Capacitaciones.", "No ha seleccionado ninguna Capacitación para editar.", TipoMensaje.ERROR);
            return null;
            }
//          Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
//          setStatus(cap.getStatus());
//          setInst(cap.getInstituciones().getInstitucionesPK().getCodInsti());
//          setNomCapacitacion(cap.getNomCapacitacion());
//          setNomInst(cap.getInstituciones().getDesInsti());
//          setFechaInicial(cap.getFechaDesde());
//          setFechaFinal(cap.getFechaHasta());
//          setDuracion(cap.getDuracion());
//          setImpartido(cap.getImpartidaPor());
//          setNomArea(cap.getCapacitacionAreas().getNomArea());
//          setNomTema(cap.getCapacitacionTemas().getNomTema());
//          setNomCapacitador(cap.getCapacitadores().getNombre());
//          setNotaCapacitacion(cap.getNotaCapacitacion());
//          Cias comp = getSessionBeanADM().getCompania();
        setListaDetalle(capacitacionSessionBean.findDetByCap(getEmpresa(), getCapacitacionSeleccionada()));
        //setEstadoAccion(3);
        return null;
    }

    public String agregarEmpleado()
    {
        if (getCapacitacionSeleccionada() == null)
            {
            addMessage("Mantenimiento Participantes", "Seleccione una Capacitación.", TipoMensaje.ERROR);
            return null;
            }
        //getSessionBeanCAP().setEmpleadoSeleccionado((Empleados) event.getObject());
        //nomEmp = getSessionBeanCAP().getEmpleadoSeleccionado().getNombreCompleto();
        //Guardar Empleado
        //isError = Boolean.FALSE;
        //validaCampos$action();
        //Short c = getSessionBeanADM().getCompania().getCodCia();
        //Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        if (getCapacitacionSeleccionada().getStatus().equals("N"))
            {
            addMessage("Mantenimiento Participantes", "Esta Capacitación ya fue notificada, no se pueden agregar más participantes", TipoMensaje.INFORMACION);
            return null;
            //isError = true;
            }
        //if (isError) {
        //return;
        //}
        //CapacitacionXEmpleado detalleCap = new CapacitacionXEmpleado();
        CapacitacionXEmpleado detalle = new CapacitacionXEmpleado();
        CapacitacionXEmpleadoPK pk = new CapacitacionXEmpleadoPK();
        pk.setCodCia(getEmpresa().getCodCia());
        //Cias ciaCod = getSessionBeanADM().getCompania();
        //Integer cod = capacitacionSessionBean.getMaxCapacitacion(getEmpresa());
        pk.setCodCapacitacion(capacitacionSessionBean.getMaxCapacitacion(getEmpresa()));
        pk.setCodCapacitacion(getCapacitacionSeleccionada().getCapacitacionPK().getCodCapacitacion());
        pk.setCodEmp(getEmpleadoSeleccionado().getEmpleadosPK().getCodEmp());
        detalle.setCapacitacionXEmpleadoPK(pk);
        detalle.setEmpleados(getEmpleadoSeleccionado());
        detalle.setNota(BigDecimal.ZERO);
        try
            {

            if (listaDetalle == null)
                {
                setListaDetalle(new ArrayList<CapacitacionXEmpleado>());
                }
            if (listaDetalle.contains(detalle))
                {
                addMessage("Mantenimiento de Detalle de Capacitaciones.", "El empleado " + getEmpleadoSeleccionado().getNombreCompleto() + " ya existe en el detalle.", TipoMensaje.INFORMACION);
                return null;
                }
            capacitacionSessionBean.guardarDetalleCapacitacion(detalle);
            registrarAsistenciaCapacitacion(getCapacitacionSeleccionada().getFechaDesde(), getCapacitacionSeleccionada().getFechaHasta(), getEmpleadoSeleccionado(), getCapacitacionSeleccionada());
            addMessage("Mantenimiento de Detalle de Capacitaciones.", "Datos guardados con éxito", TipoMensaje.INFORMACION);
            setEmpleadoSeleccionado(null);
            setNomEmp(null);
            setListaDetalle(capacitacionSessionBean.findDetByCap(getEmpresa(), getCapacitacionSeleccionada()));
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Detalle de Capacitaciones.", "Este participante ya ha sido agregado a esta Capacitación.", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Este participante ya ha sido agregado a esta Capacitación: ", e);
            }
        return null;
    }

    public void registrarAsistenciaCapacitacion(Date fechaInicial, Date fechaFinal, Empleados empleado, Capacitacion capacitacion)
    {
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaInicial);
        for (int i = 1; i <= calculaDias(fechaInicial, fechaFinal); i++)
            {
            CapacitacionAsistencia asistencia = new CapacitacionAsistencia();
            CapacitacionAsistenciaPK pk = new CapacitacionAsistenciaPK();
            pk.setCodCia(getEmpresa().getCodCia());
            pk.setCodCapacitacion(capacitacion.getCapacitacionPK().getCodCapacitacion());
            pk.setCodEmp(empleado.getEmpleadosPK().getCodEmp());
            pk.setFecha(fecha.getTime());
            fecha.add(Calendar.DATE, 1);
            asistencia.setCapacitacionAsistenciaPK(pk);
            asistencia.setCapacitacion(capacitacion);
            asistencia.setEmpleados(empleado);
            capacitacionSessionBean.guardarAsistencia(asistencia);
            }
    }

//    public void onRowSelectDetalle(SelectEvent event) {
//        getSessionBeanCAP().setDetalleCapSeleccionada((CapacitacionXEmpleado) event.getObject());
//    }
    @PermitAll
    public void enviar$correo$action()
    {
        try
            {
            for (CapacitacionXEmpleado det : listaDetalle)
                {
                //Creacion de registros para asistencia
//                try {
//                    final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
//                    Long dias = (getSessionBeanCAP().getCapacitacionSeleccionada().getFechaHasta().getTime() - getSessionBeanCAP().getCapacitacionSeleccionada().getFechaDesde().getTime()) / MILLSECS_PER_DAY;
//                    Integer total = dias.intValue() + 2;
//                    for (Integer i = 1; i < total; i++) {
//                        CapacitacionAsistencia asistencia = new CapacitacionAsistencia();
//                        CapacitacionAsistenciaPK pk = new CapacitacionAsistenciaPK();
//                        pk.setCodCia(det.getCapacitacionXEmpleadoPK().getCodCia());
//                        pk.setCodCapacitacion(det.getCapacitacionXEmpleadoPK().getCodCapacitacion());
//                        pk.setCodEmp(det.getCapacitacionXEmpleadoPK().getCodEmp());
//                        pk.setFecha(sumarFechasDias(getSessionBeanCAP().getCapacitacionSeleccionada().getFechaDesde(), i - 1));
//                        asistencia.setCapacitacionAsistenciaPK(pk);
//                        asistencia.setCapacitacion(getSessionBeanCAP().getCapacitacionSeleccionada());
//                        asistencia.setEmpleados(det.getEmpleados());
//                        asistencia.setAsistio("N");
//                        capacitacionSessionBean.guardarAsistencia(asistencia);
//                    }
//                } catch (Exception e) {
//                    addMessage("Mantenimiento de Particiantes.", "Ya se han enviado las notificaciones.", TipoMensaje.ERROR);
//                    System.out.println(e.getMessage());
//                    return;
//                }
                //Enviar correos
                StringBuilder mensaje = new StringBuilder();
                mensaje.append("\n\nPor medio de la presente se le comunica que ha sido convocado a la siguiente Capacitación");
                mensaje.append("\n\nNombre: ").append(getCapacitacionSeleccionada().getNomCapacitacion());
                mensaje.append("\n\nArea: ").append(getCapacitacionSeleccionada().getCapacitacionAreas().getNomArea());
                mensaje.append("\n\nTema: ").append(getCapacitacionSeleccionada().getCapacitacionTemas().getNomTema());
                mensaje.append("\n\nA celebrarse el día: ").append(new SimpleDateFormat("dd/MM/yyyy").format(getCapacitacionSeleccionada().getFechaDesde()));

                mailStatelessBean.enviarCorreoElectronico("Capacitación", mensaje.toString(), det.getEmpleados().getCorreo());

                }
            //Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
            getCapacitacionSeleccionada().setStatus("N");
            capacitacionSessionBean.editarCapacitacion(getCapacitacionSeleccionada());
            addMessage("Mantenimiento de participantes.", "Correos enviados a los Participantes de esta Capacitación ", TipoMensaje.INFORMACION);
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Particiantes.", "Ha ocurrido un error al enviar correos a Participantes.", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Ha ocurrido un error al enviar correos a Participantes.", e);
            //System.out.println(e.getMessage());
            }
    }

//    public static Date sumarFechasDias(Date fch, int dias) {
//        Calendar cal = new GregorianCalendar();
//        cal.setTimeInMillis(fch.getTime());
//        cal.add(Calendar.DATE, dias);
//        return new Date(cal.getTimeInMillis());
//    }
    public String eliminar$participante$action()
    {
        //isError = false;
        //Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        if (getCapacitacionSeleccionada().getStatus().equals("N"))
            {
            addMessage("Mantenimiento Participantes", "Esta Capacitación ya fue notificada, no se pueden eliminar participantes", TipoMensaje.INFORMACION);
            return null;
            //isError = true;
            }
        if (getDetalleCapSeleccionada() == null)
            {
            addMessage("Mantenimiento de Participantes", "Primero seleccione un Participante", TipoMensaje.ERROR);
            return null;
            //isError = true;
            }
//        if (isError) {
//            return;
//        }
        try
            {
            //CapacitacionXEmpleado participante = getSessionBeanCAP().getDetalleCapSeleccionada();
            capacitacionSessionBean.eliminarDetalleCapacitacion(getDetalleCapSeleccionada());
            addMessage("Mantenimiento de participantes.", "Datos eliminados con éxito", TipoMensaje.INFORMACION);
            setListaDetalle(capacitacionSessionBean.findDetByCap(getEmpresa(), getCapacitacionSeleccionada()));
            //setNomEmp(null);
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Particiantes.", "Ha ocurrido un error al intentar remover al Participante.", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Ha ocurrido un error al intentar remover al Participante.", e);
            }
        return null;
    }

//Asistencia----------------------------------------------------------------
//public void onRowSelectDetalleAsistencia(SelectEvent event) {
//setDetalleSelec((CapacitacionXEmpleado) event.getObject());
//getSessionBeanCAP().setDetalleCapSeleccionada((CapacitacionXEmpleado) event.getObject());
//Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
//CapacitacionXEmpleado detalle = detalleSelec;
//Empleados empleado = detalle.getEmpleados();
//listaAsistencia = capacitacionSessionBean.findAsistenciaByDet(getSessionBeanADM().getCompania(), cap, empleado);
//nomEmp = detalleSelec.getEmpleados().getNombreCompleto();
//}
    public String agregarDetalleAsistencia()
    {
        if (getDetalleSelec() == null)
            {
            addMessage("Mantenimiento de Particiantes.", "No ha seleccionado ningún Participante.", TipoMensaje.ERROR);
            return null;
            }
        setListaAsistencia(capacitacionSessionBean.findAsistenciaByDet(getEmpresa(), getCapacitacionSeleccionada(), getDetalleSelec().getEmpleados()));
        return null;
    }

    @PermitAll
    public void rowEditListenerAsistencia(RowEditEvent event)
    {
        //boolean hayError = false;
        CapacitacionAsistencia asistencia = (CapacitacionAsistencia) event.getObject();
        try
            {
            asistencia.setAsistio((asistencia.getAsiste().equalsIgnoreCase("Si Asistio")) ? "N" : "S");
            capacitacionSessionBean.editarAsistencia(asistencia);
            addMessage("Mantenimiento de Asistencia de Capacitacion.", "Asistencias actualizadas con éxito", TipoMensaje.INFORMACION);
            setDetalleSelec(null);
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Asistencia de Capacitacion.", "Ha ocurrido un error al intentar actualizar la Asistencia de Capacitación.", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Ha ocurrido un error al intentar actualizar la Asistencia de Capacitación.", e);
            //System.out.println(e.getMessage());
            }
    }

//Notas---------------------------------------------------------------------
    @PermitAll
    public void rowEditListenerNotas(RowEditEvent event)
    {
        //boolean hayError = false;
        CapacitacionXEmpleado detalle = null;
        try
            {
            detalle = (CapacitacionXEmpleado) event.getObject();
            capacitacionSessionBean.editarDetalleCapacitacion(detalle);
            addMessage("Mantenimiento de Detalle de Capacitación.", "Datos actualizados con éxito", TipoMensaje.INFORMACION);
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Detalle de Capacitación.", "Ha ocurrido un error al intentar actualizar el Detallle Capacitacion.", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Ha ocurrido un error al intentar actualizar el Detallle Capacitacion.", e);
            //System.out.println(e.getMessage());
            }
        //detalle.setNota(nota);
        // ==
        try
            {
            // ==
            Candidato candidato = reclutamientoFacade.findCandidatoByEmpleado(detalle.getEmpleados());
            if (candidato == null)
                return ;

            CapacitacionXCandidatoPK capacitacionXCandidatoPK = new CapacitacionXCandidatoPK();
            capacitacionXCandidatoPK.setCodCia(detalle.getCapacitacion().getCapacitacionPK().getCodCia());
            capacitacionXCandidatoPK.setCodCapacitacion(detalle.getCapacitacion().getCapacitacionPK().getCodCapacitacion());
            capacitacionXCandidatoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());

            CapacitacionXCandidato capacitacionXCandidato = reclutamientoFacade.findCapacitacionCandidatoByID(capacitacionXCandidatoPK);

            capacitacionXCandidato.setCapacitacionXCandidatoPK(capacitacionXCandidatoPK);
            capacitacionXCandidato.setCandidato(candidato);
            capacitacionXCandidato.setTipo("");

            if (capacitacionXCandidato == null)
                reclutamientoFacade.crearCapacitacionXCandidato(capacitacionXCandidato);
            else
                reclutamientoFacade.editarCapacitacionXCandidato(capacitacionXCandidato);
            }
        catch(Exception excpt)
            {
            System.err.println(excpt.toString());
            }
    }

    public String guardar$notaCap$action()
    {
        //isError = false;
        if (notaCapacitacion == null)
            {
            addMessage("Mantenimiento de Detalle de Capacitación.", "Ingrese la nota general.", TipoMensaje.INFORMACION);
            return null;
            //  isError = true;
            }
        //      if (isError) {
//            return;
        //}
        try
            {
            //Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
            getCapacitacionSeleccionada().setNotaCapacitacion(notaCapacitacion);
            capacitacionSessionBean.editarCapacitacion(getCapacitacionSeleccionada());
            addMessage("Mantenimiento de Detalle de Capacitación.", "Nota general actualizada con éxito.", TipoMensaje.INFORMACION);
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Detalle de Capacitación.", "Ha ocurrido un error al intentar actualizar la nota general.", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Ha ocurrido un error al intentar actualizar la nota general.", e);
            }
        return null;
    }

    public String editarAsistencia(String asistencia)
    {
        try
            {
            asistenciaSeleccionada.setAsistio(asistencia);
            capacitacionSessionBean.editarAsistencia(asistenciaSeleccionada);
            addMessage("Mantenimiento de Detalle de Capacitación.", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
            setListaAsistencia(capacitacionSessionBean.findAsistenciaByDet(getEmpresa(), getCapacitacionSeleccionada(), getDetalleSelec().getEmpleados()));
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Detalle de Capacitación.", "Ha ocurrido un error al intentar actualizar asistencia.", TipoMensaje.INFORMACION);
            logger.log(Level.SEVERE, "Ha ocurrido un error al intentar actualizar asistencia.", e);
            }
        return null;
    }
}
//754 getSessionBeanCAP().getCapacitacionSeleccionada() E L I M I N A R