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
public class PuestoEmpleadoPK implements Serializable
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
    @Column(name = "ID_TIPO_PUESTO", nullable = false)
    private long idTipoPuesto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PUESTO", nullable = false)
    private long idPuesto;

    public PuestoEmpleadoPK()
    {
    }

    public PuestoEmpleadoPK(long idCompania, long idSucursal, long idEmpleado, long idTipoPuesto, long idPuesto)
    {
        this.idCompania = idCompania;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
        this.idTipoPuesto = idTipoPuesto;
        this.idPuesto = idPuesto;
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

    public long getIdTipoPuesto()
    {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(long idTipoPuesto)
    {
        this.idTipoPuesto = idTipoPuesto;
    }

    public long getIdPuesto()
    {
        return idPuesto;
    }

    public void setIdPuesto(long idPuesto)
    {
        this.idPuesto = idPuesto;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idSucursal;
        hash += (int) idEmpleado;
        hash += (int) idTipoPuesto;
        hash += (int) idPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuestoEmpleadoPK))
            {
            return false;
            }
        PuestoEmpleadoPK other = (PuestoEmpleadoPK) object;
        if (this.idCompania != other.idCompania) return false;
        if (this.idSucursal != other.idSucursal) return false;
        if (this.idEmpleado != other.idEmpleado) return false;
        if (this.idTipoPuesto != other.idTipoPuesto) return false;
        if (this.idPuesto != other.idPuesto) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.PuestoEmpleadoPK[ idCompania=" + idCompania + ", idSucursal=" + idSucursal + ", idEmpleado=" + idEmpleado + ", idTipoPuesto=" + idTipoPuesto + ", idPuesto=" + idPuesto + " ]";
    }
    
}
