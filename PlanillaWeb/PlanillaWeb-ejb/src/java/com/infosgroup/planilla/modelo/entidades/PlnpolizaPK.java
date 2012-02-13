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
public class PlnpolizaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "TIPO_DOCTO", nullable = false, length = 2)
    private String tipoDocto;
    @Basic(optional = false)
    @Column(name = "NUM_POLIZA", nullable = false)
    private int numPoliza;
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public PlnpolizaPK() {
    }

    public PlnpolizaPK(short codCia, String tipoDocto, int numPoliza, Date fecha) {
        this.codCia = codCia;
        this.tipoDocto = tipoDocto;
        this.numPoliza = numPoliza;
        this.fecha = fecha;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public String getTipoDocto() {
        return tipoDocto;
    }

    public void setTipoDocto(String tipoDocto) {
        this.tipoDocto = tipoDocto;
    }

    public int getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(int numPoliza) {
        this.numPoliza = numPoliza;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (tipoDocto != null ? tipoDocto.hashCode() : 0);
        hash += (int) numPoliza;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlnpolizaPK)) {
            return false;
        }
        PlnpolizaPK other = (PlnpolizaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.tipoDocto == null && other.tipoDocto != null) || (this.tipoDocto != null && !this.tipoDocto.equals(other.tipoDocto))) {
            return false;
        }
        if (this.numPoliza != other.numPoliza) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PlnpolizaPK[ codCia=" + codCia + ", tipoDocto=" + tipoDocto + ", numPoliza=" + numPoliza + ", fecha=" + fecha + " ]";
    }
    
}
