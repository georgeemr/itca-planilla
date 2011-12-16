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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CANDIDATO")
@XmlRootElement
@NamedQueries(
    {
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
    @NamedQuery(name = "Candidato.findByEdad", query = "SELECT c FROM Candidato c WHERE c.edad = :edad")
    })
public class Candidato implements Serializable
{
    @Column(name =     "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato1")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato1")
    private List<CandidatoConcurso> candidatoConcursoList;

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CandidatoPK candidatoPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "APELLIDO", nullable = false, length = 200)
    private String apellido;
    @Size(max = 299)
    @Column(name = "AP_CASADA", length = 299)
    private String apCasada;

    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXO", nullable = false)
    private String sexo;

    @Size(max = 200)
    @Column(name = "OBSERVACION", length = 200)
    private String observacion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ESTADO", nullable = false, length = 100)
    private String estado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "EDAD", nullable = false)
    private long edad;

    @JoinTable(name = "CANDIDATO_CONCURSO", joinColumns =
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false)
        }, inverseJoinColumns =
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "CONCURSO", referencedColumnName = "COD_CONCURSO", nullable = false)
        })
    @ManyToMany
    private List<Concurso> concursoList;

    @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato1")
    private List<CriteriosXCandidato> criteriosXCandidatoList;
    @Transient
    private String nombreCompleto;
    public Candidato()
    {
    }

    public Candidato(CandidatoPK candidatoPK)
    {
        this.candidatoPK = candidatoPK;
    }

    public Candidato(CandidatoPK candidatoPK, String nombre, String apellido, String sexo, String estado, long edad) {
        this.candidatoPK = candidatoPK;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.estado = estado;
        this.edad = edad;
    }

    public Candidato(long codCia, long codCandidato)
    {
        this.candidatoPK = new CandidatoPK(codCia, codCandidato);
    }

    public CandidatoPK getCandidatoPK()
    {
        return candidatoPK;
    }

    public void setCandidatoPK(CandidatoPK candidatoPK)
    {
        this.candidatoPK = candidatoPK;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApCasada()
    {
        return apCasada;
    }

    public void setApCasada(String apCasada)
    {
        this.apCasada = apCasada;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservacion()
    {
        return observacion;
    }

    public void setObservacion(String observacion)
    {
        this.observacion = observacion;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public long getEdad()
    {
        return edad;
    }

    public void setEdad(long edad)
    {
        this.edad = edad;
    }

    @XmlTransient
    public List<Concurso> getConcursoList()
    {
        return concursoList;
    }

    public void setConcursoList(List<Concurso> concursoList)
    {
        this.concursoList = concursoList;
    }

    public Compania getCompania()
    {
        return compania;
    }

    public void setCompania(Compania compania)
    {
        this.compania = compania;
    }

    @XmlTransient
    public List<CriteriosXCandidato> getCriteriosXCandidatoList()
    {
        return criteriosXCandidatoList;
    }

    public void setCriteriosXCandidatoList(List<CriteriosXCandidato> criteriosXCandidatoList)
    {
        this.criteriosXCandidatoList = criteriosXCandidatoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (candidatoPK != null ? candidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato))
            {
            return false;
            }
        Candidato other = (Candidato) object;
        if ((this.candidatoPK == null && other.candidatoPK != null) || (this.candidatoPK != null && !this.candidatoPK.equals(other.candidatoPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Candidato[ candidatoPK=" + candidatoPK + " ]";
    }

    public List<CandidatoConcurso> getCandidatoConcursoList() {
        return candidatoConcursoList;
    }

    public void setCandidatoConcursoList(List<CandidatoConcurso> candidatoConcursoList) {
        this.candidatoConcursoList = candidatoConcursoList;
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public String getNombreCompleto() {
        nombreCompleto = getNombre()  + " " + getApellido();
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
