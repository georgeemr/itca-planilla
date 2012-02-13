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
public class ProcesoSeleccionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_ACTIVIDAD", nullable = false)
    private int codActividad;

    public ProcesoSeleccionPK() {
    }

    public ProcesoSeleccionPK(short codCia, int codActividad) {
        this.codCia = codCia;
        this.codActividad = codActividad;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(int codActividad) {
        this.codActividad = codActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoSeleccionPK)) {
            return false;
        }
        ProcesoSeleccionPK other = (ProcesoSeleccionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codActividad != other.codActividad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ProcesoSeleccionPK[ codCia=" + codCia + ", codActividad=" + codActividad + " ]";
    }
    
}
