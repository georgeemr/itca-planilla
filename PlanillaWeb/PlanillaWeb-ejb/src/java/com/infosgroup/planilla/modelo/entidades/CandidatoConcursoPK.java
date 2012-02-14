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

/**
 *
 * @author root
 */
@Embeddable
public class CandidatoConcursoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANDIDATO", nullable = false)
    private long candidato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONCURSO", nullable = false)
    private long concurso;

    public CandidatoConcursoPK() {
    }

    public CandidatoConcursoPK(short codCia, long candidato, long concurso) {
        this.codCia = codCia;
        this.candidato = candidato;
        this.concurso = concurso;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public long getCandidato() {
        return candidato;
    }

    public void setCandidato(long candidato) {
        this.candidato = candidato;
    }

    public long getConcurso() {
        return concurso;
    }

    public void setConcurso(long concurso) {
        this.concurso = concurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) candidato;
        hash += (int) concurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidatoConcursoPK)) {
            return false;
        }
        CandidatoConcursoPK other = (CandidatoConcursoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.candidato != other.candidato) {
            return false;
        }
        if (this.concurso != other.concurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CandidatoConcursoPK[ codCia=" + codCia + ", candidato=" + candidato + ", concurso=" + concurso + " ]";
    }
    
}
