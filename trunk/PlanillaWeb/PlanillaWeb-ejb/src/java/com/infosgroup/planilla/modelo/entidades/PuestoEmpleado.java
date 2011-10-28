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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Entity
@Table(name = "puesto_empleado")
@NamedQueries({
    @NamedQuery(name = "PuestoEmpleado.findAll", query = "SELECT p FROM PuestoEmpleado p"),
    @NamedQuery(name = "PuestoEmpleado.findByIdCompania", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.idCompania = :idCompania"),
    @NamedQuery(name = "PuestoEmpleado.findByIdSucursal", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "PuestoEmpleado.findByIdEmpleado", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "PuestoEmpleado.findByIdTipoPuesto", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.idTipoPuesto = :idTipoPuesto"),
    @NamedQuery(name = "PuestoEmpleado.findByIdPuesto", query = "SELECT p FROM PuestoEmpleado p WHERE p.puestoEmpleadoPK.idPuesto = :idPuesto"),
    @NamedQuery(name = "PuestoEmpleado.findByFechaAsignacion", query = "SELECT p FROM PuestoEmpleado p WHERE p.fechaAsignacion = :fechaAsignacion")})
public class PuestoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuestoEmpleadoPK puestoEmpleadoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;

    public PuestoEmpleado() {
    }

    public PuestoEmpleado(PuestoEmpleadoPK puestoEmpleadoPK) {
        this.puestoEmpleadoPK = puestoEmpleadoPK;
    }

    public PuestoEmpleado(PuestoEmpleadoPK puestoEmpleadoPK, Date fechaAsignacion) {
        this.puestoEmpleadoPK = puestoEmpleadoPK;
        this.fechaAsignacion = fechaAsignacion;
    }

    public PuestoEmpleado(int idCompania, int idSucursal, int idEmpleado, int idTipoPuesto, int idPuesto) {
        this.puestoEmpleadoPK = new PuestoEmpleadoPK(idCompania, idSucursal, idEmpleado, idTipoPuesto, idPuesto);
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
