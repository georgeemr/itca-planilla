/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_HORA_EXTRA_ASISTENCIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetHoraExtraAsistencia.findAll", query = "SELECT d FROM DetHoraExtraAsistencia d"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByCodCia", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.detHoraExtraAsistenciaPK.codCia = :codCia"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByCodEmp", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.detHoraExtraAsistenciaPK.codEmp = :codEmp"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByFechaInicial", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.detHoraExtraAsistenciaPK.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByFechaFinal", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.detHoraExtraAsistenciaPK.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByFecha", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.detHoraExtraAsistenciaPK.fecha = :fecha"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByHoraInicial", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.detHoraExtraAsistenciaPK.horaInicial = :horaInicial"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByHoraFinal", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.detHoraExtraAsistenciaPK.horaFinal = :horaFinal"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByHoraExtra", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.horaExtra = :horaExtra"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByStatus", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.status = :status"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByCodDepto", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.codDepto = :codDepto"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByCodSucursal", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.codSucursal = :codSucursal"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByEstado", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.estado = :estado"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByActividad", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.actividad = :actividad"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByHoraNivel1", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.horaNivel1 = :horaNivel1"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByHoraNivel2", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.horaNivel2 = :horaNivel2"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByHoraNivel3", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.horaNivel3 = :horaNivel3"),
    @NamedQuery(name = "DetHoraExtraAsistencia.findByHoraAprobada", query = "SELECT d FROM DetHoraExtraAsistencia d WHERE d.horaAprobada = :horaAprobada")})
public class DetHoraExtraAsistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetHoraExtraAsistenciaPK detHoraExtraAsistenciaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_EXTRA", nullable = false, precision = 6, scale = 2)
    private BigDecimal horaExtra;
    @Size(max = 1)
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Size(max = 2)
    @Column(name = "COD_SUCURSAL", length = 2)
    private String codSucursal;
    @Size(max = 1)
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @Size(max = 100)
    @Column(name = "ACTIVIDAD", length = 100)
    private String actividad;
    @Column(name = "HORA_NIVEL1", precision = 6, scale = 2)
    private BigDecimal horaNivel1;
    @Column(name = "HORA_NIVEL2", precision = 6, scale = 2)
    private BigDecimal horaNivel2;
    @Column(name = "HORA_NIVEL3", precision = 6, scale = 2)
    private BigDecimal horaNivel3;
    @Column(name = "HORA_APROBADA", precision = 6, scale = 2)
    private BigDecimal horaAprobada;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "FECHA_INICIAL", referencedColumnName = "FECHA_INICIAL", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "FECHA_FINAL", referencedColumnName = "FECHA_FINAL", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private DetAsistencia detAsistencia;

    public DetHoraExtraAsistencia() {
    }

    public DetHoraExtraAsistencia(DetHoraExtraAsistenciaPK detHoraExtraAsistenciaPK) {
        this.detHoraExtraAsistenciaPK = detHoraExtraAsistenciaPK;
    }

    public DetHoraExtraAsistencia(DetHoraExtraAsistenciaPK detHoraExtraAsistenciaPK, BigDecimal horaExtra) {
        this.detHoraExtraAsistenciaPK = detHoraExtraAsistenciaPK;
        this.horaExtra = horaExtra;
    }

    public DetHoraExtraAsistencia(short codCia, int codEmp, Date fechaInicial, Date fechaFinal, Date fecha, Date horaInicial, Date horaFinal) {
        this.detHoraExtraAsistenciaPK = new DetHoraExtraAsistenciaPK(codCia, codEmp, fechaInicial, fechaFinal, fecha, horaInicial, horaFinal);
    }

    public DetHoraExtraAsistenciaPK getDetHoraExtraAsistenciaPK() {
        return detHoraExtraAsistenciaPK;
    }

    public void setDetHoraExtraAsistenciaPK(DetHoraExtraAsistenciaPK detHoraExtraAsistenciaPK) {
        this.detHoraExtraAsistenciaPK = detHoraExtraAsistenciaPK;
    }

    public BigDecimal getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(BigDecimal horaExtra) {
        this.horaExtra = horaExtra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public BigDecimal getHoraNivel1() {
        return horaNivel1;
    }

    public void setHoraNivel1(BigDecimal horaNivel1) {
        this.horaNivel1 = horaNivel1;
    }

    public BigDecimal getHoraNivel2() {
        return horaNivel2;
    }

    public void setHoraNivel2(BigDecimal horaNivel2) {
        this.horaNivel2 = horaNivel2;
    }

    public BigDecimal getHoraNivel3() {
        return horaNivel3;
    }

    public void setHoraNivel3(BigDecimal horaNivel3) {
        this.horaNivel3 = horaNivel3;
    }

    public BigDecimal getHoraAprobada() {
        return horaAprobada;
    }

    public void setHoraAprobada(BigDecimal horaAprobada) {
        this.horaAprobada = horaAprobada;
    }

    public DetAsistencia getDetAsistencia() {
        return detAsistencia;
    }

    public void setDetAsistencia(DetAsistencia detAsistencia) {
        this.detAsistencia = detAsistencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detHoraExtraAsistenciaPK != null ? detHoraExtraAsistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetHoraExtraAsistencia)) {
            return false;
        }
        DetHoraExtraAsistencia other = (DetHoraExtraAsistencia) object;
        if ((this.detHoraExtraAsistenciaPK == null && other.detHoraExtraAsistenciaPK != null) || (this.detHoraExtraAsistenciaPK != null && !this.detHoraExtraAsistenciaPK.equals(other.detHoraExtraAsistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetHoraExtraAsistencia[ detHoraExtraAsistenciaPK=" + detHoraExtraAsistenciaPK + " ]";
    }
    
}
