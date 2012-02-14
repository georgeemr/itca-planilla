/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class SubNivelAcademicoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_NIVEL_ACADEMICO", nullable = false)
    private short codNivelAcademico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_NIVEL_ACADEMICO", nullable = false)
    private short subNivelAcademico;

    public SubNivelAcademicoPK() {
    }

    public SubNivelAcademicoPK(short codCia, short codNivelAcademico, short subNivelAcademico) {
        this.codCia = codCia;
        this.codNivelAcademico = codNivelAcademico;
        this.subNivelAcademico = subNivelAcademico;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodNivelAcademico() {
        return codNivelAcademico;
    }

    public void setCodNivelAcademico(short codNivelAcademico) {
        this.codNivelAcademico = codNivelAcademico;
    }

    public short getSubNivelAcademico() {
        return subNivelAcademico;
    }

    public void setSubNivelAcademico(short subNivelAcademico) {
        this.subNivelAcademico = subNivelAcademico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codNivelAcademico;
        hash += (int) subNivelAcademico;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubNivelAcademicoPK)) {
            return false;
        }
        SubNivelAcademicoPK other = (SubNivelAcademicoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codNivelAcademico != other.codNivelAcademico) {
            return false;
        }
        if (this.subNivelAcademico != other.subNivelAcademico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.SubNivelAcademicoPK[ codCia=" + codCia + ", codNivelAcademico=" + codNivelAcademico + ", subNivelAcademico=" + subNivelAcademico + " ]";
    }
    
}
