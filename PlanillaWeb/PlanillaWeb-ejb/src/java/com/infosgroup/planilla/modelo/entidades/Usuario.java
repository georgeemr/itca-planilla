/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdCompania", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.idCompania = :idCompania"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNomUsuarioPassword", query = "SELECT u FROM Usuario u WHERE u.nomUsuario = :nomUsuario AND u.password = :password"),
    @NamedQuery(name = "Usuario.findByNomUsuario", query = "SELECT u FROM Usuario u WHERE u.nomUsuario = :nomUsuario"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPK usuarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_usuario", nullable = false, length = 100)
    private String nomUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Modulo> moduloList;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)})
    @ManyToOne(optional = false)
    private Rol rol;

    public Usuario() {
    }

    public Usuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Usuario(UsuarioPK usuarioPK, String nomUsuario, String password) {
        this.usuarioPK = usuarioPK;
        this.nomUsuario = nomUsuario;
        this.password = password;
    }

    public Usuario(int idCompania, int idUsuario) {
        this.usuarioPK = new UsuarioPK(idCompania, idUsuario);
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPK != null ? usuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioPK == null && other.usuarioPK != null) || (this.usuarioPK != null && !this.usuarioPK.equals(other.usuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Usuario[ usuarioPK=" + usuarioPK + " ]";
    }
    
}
