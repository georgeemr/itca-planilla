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
public class PuestoPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PUESTO", nullable = false)
    private long codPuesto;

    public PuestoPK()
    {
    }

    public PuestoPK(long codCia, long codPuesto)
    {
        this.codCia = codCia;
        this.codPuesto = codPuesto;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public Long getCodPuesto()
    {
        return codPuesto;
    }

    public void setCodPuesto(long codPuesto)
    {
        this.codPuesto = codPuesto;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuestoPK))
            {
            return false;
            }
        PuestoPK other = (PuestoPK) object;
        if (this.codCia != other.codCia) return false;
        if (this.codPuesto != other.codPuesto) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.PuestoPK[ codCia=" + codCia + ", codPuesto=" + codPuesto + " ]";
    }
    
}
