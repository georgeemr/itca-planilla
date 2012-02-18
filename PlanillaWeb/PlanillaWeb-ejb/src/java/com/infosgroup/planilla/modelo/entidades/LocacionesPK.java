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
public class LocacionesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_LOCACION", nullable = false)
    private short codLocacion;

    public LocacionesPK() {
    }

    public LocacionesPK(short codCia, short codLocacion) {
        this.codCia = codCia;
        this.codLocacion = codLocacion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodLocacion() {
        return codLocacion;
    }

    public void setCodLocacion(short codLocacion) {
        this.codLocacion = codLocacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codLocacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocacionesPK)) {
            return false;
        }
        LocacionesPK other = (LocacionesPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codLocacion != other.codLocacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.activos.LocacionesPK[ codCia=" + codCia + ", codLocacion=" + codLocacion + " ]";
    }
    
}
