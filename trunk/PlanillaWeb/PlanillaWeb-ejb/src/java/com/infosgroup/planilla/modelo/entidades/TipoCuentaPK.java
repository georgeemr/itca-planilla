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
public class TipoCuentaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_CUENTA", nullable = false)
    private long codTipoCuenta;

    public TipoCuentaPK() {
    }

    public TipoCuentaPK(long codCia, long codTipoCuenta) {
        this.codCia = codCia;
        this.codTipoCuenta = codTipoCuenta;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodTipoCuenta() {
        return codTipoCuenta;
    }

    public void setCodTipoCuenta(long codTipoCuenta) {
        this.codTipoCuenta = codTipoCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoCuenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuentaPK)) {
            return false;
        }
        TipoCuentaPK other = (TipoCuentaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoCuenta != other.codTipoCuenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoCuentaPK[ codCia=" + codCia + ", codTipoCuenta=" + codTipoCuenta + " ]";
    }
    
}
