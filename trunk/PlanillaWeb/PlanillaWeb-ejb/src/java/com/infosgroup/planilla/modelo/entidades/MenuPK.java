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
public class MenuPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MODULO", nullable = false)
    private long idModulo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MENU", nullable = false)
    private long idMenu;

    public MenuPK()
    {
    }

    public MenuPK(long idCompania, long idModulo, long idMenu)
    {
        this.idCompania = idCompania;
        this.idModulo = idModulo;
        this.idMenu = idMenu;
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

    public long getIdMenu()
    {
        return idMenu;
    }

    public void setIdMenu(long idMenu)
    {
        this.idMenu = idMenu;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idModulo;
        hash += (int) idMenu;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuPK))
            {
            return false;
            }
        MenuPK other = (MenuPK) object;
        if (this.idCompania != other.idCompania) return false;
        if (this.idModulo != other.idModulo) return false;
        if (this.idMenu != other.idMenu) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.MenuPK[ idCompania=" + idCompania + ", idModulo=" + idModulo + ", idMenu=" + idMenu + " ]";
    }
    
}
