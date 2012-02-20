/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.catalogos;

import com.infosgroup.planilla.modelo.entidades.AreasStaff;
import com.infosgroup.planilla.modelo.entidades.AreasStaffPK;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.Locaciones;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import com.infosgroup.planilla.modelo.entidades.TipoPuesto;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "puestosBackendBean")
@ViewScoped
public class PuestosBackendBean extends AbstractJSFPage implements java.io.Serializable {

    /*EJB*/
    @EJB
    private ReclutamientoSessionBean reclutamientoFacade;
    /* Campos */
    private String nombre;
    private Boolean horasExtras;
    private Boolean horasDobles;
    private Boolean viaticos;
    private Boolean comision;
    private Boolean informacionConfidencial;
    private String codigoAlterno;
    private Double salarioMinimo;
    private Double salarioMaximo;
    private Short tipoPuesto;
    private String estado;
    private Short departamento;
    private Short area;
    private String descripcion;
    private String objetivo;
    private Short locacion;
    /* Listas */
    private java.util.List<TipoPuesto> listaTipoPuesto;
    private java.util.List<Departamentos> listaDepartamentos;
    private java.util.List<AreasStaff> listaAreas;
    private java.util.List<Locaciones> listaLocaciones;

    public PuestosBackendBean() {
    }

    public Short getArea() {
        return area;
    }

    public void setArea(Short area) {
        this.area = area;
    }

    public Boolean getComision() {
        return comision;
    }

    public void setComision(Boolean comision) {
        this.comision = comision;
    }

    public Short getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Short departamento) {
        this.departamento = departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getHorasDobles() {
        return horasDobles;
    }

    public void setHorasDobles(Boolean horasDobles) {
        this.horasDobles = horasDobles;
    }

    public Boolean getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(Boolean horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Double getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(Double salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public Double getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public Short getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(Short tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public Boolean getViaticos() {
        return viaticos;
    }

    public void setViaticos(Boolean viaticos) {
        this.viaticos = viaticos;
    }

    public Boolean getInformacionConfidencial() {
        return informacionConfidencial;
    }

    public void setInformacionConfidencial(Boolean informacionConfidencial) {
        this.informacionConfidencial = informacionConfidencial;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    public List<AreasStaff> getListaAreas() {
        listaAreas = reclutamientoFacade.findAreasStaffByCias(getSessionBeanADM().getCompania());
        return listaAreas;
    }

    public void setListaAreas(List<AreasStaff> listaAreas) {
        this.listaAreas = listaAreas;
    }

    public List<Departamentos> getListaDepartamentos() {
        listaDepartamentos = reclutamientoFacade.findDepartamentosByCias(getSessionBeanADM().getCompania());
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<TipoPuesto> getListaTipoPuesto() {
        listaTipoPuesto = reclutamientoFacade.getTipoPuestosByEmpresa(getSessionBeanADM().getCompania());
        return listaTipoPuesto;
    }

    public void setListaTipoPuesto(List<TipoPuesto> listaTipoPuesto) {
        this.listaTipoPuesto = listaTipoPuesto;
    }

    public Short getLocacion() {
        return locacion;
    }

    public void setLocacion(Short locacion) {
        this.locacion = locacion;
    }

    public List<Locaciones> getListaLocaciones() {
        listaLocaciones = reclutamientoFacade.findLocacionesByCias(getSessionBeanADM().getCompania());
        return listaLocaciones;
    }

    public void setListaLocaciones(List<Locaciones> listaLocaciones) {
        this.listaLocaciones = listaLocaciones;
    }

    /* Acciones */
    public String guardar$crud$action() {
        Puestos nuevoPuesto = new Puestos();
        nuevoPuesto.setNomPuesto(nombre);
        nuevoPuesto.setHorasExt(horasExtras == true ? "S" : "N");
        nuevoPuesto.setHorasDob(horasDobles == true ? "S" : "N");
        nuevoPuesto.setViaticos(viaticos == true ? "S" : "N");
        nuevoPuesto.setComision(comision == true ? "S" : "N");
        nuevoPuesto.setInfConf(informacionConfidencial == true ? "S" : "N");
        nuevoPuesto.setSalMinimo(salarioMinimo != null ? new BigDecimal(salarioMinimo) : BigDecimal.ZERO);
        nuevoPuesto.setSalMaximo(salarioMaximo != null ? new BigDecimal(salarioMaximo) : BigDecimal.ZERO);
        nuevoPuesto.setCodTipoPuesto(tipoPuesto);
        nuevoPuesto.setStatus(estado);
        nuevoPuesto.setCodDepto((departamento != null && departamento != -1) ? departamento : null);
        nuevoPuesto.setAreasStaff((area != null && area != -1) ? new AreasStaff(new AreasStaffPK(getSessionBeanADM().getCompania().getCodCia(), area)) : null);
        nuevoPuesto.setCodAlterno(codigoAlterno);
        nuevoPuesto.setDescPuesto(descripcion);
        nuevoPuesto.setObjetivo(objetivo);
        try {
            reclutamientoFacade.guardarPuesto(nuevoPuesto, getSessionBeanADM().getCompania());
            addMessage("Mantenimiento de Puestos", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Mantenimiento de Puestos", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.INFORMACION);
            e.printStackTrace();
        }

        return null;
    }

    public void eliminar$crud$action(ActionEvent actionEvent) {
    }

    public String editar$crud$action() {
        return null;
    }

    public Boolean validarFormulario() {
        Boolean e = Boolean.TRUE;
        if (nombre == null || nombre.length() <= 0) {
            e = Boolean.FALSE;
        }
        return e;
    }

    @Override
    protected void limpiarCampos() {
        setNombre("");
        setHorasExtras(Boolean.FALSE);
        setHorasDobles(Boolean.FALSE);
        setViaticos(Boolean.FALSE);
        setComision(Boolean.FALSE);
        setSalarioMinimo(0.0);
        setSalarioMaximo(0.0);
        setTipoPuesto(new Short("-1"));
        setEstado("-1");
        setDepartamento(new Short("-1"));
        setArea(area);
        setDescripcion("");
        setObjetivo("");
    }
}
