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
public class SucursalPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sucursal", nullable = false)
    private int idSucursal;

    public SucursalPK() {
    }

    public SucursalPK(int idCompania, int idSucursal) {
        this.idCompania = idCompania;
        this.idSucursal = idSucursal;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idSucursal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SucursalPK)) {
            return false;
        }
        SucursalPK other = (SucursalPK) object;
        if (this.idCompania != other.idCompania) {
            return false;
        }
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.SucursalPK[ idCompania=" + idCompania + ", idSucursal=" + idSucursal + " ]";
    }
    
}
