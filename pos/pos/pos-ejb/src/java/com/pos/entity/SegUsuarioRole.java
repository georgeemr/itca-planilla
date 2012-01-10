/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Soporte
 */
@Entity
@Table(name = "SEG_USUARIO_ROLE", catalog = "", schema = "FROGS")
@NamedQueries({
    @NamedQuery(name = "SegUsuarioRole.findAll", query = "SELECT s FROM SegUsuarioRole s"),
    @NamedQuery(name = "SegUsuarioRole.findByCodRole", query = "SELECT s FROM SegUsuarioRole s WHERE s.segUsuarioRolePK.codRole = :codRole"),
    @NamedQuery(name = "SegUsuarioRole.findByUsuario", query = "SELECT s FROM SegUsuarioRole s WHERE s.segUsuarioRolePK.usuario = :usuario"),
    @NamedQuery(name = "SegUsuarioRole.findByFechaCreacion", query = "SELECT s FROM SegUsuarioRole s WHERE s.fechaCreacion = :fechaCreacion")})
public class SegUsuarioRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegUsuarioRolePK segUsuarioRolePK;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "USUARIO", referencedColumnName = "USUARIO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegUsuario segUsuario;
    @JoinColumn(name = "COD_ROLE", referencedColumnName = "COD_ROLE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegRole segRole;

    public SegUsuarioRole() {
    }

    public SegUsuarioRole(SegUsuarioRolePK segUsuarioRolePK) {
        this.segUsuarioRolePK = segUsuarioRolePK;
    }

    public SegUsuarioRole(int codRole, String usuario) {
        this.segUsuarioRolePK = new SegUsuarioRolePK(codRole, usuario);
    }

    public SegUsuarioRolePK getSegUsuarioRolePK() {
        return segUsuarioRolePK;
    }

    public void setSegUsuarioRolePK(SegUsuarioRolePK segUsuarioRolePK) {
        this.segUsuarioRolePK = segUsuarioRolePK;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    public SegRole getSegRole() {
        return segRole;
    }

    public void setSegRole(SegRole segRole) {
        this.segRole = segRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segUsuarioRolePK != null ? segUsuarioRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuarioRole)) {
            return false;
        }
        SegUsuarioRole other = (SegUsuarioRole) object;
        if ((this.segUsuarioRolePK == null && other.segUsuarioRolePK != null) || (this.segUsuarioRolePK != null && !this.segUsuarioRolePK.equals(other.segUsuarioRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.SegUsuarioRole[segUsuarioRolePK=" + segUsuarioRolePK + "]";
    }

}
