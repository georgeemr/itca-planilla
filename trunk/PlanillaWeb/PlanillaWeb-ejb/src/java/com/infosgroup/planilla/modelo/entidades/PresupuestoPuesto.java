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
@Table(name = "PRESUPUESTO_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoPuesto.findAll", query = "SELECT p FROM PresupuestoPuesto p"),
    @NamedQuery(name = "PresupuestoPuesto.findByCodCia", query = "SELECT p FROM PresupuestoPuesto p WHERE p.presupuestoPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "PresupuestoPuesto.findByPeriodo", query = "SELECT p FROM PresupuestoPuesto p WHERE p.presupuestoPuestoPK.periodo = :periodo"),
    @NamedQuery(name = "PresupuestoPuesto.findByCodDepto", query = "SELECT p FROM PresupuestoPuesto p WHERE p.presupuestoPuestoPK.codDepto = :codDepto"),
    @NamedQuery(name = "PresupuestoPuesto.findByCodPuesto", query = "SELECT p FROM PresupuestoPuesto p WHERE p.presupuestoPuestoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "PresupuestoPuesto.findByDescripcion", query = "SELECT p FROM PresupuestoPuesto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PresupuestoPuesto.findByCantidad", query = "SELECT p FROM PresupuestoPuesto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PresupuestoPuesto.findByValorPresupuestado", query = "SELECT p FROM PresupuestoPuesto p WHERE p.valorPresupuestado = :valorPresupuestado"),
    @NamedQuery(name = "PresupuestoPuesto.findByValorAprobado", query = "SELECT p FROM PresupuestoPuesto p WHERE p.valorAprobado = :valorAprobado"),
    @NamedQuery(name = "PresupuestoPuesto.findByEstado", query = "SELECT p FROM PresupuestoPuesto p WHERE p.estado = :estado")})
public class PresupuestoPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoPuestoPK presupuestoPuestoPK;
    @Size(max = 100)
    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;
    @Column(name = "CANTIDAD")
    private Short cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_PRESUPUESTADO", precision = 16, scale = 3)
    private BigDecimal valorPresupuestado;
    @Column(name = "VALOR_APROBADO", precision = 16, scale = 3)
    private BigDecimal valorAprobado;
    @Size(max = 3)
    @Column(name = "ESTADO", length = 3)
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PresupuestoDepto presupuestoDepto;

    public PresupuestoPuesto() {
    }

    public PresupuestoPuesto(PresupuestoPuestoPK presupuestoPuestoPK) {
        this.presupuestoPuestoPK = presupuestoPuestoPK;
    }

    public PresupuestoPuesto(short codCia, short periodo, short codDepto, short codPuesto) {
        this.presupuestoPuestoPK = new PresupuestoPuestoPK(codCia, periodo, codDepto, codPuesto);
    }

    public PresupuestoPuestoPK getPresupuestoPuestoPK() {
        return presupuestoPuestoPK;
    }

    public void setPresupuestoPuestoPK(PresupuestoPuestoPK presupuestoPuestoPK) {
        this.presupuestoPuestoPK = presupuestoPuestoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorPresupuestado() {
        return valorPresupuestado;
    }

    public void setValorPresupuestado(BigDecimal valorPresupuestado) {
        this.valorPresupuestado = valorPresupuestado;
    }

    public BigDecimal getValorAprobado() {
        return valorAprobado;
    }

    public void setValorAprobado(BigDecimal valorAprobado) {
        this.valorAprobado = valorAprobado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PresupuestoDepto getPresupuestoDepto() {
        return presupuestoDepto;
    }

    public void setPresupuestoDepto(PresupuestoDepto presupuestoDepto) {
        this.presupuestoDepto = presupuestoDepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestoPuestoPK != null ? presupuestoPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoPuesto)) {
            return false;
        }
        PresupuestoPuesto other = (PresupuestoPuesto) object;
        if ((this.presupuestoPuestoPK == null && other.presupuestoPuestoPK != null) || (this.presupuestoPuestoPK != null && !this.presupuestoPuestoPK.equals(other.presupuestoPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PresupuestoPuesto[ presupuestoPuestoPK=" + presupuestoPuestoPK + " ]";
    }
    
}
