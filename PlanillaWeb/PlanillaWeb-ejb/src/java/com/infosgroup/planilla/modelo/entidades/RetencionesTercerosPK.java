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
public class RetencionesTercerosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "FEC_ULT_PAGO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltPago;

    public RetencionesTercerosPK() {
    }

    public RetencionesTercerosPK(short codCia, int codEmp, Date fecUltPago) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.fecUltPago = fecUltPago;
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

    public Date getFecUltPago() {
        return fecUltPago;
    }

    public void setFecUltPago(Date fecUltPago) {
        this.fecUltPago = fecUltPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        hash += (fecUltPago != null ? fecUltPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetencionesTercerosPK)) {
            return false;
        }
        RetencionesTercerosPK other = (RetencionesTercerosPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if ((this.fecUltPago == null && other.fecUltPago != null) || (this.fecUltPago != null && !this.fecUltPago.equals(other.fecUltPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RetencionesTercerosPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", fecUltPago=" + fecUltPago + " ]";
    }
    
}
