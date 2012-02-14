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
public class DetEvaluacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "PERIODO", nullable = false)
    private short periodo;
    @Basic(optional = false)
    @Column(name = "COD_CAMPANIA", nullable = false)
    private short codCampania;
    @Basic(optional = false)
    @Column(name = "TIPO_EVALUACION", nullable = false)
    private short tipoEvaluacion;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "COD_DET_EVALUACION", nullable = false)
    private long codDetEvaluacion;

    public DetEvaluacionPK() {
    }

    public DetEvaluacionPK(short codCia, short periodo, short codCampania, short tipoEvaluacion, int codEmp, long codDetEvaluacion) {
        this.codCia = codCia;
        this.periodo = periodo;
        this.codCampania = codCampania;
        this.tipoEvaluacion = tipoEvaluacion;
        this.codEmp = codEmp;
        this.codDetEvaluacion = codDetEvaluacion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getPeriodo() {
        return periodo;
    }

    public void setPeriodo(short periodo) {
        this.periodo = periodo;
    }

    public short getCodCampania() {
        return codCampania;
    }

    public void setCodCampania(short codCampania) {
        this.codCampania = codCampania;
    }

    public short getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(short tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public long getCodDetEvaluacion() {
        return codDetEvaluacion;
    }

    public void setCodDetEvaluacion(long codDetEvaluacion) {
        this.codDetEvaluacion = codDetEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) periodo;
        hash += (int) codCampania;
        hash += (int) tipoEvaluacion;
        hash += (int) codEmp;
        hash += (int) codDetEvaluacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetEvaluacionPK)) {
            return false;
        }
        DetEvaluacionPK other = (DetEvaluacionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.codCampania != other.codCampania) {
            return false;
        }
        if (this.tipoEvaluacion != other.tipoEvaluacion) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (this.codDetEvaluacion != other.codDetEvaluacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetEvaluacionPK[ codCia=" + codCia + ", periodo=" + periodo + ", codCampania=" + codCampania + ", tipoEvaluacion=" + tipoEvaluacion + ", codEmp=" + codEmp + ", codDetEvaluacion=" + codDetEvaluacion + " ]";
    }
    
}
