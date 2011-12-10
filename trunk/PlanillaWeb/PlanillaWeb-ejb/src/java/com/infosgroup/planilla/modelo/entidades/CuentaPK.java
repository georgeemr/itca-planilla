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
public class CuentaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CUENTA", nullable = false)
    private long idTipoCuenta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUENTA", nullable = false)
    private long idCuenta;

    public CuentaPK()
    {
    }

    public CuentaPK(long idCompania, long idTipoCuenta, long idCuenta)
    {
        this.idCompania = idCompania;
        this.idTipoCuenta = idTipoCuenta;
        this.idCuenta = idCuenta;
    }

    public long getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(long idCompania)
    {
        this.idCompania = idCompania;
    }

    public long getIdTipoCuenta()
    {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(long idTipoCuenta)
    {
        this.idTipoCuenta = idTipoCuenta;
    }

    public long getIdCuenta()
    {
        return idCuenta;
    }

    public void setIdCuenta(long idCuenta)
    {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idTipoCuenta;
        hash += (int) idCuenta;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaPK))
            {
            return false;
            }
        CuentaPK other = (CuentaPK) object;
        if (this.idCompania != other.idCompania)
            {
            return false;
            }
        if (this.idTipoCuenta != other.idTipoCuenta)
            {
            return false;
            }
        if (this.idCuenta != other.idCuenta)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.CuentaPK[ idCompania=" + idCompania + ", idTipoCuenta=" + idTipoCuenta + ", idCuenta=" + idCuenta + " ]";
    }
    
}
