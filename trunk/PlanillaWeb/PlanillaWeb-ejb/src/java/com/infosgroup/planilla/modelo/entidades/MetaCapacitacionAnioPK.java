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
public class MetaCapacitacionAnioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO", nullable = false)
    private short periodo;

    public MetaCapacitacionAnioPK() {
    }

    public MetaCapacitacionAnioPK(short codCia, short periodo) {
        this.codCia = codCia;
        this.periodo = periodo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getPeriodo() {
        return periodo;
    }

    public void setPeriodo(short periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) periodo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetaCapacitacionAnioPK)) {
            return false;
        }
        MetaCapacitacionAnioPK other = (MetaCapacitacionAnioPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.MetaCapacitacionAnioPK[ codCia=" + codCia + ", periodo=" + periodo + " ]";
    }
    
}
