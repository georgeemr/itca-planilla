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
public class MunicipioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_PAIS", nullable = false)
    private long codPais;
    @Basic(optional = false)
    @Column(name = "COD_PROVINCIA", nullable = false)
    private long codProvincia;
    @Basic(optional = false)
    @Column(name = "COD_MUNICIPIO", nullable = false)
    private long codMunicipio;

    public MunicipioPK() {
    }

    public MunicipioPK(long codPais, long codProvincia, long codMunicipio) {
        this.codPais = codPais;
        this.codProvincia = codProvincia;
        this.codMunicipio = codMunicipio;
    }

    public long getCodPais() {
        return codPais;
    }

    public void setCodPais(long codPais) {
        this.codPais = codPais;
    }

    public long getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(long codProvincia) {
        this.codProvincia = codProvincia;
    }

    public long getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(long codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPais;
        hash += (int) codProvincia;
        hash += (int) codMunicipio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipioPK)) {
            return false;
        }
        MunicipioPK other = (MunicipioPK) object;
        if (this.codPais != other.codPais) {
            return false;
        }
        if (this.codProvincia != other.codProvincia) {
            return false;
        }
        if (this.codMunicipio != other.codMunicipio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.MunicipioPK[ codPais=" + codPais + ", codProvincia=" + codProvincia + ", codMunicipio=" + codMunicipio + " ]";
    }
    
}
