/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "NIVEL_ACADEMICO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelAcademico.findAll", query = "SELECT n FROM NivelAcademico n"),
    @NamedQuery(name = "NivelAcademico.findByCodCia", query = "SELECT n FROM NivelAcademico n WHERE n.nivelAcademicoPK.codCia = :codCia"),
    @NamedQuery(name = "NivelAcademico.findByCodNivelAcademico", query = "SELECT n FROM NivelAcademico n WHERE n.nivelAcademicoPK.codNivelAcademico = :codNivelAcademico"),
    @NamedQuery(name = "NivelAcademico.findByNomNivelAcademico", query = "SELECT n FROM NivelAcademico n WHERE n.nomNivelAcademico = :nomNivelAcademico")})
public class NivelAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NivelAcademicoPK nivelAcademicoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_NIVEL_ACADEMICO", nullable = false, length = 200)
    private String nomNivelAcademico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelAcademico")
    private List<SubNivelAcademico> subNivelAcademicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelAcademico")
    private List<Candidato> candidatoList;

    public NivelAcademico() {
    }

    public NivelAcademico(NivelAcademicoPK nivelAcademicoPK) {
        this.nivelAcademicoPK = nivelAcademicoPK;
    }

    public NivelAcademico(NivelAcademicoPK nivelAcademicoPK, String nomNivelAcademico) {
        this.nivelAcademicoPK = nivelAcademicoPK;
        this.nomNivelAcademico = nomNivelAcademico;
    }

    public NivelAcademico(short codCia, short codNivelAcademico) {
        this.nivelAcademicoPK = new NivelAcademicoPK(codCia, codNivelAcademico);
    }

    public NivelAcademicoPK getNivelAcademicoPK() {
        return nivelAcademicoPK;
    }

    public void setNivelAcademicoPK(NivelAcademicoPK nivelAcademicoPK) {
        this.nivelAcademicoPK = nivelAcademicoPK;
    }

    public String getNomNivelAcademico() {
        return nomNivelAcademico;
    }

    public void setNomNivelAcademico(String nomNivelAcademico) {
        this.nomNivelAcademico = nomNivelAcademico;
    }

    @XmlTransient
    public List<SubNivelAcademico> getSubNivelAcademicoList() {
        return subNivelAcademicoList;
    }

    public void setSubNivelAcademicoList(List<SubNivelAcademico> subNivelAcademicoList) {
        this.subNivelAcademicoList = subNivelAcademicoList;
    }

    @XmlTransient
    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivelAcademicoPK != null ? nivelAcademicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcademico)) {
            return false;
        }
        NivelAcademico other = (NivelAcademico) object;
        if ((this.nivelAcademicoPK == null && other.nivelAcademicoPK != null) || (this.nivelAcademicoPK != null && !this.nivelAcademicoPK.equals(other.nivelAcademicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.NivelAcademico[ nivelAcademicoPK=" + nivelAcademicoPK + " ]";
    }
    
}
