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
public class CampaniaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CAMPANIA", nullable = false)
    private long codCampania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO", nullable = false)
    private long periodo;

    public CampaniaPK()
    {
    }

    public CampaniaPK(long codCia, long codCampania, long periodo)
    {
        this.codCia = codCia;
        this.codCampania = codCampania;
        this.periodo = periodo;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getCodCampania()
    {
        return codCampania;
    }

    public void setCodCampania(long codCampania)
    {
        this.codCampania = codCampania;
    }

    public long getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(long periodo)
    {
        this.periodo = periodo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCampania;
        hash += (int) periodo;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampaniaPK))
            {
            return false;
            }
        CampaniaPK other = (CampaniaPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if (this.codCampania != other.codCampania)
            {
            return false;
            }
        if (this.periodo != other.periodo)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.CampaniaPK[ codCia=" + codCia + ", codCampania=" + codCampania + ", periodo=" + periodo + " ]";
    }
    
}
