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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "AccionPersonal.findByAnio", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.anio = :anio"),
    @NamedQuery(name = "AccionPersonal.findByMes", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.mes = :mes"),
    @NamedQuery(name = "AccionPersonal.findByNumPlanilla", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "AccionPersonal.findByIdSucursal", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "AccionPersonal.findByIdEmpleado", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "AccionPersonal.findByIdTipoPuesto", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.idTipoPuesto = :idTipoPuesto"),
    @NamedQuery(name = "AccionPersonal.findByIdPuesto", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.idPuesto = :idPuesto"),
    @NamedQuery(name = "AccionPersonal.findByCodTipoaccion", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.codTipoaccion = :codTipoaccion"),
    @NamedQuery(name = "AccionPersonal.findByCorrelativo", query = "SELECT a FROM AccionPersonal a WHERE a.accionPersonalPK.correlativo = :correlativo"),
    @NamedQuery(name = "AccionPersonal.findByFecha", query = "SELECT a FROM AccionPersonal a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AccionPersonal.findByCantidad", query = "SELECT a FROM AccionPersonal a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "AccionPersonal.findByObservacion", query = "SELECT a FROM AccionPersonal a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AccionPersonal.findByPeriodo", query = "SELECT a FROM AccionPersonal a WHERE a.periodo = :periodo"),
    @NamedQuery(name = "AccionPersonal.findByFechaInicial", query = "SELECT a FROM AccionPersonal a WHERE a.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "AccionPersonal.findByFechaFinal", query = "SELECT a FROM AccionPersonal a WHERE a.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "AccionPersonal.findByDevengadas", query = "SELECT a FROM AccionPersonal a WHERE a.devengadas = :devengadas"),
    @NamedQuery(name = "AccionPersonal.findByDias", query = "SELECT a FROM AccionPersonal a WHERE a.dias = :dias"),
    @NamedQuery(name = "AccionPersonal.findByHoras", query = "SELECT a FROM AccionPersonal a WHERE a.horas = :horas"),
    @NamedQuery(name = "AccionPersonal.findByPeriodoFinal", query = "SELECT a FROM AccionPersonal a WHERE a.periodoFinal = :periodoFinal"),
    @NamedQuery(name = "AccionPersonal.findBySueldoAnterior", query = "SELECT a FROM AccionPersonal a WHERE a.sueldoAnterior = :sueldoAnterior"),
    @NamedQuery(name = "AccionPersonal.findByStatus", query = "SELECT a FROM AccionPersonal a WHERE a.status = :status"),
    @NamedQuery(name = "AccionPersonal.findByFechaCanje", query = "SELECT a FROM AccionPersonal a WHERE a.fechaCanje = :fechaCanje"),
    @NamedQuery(name = "AccionPersonal.findByCodTiporetiro", query = "SELECT a FROM AccionPersonal a WHERE a.codTiporetiro = :codTiporetiro"),
    @NamedQuery(name = "AccionPersonal.findByTipoPermiso", query = "SELECT a FROM AccionPersonal a WHERE a.tipoPermiso = :tipoPermiso")
})
public class AccionPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccionPersonalPK accionPersonalPK;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "CANTIDAD", precision = 12, scale = 2)
    private BigDecimal cantidad;
    @Size(max = 200)
    @Column(name = "OBSERVACION", length = 200)
    private String observacion;
    @Column(name = "PERIODO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodo;
    @Column(name = "FECHA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Size(max = 200)
    @Column(name = "DEVENGADAS", length = 200)
    private String devengadas;
    @Column(name = "DIAS")
    private Long dias;
    @Column(name = "HORAS")
    private Long horas;
    @Column(name = "PERIODO_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodoFinal;
    @Column(name = "SUELDO_ANTERIOR")
    private Long sueldoAnterior;
    @Size(max = 100)
    @Column(name = "STATUS", length = 100)
    private String status;
    @Column(name = "FECHA_CANJE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCanje;
    @Column(name = "COD_TIPORETIRO")
    private Long codTiporetiro;
    @Size(max = 108)
    @Column(name = "TIPO_PERMISO", length = 108)
    private String tipoPermiso;
    @Column(name = "APROBADO_JEFE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aprobadoJefe;
    @Column(name = "APROBADO_RH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aprobadoRh;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOACCION", referencedColumnName = "COD_TIPOACCION", nullable = false, insertable = false, updatable = false)
    })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoAccion tipoAccion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_TIPO_PUESTO", referencedColumnName = "ID_TIPO_PUESTO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_PUESTO", referencedColumnName = "ID_PUESTO", nullable = false, insertable = false, updatable = false)
    })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PuestoEmpleado puestoEmpleado;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTONUEVO", referencedColumnName = "COD_PUESTO")
    })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Puesto puesto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "MES", referencedColumnName = "MES", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NUM_PLANILLA", referencedColumnName = "NUM_PLANILLA", nullable = false, insertable = false, updatable = false)
    })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Planilla planilla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_JEFE", referencedColumnName = "COD_EMP")
    })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;

    public AccionPersonal() {
    }

    public AccionPersonal(AccionPersonalPK accionPersonalPK) {
        this.accionPersonalPK = accionPersonalPK;
    }

    public AccionPersonal(long codCia, long anio, long mes, long numPlanilla, long idSucursal, long idEmpleado, long idTipoPuesto, long idPuesto, long codTipoaccion, long correlativo) {
        this.accionPersonalPK = new AccionPersonalPK(codCia, anio, mes, numPlanilla, idSucursal, idEmpleado, idTipoPuesto, idPuesto, codTipoaccion, correlativo);
    }

    public AccionPersonalPK getAccionPersonalPK() {
        return accionPersonalPK;
    }

    public void setAccionPersonalPK(AccionPersonalPK accionPersonalPK) {
        this.accionPersonalPK = accionPersonalPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
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

    public Long getDias() {
        return dias;
    }

    public void setDias(Long dias) {
        this.dias = dias;
    }

    public Long getHoras() {
        return horas;
    }

    public void setHoras(Long horas) {
        this.horas = horas;
    }

    public Date getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(Date periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public Long getSueldoAnterior() {
        return sueldoAnterior;
    }

    public void setSueldoAnterior(Long sueldoAnterior) {
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

    public Long getCodTiporetiro() {
        return codTiporetiro;
    }

    public void setCodTiporetiro(Long codTiporetiro) {
        this.codTiporetiro = codTiporetiro;
    }

    public String getTipoPermiso() {
        return tipoPermiso;
    }

    public void setTipoPermiso(String tipoPermiso) {
        this.tipoPermiso = tipoPermiso;
    }

    public TipoAccion getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(TipoAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public PuestoEmpleado getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(PuestoEmpleado puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
}
