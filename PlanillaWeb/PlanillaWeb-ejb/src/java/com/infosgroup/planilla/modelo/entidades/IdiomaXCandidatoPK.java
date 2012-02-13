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
public class IdiomaXCandidatoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CANDIDATO", nullable = false)
    private int codCandidato;
    @Basic(optional = false)
    @Column(name = "COD_IDIOMA", nullable = false)
    private int codIdioma;

    public IdiomaXCandidatoPK() {
    }

    public IdiomaXCandidatoPK(short codCia, int codCandidato, int codIdioma) {
        this.codCia = codCia;
        this.codCandidato = codCandidato;
        this.codIdioma = codIdioma;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodCandidato() {
        return codCandidato;
    }

    public void setCodCandidato(int codCandidato) {
        this.codCandidato = codCandidato;
    }

    public int getCodIdioma() {
        return codIdioma;
    }

    public void setCodIdioma(int codIdioma) {
        this.codIdioma = codIdioma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCandidato;
        hash += (int) codIdioma;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdiomaXCandidatoPK)) {
            return false;
        }
        IdiomaXCandidatoPK other = (IdiomaXCandidatoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCandidato != other.codCandidato) {
            return false;
        }
        if (this.codIdioma != other.codIdioma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.IdiomaXCandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + ", codIdioma=" + codIdioma + " ]";
    }
    
}
