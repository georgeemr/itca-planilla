/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class PlanillaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO", nullable = false)
    private short anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MES", nullable = false)
    private short mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PLANILLA", nullable = false)
    private short numPlanilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Transient
    private String pkAsString;
    
    public PlanillaPK() {
    }

    public PlanillaPK(short codCia, short anio, short mes, short numPlanilla, int codEmp) {
        this.codCia = codCia;
        this.anio = anio;
        this.mes = mes;
        this.numPlanilla = numPlanilla;
        this.codEmp = codEmp;
    }

    public PlanillaPK(String p, int empleado) {
        this.codCia = new Short(p.split(":")[0]);
        this.anio = new Short(p.split(":")[1]);
        this.mes = new Short(p.split(":")[2]);
        this.numPlanilla = new Short(p.split(":")[3]);
        this.codEmp = empleado;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public short getMes() {
        return mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    public short getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(short numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }
    
    public String getPkAsString() {
        pkAsString = "" + codCia + ":" + anio + ":" + mes + ":" + numPlanilla;
        return pkAsString;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) anio;
        hash += (int) mes;
        hash += (int) numPlanilla;
        hash += (int) codEmp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanillaPK)) {
            return false;
        }
        PlanillaPK other = (PlanillaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.numPlanilla != other.numPlanilla) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PlanillaPK[ codCia=" + codCia + ", anio=" + anio + ", mes=" + mes + ", numPlanilla=" + numPlanilla + ", codEmp=" + codEmp + " ]";
    }
    
}
