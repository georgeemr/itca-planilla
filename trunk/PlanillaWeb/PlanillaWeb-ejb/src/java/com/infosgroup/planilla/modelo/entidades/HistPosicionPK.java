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
public class HistPosicionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_HIST_POSICION", nullable = false)
    private short codHistPosicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_POSICION", nullable = false)
    private short codPosicion;

    public HistPosicionPK() {
    }

    public HistPosicionPK(short codCia, short codHistPosicion, short codPosicion) {
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

    public short getCodHistPosicion() {
        return codHistPosicion;
    }

    public void setCodHistPosicion(short codHistPosicion) {
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
        if (!(object instanceof HistPosicionPK)) {
            return false;
        }
        HistPosicionPK other = (HistPosicionPK) object;
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
        return "com.infosgroup.planilla.modelo.entidades.HistPosicionPK[ codCia=" + codCia + ", codHistPosicion=" + codHistPosicion + ", codPosicion=" + codPosicion + " ]";
    }
    
}
