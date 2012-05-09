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
@Table(name = "ACCION_PERSONAL", catalog = "", schema = "PLANILLA")
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
    @NamedQuery(name = "AccionPersonal.findByPeriodo", query = "SELECT a FROM AccionPersonal a WHERE a.periodo = :periodo"),
    @NamedQuery(name = "AccionPersonal.findByFechaInicial", query = "SELECT a FROM AccionPersonal a WHERE a.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "AccionPersonal.findByFechaFinal", query = "SELECT a FROM AccionPersonal a WHERE a.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "AccionPersonal.findByDevengadas", query = "SELECT a FROM AccionPersonal a WHERE a.devengadas = :devengadas"),
    @NamedQuery(name = "AccionPersonal.findByCodTipopla", query = "SELECT a FROM AccionPersonal a WHERE a.codTipopla = :codTipopla"),
    @NamedQuery(name = "AccionPersonal.findByDias", query = "SELECT a FROM AccionPersonal a WHERE a.dias = :dias"),
    @NamedQuery(name = "AccionPersonal.findByHoras", query = "SELECT a FROM AccionPersonal a WHERE a.horas = :horas"),
    @NamedQuery(name = "AccionPersonal.findByPeriodoFinal", query = "SELECT a FROM AccionPersonal a WHERE a.periodoFinal = :periodoFinal"),
    @NamedQuery(name = "AccionPersonal.findBySueldoAnterior", query = "SELECT a FROM AccionPersonal a WHERE a.sueldoAnterior = :sueldoAnterior"),
    @NamedQuery(name = "AccionPersonal.findByStatus", query = "SELECT a FROM AccionPersonal a WHERE a.status = :status"),
    @NamedQuery(name = "AccionPersonal.findByFechaCanje", query = "SELECT a FROM AccionPersonal a WHERE a.fechaCanje = :fechaCanje"),
    @NamedQuery(name = "AccionPersonal.findByTipoIngreso", query = "SELECT a FROM AccionPersonal a WHERE a.tipoIngreso = :tipoIngreso"),
    @NamedQuery(name = "AccionPersonal.findByAprobadoJefe", query = "SELECT a FROM AccionPersonal a WHERE a.aprobadoJefe = :aprobadoJefe"),
    @NamedQuery(name = "AccionPersonal.findByAprobadoRh", query = "SELECT a FROM AccionPersonal a WHERE a.aprobadoRh = :aprobadoRh")})
public class AccionPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccionPersonalPK accionPersonalPK;
    @Column(name = "ANIO")
    private Short anio;
    @Column(name = "MES")
    private Short mes;
    @Column(name = "NUM_PLANILLA")
    private Short numPlanilla;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD", precision = 12, scale = 2)
    private BigDecimal cantidad;
    @Column(name = "PORCENTAJE", precision = 11, scale = 2)
    private BigDecimal porcentaje;
    @Size(max = 500)
    @Column(name = "OBSERVACION", length = 500)
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
    @Size(max = 1)
    @Column(name = "DEVENGADAS", length = 1)
    private String devengadas;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @Column(name = "DIAS")
    private Double dias;
    @Column(name = "HORAS")
    private Short horas;
    @Column(name = "PERIODO_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodoFinal;
    @Column(name = "SUELDO_ANTERIOR", precision = 12, scale = 2)
    private BigDecimal sueldoAnterior;
    @Size(max = 1)
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "FECHA_CANJE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCanje;
    @Column(name = "TIPO_INGRESO")
    private Short tipoIngreso;
    @Column(name = "F_APRUEBA_JEFE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fApruebaJefe;
    @Column(name = "F_APRUEBA_RH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fApruebaRh;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOACCION", referencedColumnName = "COD_TIPOACCION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoAccion tipoAccion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO")})
    @ManyToOne(optional = false)
    private Puestos puestos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO_NUEVO", referencedColumnName = "COD_PUESTO")})
    @ManyToOne(optional = false)
    private Puestos nuevoPuesto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_POSICION", referencedColumnName = "COD_POSICION")})
    @ManyToOne(optional = false)
    private Posicion posicion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleados empleados;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_JEFE", referencedColumnName = "COD_EMP")})
    @ManyToOne(optional = false)
    private Empleados empleados1;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO")})
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO_NUEVO", referencedColumnName = "COD_DEPTO")})
    @ManyToOne(optional = false)
    private Departamentos nuevoDepartamento;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPORETIRO", referencedColumnName = "COD_TIPORENUNCIA")})
    @ManyToOne(optional = false)
    private CausasRenuncia causasRenuncia;
    @Size(max = 1)
    @Column(name = "APROBADO_JEFE", length = 1)
    private String aprobadoJefe;
    @Size(max = 1)
    @Column(name = "APROBADO_RH", length = 1)
    private String aprobadoRh;
    @Column(name = "MONTO", precision = 11, scale = 2)
    private BigDecimal monto;
    @Size(max = 50)
    @Column(name = "USUARIO_CREACION", length = 50)
    private String usuarioCreacion;
    @Transient
    private String accEstado;
    @Transient
    private String planillaToString;
    @Size(max = 1)
    @Column(name = "FORMA_AUMENTO", length = 1)
    private String formaAumento;
        
    public String getPlanillaToString() {
        planillaToString = "" + accionPersonalPK.getCodCia() + ":" + anio + ":" + mes + ":" + numPlanilla + ":" + codTipopla;
        return planillaToString;
    }

    public void setPlanillaToString(String planillaToString) {
        this.planillaToString = planillaToString;
    }
    
    public AccionPersonal() {
    }

    public String getAprobadoJefe() {
        return aprobadoJefe;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public void setAprobadoJefe(String aprobadoJefe) {
        this.aprobadoJefe = aprobadoJefe;
    }

    public String getAprobadoRh() {
        return aprobadoRh;
    }

    public void setAprobadoRh(String aprobadoRh) {
        this.aprobadoRh = aprobadoRh;
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

    public Short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(Short codTipopla) {
        this.codTipopla = codTipopla;
    }

    public Double getDias() {
        return dias;
    }

    public void setDias(Double dias) {
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public CausasRenuncia getCausasRenuncia() {
        return causasRenuncia;
    }

    public void setCausasRenuncia(CausasRenuncia causasRenuncia) {
        this.causasRenuncia = causasRenuncia;
    }

    public Short getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(Short tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public Date getfApruebaJefe() {
        return fApruebaJefe;
    }

    public void setfApruebaJefe(Date fApruebaJefe) {
        this.fApruebaJefe = fApruebaJefe;
    }

    public Date getfApruebaRh() {
        return fApruebaRh;
    }

    public void setfApruebaRh(Date fApruebaRh) {
        this.fApruebaRh = fApruebaRh;
    }

    public TipoAccion getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(TipoAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Empleados getEmpleados1() {
        return empleados1;
    }

    public void setEmpleados1(Empleados empleados1) {
        this.empleados1 = empleados1;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

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

    public Puestos getNuevoPuesto() {
        return nuevoPuesto;
    }

    public void setNuevoPuesto(Puestos nuevoPuesto) {
        this.nuevoPuesto = nuevoPuesto;
    }

    public Departamentos getNuevoDepartamento() {
        return nuevoDepartamento;
    }

    public void setNuevoDepartamento(Departamentos nuevoDepartamento) {
        this.nuevoDepartamento = nuevoDepartamento;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFormaAumento() {
        return formaAumento;
    }

    public void setFormaAumento(String formaAumento) {
        this.formaAumento = formaAumento;
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
}
