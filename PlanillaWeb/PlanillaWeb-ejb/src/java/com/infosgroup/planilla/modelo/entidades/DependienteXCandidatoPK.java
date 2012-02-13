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
public class DependienteXCandidatoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CANDIDATO", nullable = false)
    private int codCandidato;
    @Basic(optional = false)
    @Column(name = "COD_DEPENDIENTE", nullable = false)
    private int codDependiente;

    public DependienteXCandidatoPK() {
    }

    public DependienteXCandidatoPK(short codCia, int codCandidato, int codDependiente) {
        this.codCia = codCia;
        this.codCandidato = codCandidato;
        this.codDependiente = codDependiente;
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

    public int getCodDependiente() {
        return codDependiente;
    }

    public void setCodDependiente(int codDependiente) {
        this.codDependiente = codDependiente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCandidato;
        hash += (int) codDependiente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DependienteXCandidatoPK)) {
            return false;
        }
        DependienteXCandidatoPK other = (DependienteXCandidatoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCandidato != other.codCandidato) {
            return false;
        }
        if (this.codDependiente != other.codDependiente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DependienteXCandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + ", codDependiente=" + codDependiente + " ]";
    }
    
}
