/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PUESTO_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuestoEmpleado.findAll", query = "SELECT p FROM PuestoEmpleado p"),
    @NamedQuery(name = "PuestoEmpleado.findByCodCia", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.codCia = :codCia"),
    @NamedQuery(name = "PuestoEmpleado.findByCodSucursal", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.codSucursal = :codSucursal"),
    @NamedQuery(name = "PuestoEmpleado.findByCodEmp", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.codEmp = :codEmp"),
    @NamedQuery(name = "PuestoEmpleado.findByCodTipoPuesto", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.codTipoPuesto = :codTipoPuesto"),
    @NamedQuery(name = "PuestoEmpleado.findByCodPuesto", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "PuestoEmpleado.findByFechaAsignacion", query = "SELECT p FROM PuestoEmpleado p WHERE p.fechaAsignacion = :fechaAsignacion")})
public class PuestoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuestoEmpleadoPK puestoEmpleadoPK;
    @Basic(optional = false)
    @Column(name = "FECHA_ASIGNACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_PUESTO", referencedColumnName = "COD_TIPO_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoPuesto tipoPuesto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Puestos puestos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_SUCURSAL", referencedColumnName = "COD_AGENCIA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Agencias agencias;

    public PuestoEmpleado() {
    }

    public PuestoEmpleado(PuestoEmpleadoPK puestoEmpleadoPK) {
        this.puestoEmpleadoPK = puestoEmpleadoPK;
    }

    public PuestoEmpleado(PuestoEmpleadoPK puestoEmpleadoPK, Date fechaAsignacion) {
        this.puestoEmpleadoPK = puestoEmpleadoPK;
        this.fechaAsignacion = fechaAsignacion;
    }

    public PuestoEmpleado(long codCia, long codSucursal, long codEmp, long codTipoPuesto, long codPuesto) {
        this.puestoEmpleadoPK = new PuestoEmpleadoPK(codCia, codSucursal, codEmp, codTipoPuesto, codPuesto);
    }

    public PuestoEmpleadoPK getPuestoEmpleadoPK() {
        return puestoEmpleadoPK;
    }

    public void setPuestoEmpleadoPK(PuestoEmpleadoPK puestoEmpleadoPK) {
        this.puestoEmpleadoPK = puestoEmpleadoPK;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public TipoPuesto getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(TipoPuesto tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Agencias getAgencias() {
        return agencias;
    }

    public void setAgencias(Agencias agencias) {
        this.agencias = agencias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puestoEmpleadoPK != null ? puestoEmpleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuestoEmpleado)) {
            return false;
        }
        PuestoEmpleado other = (PuestoEmpleado) object;
        if ((this.puestoEmpleadoPK == null && other.puestoEmpleadoPK != null) || (this.puestoEmpleadoPK != null && !this.puestoEmpleadoPK.equals(other.puestoEmpleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PuestoEmpleado[ puestoEmpleadoPK=" + puestoEmpleadoPK + " ]";
    }
    
}
