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
public class CapacitacionXEmpleadoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CAPACITACION", nullable = false)
    private int codCapacitacion;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;

    public CapacitacionXEmpleadoPK() {
    }

    public CapacitacionXEmpleadoPK(short codCia, int codCapacitacion, int codEmp) {
        this.codCia = codCia;
        this.codCapacitacion = codCapacitacion;
        this.codEmp = codEmp;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodCapacitacion() {
        return codCapacitacion;
    }

    public void setCodCapacitacion(int codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCapacitacion;
        hash += (int) codEmp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionXEmpleadoPK)) {
            return false;
        }
        CapacitacionXEmpleadoPK other = (CapacitacionXEmpleadoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCapacitacion != other.codCapacitacion) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CapacitacionXEmpleadoPK[ codCia=" + codCia + ", codCapacitacion=" + codCapacitacion + ", codEmp=" + codEmp + " ]";
    }
    
}
