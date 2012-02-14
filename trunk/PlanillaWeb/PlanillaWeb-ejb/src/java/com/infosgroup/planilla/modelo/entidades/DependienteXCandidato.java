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
@Table(name = "DEPENDIENTE_X_CANDIDATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DependienteXCandidato.findAll", query = "SELECT d FROM DependienteXCandidato d"),
    @NamedQuery(name = "DependienteXCandidato.findByCodCia", query = "SELECT d FROM DependienteXCandidato d WHERE d.dependienteXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "DependienteXCandidato.findByCodCandidato", query = "SELECT d FROM DependienteXCandidato d WHERE d.dependienteXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "DependienteXCandidato.findByCodDependiente", query = "SELECT d FROM DependienteXCandidato d WHERE d.dependienteXCandidatoPK.codDependiente = :codDependiente"),
    @NamedQuery(name = "DependienteXCandidato.findByCodParentesco", query = "SELECT d FROM DependienteXCandidato d WHERE d.codParentesco = :codParentesco"),
    @NamedQuery(name = "DependienteXCandidato.findByFechaNacimiento", query = "SELECT d FROM DependienteXCandidato d WHERE d.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "DependienteXCandidato.findByNombre", query = "SELECT d FROM DependienteXCandidato d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DependienteXCandidato.findBySexo", query = "SELECT d FROM DependienteXCandidato d WHERE d.sexo = :sexo")})
public class DependienteXCandidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DependienteXCandidatoPK dependienteXCandidatoPK;
    @Column(name = "COD_PARENTESCO")
    private Short codParentesco;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Size(max = 100)
    @Column(name = "NOMBRE", length = 100)
    private String nombre;
    @Size(max = 1)
    @Column(name = "SEXO", length = 1)
    private String sexo;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public DependienteXCandidato() {
    }

    public DependienteXCandidato(DependienteXCandidatoPK dependienteXCandidatoPK) {
        this.dependienteXCandidatoPK = dependienteXCandidatoPK;
    }

    public DependienteXCandidato(short codCia, int codCandidato, int codDependiente) {
        this.dependienteXCandidatoPK = new DependienteXCandidatoPK(codCia, codCandidato, codDependiente);
    }

    public DependienteXCandidatoPK getDependienteXCandidatoPK() {
        return dependienteXCandidatoPK;
    }

    public void setDependienteXCandidatoPK(DependienteXCandidatoPK dependienteXCandidatoPK) {
        this.dependienteXCandidatoPK = dependienteXCandidatoPK;
    }

    public Short getCodParentesco() {
        return codParentesco;
    }

    public void setCodParentesco(Short codParentesco) {
        this.codParentesco = codParentesco;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dependienteXCandidatoPK != null ? dependienteXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DependienteXCandidato)) {
            return false;
        }
        DependienteXCandidato other = (DependienteXCandidato) object;
        if ((this.dependienteXCandidatoPK == null && other.dependienteXCandidatoPK != null) || (this.dependienteXCandidatoPK != null && !this.dependienteXCandidatoPK.equals(other.dependienteXCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DependienteXCandidato[ dependienteXCandidatoPK=" + dependienteXCandidatoPK + " ]";
    }
    
}
