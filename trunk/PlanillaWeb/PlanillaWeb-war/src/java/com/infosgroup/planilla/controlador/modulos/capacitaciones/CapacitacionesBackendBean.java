/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.capacitaciones;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAreas;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAreasPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAsistencia;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAsistenciaPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionTemas;
import com.infosgroup.planilla.modelo.entidades.CapacitacionTemasPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleado;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleadoPK;
import com.infosgroup.planilla.modelo.entidades.Capacitadores;
import com.infosgroup.planilla.modelo.entidades.CapacitadoresPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Instituciones;
import com.infosgroup.planilla.modelo.entidades.InstitucionesPK;
import com.infosgroup.planilla.modelo.procesos.CapacitacionesSessionBean;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "capacitaciones$capacitaciones")
@ViewScoped
public class CapacitacionesBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private CapacitacionesSessionBean capacitacionSessionBean;
    @EJB
    private MailStatelessBean mailStatelessBean;
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
    private SelectItem[] estadoCapacitacion = { new SelectItem("G", "Grabado"), new SelectItem("A", "Aprobado"), new SelectItem("R", "Rechazado"), new SelectItem("RE", "Realizado"), new SelectItem("N", "Notificado") };
    private Capacitacion capacitacionSeleccionada;
    private Cias empresa;
    
    public CapacitacionesBackendBean(){}

    @PostConstruct
    public void _init(){
        setEmpresa(getSessionBeanADM().getCompania());
    }

    public Cias getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }
    
    public Capacitacion getCapacitacionSeleccionada() {
        return capacitacionSeleccionada;
    }

    public void setCapacitacionSeleccionada(Capacitacion capacitacionSeleccionada) {
        this.capacitacionSeleccionada = capacitacionSeleccionada;
    }
    
    public SelectItem[] getEstadoCapacitacion() {
        return estadoCapacitacion;
    }

    public void setEstadoCapacitacion(SelectItem[] estadoCapacitacion) {
        this.estadoCapacitacion = estadoCapacitacion;
    }
    
    public String getCodCap() {
        return codCap;
    }

    public void setCodCap(String codCap) {
        this.codCap = codCap;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public BigDecimal getCostoRazon() {
//        return costoRazon;
//    }
//
//    public void setCostoRazon(BigDecimal costoRazon) {
//        this.costoRazon = costoRazon;
//    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getImpartido() {
        return impartido;
    }

    public void setImpartido(String impartido) {
        this.impartido = impartido;
    }

    public Short getInst() {
        return inst;
    }

    public void setInst(Short inst) {
        this.inst = inst;
    }

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    public Integer getCodTema() {
        return codTema;
    }

    public void setCodTema(Integer codTema) {
        this.codTema = codTema;
    }

    public Long getCodCapacitador() {
        return codCapacitador;
    }

    public void setCodCapacitador(Long codCapacitador) {
        this.codCapacitador = codCapacitador;
    }

    public CapacitacionXEmpleado getDetalleSelec() {
        return detalleSelec;
    }

    public void setDetalleSelec(CapacitacionXEmpleado detalleSelec) {
        this.detalleSelec = detalleSelec;
    }

    public List<CapacitacionAsistencia> getListaAsistencia() {
        return listaAsistencia;
    }

    public void setListaAsistencia(List<CapacitacionAsistencia> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    public List<CapacitacionXEmpleado> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<CapacitacionXEmpleado> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public List<Empleados> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleados> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public String getNomArea() {
        return nomArea;
    }

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
    }

    public String getNomCapacitacion() {
        return nomCapacitacion;
    }

    public void setNomCapacitacion(String nomCapacitacion) {
        this.nomCapacitacion = nomCapacitacion;
    }

    public String getNomCapacitador() {
        return nomCapacitador;
    }

    public void setNomCapacitador(String nomCapacitador) {
        this.nomCapacitador = nomCapacitador;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getNomInst() {
        return nomInst;
    }

    public void setNomInst(String nomInst) {
        this.nomInst = nomInst;
    }

    public String getNomTema() {
        return nomTema;
    }

    public void setNomTema(String nomTema) {
        this.nomTema = nomTema;
    }

    public BigDecimal getNotaCapacitacion() {
        return notaCapacitacion;
    }

    public void setNotaCapacitacion(BigDecimal notaCapacitacion) {
        this.notaCapacitacion = notaCapacitacion;
    }

    public List<Instituciones> getListaInst() {
        listaInst = capacitacionSessionBean.findInstByEmpresa(getSessionBeanADM().getCompania());
        return listaInst;
    }

    public void setListaInst(List<Instituciones> listaInst) {
        this.listaInst = listaInst;
    }

    public List<Capacitacion> getListaCap() {
        listaCap = capacitacionSessionBean.findCapByEmpresa(getSessionBeanADM().getCompania());
        return listaCap;
    }

    public void setListaCap(List<Capacitacion> listaCap) {
        this.listaCap = listaCap;
    }

    public List<CapacitacionAreas> getListaArea() {
        listaArea = capacitacionSessionBean.findAreaByCap(getSessionBeanADM().getCompania());
        return listaArea;
    }

    public void setListaArea(List<CapacitacionAreas> listaArea) {
        this.listaArea = listaArea;
    }

    public List<Capacitadores> getListaCapacitadores() {
        listaCapacitadores = capacitacionSessionBean.findCapacitadoresByCap(getSessionBeanADM().getCompania());
        return listaCapacitadores;
    }

    public void setListaCapacitadores(List<Capacitadores> listaCapacitadores) {
        this.listaCapacitadores = listaCapacitadores;
    }

    public List<CapacitacionTemas> getListaTemas() {
        if(codArea != null && codArea != -1){
            listaTemas = capacitacionSessionBean.findTemaByArea(getSessionBeanADM().getCompania(), codArea);
        }
        
        listaTemas = listaTemas != null ? listaTemas : new ArrayList<CapacitacionTemas>();
        return listaTemas;
    }

    public void setListaTemas(List<CapacitacionTemas> listaTemas) {
        this.listaTemas = listaTemas;
    }

//    public DataTable getTableCapacitaciones() {
//        return tableCapacitaciones;
//    }
//
//    public void setTableCapacitaciones(DataTable tableCapacitaciones) {
//        this.tableCapacitaciones = tableCapacitaciones;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    
    @Override
    protected void limpiarCampos() {
        setNombre(null);
        setInst(null);
        setImpartido(null);
        setStatus(null);
        setFechaFinal(null);
        setFechaInicial(null);
        setRazon(null);
//        setCostoRazon(null);
        setDuracion(null);
        setCodArea(null);
        setCodCapacitador(null);
        setCodTema(null);
        getSessionBeanCAP().setCapacitacionSeleccionada(null);
    }
       
    public void consultar$vh$action() {
        setCapacitacionSeleccionada(null);
        setEstadoAccion(0);
        setDetalleSelec(null);
        setNomEmp(null);
    }

    public void nuevo$vh$action() {
        setCapacitacionSeleccionada(null);
        setEstadoAccion(2);
        setStatus("G");
    }
    
    public void participante$ver$action() {
        getSessionBeanADM().setEstadoAccion(3);
        participantes$vh$action();
        listaEmpleado = capacitacionSessionBean.findEmpByEmpresa(getSessionBeanADM().getCompania());
    }
    
    public void asistencia$ver$action() {
        getSessionBeanADM().setEstadoAccion(4);
        participantes$vh$action();
        listaAsistencia = new ArrayList<CapacitacionAsistencia>();
    }
    
    public void notas$ver$action() {
        getSessionBeanADM().setEstadoAccion(5);
        participantes$vh$action();
        listaEmpleado = capacitacionSessionBean.findEmpByEmpresa(getSessionBeanADM().getCompania());
    }
        
    
    public String editar$cap$action() {
        if (getSessionBeanCAP().getCapacitacionSeleccionada() == null) {
        addMessage("Mantenimiento de Capacitaciones.", "No ha seleccionado ninguna capacitacion para editar.", TipoMensaje.ERROR);
        return null;
        }
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        setStatus(cap.getStatus());
        setInst(cap.getInstituciones().getInstitucionesPK().getCodInsti());
        setNombre(cap.getNomCapacitacion());
        setFechaInicial(cap.getFechaDesde());
        setFechaFinal(cap.getFechaHasta());
        setDuracion(cap.getDuracion());
        setImpartido(cap.getImpartidaPor());
        setRazon(cap.getRazon());
        //setCostoRazon(cap.getCostoRazon());
        setCodArea(cap.getCapacitacionAreas().getCapacitacionAreasPK().getCodArea());
        setCodTema(cap.getCapacitacionTemas().getCapacitacionTemasPK().getCodTema());
        setCodCapacitador(cap.getCapacitadores().getCapacitadoresPK().getCodCapacitador());
        getSessionBeanADM().setEstadoAccion( 1 );
        return null;
    }
    

    
    public void setEstadoAccion(Integer estadoAccion) {
        getSessionBeanADM().setEstadoAccion(estadoAccion);
        limpiarCampos();
    }
    
    public void validaCampos$action() {
        if (!validaFechas(fechaInicial, fechaFinal)) {
            addMessage("Mantenimiento de Capacitaciones", "Los rangos de fecha ingresados no son consistentes.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
        }
    }
    
    public String guardar$cap$action() {
        isError = Boolean.FALSE;
        validaCampos$action();
        if (isError) return null;
        
        
        /* Crear Capacitacion */
        if (getSessionBeanADM().getEstadoAccion().equals(2)) {
            Capacitacion capacitacion = new Capacitacion();
            CapacitacionPK pk = new CapacitacionPK(getEmpresa().getCodCia(), capacitacionSessionBean.getMaxCapacitacion(getEmpresa()));
            capacitacion.setCapacitacionPK(pk);
            capacitacion.setCapacitacionAreas(capacitacionSessionBean.findByAreaId(new CapacitacionAreasPK(getEmpresa().getCodCia(), codArea)));
            capacitacion.setCapacitacionTemas(capacitacionSessionBean.findByTemaId(new CapacitacionTemasPK(getEmpresa().getCodCia(), codArea, codTema)));
            capacitacion.setCapacitadores(capacitacionSessionBean.findByCapId(new CapacitadoresPK(getEmpresa().getCodCia(), codCapacitador)));
            capacitacion.setInstituciones(capacitacionSessionBean.findByInstId(new InstitucionesPK(getEmpresa().getCodCia(),inst)));
            capacitacion.setStatus("G");            
            capacitacion.setNomCapacitacion(nombre.toUpperCase());
            capacitacion.setFechaDesde(fechaInicial);
            capacitacion.setFechaHasta(fechaFinal);
            capacitacion.setDuracion(duracion);
            capacitacion.setImpartidaPor(impartido);
            capacitacion.setRazon(razon);
            try {
                capacitacionSessionBean.guardarCapacitacion(capacitacion);
                addMessage("Mantenimiento de Capacitaciones.", "Datos guardados con éxito", TipoMensaje.INFORMACION);
                limpiarCampos();
            } catch (Exception e) {
                addMessage("Mantenimiento de Capacitaciones.", "Ha ocurrido un error al intentar guardar la capacitacion.", TipoMensaje.ERROR);
                logger.log(Level.SEVERE, "Ha ocurrido un error al intentar guardar la capacitacion.", e);
            }
        } else if (getSessionBeanADM().getEstadoAccion().equals(1)) {
            
            /* Modificar Concurso */
            if (getCapacitacionSeleccionada() == null) {
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
            try {
                capacitacionSessionBean.editarCapacitacion(getCapacitacionSeleccionada());
                addMessage("Mantenimiento de Capacitacion.", "Datos actualizados con éxito", TipoMensaje.INFORMACION);
                limpiarCampos();
            } catch (Exception e) {
                addMessage("Mantenimiento de Capacitacion.", "Ha ocurrido un error al intentar actualizar la Capacitacion.", TipoMensaje.ERROR);
                logger.log(Level.SEVERE, "Ha ocurrido un error al intentar actualizar la Capacitacion.", e);
            }
        }

        return null;
    }
       
    public void eliminar$crud$action(ActionEvent actionEvent) {
        if (getCapacitacionSeleccionada() == null) {
            addMessage("Mantenimiento de Capacitaciones", "Primero seleccione una Capacitación", TipoMensaje.ERROR);
            return;
        }
        try {
            capacitacionSessionBean.eliminarCapacitacion(getCapacitacionSeleccionada());
            addMessage("Mantenimiento de Capacitaciones.", "Datos eliminados con éxito", TipoMensaje.INFORMACION);
            setListaCap(capacitacionSessionBean.findCapByEmpresa(getSessionBeanADM().getCompania()));
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Mantenimiento de Capacitacion.", "Ha ocurrido un error al intentar remover la Capacitación.", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Ha ocurrido un error al intentar remover la Capacitación.", e);
        }
    }
    
        //participantes-------------------------------------------------------------
    public String participantes$vh$action(){
        if (getSessionBeanCAP().getCapacitacionSeleccionada() == null) {
            addMessage("Mantenimiento de Capacitaciones.", "No ha seleccionado ninguna capacitacion para editar.", TipoMensaje.ERROR);
            return null;
        }
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        setStatus(cap.getStatus());
        setInst(cap.getInstituciones().getInstitucionesPK().getCodInsti());
        setNomCapacitacion(cap.getNomCapacitacion());
        setNomInst(cap.getInstituciones().getDesInsti());
        setFechaInicial(cap.getFechaDesde());
        setFechaFinal(cap.getFechaHasta());
        setDuracion(cap.getDuracion());
        setImpartido(cap.getImpartidaPor());
        setNomArea(cap.getCapacitacionAreas().getNomArea());
        setNomTema(cap.getCapacitacionTemas().getNomTema());
        setNomCapacitador(cap.getCapacitadores().getNombre());
        setNotaCapacitacion(cap.getNotaCapacitacion());
        Cias comp = getSessionBeanADM().getCompania();
        listaEmpleado = capacitacionSessionBean.findEmpByEmpresa(comp);
        listaDetalle = capacitacionSessionBean.findDetByCap(getSessionBeanADM().getCompania(), cap);
        //getSessionBeanADM().setEstadoAccion(3);
        return null;
    }
    
    public void onRowSelectEmpleado(SelectEvent event) {
        getSessionBeanCAP().setEmpleadoSeleccionado((Empleados) event.getObject());
        nomEmp = getSessionBeanCAP().getEmpleadoSeleccionado().getNombreCompleto();
        //Guardar Empleado
        isError = Boolean.FALSE;
        //validaCampos$action();
        Short c = getSessionBeanADM().getCompania().getCodCia();
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        if(cap.getStatus().equals("N")){
            addMessage("Mantenimiento Participantes", "Esta Capacitacion ya fue notificada, no se pueden agregar más participantes", TipoMensaje.INFORMACION);
            isError = true;
        }
        if (isError) {
            return;
        }
        CapacitacionXEmpleado detalleCap = new CapacitacionXEmpleado();
        /* Crear Detalle*/
        CapacitacionXEmpleado detalle = new CapacitacionXEmpleado();
        CapacitacionXEmpleadoPK pk = new CapacitacionXEmpleadoPK();
        pk.setCodCia(c);
        Cias ciaCod = getSessionBeanADM().getCompania();
        Integer cod = capacitacionSessionBean.getMaxCapacitacion(ciaCod);
        pk.setCodCapacitacion(cod);
        pk.setCodCapacitacion(getSessionBeanCAP().getCapacitacionSeleccionada().getCapacitacionPK().getCodCapacitacion());
        pk.setCodEmp(getSessionBeanCAP().getEmpleadoSeleccionado().getEmpleadosPK().getCodEmp());
        detalle.setCapacitacionXEmpleadoPK(pk);
        detalle.setEmpleados(getSessionBeanCAP().getEmpleadoSeleccionado());
        detalle.setNota(BigDecimal.ZERO);
        try {
            capacitacionSessionBean.guardarDetalleCapacitacion(detalle);
            addMessage("Mantenimiento de Detalle de Capacitaciones.", "Datos guardados con éxito", TipoMensaje.INFORMACION);
            getSessionBeanCAP().setEmpleadoSeleccionado(null);
            setNomEmp(null);
            listaDetalle = capacitacionSessionBean.findDetByCap(ciaCod, getSessionBeanCAP().getCapacitacionSeleccionada());
        } catch (Exception e) {
            addMessage("Mantenimiento de Detalle de Capacitaciones.", "Este participante ya ha sido agregado a esta Capacitación.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
    }
    
    public void onRowSelectDetalle(SelectEvent event) {
        getSessionBeanCAP().setDetalleCapSeleccionada((CapacitacionXEmpleado) event.getObject());
    }
    
    @PermitAll
    public void enviar$correo$action() {
        try {
            for (CapacitacionXEmpleado det : listaDetalle) {
                //Creacion de registros para asistencia
                try {
                    final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
                    Long dias = (getSessionBeanCAP().getCapacitacionSeleccionada().getFechaHasta().getTime() - getSessionBeanCAP().getCapacitacionSeleccionada().getFechaDesde().getTime()) / MILLSECS_PER_DAY;
                    Integer total = dias.intValue() + 2;
                    for (Integer i = 1; i < total; i++) {
                        CapacitacionAsistencia asistencia = new CapacitacionAsistencia();
                        CapacitacionAsistenciaPK pk = new CapacitacionAsistenciaPK();
                        pk.setCodCia(det.getCapacitacionXEmpleadoPK().getCodCia());
                        pk.setCodCapacitacion(det.getCapacitacionXEmpleadoPK().getCodCapacitacion());
                        pk.setCodEmp(det.getCapacitacionXEmpleadoPK().getCodEmp());
                        pk.setFecha(sumarFechasDias(getSessionBeanCAP().getCapacitacionSeleccionada().getFechaDesde(), i - 1));
                        asistencia.setCapacitacionAsistenciaPK(pk);
                        asistencia.setCapacitacion(getSessionBeanCAP().getCapacitacionSeleccionada());
                        asistencia.setEmpleados(det.getEmpleados());
                        asistencia.setAsistio("N");
                        capacitacionSessionBean.guardarAsistencia(asistencia);
                    }
                } catch (Exception e) {
                    addMessage("Mantenimiento de Particiantes.", "Ya se han enviado las notificaciones.", TipoMensaje.ERROR);
                    System.out.println(e.getMessage());
                    return;
                }
                //Enviar correos
                StringBuilder mensaje = new StringBuilder();
                mensaje.append("\n\nPor medio de la presente se le comunica que ha sido convocado a la siguiente Capacitación");
                mensaje.append("\n\nNombre: ").append(getSessionBeanCAP().getCapacitacionSeleccionada().getNomCapacitacion());
                mensaje.append("\n\nArea: ").append(getSessionBeanCAP().getCapacitacionSeleccionada().getCapacitacionAreas().getNomArea());
                mensaje.append("\n\nTema: ").append(getSessionBeanCAP().getCapacitacionSeleccionada().getCapacitacionTemas().getNomTema());
                mensaje.append("\n\nA celebrarse el día: ").append(new SimpleDateFormat("dd/MM/yyyy").format(getSessionBeanCAP().getCapacitacionSeleccionada().getFechaDesde()));

                mailStatelessBean.enviarCorreoElectronico("Capacitacion", mensaje.toString(), det.getEmpleados().getCorreo());

            }
            Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
            cap.setStatus("N");
            capacitacionSessionBean.editarCapacitacion(cap);

            addMessage("Mantenimiento de participantes.", "Correos enviados a los Participantes de esta capacitación ", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Mantenimiento de Particiantes.", "Ha ocurrido un error al enviar correos a Participantes.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
    }

    public static Date sumarFechasDias(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new Date(cal.getTimeInMillis());
    }
    
    public void eliminar$participante$action(ActionEvent actionEvent){
        isError = false;
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        if(cap.getStatus().equals("N")){
            addMessage("Mantenimiento Participantes", "Esta Capacitacion ya fue notificada, no se pueden eliminar participantes", TipoMensaje.INFORMACION);
            isError = true;
        }
        if (getSessionBeanCAP().getDetalleCapSeleccionada() == null) {
            addMessage("Mantenimiento de Participantes", "Primero seleccione un Participante", TipoMensaje.ERROR);
            isError = true;
        }
        if(isError)
            return;
        try {
            CapacitacionXEmpleado participante = getSessionBeanCAP().getDetalleCapSeleccionada();
            capacitacionSessionBean.eliminarDetalleCapacitacion(participante);
            addMessage("Mantenimiento de participantes.", "Datos eliminados con éxito", TipoMensaje.INFORMACION);
            setNomEmp(null);
        } catch (Exception e) {
            addMessage("Mantenimiento de Particiantes.", "Ha ocurrido un error al intentar remover al Participante.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
        listaDetalle = capacitacionSessionBean.findDetByCap(getSessionBeanADM().getCompania(), getSessionBeanCAP().getCapacitacionSeleccionada());
    }
    
    //Asistencia----------------------------------------------------------------
    public void onRowSelectDetalleAsistencia(SelectEvent event) {
        setDetalleSelec((CapacitacionXEmpleado) event.getObject());
        //getSessionBeanCAP().setDetalleCapSeleccionada((CapacitacionXEmpleado) event.getObject());
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        CapacitacionXEmpleado detalle = detalleSelec;
        Empleados empleado = detalle.getEmpleados();
        listaAsistencia = capacitacionSessionBean.findAsistenciaByDet(getSessionBeanADM().getCompania(), cap, empleado);
        nomEmp = detalleSelec.getEmpleados().getNombreCompleto();
    }
    
    public void rowEditListenerAsistencia(RowEditEvent event) {
        boolean hayError = false;
        CapacitacionAsistencia asistencia = (CapacitacionAsistencia) event.getObject();
        try {
            asistencia.setAsistio((asistencia.getAsiste()) ? "N" : "S");
            capacitacionSessionBean.editarAsistencia(asistencia);
            addMessage("Mantenimiento de Asistencia de Capacitacion.", "Asistencias actualizadas con éxito", TipoMensaje.INFORMACION);
            setDetalleSelec(null);
        } catch (Exception e) {
            addMessage("Mantenimiento de Asistencia de Capacitacion.", "Ha ocurrido un error al intentar actualizar la Asistencia de Capacitacion.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
    }
    
    //Notas---------------------------------------------------------------------
    public void rowEditListenerNotas(RowEditEvent event) {
        boolean hayError = false;
        CapacitacionXEmpleado detalle = (CapacitacionXEmpleado) event.getObject();
        //detalle.setNota(nota);
        try {
            capacitacionSessionBean.editarDetalleCapacitacion(detalle);
            addMessage("Mantenimiento de Detalle de Capacitacion.", "Datos actualizados con éxito", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Mantenimiento de Detalle de Capacitacion.", "Ha ocurrido un error al intentar actualizar el Detallle Capacitacion.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
    }
    
    public void guardar$notaCap$action(){
        isError = false;
        if(notaCapacitacion == null){
            isError = true;
        }
        if(isError)
            return;
        try{
            Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        cap.setNotaCapacitacion(notaCapacitacion);
        capacitacionSessionBean.editarCapacitacion(cap);
        addMessage("Mantenimiento de Detalle de Capacitacion.", "Nota general actualizada con éxito", TipoMensaje.INFORMACION);
        }catch (Exception e) {
            addMessage("Mantenimiento de Detalle de Capacitacion.", "Ha ocurrido un error al intentar actualizar la nota general.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
    }
       
}
//754 getSessionBeanCAP().getCapacitacionSeleccionada() E L I M I N A R