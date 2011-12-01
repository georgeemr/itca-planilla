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
public class EstadoConcursoPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo", nullable = false, length = 2147483647)
    private String codigo;

    public EstadoConcursoPK()
    {
    }

    public EstadoConcursoPK(int codCia, String codigo)
    {
        this.codCia = codCia;
        this.codigo = codigo;
    }

    public int getCodCia()
    {
        return codCia;
    }

    public void setCodCia(int codCia)
    {
        this.codCia = codCia;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConcursoPK))
            {
            return false;
            }
        EstadoConcursoPK other = (EstadoConcursoPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.EstadoConcursoPK[ codCia=" + codCia + ", codigo=" + codigo + " ]";
    }
    
}
