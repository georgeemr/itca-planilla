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
public class ComisionObrasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO_OBRA", nullable = false, length = 2)
    private String tipoObra;

    public ComisionObrasPK() {
    }

    public ComisionObrasPK(short codCia, int codEmp, String tipoObra) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.tipoObra = tipoObra;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public String getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        hash += (tipoObra != null ? tipoObra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionObrasPK)) {
            return false;
        }
        ComisionObrasPK other = (ComisionObrasPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if ((this.tipoObra == null && other.tipoObra != null) || (this.tipoObra != null && !this.tipoObra.equals(other.tipoObra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ComisionObrasPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", tipoObra=" + tipoObra + " ]";
    }
    
}
