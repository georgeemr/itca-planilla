/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "REL_USUARIO_NIVEL", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelUsuarioNivel.findAll", query = "SELECT r FROM RelUsuarioNivel r"),
    @NamedQuery(name = "RelUsuarioNivel.findByCodCia", query = "SELECT r FROM RelUsuarioNivel r WHERE r.relUsuarioNivelPK.codCia = :codCia"),
    @NamedQuery(name = "RelUsuarioNivel.findByUsuario", query = "SELECT r FROM RelUsuarioNivel r WHERE r.relUsuarioNivelPK.usuario = :usuario"),
    @NamedQuery(name = "RelUsuarioNivel.findByNivel1", query = "SELECT r FROM RelUsuarioNivel r WHERE r.nivel1 = :nivel1"),
    @NamedQuery(name = "RelUsuarioNivel.findByNivel2", query = "SELECT r FROM RelUsuarioNivel r WHERE r.nivel2 = :nivel2"),
    @NamedQuery(name = "RelUsuarioNivel.findByNivel3", query = "SELECT r FROM RelUsuarioNivel r WHERE r.nivel3 = :nivel3")})
public class RelUsuarioNivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelUsuarioNivelPK relUsuarioNivelPK;
    @Column(name = "NIVEL_1", length = 1)
    private String nivel1;
    @Column(name = "NIVEL_2", length = 1)
    private String nivel2;
    @Column(name = "NIVEL_3", length = 1)
    private String nivel3;

    public RelUsuarioNivel() {
    }

    public RelUsuarioNivel(RelUsuarioNivelPK relUsuarioNivelPK) {
        this.relUsuarioNivelPK = relUsuarioNivelPK;
    }

    public RelUsuarioNivel(short codCia, String usuario) {
        this.relUsuarioNivelPK = new RelUsuarioNivelPK(codCia, usuario);
    }

    public RelUsuarioNivelPK getRelUsuarioNivelPK() {
        return relUsuarioNivelPK;
    }

    public void setRelUsuarioNivelPK(RelUsuarioNivelPK relUsuarioNivelPK) {
        this.relUsuarioNivelPK = relUsuarioNivelPK;
    }

    public String getNivel1() {
        return nivel1;
    }

    public void setNivel1(String nivel1) {
        this.nivel1 = nivel1;
    }

    public String getNivel2() {
        return nivel2;
    }

    public void setNivel2(String nivel2) {
        this.nivel2 = nivel2;
    }

    public String getNivel3() {
        return nivel3;
    }

    public void setNivel3(String nivel3) {
        this.nivel3 = nivel3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relUsuarioNivelPK != null ? relUsuarioNivelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelUsuarioNivel)) {
            return false;
        }
        RelUsuarioNivel other = (RelUsuarioNivel) object;
        if ((this.relUsuarioNivelPK == null && other.relUsuarioNivelPK != null) || (this.relUsuarioNivelPK != null && !this.relUsuarioNivelPK.equals(other.relUsuarioNivelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.RelUsuarioNivel[ relUsuarioNivelPK=" + relUsuarioNivelPK + " ]";
    }
    
}
