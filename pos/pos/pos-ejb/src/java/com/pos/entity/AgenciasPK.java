/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Soporte
 */
@Embeddable
public class AgenciasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_AGENCIA", nullable = false)
    private short codAgencia;

    public AgenciasPK() {
    }

    public AgenciasPK(short codCia, short codAgencia) {
        this.codCia = codCia;
        this.codAgencia = codAgencia;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(short codAgencia) {
        this.codAgencia = codAgencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codAgencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgenciasPK)) {
            return false;
        }
        AgenciasPK other = (AgenciasPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codAgencia != other.codAgencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.AgenciasPK[codCia=" + codCia + ", codAgencia=" + codAgencia + "]";
    }

}
