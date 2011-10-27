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
    @Column(name = "cod_tipo_evaluacion", nullable = false)
    private int codTipoEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo", nullable = false)
    private int periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_emp", nullable = false)
    private int codEmp;

    public EvaluacionPK() {
    }

    public EvaluacionPK(int codCia, int codCampania, int codTipoEvaluacion, int periodo, int codEmp) {
        this.codCia = codCia;
        this.codCampania = codCampania;
        this.codTipoEvaluacion = codTipoEvaluacion;
        this.periodo = periodo;
        this.codEmp = codEmp;
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

    public int getCodTipoEvaluacion() {
        return codTipoEvaluacion;
    }

    public void setCodTipoEvaluacion(int codTipoEvaluacion) {
        this.codTipoEvaluacion = codTipoEvaluacion;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCampania;
        hash += (int) codTipoEvaluacion;
        hash += (int) periodo;
        hash += (int) codEmp;
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
        if (this.codTipoEvaluacion != other.codTipoEvaluacion) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EvaluacionPK[ codCia=" + codCia + ", codCampania=" + codCampania + ", codTipoEvaluacion=" + codTipoEvaluacion + ", periodo=" + periodo + ", codEmp=" + codEmp + " ]";
    }
    
}
