/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CAPACITACION_X_EMPLEADO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapacitacionXEmpleado.findAll", query = "SELECT c FROM CapacitacionXEmpleado c"),
    @NamedQuery(name = "CapacitacionXEmpleado.findByCodCia", query = "SELECT c FROM CapacitacionXEmpleado c WHERE c.capacitacionXEmpleadoPK.codCia = :codCia"),
    @NamedQuery(name = "CapacitacionXEmpleado.findByCodCapacitacion", query = "SELECT c FROM CapacitacionXEmpleado c WHERE c.capacitacionXEmpleadoPK.codCapacitacion = :codCapacitacion"),
    @NamedQuery(name = "CapacitacionXEmpleado.findByCodEmp", query = "SELECT c FROM CapacitacionXEmpleado c WHERE c.capacitacionXEmpleadoPK.codEmp = :codEmp"),
    @NamedQuery(name = "CapacitacionXEmpleado.findByNota", query = "SELECT c FROM CapacitacionXEmpleado c WHERE c.nota = :nota")})
public class CapacitacionXEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitacionXEmpleadoPK capacitacionXEmpleadoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "NOTA", nullable = false, precision = 5, scale = 2)
    private BigDecimal nota;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAPACITACION", referencedColumnName = "COD_CAPACITACION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Capacitacion capacitacion;

    public CapacitacionXEmpleado() {
    }

    public CapacitacionXEmpleado(CapacitacionXEmpleadoPK capacitacionXEmpleadoPK) {
        this.capacitacionXEmpleadoPK = capacitacionXEmpleadoPK;
    }

    public CapacitacionXEmpleado(CapacitacionXEmpleadoPK capacitacionXEmpleadoPK, BigDecimal nota) {
        this.capacitacionXEmpleadoPK = capacitacionXEmpleadoPK;
        this.nota = nota;
    }

    public CapacitacionXEmpleado(short codCia, int codCapacitacion, int codEmp) {
        this.capacitacionXEmpleadoPK = new CapacitacionXEmpleadoPK(codCia, codCapacitacion, codEmp);
    }

    public CapacitacionXEmpleadoPK getCapacitacionXEmpleadoPK() {
        return capacitacionXEmpleadoPK;
    }

    public void setCapacitacionXEmpleadoPK(CapacitacionXEmpleadoPK capacitacionXEmpleadoPK) {
        this.capacitacionXEmpleadoPK = capacitacionXEmpleadoPK;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capacitacionXEmpleadoPK != null ? capacitacionXEmpleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionXEmpleado)) {
            return false;
        }
        CapacitacionXEmpleado other = (CapacitacionXEmpleado) object;
        if ((this.capacitacionXEmpleadoPK == null && other.capacitacionXEmpleadoPK != null) || (this.capacitacionXEmpleadoPK != null && !this.capacitacionXEmpleadoPK.equals(other.capacitacionXEmpleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CapacitacionXEmpleado[ capacitacionXEmpleadoPK=" + capacitacionXEmpleadoPK + " ]";
    }
    
}
