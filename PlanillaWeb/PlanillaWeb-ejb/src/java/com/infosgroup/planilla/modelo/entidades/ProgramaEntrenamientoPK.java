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
public class ProgramaEntrenamientoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO", nullable = false)
    private short periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DEPTO", nullable = false)
    private short codDepto;

    public ProgramaEntrenamientoPK() {
    }

    public ProgramaEntrenamientoPK(short codCia, short periodo, short codDepto) {
        this.codCia = codCia;
        this.periodo = periodo;
        this.codDepto = codDepto;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getPeriodo() {
        return periodo;
    }

    public void setPeriodo(short periodo) {
        this.periodo = periodo;
    }

    public short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(short codDepto) {
        this.codDepto = codDepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) periodo;
        hash += (int) codDepto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaEntrenamientoPK)) {
            return false;
        }
        ProgramaEntrenamientoPK other = (ProgramaEntrenamientoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.codDepto != other.codDepto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ProgramaEntrenamientoPK[ codCia=" + codCia + ", periodo=" + periodo + ", codDepto=" + codDepto + " ]";
    }
    
}
