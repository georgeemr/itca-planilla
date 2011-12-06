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
public class SalarioBasePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sucursal", nullable = false)
    private int idSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_salario", nullable = false)
    private int idSalario;

    public SalarioBasePK() {
    }

    public SalarioBasePK(int idCompania, int idSucursal, int idEmpleado, int idSalario) {
        this.idCompania = idCompania;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
        this.idSalario = idSalario;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idSucursal;
        hash += (int) idEmpleado;
        hash += (int) idSalario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalarioBasePK)) {
            return false;
        }
        SalarioBasePK other = (SalarioBasePK) object;
        if (this.idCompania != other.idCompania) {
            return false;
        }
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        if (this.idSalario != other.idSalario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.SalarioBasePK[ idCompania=" + idCompania + ", idSucursal=" + idSucursal + ", idEmpleado=" + idEmpleado + ", idSalario=" + idSalario + " ]";
    }
    
}
