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
public class TransaccionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_TRANSACCION", nullable = false)
    private long codTipoTransaccion;
    @Basic(optional = false)
    @Column(name = "COD_TRANSACCION", nullable = false)
    private long codTransaccion;

    public TransaccionPK() {
    }

    public TransaccionPK(long codCia, long codTipoTransaccion, long codTransaccion) {
        this.codCia = codCia;
        this.codTipoTransaccion = codTipoTransaccion;
        this.codTransaccion = codTransaccion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoTransaccion;
        hash += (int) codTransaccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionPK)) {
            return false;
        }
        TransaccionPK other = (TransaccionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoTransaccion != other.codTipoTransaccion) {
            return false;
        }
        if (this.codTransaccion != other.codTransaccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TransaccionPK[ codCia=" + codCia + ", codTipoTransaccion=" + codTipoTransaccion + ", codTransaccion=" + codTransaccion + " ]";
    }
    
}
