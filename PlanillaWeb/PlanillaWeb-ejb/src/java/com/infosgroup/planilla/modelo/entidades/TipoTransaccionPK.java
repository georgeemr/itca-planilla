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
public class TipoTransaccionPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_TRANSACCION", nullable = false)
    private long idTipoTransaccion;

    public TipoTransaccionPK()
    {
    }

    public TipoTransaccionPK(long idCompania, long idTipoTransaccion)
    {
        this.idCompania = idCompania;
        this.idTipoTransaccion = idTipoTransaccion;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idTipoTransaccion;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransaccionPK))
            {
            return false;
            }
        TipoTransaccionPK other = (TipoTransaccionPK) object;
        if (this.idCompania != other.idCompania) return false;
        if (this.idTipoTransaccion != other.idTipoTransaccion) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.TipoTransaccionPK[ idCompania=" + idCompania + ", idTipoTransaccion=" + idTipoTransaccion + " ]";
    }
    
}
