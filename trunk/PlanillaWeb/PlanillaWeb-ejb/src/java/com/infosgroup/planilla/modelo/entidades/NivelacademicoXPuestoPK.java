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
public class NivelacademicoXPuestoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PUESTO", nullable = false)
    private short codPuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_NIVEL_ACADEMICO", nullable = false)
    private short codNivelAcademico;

    public NivelacademicoXPuestoPK() {
    }

    public NivelacademicoXPuestoPK(short codCia, short codPuesto, short codNivelAcademico) {
        this.codCia = codCia;
        this.codPuesto = codPuesto;
        this.codNivelAcademico = codNivelAcademico;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(short codPuesto) {
        this.codPuesto = codPuesto;
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
        hash += (int) codPuesto;
        hash += (int) codNivelAcademico;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelacademicoXPuestoPK)) {
            return false;
        }
        NivelacademicoXPuestoPK other = (NivelacademicoXPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codPuesto != other.codPuesto) {
            return false;
        }
        if (this.codNivelAcademico != other.codNivelAcademico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.NivelacademicoXPuestoPK[ codCia=" + codCia + ", codPuesto=" + codPuesto + ", codNivelAcademico=" + codNivelAcademico + " ]";
    }
    
}
