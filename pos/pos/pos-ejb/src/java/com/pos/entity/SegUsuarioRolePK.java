/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Soporte
 */
@Embeddable
public class SegUsuarioRolePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_ROLE", nullable = false)
    private int codRole;
    @Basic(optional = false)
    @Column(name = "USUARIO", nullable = false, length = 30)
    private String usuario;

    public SegUsuarioRolePK() {
    }

    public SegUsuarioRolePK(int codRole, String usuario) {
        this.codRole = codRole;
        this.usuario = usuario;
    }

    public int getCodRole() {
        return codRole;
    }

    public void setCodRole(int codRole) {
        this.codRole = codRole;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codRole;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuarioRolePK)) {
            return false;
        }
        SegUsuarioRolePK other = (SegUsuarioRolePK) object;
        if (this.codRole != other.codRole) {
            return false;
        }
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.SegUsuarioRolePK[codRole=" + codRole + ", usuario=" + usuario + "]";
    }

}
