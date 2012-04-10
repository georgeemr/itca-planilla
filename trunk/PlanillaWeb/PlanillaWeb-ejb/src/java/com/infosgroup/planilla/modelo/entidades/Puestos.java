/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PUESTOS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puestos.findAll", query = "SELECT p FROM Puestos p"),
    @NamedQuery(name = "Puestos.findByCodCia", query = "SELECT p FROM Puestos p WHERE p.puestosPK.codCia = :codCia"),
    @NamedQuery(name = "Puestos.findByCodPuesto", query = "SELECT p FROM Puestos p WHERE p.puestosPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "Puestos.findByNomPuesto", query = "SELECT p FROM Puestos p WHERE p.nomPuesto = :nomPuesto"),
    @NamedQuery(name = "Puestos.findByHorasExt", query = "SELECT p FROM Puestos p WHERE p.horasExt = :horasExt"),
    @NamedQuery(name = "Puestos.findByHorasDob", query = "SELECT p FROM Puestos p WHERE p.horasDob = :horasDob"),
    @NamedQuery(name = "Puestos.findByViaticos", query = "SELECT p FROM Puestos p WHERE p.viaticos = :viaticos"),
    @NamedQuery(name = "Puestos.findByComision", query = "SELECT p FROM Puestos p WHERE p.comision = :comision"),
    @NamedQuery(name = "Puestos.findBySalMaximo", query = "SELECT p FROM Puestos p WHERE p.salMaximo = :salMaximo"),
    @NamedQuery(name = "Puestos.findBySalMinimo", query = "SELECT p FROM Puestos p WHERE p.salMinimo = :salMinimo"),
    @NamedQuery(name = "Puestos.findByCodAlterno", query = "SELECT p FROM Puestos p WHERE p.codAlterno = :codAlterno"),
    @NamedQuery(name = "Puestos.findByDescPuesto", query = "SELECT p FROM Puestos p WHERE p.descPuesto = :descPuesto"),
    @NamedQuery(name = "Puestos.findByStatus", query = "SELECT p FROM Puestos p WHERE p.status = :status"),
    @NamedQuery(name = "Puestos.findByInfConf", query = "SELECT p FROM Puestos p WHERE p.infConf = :infConf"),
    @NamedQuery(name = "Puestos.findByCodLocacion", query = "SELECT p FROM Puestos p WHERE p.codLocacion = :codLocacion"),
    @NamedQuery(name = "Puestos.findByPuestoJefe", query = "SELECT p FROM Puestos p WHERE p.puestoJefe = :puestoJefe"),
    @NamedQuery(name = "Puestos.findByObjetivo", query = "SELECT p FROM Puestos p WHERE p.objetivo = :objetivo"),
    @NamedQuery(name = "Puestos.findByImpactoFinan", query = "SELECT p FROM Puestos p WHERE p.impactoFinan = :impactoFinan"),
    @NamedQuery(name = "Puestos.findByGenero", query = "SELECT p FROM Puestos p WHERE p.genero = :genero"),
    @NamedQuery(name = "Puestos.findByCodRangoEdad", query = "SELECT p FROM Puestos p WHERE p.codRangoEdad = :codRangoEdad"),
    @NamedQuery(name = "Puestos.findByCodRangoAnios", query = "SELECT p FROM Puestos p WHERE p.codRangoAnios = :codRangoAnios"),
    @NamedQuery(name = "Puestos.findByCodNivelAcademico", query = "SELECT p FROM Puestos p WHERE p.codNivelAcademico = :codNivelAcademico"),
    @NamedQuery(name = "Puestos.findByCodCondicion", query = "SELECT p FROM Puestos p WHERE p.codCondicion = :codCondicion"),
    @NamedQuery(name = "Puestos.findByJefatura", query = "SELECT p FROM Puestos p WHERE p.jefatura = :jefatura")})
public class Puestos implements Serializable {

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
//    private List<CriteriosXPuesto> criteriosXPuestoList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuestosPK puestosPK;
    @Basic(optional = false)
    @Column(name = "NOM_PUESTO", nullable = false, length = 60)
    private String nomPuesto;
    @Column(name = "HORAS_EXT", length = 1)
    private String horasExt;
    @Column(name = "HORAS_DOB", length = 1)
    private String horasDob;
    @Column(name = "VIATICOS", length = 1)
    private String viaticos;
    @Column(name = "COMISION", length = 1)
    private String comision;
    @Column(name = "SAL_MAXIMO", precision = 16, scale = 2)
    private BigDecimal salMaximo;
    @Column(name = "SAL_MINIMO", precision = 16, scale = 2)
    private BigDecimal salMinimo;
    @Column(name = "COD_ALTERNO", length = 8)
    private String codAlterno;
    @Column(name = "DESC_PUESTO", length = 400)
    private String descPuesto;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "INF_CONF", length = 1)
    private String infConf;
    @Column(name = "COD_LOCACION")
    private Short codLocacion;
    @Column(name = "PUESTO_JEFE")
    private Short puestoJefe;
    @Column(name = "OBJETIVO", length = 400)
    private String objetivo;
    @Column(name = "IMPACTO_FINAN", precision = 12, scale = 2)
    private BigDecimal impactoFinan;
    @Column(name = "GENERO", length = 1)
    private String genero;
    @Column(name = "COD_RANGO_EDAD")
    private Long codRangoEdad;
    @Column(name = "COD_RANGO_ANIOS")
    private Long codRangoAnios;
    @Column(name = "COD_NIVEL_ACADEMICO")
    private Short codNivelAcademico;
    @Column(name = "COD_CONDICION")
    private Short codCondicion;
    @Column(name = "JEFATURA", length = 2)
    private String jefatura;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO")})
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_PUESTO", referencedColumnName = "COD_TIPO_PUESTO")})
    @ManyToOne(optional = false)
    private TipoPuesto tipoPuesto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_AREA", referencedColumnName = "COD_AREA")})
    @ManyToOne(optional = false)
    private AreasStaff areasStaff;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
//    private List<PruebaXPuesto> pruebaXPuestoList;
    @Transient
    private String descripcionEstado;
    
    public Puestos() {
    }

    public Puestos(PuestosPK puestosPK) {
        this.puestosPK = puestosPK;
    }

    public Puestos(PuestosPK puestosPK, String nomPuesto) {
        this.puestosPK = puestosPK;
        this.nomPuesto = nomPuesto;
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

    public String getCodAlterno() {
        return codAlterno;
    }

    public void setCodAlterno(String codAlterno) {
        this.codAlterno = codAlterno;
    }

//    public Short getCodTipoPuesto() {
//        return codTipoPuesto;
//    }
//
//    public void setCodTipoPuesto(Short codTipoPuesto) {
//        this.codTipoPuesto = codTipoPuesto;
//    }
    public String getDescPuesto() {
        return descPuesto;
    }

    public void setDescPuesto(String descPuesto) {
        this.descPuesto = descPuesto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

//    public Short getCodDepto() {
//        return codDepto;
//    }
//
//    public void setCodDepto(Short codDepto) {
//        this.codDepto = codDepto;
//    }
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

    public Long getCodRangoEdad() {
        return codRangoEdad;
    }

    public void setCodRangoEdad(Long codRangoEdad) {
        this.codRangoEdad = codRangoEdad;
    }

    public Long getCodRangoAnios() {
        return codRangoAnios;
    }

    public void setCodRangoAnios(Long codRangoAnios) {
        this.codRangoAnios = codRangoAnios;
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

    public AreasStaff getAreasStaff() {
        return areasStaff;
    }

    public void setAreasStaff(AreasStaff areasStaff) {
        this.areasStaff = areasStaff;
    }

    public String getDescripcionEstado() {
        descripcionEstado ="";
        if ( status!=null ){
            if ( status.equals("A") ){ descripcionEstado = "Activo"; }
            if ( status.equals("I") ){ descripcionEstado = "Inactivo"; }
        }
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
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
        return "com.infosgroup.planilla.modelo.entidades.planilla.Puestos[ puestosPK=" + puestosPK + " ]";
    }

//    @XmlTransient
//    public List<CriteriosXPuesto> getCriteriosXPuestoList() {
//        return criteriosXPuestoList;
//    }
//
//    public void setCriteriosXPuestoList(List<CriteriosXPuesto> criteriosXPuestoList) {
//        this.criteriosXPuestoList = criteriosXPuestoList;
//    }

    public TipoPuesto getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(TipoPuesto tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

//    @XmlTransient
//    public List<PruebaXPuesto> getPruebaXPuestoList() {
//        return pruebaXPuestoList;
//    }
//
//    public void setPruebaXPuestoList(List<PruebaXPuesto> pruebaXPuestoList) {
//        this.pruebaXPuestoList = pruebaXPuestoList;
//    }
}
