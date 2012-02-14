/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Embeddable
public class CriterioSeleccionadoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO", nullable = false)
    private long correlativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "USUARIO", nullable = false, length = 200)
    private String usuario;

    public CriterioSeleccionadoPK() {
    }

    public CriterioSeleccionadoPK(short codCia, long correlativo, String usuario) {
        this.codCia = codCia;
        this.correlativo = correlativo;
        this.usuario = usuario;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public long getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(long correlativo) {
        this.correlativo = correlativo;
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
        hash += (int) codCia;
        hash += (int) correlativo;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeleccionadoPK)) {
            return false;
        }
        CriterioSeleccionadoPK other = (CriterioSeleccionadoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CriterioSeleccionadoPK[ codCia=" + codCia + ", correlativo=" + correlativo + ", usuario=" + usuario + " ]";
    }
    
}
