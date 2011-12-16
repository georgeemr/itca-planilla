/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_EVALUACION")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "DetEvaluacion.findAll", query = "SELECT d FROM DetEvaluacion d"),
    @NamedQuery(name = "DetEvaluacion.findByCodCia", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "DetEvaluacion.findByPeriodo", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.periodo = :periodo"),
    @NamedQuery(name = "DetEvaluacion.findByCodCampania", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCampania = :codCampania"),
    @NamedQuery(name = "DetEvaluacion.findByTipoEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "DetEvaluacion.findByEmpleado", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.empleado = :empleado"),
    @NamedQuery(name = "DetEvaluacion.findByCodDetEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codDetEvaluacion = :codDetEvaluacion")
    })
public class DetEvaluacion implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected DetEvaluacionPK detEvaluacionPK;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_RESPUESTA", referencedColumnName = "COD_TIPO_RESPUESTA", nullable = false),
        @JoinColumn(name = "GRUPO_RESPUESTA", referencedColumnName = "GRUPO_RESPUESTA", nullable = false),
        @JoinColumn(name = "COD_RESPUESTA", referencedColumnName = "COD_RESPUESTA", nullable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Respuesta respuesta;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_FACTOR", referencedColumnName = "COD_FACTOR", nullable = false),
        @JoinColumn(name = "COD_PREGUNTA", referencedColumnName = "COD_PREGUNTA", nullable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pregunta pregunta;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAMPANIA", referencedColumnName = "COD_CAMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_EVALUACION", referencedColumnName = "TIPO_EVALUACION", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PLANTILLA", referencedColumnName = "PLANTILLA", nullable = false),
        @JoinColumn(name = "EMPLEADO", referencedColumnName = "EMPLEADO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Evaluacion evaluacion;

    public DetEvaluacion()
    {
    }

    public DetEvaluacion(DetEvaluacionPK detEvaluacionPK)
    {
        this.detEvaluacionPK = detEvaluacionPK;
    }

    public DetEvaluacion(long codCia, long periodo, long codCampania, long tipoEvaluacion, long empleado, long codDetEvaluacion)
    {
        this.detEvaluacionPK = new DetEvaluacionPK(codCia, periodo, codCampania, tipoEvaluacion, empleado, codDetEvaluacion);
    }

    public DetEvaluacionPK getDetEvaluacionPK()
    {
        return detEvaluacionPK;
    }

    public void setDetEvaluacionPK(DetEvaluacionPK detEvaluacionPK)
    {
        this.detEvaluacionPK = detEvaluacionPK;
    }

    public Respuesta getRespuesta()
    {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta)
    {
        this.respuesta = respuesta;
    }

    public Pregunta getPregunta()
    {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta)
    {
        this.pregunta = pregunta;
    }

    public Evaluacion getEvaluacion()
    {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion)
    {
        this.evaluacion = evaluacion;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (detEvaluacionPK != null ? detEvaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetEvaluacion))
            {
            return false;
            }
        DetEvaluacion other = (DetEvaluacion) object;
        if ((this.detEvaluacionPK == null && other.detEvaluacionPK != null) || (this.detEvaluacionPK != null && !this.detEvaluacionPK.equals(other.detEvaluacionPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DetEvaluacion[ detEvaluacionPK=" + detEvaluacionPK + " ]";
    }
    
}
