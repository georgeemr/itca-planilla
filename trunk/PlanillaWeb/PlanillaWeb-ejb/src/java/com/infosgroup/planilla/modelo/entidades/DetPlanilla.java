/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "det_planilla")
@NamedQueries({
    @NamedQuery(name = "DetPlanilla.findAll", query = "SELECT d FROM DetPlanilla d"),
    @NamedQuery(name = "DetPlanilla.findByIdCompania", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.idCompania = :idCompania"),
    @NamedQuery(name = "DetPlanilla.findByAnio", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.anio = :anio"),
    @NamedQuery(name = "DetPlanilla.findByMes", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.mes = :mes"),
    @NamedQuery(name = "DetPlanilla.findByNumPlanilla", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "DetPlanilla.findByIdEmpleado", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "DetPlanilla.findByIdPrestacion", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.idPrestacion = :idPrestacion"),
    @NamedQuery(name = "DetPlanilla.findByMonto", query = "SELECT d FROM DetPlanilla d WHERE d.monto = :monto")})
public class DetPlanilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetPlanillaPK detPlanillaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto", precision = 17, scale = 17)
    private Double monto;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "anio", referencedColumnName = "anio", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "mes", referencedColumnName = "mes", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "num_planilla", referencedColumnName = "num_planilla", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Planilla planilla;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_empleado", referencedColumnName = "cod_emp", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_prestacion", referencedColumnName = "id_prestacion", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private DeduccionesPrestaciones deduccionesPrestaciones;

    public DetPlanilla() {
    }

    public DetPlanilla(DetPlanillaPK detPlanillaPK) {
        this.detPlanillaPK = detPlanillaPK;
    }

    public DetPlanilla(int idCompania, int anio, int mes, int numPlanilla, int idEmpleado, int idPrestacion) {
        this.detPlanillaPK = new DetPlanillaPK(idCompania, anio, mes, numPlanilla, idEmpleado, idPrestacion);
    }

    public DetPlanillaPK getDetPlanillaPK() {
        return detPlanillaPK;
    }

    public void setDetPlanillaPK(DetPlanillaPK detPlanillaPK) {
        this.detPlanillaPK = detPlanillaPK;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public DeduccionesPrestaciones getDeduccionesPrestaciones() {
        return deduccionesPrestaciones;
    }

    public void setDeduccionesPrestaciones(DeduccionesPrestaciones deduccionesPrestaciones) {
        this.deduccionesPrestaciones = deduccionesPrestaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detPlanillaPK != null ? detPlanillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPlanilla)) {
            return false;
        }
        DetPlanilla other = (DetPlanilla) object;
        if ((this.detPlanillaPK == null && other.detPlanillaPK != null) || (this.detPlanillaPK != null && !this.detPlanillaPK.equals(other.detPlanillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetPlanilla[ detPlanillaPK=" + detPlanillaPK + " ]";
    }
    
}
