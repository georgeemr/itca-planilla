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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "candidato")
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c"),
    @NamedQuery(name = "Candidato.findByCodCia", query = "SELECT c FROM Candidato c WHERE c.candidatoPK.codCia = :codCia"),
    @NamedQuery(name = "Candidato.findByCodCandidato", query = "SELECT c FROM Candidato c WHERE c.candidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "Candidato.findByNombre", query = "SELECT c FROM Candidato c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Candidato.findByApellido", query = "SELECT c FROM Candidato c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Candidato.findByFechaNacimiento", query = "SELECT c FROM Candidato c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Candidato.findByApCasada", query = "SELECT c FROM Candidato c WHERE c.apCasada = :apCasada"),
    @NamedQuery(name = "Candidato.findBySexo", query = "SELECT c FROM Candidato c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Candidato.findByObservacion", query = "SELECT c FROM Candidato c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "Candidato.findByStatus", query = "SELECT c FROM Candidato c WHERE c.status = :status")})
public class Candidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CandidatoPK candidatoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "apellido", nullable = false, length = 2147483647)
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 2147483647)
    @Column(name = "ap_casada", length = 2147483647)
    private String apCasada;
    @Column(name = "sexo")
    private Integer sexo;
    @Size(max = 2147483647)
    @Column(name = "observacion", length = 2147483647)
    private String observacion;
    @Size(max = 2147483647)
    @Column(name = "status", length = 2147483647)
    private String status;
    @JoinColumn(name = "cod_cia", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato1")
    private List<ResultadoEvaluacionCandidato> resultadoEvaluacionCandidatoList;

    public Candidato() {
    }

    public Candidato(CandidatoPK candidatoPK) {
        this.candidatoPK = candidatoPK;
    }

    public Candidato(CandidatoPK candidatoPK, String nombre, String apellido) {
        this.candidatoPK = candidatoPK;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Candidato(int codCia, int codCandidato) {
        this.candidatoPK = new CandidatoPK(codCia, codCandidato);
    }

    public CandidatoPK getCandidatoPK() {
        return candidatoPK;
    }

    public void setCandidatoPK(CandidatoPK candidatoPK) {
        this.candidatoPK = candidatoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApCasada() {
        return apCasada;
    }

    public void setApCasada(String apCasada) {
        this.apCasada = apCasada;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public List<ResultadoEvaluacionCandidato> getResultadoEvaluacionCandidatoList() {
        return resultadoEvaluacionCandidatoList;
    }

    public void setResultadoEvaluacionCandidatoList(List<ResultadoEvaluacionCandidato> resultadoEvaluacionCandidatoList) {
        this.resultadoEvaluacionCandidatoList = resultadoEvaluacionCandidatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidatoPK != null ? candidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.candidatoPK == null && other.candidatoPK != null) || (this.candidatoPK != null && !this.candidatoPK.equals(other.candidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Candidato[ candidatoPK=" + candidatoPK + " ]";
    }
    
}
