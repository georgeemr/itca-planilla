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
public class UniversidadesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_UNIVERSIDAD", nullable = false)
    private short codUniversidad;

    public UniversidadesPK() {
    }

    public UniversidadesPK(short codCia, short codUniversidad) {
        this.codCia = codCia;
        this.codUniversidad = codUniversidad;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodUniversidad() {
        return codUniversidad;
    }

    public void setCodUniversidad(short codUniversidad) {
        this.codUniversidad = codUniversidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codUniversidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UniversidadesPK)) {
            return false;
        }
        UniversidadesPK other = (UniversidadesPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codUniversidad != other.codUniversidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.UniversidadesPK[ codCia=" + codCia + ", codUniversidad=" + codUniversidad + " ]";
    }
    
}
