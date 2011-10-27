/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class EvaluacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_campania", nullable = false)
    private int codCampania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_evaluacion", nullable = false)
    private int codEvaluacion;

    public EvaluacionPK() {
    }

    public EvaluacionPK(int codCia, int codCampania, int codEvaluacion) {
        this.codCia = codCia;
        this.codCampania = codCampania;
        this.codEvaluacion = codEvaluacion;
    }

    public int getCodCia() {
        return codCia;
    }

    public void setCodCia(int codCia) {
        this.codCia = codCia;
    }

    public int getCodCampania() {
        return codCampania;
    }

    public void setCodCampania(int codCampania) {
        this.codCampania = codCampania;
    }

    public int getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(int codEvaluacion) {
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
        return "com.infosgroup.planilla.modelo.entidades.EvaluacionPK[ codCia=" + codCia + ", codCampania=" + codCampania + ", codEvaluacion=" + codEvaluacion + " ]";
    }
    
}
