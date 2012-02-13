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
public class NivelSalarialPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_NIVEL", nullable = false)
    private short codNivel;

    public NivelSalarialPK() {
    }

    public NivelSalarialPK(short codCia, short codNivel) {
        this.codCia = codCia;
        this.codNivel = codNivel;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodNivel() {
        return codNivel;
    }

    public void setCodNivel(short codNivel) {
        this.codNivel = codNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codNivel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelSalarialPK)) {
            return false;
        }
        NivelSalarialPK other = (NivelSalarialPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codNivel != other.codNivel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.NivelSalarialPK[ codCia=" + codCia + ", codNivel=" + codNivel + " ]";
    }
    
}
