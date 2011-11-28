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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByCodCia", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "Evaluacion.findByPeriodo", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.periodo = :periodo"),
    @NamedQuery(name = "Evaluacion.findByCodCampania", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.codCampania = :codCampania"),
    @NamedQuery(name = "Evaluacion.findByEmpleado", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.empleado = :empleado"),
    @NamedQuery(name = "Evaluacion.findByTipoEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.tipoEvaluacion = :tipoEvaluacion"),
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
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Basic(optional = false)
    @NotNull
    @Column(name = "finalizada", nullable = false)
    private int finalizada;

    @JoinColumns(
        {
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "tipo_evaluacion", referencedColumnName = "cod_tipo_evaluacion", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "plantilla", referencedColumnName = "cod_plantilla", nullable = false)
        })
    @ManyToOne(optional = false)
    private Plantilla plantilla;

    @JoinColumns(
        {
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "empleado", referencedColumnName = "cod_emp", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Empleado empleado1;

    @JoinColumns(
        {
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_campania", referencedColumnName = "cod_campania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "periodo", referencedColumnName = "periodo", nullable = false, insertable = false, updatable = false)
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

    public Evaluacion(EvaluacionPK evaluacionPK, Date fecha, int finalizada)
    {
        this.evaluacionPK = evaluacionPK;
        this.fecha = fecha;
        this.finalizada = finalizada;
    }

    public Evaluacion(int codCia, int periodo, int codCampania, int empleado, int tipoEvaluacion)
    {
        this.evaluacionPK = new EvaluacionPK(codCia, periodo, codCampania, empleado, tipoEvaluacion);
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

    public int getFinalizada()
    {
        return finalizada;
    }

    public void setFinalizada(int finalizada)
    {
        this.finalizada = finalizada;
    }

    public Plantilla getPlantilla()
    {
        return plantilla;
    }

    public void setPlantilla(Plantilla plantilla)
    {
        this.plantilla = plantilla;
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

    @XmlTransient
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
