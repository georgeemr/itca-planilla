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
public class CuentaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_cuenta", nullable = false)
    private int idTipoCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuenta", nullable = false)
    private int idCuenta;

    public CuentaPK() {
    }

    public CuentaPK(int idCompania, int idTipoCuenta, int idCuenta) {
        this.idCompania = idCompania;
        this.idTipoCuenta = idTipoCuenta;
        this.idCuenta = idCuenta;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idTipoCuenta;
        hash += (int) idCuenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaPK)) {
            return false;
        }
        CuentaPK other = (CuentaPK) object;
        if (this.idCompania != other.idCompania) {
            return false;
        }
        if (this.idTipoCuenta != other.idTipoCuenta) {
            return false;
        }
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CuentaPK[ idCompania=" + idCompania + ", idTipoCuenta=" + idTipoCuenta + ", idCuenta=" + idCuenta + " ]";
    }
    
}
