/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class NivelesXCandidatoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private BigInteger codCia;
    @Basic(optional = false)
    @Column(name = "COD_CANDIDATO", nullable = false)
    private BigInteger codCandidato;
    @Basic(optional = false)
    @Column(name = "COD_NIVEL", nullable = false)
    private BigInteger codNivel;

    public NivelesXCandidatoPK() {
    }

    public NivelesXCandidatoPK(BigInteger codCia, BigInteger codCandidato, BigInteger codNivel) {
        this.codCia = codCia;
        this.codCandidato = codCandidato;
        this.codNivel = codNivel;
    }

    public BigInteger getCodCia() {
        return codCia;
    }

    public void setCodCia(BigInteger codCia) {
        this.codCia = codCia;
    }

    public BigInteger getCodCandidato() {
        return codCandidato;
    }

    public void setCodCandidato(BigInteger codCandidato) {
        this.codCandidato = codCandidato;
    }

    public BigInteger getCodNivel() {
        return codNivel;
    }

    public void setCodNivel(BigInteger codNivel) {
        this.codNivel = codNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCia != null ? codCia.hashCode() : 0);
        hash += (codCandidato != null ? codCandidato.hashCode() : 0);
        hash += (codNivel != null ? codNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelesXCandidatoPK)) {
            return false;
        }
        NivelesXCandidatoPK other = (NivelesXCandidatoPK) object;
        if ((this.codCia == null && other.codCia != null) || (this.codCia != null && !this.codCia.equals(other.codCia))) {
            return false;
        }
        if ((this.codCandidato == null && other.codCandidato != null) || (this.codCandidato != null && !this.codCandidato.equals(other.codCandidato))) {
            return false;
        }
        if ((this.codNivel == null && other.codNivel != null) || (this.codNivel != null && !this.codNivel.equals(other.codNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.NivelesXCandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + ", codNivel=" + codNivel + " ]";
    }
    
}
