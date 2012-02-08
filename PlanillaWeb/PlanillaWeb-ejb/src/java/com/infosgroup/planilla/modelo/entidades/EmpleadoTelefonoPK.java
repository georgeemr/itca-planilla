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
public class EmpleadoTelefonoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_SUCURSAL", nullable = false)
    private long codSucursal;
    @Basic(optional = false)
    @Column(name = "COD_EMPLEADO", nullable = false)
    private long codEmpleado;
    @Basic(optional = false)
    @Column(name = "COD_TELEFONO", nullable = false)
    private long codTelefono;

    public EmpleadoTelefonoPK() {
    }

    public EmpleadoTelefonoPK(long codCia, long codSucursal, long codEmpleado, long codTelefono) {
        this.codCia = codCia;
        this.codSucursal = codSucursal;
        this.codEmpleado = codEmpleado;
        this.codTelefono = codTelefono;
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

    public long getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(long codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public long getCodTelefono() {
        return codTelefono;
    }

    public void setCodTelefono(long codTelefono) {
        this.codTelefono = codTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codSucursal;
        hash += (int) codEmpleado;
        hash += (int) codTelefono;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoTelefonoPK)) {
            return false;
        }
        EmpleadoTelefonoPK other = (EmpleadoTelefonoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codSucursal != other.codSucursal) {
            return false;
        }
        if (this.codEmpleado != other.codEmpleado) {
            return false;
        }
        if (this.codTelefono != other.codTelefono) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EmpleadoTelefonoPK[ codCia=" + codCia + ", codSucursal=" + codSucursal + ", codEmpleado=" + codEmpleado + ", codTelefono=" + codTelefono + " ]";
    }
    
}
