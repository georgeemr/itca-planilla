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
public class ResumenAsistenciaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO", nullable = false)
    private long anio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "MES", nullable = false)
    private long mes;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PLANILLA", nullable = false)
    private long numPlanilla;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP", nullable = false)
    private long codEmp;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUCURSAL", nullable = false)
    private long idSucursal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PUESTO", nullable = false)
    private long idTipoPuesto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PUESTO", nullable = false)
    private long idPuesto;

    public ResumenAsistenciaPK()
    {
    }

    public ResumenAsistenciaPK(long idCompania, long anio, long mes, long numPlanilla, long codEmp, long idSucursal, long idTipoPuesto, long idPuesto)
    {
        this.idCompania = idCompania;
        this.anio = anio;
        this.mes = mes;
        this.numPlanilla = numPlanilla;
        this.codEmp = codEmp;
        this.idSucursal = idSucursal;
        this.idTipoPuesto = idTipoPuesto;
        this.idPuesto = idPuesto;
    }

    public long getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(long idCompania)
    {
        this.idCompania = idCompania;
    }

    public long getAnio()
    {
        return anio;
    }

    public void setAnio(long anio)
    {
        this.anio = anio;
    }

    public long getMes()
    {
        return mes;
    }

    public void setMes(long mes)
    {
        this.mes = mes;
    }

    public long getNumPlanilla()
    {
        return numPlanilla;
    }

    public void setNumPlanilla(long numPlanilla)
    {
        this.numPlanilla = numPlanilla;
    }

    public long getCodEmp()
    {
        return codEmp;
    }

    public void setCodEmp(long codEmp)
    {
        this.codEmp = codEmp;
    }

    public long getIdSucursal()
    {
        return idSucursal;
    }

    public void setIdSucursal(long idSucursal)
    {
        this.idSucursal = idSucursal;
    }

    public long getIdTipoPuesto()
    {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(long idTipoPuesto)
    {
        this.idTipoPuesto = idTipoPuesto;
    }

    public long getIdPuesto()
    {
        return idPuesto;
    }

    public void setIdPuesto(long idPuesto)
    {
        this.idPuesto = idPuesto;
    }

    @Override
    public int hashCode()
    {
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
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenAsistenciaPK))
            {
            return false;
            }
        ResumenAsistenciaPK other = (ResumenAsistenciaPK) object;
        if (this.idCompania != other.idCompania)
            {
            return false;
            }
        if (this.anio != other.anio)
            {
            return false;
            }
        if (this.mes != other.mes)
            {
            return false;
            }
        if (this.numPlanilla != other.numPlanilla)
            {
            return false;
            }
        if (this.codEmp != other.codEmp)
            {
            return false;
            }
        if (this.idSucursal != other.idSucursal)
            {
            return false;
            }
        if (this.idTipoPuesto != other.idTipoPuesto)
            {
            return false;
            }
        if (this.idPuesto != other.idPuesto)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.ResumenAsistenciaPK[ idCompania=" + idCompania + ", anio=" + anio + ", mes=" + mes + ", numPlanilla=" + numPlanilla + ", codEmp=" + codEmp + ", idSucursal=" + idSucursal + ", idTipoPuesto=" + idTipoPuesto + ", idPuesto=" + idPuesto + " ]";
    }
    
}
