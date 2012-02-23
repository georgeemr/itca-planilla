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
@Table(name = "CAPACITACION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitacion.findAll", query = "SELECT c FROM Capacitacion c"),
    @NamedQuery(name = "Capacitacion.findByCodCia", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.codCia = :codCia"),
    @NamedQuery(name = "Capacitacion.findByCodCapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.codCapacitacion = :codCapacitacion"),
    @NamedQuery(name = "Capacitacion.findByCodInsti", query = "SELECT c FROM Capacitacion c WHERE c.instituciones = :codInsti"),
    @NamedQuery(name = "Capacitacion.findByNomCapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.nomCapacitacion = :nomCapacitacion"),
    @NamedQuery(name = "Capacitacion.findByFechaDesde", query = "SELECT c FROM Capacitacion c WHERE c.fechaDesde = :fechaDesde"),
    @NamedQuery(name = "Capacitacion.findByFechaHasta", query = "SELECT c FROM Capacitacion c WHERE c.fechaHasta = :fechaHasta"),
    @NamedQuery(name = "Capacitacion.findByDuracion", query = "SELECT c FROM Capacitacion c WHERE c.duracion = :duracion"),
    @NamedQuery(name = "Capacitacion.findByImpartidaPor", query = "SELECT c FROM Capacitacion c WHERE c.impartidaPor = :impartidaPor"),
    @NamedQuery(name = "Capacitacion.findByRazon", query = "SELECT c FROM Capacitacion c WHERE c.razon = :razon"),
    @NamedQuery(name = "Capacitacion.findByCostoRazon", query = "SELECT c FROM Capacitacion c WHERE c.costoRazon = :costoRazon"),
    @NamedQuery(name = "Capacitacion.findByStatus", query = "SELECT c FROM Capacitacion c WHERE c.status = :status")})
public class Capacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitacionPK capacitacionPK;
    /*@Column(name = "COD_INSTI")
    private Short codInsti;*/
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_CAPACITACION", nullable = false, length = 200)
    private String nomCapacitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DESDE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_HASTA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHasta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION", nullable = false, precision = 5, scale = 2)
    private BigDecimal duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IMPARTIDA_POR", nullable = false, length = 100)
    private String impartidaPor;
    @Size(max = 200)
    @Column(name = "RAZON", length = 200)
    private String razon;
    @Column(name = "COSTO_RAZON", precision = 8, scale = 2)
    private BigDecimal costoRazon;
    @Size(max = 3)
    @Column(name = "STATUS", length = 3)
    private String status;
    //join bajo prueba
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", insertable = false, updatable = false),
        @JoinColumn(name = "COD_INSTI", referencedColumnName = "COD_INSTI")})
    @ManyToOne(optional = false)
    private Instituciones instituciones;
    /*@JoinTable(name = "CAPACITACION_X_EMPLEADO", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_CAPACITACION", referencedColumnName = "COD_CAPACITACION", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false)})
    @ManyToMany
    private List<Empleados> empleadosList;*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private List<CapacitacionXEmpleado> capacitacionXEmpleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private List<GastoXCapacitacion> gastoXCapacitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private List<CapacitacionXCandidato> capacitacionXCandidatoList;

    public Capacitacion() {
    }

    public Capacitacion(CapacitacionPK capacitacionPK) {
        this.capacitacionPK = capacitacionPK;
    }

    public Capacitacion(CapacitacionPK capacitacionPK, String nomCapacitacion, Date fechaDesde, Date fechaHasta, BigDecimal duracion, String impartidaPor) {
        this.capacitacionPK = capacitacionPK;
        this.nomCapacitacion = nomCapacitacion;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.duracion = duracion;
        this.impartidaPor = impartidaPor;
    }

    public Capacitacion(short codCia, int codCapacitacion) {
        this.capacitacionPK = new CapacitacionPK(codCia, codCapacitacion);
    }

    public CapacitacionPK getCapacitacionPK() {
        return capacitacionPK;
    }

    public void setCapacitacionPK(CapacitacionPK capacitacionPK) {
        this.capacitacionPK = capacitacionPK;
    }

    public Instituciones getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(Instituciones instituciones) {
        this.instituciones = instituciones;
    }

//    public Instituciones getCodInsti() {
//        return codInsti;
//    }
//
//    public void setCodInsti(Instituciones codInsti) {
//        this.codInsti = codInsti;
//    }

    public String getNomCapacitacion() {
        return nomCapacitacion;
    }

    public void setNomCapacitacion(String nomCapacitacion) {
        this.nomCapacitacion = nomCapacitacion;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
    }

    public String getImpartidaPor() {
        return impartidaPor;
    }

    public void setImpartidaPor(String impartidaPor) {
        this.impartidaPor = impartidaPor;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public BigDecimal getCostoRazon() {
        return costoRazon;
    }

    public void setCostoRazon(BigDecimal costoRazon) {
        this.costoRazon = costoRazon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*@XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }*/
    
    @XmlTransient
    public List<CapacitacionXEmpleado> getCapacitacionXEmpleadoList() {
        return capacitacionXEmpleadoList;
    }

    public void setCapacitacionXEmpleadoList(List<CapacitacionXEmpleado> capacitacionXEmpleadoList) {
        this.capacitacionXEmpleadoList = capacitacionXEmpleadoList;
    }

    @XmlTransient
    public List<GastoXCapacitacion> getGastoXCapacitacionList() {
        return gastoXCapacitacionList;
    }

    public void setGastoXCapacitacionList(List<GastoXCapacitacion> gastoXCapacitacionList) {
        this.gastoXCapacitacionList = gastoXCapacitacionList;
    }

    @XmlTransient
    public List<CapacitacionXCandidato> getCapacitacionXCandidatoList() {
        return capacitacionXCandidatoList;
    }

    public void setCapacitacionXCandidatoList(List<CapacitacionXCandidato> capacitacionXCandidatoList) {
        this.capacitacionXCandidatoList = capacitacionXCandidatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capacitacionPK != null ? capacitacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitacion)) {
            return false;
        }
        Capacitacion other = (Capacitacion) object;
        if ((this.capacitacionPK == null && other.capacitacionPK != null) || (this.capacitacionPK != null && !this.capacitacionPK.equals(other.capacitacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Capacitacion[ capacitacionPK=" + capacitacionPK + " ]";
    }
    
}
