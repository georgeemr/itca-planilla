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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "BENEFICIARIO_POR_CANDIDATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeneficiarioPorCandidato.findAll", query = "SELECT b FROM BeneficiarioPorCandidato b"),
    @NamedQuery(name = "BeneficiarioPorCandidato.findByCodCia", query = "SELECT b FROM BeneficiarioPorCandidato b WHERE b.beneficiarioPorCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "BeneficiarioPorCandidato.findByCandidato", query = "SELECT b FROM BeneficiarioPorCandidato b WHERE b.beneficiarioPorCandidatoPK.candidato = :candidato"),
    @NamedQuery(name = "BeneficiarioPorCandidato.findByBeneficiario", query = "SELECT b FROM BeneficiarioPorCandidato b WHERE b.beneficiarioPorCandidatoPK.beneficiario = :beneficiario"),
    @NamedQuery(name = "BeneficiarioPorCandidato.findByNombre", query = "SELECT b FROM BeneficiarioPorCandidato b WHERE b.nombre = :nombre")})
public class BeneficiarioPorCandidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BeneficiarioPorCandidatoPK beneficiarioPorCandidatoPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @JoinColumn(name = "PARENTESCO", referencedColumnName = "CODIGO", nullable = false)
    @ManyToOne(optional = false)
    private Parentesco parentesco;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato1;

    public BeneficiarioPorCandidato() {
    }

    public BeneficiarioPorCandidato(BeneficiarioPorCandidatoPK beneficiarioPorCandidatoPK) {
        this.beneficiarioPorCandidatoPK = beneficiarioPorCandidatoPK;
    }

    public BeneficiarioPorCandidato(BeneficiarioPorCandidatoPK beneficiarioPorCandidatoPK, String nombre) {
        this.beneficiarioPorCandidatoPK = beneficiarioPorCandidatoPK;
        this.nombre = nombre;
    }

    public BeneficiarioPorCandidato(long codCia, long candidato, long beneficiario) {
        this.beneficiarioPorCandidatoPK = new BeneficiarioPorCandidatoPK(codCia, candidato, beneficiario);
    }

    public BeneficiarioPorCandidatoPK getBeneficiarioPorCandidatoPK() {
        return beneficiarioPorCandidatoPK;
    }

    public void setBeneficiarioPorCandidatoPK(BeneficiarioPorCandidatoPK beneficiarioPorCandidatoPK) {
        this.beneficiarioPorCandidatoPK = beneficiarioPorCandidatoPK;
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

    public Candidato getCandidato1() {
        return candidato1;
    }

    public void setCandidato1(Candidato candidato1) {
        this.candidato1 = candidato1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beneficiarioPorCandidatoPK != null ? beneficiarioPorCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeneficiarioPorCandidato)) {
            return false;
        }
        BeneficiarioPorCandidato other = (BeneficiarioPorCandidato) object;
        if ((this.beneficiarioPorCandidatoPK == null && other.beneficiarioPorCandidatoPK != null) || (this.beneficiarioPorCandidatoPK != null && !this.beneficiarioPorCandidatoPK.equals(other.beneficiarioPorCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.BeneficiarioPorCandidato[ beneficiarioPorCandidatoPK=" + beneficiarioPorCandidatoPK + " ]";
    }
    
}
