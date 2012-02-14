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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Embeddable
public class FacturasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_DOCTO", nullable = false)
    private int numDocto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DOCTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDocto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_CLIENTE", nullable = false, length = 5)
    private String codCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALDO", nullable = false, precision = 14, scale = 2)
    private BigDecimal saldo;

    public FacturasPK() {
    }

    public FacturasPK(short codCia, int numDocto, Date fechaDocto, String codCliente, BigDecimal saldo) {
        this.codCia = codCia;
        this.numDocto = numDocto;
        this.fechaDocto = fechaDocto;
        this.codCliente = codCliente;
        this.saldo = saldo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getNumDocto() {
        return numDocto;
    }

    public void setNumDocto(int numDocto) {
        this.numDocto = numDocto;
    }

    public Date getFechaDocto() {
        return fechaDocto;
    }

    public void setFechaDocto(Date fechaDocto) {
        this.fechaDocto = fechaDocto;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) numDocto;
        hash += (fechaDocto != null ? fechaDocto.hashCode() : 0);
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        hash += (saldo != null ? saldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturasPK)) {
            return false;
        }
        FacturasPK other = (FacturasPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.numDocto != other.numDocto) {
            return false;
        }
        if ((this.fechaDocto == null && other.fechaDocto != null) || (this.fechaDocto != null && !this.fechaDocto.equals(other.fechaDocto))) {
            return false;
        }
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        if ((this.saldo == null && other.saldo != null) || (this.saldo != null && !this.saldo.equals(other.saldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.FacturasPK[ codCia=" + codCia + ", numDocto=" + numDocto + ", fechaDocto=" + fechaDocto + ", codCliente=" + codCliente + ", saldo=" + saldo + " ]";
    }
    
}
