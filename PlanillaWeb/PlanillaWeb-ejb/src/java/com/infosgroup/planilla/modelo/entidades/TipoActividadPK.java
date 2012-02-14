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
public class TipoActividadPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_ACTIVIDAD", nullable = false)
    private long tipoActividad;

    public TipoActividadPK() {
    }

    public TipoActividadPK(short codCia, long tipoActividad) {
        this.codCia = codCia;
        this.tipoActividad = tipoActividad;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public long getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(long tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) tipoActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividadPK)) {
            return false;
        }
        TipoActividadPK other = (TipoActividadPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.tipoActividad != other.tipoActividad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoActividadPK[ codCia=" + codCia + ", tipoActividad=" + tipoActividad + " ]";
    }
    
}
