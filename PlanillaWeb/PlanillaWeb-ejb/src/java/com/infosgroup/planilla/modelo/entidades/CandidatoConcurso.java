/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CANDIDATO_CONCURSO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "CandidatoConcurso.findAll", query = "SELECT c FROM CandidatoConcurso c"),
    @NamedQuery(name = "CandidatoConcurso.findByCodCia", query = "SELECT c FROM CandidatoConcurso c WHERE c.candidatoConcursoPK.codCia = :codCia"),
    @NamedQuery(name = "CandidatoConcurso.findByCandidato", query = "SELECT c FROM CandidatoConcurso c WHERE c.candidatoConcursoPK.candidato = :candidato"),
    @NamedQuery(name = "CandidatoConcurso.findByEstado", query = "SELECT c FROM CandidatoConcurso c WHERE c.estado = :estado"),
    @NamedQuery(name = "CandidatoConcurso.findByConcurso", query = "SELECT c FROM CandidatoConcurso c WHERE c.candidatoConcursoPK.concurso = :concurso"),
    @NamedQuery(name = "CandidatoConcurso.findByNotaEvaluacion", query = "SELECT c FROM CandidatoConcurso c WHERE c.notaEvaluacion = :notaEvaluacion"),
    @NamedQuery(name = "CandidatoConcurso.findByObservacion", query = "SELECT c FROM CandidatoConcurso c WHERE c.observacion = :observacion")
    })
public class CandidatoConcurso implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CandidatoConcursoPK candidatoConcursoPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ESTADO", nullable = false, length = 100)
    private String estado;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTA_EVALUACION", nullable = false, precision = 5, scale = 2)
    private BigDecimal notaEvaluacion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "OBSERVACION", nullable = false, length = 200)
    private String observacion;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CONCURSO", referencedColumnName = "COD_CONCURSO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Concurso concurso1;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Candidato candidato1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidatoConcurso", fetch = FetchType.EAGER)
    private List<EvaluacionCandidato> evaluacionCandidatoList;

    public CandidatoConcurso()
    {
    }

    public CandidatoConcurso(CandidatoConcursoPK candidatoConcursoPK)
    {
        this.candidatoConcursoPK = candidatoConcursoPK;
    }

    public CandidatoConcurso(CandidatoConcursoPK candidatoConcursoPK, String estado, BigDecimal notaEvaluacion, String observacion)
    {
        this.candidatoConcursoPK = candidatoConcursoPK;
        this.estado = estado;
        this.notaEvaluacion = notaEvaluacion;
        this.observacion = observacion;
    }

    public CandidatoConcurso(long codCia, long candidato, long concurso)
    {
        this.candidatoConcursoPK = new CandidatoConcursoPK(codCia, candidato, concurso);
    }

    public CandidatoConcursoPK getCandidatoConcursoPK()
    {
        return candidatoConcursoPK;
    }

    public void setCandidatoConcursoPK(CandidatoConcursoPK candidatoConcursoPK)
    {
        this.candidatoConcursoPK = candidatoConcursoPK;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public BigDecimal getNotaEvaluacion()
    {
        return notaEvaluacion;
    }

    public void setNotaEvaluacion(BigDecimal notaEvaluacion)
    {
        this.notaEvaluacion = notaEvaluacion;
    }

    public String getObservacion()
    {
        return observacion;
    }

    public void setObservacion(String observacion)
    {
        this.observacion = observacion;
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

    @XmlTransient
    public List<EvaluacionCandidato> getEvaluacionCandidatoList()
    {
        return evaluacionCandidatoList;
    }

    public void setEvaluacionCandidatoList(List<EvaluacionCandidato> evaluacionCandidatoList)
    {
        this.evaluacionCandidatoList = evaluacionCandidatoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (candidatoConcursoPK != null ? candidatoConcursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidatoConcurso))
            {
            return false;
            }
        CandidatoConcurso other = (CandidatoConcurso) object;
        if ((this.candidatoConcursoPK == null && other.candidatoConcursoPK != null) || (this.candidatoConcursoPK != null && !this.candidatoConcursoPK.equals(other.candidatoConcursoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.CandidatoConcurso[ candidatoConcursoPK=" + candidatoConcursoPK + " ]";
    }
    
}
