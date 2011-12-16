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
public class RolPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROL", nullable = false)
    private long idRol;

    public RolPK()
    {
    }

    public RolPK(long idCompania, long idRol)
    {
        this.idCompania = idCompania;
        this.idRol = idRol;
    }

    public long getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(long idCompania)
    {
        this.idCompania = idCompania;
    }

    public long getIdRol()
    {
        return idRol;
    }

    public void setIdRol(long idRol)
    {
        this.idRol = idRol;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idRol;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPK))
            {
            return false;
            }
        RolPK other = (RolPK) object;
        if (this.idCompania != other.idCompania) return false;
        if (this.idRol != other.idRol) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.RolPK[ idCompania=" + idCompania + ", idRol=" + idRol + " ]";
    }
    
}
