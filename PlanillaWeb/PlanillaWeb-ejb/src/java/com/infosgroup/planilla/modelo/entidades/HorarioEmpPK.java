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
public class HorarioEmpPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "CORRELAT", nullable = false)
    private int correlat;

    public HorarioEmpPK() {
    }

    public HorarioEmpPK(int codEmp, short codCia, int correlat) {
        this.codEmp = codEmp;
        this.codCia = codCia;
        this.correlat = correlat;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCorrelat() {
        return correlat;
    }

    public void setCorrelat(int correlat) {
        this.correlat = correlat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codEmp;
        hash += (int) codCia;
        hash += (int) correlat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioEmpPK)) {
            return false;
        }
        HorarioEmpPK other = (HorarioEmpPK) object;
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.correlat != other.correlat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.HorarioEmpPK[ codEmp=" + codEmp + ", codCia=" + codCia + ", correlat=" + correlat + " ]";
    }
    
}
