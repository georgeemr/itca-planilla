/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class RelUsuarioTipoplaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "USUARIO", nullable = false, length = 20)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "COD_TIPOPLA", nullable = false)
    private short codTipopla;

    public RelUsuarioTipoplaPK() {
    }

    public RelUsuarioTipoplaPK(short codCia, String usuario, short codTipopla) {
        this.codCia = codCia;
        this.usuario = usuario;
        this.codTipopla = codTipopla;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(short codTipopla) {
        this.codTipopla = codTipopla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (usuario != null ? usuario.hashCode() : 0);
        hash += (int) codTipopla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelUsuarioTipoplaPK)) {
            return false;
        }
        RelUsuarioTipoplaPK other = (RelUsuarioTipoplaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        if (this.codTipopla != other.codTipopla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.RelUsuarioTipoplaPK[ codCia=" + codCia + ", usuario=" + usuario + ", codTipopla=" + codTipopla + " ]";
    }
    
}
