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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CAMPANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campania.findAll", query = "SELECT c FROM Campania c"),
    @NamedQuery(name = "Campania.findByCodCia", query = "SELECT c FROM Campania c WHERE c.campaniaPK.codCia = :codCia"),
    @NamedQuery(name = "Campania.findByCodCampania", query = "SELECT c FROM Campania c WHERE c.campaniaPK.codCampania = :codCampania"),
    @NamedQuery(name = "Campania.findByNombre", query = "SELECT c FROM Campania c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Campania.findByFechaInicial", query = "SELECT c FROM Campania c WHERE c.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "Campania.findByFechaFinal", query = "SELECT c FROM Campania c WHERE c.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "Campania.findByEstado", query = "SELECT c FROM Campania c WHERE c.estado = :estado"),
    @NamedQuery(name = "Campania.findByPeriodo", query = "SELECT c FROM Campania c WHERE c.campaniaPK.periodo = :periodo"),
    @NamedQuery(name = "Campania.findByArea", query = "SELECT c FROM Campania c WHERE c.area = :area"),
    @NamedQuery(name = "Campania.findByNota", query = "SELECT c FROM Campania c WHERE c.nota = :nota")})
public class Campania implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CampaniaPK campaniaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FINAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ESTADO", nullable = false, length = 100)
    private String estado;
    @Column(name = "AREA")
    private Long area;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTA", precision = 11, scale = 3)
    private BigDecimal nota;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campania")
    private List<Evaluacion> evaluacionList;

    public Campania() {
    }

    public Campania(CampaniaPK campaniaPK) {
        this.campaniaPK = campaniaPK;
    }

    public Campania(CampaniaPK campaniaPK, String nombre, Date fechaInicial, Date fechaFinal, String estado) {
        this.campaniaPK = campaniaPK;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
    }

    public Campania(long codCia, long codCampania, long periodo) {
        this.campaniaPK = new CampaniaPK(codCia, codCampania, periodo);
    }

    public CampaniaPK getCampaniaPK() {
        return campaniaPK;
    }

    public void setCampaniaPK(CampaniaPK campaniaPK) {
        this.campaniaPK = campaniaPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Cias getCias() {
        return cias;
    }

    public void setCias(Cias cias) {
        this.cias = cias;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campaniaPK != null ? campaniaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campania)) {
            return false;
        }
        Campania other = (Campania) object;
        if ((this.campaniaPK == null && other.campaniaPK != null) || (this.campaniaPK != null && !this.campaniaPK.equals(other.campaniaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Campania[ campaniaPK=" + campaniaPK + " ]";
    }
    @Transient
    private String descripcionEstado;
    @Transient
    private Integer empleadosEvaluados;

    public String getDescripcionEstado() {
        if (estado.equals("0")) {
            descripcionEstado = "Cerrada";
        } else if (estado.equals("1")) {
            descripcionEstado = "Abierta";
        }
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public Integer getEmpleadosEvaluados() {
        return empleadosEvaluados;
    }

    public void setEmpleadosEvaluados(Integer empleadosEvaluados) {
        this.empleadosEvaluados = empleadosEvaluados;
    }
}
