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
public class CapacitacionXCandidatoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CANDIDATO", nullable = false)
    private int codCandidato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CAPACITACION", nullable = false)
    private int codCapacitacion;

    public CapacitacionXCandidatoPK() {
    }

    public CapacitacionXCandidatoPK(short codCia, int codCandidato, int codCapacitacion) {
        this.codCia = codCia;
        this.codCandidato = codCandidato;
        this.codCapacitacion = codCapacitacion;
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

    public int getCodCapacitacion() {
        return codCapacitacion;
    }

    public void setCodCapacitacion(int codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCandidato;
        hash += (int) codCapacitacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionXCandidatoPK)) {
            return false;
        }
        CapacitacionXCandidatoPK other = (CapacitacionXCandidatoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCandidato != other.codCandidato) {
            return false;
        }
        if (this.codCapacitacion != other.codCapacitacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CapacitacionXCandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + ", codCapacitacion=" + codCapacitacion + " ]";
    }
    
}
