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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
    @NamedQuery(name = "Candidato.findByEstado", query = "SELECT c FROM Candidato c WHERE c.estado = :estado"),
    @NamedQuery(name = "Candidato.findByEdad", query = "SELECT c FROM Candidato c WHERE c.edad = :edad")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CandidatoPK candidatoPK;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 2147483647)
    private String apellido;
    @Column(name = "ap_casada", length = 2147483647)
    private String apCasada;
    @Basic(optional = false)
    @Column(name = "sexo", nullable = false)
    private String sexo;
    @Column(name = "observacion", length = 2147483647)
    private String observacion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
    @Basic(optional = false)
    @Column(name = "edad", nullable = false)
    private int edad;
    @JoinTable(name = "candidato_concurso", joinColumns = {
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false),
        @JoinColumn(name = "candidato", referencedColumnName = "cod_candidato", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false),
        @JoinColumn(name = "concurso", referencedColumnName = "cod_concurso", nullable = false)})
    @ManyToMany
    private List<Concurso> concursoList;
    @JoinColumn(name = "cod_cia", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato1")
    private List<CriteriosXCandidato> criteriosXCandidatoList;

    public Candidato() {
    }

    public Candidato(CandidatoPK candidatoPK) {
        this.candidatoPK = candidatoPK;
    }

    public Candidato(CandidatoPK candidatoPK, String nombre, String apellido, String sexo, String estado, int edad) {
        this.candidatoPK = candidatoPK;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.estado = estado;
        this.edad = edad;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Concurso> getConcursoList() {
        return concursoList;
    }

    public void setConcursoList(List<Concurso> concursoList) {
        this.concursoList = concursoList;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public List<CriteriosXCandidato> getCriteriosXCandidatoList() {
        return criteriosXCandidatoList;
    }

    public void setCriteriosXCandidatoList(List<CriteriosXCandidato> criteriosXCandidatoList) {
        this.criteriosXCandidatoList = criteriosXCandidatoList;
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
        return "testjqpl.modelo.entidades.Candidato[ candidatoPK=" + candidatoPK + " ]";
    }
}
