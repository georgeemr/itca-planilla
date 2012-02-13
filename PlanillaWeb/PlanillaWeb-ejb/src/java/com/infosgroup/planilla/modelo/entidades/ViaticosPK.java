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
public class ViaticosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_VIATICO", nullable = false)
    private short codViatico;

    public ViaticosPK() {
    }

    public ViaticosPK(short codCia, short codViatico) {
        this.codCia = codCia;
        this.codViatico = codViatico;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodViatico() {
        return codViatico;
    }

    public void setCodViatico(short codViatico) {
        this.codViatico = codViatico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codViatico;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaticosPK)) {
            return false;
        }
        ViaticosPK other = (ViaticosPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codViatico != other.codViatico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ViaticosPK[ codCia=" + codCia + ", codViatico=" + codViatico + " ]";
    }
    
}
