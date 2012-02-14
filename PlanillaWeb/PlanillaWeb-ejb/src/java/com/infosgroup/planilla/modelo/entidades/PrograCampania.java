/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PROGRA_CAMPANIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrograCampania.findAll", query = "SELECT p FROM PrograCampania p"),
    @NamedQuery(name = "PrograCampania.findByCodCia", query = "SELECT p FROM PrograCampania p WHERE p.prograCampaniaPK.codCia = :codCia"),
    @NamedQuery(name = "PrograCampania.findByCodCampania", query = "SELECT p FROM PrograCampania p WHERE p.prograCampaniaPK.codCampania = :codCampania"),
    @NamedQuery(name = "PrograCampania.findByPeriodo", query = "SELECT p FROM PrograCampania p WHERE p.prograCampaniaPK.periodo = :periodo"),
    @NamedQuery(name = "PrograCampania.findByCorrelativo", query = "SELECT p FROM PrograCampania p WHERE p.prograCampaniaPK.correlativo = :correlativo"),
    @NamedQuery(name = "PrograCampania.findByObservacion", query = "SELECT p FROM PrograCampania p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PrograCampania.findByCosto", query = "SELECT p FROM PrograCampania p WHERE p.costo = :costo"),
    @NamedQuery(name = "PrograCampania.findByCapacitados", query = "SELECT p FROM PrograCampania p WHERE p.capacitados = :capacitados"),
    @NamedQuery(name = "PrograCampania.findByEstado", query = "SELECT p FROM PrograCampania p WHERE p.estado = :estado")})
public class PrograCampania implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrograCampaniaPK prograCampaniaPK;
    @Size(max = 200)
    @Column(name = "OBSERVACION", length = 200)
    private String observacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTO", precision = 12, scale = 2)
    private BigDecimal costo;
    @Column(name = "CAPACITADOS")
    private Long capacitados;
    @Size(max = 1)
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_ACTIVIDAD", referencedColumnName = "TIPO_ACTIVIDAD")})
    @ManyToOne(optional = false)
    private TipoActividad tipoActividad;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAPACITADOR", referencedColumnName = "COD_CAPACITADOR")})
    @ManyToOne(optional = false)
    private Capacitadores capacitadores;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAMPANIA", referencedColumnName = "COD_CAMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Campania campania;

    public PrograCampania() {
    }

    public PrograCampania(PrograCampaniaPK prograCampaniaPK) {
        this.prograCampaniaPK = prograCampaniaPK;
    }

    public PrograCampania(short codCia, short codCampania, int periodo, long correlativo) {
        this.prograCampaniaPK = new PrograCampaniaPK(codCia, codCampania, periodo, correlativo);
    }

    public PrograCampaniaPK getPrograCampaniaPK() {
        return prograCampaniaPK;
    }

    public void setPrograCampaniaPK(PrograCampaniaPK prograCampaniaPK) {
        this.prograCampaniaPK = prograCampaniaPK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Long getCapacitados() {
        return capacitados;
    }

    public void setCapacitados(Long capacitados) {
        this.capacitados = capacitados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Capacitadores getCapacitadores() {
        return capacitadores;
    }

    public void setCapacitadores(Capacitadores capacitadores) {
        this.capacitadores = capacitadores;
    }

    public Campania getCampania() {
        return campania;
    }

    public void setCampania(Campania campania) {
        this.campania = campania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prograCampaniaPK != null ? prograCampaniaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrograCampania)) {
            return false;
        }
        PrograCampania other = (PrograCampania) object;
        if ((this.prograCampaniaPK == null && other.prograCampaniaPK != null) || (this.prograCampaniaPK != null && !this.prograCampaniaPK.equals(other.prograCampaniaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PrograCampania[ prograCampaniaPK=" + prograCampaniaPK + " ]";
    }
    
}
