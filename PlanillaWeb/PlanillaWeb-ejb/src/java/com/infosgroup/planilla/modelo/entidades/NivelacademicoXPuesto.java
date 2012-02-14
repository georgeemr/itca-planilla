/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "NIVELACADEMICO_X_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelacademicoXPuesto.findAll", query = "SELECT n FROM NivelacademicoXPuesto n"),
    @NamedQuery(name = "NivelacademicoXPuesto.findByCodCia", query = "SELECT n FROM NivelacademicoXPuesto n WHERE n.nivelacademicoXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "NivelacademicoXPuesto.findByCodPuesto", query = "SELECT n FROM NivelacademicoXPuesto n WHERE n.nivelacademicoXPuestoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "NivelacademicoXPuesto.findByCodNivelAcademico", query = "SELECT n FROM NivelacademicoXPuesto n WHERE n.nivelacademicoXPuestoPK.codNivelAcademico = :codNivelAcademico"),
    @NamedQuery(name = "NivelacademicoXPuesto.findBySubNivelAcademico", query = "SELECT n FROM NivelacademicoXPuesto n WHERE n.subNivelAcademico = :subNivelAcademico")})
public class NivelacademicoXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NivelacademicoXPuestoPK nivelacademicoXPuestoPK;
    @Column(name = "SUB_NIVEL_ACADEMICO")
    private Short subNivelAcademico;

    public NivelacademicoXPuesto() {
    }

    public NivelacademicoXPuesto(NivelacademicoXPuestoPK nivelacademicoXPuestoPK) {
        this.nivelacademicoXPuestoPK = nivelacademicoXPuestoPK;
    }

    public NivelacademicoXPuesto(short codCia, short codPuesto, short codNivelAcademico) {
        this.nivelacademicoXPuestoPK = new NivelacademicoXPuestoPK(codCia, codPuesto, codNivelAcademico);
    }

    public NivelacademicoXPuestoPK getNivelacademicoXPuestoPK() {
        return nivelacademicoXPuestoPK;
    }

    public void setNivelacademicoXPuestoPK(NivelacademicoXPuestoPK nivelacademicoXPuestoPK) {
        this.nivelacademicoXPuestoPK = nivelacademicoXPuestoPK;
    }

    public Short getSubNivelAcademico() {
        return subNivelAcademico;
    }

    public void setSubNivelAcademico(Short subNivelAcademico) {
        this.subNivelAcademico = subNivelAcademico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivelacademicoXPuestoPK != null ? nivelacademicoXPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelacademicoXPuesto)) {
            return false;
        }
        NivelacademicoXPuesto other = (NivelacademicoXPuesto) object;
        if ((this.nivelacademicoXPuestoPK == null && other.nivelacademicoXPuestoPK != null) || (this.nivelacademicoXPuestoPK != null && !this.nivelacademicoXPuestoPK.equals(other.nivelacademicoXPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.NivelacademicoXPuesto[ nivelacademicoXPuestoPK=" + nivelacademicoXPuestoPK + " ]";
    }
    
}
