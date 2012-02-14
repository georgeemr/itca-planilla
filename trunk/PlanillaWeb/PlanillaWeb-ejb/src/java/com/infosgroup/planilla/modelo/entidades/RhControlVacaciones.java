/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "RH_CONTROL_VACACIONES", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhControlVacaciones.findAll", query = "SELECT r FROM RhControlVacaciones r"),
    @NamedQuery(name = "RhControlVacaciones.findByCodCia", query = "SELECT r FROM RhControlVacaciones r WHERE r.rhControlVacacionesPK.codCia = :codCia"),
    @NamedQuery(name = "RhControlVacaciones.findByCodEmp", query = "SELECT r FROM RhControlVacaciones r WHERE r.rhControlVacacionesPK.codEmp = :codEmp"),
    @NamedQuery(name = "RhControlVacaciones.findByAnio", query = "SELECT r FROM RhControlVacaciones r WHERE r.rhControlVacacionesPK.anio = :anio"),
    @NamedQuery(name = "RhControlVacaciones.findByFecInicio", query = "SELECT r FROM RhControlVacaciones r WHERE r.fecInicio = :fecInicio"),
    @NamedQuery(name = "RhControlVacaciones.findByFecFin", query = "SELECT r FROM RhControlVacaciones r WHERE r.fecFin = :fecFin"),
    @NamedQuery(name = "RhControlVacaciones.findByDiasPagados", query = "SELECT r FROM RhControlVacaciones r WHERE r.diasPagados = :diasPagados"),
    @NamedQuery(name = "RhControlVacaciones.findByDiasXPagar", query = "SELECT r FROM RhControlVacaciones r WHERE r.diasXPagar = :diasXPagar"),
    @NamedQuery(name = "RhControlVacaciones.findByDiasDevengados", query = "SELECT r FROM RhControlVacaciones r WHERE r.diasDevengados = :diasDevengados"),
    @NamedQuery(name = "RhControlVacaciones.findByDiasXDevengar", query = "SELECT r FROM RhControlVacaciones r WHERE r.diasXDevengar = :diasXDevengar"),
    @NamedQuery(name = "RhControlVacaciones.findBySaldo", query = "SELECT r FROM RhControlVacaciones r WHERE r.saldo = :saldo"),
    @NamedQuery(name = "RhControlVacaciones.findByEstado", query = "SELECT r FROM RhControlVacaciones r WHERE r.estado = :estado")})
public class RhControlVacaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RhControlVacacionesPK rhControlVacacionesPK;
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio;
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DIAS_PAGADOS", precision = 5, scale = 2)
    private BigDecimal diasPagados;
    @Column(name = "DIAS_X_PAGAR", precision = 5, scale = 2)
    private BigDecimal diasXPagar;
    @Column(name = "DIAS_DEVENGADOS", precision = 5, scale = 2)
    private BigDecimal diasDevengados;
    @Column(name = "DIAS_X_DEVENGAR", precision = 5, scale = 2)
    private BigDecimal diasXDevengar;
    @Column(name = "SALDO", precision = 5, scale = 2)
    private BigDecimal saldo;
    @Size(max = 1)
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public RhControlVacaciones() {
    }

    public RhControlVacaciones(RhControlVacacionesPK rhControlVacacionesPK) {
        this.rhControlVacacionesPK = rhControlVacacionesPK;
    }

    public RhControlVacaciones(short codCia, int codEmp, short anio) {
        this.rhControlVacacionesPK = new RhControlVacacionesPK(codCia, codEmp, anio);
    }

    public RhControlVacacionesPK getRhControlVacacionesPK() {
        return rhControlVacacionesPK;
    }

    public void setRhControlVacacionesPK(RhControlVacacionesPK rhControlVacacionesPK) {
        this.rhControlVacacionesPK = rhControlVacacionesPK;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public BigDecimal getDiasPagados() {
        return diasPagados;
    }

    public void setDiasPagados(BigDecimal diasPagados) {
        this.diasPagados = diasPagados;
    }

    public BigDecimal getDiasXPagar() {
        return diasXPagar;
    }

    public void setDiasXPagar(BigDecimal diasXPagar) {
        this.diasXPagar = diasXPagar;
    }

    public BigDecimal getDiasDevengados() {
        return diasDevengados;
    }

    public void setDiasDevengados(BigDecimal diasDevengados) {
        this.diasDevengados = diasDevengados;
    }

    public BigDecimal getDiasXDevengar() {
        return diasXDevengar;
    }

    public void setDiasXDevengar(BigDecimal diasXDevengar) {
        this.diasXDevengar = diasXDevengar;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rhControlVacacionesPK != null ? rhControlVacacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhControlVacaciones)) {
            return false;
        }
        RhControlVacaciones other = (RhControlVacaciones) object;
        if ((this.rhControlVacacionesPK == null && other.rhControlVacacionesPK != null) || (this.rhControlVacacionesPK != null && !this.rhControlVacacionesPK.equals(other.rhControlVacacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RhControlVacaciones[ rhControlVacacionesPK=" + rhControlVacacionesPK + " ]";
    }
    
}
