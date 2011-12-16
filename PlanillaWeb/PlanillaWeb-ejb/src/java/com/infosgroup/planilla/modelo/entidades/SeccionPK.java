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
public class SeccionPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DEPTO", nullable = false)
    private long codDepto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SECCION", nullable = false)
    private long codSeccion;

    public SeccionPK()
    {
    }

    public SeccionPK(long codCia, long codDepto, long codSeccion)
    {
        this.codCia = codCia;
        this.codDepto = codDepto;
        this.codSeccion = codSeccion;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getCodDepto()
    {
        return codDepto;
    }

    public void setCodDepto(long codDepto)
    {
        this.codDepto = codDepto;
    }

    public long getCodSeccion()
    {
        return codSeccion;
    }

    public void setCodSeccion(long codSeccion)
    {
        this.codSeccion = codSeccion;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codDepto;
        hash += (int) codSeccion;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeccionPK))
            {
            return false;
            }
        SeccionPK other = (SeccionPK) object;
        if (this.codCia != other.codCia) return false;
        if (this.codDepto != other.codDepto) return false;
        if (this.codSeccion != other.codSeccion) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.SeccionPK[ codCia=" + codCia + ", codDepto=" + codDepto + ", codSeccion=" + codSeccion + " ]";
    }
    
}
