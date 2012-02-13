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
public class CampaniaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CAMPANIA", nullable = false)
    private short codCampania;
    @Basic(optional = false)
    @Column(name = "PERIODO", nullable = false)
    private int periodo;

    public CampaniaPK() {
    }

    public CampaniaPK(short codCia, short codCampania, int periodo) {
        this.codCia = codCia;
        this.codCampania = codCampania;
        this.periodo = periodo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodCampania() {
        return codCampania;
    }

    public void setCodCampania(short codCampania) {
        this.codCampania = codCampania;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCampania;
        hash += (int) periodo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampaniaPK)) {
            return false;
        }
        CampaniaPK other = (CampaniaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCampania != other.codCampania) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CampaniaPK[ codCia=" + codCia + ", codCampania=" + codCampania + ", periodo=" + periodo + " ]";
    }
    
}
