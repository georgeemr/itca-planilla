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
public class MunicipiosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_PAIS", nullable = false)
    private short codPais;
    @Basic(optional = false)
    @Column(name = "COD_DEPTO", nullable = false)
    private short codDepto;
    @Basic(optional = false)
    @Column(name = "COD_MUNI", nullable = false)
    private short codMuni;

    public MunicipiosPK() {
    }

    public MunicipiosPK(short codPais, short codDepto, short codMuni) {
        this.codPais = codPais;
        this.codDepto = codDepto;
        this.codMuni = codMuni;
    }

    public short getCodPais() {
        return codPais;
    }

    public void setCodPais(short codPais) {
        this.codPais = codPais;
    }

    public short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(short codDepto) {
        this.codDepto = codDepto;
    }

    public short getCodMuni() {
        return codMuni;
    }

    public void setCodMuni(short codMuni) {
        this.codMuni = codMuni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPais;
        hash += (int) codDepto;
        hash += (int) codMuni;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipiosPK)) {
            return false;
        }
        MunicipiosPK other = (MunicipiosPK) object;
        if (this.codPais != other.codPais) {
            return false;
        }
        if (this.codDepto != other.codDepto) {
            return false;
        }
        if (this.codMuni != other.codMuni) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.parametros.MunicipiosPK[ codPais=" + codPais + ", codDepto=" + codDepto + ", codMuni=" + codMuni + " ]";
    }
    
}
