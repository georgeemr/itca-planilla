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
public class EntrevistaXCandidatoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CANDIDATO", nullable = false)
    private int codCandidato;
    @Basic(optional = false)
    @Column(name = "COD_PUESTO", nullable = false)
    private short codPuesto;
    @Basic(optional = false)
    @Column(name = "COD_ENTREVISTA", nullable = false)
    private short codEntrevista;

    public EntrevistaXCandidatoPK() {
    }

    public EntrevistaXCandidatoPK(short codCia, int codCandidato, short codPuesto, short codEntrevista) {
        this.codCia = codCia;
        this.codCandidato = codCandidato;
        this.codPuesto = codPuesto;
        this.codEntrevista = codEntrevista;
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

    public short getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(short codPuesto) {
        this.codPuesto = codPuesto;
    }

    public short getCodEntrevista() {
        return codEntrevista;
    }

    public void setCodEntrevista(short codEntrevista) {
        this.codEntrevista = codEntrevista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCandidato;
        hash += (int) codPuesto;
        hash += (int) codEntrevista;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntrevistaXCandidatoPK)) {
            return false;
        }
        EntrevistaXCandidatoPK other = (EntrevistaXCandidatoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCandidato != other.codCandidato) {
            return false;
        }
        if (this.codPuesto != other.codPuesto) {
            return false;
        }
        if (this.codEntrevista != other.codEntrevista) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.EntrevistaXCandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + ", codPuesto=" + codPuesto + ", codEntrevista=" + codEntrevista + " ]";
    }
    
}
