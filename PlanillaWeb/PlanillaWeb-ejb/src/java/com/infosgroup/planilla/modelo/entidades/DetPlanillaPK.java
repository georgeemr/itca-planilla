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
public class DetPlanillaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "anio", nullable = false)
    private int anio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "mes", nullable = false)
    private int mes;

    @Basic(optional = false)
    @NotNull
    @Column(name = "num_planilla", nullable = false)
    private int numPlanilla;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prestacion", nullable = false)
    private int idPrestacion;

    public DetPlanillaPK()
    {
    }

    public DetPlanillaPK(int idCompania, int anio, int mes, int numPlanilla, int idEmpleado, int idPrestacion)
    {
        this.idCompania = idCompania;
        this.anio = anio;
        this.mes = mes;
        this.numPlanilla = numPlanilla;
        this.idEmpleado = idEmpleado;
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

    public int getAnio()
    {
        return anio;
    }

    public void setAnio(int anio)
    {
        this.anio = anio;
    }

    public int getMes()
    {
        return mes;
    }

    public void setMes(int mes)
    {
        this.mes = mes;
    }

    public int getNumPlanilla()
    {
        return numPlanilla;
    }

    public void setNumPlanilla(int numPlanilla)
    {
        this.numPlanilla = numPlanilla;
    }

    public int getIdEmpleado()
    {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado)
    {
        this.idEmpleado = idEmpleado;
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
        hash += (int) anio;
        hash += (int) mes;
        hash += (int) numPlanilla;
        hash += (int) idEmpleado;
        hash += (int) idPrestacion;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPlanillaPK))
            {
            return false;
            }
        DetPlanillaPK other = (DetPlanillaPK) object;
        if (this.idCompania != other.idCompania)
            {
            return false;
            }
        if (this.anio != other.anio)
            {
            return false;
            }
        if (this.mes != other.mes)
            {
            return false;
            }
        if (this.numPlanilla != other.numPlanilla)
            {
            return false;
            }
        if (this.idEmpleado != other.idEmpleado)
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
        return "com.infosgroup.planilla.modelo.entidades.DetPlanillaPK[ idCompania=" + idCompania + ", anio=" + anio + ", mes=" + mes + ", numPlanilla=" + numPlanilla + ", idEmpleado=" + idEmpleado + ", idPrestacion=" + idPrestacion + " ]";
    }
    
}
