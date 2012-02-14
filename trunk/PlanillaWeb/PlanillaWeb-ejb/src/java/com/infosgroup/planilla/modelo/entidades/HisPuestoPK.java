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
public class HisPuestoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_HIST_PUESTO", nullable = false)
    private int codHistPuesto;

    public HisPuestoPK() {
    }

    public HisPuestoPK(short codCia, int codHistPuesto) {
        this.codCia = codCia;
        this.codHistPuesto = codHistPuesto;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodHistPuesto() {
        return codHistPuesto;
    }

    public void setCodHistPuesto(int codHistPuesto) {
        this.codHistPuesto = codHistPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codHistPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HisPuestoPK)) {
            return false;
        }
        HisPuestoPK other = (HisPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codHistPuesto != other.codHistPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.HisPuestoPK[ codCia=" + codCia + ", codHistPuesto=" + codHistPuesto + " ]";
    }
    
}
