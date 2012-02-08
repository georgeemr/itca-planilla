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
public class TipoPuestoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_PUESTO", nullable = false)
    private short codTipoPuesto;

    public TipoPuestoPK() {
    }

    public TipoPuestoPK(short codCia, short codTipoPuesto) {
        this.codCia = codCia;
        this.codTipoPuesto = codTipoPuesto;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodTipoPuesto() {
        return codTipoPuesto;
    }

    public void setCodTipoPuesto(short codTipoPuesto) {
        this.codTipoPuesto = codTipoPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPuestoPK)) {
            return false;
        }
        TipoPuestoPK other = (TipoPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoPuesto != other.codTipoPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoPuestoPK[ codCia=" + codCia + ", codTipoPuesto=" + codTipoPuesto + " ]";
    }
    
}
