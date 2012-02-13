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
public class ContratoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CONTRATO", nullable = false)
    private int codContrato;
    @Basic(optional = false)
    @Column(name = "COD_CANDIDATO", nullable = false)
    private int codCandidato;

    public ContratoPK() {
    }

    public ContratoPK(short codCia, int codContrato, int codCandidato) {
        this.codCia = codCia;
        this.codContrato = codContrato;
        this.codCandidato = codCandidato;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodContrato() {
        return codContrato;
    }

    public void setCodContrato(int codContrato) {
        this.codContrato = codContrato;
    }

    public int getCodCandidato() {
        return codCandidato;
    }

    public void setCodCandidato(int codCandidato) {
        this.codCandidato = codCandidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codContrato;
        hash += (int) codCandidato;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoPK)) {
            return false;
        }
        ContratoPK other = (ContratoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codContrato != other.codContrato) {
            return false;
        }
        if (this.codCandidato != other.codCandidato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ContratoPK[ codCia=" + codCia + ", codContrato=" + codContrato + ", codCandidato=" + codCandidato + " ]";
    }
    
}
