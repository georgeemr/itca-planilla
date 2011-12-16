/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EVALUACION_CANDIDATO")
@NamedQueries({
    @NamedQuery(name = "EvaluacionCandidato.findAll", query = "SELECT e FROM EvaluacionCandidato e"),
    @NamedQuery(name = "EvaluacionCandidato.findByCodCia", query = "SELECT e FROM EvaluacionCandidato e WHERE e.evaluacionCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "EvaluacionCandidato.findByPuesto", query = "SELECT e FROM EvaluacionCandidato e WHERE e.evaluacionCandidatoPK.puesto = :puesto"),
    @NamedQuery(name = "EvaluacionCandidato.findByPrueba", query = "SELECT e FROM EvaluacionCandidato e WHERE e.evaluacionCandidatoPK.prueba = :prueba"),
    @NamedQuery(name = "EvaluacionCandidato.findByCandidato", query = "SELECT e FROM EvaluacionCandidato e WHERE e.evaluacionCandidatoPK.candidato = :candidato"),
    @NamedQuery(name = "EvaluacionCandidato.findByConcurso", query = "SELECT e FROM EvaluacionCandidato e WHERE e.evaluacionCandidatoPK.concurso = :concurso"),
    @NamedQuery(name = "EvaluacionCandidato.findByNota", query = "SELECT e FROM EvaluacionCandidato e WHERE e.nota = :nota"),
    @NamedQuery(name = "EvaluacionCandidato.findByObservacion", query = "SELECT e FROM EvaluacionCandidato e WHERE e.observacion = :observacion"),
    @NamedQuery(name = "EvaluacionCandidato.findByFecha", query = "SELECT e FROM EvaluacionCandidato e WHERE e.fecha = :fecha")})
public class EvaluacionCandidato implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluacionCandidatoPK evaluacionCandidatoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "NOTA"/*, nullable = false*/, precision = 5, scale = 2)
    private BigDecimal nota;
    @Size(max = 200)
    @Column(name = "OBSERVACION", length = 200)
    private String observacion;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PUESTO", referencedColumnName = "PUESTO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PRUEBA", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch= FetchType.EAGER)
    private PruebaXPuesto pruebaXPuesto;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CANDIDATO", referencedColumnName = "CANDIDATO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CONCURSO", referencedColumnName = "CONCURSO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CandidatoConcurso candidatoConcurso;

    public EvaluacionCandidato() {
    }

    public EvaluacionCandidato(EvaluacionCandidatoPK evaluacionCandidatoPK) {
        this.evaluacionCandidatoPK = evaluacionCandidatoPK;
    }

    public EvaluacionCandidato(EvaluacionCandidatoPK evaluacionCandidatoPK, BigDecimal nota, Date fecha) {
        this.evaluacionCandidatoPK = evaluacionCandidatoPK;
        this.nota = nota;
        this.fecha = fecha;
    }

    public EvaluacionCandidato(long codCia, long puesto, long prueba, long candidato, long concurso) {
        this.evaluacionCandidatoPK = new EvaluacionCandidatoPK(codCia, puesto, prueba, candidato, concurso);
    }

    public EvaluacionCandidatoPK getEvaluacionCandidatoPK() {
        return evaluacionCandidatoPK;
    }

    public void setEvaluacionCandidatoPK(EvaluacionCandidatoPK evaluacionCandidatoPK) {
        this.evaluacionCandidatoPK = evaluacionCandidatoPK;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public PruebaXPuesto getPruebaXPuesto() {
        return pruebaXPuesto;
    }

    public void setPruebaXPuesto(PruebaXPuesto pruebaXPuesto) {
        this.pruebaXPuesto = pruebaXPuesto;
    }

    public CandidatoConcurso getCandidatoConcurso() {
        return candidatoConcurso;
    }

    public void setCandidatoConcurso(CandidatoConcurso candidatoConcurso) {
        this.candidatoConcurso = candidatoConcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacionCandidatoPK != null ? evaluacionCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionCandidato)) {
            return false;
        }
        EvaluacionCandidato other = (EvaluacionCandidato) object;
        if ((this.evaluacionCandidatoPK == null && other.evaluacionCandidatoPK != null) || (this.evaluacionCandidatoPK != null && !this.evaluacionCandidatoPK.equals(other.evaluacionCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EvaluacionCandidato[ evaluacionCandidatoPK=" + evaluacionCandidatoPK + " ]";
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
