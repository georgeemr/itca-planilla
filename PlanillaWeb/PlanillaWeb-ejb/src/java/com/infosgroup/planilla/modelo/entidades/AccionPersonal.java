/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ACCION_PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccionPersonal.findAll", query = "SELECT a FROM AccionPersonal a"),
    @NamedQuery(name = "AccionPersonal.findByCodCia", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.codCia = :codCia"),
    @NamedQuery(name = "AccionPersonal.findByCodEmp", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.codEmp = :codEmp"),
    @NamedQuery(name = "AccionPersonal.findByCodTipoaccion", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.codTipoaccion = :codTipoaccion"),
    @NamedQuery(name = "AccionPersonal.findByCorrelativo", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.correlativo = :correlativo"),
    @NamedQuery(name = "AccionPersonal.findByAnio", query = "SELECT a FROM AccionPersonal a WHERE a.anio = :anio"),
    @NamedQuery(name = "AccionPersonal.findByMes", query = "SELECT a FROM AccionPersonal a WHERE a.mes = :mes"),
    @NamedQuery(name = "AccionPersonal.findByNumPlanilla", query = "SELECT a FROM AccionPersonal a WHERE a.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "AccionPersonal.findByFecha", query = "SELECT a FROM AccionPersonal a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AccionPersonal.findByCantidad", query = "SELECT a FROM AccionPersonal a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "AccionPersonal.findByObservacion", query = "SELECT a FROM AccionPersonal a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AccionPersonal.findByCodJefe", query = "SELECT a FROM AccionPersonal a WHERE a.codJefe = :codJefe"),
    @NamedQuery(name = "AccionPersonal.findByCodDepto", query = "SELECT a FROM AccionPersonal a WHERE a.codDepto = :codDepto"),
    @NamedQuery(name = "AccionPersonal.findByPeriodo", query = "SELECT a FROM AccionPersonal a WHERE a.periodo = :periodo"),
    @NamedQuery(name = "AccionPersonal.findByFechaInicial", query = "SELECT a FROM AccionPersonal a WHERE a.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "AccionPersonal.findByFechaFinal", query = "SELECT a FROM AccionPersonal a WHERE a.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "AccionPersonal.findByDevengadas", query = "SELECT a FROM AccionPersonal a WHERE a.devengadas = :devengadas"),
    @NamedQuery(name = "AccionPersonal.findByCodTipopla", query = "SELECT a FROM AccionPersonal a WHERE a.codTipopla = :codTipopla"),
    @NamedQuery(name = "AccionPersonal.findByCodPuesto", query = "SELECT a FROM AccionPersonal a WHERE a.codPuesto = :codPuesto"),
    @NamedQuery(name = "AccionPersonal.findByCodPosicion", query = "SELECT a FROM AccionPersonal a WHERE a.codPosicion = :codPosicion"),
    @NamedQuery(name = "AccionPersonal.findByCodDeptoNuevo", query = "SELECT a FROM AccionPersonal a WHERE a.codDeptoNuevo = :codDeptoNuevo"),
    @NamedQuery(name = "AccionPersonal.findByDias", query = "SELECT a FROM AccionPersonal a WHERE a.dias = :dias"),
    @NamedQuery(name = "AccionPersonal.findByHoras", query = "SELECT a FROM AccionPersonal a WHERE a.horas = :horas"),
    @NamedQuery(name = "AccionPersonal.findByPeriodoFinal", query = "SELECT a FROM AccionPersonal a WHERE a.periodoFinal = :periodoFinal"),
    @NamedQuery(name = "AccionPersonal.findBySueldoAnterior", query = "SELECT a FROM AccionPersonal a WHERE a.sueldoAnterior = :sueldoAnterior"),
    @NamedQuery(name = "AccionPersonal.findByStatus", query = "SELECT a FROM AccionPersonal a WHERE a.status = :status"),
    @NamedQuery(name = "AccionPersonal.findByFechaCanje", query = "SELECT a FROM AccionPersonal a WHERE a.fechaCanje = :fechaCanje"),
    @NamedQuery(name = "AccionPersonal.findByCodTiporetiro", query = "SELECT a FROM AccionPersonal a WHERE a.codTiporetiro = :codTiporetiro"),
    @NamedQuery(name = "AccionPersonal.findByCodPuestoNuevo", query = "SELECT a FROM AccionPersonal a WHERE a.codPuestoNuevo = :codPuestoNuevo")})
public class AccionPersonal implements Serializable {

    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "PERIODO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodo;
    @Column(name = "FECHA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Column(name = "PERIODO_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodoFinal;
    @Column(name = "FECHA_CANJE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCanje;
    @Column(name = "APROBADO_JEFE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aprobadoJefe;
    @Column(name = "APROBADO_RH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aprobadoRh;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO_NUEVO", referencedColumnName = "COD_PUESTO")})
    @ManyToOne(optional = false)
    private Puestos puestosNuevo;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO")})
    @ManyToOne(optional = false)
    private Puestos puestos;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccionPersonalPK accionPersonalPK;
    @Column(name = "ANIO")
    private Short anio;
    @Column(name = "MES")
    private Short mes;
    @Column(name = "NUM_PLANILLA")
    private Short numPlanilla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD", precision = 12, scale = 2)
    private BigDecimal cantidad;
    @Column(name = "OBSERVACION", length = 500)
    private String observacion;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "DEVENGADAS", length = 1)
    private String devengadas;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @Column(name = "COD_PUESTO")
    private Short codPuesto;
    @Column(name = "COD_POSICION")
    private Short codPosicion;
    @Column(name = "COD_DEPTO_NUEVO")
    private Short codDeptoNuevo;
    @Column(name = "DIAS", precision = 5, scale = 2)
    private BigDecimal dias;
    @Column(name = "HORAS")
    private Short horas;
    @Column(name = "SUELDO_ANTERIOR", precision = 12, scale = 2)
    private BigDecimal sueldoAnterior;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "COD_TIPORETIRO")
    private Short codTiporetiro;
    @Column(name = "COD_PUESTO_NUEVO")
    private Short codPuestoNuevo;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOACCION", referencedColumnName = "COD_TIPOACCION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoAccion tipoAccion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_JEFE", referencedColumnName = "COD_EMP")})
    @ManyToOne(optional = false)
    private Empleados jefe;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA"),
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO"),
        @JoinColumn(name = "MES", referencedColumnName = "MES"),
        @JoinColumn(name = "NUM_PLANILLA", referencedColumnName = "NUM_PLANILLA"),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Planilla planilla;
    
    public AccionPersonal() {
    }

    public AccionPersonal(AccionPersonalPK accionPersonalPK) {
        this.accionPersonalPK = accionPersonalPK;
    }

    public AccionPersonal(short codCia, int codEmp, short codTipoaccion, int correlativo) {
        this.accionPersonalPK = new AccionPersonalPK(codCia, codEmp, codTipoaccion, correlativo);
    }

    public AccionPersonalPK getAccionPersonalPK() {
        return accionPersonalPK;
    }

    public void setAccionPersonalPK(AccionPersonalPK accionPersonalPK) {
        this.accionPersonalPK = accionPersonalPK;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public Short getMes() {
        return mes;
    }

    public void setMes(Short mes) {
        this.mes = mes;
    }

    public Short getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(Short numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
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

    public String getDevengadas() {
        return devengadas;
    }

    public void setDevengadas(String devengadas) {
        this.devengadas = devengadas;
    }

    public Short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(Short codTipopla) {
        this.codTipopla = codTipopla;
    }

    public Short getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(Short codPuesto) {
        this.codPuesto = codPuesto;
    }

    public Short getCodPosicion() {
        return codPosicion;
    }

    public void setCodPosicion(Short codPosicion) {
        this.codPosicion = codPosicion;
    }

    public Short getCodDeptoNuevo() {
        return codDeptoNuevo;
    }

    public void setCodDeptoNuevo(Short codDeptoNuevo) {
        this.codDeptoNuevo = codDeptoNuevo;
    }

    public BigDecimal getDias() {
        return dias;
    }

    public void setDias(BigDecimal dias) {
        this.dias = dias;
    }

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    public Date getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(Date periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public BigDecimal getSueldoAnterior() {
        return sueldoAnterior;
    }

    public void setSueldoAnterior(BigDecimal sueldoAnterior) {
        this.sueldoAnterior = sueldoAnterior;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechaCanje() {
        return fechaCanje;
    }

    public void setFechaCanje(Date fechaCanje) {
        this.fechaCanje = fechaCanje;
    }

    public Short getCodTiporetiro() {
        return codTiporetiro;
    }

    public void setCodTiporetiro(Short codTiporetiro) {
        this.codTiporetiro = codTiporetiro;
    }

    public Short getCodPuestoNuevo() {
        return codPuestoNuevo;
    }

    public void setCodPuestoNuevo(Short codPuestoNuevo) {
        this.codPuestoNuevo = codPuestoNuevo;
    }

    public TipoAccion getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(TipoAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
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
        hash += (accionPersonalPK != null ? accionPersonalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccionPersonal)) {
            return false;
        }
        AccionPersonal other = (AccionPersonal) object;
        if ((this.accionPersonalPK == null && other.accionPersonalPK != null) || (this.accionPersonalPK != null && !this.accionPersonalPK.equals(other.accionPersonalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.AccionPersonal[ accionPersonalPK=" + accionPersonalPK + " ]";
    }

    public Date getAprobadoJefe() {
        return aprobadoJefe;
    }

    public void setAprobadoJefe(Date aprobadoJefe) {
        this.aprobadoJefe = aprobadoJefe;
    }

    public Date getAprobadoRh() {
        return aprobadoRh;
    }

    public void setAprobadoRh(Date aprobadoRh) {
        this.aprobadoRh = aprobadoRh;
    }

    public Puestos getPuestosNuevo() {
        return puestosNuevo;
    }

    public void setPuestosNuevo(Puestos puestosNuevo) {
        this.puestosNuevo = puestosNuevo;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public Empleados getJefe() {
        return jefe;
    }

    public void setJefe(Empleados jefe) {
        this.jefe = jefe;
    }
    @Transient
    private String accEstado;

    public String getAccEstado() {
        if (getStatus().matches("G")) {
            accEstado = "Solicitada";
        } else {
            if (getStatus().matches("J")) {
                accEstado = "pre-Aprobada";
            } else {
                if (getStatus().matches("R")) {
                    accEstado = "Rechazada";
                } else {
                    accEstado = "Aprobada";
                }
            }
        }
        return accEstado;
    }

    public void setAccEstado(String accEstado) {
        this.accEstado = accEstado;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }
    
}