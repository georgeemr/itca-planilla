/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Soporte
 */
@Embeddable
public class VentasDiariasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_AGENCIA", nullable = false)
    private short codAgencia;
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "TIPO", nullable = false, length = 5)
    private String tipo;

    public VentasDiariasPK() {
    }

    public VentasDiariasPK(short codCia, short codAgencia, Date fecha, String tipo) {
        this.codCia = codCia;
        this.codAgencia = codAgencia;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(short codAgencia) {
        this.codAgencia = codAgencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codAgencia;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (tipo != null ? tipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasDiariasPK)) {
            return false;
        }
        VentasDiariasPK other = (VentasDiariasPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codAgencia != other.codAgencia) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.tipo == null && other.tipo != null) || (this.tipo != null && !this.tipo.equals(other.tipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.VentasDiariasPK[codCia=" + codCia + ", codAgencia=" + codAgencia + ", fecha=" + fecha + ", tipo=" + tipo + "]";
    }

}
