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
public class EvaluadorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private long codEmp;
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

    public EvaluadorPK() {
    }
    
    public EvaluadorPK( PreEvaluacion preEvaluacion, Empleados e ){
        this.codCia = preEvaluacion.getPreEvaluacionPK().getCodCia();
        this.codEmp = e.getEmpleadosPK().getCodEmp();
        this.periodo = preEvaluacion.getPreEvaluacionPK().getPeriodo();
        this.campania = preEvaluacion.getPreEvaluacionPK().getCodCampania();
        this.tipoEvaluacion = preEvaluacion.getPreEvaluacionPK().getTipoEvaluacion();
        this.plantilla = preEvaluacion.getPreEvaluacionPK().getPlantilla();        
    }

    public EvaluadorPK(long codCia, long codEmp, long periodo, long campania, long tipoEvaluacion, long plantilla) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.periodo = periodo;
        this.campania = campania;
        this.tipoEvaluacion = tipoEvaluacion;
        this.plantilla = plantilla;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(long codEmp) {
        this.codEmp = codEmp;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        hash += (int) periodo;
        hash += (int) campania;
        hash += (int) tipoEvaluacion;
        hash += (int) plantilla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluadorPK)) {
            return false;
        }
        EvaluadorPK other = (EvaluadorPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
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
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.EvaluadorPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", periodo=" + periodo + ", campania=" + campania + ", tipoEvaluacion=" + tipoEvaluacion + ", plantilla=" + plantilla + " ]";
    }
    
}
