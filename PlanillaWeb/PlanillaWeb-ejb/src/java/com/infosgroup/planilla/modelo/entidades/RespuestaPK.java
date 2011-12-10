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
public class RespuestaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_RESPUESTA", nullable = false)
    private long codTipoRespuesta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "GRUPO_RESPUESTA", nullable = false)
    private long grupoRespuesta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_RESPUESTA", nullable = false)
    private long codRespuesta;

    public RespuestaPK()
    {
    }

    public RespuestaPK(long codCia, long codTipoRespuesta, long grupoRespuesta, long codRespuesta)
    {
        this.codCia = codCia;
        this.codTipoRespuesta = codTipoRespuesta;
        this.grupoRespuesta = grupoRespuesta;
        this.codRespuesta = codRespuesta;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getCodTipoRespuesta()
    {
        return codTipoRespuesta;
    }

    public void setCodTipoRespuesta(long codTipoRespuesta)
    {
        this.codTipoRespuesta = codTipoRespuesta;
    }

    public long getGrupoRespuesta()
    {
        return grupoRespuesta;
    }

    public void setGrupoRespuesta(long grupoRespuesta)
    {
        this.grupoRespuesta = grupoRespuesta;
    }

    public long getCodRespuesta()
    {
        return codRespuesta;
    }

    public void setCodRespuesta(long codRespuesta)
    {
        this.codRespuesta = codRespuesta;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoRespuesta;
        hash += (int) grupoRespuesta;
        hash += (int) codRespuesta;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaPK))
            {
            return false;
            }
        RespuestaPK other = (RespuestaPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if (this.codTipoRespuesta != other.codTipoRespuesta)
            {
            return false;
            }
        if (this.grupoRespuesta != other.grupoRespuesta)
            {
            return false;
            }
        if (this.codRespuesta != other.codRespuesta)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.RespuestaPK[ codCia=" + codCia + ", codTipoRespuesta=" + codTipoRespuesta + ", grupoRespuesta=" + grupoRespuesta + ", codRespuesta=" + codRespuesta + " ]";
    }
    
}
