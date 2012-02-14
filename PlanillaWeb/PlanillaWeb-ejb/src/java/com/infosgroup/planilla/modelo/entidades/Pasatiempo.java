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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PASATIEMPO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasatiempo.findAll", query = "SELECT p FROM Pasatiempo p"),
    @NamedQuery(name = "Pasatiempo.findByCodCia", query = "SELECT p FROM Pasatiempo p WHERE p.pasatiempoPK.codCia = :codCia"),
    @NamedQuery(name = "Pasatiempo.findByCodPasatiempo", query = "SELECT p FROM Pasatiempo p WHERE p.pasatiempoPK.codPasatiempo = :codPasatiempo"),
    @NamedQuery(name = "Pasatiempo.findByNomPasatiempo", query = "SELECT p FROM Pasatiempo p WHERE p.nomPasatiempo = :nomPasatiempo")})
public class Pasatiempo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PasatiempoPK pasatiempoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_PASATIEMPO", nullable = false, length = 200)
    private String nomPasatiempo;
    @ManyToMany(mappedBy = "pasatiempoList")
    private List<Candidato> candidatoList;

    public Pasatiempo() {
    }

    public Pasatiempo(PasatiempoPK pasatiempoPK) {
        this.pasatiempoPK = pasatiempoPK;
    }

    public Pasatiempo(PasatiempoPK pasatiempoPK, String nomPasatiempo) {
        this.pasatiempoPK = pasatiempoPK;
        this.nomPasatiempo = nomPasatiempo;
    }

    public Pasatiempo(short codCia, short codPasatiempo) {
        this.pasatiempoPK = new PasatiempoPK(codCia, codPasatiempo);
    }

    public PasatiempoPK getPasatiempoPK() {
        return pasatiempoPK;
    }

    public void setPasatiempoPK(PasatiempoPK pasatiempoPK) {
        this.pasatiempoPK = pasatiempoPK;
    }

    public String getNomPasatiempo() {
        return nomPasatiempo;
    }

    public void setNomPasatiempo(String nomPasatiempo) {
        this.nomPasatiempo = nomPasatiempo;
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
        hash += (pasatiempoPK != null ? pasatiempoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasatiempo)) {
            return false;
        }
        Pasatiempo other = (Pasatiempo) object;
        if ((this.pasatiempoPK == null && other.pasatiempoPK != null) || (this.pasatiempoPK != null && !this.pasatiempoPK.equals(other.pasatiempoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Pasatiempo[ pasatiempoPK=" + pasatiempoPK + " ]";
    }
    
}
