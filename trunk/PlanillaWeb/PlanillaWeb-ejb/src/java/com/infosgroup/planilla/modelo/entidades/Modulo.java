/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "MODULO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByIdCompania", query = "SELECT m FROM Modulo m WHERE m.moduloPK.idCompania = :idCompania"),
    @NamedQuery(name = "Modulo.findByIdModulo", query = "SELECT m FROM Modulo m WHERE m.moduloPK.idModulo = :idModulo"),
    @NamedQuery(name = "Modulo.findByNomModulo", query = "SELECT m FROM Modulo m WHERE m.nomModulo = :nomModulo")
    })
public class Modulo implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ModuloPK moduloPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_MODULO", nullable = false, length = 200)
    private String nomModulo;

    @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
    private List<Menu> menuList;

    public Modulo()
    {
    }

    public Modulo(ModuloPK moduloPK)
    {
        this.moduloPK = moduloPK;
    }

    public Modulo(ModuloPK moduloPK, String nomModulo)
    {
        this.moduloPK = moduloPK;
        this.nomModulo = nomModulo;
    }

    public Modulo(long idCompania, long idModulo)
    {
        this.moduloPK = new ModuloPK(idCompania, idModulo);
    }

    public ModuloPK getModuloPK()
    {
        return moduloPK;
    }

    public void setModuloPK(ModuloPK moduloPK)
    {
        this.moduloPK = moduloPK;
    }

    public String getNomModulo()
    {
        return nomModulo;
    }

    public void setNomModulo(String nomModulo)
    {
        this.nomModulo = nomModulo;
    }

    public Compania getCompania()
    {
        return compania;
    }

    public void setCompania(Compania compania)
    {
        this.compania = compania;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (moduloPK != null ? moduloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo))
            {
            return false;
            }
        Modulo other = (Modulo) object;
        if ((this.moduloPK == null && other.moduloPK != null) || (this.moduloPK != null && !this.moduloPK.equals(other.moduloPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Modulo[ moduloPK=" + moduloPK + " ]";
    }
    
}
