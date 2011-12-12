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
public class CandidatoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CANDIDATO", nullable = false)
    private long codCandidato;
    @Transient
    private String pkAsString;

    public CandidatoPK() {
    }

    public CandidatoPK(long codCia, long codCandidato) {
        this.codCia = codCia;
        this.codCandidato = codCandidato;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodCandidato() {
        return codCandidato;
    }

    public void setCodCandidato(long codCandidato) {
        this.codCandidato = codCandidato;
    }

    public String getPkAsString() {
        pkAsString = "" + codCia + ":" + codCandidato;
        return pkAsString;
    }

    public void setPkAsString(String pkAsString) {
        this.pkAsString = pkAsString;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCandidato;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidatoPK)) {
            return false;
        }
        CandidatoPK other = (CandidatoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCandidato != other.codCandidato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + " ]";
    }
}
