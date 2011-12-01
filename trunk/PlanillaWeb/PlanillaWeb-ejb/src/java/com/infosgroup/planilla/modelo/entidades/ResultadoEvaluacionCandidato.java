/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "resultado_evaluacion_candidato")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "ResultadoEvaluacionCandidato.findAll", query = "SELECT r FROM ResultadoEvaluacionCandidato r"),
    @NamedQuery(name = "ResultadoEvaluacionCandidato.findByCodCia", query = "SELECT r FROM ResultadoEvaluacionCandidato r WHERE r.resultadoEvaluacionCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "ResultadoEvaluacionCandidato.findByConcurso", query = "SELECT r FROM ResultadoEvaluacionCandidato r WHERE r.resultadoEvaluacionCandidatoPK.concurso = :concurso"),
    @NamedQuery(name = "ResultadoEvaluacionCandidato.findByCandidato", query = "SELECT r FROM ResultadoEvaluacionCandidato r WHERE r.resultadoEvaluacionCandidatoPK.candidato = :candidato"),
    @NamedQuery(name = "ResultadoEvaluacionCandidato.findByFechaEvaluacion", query = "SELECT r FROM ResultadoEvaluacionCandidato r WHERE r.fechaEvaluacion = :fechaEvaluacion"),
    @NamedQuery(name = "ResultadoEvaluacionCandidato.findByTipoEvaluacion", query = "SELECT r FROM ResultadoEvaluacionCandidato r WHERE r.resultadoEvaluacionCandidatoPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "ResultadoEvaluacionCandidato.findByNota", query = "SELECT r FROM ResultadoEvaluacionCandidato r WHERE r.nota = :nota"),
    @NamedQuery(name = "ResultadoEvaluacionCandidato.findByObservacion", query = "SELECT r FROM ResultadoEvaluacionCandidato r WHERE r.observacion = :observacion")
    })
public class ResultadoEvaluacionCandidato implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ResultadoEvaluacionCandidatoPK resultadoEvaluacionCandidatoPK;

    @Column(name = "fecha_evaluacion")
    @Temporal(TemporalType.DATE)
    private Date fechaEvaluacion;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota", precision = 17, scale = 17)
    private Double nota;

    @Size(max = 2147483647)
    @Column(name = "observacion", length = 2147483647)
    private String observacion;

    @JoinColumns(
        {
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "tipo_evaluacion", referencedColumnName = "cod_tipo_evaluacion", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private TipoEvaluacion tipoEvaluacion1;

    @JoinColumns(
        {
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "concurso", referencedColumnName = "cod_concurso", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Concurso concurso1;

    @JoinColumns(
        {
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "candidato", referencedColumnName = "cod_candidato", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Candidato candidato1;

    public ResultadoEvaluacionCandidato()
    {
    }

    public ResultadoEvaluacionCandidato(ResultadoEvaluacionCandidatoPK resultadoEvaluacionCandidatoPK)
    {
        this.resultadoEvaluacionCandidatoPK = resultadoEvaluacionCandidatoPK;
    }

    public ResultadoEvaluacionCandidato(int codCia, String concurso, int candidato, int tipoEvaluacion)
    {
        this.resultadoEvaluacionCandidatoPK = new ResultadoEvaluacionCandidatoPK(codCia, concurso, candidato, tipoEvaluacion);
    }

    public ResultadoEvaluacionCandidatoPK getResultadoEvaluacionCandidatoPK()
    {
        return resultadoEvaluacionCandidatoPK;
    }

    public void setResultadoEvaluacionCandidatoPK(ResultadoEvaluacionCandidatoPK resultadoEvaluacionCandidatoPK)
    {
        this.resultadoEvaluacionCandidatoPK = resultadoEvaluacionCandidatoPK;
    }

    public Date getFechaEvaluacion()
    {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion)
    {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Double getNota()
    {
        return nota;
    }

    public void setNota(Double nota)
    {
        this.nota = nota;
    }

    public String getObservacion()
    {
        return observacion;
    }

    public void setObservacion(String observacion)
    {
        this.observacion = observacion;
    }

    public TipoEvaluacion getTipoEvaluacion1()
    {
        return tipoEvaluacion1;
    }

    public void setTipoEvaluacion1(TipoEvaluacion tipoEvaluacion1)
    {
        this.tipoEvaluacion1 = tipoEvaluacion1;
    }

    public Concurso getConcurso1()
    {
        return concurso1;
    }

    public void setConcurso1(Concurso concurso1)
    {
        this.concurso1 = concurso1;
    }

    public Candidato getCandidato1()
    {
        return candidato1;
    }

    public void setCandidato1(Candidato candidato1)
    {
        this.candidato1 = candidato1;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (resultadoEvaluacionCandidatoPK != null ? resultadoEvaluacionCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoEvaluacionCandidato))
            {
            return false;
            }
        ResultadoEvaluacionCandidato other = (ResultadoEvaluacionCandidato) object;
        if ((this.resultadoEvaluacionCandidatoPK == null && other.resultadoEvaluacionCandidatoPK != null) || (this.resultadoEvaluacionCandidatoPK != null && !this.resultadoEvaluacionCandidatoPK.equals(other.resultadoEvaluacionCandidatoPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.ResultadoEvaluacionCandidato[ resultadoEvaluacionCandidatoPK=" + resultadoEvaluacionCandidatoPK + " ]";
    }
    
}
