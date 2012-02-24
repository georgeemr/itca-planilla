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
public class PruebaXPuestoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "PUESTO", nullable = false)
    private long puesto;
    @Basic(optional = false)
    @Column(name = "CODIGO", nullable = false)
    private long codigo;

    public PruebaXPuestoPK() {
    }

    public PruebaXPuestoPK(short codCia, long puesto, long codigo) {
        this.codCia = codCia;
        this.puesto = puesto;
        this.codigo = codigo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public long getPuesto() {
        return puesto;
    }

    public void setPuesto(long puesto) {
        this.puesto = puesto;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) puesto;
        hash += (int) codigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PruebaXPuestoPK)) {
            return false;
        }
        PruebaXPuestoPK other = (PruebaXPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.puesto != other.puesto) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + codCia + ":" + puesto + ":" + codigo + "";
    }
    
}
