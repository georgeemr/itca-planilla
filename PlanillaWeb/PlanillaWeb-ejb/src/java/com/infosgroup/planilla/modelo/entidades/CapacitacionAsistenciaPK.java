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
 * @author infosgroup
 */
@Embeddable
public class CapacitacionAsistenciaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CAPACITACION", nullable = false)
    private int codCapacitacion;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public CapacitacionAsistenciaPK() {
    }

    public CapacitacionAsistenciaPK(short codCia, int codCapacitacion, int codEmp, Date fecha) {
        this.codCia = codCia;
        this.codCapacitacion = codCapacitacion;
        this.codEmp = codEmp;
        this.fecha = fecha;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodCapacitacion() {
        return codCapacitacion;
    }

    public void setCodCapacitacion(int codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
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
        hash += (int) codCapacitacion;
        hash += (int) codEmp;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionAsistenciaPK)) {
            return false;
        }
        CapacitacionAsistenciaPK other = (CapacitacionAsistenciaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCapacitacion != other.codCapacitacion) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitdadesplanilla.CapacitacionAsistenciaPK[ codCia=" + codCia + ", codCapacitacion=" + codCapacitacion + ", codEmp=" + codEmp + ", fecha=" + fecha + " ]";
    }
    
}
