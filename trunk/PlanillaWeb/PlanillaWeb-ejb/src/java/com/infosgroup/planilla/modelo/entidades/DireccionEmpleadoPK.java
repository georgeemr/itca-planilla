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
    @Column(name = "id_compania", nullable = false)
    private int idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sucursal", nullable = false)
    private int idSucursal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;

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

    public DireccionEmpleadoPK()
    {
    }

    public DireccionEmpleadoPK(int idCompania, int idSucursal, int idEmpleado, int idPais, int idProvincia, int idMunicipio, int idBarrio, String numCasa)
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

    public int getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(int idCompania)
    {
        this.idCompania = idCompania;
    }

    public int getIdSucursal()
    {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal)
    {
        this.idSucursal = idSucursal;
    }

    public int getIdEmpleado()
    {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado)
    {
        this.idEmpleado = idEmpleado;
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
        if (this.idCompania != other.idCompania)
            {
            return false;
            }
        if (this.idSucursal != other.idSucursal)
            {
            return false;
            }
        if (this.idEmpleado != other.idEmpleado)
            {
            return false;
            }
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
        return "com.infosgroup.planilla.modelo.entidades.DireccionEmpleadoPK[ idCompania=" + idCompania + ", idSucursal=" + idSucursal + ", idEmpleado=" + idEmpleado + ", idPais=" + idPais + ", idProvincia=" + idProvincia + ", idMunicipio=" + idMunicipio + ", idBarrio=" + idBarrio + ", numCasa=" + numCasa + " ]";
    }
    
}
