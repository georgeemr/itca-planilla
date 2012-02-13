/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_ASISTENCIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetAsistencia.findAll", query = "SELECT d FROM DetAsistencia d"),
    @NamedQuery(name = "DetAsistencia.findByCodCia", query = "SELECT d FROM DetAsistencia d WHERE d.detAsistenciaPK.codCia = :codCia"),
    @NamedQuery(name = "DetAsistencia.findByCodEmp", query = "SELECT d FROM DetAsistencia d WHERE d.detAsistenciaPK.codEmp = :codEmp"),
    @NamedQuery(name = "DetAsistencia.findByFechaInicial", query = "SELECT d FROM DetAsistencia d WHERE d.detAsistenciaPK.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "DetAsistencia.findByFechaFinal", query = "SELECT d FROM DetAsistencia d WHERE d.detAsistenciaPK.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "DetAsistencia.findByDLaborados", query = "SELECT d FROM DetAsistencia d WHERE d.dLaborados = :dLaborados"),
    @NamedQuery(name = "DetAsistencia.findByDnLaborados", query = "SELECT d FROM DetAsistencia d WHERE d.dnLaborados = :dnLaborados"),
    @NamedQuery(name = "DetAsistencia.findByDNocturnidad", query = "SELECT d FROM DetAsistencia d WHERE d.dNocturnidad = :dNocturnidad"),
    @NamedQuery(name = "DetAsistencia.findByViaticos", query = "SELECT d FROM DetAsistencia d WHERE d.viaticos = :viaticos"),
    @NamedQuery(name = "DetAsistencia.findByHXsencillas", query = "SELECT d FROM DetAsistencia d WHERE d.hXsencillas = :hXsencillas"),
    @NamedQuery(name = "DetAsistencia.findByHXdobles", query = "SELECT d FROM DetAsistencia d WHERE d.hXdobles = :hXdobles"),
    @NamedQuery(name = "DetAsistencia.findByHXf150", query = "SELECT d FROM DetAsistencia d WHERE d.hXf150 = :hXf150"),
    @NamedQuery(name = "DetAsistencia.findByHXf250", query = "SELECT d FROM DetAsistencia d WHERE d.hXf250 = :hXf250"),
    @NamedQuery(name = "DetAsistencia.findByStatus", query = "SELECT d FROM DetAsistencia d WHERE d.status = :status"),
    @NamedQuery(name = "DetAsistencia.findByCodDepto", query = "SELECT d FROM DetAsistencia d WHERE d.codDepto = :codDepto"),
    @NamedQuery(name = "DetAsistencia.findByCodSucursal", query = "SELECT d FROM DetAsistencia d WHERE d.codSucursal = :codSucursal"),
    @NamedQuery(name = "DetAsistencia.findByEstado", query = "SELECT d FROM DetAsistencia d WHERE d.estado = :estado")})
public class DetAsistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetAsistenciaPK detAsistenciaPK;
    @Basic(optional = false)
    @Column(name = "D_LABORADOS", nullable = false)
    private short dLaborados;
    @Column(name = "DN_LABORADOS")
    private Short dnLaborados;
    @Column(name = "D_NOCTURNIDAD")
    private Short dNocturnidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VIATICOS", precision = 8, scale = 2)
    private BigDecimal viaticos;
    @Column(name = "H_XSENCILLAS", precision = 6, scale = 2)
    private BigDecimal hXsencillas;
    @Column(name = "H_XDOBLES", precision = 6, scale = 2)
    private BigDecimal hXdobles;
    @Column(name = "H_XF150", precision = 6, scale = 2)
    private BigDecimal hXf150;
    @Column(name = "H_XF250", precision = 6, scale = 2)
    private BigDecimal hXf250;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "COD_SUCURSAL", length = 2)
    private String codSucursal;
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detAsistencia")
    private List<DetHoraExtraAsistencia> detHoraExtraAsistenciaList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public DetAsistencia() {
    }

    public DetAsistencia(DetAsistenciaPK detAsistenciaPK) {
        this.detAsistenciaPK = detAsistenciaPK;
    }

    public DetAsistencia(DetAsistenciaPK detAsistenciaPK, short dLaborados) {
        this.detAsistenciaPK = detAsistenciaPK;
        this.dLaborados = dLaborados;
    }

    public DetAsistencia(short codCia, int codEmp, Date fechaInicial, Date fechaFinal) {
        this.detAsistenciaPK = new DetAsistenciaPK(codCia, codEmp, fechaInicial, fechaFinal);
    }

    public DetAsistenciaPK getDetAsistenciaPK() {
        return detAsistenciaPK;
    }

    public void setDetAsistenciaPK(DetAsistenciaPK detAsistenciaPK) {
        this.detAsistenciaPK = detAsistenciaPK;
    }

    public short getDLaborados() {
        return dLaborados;
    }

    public void setDLaborados(short dLaborados) {
        this.dLaborados = dLaborados;
    }

    public Short getDnLaborados() {
        return dnLaborados;
    }

    public void setDnLaborados(Short dnLaborados) {
        this.dnLaborados = dnLaborados;
    }

    public Short getDNocturnidad() {
        return dNocturnidad;
    }

    public void setDNocturnidad(Short dNocturnidad) {
        this.dNocturnidad = dNocturnidad;
    }

    public BigDecimal getViaticos() {
        return viaticos;
    }

    public void setViaticos(BigDecimal viaticos) {
        this.viaticos = viaticos;
    }

    public BigDecimal getHXsencillas() {
        return hXsencillas;
    }

    public void setHXsencillas(BigDecimal hXsencillas) {
        this.hXsencillas = hXsencillas;
    }

    public BigDecimal getHXdobles() {
        return hXdobles;
    }

    public void setHXdobles(BigDecimal hXdobles) {
        this.hXdobles = hXdobles;
    }

    public BigDecimal getHXf150() {
        return hXf150;
    }

    public void setHXf150(BigDecimal hXf150) {
        this.hXf150 = hXf150;
    }

    public BigDecimal getHXf250() {
        return hXf250;
    }

    public void setHXf250(BigDecimal hXf250) {
        this.hXf250 = hXf250;
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

    @XmlTransient
    public List<DetHoraExtraAsistencia> getDetHoraExtraAsistenciaList() {
        return detHoraExtraAsistenciaList;
    }

    public void setDetHoraExtraAsistenciaList(List<DetHoraExtraAsistencia> detHoraExtraAsistenciaList) {
        this.detHoraExtraAsistenciaList = detHoraExtraAsistenciaList;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detAsistenciaPK != null ? detAsistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetAsistencia)) {
            return false;
        }
        DetAsistencia other = (DetAsistencia) object;
        if ((this.detAsistenciaPK == null && other.detAsistenciaPK != null) || (this.detAsistenciaPK != null && !this.detAsistenciaPK.equals(other.detAsistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetAsistencia[ detAsistenciaPK=" + detAsistenciaPK + " ]";
    }
    
}
