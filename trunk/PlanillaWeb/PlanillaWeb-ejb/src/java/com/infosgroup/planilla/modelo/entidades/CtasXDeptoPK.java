/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class CtasXDeptoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DEPTO", nullable = false)
    private short codDepto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DP", nullable = false)
    private short codDp;

    public CtasXDeptoPK() {
    }

    public CtasXDeptoPK(short codCia, short codDepto, short codDp) {
        this.codCia = codCia;
        this.codDepto = codDepto;
        this.codDp = codDp;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(short codDepto) {
        this.codDepto = codDepto;
    }

    public short getCodDp() {
        return codDp;
    }

    public void setCodDp(short codDp) {
        this.codDp = codDp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codDepto;
        hash += (int) codDp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtasXDeptoPK)) {
            return false;
        }
        CtasXDeptoPK other = (CtasXDeptoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codDepto != other.codDepto) {
            return false;
        }
        if (this.codDp != other.codDp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CtasXDeptoPK[ codCia=" + codCia + ", codDepto=" + codDepto + ", codDp=" + codDp + " ]";
    }
    
}
