/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Sucursal sucursal;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_puesto", referencedColumnName = "cod_puesto", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Puesto puesto;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_empleado", referencedColumnName = "cod_emp", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleado empleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestoEmpleado")
    private List<ResumenAsistencia> resumenAsistenciaList;

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

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<ResumenAsistencia> getResumenAsistenciaList() {
        return resumenAsistenciaList;
    }

    public void setResumenAsistenciaList(List<ResumenAsistencia> resumenAsistenciaList) {
        this.resumenAsistenciaList = resumenAsistenciaList;
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
