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
public class PosicionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_POSICION", nullable = false)
    private short codPosicion;

    public PosicionPK() {
    }

    public PosicionPK(short codCia, short codPosicion) {
        this.codCia = codCia;
        this.codPosicion = codPosicion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
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
        hash += (int) codPosicion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosicionPK)) {
            return false;
        }
        PosicionPK other = (PosicionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codPosicion != other.codPosicion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PosicionPK[ codCia=" + codCia + ", codPosicion=" + codPosicion + " ]";
    }
    
}
