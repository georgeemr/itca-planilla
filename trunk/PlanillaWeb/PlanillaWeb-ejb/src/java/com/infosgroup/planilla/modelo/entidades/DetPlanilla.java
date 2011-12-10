/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_PLANILLA")
@NamedQueries(
    {
    @NamedQuery(name = "DetPlanilla.findAll", query = "SELECT d FROM DetPlanilla d"),
    @NamedQuery(name = "DetPlanilla.findByIdCompania", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.idCompania = :idCompania"),
    @NamedQuery(name = "DetPlanilla.findByAnio", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.anio = :anio"),
    @NamedQuery(name = "DetPlanilla.findByMes", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.mes = :mes"),
    @NamedQuery(name = "DetPlanilla.findByNumPlanilla", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "DetPlanilla.findByIdEmpleado", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "DetPlanilla.findByIdPrestacion", query = "SELECT d FROM DetPlanilla d WHERE d.detPlanillaPK.idPrestacion = :idPrestacion"),
    @NamedQuery(name = "DetPlanilla.findByMonto", query = "SELECT d FROM DetPlanilla d WHERE d.monto = :monto")
    })
public class DetPlanilla implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected DetPlanillaPK detPlanillaPK;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO", precision = 11, scale = 3)
    private BigDecimal monto;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "MES", referencedColumnName = "MES", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NUM_PLANILLA", referencedColumnName = "NUM_PLANILLA", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Planilla planilla;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Empleado empleado;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_PRESTACION", referencedColumnName = "ID_PRESTACION", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private DeduccionesPrestaciones deduccionesPrestaciones;

    public DetPlanilla()
    {
    }

    public DetPlanilla(DetPlanillaPK detPlanillaPK)
    {
        this.detPlanillaPK = detPlanillaPK;
    }

    public DetPlanilla(long idCompania, long anio, long mes, long numPlanilla, long idEmpleado, long idPrestacion)
    {
        this.detPlanillaPK = new DetPlanillaPK(idCompania, anio, mes, numPlanilla, idEmpleado, idPrestacion);
    }

    public DetPlanillaPK getDetPlanillaPK()
    {
        return detPlanillaPK;
    }

    public void setDetPlanillaPK(DetPlanillaPK detPlanillaPK)
    {
        this.detPlanillaPK = detPlanillaPK;
    }

    public BigDecimal getMonto()
    {
        return monto;
    }

    public void setMonto(BigDecimal monto)
    {
        this.monto = monto;
    }

    public Planilla getPlanilla()
    {
        return planilla;
    }

    public void setPlanilla(Planilla planilla)
    {
        this.planilla = planilla;
    }

    public Empleado getEmpleado()
    {
        return empleado;
    }

    public void setEmpleado(Empleado empleado)
    {
        this.empleado = empleado;
    }

    public DeduccionesPrestaciones getDeduccionesPrestaciones()
    {
        return deduccionesPrestaciones;
    }

    public void setDeduccionesPrestaciones(DeduccionesPrestaciones deduccionesPrestaciones)
    {
        this.deduccionesPrestaciones = deduccionesPrestaciones;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (detPlanillaPK != null ? detPlanillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPlanilla))
            {
            return false;
            }
        DetPlanilla other = (DetPlanilla) object;
        if ((this.detPlanillaPK == null && other.detPlanillaPK != null) || (this.detPlanillaPK != null && !this.detPlanillaPK.equals(other.detPlanillaPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DetPlanilla[ detPlanillaPK=" + detPlanillaPK + " ]";
    }
    
}
