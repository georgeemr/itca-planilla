/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "PROFESION_X_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesionXPuesto.findAll", query = "SELECT p FROM ProfesionXPuesto p"),
    @NamedQuery(name = "ProfesionXPuesto.findByCodCia", query = "SELECT p FROM ProfesionXPuesto p WHERE p.profesionXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "ProfesionXPuesto.findByCodPuesto", query = "SELECT p FROM ProfesionXPuesto p WHERE p.profesionXPuestoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "ProfesionXPuesto.findByCodProfesion", query = "SELECT p FROM ProfesionXPuesto p WHERE p.profesionXPuestoPK.codProfesion = :codProfesion")})
public class ProfesionXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfesionXPuestoPK profesionXPuestoPK;

    public ProfesionXPuesto() {
    }

    public ProfesionXPuesto(ProfesionXPuestoPK profesionXPuestoPK) {
        this.profesionXPuestoPK = profesionXPuestoPK;
    }

    public ProfesionXPuesto(short codCia, short codPuesto, short codProfesion) {
        this.profesionXPuestoPK = new ProfesionXPuestoPK(codCia, codPuesto, codProfesion);
    }

    public ProfesionXPuestoPK getProfesionXPuestoPK() {
        return profesionXPuestoPK;
    }

    public void setProfesionXPuestoPK(ProfesionXPuestoPK profesionXPuestoPK) {
        this.profesionXPuestoPK = profesionXPuestoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesionXPuestoPK != null ? profesionXPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesionXPuesto)) {
            return false;
        }
        ProfesionXPuesto other = (ProfesionXPuesto) object;
        if ((this.profesionXPuestoPK == null && other.profesionXPuestoPK != null) || (this.profesionXPuestoPK != null && !this.profesionXPuestoPK.equals(other.profesionXPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ProfesionXPuesto[ profesionXPuestoPK=" + profesionXPuestoPK + " ]";
    }
    
}
