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
public class ModuloPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MODULO", nullable = false)
    private long idModulo;

    public ModuloPK()
    {
    }

    public ModuloPK(long idCompania, long idModulo)
    {
        this.idCompania = idCompania;
        this.idModulo = idModulo;
    }

    public long getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(long idCompania)
    {
        this.idCompania = idCompania;
    }

    public long getIdModulo()
    {
        return idModulo;
    }

    public void setIdModulo(long idModulo)
    {
        this.idModulo = idModulo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idModulo;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuloPK))
            {
            return false;
            }
        ModuloPK other = (ModuloPK) object;
        if (this.idCompania != other.idCompania)
            {
            return false;
            }
        if (this.idModulo != other.idModulo)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.ModuloPK[ idCompania=" + idCompania + ", idModulo=" + idModulo + " ]";
    }
    
}
