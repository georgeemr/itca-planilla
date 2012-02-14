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
public class EstudiosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_ESTUDIO", nullable = false, length = 5)
    private String codEstudio;

    public EstudiosPK() {
    }

    public EstudiosPK(short codCia, String codEstudio) {
        this.codCia = codCia;
        this.codEstudio = codEstudio;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public String getCodEstudio() {
        return codEstudio;
    }

    public void setCodEstudio(String codEstudio) {
        this.codEstudio = codEstudio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (codEstudio != null ? codEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiosPK)) {
            return false;
        }
        EstudiosPK other = (EstudiosPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.codEstudio == null && other.codEstudio != null) || (this.codEstudio != null && !this.codEstudio.equals(other.codEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EstudiosPK[ codCia=" + codCia + ", codEstudio=" + codEstudio + " ]";
    }
    
}
