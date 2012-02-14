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
public class HisPosicionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_HIST_POSICION", nullable = false)
    private int codHistPosicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_POSICION", nullable = false)
    private short codPosicion;

    public HisPosicionPK() {
    }

    public HisPosicionPK(short codCia, int codHistPosicion, short codPosicion) {
        this.codCia = codCia;
        this.codHistPosicion = codHistPosicion;
        this.codPosicion = codPosicion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodHistPosicion() {
        return codHistPosicion;
    }

    public void setCodHistPosicion(int codHistPosicion) {
        this.codHistPosicion = codHistPosicion;
    }

    public short getCodPosicion() {
        return codPosicion;
    }

    public void setCodPosicion(short codPosicion) {
        this.codPosicion = codPosicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codHistPosicion;
        hash += (int) codPosicion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HisPosicionPK)) {
            return false;
        }
        HisPosicionPK other = (HisPosicionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codHistPosicion != other.codHistPosicion) {
            return false;
        }
        if (this.codPosicion != other.codPosicion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.HisPosicionPK[ codCia=" + codCia + ", codHistPosicion=" + codHistPosicion + ", codPosicion=" + codPosicion + " ]";
    }
    
}
