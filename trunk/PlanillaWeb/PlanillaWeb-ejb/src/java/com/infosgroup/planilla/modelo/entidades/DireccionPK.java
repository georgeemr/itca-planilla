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
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Embeddable
public class DireccionPK implements Serializable
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

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "num_casa", nullable = false, length = 100)
    private String numCasa;

    public DireccionPK()
    {
    }

    public DireccionPK(int idPais, int idProvincia, int idMunicipio, int idBarrio, String numCasa)
    {
        this.idPais = idPais;
        this.idProvincia = idProvincia;
        this.idMunicipio = idMunicipio;
        this.idBarrio = idBarrio;
        this.numCasa = numCasa;
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

    public String getNumCasa()
    {
        return numCasa;
    }

    public void setNumCasa(String numCasa)
    {
        this.numCasa = numCasa;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idPais;
        hash += (int) idProvincia;
        hash += (int) idMunicipio;
        hash += (int) idBarrio;
        hash += (numCasa != null ? numCasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionPK))
            {
            return false;
            }
        DireccionPK other = (DireccionPK) object;
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
        if ((this.numCasa == null && other.numCasa != null) || (this.numCasa != null && !this.numCasa.equals(other.numCasa)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DireccionPK[ idPais=" + idPais + ", idProvincia=" + idProvincia + ", idMunicipio=" + idMunicipio + ", idBarrio=" + idBarrio + ", numCasa=" + numCasa + " ]";
    }
    
}
