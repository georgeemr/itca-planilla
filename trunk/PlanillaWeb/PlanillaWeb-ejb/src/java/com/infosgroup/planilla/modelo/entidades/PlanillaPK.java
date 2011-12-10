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
public class PlanillaPK implements Serializable
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

    public PlanillaPK()
    {
    }

    public PlanillaPK(long idCompania, long anio, long mes, long numPlanilla)
    {
        this.idCompania = idCompania;
        this.anio = anio;
        this.mes = mes;
        this.numPlanilla = numPlanilla;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) anio;
        hash += (int) mes;
        hash += (int) numPlanilla;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanillaPK))
            {
            return false;
            }
        PlanillaPK other = (PlanillaPK) object;
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
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.PlanillaPK[ idCompania=" + idCompania + ", anio=" + anio + ", mes=" + mes + ", numPlanilla=" + numPlanilla + " ]";
    }
    
}
