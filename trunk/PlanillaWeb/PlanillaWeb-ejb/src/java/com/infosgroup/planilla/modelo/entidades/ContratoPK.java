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
public class ContratoPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
    private long codigo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CANDIDATO", nullable = false)
    private long candidato;

    public ContratoPK()
    {
    }

    public ContratoPK(long codCia, long codigo, long candidato)
    {
        this.codCia = codCia;
        this.codigo = codigo;
        this.candidato = candidato;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(long codigo)
    {
        this.codigo = codigo;
    }

    public long getCandidato()
    {
        return candidato;
    }

    public void setCandidato(long candidato)
    {
        this.candidato = candidato;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codigo;
        hash += (int) candidato;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoPK))
            {
            return false;
            }
        ContratoPK other = (ContratoPK) object;
        if (this.codCia != other.codCia) return false;
        if (this.codigo != other.codigo) return false;
        if (this.candidato != other.candidato) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.ContratoPK[ codCia=" + codCia + ", codigo=" + codigo + ", candidato=" + candidato + " ]";
    }
    
}
