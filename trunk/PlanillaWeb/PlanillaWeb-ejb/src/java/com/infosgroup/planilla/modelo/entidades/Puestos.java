/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
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
@Table(name = "PUESTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puestos.findAll", query = "SELECT p FROM Puestos p"),
    @NamedQuery(name = "Puestos.findByCodCia", query = "SELECT p FROM Puestos p WHERE p.puestosPK.codCia = :codCia"),
    @NamedQuery(name = "Puestos.findByCodPuesto", query = "SELECT p FROM Puestos p WHERE p.puestosPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "Puestos.findByNomPuesto", query = "SELECT p FROM Puestos p WHERE p.nomPuesto = :nomPuesto"),
    @NamedQuery(name = "Puestos.findByHorasExt", query = "SELECT p FROM Puestos p WHERE p.horasExt = :horasExt"),
    @NamedQuery(name = "Puestos.findByHorasDob", query = "SELECT p FROM Puestos p WHERE p.horasDob = :horasDob"),
    @NamedQuery(name = "Puestos.findByViaticos", query = "SELECT p FROM Puestos p WHERE p.viaticos = :viaticos"),
    @NamedQuery(name = "Puestos.findByAdmonObra", query = "SELECT p FROM Puestos p WHERE p.admonObra = :admonObra"),
    @NamedQuery(name = "Puestos.findByComision", query = "SELECT p FROM Puestos p WHERE p.comision = :comision"),
    @NamedQuery(name = "Puestos.findBySalMaximo", query = "SELECT p FROM Puestos p WHERE p.salMaximo = :salMaximo"),
    @NamedQuery(name = "Puestos.findBySalMinimo", query = "SELECT p FROM Puestos p WHERE p.salMinimo = :salMinimo"),
    @NamedQuery(name = "Puestos.findByEnObra", query = "SELECT p FROM Puestos p WHERE p.enObra = :enObra"),
    @NamedQuery(name = "Puestos.findByCodAlterno", query = "SELECT p FROM Puestos p WHERE p.codAlterno = :codAlterno"),
    @NamedQuery(name = "Puestos.findByDescPuesto", query = "SELECT p FROM Puestos p WHERE p.descPuesto = :descPuesto"),
    @NamedQuery(name = "Puestos.findByStatus", query = "SELECT p FROM Puestos p WHERE p.status = :status"),
    @NamedQuery(name = "Puestos.findByInfConf", query = "SELECT p FROM Puestos p WHERE p.infConf = :infConf"),
    @NamedQuery(name = "Puestos.findByCodLocacion", query = "SELECT p FROM Puestos p WHERE p.codLocacion = :codLocacion"),
    @NamedQuery(name = "Puestos.findByPuestoJefe", query = "SELECT p FROM Puestos p WHERE p.puestoJefe = :puestoJefe"),
    @NamedQuery(name = "Puestos.findByCodDepto", query = "SELECT p FROM Puestos p WHERE p.codDepto = :codDepto"),
    @NamedQuery(name = "Puestos.findByCodArea", query = "SELECT p FROM Puestos p WHERE p.codArea = :codArea"),
    @NamedQuery(name = "Puestos.findByObjetivo", query = "SELECT p FROM Puestos p WHERE p.objetivo = :objetivo"),
    @NamedQuery(name = "Puestos.findByImpactoFinan", query = "SELECT p FROM Puestos p WHERE p.impactoFinan = :impactoFinan"),
    @NamedQuery(name = "Puestos.findByGenero", query = "SELECT p FROM Puestos p WHERE p.genero = :genero"),
    @NamedQuery(name = "Puestos.findByCodNivelAcademico", query = "SELECT p FROM Puestos p WHERE p.codNivelAcademico = :codNivelAcademico"),
    @NamedQuery(name = "Puestos.findByCodCondicion", query = "SELECT p FROM Puestos p WHERE p.codCondicion = :codCondicion"),
    @NamedQuery(name = "Puestos.findByJefatura", query = "SELECT p FROM Puestos p WHERE p.jefatura = :jefatura"),
    @NamedQuery(name = "Puestos.findByOrdenSitioWeb", query = "SELECT p FROM Puestos p WHERE p.ordenSitioWeb = :ordenSitioWeb")})
public class Puestos implements Serializable {
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestosNuevo")
    private List<AccionPersonal> accionPersonalList;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<AccionPersonal> accionPersonalList1;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuestosPK puestosPK;
    @Column(name = "NOM_PUESTO", length = 60)
    private String nomPuesto;
    @Column(name = "HORAS_EXT", length = 1)
    private String horasExt;
    @Column(name = "HORAS_DOB", length = 1)
    private String horasDob;
    @Column(name = "VIATICOS", length = 1)
    private String viaticos;
    @Column(name = "ADMON_OBRA", length = 2)
    private String admonObra;
    @Column(name = "COMISION", length = 1)
    private String comision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SAL_MAXIMO", precision = 16, scale = 2)
    private BigDecimal salMaximo;
    @Column(name = "SAL_MINIMO", precision = 16, scale = 2)
    private BigDecimal salMinimo;
    @Column(name = "EN_OBRA", length = 1)
    private String enObra;
    @Column(name = "COD_ALTERNO", length = 8)
    private String codAlterno;
    @Column(name = "DESC_PUESTO", length = 400)
    private String descPuesto;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "INF_CONF", length = 1)
    private String infConf;
    @Column(name = "COD_LOCACION")
    private Short codLocacion;
    @Column(name = "PUESTO_JEFE")
    private Short puestoJefe;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "COD_AREA")
    private Short codArea;
    @Column(name = "OBJETIVO", length = 400)
    private String objetivo;
    @Column(name = "IMPACTO_FINAN", precision = 12, scale = 2)
    private BigDecimal impactoFinan;
    @Column(name = "GENERO", length = 1)
    private String genero;
    @Column(name = "COD_NIVEL_ACADEMICO")
    private Short codNivelAcademico;
    @Column(name = "COD_CONDICION")
    private Short codCondicion;
    @Column(name = "JEFATURA", length = 2)
    private String jefatura;
    @Column(name = "ORDEN_SITIO_WEB")
    private Short ordenSitioWeb;
    @ManyToMany(mappedBy = "puestosList")
    private List<Competencias> competenciasList;
    @ManyToMany(mappedBy = "puestosList")
    private List<DeducPresta> deducPrestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<Empleados> empleadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<PruebaXPuesto> pruebaXPuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<FuncionXPuesto> funcionXPuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<PuestoEmpleado> puestoEmpleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<Concurso> concursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<HisPuesto> hisPuestoList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_PUESTO", referencedColumnName = "COD_TIPO_PUESTO")})
    @ManyToOne(optional = false)
    private TipoPuesto tipoPuesto;
    @JoinColumn(name = "COD_RANGO_EDAD", referencedColumnName = "COD_RANGO_EDAD")
    @ManyToOne
    private RangoEdad codRangoEdad;
    @JoinColumn(name = "COD_RANGO_ANIOS", referencedColumnName = "COD_RANGO_ANIOS")
    @ManyToOne
    private RangoAniosExp codRangoAnios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<ContactosXPuesto> contactosXPuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<RhOutsorcing> rhOutsorcingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<CriteriosXPuesto> criteriosXPuestoList;

    public Puestos() {
    }

    public Puestos(PuestosPK puestosPK) {
        this.puestosPK = puestosPK;
    }

    public Puestos(short codCia, short codPuesto) {
        this.puestosPK = new PuestosPK(codCia, codPuesto);
    }

    public PuestosPK getPuestosPK() {
        return puestosPK;
    }

    public void setPuestosPK(PuestosPK puestosPK) {
        this.puestosPK = puestosPK;
    }

    public String getNomPuesto() {
        return nomPuesto;
    }

    public void setNomPuesto(String nomPuesto) {
        this.nomPuesto = nomPuesto;
    }

    public String getHorasExt() {
        return horasExt;
    }

    public void setHorasExt(String horasExt) {
        this.horasExt = horasExt;
    }

    public String getHorasDob() {
        return horasDob;
    }

    public void setHorasDob(String horasDob) {
        this.horasDob = horasDob;
    }

    public String getViaticos() {
        return viaticos;
    }

    public void setViaticos(String viaticos) {
        this.viaticos = viaticos;
    }

    public String getAdmonObra() {
        return admonObra;
    }

    public void setAdmonObra(String admonObra) {
        this.admonObra = admonObra;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public BigDecimal getSalMaximo() {
        return salMaximo;
    }

    public void setSalMaximo(BigDecimal salMaximo) {
        this.salMaximo = salMaximo;
    }

    public BigDecimal getSalMinimo() {
        return salMinimo;
    }

    public void setSalMinimo(BigDecimal salMinimo) {
        this.salMinimo = salMinimo;
    }

    public String getEnObra() {
        return enObra;
    }

    public void setEnObra(String enObra) {
        this.enObra = enObra;
    }

    public String getCodAlterno() {
        return codAlterno;
    }

    public void setCodAlterno(String codAlterno) {
        this.codAlterno = codAlterno;
    }

    public String getDescPuesto() {
        return descPuesto;
    }

    public void setDescPuesto(String descPuesto) {
        this.descPuesto = descPuesto;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getInfConf() {
        return infConf;
    }

    public void setInfConf(String infConf) {
        this.infConf = infConf;
    }

    public Short getCodLocacion() {
        return codLocacion;
    }

    public void setCodLocacion(Short codLocacion) {
        this.codLocacion = codLocacion;
    }

    public Short getPuestoJefe() {
        return puestoJefe;
    }

    public void setPuestoJefe(Short puestoJefe) {
        this.puestoJefe = puestoJefe;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public Short getCodArea() {
        return codArea;
    }

    public void setCodArea(Short codArea) {
        this.codArea = codArea;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public BigDecimal getImpactoFinan() {
        return impactoFinan;
    }

    public void setImpactoFinan(BigDecimal impactoFinan) {
        this.impactoFinan = impactoFinan;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Short getCodNivelAcademico() {
        return codNivelAcademico;
    }

    public void setCodNivelAcademico(Short codNivelAcademico) {
        this.codNivelAcademico = codNivelAcademico;
    }

    public Short getCodCondicion() {
        return codCondicion;
    }

    public void setCodCondicion(Short codCondicion) {
        this.codCondicion = codCondicion;
    }

    public String getJefatura() {
        return jefatura;
    }

    public void setJefatura(String jefatura) {
        this.jefatura = jefatura;
    }

    public Short getOrdenSitioWeb() {
        return ordenSitioWeb;
    }

    public void setOrdenSitioWeb(Short ordenSitioWeb) {
        this.ordenSitioWeb = ordenSitioWeb;
    }

    @XmlTransient
    public List<Competencias> getCompetenciasList() {
        return competenciasList;
    }

    public void setCompetenciasList(List<Competencias> competenciasList) {
        this.competenciasList = competenciasList;
    }

    @XmlTransient
    public List<DeducPresta> getDeducPrestaList() {
        return deducPrestaList;
    }

    public void setDeducPrestaList(List<DeducPresta> deducPrestaList) {
        this.deducPrestaList = deducPrestaList;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<PruebaXPuesto> getPruebaXPuestoList() {
        return pruebaXPuestoList;
    }

    public void setPruebaXPuestoList(List<PruebaXPuesto> pruebaXPuestoList) {
        this.pruebaXPuestoList = pruebaXPuestoList;
    }

    @XmlTransient
    public List<FuncionXPuesto> getFuncionXPuestoList() {
        return funcionXPuestoList;
    }

    public void setFuncionXPuestoList(List<FuncionXPuesto> funcionXPuestoList) {
        this.funcionXPuestoList = funcionXPuestoList;
    }

    @XmlTransient
    public List<PuestoEmpleado> getPuestoEmpleadoList() {
        return puestoEmpleadoList;
    }

    public void setPuestoEmpleadoList(List<PuestoEmpleado> puestoEmpleadoList) {
        this.puestoEmpleadoList = puestoEmpleadoList;
    }

    @XmlTransient
    public List<Concurso> getConcursoList() {
        return concursoList;
    }

    public void setConcursoList(List<Concurso> concursoList) {
        this.concursoList = concursoList;
    }

    @XmlTransient
    public List<HisPuesto> getHisPuestoList() {
        return hisPuestoList;
    }

    public void setHisPuestoList(List<HisPuesto> hisPuestoList) {
        this.hisPuestoList = hisPuestoList;
    }

    public TipoPuesto getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(TipoPuesto tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public RangoEdad getCodRangoEdad() {
        return codRangoEdad;
    }

    public void setCodRangoEdad(RangoEdad codRangoEdad) {
        this.codRangoEdad = codRangoEdad;
    }

    public RangoAniosExp getCodRangoAnios() {
        return codRangoAnios;
    }

    public void setCodRangoAnios(RangoAniosExp codRangoAnios) {
        this.codRangoAnios = codRangoAnios;
    }

    @XmlTransient
    public List<ContactosXPuesto> getContactosXPuestoList() {
        return contactosXPuestoList;
    }

    public void setContactosXPuestoList(List<ContactosXPuesto> contactosXPuestoList) {
        this.contactosXPuestoList = contactosXPuestoList;
    }

    @XmlTransient
    public List<RhOutsorcing> getRhOutsorcingList() {
        return rhOutsorcingList;
    }

    public void setRhOutsorcingList(List<RhOutsorcing> rhOutsorcingList) {
        this.rhOutsorcingList = rhOutsorcingList;
    }

    @XmlTransient
    public List<CriteriosXPuesto> getCriteriosXPuestoList() {
        return criteriosXPuestoList;
    }

    public void setCriteriosXPuestoList(List<CriteriosXPuesto> criteriosXPuestoList) {
        this.criteriosXPuestoList = criteriosXPuestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puestosPK != null ? puestosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puestos)) {
            return false;
        }
        Puestos other = (Puestos) object;
        if ((this.puestosPK == null && other.puestosPK != null) || (this.puestosPK != null && !this.puestosPK.equals(other.puestosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Puestos[ puestosPK=" + puestosPK + " ]";
    }

    @XmlTransient
    public List<AccionPersonal> getAccionPersonalList() {
        return accionPersonalList;
    }

    public void setAccionPersonalList(List<AccionPersonal> accionPersonalList) {
        this.accionPersonalList = accionPersonalList;
    }

    @XmlTransient
    public List<AccionPersonal> getAccionPersonalList1() {
        return accionPersonalList1;
    }

    public void setAccionPersonalList1(List<AccionPersonal> accionPersonalList1) {
        this.accionPersonalList1 = accionPersonalList1;
    }
    
}
