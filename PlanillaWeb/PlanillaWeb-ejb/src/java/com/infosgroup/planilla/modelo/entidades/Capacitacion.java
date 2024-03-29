/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
    @Column(name = "NOTA_CAPACITACION", precision = 5, scale = 2)
    private BigDecimal notaCapacitacion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", insertable = false, updatable = false),
        @JoinColumn(name = "COD_INSTI", referencedColumnName = "COD_INSTI")})
    @ManyToOne(optional = false)
    private Instituciones instituciones;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAPACITADOR", referencedColumnName = "COD_CAPACITADOR")})
    @ManyToOne(optional = false)
    private Capacitadores capacitadores;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_AREA_TEMA", referencedColumnName = "COD_AREA"),
        @JoinColumn(name = "COD_TEMA", referencedColumnName = "COD_TEMA")})
    @ManyToOne(optional = false)
    private CapacitacionTemas capacitacionTemas;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_AREA", referencedColumnName = "COD_AREA")})
    @ManyToOne(optional = false)
    private CapacitacionAreas capacitacionAreas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private List<CapacitacionXEmpleado> capacitacionXEmpleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private List<GastoXCapacitacion> gastoXCapacitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private List<CapacitacionAsistencia> capacitacionAsistenciaList;
    @Transient
    private String descripcionEstado;
    
    public Capacitacion() {
    }

    public String getDescripcionEstado() {
        descripcionEstado ="";
        if (status!=null){
            if ( status.equalsIgnoreCase("G") ){
                descripcionEstado ="Grabado";
            }else
            if ( status.equalsIgnoreCase("A") ){
                descripcionEstado ="Aprobado";
            }else
            if ( status.equalsIgnoreCase("R") ){
                descripcionEstado ="Rechazado";
            }else
            if ( status.equalsIgnoreCase("RE") ){
                descripcionEstado ="Realizado";
            }else
            if ( status.equalsIgnoreCase("N")){
                descripcionEstado ="Notificado";
            }
        }
        
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
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

    public BigDecimal getNotaCapacitacion() {
        return notaCapacitacion;
    }

    public void setNotaCapacitacion(BigDecimal notaCapacitacion) {
        this.notaCapacitacion = notaCapacitacion;
    }

    public CapacitacionAreas getCapacitacionAreas() {
        return capacitacionAreas;
    }

    public void setCapacitacionAreas(CapacitacionAreas capacitacionAreas) {
        this.capacitacionAreas = capacitacionAreas;
    }

    public CapacitacionTemas getCapacitacionTemas() {
        return capacitacionTemas;
    }

    public void setCapacitacionTemas(CapacitacionTemas capacitacionTemas) {
        this.capacitacionTemas = capacitacionTemas;
    }

    public Capacitadores getCapacitadores() {
        return capacitadores;
    }

    public void setCapacitadores(Capacitadores capacitadores) {
        this.capacitadores = capacitadores;
    }

    @XmlTransient
    public List<CapacitacionXEmpleado> getCapacitacionXEmpleadoList() {
        return capacitacionXEmpleadoList;
    }

    @XmlTransient
    public List<CapacitacionAsistencia> getCapacitacionAsistenciaList() {
        return capacitacionAsistenciaList;
    }

    public void setCapacitacionAsistenciaList(List<CapacitacionAsistencia> capacitacionAsistenciaList) {
        this.capacitacionAsistenciaList = capacitacionAsistenciaList;
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
