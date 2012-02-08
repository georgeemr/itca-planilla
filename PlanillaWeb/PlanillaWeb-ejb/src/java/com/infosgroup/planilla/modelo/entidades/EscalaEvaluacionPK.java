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
public class EscalaEvaluacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "TIPO_EVALUACION", nullable = false)
    private long tipoEvaluacion;
    @Basic(optional = false)
    @Column(name = "ESCALA", nullable = false)
    private long escala;

    public EscalaEvaluacionPK() {
    }

    public EscalaEvaluacionPK(long codCia, long tipoEvaluacion, long escala) {
        this.codCia = codCia;
        this.tipoEvaluacion = tipoEvaluacion;
        this.escala = escala;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(long tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public long getEscala() {
        return escala;
    }

    public void setEscala(long escala) {
        this.escala = escala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) tipoEvaluacion;
        hash += (int) escala;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscalaEvaluacionPK)) {
            return false;
        }
        EscalaEvaluacionPK other = (EscalaEvaluacionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.tipoEvaluacion != other.tipoEvaluacion) {
            return false;
        }
        if (this.escala != other.escala) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EscalaEvaluacionPK[ codCia=" + codCia + ", tipoEvaluacion=" + tipoEvaluacion + ", escala=" + escala + " ]";
    }
    
}
