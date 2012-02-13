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
public class TipoIngresoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "TIPO_INGRESO", nullable = false)
    private short tipoIngreso;

    public TipoIngresoPK() {
    }

    public TipoIngresoPK(short codCia, short tipoIngreso) {
        this.codCia = codCia;
        this.tipoIngreso = tipoIngreso;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(short tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) tipoIngreso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIngresoPK)) {
            return false;
        }
        TipoIngresoPK other = (TipoIngresoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.tipoIngreso != other.tipoIngreso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoIngresoPK[ codCia=" + codCia + ", tipoIngreso=" + tipoIngreso + " ]";
    }
    
}
