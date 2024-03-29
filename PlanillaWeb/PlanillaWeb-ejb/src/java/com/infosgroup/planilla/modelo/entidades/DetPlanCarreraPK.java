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
public class DetPlanCarreraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO", nullable = false)
    private short periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO", nullable = false)
    private short correlativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_PLAN", nullable = false)
    private short detPlan;

    public DetPlanCarreraPK() {
    }

    public DetPlanCarreraPK(short codCia, short periodo, short correlativo, short detPlan) {
        this.codCia = codCia;
        this.periodo = periodo;
        this.correlativo = correlativo;
        this.detPlan = detPlan;
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

    public short getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(short correlativo) {
        this.correlativo = correlativo;
    }

    public short getDetPlan() {
        return detPlan;
    }

    public void setDetPlan(short detPlan) {
        this.detPlan = detPlan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) periodo;
        hash += (int) correlativo;
        hash += (int) detPlan;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPlanCarreraPK)) {
            return false;
        }
        DetPlanCarreraPK other = (DetPlanCarreraPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        if (this.detPlan != other.detPlan) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetPlanCarreraPK[ codCia=" + codCia + ", periodo=" + periodo + ", correlativo=" + correlativo + ", detPlan=" + detPlan + " ]";
    }
    
}
