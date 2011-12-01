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
    @Column(name = "id_tipo_documento", nullable = false)
    private int idTipoDocumento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "num_documento", nullable = false, length = 100)
    private String numDocumento;

    public DocumentoEmpleadoPK()
    {
    }

    public DocumentoEmpleadoPK(int idCompania, int idSucursal, int idEmpleado, int idTipoDocumento, String numDocumento)
    {
        this.idCompania = idCompania;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
        this.idTipoDocumento = idTipoDocumento;
        this.numDocumento = numDocumento;
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

    public int getIdTipoDocumento()
    {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento)
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
        if (this.idTipoDocumento != other.idTipoDocumento)
            {
            return false;
            }
        if ((this.numDocumento == null && other.numDocumento != null) || (this.numDocumento != null && !this.numDocumento.equals(other.numDocumento)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DocumentoEmpleadoPK[ idCompania=" + idCompania + ", idSucursal=" + idSucursal + ", idEmpleado=" + idEmpleado + ", idTipoDocumento=" + idTipoDocumento + ", numDocumento=" + numDocumento + " ]";
    }
    
}
