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
public class CapacitadoresPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CAPACITADOR", nullable = false)
    private long codCapacitador;

    public CapacitadoresPK() {
    }

    public CapacitadoresPK(short codCia, long codCapacitador) {
        this.codCia = codCia;
        this.codCapacitador = codCapacitador;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public long getCodCapacitador() {
        return codCapacitador;
    }

    public void setCodCapacitador(long codCapacitador) {
        this.codCapacitador = codCapacitador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCapacitador;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitadoresPK)) {
            return false;
        }
        CapacitadoresPK other = (CapacitadoresPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCapacitador != other.codCapacitador) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CapacitadoresPK[ codCia=" + codCia + ", codCapacitador=" + codCapacitador + " ]";
    }
    
}
