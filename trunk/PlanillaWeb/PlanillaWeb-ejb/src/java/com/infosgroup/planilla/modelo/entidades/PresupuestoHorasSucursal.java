/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PRESUPUESTO_HORAS_SUCURSAL", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoHorasSucursal.findAll", query = "SELECT p FROM PresupuestoHorasSucursal p"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByCodCia", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.presupuestoHorasSucursalPK.codCia = :codCia"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByAnio", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.presupuestoHorasSucursalPK.anio = :anio"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByMes", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.presupuestoHorasSucursalPK.mes = :mes"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByCodDepto", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.codDepto = :codDepto"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByCodSucursal", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.codSucursal = :codSucursal"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByFechaInicio", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByFechaFinal", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByEstado", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.estado = :estado"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByObservacion", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PresupuestoHorasSucursal.findByCorrelat", query = "SELECT p FROM PresupuestoHorasSucursal p WHERE p.presupuestoHorasSucursalPK.correlat = :correlat")})
public class PresupuestoHorasSucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoHorasSucursalPK presupuestoHorasSucursalPK;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Size(max = 2)
    @Column(name = "COD_SUCURSAL", length = 2)
    private String codSucursal;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Size(max = 3)
    @Column(name = "ESTADO", length = 3)
    private String estado;
    @Size(max = 100)
    @Column(name = "OBSERVACION", length = 100)
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestoHorasSucursal")
    private List<DetPresupuestoHorasSucursal> detPresupuestoHorasSucursalList;

    public PresupuestoHorasSucursal() {
    }

    public PresupuestoHorasSucursal(PresupuestoHorasSucursalPK presupuestoHorasSucursalPK) {
        this.presupuestoHorasSucursalPK = presupuestoHorasSucursalPK;
    }

    public PresupuestoHorasSucursal(short codCia, short anio, short mes, int correlat) {
        this.presupuestoHorasSucursalPK = new PresupuestoHorasSucursalPK(codCia, anio, mes, correlat);
    }

    public PresupuestoHorasSucursalPK getPresupuestoHorasSucursalPK() {
        return presupuestoHorasSucursalPK;
    }

    public void setPresupuestoHorasSucursalPK(PresupuestoHorasSucursalPK presupuestoHorasSucursalPK) {
        this.presupuestoHorasSucursalPK = presupuestoHorasSucursalPK;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<DetPresupuestoHorasSucursal> getDetPresupuestoHorasSucursalList() {
        return detPresupuestoHorasSucursalList;
    }

    public void setDetPresupuestoHorasSucursalList(List<DetPresupuestoHorasSucursal> detPresupuestoHorasSucursalList) {
        this.detPresupuestoHorasSucursalList = detPresupuestoHorasSucursalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestoHorasSucursalPK != null ? presupuestoHorasSucursalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoHorasSucursal)) {
            return false;
        }
        PresupuestoHorasSucursal other = (PresupuestoHorasSucursal) object;
        if ((this.presupuestoHorasSucursalPK == null && other.presupuestoHorasSucursalPK != null) || (this.presupuestoHorasSucursalPK != null && !this.presupuestoHorasSucursalPK.equals(other.presupuestoHorasSucursalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PresupuestoHorasSucursal[ presupuestoHorasSucursalPK=" + presupuestoHorasSucursalPK + " ]";
    }
    
}
