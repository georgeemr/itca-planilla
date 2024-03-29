/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "RESUMEN_ASISTENCIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResumenAsistencia.findAll", query = "SELECT r FROM ResumenAsistencia r"),
    @NamedQuery(name = "ResumenAsistencia.findByCodCia", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.codCia = :codCia"),
    @NamedQuery(name = "ResumenAsistencia.findByAnio", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.anio = :anio"),
    @NamedQuery(name = "ResumenAsistencia.findByMes", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.mes = :mes"),
    @NamedQuery(name = "ResumenAsistencia.findByNumPlanilla", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.numPlanilla = :numPlanilla"),
    //@NamedQuery(name = "ResumenAsistencia.findByCodEmp", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.codEmp = :codEmp"),
    @NamedQuery(name = "ResumenAsistencia.findByDLaborados", query = "SELECT r FROM ResumenAsistencia r WHERE r.dLaborados = :dLaborados"),
    @NamedQuery(name = "ResumenAsistencia.findByDnLaborados", query = "SELECT r FROM ResumenAsistencia r WHERE r.dnLaborados = :dnLaborados"),
    @NamedQuery(name = "ResumenAsistencia.findByHXsencillas", query = "SELECT r FROM ResumenAsistencia r WHERE r.hXsencillas = :hXsencillas"),
    @NamedQuery(name = "ResumenAsistencia.findByHXdobles", query = "SELECT r FROM ResumenAsistencia r WHERE r.hXdobles = :hXdobles"),
    @NamedQuery(name = "ResumenAsistencia.findByViaticos", query = "SELECT r FROM ResumenAsistencia r WHERE r.viaticos = :viaticos"),
    //@NamedQuery(name = "ResumenAsistencia.findByStatus", query = "SELECT r FROM ResumenAsistencia r WHERE r.status = :status"),
    //@NamedQuery(name = "ResumenAsistencia.findByCodTipopla", query = "SELECT r FROM ResumenAsistencia r WHERE r.resumenAsistenciaPK.codTipopla = :codTipopla"),
    @NamedQuery(name = "ResumenAsistencia.findByHXf250", query = "SELECT r FROM ResumenAsistencia r WHERE r.hXf250 = :hXf250"),
    @NamedQuery(name = "ResumenAsistencia.findByHHora", query = "SELECT r FROM ResumenAsistencia r WHERE r.hHora = :hHora"),
    @NamedQuery(name = "ResumenAsistencia.findByDAguinaldo", query = "SELECT r FROM ResumenAsistencia r WHERE r.dAguinaldo = :dAguinaldo"),
    @NamedQuery(name = "ResumenAsistencia.findByVacaciones", query = "SELECT r FROM ResumenAsistencia r WHERE r.vacaciones = :vacaciones"),
    @NamedQuery(name = "ResumenAsistencia.findByHXf150", query = "SELECT r FROM ResumenAsistencia r WHERE r.hXf150 = :hXf150"),
    //@NamedQuery(name = "ResumenAsistencia.findByCodDepto", query = "SELECT r FROM ResumenAsistencia r WHERE r.codDepto = :codDepto"),
    //@NamedQuery(name = "ResumenAsistencia.findByCodSucursal", query = "SELECT r FROM ResumenAsistencia r WHERE r.codSucursal = :codSucursal"),
    @NamedQuery(name = "ResumenAsistencia.findByOtros", query = "SELECT r FROM ResumenAsistencia r WHERE r.otros = :otros"),
    //@NamedQuery(name = "ResumenAsistencia.findByEstado", query = "SELECT r FROM ResumenAsistencia r WHERE r.estado = :estado"),
    @NamedQuery(name = "ResumenAsistencia.findByHorasAusencia", query = "SELECT r FROM ResumenAsistencia r WHERE r.horasAusencia = :horasAusencia"),
    @NamedQuery(name = "ResumenAsistencia.findByDNocturnidad", query = "SELECT r FROM ResumenAsistencia r WHERE r.dNocturnidad = :dNocturnidad")})
public class ResumenAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResumenAsistenciaPK resumenAsistenciaPK;
    @Basic(optional = false)
    @Column(name = "D_LABORADOS", nullable = false)
    private short dLaborados;
    @Column(name = "DN_LABORADOS")
    private Short dnLaborados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "H_XSENCILLAS", precision = 6, scale = 2)
    private BigDecimal hXsencillas;
    @Column(name = "H_XDOBLES", precision = 6, scale = 2)
    private BigDecimal hXdobles;
    @Column(name = "VIATICOS", precision = 8, scale = 2)
    private BigDecimal viaticos;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "H_XF250", precision = 6, scale = 2)
    private BigDecimal hXf250;
    @Column(name = "H_HORA", precision = 6, scale = 2)
    private BigDecimal hHora;
    @Column(name = "D_AGUINALDO")
    private Integer dAguinaldo;
    @Column(name = "VACACIONES", precision = 10, scale = 2)
    private BigDecimal vacaciones;
    @Column(name = "H_XF150")
    private Integer hXf150;
    @Column(name = "OTROS", precision = 12, scale = 2)
    private BigDecimal otros;
    @JoinColumn(name = "ESTADO", referencedColumnName = "COD_AUSEN")
    @ManyToOne
    private TipoAusent estado;
    @Column(name = "HORAS_AUSENCIA", precision = 6, scale = 2)
    private BigDecimal horasAusencia;
    @Column(name = "D_NOCTURNIDAD")
    private Short dNocturnidad;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_SUCURSAL", referencedColumnName = "COD_AGENCIA")})
    @ManyToOne(optional = false)
    private Agencias agencias;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO")})
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resumenAsistencia")
    private List<MovDp> movDpList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TiposPlanilla tiposPlanilla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;
    @Transient
    private Double valorTemp;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "resumenAsistencia")
    private Planilla planilla;

    public ResumenAsistencia() {
    }

    public ResumenAsistencia(ResumenAsistenciaPK resumenAsistenciaPK) {
        this.resumenAsistenciaPK = resumenAsistenciaPK;
    }

    public ResumenAsistencia(ResumenAsistenciaPK resumenAsistenciaPK, short dLaborados) {
        this.resumenAsistenciaPK = resumenAsistenciaPK;
        this.dLaborados = dLaborados;
    }

    public ResumenAsistencia(short codCia, short anio, short mes, short numPlanilla, int codEmp, short codTipopla) {
        this.resumenAsistenciaPK = new ResumenAsistenciaPK(codCia, anio, mes, numPlanilla, codEmp, codTipopla);
    }

    public ResumenAsistenciaPK getResumenAsistenciaPK() {
        return resumenAsistenciaPK;
    }

    public void setResumenAsistenciaPK(ResumenAsistenciaPK resumenAsistenciaPK) {
        this.resumenAsistenciaPK = resumenAsistenciaPK;
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

    public BigDecimal getViaticos() {
        return viaticos;
    }

    public void setViaticos(BigDecimal viaticos) {
        this.viaticos = viaticos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getHXf250() {
        return hXf250;
    }

    public void setHXf250(BigDecimal hXf250) {
        this.hXf250 = hXf250;
    }

    public BigDecimal getHHora() {
        return hHora;
    }

    public void setHHora(BigDecimal hHora) {
        this.hHora = hHora;
    }

    public Integer getDAguinaldo() {
        return dAguinaldo;
    }

    public void setDAguinaldo(Integer dAguinaldo) {
        this.dAguinaldo = dAguinaldo;
    }

    public BigDecimal getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(BigDecimal vacaciones) {
        this.vacaciones = vacaciones;
    }

    public Integer getHXf150() {
        return hXf150;
    }

    public void setHXf150(Integer hXf150) {
        this.hXf150 = hXf150;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public Agencias getAgencias() {
        return agencias;
    }

    public void setAgencias(Agencias agencias) {
        this.agencias = agencias;
    }

    public BigDecimal getOtros() {
        return otros;
    }

    public void setOtros(BigDecimal otros) {
        this.otros = otros;
    }

    public TipoAusent getEstado() {
        return estado;
    }

    public void setEstado(TipoAusent estado) {
        this.estado = estado;
    }

    public BigDecimal getHorasAusencia() {
        return horasAusencia;
    }

    public void setHorasAusencia(BigDecimal horasAusencia) {
        this.horasAusencia = horasAusencia;
    }

    public Short getDNocturnidad() {
        return dNocturnidad;
    }

    public void setDNocturnidad(Short dNocturnidad) {
        this.dNocturnidad = dNocturnidad;
    }

    @XmlTransient
    public List<MovDp> getMovDpList() {
        return movDpList;
    }

    public void setMovDpList(List<MovDp> movDpList) {
        this.movDpList = movDpList;
    }

    public TiposPlanilla getTiposPlanilla() {
        return tiposPlanilla;
    }

    public void setTiposPlanilla(TiposPlanilla tiposPlanilla) {
        this.tiposPlanilla = tiposPlanilla;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Double getValorTemp() {
        return valorTemp;
    }

    public void setValorTemp(Double valorTemp) {
        this.valorTemp = valorTemp;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resumenAsistenciaPK != null ? resumenAsistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumenAsistencia)) {
            return false;
        }
        ResumenAsistencia other = (ResumenAsistencia) object;
        if ((this.resumenAsistenciaPK == null && other.resumenAsistenciaPK != null) || (this.resumenAsistenciaPK != null && !this.resumenAsistenciaPK.equals(other.resumenAsistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ResumenAsistencia[ resumenAsistenciaPK=" + resumenAsistenciaPK + " ]";
    }
}
