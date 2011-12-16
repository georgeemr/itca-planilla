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
public class GerenciaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_GERENCIA", nullable = false)
    private long codGerencia;

    public GerenciaPK()
    {
    }

    public GerenciaPK(long codCia, long codGerencia)
    {
        this.codCia = codCia;
        this.codGerencia = codGerencia;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getCodGerencia()
    {
        return codGerencia;
    }

    public void setCodGerencia(long codGerencia)
    {
        this.codGerencia = codGerencia;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codGerencia;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GerenciaPK))
            {
            return false;
            }
        GerenciaPK other = (GerenciaPK) object;
        if (this.codCia != other.codCia) return false;
        if (this.codGerencia != other.codGerencia) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.GerenciaPK[ codCia=" + codCia + ", codGerencia=" + codGerencia + " ]";
    }
    
}
