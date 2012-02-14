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
import javax.persistence.ManyToMany;
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
@Table(name = "ROL", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByCodCia", query = "SELECT r FROM Rol r WHERE r.rolPK.codCia = :codCia"),
    @NamedQuery(name = "Rol.findByCodRol", query = "SELECT r FROM Rol r WHERE r.rolPK.codRol = :codRol"),
    @NamedQuery(name = "Rol.findByNomRol", query = "SELECT r FROM Rol r WHERE r.nomRol = :nomRol")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolPK rolPK;
    @Size(max = 100)
    @Column(name = "NOM_ROL", length = 100)
    private String nomRol;
    @ManyToMany(mappedBy = "rolList")
    private List<Menu> menuList;

    public Rol() {
    }

    public Rol(RolPK rolPK) {
        this.rolPK = rolPK;
    }

    public Rol(long codCia, long codRol) {
        this.rolPK = new RolPK(codCia, codRol);
    }

    public RolPK getRolPK() {
        return rolPK;
    }

    public void setRolPK(RolPK rolPK) {
        this.rolPK = rolPK;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolPK != null ? rolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolPK == null && other.rolPK != null) || (this.rolPK != null && !this.rolPK.equals(other.rolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Rol[ rolPK=" + rolPK + " ]";
    }
    
}
