/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;

/**
 *
 * @author Soporte
 */
@Entity
@Table(name = "VENTAS_DIARIAS", catalog = "", schema = "FROGS")
@NamedQueries({
    @NamedQuery(name = "VentasDiarias.findAll", query = "SELECT v FROM VentasDiarias v"),
    @NamedQuery(name = "VentasDiarias.findByCodCia", query = "SELECT v FROM VentasDiarias v WHERE v.ventasDiariasPK.codCia = :codCia"),
    @NamedQuery(name = "VentasDiarias.findByCodAgencia", query = "SELECT v FROM VentasDiarias v WHERE v.ventasDiariasPK.codAgencia = :codAgencia"),
    @NamedQuery(name = "VentasDiarias.findByFecha", query = "SELECT v FROM VentasDiarias v WHERE v.ventasDiariasPK.fecha = :fecha"),
    @NamedQuery(name = "VentasDiarias.findByTipo", query = "SELECT v FROM VentasDiarias v WHERE v.ventasDiariasPK.tipo = :tipo"),
    @NamedQuery(name = "VentasDiarias.findByCantidad", query = "SELECT v FROM VentasDiarias v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "VentasDiarias.findByMontoVenta", query = "SELECT v FROM VentasDiarias v WHERE v.montoVenta = :montoVenta")})
public class VentasDiarias implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasDiariasPK ventasDiariasPK;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false)
    private long cantidad;
    @Basic(optional = false)
    @Column(name = "MONTO_VENTA", nullable = false, precision = 16, scale = 2)
    private BigDecimal montoVenta;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_AGENCIA", referencedColumnName = "COD_AGENCIA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Agencias agencias;
    @Transient
    private String tipo;
    @Transient
    private String sucursal;

    public VentasDiarias() {
    }

    public VentasDiarias(VentasDiariasPK ventasDiariasPK) {
        this.ventasDiariasPK = ventasDiariasPK;
    }

    public VentasDiarias(VentasDiariasPK ventasDiariasPK, long cantidad, BigDecimal montoVenta) {
        this.ventasDiariasPK = ventasDiariasPK;
        this.cantidad = cantidad;
        this.montoVenta = montoVenta;
    }

    public VentasDiarias(short codCia, short codAgencia, Date fecha, String tipo) {
        this.ventasDiariasPK = new VentasDiariasPK(codCia, codAgencia, fecha, tipo);
    }

    public VentasDiariasPK getVentasDiariasPK() {
        return ventasDiariasPK;
    }

    public void setVentasDiariasPK(VentasDiariasPK ventasDiariasPK) {
        this.ventasDiariasPK = ventasDiariasPK;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(BigDecimal montoVenta) {
        this.montoVenta = montoVenta;
    }

    public Agencias getAgencias() {
        return agencias;
    }

    public void setAgencias(Agencias agencias) {
        this.agencias = agencias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasDiariasPK != null ? ventasDiariasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasDiarias)) {
            return false;
        }
        VentasDiarias other = (VentasDiarias) object;
        if ((this.ventasDiariasPK == null && other.ventasDiariasPK != null) || (this.ventasDiariasPK != null && !this.ventasDiariasPK.equals(other.ventasDiariasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.VentasDiarias[ventasDiariasPK=" + ventasDiariasPK + "]";
    }
}
