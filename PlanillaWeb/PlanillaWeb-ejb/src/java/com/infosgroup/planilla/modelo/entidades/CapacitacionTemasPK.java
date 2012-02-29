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
 * @author infosgroup
 */
@Embeddable
public class CapacitacionTemasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_AREA", nullable = false)
    private int codArea;
    @Basic(optional = false)
    @Column(name = "COD_TEMA", nullable = false)
    private int codTema;

    public CapacitacionTemasPK() {
    }

    public CapacitacionTemasPK(short codCia, int codArea, int codTema) {
        this.codCia = codCia;
        this.codArea = codArea;
        this.codTema = codTema;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodArea() {
        return codArea;
    }

    public void setCodArea(int codArea) {
        this.codArea = codArea;
    }

    public int getCodTema() {
        return codTema;
    }

    public void setCodTema(int codTema) {
        this.codTema = codTema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codArea;
        hash += (int) codTema;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionTemasPK)) {
            return false;
        }
        CapacitacionTemasPK other = (CapacitacionTemasPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codArea != other.codArea) {
            return false;
        }
        if (this.codTema != other.codTema) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitdadesplanilla.CapacitacionTemasPK[ codCia=" + codCia + ", codArea=" + codArea + ", codTema=" + codTema + " ]";
    }
    
}
