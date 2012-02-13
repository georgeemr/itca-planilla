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
public class RolPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_ROL", nullable = false)
    private long codRol;

    public RolPK() {
    }

    public RolPK(long codCia, long codRol) {
        this.codCia = codCia;
        this.codRol = codRol;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodRol() {
        return codRol;
    }

    public void setCodRol(long codRol) {
        this.codRol = codRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codRol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPK)) {
            return false;
        }
        RolPK other = (RolPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codRol != other.codRol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.RolPK[ codCia=" + codCia + ", codRol=" + codRol + " ]";
    }
    
}
