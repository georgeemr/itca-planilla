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
public class FactorPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_FACTOR", nullable = false)
    private long codFactor;

    public FactorPK()
    {
    }

    public FactorPK(long codCia, long codFactor)
    {
        this.codCia = codCia;
        this.codFactor = codFactor;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getCodFactor()
    {
        return codFactor;
    }

    public void setCodFactor(long codFactor)
    {
        this.codFactor = codFactor;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codFactor;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactorPK))
            {
            return false;
            }
        FactorPK other = (FactorPK) object;
        if (this.codCia != other.codCia) return false;
        if (this.codFactor != other.codFactor) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.FactorPK[ codCia=" + codCia + ", codFactor=" + codFactor + " ]";
    }
    
}
