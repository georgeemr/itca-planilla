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
public class ParentescoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PARENTESCO", nullable = false)
    private short codParentesco;

    public ParentescoPK() {
    }

    public ParentescoPK(short codCia, short codParentesco) {
        this.codCia = codCia;
        this.codParentesco = codParentesco;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodParentesco() {
        return codParentesco;
    }

    public void setCodParentesco(short codParentesco) {
        this.codParentesco = codParentesco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codParentesco;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentescoPK)) {
            return false;
        }
        ParentescoPK other = (ParentescoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codParentesco != other.codParentesco) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ParentescoPK[ codCia=" + codCia + ", codParentesco=" + codParentesco + " ]";
    }
    
}
