/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "FACTURAS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f"),
    @NamedQuery(name = "Facturas.findByCodCia", query = "SELECT f FROM Facturas f WHERE f.facturasPK.codCia = :codCia"),
    @NamedQuery(name = "Facturas.findByNumDocto", query = "SELECT f FROM Facturas f WHERE f.facturasPK.numDocto = :numDocto"),
    @NamedQuery(name = "Facturas.findByFechaDocto", query = "SELECT f FROM Facturas f WHERE f.facturasPK.fechaDocto = :fechaDocto"),
    @NamedQuery(name = "Facturas.findByCodCliente", query = "SELECT f FROM Facturas f WHERE f.facturasPK.codCliente = :codCliente"),
    @NamedQuery(name = "Facturas.findBySaldo", query = "SELECT f FROM Facturas f WHERE f.facturasPK.saldo = :saldo"),
    @NamedQuery(name = "Facturas.findBySubTotal", query = "SELECT f FROM Facturas f WHERE f.subTotal = :subTotal")})
public class Facturas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturasPK facturasPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SUB_TOTAL", nullable = false, precision = 14, scale = 2)
    private BigDecimal subTotal;

    public Facturas() {
    }

    public Facturas(FacturasPK facturasPK) {
        this.facturasPK = facturasPK;
    }

    public Facturas(FacturasPK facturasPK, BigDecimal subTotal) {
        this.facturasPK = facturasPK;
        this.subTotal = subTotal;
    }

    public Facturas(short codCia, int numDocto, Date fechaDocto, String codCliente, BigDecimal saldo) {
        this.facturasPK = new FacturasPK(codCia, numDocto, fechaDocto, codCliente, saldo);
    }

    public FacturasPK getFacturasPK() {
        return facturasPK;
    }

    public void setFacturasPK(FacturasPK facturasPK) {
        this.facturasPK = facturasPK;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturasPK != null ? facturasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.facturasPK == null && other.facturasPK != null) || (this.facturasPK != null && !this.facturasPK.equals(other.facturasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Facturas[ facturasPK=" + facturasPK + " ]";
    }
    
}
