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
public class ServidorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_AGENCIA", nullable = false)
    private short codAgencia;
    @Basic(optional = false)
    @Column(name = "SERVIDOR", nullable = false, length = 50)
    private String servidor;

    public ServidorPK() {
    }

    public ServidorPK(short codCia, short codAgencia, String servidor) {
        this.codCia = codCia;
        this.codAgencia = codAgencia;
        this.servidor = servidor;
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

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codAgencia;
        hash += (servidor != null ? servidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServidorPK)) {
            return false;
        }
        ServidorPK other = (ServidorPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codAgencia != other.codAgencia) {
            return false;
        }
        if ((this.servidor == null && other.servidor != null) || (this.servidor != null && !this.servidor.equals(other.servidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.ServidorPK[codCia=" + codCia + ", codAgencia=" + codAgencia + ", servidor=" + servidor + "]";
    }

}
