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
public class TipoCuentaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_cuenta", nullable = false)
    private int idTipoCuenta;

    public TipoCuentaPK()
    {
    }

    public TipoCuentaPK(int idCompania, int idTipoCuenta)
    {
        this.idCompania = idCompania;
        this.idTipoCuenta = idTipoCuenta;
    }

    public int getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(int idCompania)
    {
        this.idCompania = idCompania;
    }

    public int getIdTipoCuenta()
    {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta)
    {
        this.idTipoCuenta = idTipoCuenta;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idTipoCuenta;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuentaPK))
            {
            return false;
            }
        TipoCuentaPK other = (TipoCuentaPK) object;
        if (this.idCompania != other.idCompania)
            {
            return false;
            }
        if (this.idTipoCuenta != other.idTipoCuenta)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.TipoCuentaPK[ idCompania=" + idCompania + ", idTipoCuenta=" + idTipoCuenta + " ]";
    }
    
}
