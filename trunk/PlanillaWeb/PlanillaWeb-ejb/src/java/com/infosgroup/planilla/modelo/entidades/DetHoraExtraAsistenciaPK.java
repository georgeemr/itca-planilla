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
public class DetHoraExtraAsistenciaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FINAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_INICIAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_FINAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinal;

    public DetHoraExtraAsistenciaPK() {
    }

    public DetHoraExtraAsistenciaPK(short codCia, int codEmp, Date fechaInicial, Date fechaFinal, Date fecha, Date horaInicial, Date horaFinal) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fecha = fecha;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        hash += (fechaInicial != null ? fechaInicial.hashCode() : 0);
        hash += (fechaFinal != null ? fechaFinal.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (horaInicial != null ? horaInicial.hashCode() : 0);
        hash += (horaFinal != null ? horaFinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetHoraExtraAsistenciaPK)) {
            return false;
        }
        DetHoraExtraAsistenciaPK other = (DetHoraExtraAsistenciaPK) object;
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
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.horaInicial == null && other.horaInicial != null) || (this.horaInicial != null && !this.horaInicial.equals(other.horaInicial))) {
            return false;
        }
        if ((this.horaFinal == null && other.horaFinal != null) || (this.horaFinal != null && !this.horaFinal.equals(other.horaFinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetHoraExtraAsistenciaPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + ", fecha=" + fecha + ", horaInicial=" + horaInicial + ", horaFinal=" + horaFinal + " ]";
    }
    
}
