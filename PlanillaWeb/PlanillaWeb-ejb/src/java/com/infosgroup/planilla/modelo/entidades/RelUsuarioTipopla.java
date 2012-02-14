/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "REL_USUARIO_TIPOPLA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelUsuarioTipopla.findAll", query = "SELECT r FROM RelUsuarioTipopla r"),
    @NamedQuery(name = "RelUsuarioTipopla.findByCodCia", query = "SELECT r FROM RelUsuarioTipopla r WHERE r.relUsuarioTipoplaPK.codCia = :codCia"),
    @NamedQuery(name = "RelUsuarioTipopla.findByUsuario", query = "SELECT r FROM RelUsuarioTipopla r WHERE r.relUsuarioTipoplaPK.usuario = :usuario"),
    @NamedQuery(name = "RelUsuarioTipopla.findByCodTipopla", query = "SELECT r FROM RelUsuarioTipopla r WHERE r.relUsuarioTipoplaPK.codTipopla = :codTipopla")})
public class RelUsuarioTipopla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelUsuarioTipoplaPK relUsuarioTipoplaPK;

    public RelUsuarioTipopla() {
    }

    public RelUsuarioTipopla(RelUsuarioTipoplaPK relUsuarioTipoplaPK) {
        this.relUsuarioTipoplaPK = relUsuarioTipoplaPK;
    }

    public RelUsuarioTipopla(short codCia, String usuario, short codTipopla) {
        this.relUsuarioTipoplaPK = new RelUsuarioTipoplaPK(codCia, usuario, codTipopla);
    }

    public RelUsuarioTipoplaPK getRelUsuarioTipoplaPK() {
        return relUsuarioTipoplaPK;
    }

    public void setRelUsuarioTipoplaPK(RelUsuarioTipoplaPK relUsuarioTipoplaPK) {
        this.relUsuarioTipoplaPK = relUsuarioTipoplaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relUsuarioTipoplaPK != null ? relUsuarioTipoplaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelUsuarioTipopla)) {
            return false;
        }
        RelUsuarioTipopla other = (RelUsuarioTipopla) object;
        if ((this.relUsuarioTipoplaPK == null && other.relUsuarioTipoplaPK != null) || (this.relUsuarioTipoplaPK != null && !this.relUsuarioTipoplaPK.equals(other.relUsuarioTipoplaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RelUsuarioTipopla[ relUsuarioTipoplaPK=" + relUsuarioTipoplaPK + " ]";
    }
    
}
