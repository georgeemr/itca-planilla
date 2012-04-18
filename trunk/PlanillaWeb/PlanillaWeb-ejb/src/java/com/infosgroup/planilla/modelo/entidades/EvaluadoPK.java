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
public class EvaluadoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "EVALUADOR", nullable = false)
    private long evaluador;
    @Basic(optional = false)
    @Column(name = "PERIODO", nullable = false)
    private long periodo;
    @Basic(optional = false)
    @Column(name = "CAMPANIA", nullable = false)
    private long campania;
    @Basic(optional = false)
    @Column(name = "TIPO_EVALUACION", nullable = false)
    private long tipoEvaluacion;
    @Basic(optional = false)
    @Column(name = "PLANTILLA", nullable = false)
    private long plantilla;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private long codEmp;

    public EvaluadoPK() {
    }

    public EvaluadoPK(long codCia, long evaluador, long periodo, long campania, long tipoEvaluacion, long plantilla, long codEmp) {
        this.codCia = codCia;
        this.evaluador = evaluador;
        this.periodo = periodo;
        this.campania = campania;
        this.tipoEvaluacion = tipoEvaluacion;
        this.plantilla = plantilla;
        this.codEmp = codEmp;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(long evaluador) {
        this.evaluador = evaluador;
    }

    public long getPeriodo() {
        return periodo;
    }

    public void setPeriodo(long periodo) {
        this.periodo = periodo;
    }

    public long getCampania() {
        return campania;
    }

    public void setCampania(long campania) {
        this.campania = campania;
    }

    public long getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(long tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public long getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(long plantilla) {
        this.plantilla = plantilla;
    }

    public long getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(long codEmp) {
        this.codEmp = codEmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) evaluador;
        hash += (int) periodo;
        hash += (int) campania;
        hash += (int) tipoEvaluacion;
        hash += (int) plantilla;
        hash += (int) codEmp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluadoPK)) {
            return false;
        }
        EvaluadoPK other = (EvaluadoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.evaluador != other.evaluador) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.campania != other.campania) {
            return false;
        }
        if (this.tipoEvaluacion != other.tipoEvaluacion) {
            return false;
        }
        if (this.plantilla != other.plantilla) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.EvaluadoPK[ codCia=" + codCia + ", evaluador=" + evaluador + ", periodo=" + periodo + ", campania=" + campania + ", tipoEvaluacion=" + tipoEvaluacion + ", plantilla=" + plantilla + ", codEmp=" + codEmp + " ]";
    }
    
}
