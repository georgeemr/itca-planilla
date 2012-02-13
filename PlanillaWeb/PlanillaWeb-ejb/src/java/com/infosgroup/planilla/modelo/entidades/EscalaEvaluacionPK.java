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
    private short codCia;
    @Basic(optional = false)
    @Column(name = "ESCALA", nullable = false)
    private short escala;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_EVALUACION", nullable = false)
    private short codTipoEvaluacion;

    public EscalaEvaluacionPK() {
    }

    public EscalaEvaluacionPK(short codCia, short escala, short codTipoEvaluacion) {
        this.codCia = codCia;
        this.escala = escala;
        this.codTipoEvaluacion = codTipoEvaluacion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getEscala() {
        return escala;
    }

    public void setEscala(short escala) {
        this.escala = escala;
    }

    public short getCodTipoEvaluacion() {
        return codTipoEvaluacion;
    }

    public void setCodTipoEvaluacion(short codTipoEvaluacion) {
        this.codTipoEvaluacion = codTipoEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) escala;
        hash += (int) codTipoEvaluacion;
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
        if (this.escala != other.escala) {
            return false;
        }
        if (this.codTipoEvaluacion != other.codTipoEvaluacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.EscalaEvaluacionPK[ codCia=" + codCia + ", escala=" + escala + ", codTipoEvaluacion=" + codTipoEvaluacion + " ]";
    }
    
}
