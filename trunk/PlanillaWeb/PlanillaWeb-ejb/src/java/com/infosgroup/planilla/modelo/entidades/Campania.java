/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "campania")
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
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicial", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_final", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado", nullable = false, length = 2147483647)
    private String estado;
    @Column(name = "area")
    private Integer area;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota", precision = 17, scale = 17)
    private Double nota;
    @JoinColumn(name = "cod_cia", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;
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

    public Campania(int codCia, int codCampania, int periodo) {
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
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
    
}
