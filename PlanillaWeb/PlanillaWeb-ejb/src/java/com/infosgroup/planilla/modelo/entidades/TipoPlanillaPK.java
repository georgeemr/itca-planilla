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
public class TipoPlanillaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PLANILLA", nullable = false)
    private long idTipoPlanilla;

    public TipoPlanillaPK()
    {
    }

    public TipoPlanillaPK(long idCompania, long idTipoPlanilla)
    {
        this.idCompania = idCompania;
        this.idTipoPlanilla = idTipoPlanilla;
    }

    public long getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(long idCompania)
    {
        this.idCompania = idCompania;
    }

    public long getIdTipoPlanilla()
    {
        return idTipoPlanilla;
    }

    public void setIdTipoPlanilla(long idTipoPlanilla)
    {
        this.idTipoPlanilla = idTipoPlanilla;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idTipoPlanilla;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlanillaPK))
            {
            return false;
            }
        TipoPlanillaPK other = (TipoPlanillaPK) object;
        if (this.idCompania != other.idCompania) return false;
        if (this.idTipoPlanilla != other.idTipoPlanilla) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.TipoPlanillaPK[ idCompania=" + idCompania + ", idTipoPlanilla=" + idTipoPlanilla + " ]";
    }
    
}
