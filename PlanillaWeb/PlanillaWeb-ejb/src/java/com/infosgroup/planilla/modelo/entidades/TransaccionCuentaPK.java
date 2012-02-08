/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class TransaccionCuentaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_TRANSACCION", nullable = false)
    private long codTipoTransaccion;
    @Basic(optional = false)
    @Column(name = "COD_TRANSACCION", nullable = false)
    private long codTransaccion;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_CUENTA", nullable = false)
    private long codTipoCuenta;
    @Basic(optional = false)
    @Column(name = "COD_CUENTA", nullable = false)
    private long codCuenta;

    public TransaccionCuentaPK() {
    }

    public TransaccionCuentaPK(long codCia, long codTipoTransaccion, long codTransaccion, long codTipoCuenta, long codCuenta) {
        this.codCia = codCia;
        this.codTipoTransaccion = codTipoTransaccion;
        this.codTransaccion = codTransaccion;
        this.codTipoCuenta = codTipoCuenta;
        this.codCuenta = codCuenta;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodTipoTransaccion() {
        return codTipoTransaccion;
    }

    public void setCodTipoTransaccion(long codTipoTransaccion) {
        this.codTipoTransaccion = codTipoTransaccion;
    }

    public long getCodTransaccion() {
        return codTransaccion;
    }

    public void setCodTransaccion(long codTransaccion) {
        this.codTransaccion = codTransaccion;
    }

    public long getCodTipoCuenta() {
        return codTipoCuenta;
    }

    public void setCodTipoCuenta(long codTipoCuenta) {
        this.codTipoCuenta = codTipoCuenta;
    }

    public long getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(long codCuenta) {
        this.codCuenta = codCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoTransaccion;
        hash += (int) codTransaccion;
        hash += (int) codTipoCuenta;
        hash += (int) codCuenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionCuentaPK)) {
            return false;
        }
        TransaccionCuentaPK other = (TransaccionCuentaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoTransaccion != other.codTipoTransaccion) {
            return false;
        }
        if (this.codTransaccion != other.codTransaccion) {
            return false;
        }
        if (this.codTipoCuenta != other.codTipoCuenta) {
            return false;
        }
        if (this.codCuenta != other.codCuenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TransaccionCuentaPK[ codCia=" + codCia + ", codTipoTransaccion=" + codTipoTransaccion + ", codTransaccion=" + codTransaccion + ", codTipoCuenta=" + codTipoCuenta + ", codCuenta=" + codCuenta + " ]";
    }
    
}
