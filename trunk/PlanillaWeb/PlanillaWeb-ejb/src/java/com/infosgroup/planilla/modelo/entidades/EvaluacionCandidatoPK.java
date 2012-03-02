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
public class EvaluacionCandidatoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "PUESTO", nullable = false)
//    private short puesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRUEBA", nullable = false)
    private long prueba;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANDIDATO", nullable = false)
    private int candidato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONCURSO", nullable = false)
    private long concurso;

    public EvaluacionCandidatoPK() {
    }

    public EvaluacionCandidatoPK(short codCia, short puesto, long prueba, int candidato, long concurso) {
        this.codCia = codCia;
//        this.puesto = puesto;
        this.prueba = prueba;
        this.candidato = candidato;
        this.concurso = concurso;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

//    public short getPuesto() {
//        return puesto;
//    }
//
//    public void setPuesto(short puesto) {
//        this.puesto = puesto;
//    }

    public long getPrueba() {
        return prueba;
    }

    public void setPrueba(long prueba) {
        this.prueba = prueba;
    }

    public int getCandidato() {
        return candidato;
    }

    public void setCandidato(int candidato) {
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
//        hash += (int) puesto;
        hash += (int) prueba;
        hash += (int) candidato;
        hash += (int) concurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionCandidatoPK)) {
            return false;
        }
        EvaluacionCandidatoPK other = (EvaluacionCandidatoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
//        if (this.puesto != other.puesto) {
//            return false;
//        }
        if (this.prueba != other.prueba) {
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
        return "com.infosgroup.planilla.modelo.entidades.EvaluacionCandidatoPK[ codCia=" + codCia + /*", puesto=" + puesto +*/ ", prueba=" + prueba + ", candidato=" + candidato + ", concurso=" + concurso + " ]";
    }
    
}
