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
public class DetHojaAsistenciaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "NO_HOJA", nullable = false)
    private short noHoja;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "NO_SERIE", nullable = false)
    private short noSerie;

    public DetHojaAsistenciaPK() {
    }

    public DetHojaAsistenciaPK(short codCia, short noHoja, int codEmp, short noSerie) {
        this.codCia = codCia;
        this.noHoja = noHoja;
        this.codEmp = codEmp;
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

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
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
        hash += (int) codEmp;
        hash += (int) noSerie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetHojaAsistenciaPK)) {
            return false;
        }
        DetHojaAsistenciaPK other = (DetHojaAsistenciaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.noHoja != other.noHoja) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (this.noSerie != other.noSerie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetHojaAsistenciaPK[ codCia=" + codCia + ", noHoja=" + noHoja + ", codEmp=" + codEmp + ", noSerie=" + noSerie + " ]";
    }
    
}
