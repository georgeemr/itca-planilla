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
public class ConcursoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CONCURSO", nullable = false)
    private long codConcurso;

    public ConcursoPK() {
    }

    public ConcursoPK(short codCia, long codConcurso) {
        this.codCia = codCia;
        this.codConcurso = codConcurso;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public long getCodConcurso() {
        return codConcurso;
    }

    public void setCodConcurso(long codConcurso) {
        this.codConcurso = codConcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codConcurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConcursoPK)) {
            return false;
        }
        ConcursoPK other = (ConcursoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codConcurso != other.codConcurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ConcursoPK[ codCia=" + codCia + ", codConcurso=" + codConcurso + " ]";
    }
    
}
