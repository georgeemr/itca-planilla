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
public class CriterioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "CODIGO", nullable = false)
    private long codigo;
    @Basic(optional = false)
    @Column(name = "TIPO", nullable = false)
    private long tipo;

    public CriterioPK() {
    }

    public CriterioPK(long codCia, long codigo, long tipo) {
        this.codCia = codCia;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getTipo() {
        return tipo;
    }

    public void setTipo(long tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codigo;
        hash += (int) tipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioPK)) {
            return false;
        }
        CriterioPK other = (CriterioPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CriterioPK[ codCia=" + codCia + ", codigo=" + codigo + ", tipo=" + tipo + " ]";
    }
    
}
