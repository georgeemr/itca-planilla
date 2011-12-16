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
public class MunicipioPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAIS", nullable = false)
    private long idPais;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROVINCIA", nullable = false)
    private long idProvincia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MUNICIPIO", nullable = false)
    private long idMunicipio;

    public MunicipioPK()
    {
    }

    public MunicipioPK(long idPais, long idProvincia, long idMunicipio)
    {
        this.idPais = idPais;
        this.idProvincia = idProvincia;
        this.idMunicipio = idMunicipio;
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

    public long getIdMunicipio()
    {
        return idMunicipio;
    }

    public void setIdMunicipio(long idMunicipio)
    {
        this.idMunicipio = idMunicipio;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idPais;
        hash += (int) idProvincia;
        hash += (int) idMunicipio;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipioPK))
            {
            return false;
            }
        MunicipioPK other = (MunicipioPK) object;
        if (this.idPais != other.idPais) return false;
        if (this.idProvincia != other.idProvincia) return false;
        if (this.idMunicipio != other.idMunicipio) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.MunicipioPK[ idPais=" + idPais + ", idProvincia=" + idProvincia + ", idMunicipio=" + idMunicipio + " ]";
    }
    
}
