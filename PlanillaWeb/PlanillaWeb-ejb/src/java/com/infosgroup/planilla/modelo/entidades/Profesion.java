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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PROFESION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesion.findAll", query = "SELECT p FROM Profesion p"),
    @NamedQuery(name = "Profesion.findByCodCia", query = "SELECT p FROM Profesion p WHERE p.profesionPK.codCia = :codCia"),
    @NamedQuery(name = "Profesion.findByCodProfesion", query = "SELECT p FROM Profesion p WHERE p.profesionPK.codProfesion = :codProfesion"),
    @NamedQuery(name = "Profesion.findByNomProfesion", query = "SELECT p FROM Profesion p WHERE p.nomProfesion = :nomProfesion")})
public class Profesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfesionPK profesionPK;
    @Basic(optional = false)
    @Column(name = "NOM_PROFESION", nullable = false, length = 200)
    private String nomProfesion;

    public Profesion() {
    }

    public Profesion(ProfesionPK profesionPK) {
        this.profesionPK = profesionPK;
    }

    public Profesion(ProfesionPK profesionPK, String nomProfesion) {
        this.profesionPK = profesionPK;
        this.nomProfesion = nomProfesion;
    }

    public Profesion(short codCia, short codProfesion) {
        this.profesionPK = new ProfesionPK(codCia, codProfesion);
    }

    public ProfesionPK getProfesionPK() {
        return profesionPK;
    }

    public void setProfesionPK(ProfesionPK profesionPK) {
        this.profesionPK = profesionPK;
    }

    public String getNomProfesion() {
        return nomProfesion;
    }

    public void setNomProfesion(String nomProfesion) {
        this.nomProfesion = nomProfesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesionPK != null ? profesionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesion)) {
            return false;
        }
        Profesion other = (Profesion) object;
        if ((this.profesionPK == null && other.profesionPK != null) || (this.profesionPK != null && !this.profesionPK.equals(other.profesionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Profesion[ profesionPK=" + profesionPK + " ]";
    }
    
}
