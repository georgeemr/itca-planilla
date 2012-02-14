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
public class HojaAsistenciaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_HOJA", nullable = false)
    private short noHoja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_SERIE", nullable = false)
    private short noSerie;

    public HojaAsistenciaPK() {
    }

    public HojaAsistenciaPK(short codCia, short noHoja, short noSerie) {
        this.codCia = codCia;
        this.noHoja = noHoja;
        this.noSerie = noSerie;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getNoHoja() {
        return noHoja;
    }

    public void setNoHoja(short noHoja) {
        this.noHoja = noHoja;
    }

    public short getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(short noSerie) {
        this.noSerie = noSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) noHoja;
        hash += (int) noSerie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HojaAsistenciaPK)) {
            return false;
        }
        HojaAsistenciaPK other = (HojaAsistenciaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.noHoja != other.noHoja) {
            return false;
        }
        if (this.noSerie != other.noSerie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.HojaAsistenciaPK[ codCia=" + codCia + ", noHoja=" + noHoja + ", noSerie=" + noSerie + " ]";
    }
    
}
