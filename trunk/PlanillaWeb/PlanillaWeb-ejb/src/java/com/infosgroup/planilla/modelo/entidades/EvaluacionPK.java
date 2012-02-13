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
public class EvaluacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CAMPANIA", nullable = false)
    private short codCampania;
    @Basic(optional = false)
    @Column(name = "COD_EVALUACION", nullable = false)
    private short codEvaluacion;

    public EvaluacionPK() {
    }

    public EvaluacionPK(short codCia, short codCampania, short codEvaluacion) {
        this.codCia = codCia;
        this.codCampania = codCampania;
        this.codEvaluacion = codEvaluacion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodCampania() {
        return codCampania;
    }

    public void setCodCampania(short codCampania) {
        this.codCampania = codCampania;
    }

    public short getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(short codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCampania;
        hash += (int) codEvaluacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionPK)) {
            return false;
        }
        EvaluacionPK other = (EvaluacionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCampania != other.codCampania) {
            return false;
        }
        if (this.codEvaluacion != other.codEvaluacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.EvaluacionPK[ codCia=" + codCia + ", codCampania=" + codCampania + ", codEvaluacion=" + codEvaluacion + " ]";
    }
    
}
