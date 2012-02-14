/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "SUB_NIVEL_ACADEMICO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubNivelAcademico.findAll", query = "SELECT s FROM SubNivelAcademico s"),
    @NamedQuery(name = "SubNivelAcademico.findByCodCia", query = "SELECT s FROM SubNivelAcademico s WHERE s.subNivelAcademicoPK.codCia = :codCia"),
    @NamedQuery(name = "SubNivelAcademico.findByCodNivelAcademico", query = "SELECT s FROM SubNivelAcademico s WHERE s.subNivelAcademicoPK.codNivelAcademico = :codNivelAcademico"),
    @NamedQuery(name = "SubNivelAcademico.findBySubNivelAcademico", query = "SELECT s FROM SubNivelAcademico s WHERE s.subNivelAcademicoPK.subNivelAcademico = :subNivelAcademico"),
    @NamedQuery(name = "SubNivelAcademico.findByNomSumNivel", query = "SELECT s FROM SubNivelAcademico s WHERE s.nomSumNivel = :nomSumNivel")})
public class SubNivelAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubNivelAcademicoPK subNivelAcademicoPK;
    @Size(max = 200)
    @Column(name = "NOM_SUM_NIVEL", length = 200)
    private String nomSumNivel;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_NIVEL_ACADEMICO", referencedColumnName = "COD_NIVEL_ACADEMICO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private NivelAcademico nivelAcademico;

    public SubNivelAcademico() {
    }

    public SubNivelAcademico(SubNivelAcademicoPK subNivelAcademicoPK) {
        this.subNivelAcademicoPK = subNivelAcademicoPK;
    }

    public SubNivelAcademico(short codCia, short codNivelAcademico, short subNivelAcademico) {
        this.subNivelAcademicoPK = new SubNivelAcademicoPK(codCia, codNivelAcademico, subNivelAcademico);
    }

    public SubNivelAcademicoPK getSubNivelAcademicoPK() {
        return subNivelAcademicoPK;
    }

    public void setSubNivelAcademicoPK(SubNivelAcademicoPK subNivelAcademicoPK) {
        this.subNivelAcademicoPK = subNivelAcademicoPK;
    }

    public String getNomSumNivel() {
        return nomSumNivel;
    }

    public void setNomSumNivel(String nomSumNivel) {
        this.nomSumNivel = nomSumNivel;
    }

    public NivelAcademico getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademico nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subNivelAcademicoPK != null ? subNivelAcademicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubNivelAcademico)) {
            return false;
        }
        SubNivelAcademico other = (SubNivelAcademico) object;
        if ((this.subNivelAcademicoPK == null && other.subNivelAcademicoPK != null) || (this.subNivelAcademicoPK != null && !this.subNivelAcademicoPK.equals(other.subNivelAcademicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.SubNivelAcademico[ subNivelAcademicoPK=" + subNivelAcademicoPK + " ]";
    }
    
}
