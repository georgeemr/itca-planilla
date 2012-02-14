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
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class FirmasPlanillaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_FIRMA", nullable = false)
    private short codFirma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DESDE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_HASTA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHasta;

    public FirmasPlanillaPK() {
    }

    public FirmasPlanillaPK(short codCia, short codFirma, Date fechaDesde, Date fechaHasta) {
        this.codCia = codCia;
        this.codFirma = codFirma;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodFirma() {
        return codFirma;
    }

    public void setCodFirma(short codFirma) {
        this.codFirma = codFirma;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codFirma;
        hash += (fechaDesde != null ? fechaDesde.hashCode() : 0);
        hash += (fechaHasta != null ? fechaHasta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FirmasPlanillaPK)) {
            return false;
        }
        FirmasPlanillaPK other = (FirmasPlanillaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codFirma != other.codFirma) {
            return false;
        }
        if ((this.fechaDesde == null && other.fechaDesde != null) || (this.fechaDesde != null && !this.fechaDesde.equals(other.fechaDesde))) {
            return false;
        }
        if ((this.fechaHasta == null && other.fechaHasta != null) || (this.fechaHasta != null && !this.fechaHasta.equals(other.fechaHasta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.FirmasPlanillaPK[ codCia=" + codCia + ", codFirma=" + codFirma + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + " ]";
    }
    
}
