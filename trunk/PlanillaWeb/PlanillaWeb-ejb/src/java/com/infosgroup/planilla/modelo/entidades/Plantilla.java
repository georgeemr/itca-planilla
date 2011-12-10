/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PLANTILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Plantilla.findAll", query = "SELECT p FROM Plantilla p"),
    @NamedQuery(name = "Plantilla.findByCodCia", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.codCia = :codCia"),
    @NamedQuery(name = "Plantilla.findByCodTipoEvaluacion", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.codTipoEvaluacion = :codTipoEvaluacion"),
    @NamedQuery(name = "Plantilla.findByCodPlantilla", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.codPlantilla = :codPlantilla"),
    @NamedQuery(name = "Plantilla.findByNombre", query = "SELECT p FROM Plantilla p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Plantilla.findByIncluyeObjetivos", query = "SELECT p FROM Plantilla p WHERE p.incluyeObjetivos = :incluyeObjetivos"),
    @NamedQuery(name = "Plantilla.findByIncluyeCompetencias", query = "SELECT p FROM Plantilla p WHERE p.incluyeCompetencias = :incluyeCompetencias")
    })
public class Plantilla implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PlantillaPK plantillaPK;

    @Size(max = 200)
    @Column(name = "NOMBRE", length = 200)
    private String nombre;

    @Size(max = 200)
    @Column(name = "INCLUYE_OBJETIVOS", length = 200)
    private String incluyeObjetivos;

    @Size(max = 200)
    @Column(name = "INCLUYE_COMPETENCIAS", length = 200)
    private String incluyeCompetencias;

    @JoinTable(name = "DET_PLANTILLA", joinColumns =
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_TIPO_EVALUACION", referencedColumnName = "COD_TIPO_EVALUACION", nullable = false),
        @JoinColumn(name = "COD_PLANTILLA", referencedColumnName = "COD_PLANTILLA", nullable = false)
        }, inverseJoinColumns =
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "FACTOR", referencedColumnName = "COD_FACTOR", nullable = false),
        @JoinColumn(name = "PREGUNTA", referencedColumnName = "COD_PREGUNTA", nullable = false)
        })
    @ManyToMany
    private List<Pregunta> preguntaList;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_EVALUACION", referencedColumnName = "COD_TIPO_EVALUACION", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private TipoEvaluacion tipoEvaluacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantilla1")
    private List<Evaluacion> evaluacionList;

    public Plantilla()
    {
    }

    public Plantilla(PlantillaPK plantillaPK)
    {
        this.plantillaPK = plantillaPK;
    }

    public Plantilla(long codCia, long codTipoEvaluacion, long codPlantilla)
    {
        this.plantillaPK = new PlantillaPK(codCia, codTipoEvaluacion, codPlantilla);
    }

    public PlantillaPK getPlantillaPK()
    {
        return plantillaPK;
    }

    public void setPlantillaPK(PlantillaPK plantillaPK)
    {
        this.plantillaPK = plantillaPK;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getIncluyeObjetivos()
    {
        return incluyeObjetivos;
    }

    public void setIncluyeObjetivos(String incluyeObjetivos)
    {
        this.incluyeObjetivos = incluyeObjetivos;
    }

    public String getIncluyeCompetencias()
    {
        return incluyeCompetencias;
    }

    public void setIncluyeCompetencias(String incluyeCompetencias)
    {
        this.incluyeCompetencias = incluyeCompetencias;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList()
    {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList)
    {
        this.preguntaList = preguntaList;
    }

    public TipoEvaluacion getTipoEvaluacion()
    {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion)
    {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList()
    {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList)
    {
        this.evaluacionList = evaluacionList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (plantillaPK != null ? plantillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantilla))
            {
            return false;
            }
        Plantilla other = (Plantilla) object;
        if ((this.plantillaPK == null && other.plantillaPK != null) || (this.plantillaPK != null && !this.plantillaPK.equals(other.plantillaPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Plantilla[ plantillaPK=" + plantillaPK + " ]";
    }
    
}
