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
public class DetProcesoDegradacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PUESTO", nullable = false)
    private short codPuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ACTIVIDAD", nullable = false)
    private int codActividad;

    public DetProcesoDegradacionPK() {
    }

    public DetProcesoDegradacionPK(short codCia, Date fecha, short codPuesto, int codActividad) {
        this.codCia = codCia;
        this.fecha = fecha;
        this.codPuesto = codPuesto;
        this.codActividad = codActividad;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(short codPuesto) {
        this.codPuesto = codPuesto;
    }

    public int getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(int codActividad) {
        this.codActividad = codActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) codPuesto;
        hash += (int) codActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetProcesoDegradacionPK)) {
            return false;
        }
        DetProcesoDegradacionPK other = (DetProcesoDegradacionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.codPuesto != other.codPuesto) {
            return false;
        }
        if (this.codActividad != other.codActividad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetProcesoDegradacionPK[ codCia=" + codCia + ", fecha=" + fecha + ", codPuesto=" + codPuesto + ", codActividad=" + codActividad + " ]";
    }
    
}
