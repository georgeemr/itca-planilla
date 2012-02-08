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
public class BeneficiarioPorCandidatoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "CANDIDATO", nullable = false)
    private long candidato;
    @Basic(optional = false)
    @Column(name = "BENEFICIARIO", nullable = false)
    private long beneficiario;

    public BeneficiarioPorCandidatoPK() {
    }

    public BeneficiarioPorCandidatoPK(long codCia, long candidato, long beneficiario) {
        this.codCia = codCia;
        this.candidato = candidato;
        this.beneficiario = beneficiario;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCandidato() {
        return candidato;
    }

    public void setCandidato(long candidato) {
        this.candidato = candidato;
    }

    public long getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(long beneficiario) {
        this.beneficiario = beneficiario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) candidato;
        hash += (int) beneficiario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeneficiarioPorCandidatoPK)) {
            return false;
        }
        BeneficiarioPorCandidatoPK other = (BeneficiarioPorCandidatoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.candidato != other.candidato) {
            return false;
        }
        if (this.beneficiario != other.beneficiario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.BeneficiarioPorCandidatoPK[ codCia=" + codCia + ", candidato=" + candidato + ", beneficiario=" + beneficiario + " ]";
    }
    
}
