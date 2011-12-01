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
public class BarrioPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pais", nullable = false)
    private int idPais;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_provincia", nullable = false)
    private int idProvincia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_municipio", nullable = false)
    private int idMunicipio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_barrio", nullable = false)
    private int idBarrio;

    public BarrioPK()
    {
    }

    public BarrioPK(int idPais, int idProvincia, int idMunicipio, int idBarrio)
    {
        this.idPais = idPais;
        this.idProvincia = idProvincia;
        this.idMunicipio = idMunicipio;
        this.idBarrio = idBarrio;
    }

    public int getIdPais()
    {
        return idPais;
    }

    public void setIdPais(int idPais)
    {
        this.idPais = idPais;
    }

    public int getIdProvincia()
    {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia)
    {
        this.idProvincia = idProvincia;
    }

    public int getIdMunicipio()
    {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio)
    {
        this.idMunicipio = idMunicipio;
    }

    public int getIdBarrio()
    {
        return idBarrio;
    }

    public void setIdBarrio(int idBarrio)
    {
        this.idBarrio = idBarrio;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idPais;
        hash += (int) idProvincia;
        hash += (int) idMunicipio;
        hash += (int) idBarrio;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BarrioPK))
            {
            return false;
            }
        BarrioPK other = (BarrioPK) object;
        if (this.idPais != other.idPais)
            {
            return false;
            }
        if (this.idProvincia != other.idProvincia)
            {
            return false;
            }
        if (this.idMunicipio != other.idMunicipio)
            {
            return false;
            }
        if (this.idBarrio != other.idBarrio)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.BarrioPK[ idPais=" + idPais + ", idProvincia=" + idProvincia + ", idMunicipio=" + idMunicipio + ", idBarrio=" + idBarrio + " ]";
    }
    
}
