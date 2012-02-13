/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class NivelAcademicoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_NIVEL_ACADEMICO", nullable = false)
    private short codNivelAcademico;

    public NivelAcademicoPK() {
    }

    public NivelAcademicoPK(short codCia, short codNivelAcademico) {
        this.codCia = codCia;
        this.codNivelAcademico = codNivelAcademico;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codNivelAcademico;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcademicoPK)) {
            return false;
        }
        NivelAcademicoPK other = (NivelAcademicoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codNivelAcademico != other.codNivelAcademico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.NivelAcademicoPK[ codCia=" + codCia + ", codNivelAcademico=" + codNivelAcademico + " ]";
    }
    
}
