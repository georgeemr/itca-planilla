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
public class PrestamosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PRESTA", nullable = false)
    private int codPresta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;

    public PrestamosPK() {
    }

    public PrestamosPK(short codCia, int codPresta, int codEmp) {
        this.codCia = codCia;
        this.codPresta = codPresta;
        this.codEmp = codEmp;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodPresta() {
        return codPresta;
    }

    public void setCodPresta(int codPresta) {
        this.codPresta = codPresta;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codPresta;
        hash += (int) codEmp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamosPK)) {
            return false;
        }
        PrestamosPK other = (PrestamosPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codPresta != other.codPresta) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PrestamosPK[ codCia=" + codCia + ", codPresta=" + codPresta + ", codEmp=" + codEmp + " ]";
    }
    
}
