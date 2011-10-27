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
public class PlanillaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_planilla", nullable = false)
    private int idTipoPlanilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sucursal", nullable = false)
    private int idSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;

    public PlanillaPK() {
    }

    public PlanillaPK(int idCompania, int idTipoPlanilla, int idSucursal, int idEmpleado) {
        this.idCompania = idCompania;
        this.idTipoPlanilla = idTipoPlanilla;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public int getIdTipoPlanilla() {
        return idTipoPlanilla;
    }

    public void setIdTipoPlanilla(int idTipoPlanilla) {
        this.idTipoPlanilla = idTipoPlanilla;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idTipoPlanilla;
        hash += (int) idSucursal;
        hash += (int) idEmpleado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanillaPK)) {
            return false;
        }
        PlanillaPK other = (PlanillaPK) object;
        if (this.idCompania != other.idCompania) {
            return false;
        }
        if (this.idTipoPlanilla != other.idTipoPlanilla) {
            return false;
        }
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PlanillaPK[ idCompania=" + idCompania + ", idTipoPlanilla=" + idTipoPlanilla + ", idSucursal=" + idSucursal + ", idEmpleado=" + idEmpleado + " ]";
    }
    
}
