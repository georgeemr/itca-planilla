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
public class CriteriosXPuestoPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PUESTO", nullable = false)
    private long puesto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_CRITERIO", nullable = false)
    private long tipoCriterio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CRITERIO", nullable = false)
    private long criterio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO", nullable = false)
    private long correlativo;

    public CriteriosXPuestoPK()
    {
    }

    public CriteriosXPuestoPK(long codCia, long puesto, long tipoCriterio, long criterio, long correlativo)
    {
        this.codCia = codCia;
        this.puesto = puesto;
        this.tipoCriterio = tipoCriterio;
        this.criterio = criterio;
        this.correlativo = correlativo;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getPuesto()
    {
        return puesto;
    }

    public void setPuesto(long puesto)
    {
        this.puesto = puesto;
    }

    public long getTipoCriterio()
    {
        return tipoCriterio;
    }

    public void setTipoCriterio(long tipoCriterio)
    {
        this.tipoCriterio = tipoCriterio;
    }

    public long getCriterio()
    {
        return criterio;
    }

    public void setCriterio(long criterio)
    {
        this.criterio = criterio;
    }

    public long getCorrelativo()
    {
        return correlativo;
    }

    public void setCorrelativo(long correlativo)
    {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) puesto;
        hash += (int) tipoCriterio;
        hash += (int) criterio;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXPuestoPK))
            {
            return false;
            }
        CriteriosXPuestoPK other = (CriteriosXPuestoPK) object;
        if (this.codCia != other.codCia) return false;
        if (this.puesto != other.puesto) return false;
        if (this.tipoCriterio != other.tipoCriterio) return false;
        if (this.criterio != other.criterio) return false;
        if (this.correlativo != other.correlativo) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.CriteriosXPuestoPK[ codCia=" + codCia + ", puesto=" + puesto + ", tipoCriterio=" + tipoCriterio + ", criterio=" + criterio + ", correlativo=" + correlativo + " ]";
    }
    
}
