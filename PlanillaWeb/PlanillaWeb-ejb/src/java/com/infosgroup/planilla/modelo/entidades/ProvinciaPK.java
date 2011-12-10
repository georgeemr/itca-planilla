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
public class ProvinciaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAIS", nullable = false)
    private long idPais;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROVINCIA", nullable = false)
    private long idProvincia;

    public ProvinciaPK()
    {
    }

    public ProvinciaPK(long idPais, long idProvincia)
    {
        this.idPais = idPais;
        this.idProvincia = idProvincia;
    }

    public long getIdPais()
    {
        return idPais;
    }

    public void setIdPais(long idPais)
    {
        this.idPais = idPais;
    }

    public long getIdProvincia()
    {
        return idProvincia;
    }

    public void setIdProvincia(long idProvincia)
    {
        this.idProvincia = idProvincia;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idPais;
        hash += (int) idProvincia;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProvinciaPK))
            {
            return false;
            }
        ProvinciaPK other = (ProvinciaPK) object;
        if (this.idPais != other.idPais)
            {
            return false;
            }
        if (this.idProvincia != other.idProvincia)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.ProvinciaPK[ idPais=" + idPais + ", idProvincia=" + idProvincia + " ]";
    }
    
}
