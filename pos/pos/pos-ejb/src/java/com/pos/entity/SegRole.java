/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Soporte
 */
@Entity
@Table(name = "SEG_ROLE", catalog = "", schema = "FROGS")
@NamedQueries({
    @NamedQuery(name = "SegRole.findAll", query = "SELECT s FROM SegRole s"),
    @NamedQuery(name = "SegRole.findByCodRole", query = "SELECT s FROM SegRole s WHERE s.codRole = :codRole"),
    @NamedQuery(name = "SegRole.findByNomRole", query = "SELECT s FROM SegRole s WHERE s.nomRole = :nomRole")})
public class SegRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_ROLE", nullable = false)
    private Integer codRole;
    @Basic(optional = false)
    @Column(name = "NOM_ROLE", nullable = false, length = 100)
    private String nomRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segRole")
    private List<SegUsuarioRole> segUsuarioRoleList;

    public SegRole() {
    }

    public SegRole(Integer codRole) {
        this.codRole = codRole;
    }

    public SegRole(Integer codRole, String nomRole) {
        this.codRole = codRole;
        this.nomRole = nomRole;
    }

    public Integer getCodRole() {
        return codRole;
    }

    public void setCodRole(Integer codRole) {
        this.codRole = codRole;
    }

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    public List<SegUsuarioRole> getSegUsuarioRoleList() {
        return segUsuarioRoleList;
    }

    public void setSegUsuarioRoleList(List<SegUsuarioRole> segUsuarioRoleList) {
        this.segUsuarioRoleList = segUsuarioRoleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRole != null ? codRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRole)) {
            return false;
        }
        SegRole other = (SegRole) object;
        if ((this.codRole == null && other.codRole != null) || (this.codRole != null && !this.codRole.equals(other.codRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.SegRole[codRole=" + codRole + "]";
    }

}
