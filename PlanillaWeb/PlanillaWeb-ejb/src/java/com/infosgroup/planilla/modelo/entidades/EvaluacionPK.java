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
    @Column(name = "tipo_evaluacion", nullable = false)
    private int tipoEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo", nullable = false)
    private int periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleado", nullable = false)
    private int empleado;

    public EvaluacionPK() {
    }

    public EvaluacionPK(int codCia, int codCampania, int tipoEvaluacion, int periodo, int empleado) {
        this.codCia = codCia;
        this.codCampania = codCampania;
        this.tipoEvaluacion = tipoEvaluacion;
        this.periodo = periodo;
        this.empleado = empleado;
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

    public int getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(int tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCampania;
        hash += (int) tipoEvaluacion;
        hash += (int) periodo;
        hash += (int) empleado;
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
        if (this.tipoEvaluacion != other.tipoEvaluacion) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.empleado != other.empleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EvaluacionPK[ codCia=" + codCia + ", codCampania=" + codCampania + ", tipoEvaluacion=" + tipoEvaluacion + ", periodo=" + periodo + ", empleado=" + empleado + " ]";
    }
    
}
