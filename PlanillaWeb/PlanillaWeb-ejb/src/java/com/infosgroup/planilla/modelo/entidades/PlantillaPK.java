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
public class PlantillaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_EVALUACION", nullable = false)
    private long codTipoEvaluacion;
    @Basic(optional = false)
    @Column(name = "COD_PLANTILLA", nullable = false)
    private long codPlantilla;

    public PlantillaPK() {
    }

    public PlantillaPK(long codCia, long codTipoEvaluacion, long codPlantilla) {
        this.codCia = codCia;
        this.codTipoEvaluacion = codTipoEvaluacion;
        this.codPlantilla = codPlantilla;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodTipoEvaluacion() {
        return codTipoEvaluacion;
    }

    public void setCodTipoEvaluacion(long codTipoEvaluacion) {
        this.codTipoEvaluacion = codTipoEvaluacion;
    }

    public long getCodPlantilla() {
        return codPlantilla;
    }

    public void setCodPlantilla(long codPlantilla) {
        this.codPlantilla = codPlantilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoEvaluacion;
        hash += (int) codPlantilla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantillaPK)) {
            return false;
        }
        PlantillaPK other = (PlantillaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoEvaluacion != other.codTipoEvaluacion) {
            return false;
        }
        if (this.codPlantilla != other.codPlantilla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PlantillaPK[ codCia=" + codCia + ", codTipoEvaluacion=" + codTipoEvaluacion + ", codPlantilla=" + codPlantilla + " ]";
    }
    
}
