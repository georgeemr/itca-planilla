/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EMPLEADOS", catalog = "", schema = "PLANILLA", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "USUARIO"
    })
})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByCodCia", query = "SELECT e FROM Empleados e WHERE e.empleadosPK.codCia = :codCia"),
    @NamedQuery(name = "Empleados.findByCodEmp", query = "SELECT e FROM Empleados e WHERE e.empleadosPK.codEmp = :codEmp"),
    @NamedQuery(name = "Empleados.findByApellidos", query = "SELECT e FROM Empleados e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleados.findByNombres", query = "SELECT e FROM Empleados e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleados.findByApCasada", query = "SELECT e FROM Empleados e WHERE e.apCasada = :apCasada"),
    @NamedQuery(name = "Empleados.findByDireccion", query = "SELECT e FROM Empleados e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleados.findByTelefonos", query = "SELECT e FROM Empleados e WHERE e.telefonos = :telefonos"),
    @NamedQuery(name = "Empleados.findByFechaNac", query = "SELECT e FROM Empleados e WHERE e.fechaNac = :fechaNac"),
    @NamedQuery(name = "Empleados.findByNumIgss", query = "SELECT e FROM Empleados e WHERE e.numIgss = :numIgss"),
    @NamedQuery(name = "Empleados.findByNumIrtra", query = "SELECT e FROM Empleados e WHERE e.numIrtra = :numIrtra"),
    @NamedQuery(name = "Empleados.findByNumNit", query = "SELECT e FROM Empleados e WHERE e.numNit = :numNit"),
    @NamedQuery(name = "Empleados.findByFecIngreso", query = "SELECT e FROM Empleados e WHERE e.fecIngreso = :fecIngreso"),
    @NamedQuery(name = "Empleados.findByFecSalida", query = "SELECT e FROM Empleados e WHERE e.fecSalida = :fecSalida"),
    @NamedQuery(name = "Empleados.findByMotSalida", query = "SELECT e FROM Empleados e WHERE e.motSalida = :motSalida"),
    @NamedQuery(name = "Empleados.findByObservacion", query = "SELECT e FROM Empleados e WHERE e.observacion = :observacion"),
    @NamedQuery(name = "Empleados.findByStatus", query = "SELECT e FROM Empleados e WHERE e.status = :status"),
    @NamedQuery(name = "Empleados.findByTipoContra", query = "SELECT e FROM Empleados e WHERE e.tipoContra = :tipoContra"),
    @NamedQuery(name = "Empleados.findBySalario", query = "SELECT e FROM Empleados e WHERE e.salario = :salario"),
    @NamedQuery(name = "Empleados.findByPromedio", query = "SELECT e FROM Empleados e WHERE e.promedio = :promedio"),
    @NamedQuery(name = "Empleados.findByBonificacion", query = "SELECT e FROM Empleados e WHERE e.bonificacion = :bonificacion"),
    @NamedQuery(name = "Empleados.findBySalarioBase", query = "SELECT e FROM Empleados e WHERE e.salarioBase = :salarioBase"),
    @NamedQuery(name = "Empleados.findByAvisarA", query = "SELECT e FROM Empleados e WHERE e.avisarA = :avisarA"),
    @NamedQuery(name = "Empleados.findByCedula", query = "SELECT e FROM Empleados e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Empleados.findByChequeDep", query = "SELECT e FROM Empleados e WHERE e.chequeDep = :chequeDep"),
    @NamedQuery(name = "Empleados.findByCtaBancaria", query = "SELECT e FROM Empleados e WHERE e.ctaBancaria = :ctaBancaria"),
    @NamedQuery(name = "Empleados.findByComSprod", query = "SELECT e FROM Empleados e WHERE e.comSprod = :comSprod"),
    @NamedQuery(name = "Empleados.findByComSobra", query = "SELECT e FROM Empleados e WHERE e.comSobra = :comSobra"),
    @NamedQuery(name = "Empleados.findByValIsr", query = "SELECT e FROM Empleados e WHERE e.valIsr = :valIsr"),
    @NamedQuery(name = "Empleados.findBySexo", query = "SELECT e FROM Empleados e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "Empleados.findByTipoCta", query = "SELECT e FROM Empleados e WHERE e.tipoCta = :tipoCta"),
    @NamedQuery(name = "Empleados.findByNupAfp", query = "SELECT e FROM Empleados e WHERE e.nupAfp = :nupAfp"),
    @NamedQuery(name = "Empleados.findByCodAfp", query = "SELECT e FROM Empleados e WHERE e.codAfp = :codAfp"),
    @NamedQuery(name = "Empleados.findByNumHijos", query = "SELECT e FROM Empleados e WHERE e.numHijos = :numHijos"),
    @NamedQuery(name = "Empleados.findByEstadoCivil", query = "SELECT e FROM Empleados e WHERE e.estadoCivil = :estadoCivil"),
//    @NamedQuery(name = "Empleados.findByCodEmpref", query = "SELECT e FROM Empleados e WHERE e.codEmpref = :codEmpref"),
    @NamedQuery(name = "Empleados.findByNombreIsss", query = "SELECT e FROM Empleados e WHERE e.nombreIsss = :nombreIsss"),
    @NamedQuery(name = "Empleados.findByConocidoPor", query = "SELECT e FROM Empleados e WHERE e.conocidoPor = :conocidoPor"),
    @NamedQuery(name = "Empleados.findByTitulo", query = "SELECT e FROM Empleados e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "Empleados.findByDomicilio", query = "SELECT e FROM Empleados e WHERE e.domicilio = :domicilio"),
    //@NamedQuery(name = "Empleados.findByDepartamento", query = "SELECT e FROM Empleados e WHERE e.departamento = :departamento"),
    @NamedQuery(name = "Empleados.findByLiquidacion", query = "SELECT e FROM Empleados e WHERE e.liquidacion = :liquidacion"),
    @NamedQuery(name = "Empleados.findByNombreRenta", query = "SELECT e FROM Empleados e WHERE e.nombreRenta = :nombreRenta"),
    @NamedQuery(name = "Empleados.findByHorario", query = "SELECT e FROM Empleados e WHERE e.horario = :horario"),
    @NamedQuery(name = "Empleados.findByAntipag", query = "SELECT e FROM Empleados e WHERE e.antipag = :antipag"),
    @NamedQuery(name = "Empleados.findByDui", query = "SELECT e FROM Empleados e WHERE e.dui = :dui"),
    @NamedQuery(name = "Empleados.findByComision", query = "SELECT e FROM Empleados e WHERE e.comision = :comision"),
    @NamedQuery(name = "Empleados.findByCodSeccion", query = "SELECT e FROM Empleados e WHERE e.codSeccion = :codSeccion"),
    @NamedQuery(name = "Empleados.findByLugarnacimiento", query = "SELECT e FROM Empleados e WHERE e.lugarnacimiento = :lugarnacimiento"),
    @NamedQuery(name = "Empleados.findByNumDui", query = "SELECT e FROM Empleados e WHERE e.numDui = :numDui"),
    @NamedQuery(name = "Empleados.findByFecha", query = "SELECT e FROM Empleados e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Empleados.findByCodEstudio", query = "SELECT e FROM Empleados e WHERE e.codEstudio = :codEstudio"),
    @NamedQuery(name = "Empleados.findByLugarDui", query = "SELECT e FROM Empleados e WHERE e.lugarDui = :lugarDui"),
    @NamedQuery(name = "Empleados.findByFechaDui", query = "SELECT e FROM Empleados e WHERE e.fechaDui = :fechaDui"),
    @NamedQuery(name = "Empleados.findByFecUltContrato", query = "SELECT e FROM Empleados e WHERE e.fecUltContrato = :fecUltContrato"),
    @NamedQuery(name = "Empleados.findByCodBanco", query = "SELECT e FROM Empleados e WHERE e.codBanco = :codBanco"),
    //@NamedQuery(name = "Empleados.findByCodSucursal", query = "SELECT e FROM Empleados e WHERE e.codSucursal = :codSucursal"),
    @NamedQuery(name = "Empleados.findByLicencia", query = "SELECT e FROM Empleados e WHERE e.licencia = :licencia"),
    @NamedQuery(name = "Empleados.findByActualizadoPor", query = "SELECT e FROM Empleados e WHERE e.actualizadoPor = :actualizadoPor"),
    @NamedQuery(name = "Empleados.findByUsuario", query = "SELECT e FROM Empleados e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "Empleados.findByNumTarjeta", query = "SELECT e FROM Empleados e WHERE e.numTarjeta = :numTarjeta"),
    @NamedQuery(name = "Empleados.findByFechaActualizacion", query = "SELECT e FROM Empleados e WHERE e.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Empleados.findByCodPais", query = "SELECT e FROM Empleados e WHERE e.codPais = :codPais"),
    @NamedQuery(name = "Empleados.findByCodDepar", query = "SELECT e FROM Empleados e WHERE e.codDepar = :codDepar"),
    @NamedQuery(name = "Empleados.findByCodMuni", query = "SELECT e FROM Empleados e WHERE e.codMuni = :codMuni"),
    @NamedQuery(name = "Empleados.findByOtras", query = "SELECT e FROM Empleados e WHERE e.otras = :otras"),
    @NamedQuery(name = "Empleados.findByCodArea", query = "SELECT e FROM Empleados e WHERE e.codArea = :codArea"),
    @NamedQuery(name = "Empleados.findByFechavac", query = "SELECT e FROM Empleados e WHERE e.fechavac = :fechavac"),
    @NamedQuery(name = "Empleados.findByFechavac2", query = "SELECT e FROM Empleados e WHERE e.fechavac2 = :fechavac2"),
    @NamedQuery(name = "Empleados.findByAnio", query = "SELECT e FROM Empleados e WHERE e.anio = :anio"),
    @NamedQuery(name = "Empleados.findByEstructura", query = "SELECT e FROM Empleados e WHERE e.estructura = :estructura"),
    @NamedQuery(name = "Empleados.findByCodObjeto", query = "SELECT e FROM Empleados e WHERE e.codObjeto = :codObjeto"),
    @NamedQuery(name = "Empleados.findByMarcaTarjeta", query = "SELECT e FROM Empleados e WHERE e.marcaTarjeta = :marcaTarjeta"),
    @NamedQuery(name = "Empleados.findByConcurso", query = "SELECT e FROM Empleados e WHERE e.concurso = :concurso"),
    @NamedQuery(name = "Empleados.findBySindicato", query = "SELECT e FROM Empleados e WHERE e.sindicato = :sindicato"),
    @NamedQuery(name = "Empleados.findByCodContratacion", query = "SELECT e FROM Empleados e WHERE e.codContratacion = :codContratacion"),
    @NamedQuery(name = "Empleados.findByDocente", query = "SELECT e FROM Empleados e WHERE e.docente = :docente"),
    @NamedQuery(name = "Empleados.findByCorreo", query = "SELECT e FROM Empleados e WHERE e.correo = :correo")
})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadosPK empleadosPK;
    @Column(name = "APELLIDOS", length = 60)
    private String apellidos;
    @Column(name = "NOMBRES", length = 30)
    private String nombres;
    @Column(name = "AP_CASADA", length = 20)
    private String apCasada;
    @Column(name = "DIRECCION", length = 120)
    private String direccion;
    @Column(name = "TELEFONOS", length = 30)
    private String telefonos;
    @Column(name = "FECHA_NAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @Column(name = "NUM_IGSS", length = 16)
    private String numIgss;
    @Column(name = "NUM_IRTRA", length = 12)
    private String numIrtra;
    @Column(name = "NUM_NIT", length = 20)
    private String numNit;
    @Column(name = "FEC_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    @Column(name = "FEC_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecSalida;
    @Column(name = "MOT_SALIDA", length = 250)
    private String motSalida;
    @Column(name = "OBSERVACION", length = 250)
    private String observacion;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "TIPO_CONTRA", length = 1)
    private String tipoContra;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO", precision = 16, scale = 2)
    private BigDecimal salario;
    @Column(name = "PROMEDIO", precision = 16, scale = 2)
    private BigDecimal promedio;
    @Column(name = "BONIFICACION", precision = 16, scale = 2)
    private BigDecimal bonificacion;
    @Column(name = "SALARIO_BASE", precision = 16, scale = 2)
    private BigDecimal salarioBase;
    @Column(name = "AVISAR_A", length = 250)
    private String avisarA;
    @Column(name = "CEDULA", length = 15)
    private String cedula;
    @Column(name = "CHEQUE_DEP", length = 1)
    private String chequeDep;
    @Column(name = "CTA_BANCARIA", length = 15)
    private String ctaBancaria;
    @Column(name = "COM_SPROD", length = 1)
    private String comSprod;
    @Column(name = "COM_SOBRA", length = 1)
    private String comSobra;
    @Column(name = "VAL_ISR", precision = 12, scale = 2)
    private BigDecimal valIsr;
    @Column(name = "SEXO")
    private Integer sexo;
    @Column(name = "TIPO_CTA", length = 2)
    private String tipoCta;
    @Column(name = "NUP_AFP", length = 20)
    private String nupAfp;
    @Column(name = "COD_AFP")
    private Integer codAfp;
    @Column(name = "NUM_HIJOS")
    private Short numHijos;
    @Column(name = "ESTADO_CIVIL", length = 1)
    private String estadoCivil;
//    @Column(name = "COD_EMPREF", length = 6)
//    private String codEmpref;
    @Column(name = "NOMBRE_ISSS", length = 100)
    private String nombreIsss;
    @Column(name = "CONOCIDO_POR", length = 100)
    private String conocidoPor;
    @Column(name = "TITULO", length = 100)
    private String titulo;
    @Column(name = "DOMICILIO", length = 100)
    private String domicilio;
//    @Column(name = "DEPARTAMENTO", length = 100)
//    private String departamento;
    @Column(name = "LIQUIDACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date liquidacion;
    @Column(name = "NOMBRE_RENTA", length = 100)
    private String nombreRenta;
    @Column(name = "HORARIO", length = 1)
    private String horario;
    @Column(name = "ANTIPAG", precision = 16, scale = 2)
    private BigDecimal antipag;
    @Column(name = "DUI", length = 30)
    private String dui;
    @Column(name = "COMISION", length = 1)
    private String comision;
    @Column(name = "COD_SECCION")
    private Short codSeccion;
    @Column(name = "LUGARNACIMIENTO", length = 100)
    private String lugarnacimiento;
    @Column(name = "NUM_DUI", length = 30)
    private String numDui;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "COD_ESTUDIO", length = 5)
    private String codEstudio;
    @Column(name = "LUGAR_DUI", length = 60)
    private String lugarDui;
    @Column(name = "FECHA_DUI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDui;
    @Column(name = "FEC_ULT_CONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltContrato;
    @Column(name = "COD_BANCO", length = 3)
    private String codBanco;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_SUCURSAL", referencedColumnName = "COD_AGENCIA")})
    @ManyToOne(optional = false)
    private Agencias agencias;
    @Column(name = "LICENCIA", length = 20)
    private String licencia;
    @Column(name = "ACTUALIZADO_POR", length = 20)
    private String actualizadoPor;
    @Column(name = "USUARIO", length = 20)
    private String usuario;
    @Column(name = "NUM_TARJETA", length = 8)
    private String numTarjeta;
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "COD_PAIS")
    private Short codPais;
    @Column(name = "COD_DEPAR")
    private Short codDepar;
    @Column(name = "COD_MUNI")
    private Short codMuni;
    @Column(name = "OTRAS", length = 100)
    private String otras;
    @Column(name = "COD_AREA")
    private BigInteger codArea;
    @Column(name = "FECHAVAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavac;
    @Column(name = "FECHAVAC2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavac2;
    @Column(name = "ANIO")
    private Short anio;
    @Column(name = "ESTRUCTURA", length = 20)
    private String estructura;
    @Column(name = "COD_OBJETO", length = 10)
    private String codObjeto;
    @Column(name = "MARCA_TARJETA", length = 1)
    private String marcaTarjeta;
    @Column(name = "CONCURSO", length = 1)
    private String concurso;
    @Column(name = "SINDICATO", length = 1)
    private String sindicato;
    @Column(name = "COD_CONTRATACION")
    private Short codContratacion;
    @Column(name = "DOCENTE", length = 1)
    private String docente;
    @Column(name = "CORREO", length = 150)
    private String correo;

    /*
     * @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados") private
     * List<Evaluacion> evaluacionList;
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados")
    private List<Planilla> planillaList;
    @JoinTable(name = "EVALUADOR_EVALUACIONES", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "EVALUADOR", referencedColumnName = "COD_EMP", nullable = false)
    }, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false),
        @JoinColumn(name = "CAMPANIA", referencedColumnName = "COD_CAMPANIA", nullable = false),
        @JoinColumn(name = "TIPO_EVALUACION", referencedColumnName = "TIPO_EVALUACION", nullable = false),
        @JoinColumn(name = "PLANTILLA", referencedColumnName = "PLANTILLA", nullable = false),
        @JoinColumn(name = "EMPLEADO", referencedColumnName = "COD_EMP", nullable = false)
    })
    @ManyToMany
    private List<Evaluacion> evaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados")
    private List<CapacitacionXEmpleado> capacitacionXEmpleadoList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA")
    })
    @ManyToOne(optional = false)
    private TiposPlanilla tiposPlanilla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO")
    })
    @ManyToOne(optional = false)
    private Puestos puestos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados")
    private List<Empleados> empleadosList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "JEFE", referencedColumnName = "COD_EMP")
    })
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO")
    })
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPORENUNCIA", referencedColumnName = "COD_TIPORENUNCIA")
    })
    @ManyToOne(optional = false)
    private CausasRenuncia causasRenuncia;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMPREF", referencedColumnName = "COD_EMP")
    })
    @ManyToOne(optional = false)
    private Empleados representantePatronal;
//    @Column(name = "COD_EMPREF")
//    private Integer representantePatronal;
    @Transient
    private String nombreCompleto;
    @Transient
    private String pkAsString;
    @Transient
    private String nombreYCodigo;

    public Empleados() {
    }

    public String getNombreYCodigo() {
        nombreYCodigo = String.format("%05d", empleadosPK.getCodEmp()) + "-" + getNombreCompleto();
        return nombreYCodigo;
    }

    public void setNombreYCodigo(String nombreYCodigo) {
        this.nombreYCodigo = nombreYCodigo;
    }

    public Empleados(EmpleadosPK empleadosPK) {
        this.empleadosPK = empleadosPK;
    }

    public Empleados(short codCia, int codEmp) {
        this.empleadosPK = new EmpleadosPK(codCia, codEmp);
    }

    public EmpleadosPK getEmpleadosPK() {
        return empleadosPK;
    }

    public void setEmpleadosPK(EmpleadosPK empleadosPK) {
        this.empleadosPK = empleadosPK;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApCasada() {
        return apCasada;
    }

    public void setApCasada(String apCasada) {
        this.apCasada = apCasada;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNumIgss() {
        return numIgss;
    }

    public void setNumIgss(String numIgss) {
        this.numIgss = numIgss;
    }

    public String getNumIrtra() {
        return numIrtra;
    }

    public void setNumIrtra(String numIrtra) {
        this.numIrtra = numIrtra;
    }

    public String getNumNit() {
        return numNit;
    }

    public void setNumNit(String numNit) {
        this.numNit = numNit;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public Date getFecSalida() {
        return fecSalida;
    }

    public void setFecSalida(Date fecSalida) {
        this.fecSalida = fecSalida;
    }

    public String getMotSalida() {
        return motSalida;
    }

    public void setMotSalida(String motSalida) {
        this.motSalida = motSalida;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoContra() {
        return tipoContra;
    }

    public void setTipoContra(String tipoContra) {
        this.tipoContra = tipoContra;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public BigDecimal getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(BigDecimal bonificacion) {
        this.bonificacion = bonificacion;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getAvisarA() {
        return avisarA;
    }

    public void setAvisarA(String avisarA) {
        this.avisarA = avisarA;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getChequeDep() {
        return chequeDep;
    }

    public void setChequeDep(String chequeDep) {
        this.chequeDep = chequeDep;
    }

    public String getCtaBancaria() {
        return ctaBancaria;
    }

    public void setCtaBancaria(String ctaBancaria) {
        this.ctaBancaria = ctaBancaria;
    }

    public String getComSprod() {
        return comSprod;
    }

    public void setComSprod(String comSprod) {
        this.comSprod = comSprod;
    }

    public String getComSobra() {
        return comSobra;
    }

    public void setComSobra(String comSobra) {
        this.comSobra = comSobra;
    }

    public BigDecimal getValIsr() {
        return valIsr;
    }

    public void setValIsr(BigDecimal valIsr) {
        this.valIsr = valIsr;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public String getTipoCta() {
        return tipoCta;
    }

    public void setTipoCta(String tipoCta) {
        this.tipoCta = tipoCta;
    }

    public String getNupAfp() {
        return nupAfp;
    }

    public void setNupAfp(String nupAfp) {
        this.nupAfp = nupAfp;
    }

    public Integer getCodAfp() {
        return codAfp;
    }

    public void setCodAfp(Integer codAfp) {
        this.codAfp = codAfp;
    }

    public Short getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(Short numHijos) {
        this.numHijos = numHijos;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

//    public String getCodEmpref() {
//        return codEmpref;
//    }
//
//    public void setCodEmpref(String codEmpref) {
//        this.codEmpref = codEmpref;
//    }
    public String getNombreIsss() {
        return nombreIsss;
    }

    public void setNombreIsss(String nombreIsss) {
        this.nombreIsss = nombreIsss;
    }

    public String getConocidoPor() {
        return conocidoPor;
    }

    public void setConocidoPor(String conocidoPor) {
        this.conocidoPor = conocidoPor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

//    public String getDepartamento() {
//        return departamento;
//    }
//
//    public void setDepartamento(String departamento) {
//        this.departamento = departamento;
//    }

    public Date getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(Date liquidacion) {
        this.liquidacion = liquidacion;
    }

    public String getNombreRenta() {
        return nombreRenta;
    }

    public void setNombreRenta(String nombreRenta) {
        this.nombreRenta = nombreRenta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public BigDecimal getAntipag() {
        return antipag;
    }

    public void setAntipag(BigDecimal antipag) {
        this.antipag = antipag;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public Short getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(Short codSeccion) {
        this.codSeccion = codSeccion;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public String getNumDui() {
        return numDui;
    }

    public void setNumDui(String numDui) {
        this.numDui = numDui;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodEstudio() {
        return codEstudio;
    }

    public void setCodEstudio(String codEstudio) {
        this.codEstudio = codEstudio;
    }

    public String getLugarDui() {
        return lugarDui;
    }

    public void setLugarDui(String lugarDui) {
        this.lugarDui = lugarDui;
    }

    public Date getFechaDui() {
        return fechaDui;
    }

    public void setFechaDui(Date fechaDui) {
        this.fechaDui = fechaDui;
    }

    public Date getFecUltContrato() {
        return fecUltContrato;
    }

    public void setFecUltContrato(Date fecUltContrato) {
        this.fecUltContrato = fecUltContrato;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public Agencias getAgencias() {
        return agencias;
    }

    public void setAgencias(Agencias agencias) {
        this.agencias = agencias;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Short getCodPais() {
        return codPais;
    }

    public void setCodPais(Short codPais) {
        this.codPais = codPais;
    }

    public Short getCodDepar() {
        return codDepar;
    }

    public void setCodDepar(Short codDepar) {
        this.codDepar = codDepar;
    }

    public Short getCodMuni() {
        return codMuni;
    }

    public void setCodMuni(Short codMuni) {
        this.codMuni = codMuni;
    }

    public String getOtras() {
        return otras;
    }

    public void setOtras(String otras) {
        this.otras = otras;
    }

    public BigInteger getCodArea() {
        return codArea;
    }

    public void setCodArea(BigInteger codArea) {
        this.codArea = codArea;
    }

    public Date getFechavac() {
        return fechavac;
    }

    public void setFechavac(Date fechavac) {
        this.fechavac = fechavac;
    }

    public Date getFechavac2() {
        return fechavac2;
    }

    public void setFechavac2(Date fechavac2) {
        this.fechavac2 = fechavac2;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    public String getCodObjeto() {
        return codObjeto;
    }

    public void setCodObjeto(String codObjeto) {
        this.codObjeto = codObjeto;
    }

    public String getMarcaTarjeta() {
        return marcaTarjeta;
    }

    public void setMarcaTarjeta(String marcaTarjeta) {
        this.marcaTarjeta = marcaTarjeta;
    }

    public String getConcurso() {
        return concurso;
    }

    public void setConcurso(String concurso) {
        this.concurso = concurso;
    }

    public String getSindicato() {
        return sindicato;
    }

    public void setSindicato(String sindicato) {
        this.sindicato = sindicato;
    }

    public Short getCodContratacion() {
        return codContratacion;
    }

    public void setCodContratacion(Short codContratacion) {
        this.codContratacion = codContratacion;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Planilla> getPlanillaList() {
        return planillaList;
    }

    public void setPlanillaList(List<Planilla> planillaList) {
        this.planillaList = planillaList;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    public TiposPlanilla getTiposPlanilla() {
        return tiposPlanilla;
    }

    @XmlTransient
    public List<CapacitacionXEmpleado> getCapacitacionXEmpleadoList() {
        return capacitacionXEmpleadoList;
    }

    public void setCapacitacionXEmpleadoList(List<CapacitacionXEmpleado> capacitacionXEmpleadoList) {
        this.capacitacionXEmpleadoList = capacitacionXEmpleadoList;
    }

    public void setTiposPlanilla(TiposPlanilla tiposPlanilla) {
        this.tiposPlanilla = tiposPlanilla;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public CausasRenuncia getCausasRenuncia() {
        return causasRenuncia;
    }

    public void setCausasRenuncia(CausasRenuncia causasRenuncia) {
        this.causasRenuncia = causasRenuncia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadosPK != null ? empleadosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.empleadosPK == null && other.empleadosPK != null) || (this.empleadosPK != null && !this.empleadosPK.equals(other.empleadosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Empleados[ empleadosPK=" + empleadosPK + " ]";
    }

    public String getNombreCompleto() {
        nombreCompleto = getNombres() + ((getApellidos() != null) ? " " + getApellidos() : "") + ((getApCasada() != null) ? " " + getApCasada() : "");
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Empleados getRepresentantePatronal() {
        return representantePatronal;
    }

    public void setRepresentantePatronal(Empleados representantePatronal) {
        this.representantePatronal = representantePatronal;
    }

    public String getPkAsString() {
        pkAsString = "" + empleadosPK.getCodCia() + "," + empleadosPK.getCodEmp();
        return pkAsString;
    }

    public void setPkAsString(String pkAsString) {
        this.pkAsString = pkAsString;
    }
}