/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_PRESUPUESTO_HORAS_SUCURSAL", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetPresupuestoHorasSucursal.findAll", query = "SELECT d FROM DetPresupuestoHorasSucursal d"),
    @NamedQuery(name = "DetPresupuestoHorasSucursal.findByCodCia", query = "SELECT d FROM DetPresupuestoHorasSucursal d WHERE d.detPresupuestoHorasSucursalPK.codCia = :codCia"),
    @NamedQuery(name = "DetPresupuestoHorasSucursal.findByAnio", query = "SELECT d FROM DetPresupuestoHorasSucursal d WHERE d.detPresupuestoHorasSucursalPK.anio = :anio"),
    @NamedQuery(name = "DetPresupuestoHorasSucursal.findByMes", query = "SELECT d FROM DetPresupuestoHorasSucursal d WHERE d.detPresupuestoHorasSucursalPK.mes = :mes"),
    @NamedQuery(name = "DetPresupuestoHorasSucursal.findByCorrelat", query = "SELECT d FROM DetPresupuestoHorasSucursal d WHERE d.detPresupuestoHorasSucursalPK.correlat = :correlat"),
    @NamedQuery(name = "DetPresupuestoHorasSucursal.findByCodPuesto", query = "SELECT d FROM DetPresupuestoHorasSucursal d WHERE d.detPresupuestoHorasSucursalPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "DetPresupuestoHorasSucursal.findByEstado", query = "SELECT d FROM DetPresupuestoHorasSucursal d WHERE d.estado = :estado"),
    @NamedQuery(name = "DetPresupuestoHorasSucursal.findByHorasPresup", query = "SELECT d FROM DetPresupuestoHorasSucursal d WHERE d.horasPresup = :horasPresup")})
public class DetPresupuestoHorasSucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetPresupuestoHorasSucursalPK detPresupuestoHorasSucursalPK;
    @Size(max = 3)
    @Column(name = "ESTADO", length = 3)
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HORAS_PRESUP", precision = 6, scale = 2)
    private BigDecimal horasPresup;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "MES", referencedColumnName = "MES", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CORRELAT", referencedColumnName = "CORRELAT", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PresupuestoHorasSucursal presupuestoHorasSucursal;

    public DetPresupuestoHorasSucursal() {
    }

    public DetPresupuestoHorasSucursal(DetPresupuestoHorasSucursalPK detPresupuestoHorasSucursalPK) {
        this.detPresupuestoHorasSucursalPK = detPresupuestoHorasSucursalPK;
    }

    public DetPresupuestoHorasSucursal(short codCia, short anio, short mes, int correlat, short codPuesto) {
        this.detPresupuestoHorasSucursalPK = new DetPresupuestoHorasSucursalPK(codCia, anio, mes, correlat, codPuesto);
    }

    public DetPresupuestoHorasSucursalPK getDetPresupuestoHorasSucursalPK() {
        return detPresupuestoHorasSucursalPK;
    }

    public void setDetPresupuestoHorasSucursalPK(DetPresupuestoHorasSucursalPK detPresupuestoHorasSucursalPK) {
        this.detPresupuestoHorasSucursalPK = detPresupuestoHorasSucursalPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getHorasPresup() {
        return horasPresup;
    }

    public void setHorasPresup(BigDecimal horasPresup) {
        this.horasPresup = horasPresup;
    }

    public PresupuestoHorasSucursal getPresupuestoHorasSucursal() {
        return presupuestoHorasSucursal;
    }

    public void setPresupuestoHorasSucursal(PresupuestoHorasSucursal presupuestoHorasSucursal) {
        this.presupuestoHorasSucursal = presupuestoHorasSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detPresupuestoHorasSucursalPK != null ? detPresupuestoHorasSucursalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPresupuestoHorasSucursal)) {
            return false;
        }
        DetPresupuestoHorasSucursal other = (DetPresupuestoHorasSucursal) object;
        if ((this.detPresupuestoHorasSucursalPK == null && other.detPresupuestoHorasSucursalPK != null) || (this.detPresupuestoHorasSucursalPK != null && !this.detPresupuestoHorasSucursalPK.equals(other.detPresupuestoHorasSucursalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetPresupuestoHorasSucursal[ detPresupuestoHorasSucursalPK=" + detPresupuestoHorasSucursalPK + " ]";
    }
    
}
