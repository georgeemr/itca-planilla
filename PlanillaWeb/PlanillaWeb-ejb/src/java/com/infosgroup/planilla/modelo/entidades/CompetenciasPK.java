/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class CompetenciasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private BigInteger codCia;
    @Basic(optional = false)
    @Column(name = "COD_COMPETENCIA", nullable = false)
    private BigInteger codCompetencia;

    public CompetenciasPK() {
    }

    public CompetenciasPK(BigInteger codCia, BigInteger codCompetencia) {
        this.codCia = codCia;
        this.codCompetencia = codCompetencia;
    }

    public BigInteger getCodCia() {
        return codCia;
    }

    public void setCodCia(BigInteger codCia) {
        this.codCia = codCia;
    }

    public BigInteger getCodCompetencia() {
        return codCompetencia;
    }

    public void setCodCompetencia(BigInteger codCompetencia) {
        this.codCompetencia = codCompetencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCia != null ? codCia.hashCode() : 0);
        hash += (codCompetencia != null ? codCompetencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenciasPK)) {
            return false;
        }
        CompetenciasPK other = (CompetenciasPK) object;
        if ((this.codCia == null && other.codCia != null) || (this.codCia != null && !this.codCia.equals(other.codCia))) {
            return false;
        }
        if ((this.codCompetencia == null && other.codCompetencia != null) || (this.codCompetencia != null && !this.codCompetencia.equals(other.codCompetencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CompetenciasPK[ codCia=" + codCia + ", codCompetencia=" + codCompetencia + " ]";
    }
    
}
