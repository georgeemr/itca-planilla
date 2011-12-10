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
public class TransaccionPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_TRANSACCION", nullable = false)
    private long idTipoTransaccion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRANSACCION", nullable = false)
    private long idTransaccion;

    public TransaccionPK()
    {
    }

    public TransaccionPK(long idCompania, long idTipoTransaccion, long idTransaccion)
    {
        this.idCompania = idCompania;
        this.idTipoTransaccion = idTipoTransaccion;
        this.idTransaccion = idTransaccion;
    }

    public long getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(long idCompania)
    {
        this.idCompania = idCompania;
    }

    public long getIdTipoTransaccion()
    {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(long idTipoTransaccion)
    {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public long getIdTransaccion()
    {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion)
    {
        this.idTransaccion = idTransaccion;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idTipoTransaccion;
        hash += (int) idTransaccion;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionPK))
            {
            return false;
            }
        TransaccionPK other = (TransaccionPK) object;
        if (this.idCompania != other.idCompania)
            {
            return false;
            }
        if (this.idTipoTransaccion != other.idTipoTransaccion)
            {
            return false;
            }
        if (this.idTransaccion != other.idTransaccion)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.TransaccionPK[ idCompania=" + idCompania + ", idTipoTransaccion=" + idTipoTransaccion + ", idTransaccion=" + idTransaccion + " ]";
    }
    
}
