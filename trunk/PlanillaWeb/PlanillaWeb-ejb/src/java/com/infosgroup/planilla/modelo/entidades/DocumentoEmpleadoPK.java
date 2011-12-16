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
public class DocumentoEmpleadoPK implements Serializable
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
    @Column(name = "ID_TIPO_DOCUMENTO", nullable = false)
    private long idTipoDocumento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NUM_DOCUMENTO", nullable = false, length = 200)
    private String numDocumento;

    public DocumentoEmpleadoPK()
    {
    }

    public DocumentoEmpleadoPK(long idCompania, long idSucursal, long idEmpleado, long idTipoDocumento, String numDocumento)
    {
        this.idCompania = idCompania;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
        this.idTipoDocumento = idTipoDocumento;
        this.numDocumento = numDocumento;
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

    public long getIdTipoDocumento()
    {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(long idTipoDocumento)
    {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNumDocumento()
    {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento)
    {
        this.numDocumento = numDocumento;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idSucursal;
        hash += (int) idEmpleado;
        hash += (int) idTipoDocumento;
        hash += (numDocumento != null ? numDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoEmpleadoPK))
            {
            return false;
            }
        DocumentoEmpleadoPK other = (DocumentoEmpleadoPK) object;
        if (this.idCompania != other.idCompania) return false;
        if (this.idSucursal != other.idSucursal) return false;
        if (this.idEmpleado != other.idEmpleado) return false;
        if (this.idTipoDocumento != other.idTipoDocumento) return false;
        if ((this.numDocumento == null && other.numDocumento != null) || (this.numDocumento != null && !this.numDocumento.equals(other.numDocumento))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DocumentoEmpleadoPK[ idCompania=" + idCompania + ", idSucursal=" + idSucursal + ", idEmpleado=" + idEmpleado + ", idTipoDocumento=" + idTipoDocumento + ", numDocumento=" + numDocumento + " ]";
    }
    
}
