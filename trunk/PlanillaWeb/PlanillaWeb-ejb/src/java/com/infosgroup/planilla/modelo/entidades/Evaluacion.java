/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EVALUACION")
@NamedQueries(
    {
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByCodCia", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "Evaluacion.findByPeriodo", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.periodo = :periodo"),
    @NamedQuery(name = "Evaluacion.findByCodCampania", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.codCampania = :codCampania"),
    @NamedQuery(name = "Evaluacion.findByTipoEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByPlantilla", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.plantilla = :plantilla"),
    @NamedQuery(name = "Evaluacion.findByEmpleado", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.empleado = :empleado"),
    @NamedQuery(name = "Evaluacion.findByFecha", query = "SELECT e FROM Evaluacion e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Evaluacion.findByFinalizada", query = "SELECT e FROM Evaluacion e WHERE e.finalizada = :finalizada")
    })
public class Evaluacion implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EvaluacionPK evaluacionPK;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FINALIZADA", nullable = false)
    private long finalizada;

    @ManyToMany(mappedBy = "evaluacionList")
    private List<Empleado> empleadoList;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_EVALUACION", referencedColumnName = "COD_TIPO_EVALUACION", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PLANTILLA", referencedColumnName = "COD_PLANTILLA", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Plantilla plantilla1;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "EMPLEADO", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Empleado empleado1;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAMPANIA", referencedColumnName = "COD_CAMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Campania campania;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion")
    private List<DetEvaluacion> detEvaluacionList;

    public Evaluacion()
    {
    }

    public Evaluacion(EvaluacionPK evaluacionPK)
    {
        this.evaluacionPK = evaluacionPK;
    }

    public Evaluacion(EvaluacionPK evaluacionPK, Date fecha, long finalizada)
    {
        this.evaluacionPK = evaluacionPK;
        this.fecha = fecha;
        this.finalizada = finalizada;
    }

    public Evaluacion(long codCia, long periodo, long codCampania, long tipoEvaluacion, long plantilla, long empleado)
    {
        this.evaluacionPK = new EvaluacionPK(codCia, periodo, codCampania, tipoEvaluacion, plantilla, empleado);
    }

    public EvaluacionPK getEvaluacionPK()
    {
        return evaluacionPK;
    }

    public void setEvaluacionPK(EvaluacionPK evaluacionPK)
    {
        this.evaluacionPK = evaluacionPK;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public long getFinalizada()
    {
        return finalizada;
    }

    public void setFinalizada(long finalizada)
    {
        this.finalizada = finalizada;
    }

    public List<Empleado> getEmpleadoList()
    {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList)
    {
        this.empleadoList = empleadoList;
    }

    public Plantilla getPlantilla1()
    {
        return plantilla1;
    }

    public void setPlantilla1(Plantilla plantilla1)
    {
        this.plantilla1 = plantilla1;
    }

    public Empleado getEmpleado1()
    {
        return empleado1;
    }

    public void setEmpleado1(Empleado empleado1)
    {
        this.empleado1 = empleado1;
    }

    public Campania getCampania()
    {
        return campania;
    }

    public void setCampania(Campania campania)
    {
        this.campania = campania;
    }

    public List<DetEvaluacion> getDetEvaluacionList()
    {
        return detEvaluacionList;
    }

    public void setDetEvaluacionList(List<DetEvaluacion> detEvaluacionList)
    {
        this.detEvaluacionList = detEvaluacionList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (evaluacionPK != null ? evaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion))
            {
            return false;
            }
        Evaluacion other = (Evaluacion) object;
        if ((this.evaluacionPK == null && other.evaluacionPK != null) || (this.evaluacionPK != null && !this.evaluacionPK.equals(other.evaluacionPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Evaluacion[ evaluacionPK=" + evaluacionPK + " ]";
    }
    
}
