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
public class GerenciaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_GERENCIA", nullable = false)
    private short codGerencia;

    public GerenciaPK() {
    }

    public GerenciaPK(short codCia, short codGerencia) {
        this.codCia = codCia;
        this.codGerencia = codGerencia;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodGerencia() {
        return codGerencia;
    }

    public void setCodGerencia(short codGerencia) {
        this.codGerencia = codGerencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codGerencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GerenciaPK)) {
            return false;
        }
        GerenciaPK other = (GerenciaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codGerencia != other.codGerencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.GerenciaPK[ codCia=" + codCia + ", codGerencia=" + codGerencia + " ]";
    }
    
}
