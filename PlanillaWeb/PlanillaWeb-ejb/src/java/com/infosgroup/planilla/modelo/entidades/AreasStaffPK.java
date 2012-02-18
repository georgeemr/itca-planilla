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
public class AreasStaffPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_AREA", nullable = false)
    private Integer codArea;
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;

    public AreasStaffPK() {
    }

    public AreasStaffPK(short codCia, int codArea) {
        this.codArea = codArea;
        this.codCia = codCia;
    }

    public int getCodArea() {
        return codArea;
    }

    public void setCodArea(int codArea) {
        this.codArea = codArea;
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
        hash += (int) codCia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreasStaffPK)) {
            return false;
        }
        AreasStaffPK other = (AreasStaffPK) object;
        if ((this.codArea == null && other.codArea != null) || (this.codArea != null && !this.codArea.equals(other.codArea))) {
            return false;
        }
        if (this.codCia != other.codCia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.AreasStaffPK[ codArea=" + codArea + ", codCia=" + codCia + " ]";
    }
    
}
