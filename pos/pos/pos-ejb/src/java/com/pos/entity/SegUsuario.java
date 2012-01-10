/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "SEG_USUARIO", catalog = "", schema = "FROGS")
@NamedQueries({
    @NamedQuery(name = "SegUsuario.findAll", query = "SELECT s FROM SegUsuario s"),
    @NamedQuery(name = "SegUsuario.findByUsuario", query = "SELECT s FROM SegUsuario s WHERE s.usuario = :usuario"),
    @NamedQuery(name = "SegUsuario.findByNomUsuario", query = "SELECT s FROM SegUsuario s WHERE s.nomUsuario = :nomUsuario"),
    @NamedQuery(name = "SegUsuario.findByEstado", query = "SELECT s FROM SegUsuario s WHERE s.estado = :estado"),
    @NamedQuery(name = "SegUsuario.findByCorreo", query = "SELECT s FROM SegUsuario s WHERE s.correo = :correo"),
    @NamedQuery(name = "SegUsuario.findByPassword", query = "SELECT s FROM SegUsuario s WHERE s.password = :password"),
    @NamedQuery(name = "SegUsuario.findByCedula", query = "SELECT s FROM SegUsuario s WHERE s.cedula = :cedula"),
    @NamedQuery(name = "SegUsuario.findByTipo", query = "SELECT s FROM SegUsuario s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "SegUsuario.findByOrden", query = "SELECT s FROM SegUsuario s WHERE s.orden = :orden"),
    @NamedQuery(name = "SegUsuario.findByCodSucursal", query = "SELECT s FROM SegUsuario s WHERE s.codSucursal = :codSucursal"),
    @NamedQuery(name = "SegUsuario.findByCodEncargado", query = "SELECT s FROM SegUsuario s WHERE s.codEncargado = :codEncargado")})
public class SegUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USUARIO", nullable = false, length = 50)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "NOM_USUARIO", nullable = false, length = 200)
    private String nomUsuario;
    @Basic(optional = false)
    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;
    @Column(name = "CORREO", length = 100)
    private String correo;
    @Basic(optional = false)
    @Column(name = "PASSWORD", nullable = false, length = 25)
    private String password;
    @Column(name = "CEDULA", length = 50)
    private String cedula;
    @Basic(optional = false)
    @Column(name = "TIPO", nullable = false, length = 1)
    private String tipo;
    @Column(name = "ORDEN")
    private BigInteger orden;
    @Column(name = "COD_SUCURSAL", length = 3)
    private String codSucursal;
    @Column(name = "COD_ENCARGADO")
    private Long codEncargado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario")
    private List<SegUsuarioRole> segUsuarioRoleList;

    public SegUsuario() {
    }

    public SegUsuario(String usuario) {
        this.usuario = usuario;
    }

    public SegUsuario(String usuario, String nomUsuario, String estado, String password, String tipo) {
        this.usuario = usuario;
        this.nomUsuario = nomUsuario;
        this.estado = estado;
        this.password = password;
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigInteger getOrden() {
        return orden;
    }

    public void setOrden(BigInteger orden) {
        this.orden = orden;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public Long getCodEncargado() {
        return codEncargado;
    }

    public void setCodEncargado(Long codEncargado) {
        this.codEncargado = codEncargado;
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
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.SegUsuario[usuario=" + usuario + "]";
    }

}
