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
public class IndicadorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "MODULO", nullable = false)
    private long modulo;
    @Basic(optional = false)
    @Column(name = "INDICADOR", nullable = false)
    private long indicador;

    public IndicadorPK() {
    }

    public IndicadorPK(short codCia, long modulo, long indicador) {
        this.codCia = codCia;
        this.modulo = modulo;
        this.indicador = indicador;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public long getModulo() {
        return modulo;
    }

    public void setModulo(long modulo) {
        this.modulo = modulo;
    }

    public long getIndicador() {
        return indicador;
    }

    public void setIndicador(long indicador) {
        this.indicador = indicador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) modulo;
        hash += (int) indicador;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicadorPK)) {
            return false;
        }
        IndicadorPK other = (IndicadorPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.modulo != other.modulo) {
            return false;
        }
        if (this.indicador != other.indicador) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.IndicadorPK[ codCia=" + codCia + ", modulo=" + modulo + ", indicador=" + indicador + " ]";
    }
    
}
