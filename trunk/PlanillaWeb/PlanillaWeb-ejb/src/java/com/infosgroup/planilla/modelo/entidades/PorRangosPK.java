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
public class PorRangosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_RANGO", nullable = false)
    private short codRango;

    public PorRangosPK() {
    }

    public PorRangosPK(short codCia, short codRango) {
        this.codCia = codCia;
        this.codRango = codRango;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodRango() {
        return codRango;
    }

    public void setCodRango(short codRango) {
        this.codRango = codRango;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codRango;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PorRangosPK)) {
            return false;
        }
        PorRangosPK other = (PorRangosPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codRango != other.codRango) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PorRangosPK[ codCia=" + codCia + ", codRango=" + codRango + " ]";
    }
    
}
