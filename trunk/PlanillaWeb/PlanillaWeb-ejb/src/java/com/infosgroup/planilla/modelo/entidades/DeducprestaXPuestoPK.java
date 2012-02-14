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
public class DeducprestaXPuestoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PUESTO", nullable = false)
    private short codPuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DP", nullable = false)
    private int codDp;

    public DeducprestaXPuestoPK() {
    }

    public DeducprestaXPuestoPK(short codCia, short codPuesto, int codDp) {
        this.codCia = codCia;
        this.codPuesto = codPuesto;
        this.codDp = codDp;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(short codPuesto) {
        this.codPuesto = codPuesto;
    }

    public int getCodDp() {
        return codDp;
    }

    public void setCodDp(int codDp) {
        this.codDp = codDp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codPuesto;
        hash += (int) codDp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeducprestaXPuestoPK)) {
            return false;
        }
        DeducprestaXPuestoPK other = (DeducprestaXPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codPuesto != other.codPuesto) {
            return false;
        }
        if (this.codDp != other.codDp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DeducprestaXPuestoPK[ codCia=" + codCia + ", codPuesto=" + codPuesto + ", codDp=" + codDp + " ]";
    }
    
}
