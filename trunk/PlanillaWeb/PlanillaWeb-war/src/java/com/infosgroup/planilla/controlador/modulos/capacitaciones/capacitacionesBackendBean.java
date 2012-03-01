/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.capacitaciones;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAreas;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAreasPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionTemas;
import com.infosgroup.planilla.modelo.entidades.CapacitacionTemasPK;
import com.infosgroup.planilla.modelo.entidades.Capacitadores;
import com.infosgroup.planilla.modelo.entidades.CapacitadoresPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Instituciones;
import com.infosgroup.planilla.modelo.entidades.InstitucionesPK;
import com.infosgroup.planilla.modelo.procesos.CapacitacionesSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "capacitaciones$capacitaciones")
@ViewScoped
public class capacitacionesBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private CapacitacionesSessionBean capacitacionSessionBean;
    private Boolean isError;
    private String status;
    private String nombre;
    private Date fechaInicial;
    private Date fechaFinal;
    private BigDecimal duracion;
    private String impartido;
    private String razon;
    private BigDecimal costoRazon;
    private String codCap;
    private Short inst;
    private Integer codArea;
    private Integer codTema;
    private Long codCapacitador;
    private List<Instituciones> listaInst;
    private List<Capacitacion> listaCap;
    private List<CapacitacionAreas> listaArea;
    private List<CapacitacionTemas> listaTemas;
    private List<Capacitadores> listaCapacitadores;
    private DataTable tableCapacitaciones;
    
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

    public BigDecimal getCostoRazon() {
        return costoRazon;
    }

    public void setCostoRazon(BigDecimal costoRazon) {
        this.costoRazon = costoRazon;
    }

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

    public DataTable getTableCapacitaciones() {
        return tableCapacitaciones;
    }

    public void setTableCapacitaciones(DataTable tableCapacitaciones) {
        this.tableCapacitaciones = tableCapacitaciones;
    }

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
        setCostoRazon(null);
        setDuracion(null);
        setCodArea(null);
        setCodCapacitador(null);
        setCodTema(null);
        
    }
    
    public capacitacionesBackendBean(){
        
    }
    
    public void nuevo$vh$action() {
        setEstadoAccion(0);
    }

    public void consultar$vh$action() {
        setEstadoAccion(2);
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
        Short c = getSessionBeanADM().getCompania().getCodCia();
        if (isError) {
            return null;
        }

        Capacitacion capacitacion = new Capacitacion();
        //Concurso concurso = new Concurso();
        /* Crear Capacitacion */
        if (getSessionBeanADM().getEstadoAccion() == null || getSessionBeanADM().getEstadoAccion().equals(0)) {
            CapacitacionPK pk = new CapacitacionPK();
            pk.setCodCia(c);
            Cias ciaCod = getSessionBeanADM().getCompania();
            Integer cod = capacitacionSessionBean.getMaxCapacitacion(ciaCod);
            pk.setCodCapacitacion(cod);
            capacitacion.setCapacitacionPK(pk);
            CapacitacionAreas area = capacitacionSessionBean.findByAreaId(new CapacitacionAreasPK(getSessionBeanADM().getCompania().getCodCia(), codArea));
            capacitacion.setCapacitacionAreas(area);
            CapacitacionTemas tema = capacitacionSessionBean.findByTemaId(new CapacitacionTemasPK(getSessionBeanADM().getCompania().getCodCia(),area.getCapacitacionAreasPK().getCodArea(), codTema));
            capacitacion.setCapacitacionTemas(tema);
            Capacitadores capacitador = capacitacionSessionBean.findByCapId(new CapacitadoresPK(getSessionBeanADM().getCompania().getCodCia(), codCapacitador));
            capacitacion.setCapacitadores(capacitador);
            capacitacion.setStatus(status);
            capacitacion.setNomCapacitacion(nombre.toUpperCase());
            capacitacion.setInstituciones(capacitacionSessionBean.findByInstId(new InstitucionesPK(inst, c)));
            capacitacion.setFechaDesde(fechaInicial);
            capacitacion.setFechaHasta(fechaFinal);
            capacitacion.setDuracion(duracion);
            capacitacion.setImpartidaPor(impartido.toUpperCase());
            capacitacion.setRazon(razon.toUpperCase());
            capacitacion.setCostoRazon(costoRazon);
            try {
                capacitacionSessionBean.guardarCapacitacion(capacitacion);
                addMessage("Mantenimiento de Capacitaciones.", "Datos guardados con éxito", TipoMensaje.INFORMACION);
                limpiarCampos();
            } catch (Exception e) {
                addMessage("Mantenimiento de Capacitaciones.", "Ha ocurrido un error al intentar guardar la capacitacion.", TipoMensaje.ERROR);
                System.out.println(e.getMessage());
            }
        } else if (getSessionBeanADM().getEstadoAccion().equals(1)) {
            /* Modificar Concurso */
            capacitacion = getSessionBeanCAP().getCapacitacionSeleccionada();
            if (capacitacion == null) {
                addMessage("Mantenimiento de Concursos.", "No ha seleccionado ningún concurso para editar.", TipoMensaje.ERROR);
                return null;
            }
            CapacitacionAreas area = capacitacionSessionBean.findByAreaId(new CapacitacionAreasPK(getSessionBeanADM().getCompania().getCodCia(), codArea));
            capacitacion.setCapacitacionAreas(area);
            CapacitacionTemasPK temaPK = new CapacitacionTemasPK(getSessionBeanADM().getCompania().getCodCia(),area.getCapacitacionAreasPK().getCodArea(), codTema);
            CapacitacionTemas tema = capacitacionSessionBean.findByTemaId(temaPK);
            capacitacion.setCapacitacionTemas(tema);
            CapacitadoresPK capPK = new CapacitadoresPK(getSessionBeanADM().getCompania().getCodCia(), codCapacitador);
            Capacitadores capacitador = capacitacionSessionBean.findByCapId(capPK);
            capacitacion.setCapacitadores(capacitador);
            capacitacion.setNomCapacitacion(nombre);
            capacitacion.setFechaDesde(fechaInicial);
            capacitacion.setFechaHasta(fechaFinal);
            capacitacion.setDuracion(duracion);
            capacitacion.setImpartidaPor(impartido);
            capacitacion.setRazon(razon);
            capacitacion.setCostoRazon(costoRazon);
            capacitacion.setStatus(status);
            try {
                capacitacionSessionBean.editarCapacitacion(capacitacion);
                addMessage("Mantenimiento de Capacitacion.", "Datos actualizados con éxito", TipoMensaje.INFORMACION);
                limpiarCampos();
            } catch (Exception e) {
                addMessage("Mantenimiento de Capacitacion.", "Ha ocurrido un error al intentar actualizar la Capacitacion.", TipoMensaje.ERROR);
                System.out.println(e.getMessage());
            }
        }

        return null;
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
        setCostoRazon(cap.getCostoRazon());
        setCodArea(cap.getCapacitacionAreas().getCapacitacionAreasPK().getCodArea());
        setCodTema(cap.getCapacitacionTemas().getCapacitacionTemasPK().getCodTema());
        setCodCapacitador(cap.getCapacitadores().getCapacitadoresPK().getCodCapacitador());
        getSessionBeanADM().setEstadoAccion( 1 );
        return null;
    }
    
    public void onRowSelectConcurso(SelectEvent event) {
        getSessionBeanCAP().setCapacitacionSeleccionada((Capacitacion) event.getObject());
    }

    public void onRowUnSelectConcurso(UnselectEvent event) {
        getSessionBeanCAP().setCapacitacionSeleccionada(null);
    }
    
    public void eliminar$crud$action(ActionEvent actionEvent) {
        if (getSessionBeanCAP().getCapacitacionSeleccionada() == null) {
            addMessage("Mantenimiento de Capacitaciones", "Primero seleccione una Capacitacion", TipoMensaje.ERROR);
            return;
        }
        try {
            Capacitacion capEliminar = getSessionBeanCAP().getCapacitacionSeleccionada();
            capacitacionSessionBean.eliminarCapacitacion(capEliminar);
            addMessage("Mantenimiento de Capacitaciones.", "Datos eliminados con éxito", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Mantenimiento de Capacitacion.", "Ha ocurrido un error al intentar remover la Capacitacion.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
        listaCap = capacitacionSessionBean.findCapByEmpresa(getSessionBeanADM().getCompania());
    }
    
}