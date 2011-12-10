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
public class DepartamentoPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private long idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DEPARTAMENTO", nullable = false)
    private long idDepartamento;

    public DepartamentoPK()
    {
    }

    public DepartamentoPK(long idCompania, long idDepartamento)
    {
        this.idCompania = idCompania;
        this.idDepartamento = idDepartamento;
    }

    public long getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(long idCompania)
    {
        this.idCompania = idCompania;
    }

    public long getIdDepartamento()
    {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento)
    {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentoPK))
            {
            return false;
            }
        DepartamentoPK other = (DepartamentoPK) object;
        if (this.idCompania != other.idCompania)
            {
            return false;
            }
        if (this.idDepartamento != other.idDepartamento)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DepartamentoPK[ idCompania=" + idCompania + ", idDepartamento=" + idDepartamento + " ]";
    }
    
}
