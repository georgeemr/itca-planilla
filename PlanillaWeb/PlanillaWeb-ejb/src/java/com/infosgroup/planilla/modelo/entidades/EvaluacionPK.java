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
    @Column(name = "periodo", nullable = false)
    private int periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_campania", nullable = false)
    private int codCampania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleado", nullable = false)
    private int empleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_evaluacion", nullable = false)
    private int tipoEvaluacion;

    public EvaluacionPK() {
    }

    public EvaluacionPK(int codCia, int periodo, int codCampania, int empleado, int tipoEvaluacion) {
        this.codCia = codCia;
        this.periodo = periodo;
        this.codCampania = codCampania;
        this.empleado = empleado;
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public int getCodCia() {
        return codCia;
    }

    public void setCodCia(int codCia) {
        this.codCia = codCia;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getCodCampania() {
        return codCampania;
    }

    public void setCodCampania(int codCampania) {
        this.codCampania = codCampania;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public int getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(int tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) periodo;
        hash += (int) codCampania;
        hash += (int) empleado;
        hash += (int) tipoEvaluacion;
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
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.codCampania != other.codCampania) {
            return false;
        }
        if (this.empleado != other.empleado) {
            return false;
        }
        if (this.tipoEvaluacion != other.tipoEvaluacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EvaluacionPK[ codCia=" + codCia + ", periodo=" + periodo + ", codCampania=" + codCampania + ", empleado=" + empleado + ", tipoEvaluacion=" + tipoEvaluacion + " ]";
    }
    
}
