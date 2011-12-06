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
public class PuestoEmpleadoPK implements Serializable {
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
    @Column(name = "id_tipo_puesto", nullable = false)
    private int idTipoPuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_puesto", nullable = false)
    private int idPuesto;

    public PuestoEmpleadoPK() {
    }

    public PuestoEmpleadoPK(int idCompania, int idSucursal, int idEmpleado, int idTipoPuesto, int idPuesto) {
        this.idCompania = idCompania;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
        this.idTipoPuesto = idTipoPuesto;
        this.idPuesto = idPuesto;
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

    public int getIdTipoPuesto() {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(int idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idSucursal;
        hash += (int) idEmpleado;
        hash += (int) idTipoPuesto;
        hash += (int) idPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuestoEmpleadoPK)) {
            return false;
        }
        PuestoEmpleadoPK other = (PuestoEmpleadoPK) object;
        if (this.idCompania != other.idCompania) {
            return false;
        }
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        if (this.idTipoPuesto != other.idTipoPuesto) {
            return false;
        }
        if (this.idPuesto != other.idPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PuestoEmpleadoPK[ idCompania=" + idCompania + ", idSucursal=" + idSucursal + ", idEmpleado=" + idEmpleado + ", idTipoPuesto=" + idTipoPuesto + ", idPuesto=" + idPuesto + " ]";
    }
    
}
