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
public class EmpleadoPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP", nullable = false)
    private long codEmp;

    public EmpleadoPK()
    {
    }

    public EmpleadoPK(long codCia, long codEmp)
    {
        this.codCia = codCia;
        this.codEmp = codEmp;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getCodEmp()
    {
        return codEmp;
    }

    public void setCodEmp(long codEmp)
    {
        this.codEmp = codEmp;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoPK))
            {
            return false;
            }
        EmpleadoPK other = (EmpleadoPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if (this.codEmp != other.codEmp)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.EmpleadoPK[ codCia=" + codCia + ", codEmp=" + codEmp + " ]";
    }
    
}
