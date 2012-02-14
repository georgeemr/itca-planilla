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
public class ProfesionXPuestoPK implements Serializable {
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
    @Column(name = "COD_PROFESION", nullable = false)
    private short codProfesion;

    public ProfesionXPuestoPK() {
    }

    public ProfesionXPuestoPK(short codCia, short codPuesto, short codProfesion) {
        this.codCia = codCia;
        this.codPuesto = codPuesto;
        this.codProfesion = codProfesion;
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

    public short getCodProfesion() {
        return codProfesion;
    }

    public void setCodProfesion(short codProfesion) {
        this.codProfesion = codProfesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codPuesto;
        hash += (int) codProfesion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesionXPuestoPK)) {
            return false;
        }
        ProfesionXPuestoPK other = (ProfesionXPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codPuesto != other.codPuesto) {
            return false;
        }
        if (this.codProfesion != other.codProfesion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ProfesionXPuestoPK[ codCia=" + codCia + ", codPuesto=" + codPuesto + ", codProfesion=" + codProfesion + " ]";
    }
    
}
