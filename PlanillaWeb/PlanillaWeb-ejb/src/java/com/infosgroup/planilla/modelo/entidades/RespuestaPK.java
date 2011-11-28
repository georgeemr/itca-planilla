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
    @Column(name = "cod_cia", nullable = false)
    private int codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_respuesta", nullable = false)
    private int codTipoRespuesta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "grupo_respuesta", nullable = false)
    private int grupoRespuesta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_respuesta", nullable = false)
    private int codRespuesta;

    public RespuestaPK()
    {
    }

    public RespuestaPK(int codCia, int codTipoRespuesta, int grupoRespuesta, int codRespuesta)
    {
        this.codCia = codCia;
        this.codTipoRespuesta = codTipoRespuesta;
        this.grupoRespuesta = grupoRespuesta;
        this.codRespuesta = codRespuesta;
    }

    public int getCodCia()
    {
        return codCia;
    }

    public void setCodCia(int codCia)
    {
        this.codCia = codCia;
    }

    public int getCodTipoRespuesta()
    {
        return codTipoRespuesta;
    }

    public void setCodTipoRespuesta(int codTipoRespuesta)
    {
        this.codTipoRespuesta = codTipoRespuesta;
    }

    public int getGrupoRespuesta()
    {
        return grupoRespuesta;
    }

    public void setGrupoRespuesta(int grupoRespuesta)
    {
        this.grupoRespuesta = grupoRespuesta;
    }

    public int getCodRespuesta()
    {
        return codRespuesta;
    }

    public void setCodRespuesta(int codRespuesta)
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
