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
public class RelDeptosCategoriasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DEPTO", nullable = false)
    private short codDepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COD_CAT", nullable = false, length = 4)
    private String codCat;

    public RelDeptosCategoriasPK() {
    }

    public RelDeptosCategoriasPK(short codCia, short codDepto, String codCat) {
        this.codCia = codCia;
        this.codDepto = codDepto;
        this.codCat = codCat;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(short codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodCat() {
        return codCat;
    }

    public void setCodCat(String codCat) {
        this.codCat = codCat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codDepto;
        hash += (codCat != null ? codCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelDeptosCategoriasPK)) {
            return false;
        }
        RelDeptosCategoriasPK other = (RelDeptosCategoriasPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codDepto != other.codDepto) {
            return false;
        }
        if ((this.codCat == null && other.codCat != null) || (this.codCat != null && !this.codCat.equals(other.codCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RelDeptosCategoriasPK[ codCia=" + codCia + ", codDepto=" + codDepto + ", codCat=" + codCat + " ]";
    }
    
}
