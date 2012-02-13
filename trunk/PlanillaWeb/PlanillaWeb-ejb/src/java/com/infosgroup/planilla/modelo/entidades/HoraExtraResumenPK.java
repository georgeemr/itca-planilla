/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Embeddable
public class HoraExtraResumenPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Basic(optional = false)
    @Column(name = "FECHA_FINAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;

    public HoraExtraResumenPK() {
    }

    public HoraExtraResumenPK(short codCia, int codEmp, Date fechaInicial, Date fechaFinal) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        hash += (fechaInicial != null ? fechaInicial.hashCode() : 0);
        hash += (fechaFinal != null ? fechaFinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoraExtraResumenPK)) {
            return false;
        }
        HoraExtraResumenPK other = (HoraExtraResumenPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if ((this.fechaInicial == null && other.fechaInicial != null) || (this.fechaInicial != null && !this.fechaInicial.equals(other.fechaInicial))) {
            return false;
        }
        if ((this.fechaFinal == null && other.fechaFinal != null) || (this.fechaFinal != null && !this.fechaFinal.equals(other.fechaFinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.HoraExtraResumenPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + " ]";
    }
    
}
