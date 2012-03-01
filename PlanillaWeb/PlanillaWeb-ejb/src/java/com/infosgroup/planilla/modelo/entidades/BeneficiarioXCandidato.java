/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "BENEFICIARIO_X_CANDIDATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeneficiarioXCandidato.findAll", query = "SELECT b FROM BeneficiarioXCandidato b"),
    @NamedQuery(name = "BeneficiarioXCandidato.findByCodCia", query = "SELECT b FROM BeneficiarioXCandidato b WHERE b.beneficiarioXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "BeneficiarioXCandidato.findByCodCandidato", query = "SELECT b FROM BeneficiarioXCandidato b WHERE b.beneficiarioXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "BeneficiarioXCandidato.findByCodBeneficiario", query = "SELECT b FROM BeneficiarioXCandidato b WHERE b.beneficiarioXCandidatoPK.codBeneficiario = :codBeneficiario"),
    @NamedQuery(name = "BeneficiarioXCandidato.findByNombre", query = "SELECT b FROM BeneficiarioXCandidato b WHERE b.nombre = :nombre")})
public class BeneficiarioXCandidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BeneficiarioXCandidatoPK beneficiarioXCandidatoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PARENTESCO", referencedColumnName = "COD_PARENTESCO")})
    @ManyToOne(optional = false)
    private Parentesco parentesco;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public BeneficiarioXCandidato() {
    }

    public BeneficiarioXCandidato(BeneficiarioXCandidatoPK beneficiarioXCandidatoPK) {
        this.beneficiarioXCandidatoPK = beneficiarioXCandidatoPK;
    }

    public BeneficiarioXCandidato(BeneficiarioXCandidatoPK beneficiarioXCandidatoPK, String nombre) {
        this.beneficiarioXCandidatoPK = beneficiarioXCandidatoPK;
        this.nombre = nombre;
    }

    public BeneficiarioXCandidato(short codCia, int codCandidato, int codBeneficiario) {
        this.beneficiarioXCandidatoPK = new BeneficiarioXCandidatoPK(codCia, codCandidato, codBeneficiario);
    }

    public BeneficiarioXCandidatoPK getBeneficiarioXCandidatoPK() {
        return beneficiarioXCandidatoPK;
    }

    public void setBeneficiarioXCandidatoPK(BeneficiarioXCandidatoPK beneficiarioXCandidatoPK) {
        this.beneficiarioXCandidatoPK = beneficiarioXCandidatoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
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
        hash += (beneficiarioXCandidatoPK != null ? beneficiarioXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeneficiarioXCandidato)) {
            return false;
        }
        BeneficiarioXCandidato other = (BeneficiarioXCandidato) object;
        if ((this.beneficiarioXCandidatoPK == null && other.beneficiarioXCandidatoPK != null) || (this.beneficiarioXCandidatoPK != null && !this.beneficiarioXCandidatoPK.equals(other.beneficiarioXCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.BeneficiarioXCandidato[ beneficiarioXCandidatoPK=" + beneficiarioXCandidatoPK + " ]";
    }
    
}
