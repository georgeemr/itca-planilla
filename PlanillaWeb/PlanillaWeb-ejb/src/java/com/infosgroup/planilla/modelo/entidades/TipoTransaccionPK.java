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
public class TipoTransaccionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_TRANSACCION", nullable = false)
    private long codTipoTransaccion;

    public TipoTransaccionPK() {
    }

    public TipoTransaccionPK(long codCia, long codTipoTransaccion) {
        this.codCia = codCia;
        this.codTipoTransaccion = codTipoTransaccion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoTransaccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransaccionPK)) {
            return false;
        }
        TipoTransaccionPK other = (TipoTransaccionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoTransaccion != other.codTipoTransaccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoTransaccionPK[ codCia=" + codCia + ", codTipoTransaccion=" + codTipoTransaccion + " ]";
    }
    
}
