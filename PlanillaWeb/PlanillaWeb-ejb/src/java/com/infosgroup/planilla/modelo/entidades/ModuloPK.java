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
public class ModuloPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MODULO", nullable = false)
    private long codModulo;

    public ModuloPK() {
    }

    public ModuloPK(short codCia, long codModulo) {
        this.codCia = codCia;
        this.codModulo = codModulo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public long getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(long codModulo) {
        this.codModulo = codModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codModulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuloPK)) {
            return false;
        }
        ModuloPK other = (ModuloPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codModulo != other.codModulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ModuloPK[ codCia=" + codCia + ", codModulo=" + codModulo + " ]";
    }
    
}
