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
public class ResumenAsistenciaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio", nullable = false)
    private int anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes", nullable = false)
    private int mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_planilla", nullable = false)
    private int numPlanilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_emp", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sucursal", nullable = false)
    private int idSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_puesto", nullable = false)
    private int idTipoPuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_puesto", nullable = false)
    private int idPuesto;

    public ResumenAsistenciaPK() {
    }

    public ResumenAsistenciaPK(int idCompania, int anio, int mes, int numPlanilla, int codEmp, int idSucursal, int idTipoPuesto, int idPuesto) {
        this.idCompania = idCompania;
        this.anio = anio;
        this.mes = mes;
        this.numPlanilla = numPlanilla;
        this.codEmp = codEmp;
        this.idSucursal = idSucursal;
        this.idTipoPuesto = idTipoPuesto;
        this.idPuesto = idPuesto;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(int numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdTipoPuesto() {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(int idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) anio;
        hash += (int) mes;
        hash += (int) numPlanilla;
        hash += (int) codEmp;
        hash += (int) idSucursal;
        hash += (int) idTipoPuesto;
        hash += (int) idPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenAsistenciaPK)) {
            return false;
        }
        ResumenAsistenciaPK other = (ResumenAsistenciaPK) object;
        if (this.idCompania != other.idCompania) {
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
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        if (this.idTipoPuesto != other.idTipoPuesto) {
            return false;
        }
        if (this.idPuesto != other.idPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ResumenAsistenciaPK[ idCompania=" + idCompania + ", anio=" + anio + ", mes=" + mes + ", numPlanilla=" + numPlanilla + ", codEmp=" + codEmp + ", idSucursal=" + idSucursal + ", idTipoPuesto=" + idTipoPuesto + ", idPuesto=" + idPuesto + " ]";
    }
    
}
