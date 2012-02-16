/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.catalogos;

import com.infosgroup.planilla.modelo.entidades.AreasStaff;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.TipoPuesto;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
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
    private Double comision;
    private Double salarioMinimo;
    private Double salarioMaximo;
    private Short tipoPuesto;
    private String estado;
    private Short departamento;
    private Short area;
    private String descripcion;
    private String objetivo;

    /* Listas */
    private java.util.List<TipoPuesto> listaTipoPuesto;
    private java.util.List<Departamentos> listaDepartamentos;
    private java.util.List<AreasStaff> listaAreas;

    public PuestosBackendBean() {
    }

    public Short getArea() {
        return area;
    }

    public void setArea(Short area) {
        this.area = area;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
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

    public List<AreasStaff> getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(List<AreasStaff> listaAreas) {
        this.listaAreas = listaAreas;
    }

    public List<Departamentos> getListaDepartamentos() {
        listaDepartamentos = reclutamientoFacade.findDepartamentosByCias( getSessionBeanADM().getCompania() );
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<TipoPuesto> getListaTipoPuesto() {
        listaTipoPuesto = reclutamientoFacade.getTipoPuestosByEmpresa( getSessionBeanADM().getCompania() );
        return listaTipoPuesto;
    }

    public void setListaTipoPuesto(List<TipoPuesto> listaTipoPuesto) {
        this.listaTipoPuesto = listaTipoPuesto;
    }

    /* Acciones */
    public String guardar$crud$action() {
        return null;
    }

    public void eliminar$crud$action(ActionEvent actionEvent) {
    }

    public String editar$crud$action() {
        return null;
    }

    @Override
    protected void limpiarCampos() {
        setNombre("");
        setHorasExtras(Boolean.FALSE);
        setHorasDobles(Boolean.FALSE);
        setViaticos(Boolean.FALSE);
        setComision(0.0);
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
