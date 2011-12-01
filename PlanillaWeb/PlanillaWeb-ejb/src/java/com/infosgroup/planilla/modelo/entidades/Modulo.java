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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "modulo")
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
    @Size(min = 1, max = 100)
    @Column(name = "nom_modulo", nullable = false, length = 100)
    private String nomModulo;

    @JoinTable(name = "usuario_modulo", joinColumns =
        {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo", nullable = false)
        }, inverseJoinColumns =
        {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
        })
    @ManyToMany
    private List<Usuario> usuarioList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
    private List<Menu> menuList;

    @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

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

    public Modulo(int idCompania, int idModulo)
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

    @XmlTransient
    public List<Usuario> getUsuarioList()
    {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList)
    {
        this.usuarioList = usuarioList;
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
