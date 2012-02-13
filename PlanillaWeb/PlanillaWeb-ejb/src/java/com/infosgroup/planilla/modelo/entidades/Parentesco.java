/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PARENTESCO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parentesco.findAll", query = "SELECT p FROM Parentesco p"),
    @NamedQuery(name = "Parentesco.findByCodCia", query = "SELECT p FROM Parentesco p WHERE p.parentescoPK.codCia = :codCia"),
    @NamedQuery(name = "Parentesco.findByCodParentesco", query = "SELECT p FROM Parentesco p WHERE p.parentescoPK.codParentesco = :codParentesco"),
    @NamedQuery(name = "Parentesco.findByNomParentesco", query = "SELECT p FROM Parentesco p WHERE p.nomParentesco = :nomParentesco")})
public class Parentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParentescoPK parentescoPK;
    @Basic(optional = false)
    @Column(name = "NOM_PARENTESCO", nullable = false, length = 200)
    private String nomParentesco;
    @ManyToMany(mappedBy = "parentescoList")
    private List<Candidato> candidatoList;

    public Parentesco() {
    }

    public Parentesco(ParentescoPK parentescoPK) {
        this.parentescoPK = parentescoPK;
    }

    public Parentesco(ParentescoPK parentescoPK, String nomParentesco) {
        this.parentescoPK = parentescoPK;
        this.nomParentesco = nomParentesco;
    }

    public Parentesco(short codCia, short codParentesco) {
        this.parentescoPK = new ParentescoPK(codCia, codParentesco);
    }

    public ParentescoPK getParentescoPK() {
        return parentescoPK;
    }

    public void setParentescoPK(ParentescoPK parentescoPK) {
        this.parentescoPK = parentescoPK;
    }

    public String getNomParentesco() {
        return nomParentesco;
    }

    public void setNomParentesco(String nomParentesco) {
        this.nomParentesco = nomParentesco;
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
        hash += (parentescoPK != null ? parentescoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentesco)) {
            return false;
        }
        Parentesco other = (Parentesco) object;
        if ((this.parentescoPK == null && other.parentescoPK != null) || (this.parentescoPK != null && !this.parentescoPK.equals(other.parentescoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Parentesco[ parentescoPK=" + parentescoPK + " ]";
    }
    
}
