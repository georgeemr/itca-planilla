/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class CriterioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo", nullable = false)
    private int tipo;
    @Transient
    private String pkAsString;

    public CriterioPK() {
    }

    public CriterioPK(int codCia, int codigo, int tipo) {
        this.codCia = codCia;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public int getCodCia() {
        return codCia;
    }

    public void setCodCia(int codCia) {
        this.codCia = codCia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
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

    public String getPkAsString() {
        return ""+codCia + ":" + codigo +":" + tipo;
    }
    
    public void setPkAsString(String pkAsString) {
        this.pkAsString = pkAsString;
    }
    
}
