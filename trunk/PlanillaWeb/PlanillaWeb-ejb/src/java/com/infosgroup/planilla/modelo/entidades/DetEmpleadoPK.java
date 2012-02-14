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
public class DetEmpleadoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DP", nullable = false)
    private int codDp;

    public DetEmpleadoPK() {
    }

    public DetEmpleadoPK(short codCia, int codEmp, int codDp) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.codDp = codDp;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
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
        hash += (int) codEmp;
        hash += (int) codDp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetEmpleadoPK)) {
            return false;
        }
        DetEmpleadoPK other = (DetEmpleadoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (this.codDp != other.codDp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetEmpleadoPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codDp=" + codDp + " ]";
    }
    
}
