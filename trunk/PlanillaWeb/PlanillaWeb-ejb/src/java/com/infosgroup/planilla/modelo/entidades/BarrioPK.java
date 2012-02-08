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
public class BarrioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_PAIS", nullable = false)
    private long codPais;
    @Basic(optional = false)
    @Column(name = "COD_PROVINCIA", nullable = false)
    private long codProvincia;
    @Basic(optional = false)
    @Column(name = "COD_MUNICIPIO", nullable = false)
    private long codMunicipio;
    @Basic(optional = false)
    @Column(name = "COD_BARRIO", nullable = false)
    private long codBarrio;

    public BarrioPK() {
    }

    public BarrioPK(long codPais, long codProvincia, long codMunicipio, long codBarrio) {
        this.codPais = codPais;
        this.codProvincia = codProvincia;
        this.codMunicipio = codMunicipio;
        this.codBarrio = codBarrio;
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

    public long getCodBarrio() {
        return codBarrio;
    }

    public void setCodBarrio(long codBarrio) {
        this.codBarrio = codBarrio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPais;
        hash += (int) codProvincia;
        hash += (int) codMunicipio;
        hash += (int) codBarrio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BarrioPK)) {
            return false;
        }
        BarrioPK other = (BarrioPK) object;
        if (this.codPais != other.codPais) {
            return false;
        }
        if (this.codProvincia != other.codProvincia) {
            return false;
        }
        if (this.codMunicipio != other.codMunicipio) {
            return false;
        }
        if (this.codBarrio != other.codBarrio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.BarrioPK[ codPais=" + codPais + ", codProvincia=" + codProvincia + ", codMunicipio=" + codMunicipio + ", codBarrio=" + codBarrio + " ]";
    }
    
}
