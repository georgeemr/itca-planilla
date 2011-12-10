/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ROL")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByIdCompania", query = "SELECT r FROM Rol r WHERE r.rolPK.idCompania = :idCompania"),
    @NamedQuery(name = "Rol.findByIdRol", query = "SELECT r FROM Rol r WHERE r.rolPK.idRol = :idRol"),
    @NamedQuery(name = "Rol.findByNomRol", query = "SELECT r FROM Rol r WHERE r.nomRol = :nomRol")
    })
public class Rol implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected RolPK rolPK;

    @Size(max = 100)
    @Column(name = "NOM_ROL", length = 100)
    private String nomRol;

    @ManyToMany(mappedBy = "rolList")
    private List<Menu> menuList;

    @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public Rol()
    {
    }

    public Rol(RolPK rolPK)
    {
        this.rolPK = rolPK;
    }

    public Rol(long idCompania, long idRol)
    {
        this.rolPK = new RolPK(idCompania, idRol);
    }

    public RolPK getRolPK()
    {
        return rolPK;
    }

    public void setRolPK(RolPK rolPK)
    {
        this.rolPK = rolPK;
    }

    public String getNomRol()
    {
        return nomRol;
    }

    public void setNomRol(String nomRol)
    {
        this.nomRol = nomRol;
    }

    @XmlTransient
    public List<Menu> getMenuList()
    {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList)
    {
        this.menuList = menuList;
    }

    public Compania getCompania()
    {
        return compania;
    }

    public void setCompania(Compania compania)
    {
        this.compania = compania;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (rolPK != null ? rolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol))
            {
            return false;
            }
        Rol other = (Rol) object;
        if ((this.rolPK == null && other.rolPK != null) || (this.rolPK != null && !this.rolPK.equals(other.rolPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Rol[ rolPK=" + rolPK + " ]";
    }
    
}
