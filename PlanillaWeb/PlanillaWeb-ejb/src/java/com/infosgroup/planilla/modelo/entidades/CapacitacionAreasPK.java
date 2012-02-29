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
 * @author infosgroup
 */
@Embeddable
public class CapacitacionAreasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_AREA", nullable = false)
    private int codArea;

    public CapacitacionAreasPK() {
    }

    public CapacitacionAreasPK(short codCia, int codArea) {
        this.codCia = codCia;
        this.codArea = codArea;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodArea() {
        return codArea;
    }

    public void setCodArea(int codArea) {
        this.codArea = codArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codArea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionAreasPK)) {
            return false;
        }
        CapacitacionAreasPK other = (CapacitacionAreasPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codArea != other.codArea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitdadesplanilla.CapacitacionAreasPK[ codCia=" + codCia + ", codArea=" + codArea + " ]";
    }
    
}
