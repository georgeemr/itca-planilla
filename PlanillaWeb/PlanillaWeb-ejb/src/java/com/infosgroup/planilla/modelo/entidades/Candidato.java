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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CANDIDATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c"),
    @NamedQuery(name = "Candidato.findByCodCia", query = "SELECT c FROM Candidato c WHERE c.candidatoPK.codCia = :codCia"),
    @NamedQuery(name = "Candidato.findByCodCandidato", query = "SELECT c FROM Candidato c WHERE c.candidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "Candidato.findByCodMunicipioDomic", query = "SELECT c FROM Candidato c WHERE c.codMunicipioDomic = :codMunicipioDomic"),
    @NamedQuery(name = "Candidato.findByCodDepartamentoDomic", query = "SELECT c FROM Candidato c WHERE c.codDepartamentoDomic = :codDepartamentoDomic"),
    @NamedQuery(name = "Candidato.findByCodPaisNacimiento", query = "SELECT c FROM Candidato c WHERE c.codPaisNacimiento = :codPaisNacimiento"),
    @NamedQuery(name = "Candidato.findByCodPaisNacionalidad", query = "SELECT c FROM Candidato c WHERE c.codPaisNacionalidad = :codPaisNacionalidad"),
    @NamedQuery(name = "Candidato.findByCodMunicipioNacim", query = "SELECT c FROM Candidato c WHERE c.codMunicipioNacim = :codMunicipioNacim"),
    @NamedQuery(name = "Candidato.findByCodDepartamentoNacim", query = "SELECT c FROM Candidato c WHERE c.codDepartamentoNacim = :codDepartamentoNacim"),
    @NamedQuery(name = "Candidato.findByApellido", query = "SELECT c FROM Candidato c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Candidato.findByFecSolicitud", query = "SELECT c FROM Candidato c WHERE c.fecSolicitud = :fecSolicitud"),
    @NamedQuery(name = "Candidato.findByNombre", query = "SELECT c FROM Candidato c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Candidato.findByApCasada", query = "SELECT c FROM Candidato c WHERE c.apCasada = :apCasada"),
    @NamedQuery(name = "Candidato.findByNumDui", query = "SELECT c FROM Candidato c WHERE c.numDui = :numDui"),
    @NamedQuery(name = "Candidato.findByNumNit", query = "SELECT c FROM Candidato c WHERE c.numNit = :numNit"),
    @NamedQuery(name = "Candidato.findByDireccion", query = "SELECT c FROM Candidato c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Candidato.findByTelefono", query = "SELECT c FROM Candidato c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Candidato.findByFechaNac", query = "SELECT c FROM Candidato c WHERE c.fechaNac = :fechaNac"),
    @NamedQuery(name = "Candidato.findBySalarioAspirado", query = "SELECT c FROM Candidato c WHERE c.salarioAspirado = :salarioAspirado"),
    @NamedQuery(name = "Candidato.findByCodPaisDomic", query = "SELECT c FROM Candidato c WHERE c.codPaisDomic = :codPaisDomic"),
    @NamedQuery(name = "Candidato.findByEstadoEstudios", query = "SELECT c FROM Candidato c WHERE c.estadoEstudios = :estadoEstudios"),
    @NamedQuery(name = "Candidato.findByNumLicencia", query = "SELECT c FROM Candidato c WHERE c.numLicencia = :numLicencia"),
    @NamedQuery(name = "Candidato.findBySexo", query = "SELECT c FROM Candidato c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Candidato.findByObservacion", query = "SELECT c FROM Candidato c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "Candidato.findByNombreConyuge", query = "SELECT c FROM Candidato c WHERE c.nombreConyuge = :nombreConyuge"),
    @NamedQuery(name = "Candidato.findByTrabajoConyuge", query = "SELECT c FROM Candidato c WHERE c.trabajoConyuge = :trabajoConyuge"),
    @NamedQuery(name = "Candidato.findByTelefonoConyuge", query = "SELECT c FROM Candidato c WHERE c.telefonoConyuge = :telefonoConyuge"),
    @NamedQuery(name = "Candidato.findByEstadoCivil", query = "SELECT c FROM Candidato c WHERE c.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Candidato.findByRecomendadoPor", query = "SELECT c FROM Candidato c WHERE c.recomendadoPor = :recomendadoPor"),
    @NamedQuery(name = "Candidato.findByNumPasaporte", query = "SELECT c FROM Candidato c WHERE c.numPasaporte = :numPasaporte"),
    @NamedQuery(name = "Candidato.findByExpedicionDui", query = "SELECT c FROM Candidato c WHERE c.expedicionDui = :expedicionDui"),
    @NamedQuery(name = "Candidato.findByCodBanco", query = "SELECT c FROM Candidato c WHERE c.codBanco = :codBanco"),
    @NamedQuery(name = "Candidato.findByCodTiporenuncia", query = "SELECT c FROM Candidato c WHERE c.codTiporenuncia = :codTiporenuncia"),
    @NamedQuery(name = "Candidato.findByOtras", query = "SELECT c FROM Candidato c WHERE c.otras = :otras"),
    @NamedQuery(name = "Candidato.findByMuniExpDui", query = "SELECT c FROM Candidato c WHERE c.muniExpDui = :muniExpDui"),
    @NamedQuery(name = "Candidato.findByFechaExpDui", query = "SELECT c FROM Candidato c WHERE c.fechaExpDui = :fechaExpDui"),
    @NamedQuery(name = "Candidato.findByStatus", query = "SELECT c FROM Candidato c WHERE c.status = :status"),
    @NamedQuery(name = "Candidato.findByFecSalida", query = "SELECT c FROM Candidato c WHERE c.fecSalida = :fecSalida"),
    @NamedQuery(name = "Candidato.findByFecIngreso", query = "SELECT c FROM Candidato c WHERE c.fecIngreso = :fecIngreso"),
    @NamedQuery(name = "Candidato.findByNomIsss", query = "SELECT c FROM Candidato c WHERE c.nomIsss = :nomIsss"),
    @NamedQuery(name = "Candidato.findByNomNit", query = "SELECT c FROM Candidato c WHERE c.nomNit = :nomNit"),
    @NamedQuery(name = "Candidato.findByCodSucursal", query = "SELECT c FROM Candidato c WHERE c.codSucursal = :codSucursal"),
    @NamedQuery(name = "Candidato.findByFecha", query = "SELECT c FROM Candidato c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Candidato.findByUsuario", query = "SELECT c FROM Candidato c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Candidato.findByNumIsss", query = "SELECT c FROM Candidato c WHERE c.numIsss = :numIsss"),
    @NamedQuery(name = "Candidato.findByIdConyuge", query = "SELECT c FROM Candidato c WHERE c.idConyuge = :idConyuge"),
    @NamedQuery(name = "Candidato.findByIdentidadConyuge", query = "SELECT c FROM Candidato c WHERE c.identidadConyuge = :identidadConyuge"),
    @NamedQuery(name = "Candidato.findByEstado", query = "SELECT c FROM Candidato c WHERE c.estado = :estado"),
    @NamedQuery(name = "Candidato.findByCambioSede", query = "SELECT c FROM Candidato c WHERE c.cambioSede = :cambioSede"),
    @NamedQuery(name = "Candidato.findByCodTipoCont", query = "SELECT c FROM Candidato c WHERE c.codTipoCont = :codTipoCont"),
    @NamedQuery(name = "Candidato.findByCodPuesto", query = "SELECT c FROM Candidato c WHERE c.codPuesto = :codPuesto"),
    @NamedQuery(name = "Candidato.findByCodDepto", query = "SELECT c FROM Candidato c WHERE c.codDepto = :codDepto"),
    @NamedQuery(name = "Candidato.findByCodContratacion", query = "SELECT c FROM Candidato c WHERE c.codContratacion = :codContratacion"),
    @NamedQuery(name = "Candidato.findByCelular", query = "SELECT c FROM Candidato c WHERE c.celular = :celular"),
    @NamedQuery(name = "Candidato.findByEmail", query = "SELECT c FROM Candidato c WHERE c.email = :email"),
    @NamedQuery(name = "Candidato.findByOtrosDocumentos", query = "SELECT c FROM Candidato c WHERE c.otrosDocumentos = :otrosDocumentos")})
public class Candidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CandidatoPK candidatoPK;
    @Column(name = "COD_MUNICIPIO_DOMIC")
    private Short codMunicipioDomic;
    @Column(name = "COD_DEPARTAMENTO_DOMIC")
    private Short codDepartamentoDomic;
    @Column(name = "COD_PAIS_NACIMIENTO")
    private Short codPaisNacimiento;
    @Column(name = "COD_PAIS_NACIONALIDAD")
    private Short codPaisNacionalidad;
    @Column(name = "COD_MUNICIPIO_NACIM")
    private Short codMunicipioNacim;
    @Column(name = "COD_DEPARTAMENTO_NACIM")
    private Short codDepartamentoNacim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDO", nullable = false, length = 30)
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_SOLICITUD", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;
    @Size(max = 20)
    @Column(name = "AP_CASADA", length = 20)
    private String apCasada;
    @Size(max = 20)
    @Column(name = "NUM_DUI", length = 20)
    private String numDui;
    @Size(max = 20)
    @Column(name = "NUM_NIT", length = 20)
    private String numNit;
    @Size(max = 200)
    @Column(name = "DIRECCION", length = 200)
    private String direccion;
    @Size(max = 50)
    @Column(name = "TELEFONO", length = 50)
    private String telefono;
    @Column(name = "FECHA_NAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO_ASPIRADO", precision = 16, scale = 2)
    private BigDecimal salarioAspirado;
    @Column(name = "COD_PAIS_DOMIC")
    private Short codPaisDomic;
    @Size(max = 3)
    @Column(name = "ESTADO_ESTUDIOS", length = 3)
    private String estadoEstudios;
    @Size(max = 20)
    @Column(name = "NUM_LICENCIA", length = 20)
    private String numLicencia;
    @Column(name = "SEXO")
    private Short sexo;
    @Size(max = 200)
    @Column(name = "OBSERVACION", length = 200)
    private String observacion;
    @Size(max = 60)
    @Column(name = "NOMBRE_CONYUGE", length = 60)
    private String nombreConyuge;
    @Size(max = 30)
    @Column(name = "TRABAJO_CONYUGE", length = 30)
    private String trabajoConyuge;
    @Size(max = 50)
    @Column(name = "TELEFONO_CONYUGE", length = 50)
    private String telefonoConyuge;
    @Size(max = 1)
    @Column(name = "ESTADO_CIVIL", length = 1)
    private String estadoCivil;
    @Size(max = 60)
    @Column(name = "RECOMENDADO_POR", length = 60)
    private String recomendadoPor;
    @Size(max = 30)
    @Column(name = "NUM_PASAPORTE", length = 30)
    private String numPasaporte;
    @Size(max = 50)
    @Column(name = "EXPEDICION_DUI", length = 50)
    private String expedicionDui;
    @Size(max = 3)
    @Column(name = "COD_BANCO", length = 3)
    private String codBanco;
    @Column(name = "COD_TIPORENUNCIA")
    private Short codTiporenuncia;
    @Size(max = 100)
    @Column(name = "OTRAS", length = 100)
    private String otras;
    @Size(max = 50)
    @Column(name = "MUNI_EXP_DUI", length = 50)
    private String muniExpDui;
    @Column(name = "FECHA_EXP_DUI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpDui;
    @Size(max = 1)
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "FEC_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecSalida;
    @Column(name = "FEC_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    @Size(max = 100)
    @Column(name = "NOM_ISSS", length = 100)
    private String nomIsss;
    @Size(max = 100)
    @Column(name = "NOM_NIT", length = 100)
    private String nomNit;
    @Column(name = "COD_SUCURSAL")
    private Short codSucursal;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 20)
    @Column(name = "USUARIO", length = 20)
    private String usuario;
    @Size(max = 12)
    @Column(name = "NUM_ISSS", length = 12)
    private String numIsss;
    @Size(max = 20)
    @Column(name = "ID_CONYUGE", length = 20)
    private String idConyuge;
    @Size(max = 20)
    @Column(name = "IDENTIDAD_CONYUGE", length = 20)
    private String identidadConyuge;
    @Size(max = 1)
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @Size(max = 2)
    @Column(name = "CAMBIO_SEDE", length = 2)
    private String cambioSede;
    @Column(name = "COD_TIPO_CONT")
    private Short codTipoCont;
    @Column(name = "COD_PUESTO")
    private Integer codPuesto;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "COD_CONTRATACION")
    private Short codContratacion;
    @Size(max = 50)
    @Column(name = "CELULAR", length = 50)
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL", length = 50)
    private String email;
    @Size(max = 200)
    @Column(name = "OTROS_DOCUMENTOS", length = 200)
    private String otrosDocumentos;
    @JoinTable(name = "PASATIEMPO_X_CANDIDATO", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_PASATIEMPO", referencedColumnName = "COD_PASATIEMPO", nullable = false)})
    @ManyToMany
    private List<Pasatiempo> pasatiempoList;
    @JoinTable(name = "PARENTESCO_EMPLEADO_CANDIDATO", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_PARENTESCO", referencedColumnName = "COD_PARENTESCO")})
    @ManyToMany
    private List<Parentesco> parentescoList;
    @JoinTable(name = "PERFIL_X_CANDIDATO", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA"),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO")}, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA"),
        @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL"),
        @JoinColumn(name = "COD_ITEM_PERFIL", referencedColumnName = "COD_ITEM_PERFIL")})
    @ManyToMany
    private List<ItemXPerfil> itemXPerfilList;
    @JoinTable(name = "REL_LIC_EMPLEADO", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_TIPO_LIC", referencedColumnName = "COD_TIPO_LIC", nullable = false)})
    @ManyToMany
    private List<TipoLicencia> tipoLicenciaList;
    @JoinTable(name = "EQUIPO_X_CANDIDATO", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_EQUIPO", referencedColumnName = "COD_EQUIPO", nullable = false)})
    @ManyToMany
    private List<Equipo> equipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<BeneficiarioXCandidato> beneficiarioXCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<IdiomaXCandidato> idiomaXCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<CandidatoXCargo> candidatoXCargoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<DependienteXCandidato> dependienteXCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<DocumentoPresentado> documentoPresentadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<NivelesXCandidato> nivelesXCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<ProfesionesXCandidato> profesionesXCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<HisEmpleo> hisEmpleoList;
    @JoinColumn(name = "TIPO_SANGRE", referencedColumnName = "TIPO_SANGRE")
    @ManyToOne
    private TipoSangre tipoSangre;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_LICENCIA", referencedColumnName = "COD_TIPO_LIC")})
    @ManyToOne(optional = false)
    private TipoLicencia tipoLicencia;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PROFESION", referencedColumnName = "COD_PROFESION")})
    @ManyToOne(optional = false)
    private Profesion profesion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_NIVEL_ACADEMICO", referencedColumnName = "COD_NIVEL_ACADEMICO")})
    @ManyToOne(optional = false)
    private NivelAcademico nivelAcademico;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP")})
    @ManyToOne(optional = false)
    private Empleados empleados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<EntrevistaXCandidato> entrevistaXCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<EmergenciaXCandidato> emergenciaXCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<CapacitacionXCandidato> capacitacionXCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<Referencia> referenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato1")
    private List<CandidatoConcurso> candidatoConcursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<TipoPruebaXCandidato> tipoPruebaXCandidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato1")
    private List<CriteriosXCandidato> criteriosXCandidatoList;

    public Candidato() {
    }

    public Candidato(CandidatoPK candidatoPK) {
        this.candidatoPK = candidatoPK;
    }

    public Candidato(CandidatoPK candidatoPK, String apellido, Date fecSolicitud, String nombre) {
        this.candidatoPK = candidatoPK;
        this.apellido = apellido;
        this.fecSolicitud = fecSolicitud;
        this.nombre = nombre;
    }

    public Candidato(short codCia, int codCandidato) {
        this.candidatoPK = new CandidatoPK(codCia, codCandidato);
    }

    public CandidatoPK getCandidatoPK() {
        return candidatoPK;
    }

    public void setCandidatoPK(CandidatoPK candidatoPK) {
        this.candidatoPK = candidatoPK;
    }

    public Short getCodMunicipioDomic() {
        return codMunicipioDomic;
    }

    public void setCodMunicipioDomic(Short codMunicipioDomic) {
        this.codMunicipioDomic = codMunicipioDomic;
    }

    public Short getCodDepartamentoDomic() {
        return codDepartamentoDomic;
    }

    public void setCodDepartamentoDomic(Short codDepartamentoDomic) {
        this.codDepartamentoDomic = codDepartamentoDomic;
    }

    public Short getCodPaisNacimiento() {
        return codPaisNacimiento;
    }

    public void setCodPaisNacimiento(Short codPaisNacimiento) {
        this.codPaisNacimiento = codPaisNacimiento;
    }

    public Short getCodPaisNacionalidad() {
        return codPaisNacionalidad;
    }

    public void setCodPaisNacionalidad(Short codPaisNacionalidad) {
        this.codPaisNacionalidad = codPaisNacionalidad;
    }

    public Short getCodMunicipioNacim() {
        return codMunicipioNacim;
    }

    public void setCodMunicipioNacim(Short codMunicipioNacim) {
        this.codMunicipioNacim = codMunicipioNacim;
    }

    public Short getCodDepartamentoNacim() {
        return codDepartamentoNacim;
    }

    public void setCodDepartamentoNacim(Short codDepartamentoNacim) {
        this.codDepartamentoNacim = codDepartamentoNacim;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecSolicitud() {
        return fecSolicitud;
    }

    public void setFecSolicitud(Date fecSolicitud) {
        this.fecSolicitud = fecSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApCasada() {
        return apCasada;
    }

    public void setApCasada(String apCasada) {
        this.apCasada = apCasada;
    }

    public String getNumDui() {
        return numDui;
    }

    public void setNumDui(String numDui) {
        this.numDui = numDui;
    }

    public String getNumNit() {
        return numNit;
    }

    public void setNumNit(String numNit) {
        this.numNit = numNit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public BigDecimal getSalarioAspirado() {
        return salarioAspirado;
    }

    public void setSalarioAspirado(BigDecimal salarioAspirado) {
        this.salarioAspirado = salarioAspirado;
    }

    public Short getCodPaisDomic() {
        return codPaisDomic;
    }

    public void setCodPaisDomic(Short codPaisDomic) {
        this.codPaisDomic = codPaisDomic;
    }

    public String getEstadoEstudios() {
        return estadoEstudios;
    }

    public void setEstadoEstudios(String estadoEstudios) {
        this.estadoEstudios = estadoEstudios;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public Short getSexo() {
        return sexo;
    }

    public void setSexo(Short sexo) {
        this.sexo = sexo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNombreConyuge() {
        return nombreConyuge;
    }

    public void setNombreConyuge(String nombreConyuge) {
        this.nombreConyuge = nombreConyuge;
    }

    public String getTrabajoConyuge() {
        return trabajoConyuge;
    }

    public void setTrabajoConyuge(String trabajoConyuge) {
        this.trabajoConyuge = trabajoConyuge;
    }

    public String getTelefonoConyuge() {
        return telefonoConyuge;
    }

    public void setTelefonoConyuge(String telefonoConyuge) {
        this.telefonoConyuge = telefonoConyuge;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRecomendadoPor() {
        return recomendadoPor;
    }

    public void setRecomendadoPor(String recomendadoPor) {
        this.recomendadoPor = recomendadoPor;
    }

    public String getNumPasaporte() {
        return numPasaporte;
    }

    public void setNumPasaporte(String numPasaporte) {
        this.numPasaporte = numPasaporte;
    }

    public String getExpedicionDui() {
        return expedicionDui;
    }

    public void setExpedicionDui(String expedicionDui) {
        this.expedicionDui = expedicionDui;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public Short getCodTiporenuncia() {
        return codTiporenuncia;
    }

    public void setCodTiporenuncia(Short codTiporenuncia) {
        this.codTiporenuncia = codTiporenuncia;
    }

    public String getOtras() {
        return otras;
    }

    public void setOtras(String otras) {
        this.otras = otras;
    }

    public String getMuniExpDui() {
        return muniExpDui;
    }

    public void setMuniExpDui(String muniExpDui) {
        this.muniExpDui = muniExpDui;
    }

    public Date getFechaExpDui() {
        return fechaExpDui;
    }

    public void setFechaExpDui(Date fechaExpDui) {
        this.fechaExpDui = fechaExpDui;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFecSalida() {
        return fecSalida;
    }

    public void setFecSalida(Date fecSalida) {
        this.fecSalida = fecSalida;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public String getNomIsss() {
        return nomIsss;
    }

    public void setNomIsss(String nomIsss) {
        this.nomIsss = nomIsss;
    }

    public String getNomNit() {
        return nomNit;
    }

    public void setNomNit(String nomNit) {
        this.nomNit = nomNit;
    }

    public Short getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Short codSucursal) {
        this.codSucursal = codSucursal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNumIsss() {
        return numIsss;
    }

    public void setNumIsss(String numIsss) {
        this.numIsss = numIsss;
    }

    public String getIdConyuge() {
        return idConyuge;
    }

    public void setIdConyuge(String idConyuge) {
        this.idConyuge = idConyuge;
    }

    public String getIdentidadConyuge() {
        return identidadConyuge;
    }

    public void setIdentidadConyuge(String identidadConyuge) {
        this.identidadConyuge = identidadConyuge;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCambioSede() {
        return cambioSede;
    }

    public void setCambioSede(String cambioSede) {
        this.cambioSede = cambioSede;
    }

    public Short getCodTipoCont() {
        return codTipoCont;
    }

    public void setCodTipoCont(Short codTipoCont) {
        this.codTipoCont = codTipoCont;
    }

    public Integer getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(Integer codPuesto) {
        this.codPuesto = codPuesto;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public Short getCodContratacion() {
        return codContratacion;
    }

    public void setCodContratacion(Short codContratacion) {
        this.codContratacion = codContratacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtrosDocumentos() {
        return otrosDocumentos;
    }

    public void setOtrosDocumentos(String otrosDocumentos) {
        this.otrosDocumentos = otrosDocumentos;
    }

    @XmlTransient
    public List<Pasatiempo> getPasatiempoList() {
        return pasatiempoList;
    }

    public void setPasatiempoList(List<Pasatiempo> pasatiempoList) {
        this.pasatiempoList = pasatiempoList;
    }

    @XmlTransient
    public List<Parentesco> getParentescoList() {
        return parentescoList;
    }

    public void setParentescoList(List<Parentesco> parentescoList) {
        this.parentescoList = parentescoList;
    }

    @XmlTransient
    public List<ItemXPerfil> getItemXPerfilList() {
        return itemXPerfilList;
    }

    public void setItemXPerfilList(List<ItemXPerfil> itemXPerfilList) {
        this.itemXPerfilList = itemXPerfilList;
    }

    @XmlTransient
    public List<TipoLicencia> getTipoLicenciaList() {
        return tipoLicenciaList;
    }

    public void setTipoLicenciaList(List<TipoLicencia> tipoLicenciaList) {
        this.tipoLicenciaList = tipoLicenciaList;
    }

    @XmlTransient
    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    @XmlTransient
    public List<BeneficiarioXCandidato> getBeneficiarioXCandidatoList() {
        return beneficiarioXCandidatoList;
    }

    public void setBeneficiarioXCandidatoList(List<BeneficiarioXCandidato> beneficiarioXCandidatoList) {
        this.beneficiarioXCandidatoList = beneficiarioXCandidatoList;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<IdiomaXCandidato> getIdiomaXCandidatoList() {
        return idiomaXCandidatoList;
    }

    public void setIdiomaXCandidatoList(List<IdiomaXCandidato> idiomaXCandidatoList) {
        this.idiomaXCandidatoList = idiomaXCandidatoList;
    }

    @XmlTransient
    public List<CandidatoXCargo> getCandidatoXCargoList() {
        return candidatoXCargoList;
    }

    public void setCandidatoXCargoList(List<CandidatoXCargo> candidatoXCargoList) {
        this.candidatoXCargoList = candidatoXCargoList;
    }

    @XmlTransient
    public List<DependienteXCandidato> getDependienteXCandidatoList() {
        return dependienteXCandidatoList;
    }

    public void setDependienteXCandidatoList(List<DependienteXCandidato> dependienteXCandidatoList) {
        this.dependienteXCandidatoList = dependienteXCandidatoList;
    }

    @XmlTransient
    public List<DocumentoPresentado> getDocumentoPresentadoList() {
        return documentoPresentadoList;
    }

    public void setDocumentoPresentadoList(List<DocumentoPresentado> documentoPresentadoList) {
        this.documentoPresentadoList = documentoPresentadoList;
    }

    @XmlTransient
    public List<NivelesXCandidato> getNivelesXCandidatoList() {
        return nivelesXCandidatoList;
    }

    public void setNivelesXCandidatoList(List<NivelesXCandidato> nivelesXCandidatoList) {
        this.nivelesXCandidatoList = nivelesXCandidatoList;
    }

    @XmlTransient
    public List<ProfesionesXCandidato> getProfesionesXCandidatoList() {
        return profesionesXCandidatoList;
    }

    public void setProfesionesXCandidatoList(List<ProfesionesXCandidato> profesionesXCandidatoList) {
        this.profesionesXCandidatoList = profesionesXCandidatoList;
    }

    @XmlTransient
    public List<HisEmpleo> getHisEmpleoList() {
        return hisEmpleoList;
    }

    public void setHisEmpleoList(List<HisEmpleo> hisEmpleoList) {
        this.hisEmpleoList = hisEmpleoList;
    }

    public TipoSangre getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(TipoSangre tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public TipoLicencia getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(TipoLicencia tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public NivelAcademico getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademico nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @XmlTransient
    public List<EntrevistaXCandidato> getEntrevistaXCandidatoList() {
        return entrevistaXCandidatoList;
    }

    public void setEntrevistaXCandidatoList(List<EntrevistaXCandidato> entrevistaXCandidatoList) {
        this.entrevistaXCandidatoList = entrevistaXCandidatoList;
    }

    @XmlTransient
    public List<EmergenciaXCandidato> getEmergenciaXCandidatoList() {
        return emergenciaXCandidatoList;
    }

    public void setEmergenciaXCandidatoList(List<EmergenciaXCandidato> emergenciaXCandidatoList) {
        this.emergenciaXCandidatoList = emergenciaXCandidatoList;
    }

    @XmlTransient
    public List<CapacitacionXCandidato> getCapacitacionXCandidatoList() {
        return capacitacionXCandidatoList;
    }

    public void setCapacitacionXCandidatoList(List<CapacitacionXCandidato> capacitacionXCandidatoList) {
        this.capacitacionXCandidatoList = capacitacionXCandidatoList;
    }

    @XmlTransient
    public List<Referencia> getReferenciaList() {
        return referenciaList;
    }

    public void setReferenciaList(List<Referencia> referenciaList) {
        this.referenciaList = referenciaList;
    }

    @XmlTransient
    public List<CandidatoConcurso> getCandidatoConcursoList() {
        return candidatoConcursoList;
    }

    public void setCandidatoConcursoList(List<CandidatoConcurso> candidatoConcursoList) {
        this.candidatoConcursoList = candidatoConcursoList;
    }

    @XmlTransient
    public List<TipoPruebaXCandidato> getTipoPruebaXCandidatoList() {
        return tipoPruebaXCandidatoList;
    }

    public void setTipoPruebaXCandidatoList(List<TipoPruebaXCandidato> tipoPruebaXCandidatoList) {
        this.tipoPruebaXCandidatoList = tipoPruebaXCandidatoList;
    }

    @XmlTransient
    public List<CriteriosXCandidato> getCriteriosXCandidatoList() {
        return criteriosXCandidatoList;
    }

    public void setCriteriosXCandidatoList(List<CriteriosXCandidato> criteriosXCandidatoList) {
        this.criteriosXCandidatoList = criteriosXCandidatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidatoPK != null ? candidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.candidatoPK == null && other.candidatoPK != null) || (this.candidatoPK != null && !this.candidatoPK.equals(other.candidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Candidato[ candidatoPK=" + candidatoPK + " ]";
    }
    
}
