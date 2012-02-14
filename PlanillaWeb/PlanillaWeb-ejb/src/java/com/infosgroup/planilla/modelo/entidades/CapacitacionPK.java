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
public class CapacitacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CAPACITACION", nullable = false)
    private int codCapacitacion;

    public CapacitacionPK() {
    }

    public CapacitacionPK(short codCia, int codCapacitacion) {
        this.codCia = codCia;
        this.codCapacitacion = codCapacitacion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodCapacitacion() {
        return codCapacitacion;
    }

    public void setCodCapacitacion(int codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCapacitacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionPK)) {
            return false;
        }
        CapacitacionPK other = (CapacitacionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCapacitacion != other.codCapacitacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CapacitacionPK[ codCia=" + codCia + ", codCapacitacion=" + codCapacitacion + " ]";
    }
    
}
