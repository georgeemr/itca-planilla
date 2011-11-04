/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "concurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concurso.findAll", query = "SELECT c FROM Concurso c"),
    @NamedQuery(name = "Concurso.findByCodCia", query = "SELECT c FROM Concurso c WHERE c.concursoPK.codCia = :codCia"),
    @NamedQuery(name = "Concurso.findByCodConcurso", query = "SELECT c FROM Concurso c WHERE c.concursoPK.codConcurso = :codConcurso"),
    @NamedQuery(name = "Concurso.findByNombre", query = "SELECT c FROM Concurso c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Concurso.findByFechaInicial", query = "SELECT c FROM Concurso c WHERE c.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "Concurso.findByFechaFinal", query = "SELECT c FROM Concurso c WHERE c.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "Concurso.findByFechaInicialFinal", query = "SELECT c FROM Concurso c WHERE c.fechaInicial between :fechaInicial and :fechaFinal and c.estadoConcurso.estadoConcursoPK.codigo = 'A'"),
    @NamedQuery(name = "Concurso.findByNumeroPlazas", query = "SELECT c FROM Concurso c WHERE c.numeroPlazas = :numeroPlazas")})
public class Concurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConcursoPK concursoPK;
    @Size(max = 2147483647)
    @Column(name = "nombre", length = 2147483647)
    private String nombre;
    @Column(name = "fecha_inicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Column(name = "numero_plazas")
    private Integer numeroPlazas;
    @ManyToMany(mappedBy = "concursoList")
    private List<Candidato> candidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "concurso1")
    private List<ResultadoEvaluacionCandidato> resultadoEvaluacionCandidatoList;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "puesto", referencedColumnName = "cod_puesto")})
    @ManyToOne(optional = false)
    private Puesto puesto;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "estado", referencedColumnName = "codigo", nullable = false)})
    @ManyToOne(optional = false)
    private EstadoConcurso estadoConcurso;

    public Concurso() {
    }

    public Concurso(ConcursoPK concursoPK) {
        this.concursoPK = concursoPK;
    }

    public Concurso(int codCia, String codConcurso) {
        this.concursoPK = new ConcursoPK(codCia, codConcurso);
    }

    public ConcursoPK getConcursoPK() {
        return concursoPK;
    }

    public void setConcursoPK(ConcursoPK concursoPK) {
        this.concursoPK = concursoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(Integer numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    @XmlTransient
    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    @XmlTransient
    public List<ResultadoEvaluacionCandidato> getResultadoEvaluacionCandidatoList() {
        return resultadoEvaluacionCandidatoList;
    }

    public void setResultadoEvaluacionCandidatoList(List<ResultadoEvaluacionCandidato> resultadoEvaluacionCandidatoList) {
        this.resultadoEvaluacionCandidatoList = resultadoEvaluacionCandidatoList;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public EstadoConcurso getEstadoConcurso() {
        return estadoConcurso;
    }

    public void setEstadoConcurso(EstadoConcurso estadoConcurso) {
        this.estadoConcurso = estadoConcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (concursoPK != null ? concursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concurso)) {
            return false;
        }
        Concurso other = (Concurso) object;
        if ((this.concursoPK == null && other.concursoPK != null) || (this.concursoPK != null && !this.concursoPK.equals(other.concursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Concurso[ concursoPK=" + concursoPK + " ]";
    }
    
}
