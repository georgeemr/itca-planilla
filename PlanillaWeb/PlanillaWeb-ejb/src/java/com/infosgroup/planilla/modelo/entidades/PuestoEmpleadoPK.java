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
public class PuestoEmpleadoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_SUCURSAL", nullable = false)
    private long codSucursal;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private long codEmp;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_PUESTO", nullable = false)
    private long codTipoPuesto;
    @Basic(optional = false)
    @Column(name = "COD_PUESTO", nullable = false)
    private long codPuesto;

    public PuestoEmpleadoPK() {
    }

    public PuestoEmpleadoPK(long codCia, long codSucursal, long codEmp, long codTipoPuesto, long codPuesto) {
        this.codCia = codCia;
        this.codSucursal = codSucursal;
        this.codEmp = codEmp;
        this.codTipoPuesto = codTipoPuesto;
        this.codPuesto = codPuesto;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(long codSucursal) {
        this.codSucursal = codSucursal;
    }

    public long getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(long codEmp) {
        this.codEmp = codEmp;
    }

    public long getCodTipoPuesto() {
        return codTipoPuesto;
    }

    public void setCodTipoPuesto(long codTipoPuesto) {
        this.codTipoPuesto = codTipoPuesto;
    }

    public long getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(long codPuesto) {
        this.codPuesto = codPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codSucursal;
        hash += (int) codEmp;
        hash += (int) codTipoPuesto;
        hash += (int) codPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuestoEmpleadoPK)) {
            return false;
        }
        PuestoEmpleadoPK other = (PuestoEmpleadoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codSucursal != other.codSucursal) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (this.codTipoPuesto != other.codTipoPuesto) {
            return false;
        }
        if (this.codPuesto != other.codPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PuestoEmpleadoPK[ codCia=" + codCia + ", codSucursal=" + codSucursal + ", codEmp=" + codEmp + ", codTipoPuesto=" + codTipoPuesto + ", codPuesto=" + codPuesto + " ]";
    }
    
}
