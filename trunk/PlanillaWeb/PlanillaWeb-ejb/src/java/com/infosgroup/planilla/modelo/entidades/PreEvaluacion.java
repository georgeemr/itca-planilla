/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**

 @author root
 */
@Entity
@Table(name = "PRE_EVALUACION", catalog = "", schema = "PLANILLA", uniqueConstraints =
    {
    @UniqueConstraint(columnNames =
        {
        "COD_CIA", "COD_CAMPANIA"
        })
    })
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "PreEvaluacion.findAll", query = "SELECT p FROM PreEvaluacion p"),
    @NamedQuery(name = "PreEvaluacion.findByCodCia", query = "SELECT p FROM PreEvaluacion p WHERE p.preEvaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "PreEvaluacion.findByPeriodo", query = "SELECT p FROM PreEvaluacion p WHERE p.preEvaluacionPK.periodo = :periodo"),
    @NamedQuery(name = "PreEvaluacion.findByCodCampania", query = "SELECT p FROM PreEvaluacion p WHERE p.preEvaluacionPK.codCampania = :codCampania"),
    @NamedQuery(name = "PreEvaluacion.findByTipoEvaluacion", query = "SELECT p FROM PreEvaluacion p WHERE p.preEvaluacionPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "PreEvaluacion.findByPlantilla", query = "SELECT p FROM PreEvaluacion p WHERE p.preEvaluacionPK.plantilla = :plantilla")
    })
public class PreEvaluacion implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreEvaluacionPK preEvaluacionPK;
    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_EVALUACION", referencedColumnName = "COD_TIPO_EVALUACION", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private TipoEvaluacion tipoEvaluacion1;
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
        @JoinColumn(name = "COD_CAMPANIA", referencedColumnName = "COD_CAMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Campania campania;

    public PreEvaluacion()
    {
    }

    public PreEvaluacion(PreEvaluacionPK preEvaluacionPK)
    {
        this.preEvaluacionPK = preEvaluacionPK;
    }

    public PreEvaluacion(short codCia, short periodo, short codCampania, short tipoEvaluacion, long plantilla)
    {
        this.preEvaluacionPK = new PreEvaluacionPK(codCia, periodo, codCampania, tipoEvaluacion, plantilla);
    }

    public PreEvaluacionPK getPreEvaluacionPK()
    {
        return preEvaluacionPK;
    }

    public void setPreEvaluacionPK(PreEvaluacionPK preEvaluacionPK)
    {
        this.preEvaluacionPK = preEvaluacionPK;
    }

    public TipoEvaluacion getTipoEvaluacion1()
    {
        return tipoEvaluacion1;
    }

    public void setTipoEvaluacion1(TipoEvaluacion tipoEvaluacion1)
    {
        this.tipoEvaluacion1 = tipoEvaluacion1;
    }

    public Plantilla getPlantilla1()
    {
        return plantilla1;
    }

    public void setPlantilla1(Plantilla plantilla1)
    {
        this.plantilla1 = plantilla1;
    }

    public Campania getCampania()
    {
        return campania;
    }

    public void setCampania(Campania campania)
    {
        this.campania = campania;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (preEvaluacionPK != null ? preEvaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreEvaluacion))
            {
            return false;
            }
        PreEvaluacion other = (PreEvaluacion) object;
        if ((this.preEvaluacionPK == null && other.preEvaluacionPK != null) || (this.preEvaluacionPK != null && !this.preEvaluacionPK.equals(other.preEvaluacionPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.PreEvaluacion[ preEvaluacionPK=" + preEvaluacionPK + " ]";
    }
    
}
