/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PLANILLA")
@NamedQueries(
    {
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p"),
    @NamedQuery(name = "Planilla.findByIdCompania", query = "SELECT p FROM Planilla p WHERE p.planillaPK.idCompania = :idCompania"),
    @NamedQuery(name = "Planilla.findByAnio", query = "SELECT p FROM Planilla p WHERE p.planillaPK.anio = :anio"),
    @NamedQuery(name = "Planilla.findByMes", query = "SELECT p FROM Planilla p WHERE p.planillaPK.mes = :mes"),
    @NamedQuery(name = "Planilla.findByNumPlanilla", query = "SELECT p FROM Planilla p WHERE p.planillaPK.numPlanilla = :numPlanilla")
    })
public class Planilla implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PlanillaPK planillaPK;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planilla")
    private List<ResumenAsistencia> resumenAsistenciaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planilla")
    private List<DetPlanilla> detPlanillaList;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_TIPO_PLANILLA", referencedColumnName = "ID_TIPO_PLANILLA", nullable = false)
        })
    @ManyToOne(optional = false)
    private TipoPlanilla tipoPlanilla;

    @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public Planilla()
    {
    }

    public Planilla(PlanillaPK planillaPK)
    {
        this.planillaPK = planillaPK;
    }

    public Planilla(long idCompania, long anio, long mes, long numPlanilla)
    {
        this.planillaPK = new PlanillaPK(idCompania, anio, mes, numPlanilla);
    }

    public PlanillaPK getPlanillaPK()
    {
        return planillaPK;
    }

    public void setPlanillaPK(PlanillaPK planillaPK)
    {
        this.planillaPK = planillaPK;
    }

    public List<ResumenAsistencia> getResumenAsistenciaList()
    {
        return resumenAsistenciaList;
    }

    public void setResumenAsistenciaList(List<ResumenAsistencia> resumenAsistenciaList)
    {
        this.resumenAsistenciaList = resumenAsistenciaList;
    }

    public List<DetPlanilla> getDetPlanillaList()
    {
        return detPlanillaList;
    }

    public void setDetPlanillaList(List<DetPlanilla> detPlanillaList)
    {
        this.detPlanillaList = detPlanillaList;
    }

    public TipoPlanilla getTipoPlanilla()
    {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(TipoPlanilla tipoPlanilla)
    {
        this.tipoPlanilla = tipoPlanilla;
    }

    public Compania getCompania()
    {
        return compania;
    }

    public void setCompania(Compania compania)
    {
        this.compania = compania;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (planillaPK != null ? planillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla))
            {
            return false;
            }
        Planilla other = (Planilla) object;
        if ((this.planillaPK == null && other.planillaPK != null) || (this.planillaPK != null && !this.planillaPK.equals(other.planillaPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Planilla[ planillaPK=" + planillaPK + " ]";
    }
    
}
