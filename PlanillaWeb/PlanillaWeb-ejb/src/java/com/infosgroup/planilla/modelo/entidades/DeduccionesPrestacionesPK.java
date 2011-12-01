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
public class DeduccionesPrestacionesPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prestacion", nullable = false)
    private int idPrestacion;

    public DeduccionesPrestacionesPK()
    {
    }

    public DeduccionesPrestacionesPK(int idCompania, int idPrestacion)
    {
        this.idCompania = idCompania;
        this.idPrestacion = idPrestacion;
    }

    public int getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(int idCompania)
    {
        this.idCompania = idCompania;
    }

    public int getIdPrestacion()
    {
        return idPrestacion;
    }

    public void setIdPrestacion(int idPrestacion)
    {
        this.idPrestacion = idPrestacion;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idPrestacion;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeduccionesPrestacionesPK))
            {
            return false;
            }
        DeduccionesPrestacionesPK other = (DeduccionesPrestacionesPK) object;
        if (this.idCompania != other.idCompania)
            {
            return false;
            }
        if (this.idPrestacion != other.idPrestacion)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DeduccionesPrestacionesPK[ idCompania=" + idCompania + ", idPrestacion=" + idPrestacion + " ]";
    }
    
}
