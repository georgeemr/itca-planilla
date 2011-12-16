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
public class DireccionEmpleadoPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUCURSAL", nullable = false)
    private long idSucursal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO", nullable = false)
    private long idEmpleado;

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

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BARRIO", nullable = false)
    private long idBarrio;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NUM_CASA", nullable = false, length = 100)
    private String numCasa;

    public DireccionEmpleadoPK()
    {
    }

    public DireccionEmpleadoPK(long idCompania, long idSucursal, long idEmpleado, long idPais, long idProvincia, long idMunicipio, long idBarrio, String numCasa)
    {
        this.idCompania = idCompania;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
        this.idPais = idPais;
        this.idProvincia = idProvincia;
        this.idMunicipio = idMunicipio;
        this.idBarrio = idBarrio;
        this.numCasa = numCasa;
    }

    public long getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(long idCompania)
    {
        this.idCompania = idCompania;
    }

    public long getIdSucursal()
    {
        return idSucursal;
    }

    public void setIdSucursal(long idSucursal)
    {
        this.idSucursal = idSucursal;
    }

    public long getIdEmpleado()
    {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado)
    {
        this.idEmpleado = idEmpleado;
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

    public long getIdBarrio()
    {
        return idBarrio;
    }

    public void setIdBarrio(long idBarrio)
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
        hash += (int) idCompania;
        hash += (int) idSucursal;
        hash += (int) idEmpleado;
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
        if (!(object instanceof DireccionEmpleadoPK))
            {
            return false;
            }
        DireccionEmpleadoPK other = (DireccionEmpleadoPK) object;
        if (this.idCompania != other.idCompania) return false;
        if (this.idSucursal != other.idSucursal) return false;
        if (this.idEmpleado != other.idEmpleado) return false;
        if (this.idPais != other.idPais) return false;
        if (this.idProvincia != other.idProvincia) return false;
        if (this.idMunicipio != other.idMunicipio) return false;
        if (this.idBarrio != other.idBarrio) return false;
        if ((this.numCasa == null && other.numCasa != null) || (this.numCasa != null && !this.numCasa.equals(other.numCasa))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DireccionEmpleadoPK[ idCompania=" + idCompania + ", idSucursal=" + idSucursal + ", idEmpleado=" + idEmpleado + ", idPais=" + idPais + ", idProvincia=" + idProvincia + ", idMunicipio=" + idMunicipio + ", idBarrio=" + idBarrio + ", numCasa=" + numCasa + " ]";
    }
    
}
