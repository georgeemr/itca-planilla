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
public class DetPrestamosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_PRESTA", nullable = false)
    private int codPresta;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "CORRELAT", nullable = false)
    private int correlat;

    public DetPrestamosPK() {
    }

    public DetPrestamosPK(short codCia, int codPresta, int codEmp, int correlat) {
        this.codCia = codCia;
        this.codPresta = codPresta;
        this.codEmp = codEmp;
        this.correlat = correlat;
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

    public int getCorrelat() {
        return correlat;
    }

    public void setCorrelat(int correlat) {
        this.correlat = correlat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codPresta;
        hash += (int) codEmp;
        hash += (int) correlat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPrestamosPK)) {
            return false;
        }
        DetPrestamosPK other = (DetPrestamosPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codPresta != other.codPresta) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (this.correlat != other.correlat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetPrestamosPK[ codCia=" + codCia + ", codPresta=" + codPresta + ", codEmp=" + codEmp + ", correlat=" + correlat + " ]";
    }
    
}
