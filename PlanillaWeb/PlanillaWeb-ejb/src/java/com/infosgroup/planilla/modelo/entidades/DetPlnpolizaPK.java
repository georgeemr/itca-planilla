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
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Embeddable
public class DetPlnpolizaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO_DOCTO", nullable = false, length = 2)
    private String tipoDocto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_POLIZA", nullable = false)
    private int numPoliza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELAT", nullable = false)
    private short correlat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public DetPlnpolizaPK() {
    }

    public DetPlnpolizaPK(short codCia, String tipoDocto, int numPoliza, short correlat, Date fecha) {
        this.codCia = codCia;
        this.tipoDocto = tipoDocto;
        this.numPoliza = numPoliza;
        this.correlat = correlat;
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

    public short getCorrelat() {
        return correlat;
    }

    public void setCorrelat(short correlat) {
        this.correlat = correlat;
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
        hash += (int) correlat;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPlnpolizaPK)) {
            return false;
        }
        DetPlnpolizaPK other = (DetPlnpolizaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.tipoDocto == null && other.tipoDocto != null) || (this.tipoDocto != null && !this.tipoDocto.equals(other.tipoDocto))) {
            return false;
        }
        if (this.numPoliza != other.numPoliza) {
            return false;
        }
        if (this.correlat != other.correlat) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetPlnpolizaPK[ codCia=" + codCia + ", tipoDocto=" + tipoDocto + ", numPoliza=" + numPoliza + ", correlat=" + correlat + ", fecha=" + fecha + " ]";
    }
    
}
