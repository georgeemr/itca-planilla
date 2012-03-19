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
public class ProgramacionPlaPK implements Serializable {
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
    @Column(name = "SECUENCIA", nullable = false)
    private int secuencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPOPLA", nullable = false)
    private short codTipopla;

    public ProgramacionPlaPK() {
    }

    public ProgramacionPlaPK(short codCia, short periodo, int secuencia, short codTipopla) {
        this.codCia = codCia;
        this.periodo = periodo;
        this.secuencia = secuencia;
        this.codTipopla = codTipopla;
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

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(short codTipopla) {
        this.codTipopla = codTipopla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) periodo;
        hash += (int) secuencia;
        hash += (int) codTipopla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramacionPlaPK)) {
            return false;
        }
        ProgramacionPlaPK other = (ProgramacionPlaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.secuencia != other.secuencia) {
            return false;
        }
        if (this.codTipopla != other.codTipopla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + codCia + "," + periodo + "," + secuencia + "," + codTipopla;
    }
    
}
