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
    @Column(name = "id_compania", nullable = false)
    private int idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modulo", nullable = false)
    private int idModulo;

    public ModuloPK()
    {
    }

    public ModuloPK(int idCompania, int idModulo)
    {
        this.idCompania = idCompania;
        this.idModulo = idModulo;
    }

    public int getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(int idCompania)
    {
        this.idCompania = idCompania;
    }

    public int getIdModulo()
    {
        return idModulo;
    }

    public void setIdModulo(int idModulo)
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
