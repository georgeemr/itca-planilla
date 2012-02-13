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
public class RhControlVacacionesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "ANIO", nullable = false)
    private short anio;

    public RhControlVacacionesPK() {
    }

    public RhControlVacacionesPK(short codCia, int codEmp, short anio) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.anio = anio;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        hash += (int) anio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhControlVacacionesPK)) {
            return false;
        }
        RhControlVacacionesPK other = (RhControlVacacionesPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.RhControlVacacionesPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", anio=" + anio + " ]";
    }
    
}
