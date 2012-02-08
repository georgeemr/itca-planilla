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
public class DeducPrestaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_DP", nullable = false)
    private int codDp;
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;

    public DeducPrestaPK() {
    }

    public DeducPrestaPK(int codDp, short codCia) {
        this.codDp = codDp;
        this.codCia = codCia;
    }

    public int getCodDp() {
        return codDp;
    }

    public void setCodDp(int codDp) {
        this.codDp = codDp;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codDp;
        hash += (int) codCia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeducPrestaPK)) {
            return false;
        }
        DeducPrestaPK other = (DeducPrestaPK) object;
        if (this.codDp != other.codDp) {
            return false;
        }
        if (this.codCia != other.codCia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DeducPrestaPK[ codDp=" + codDp + ", codCia=" + codCia + " ]";
    }
    
}
