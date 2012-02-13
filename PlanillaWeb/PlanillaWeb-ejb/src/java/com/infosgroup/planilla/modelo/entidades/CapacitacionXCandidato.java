/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CAPACITACION_X_CANDIDATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapacitacionXCandidato.findAll", query = "SELECT c FROM CapacitacionXCandidato c"),
    @NamedQuery(name = "CapacitacionXCandidato.findByCodCia", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.capacitacionXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "CapacitacionXCandidato.findByCodCandidato", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.capacitacionXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "CapacitacionXCandidato.findByCodCapacitacion", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.capacitacionXCandidatoPK.codCapacitacion = :codCapacitacion"),
    @NamedQuery(name = "CapacitacionXCandidato.findByDescripcion", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CapacitacionXCandidato.findByFecha", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CapacitacionXCandidato.findByCodInsti", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.codInsti = :codInsti"),
    @NamedQuery(name = "CapacitacionXCandidato.findByTipo", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "CapacitacionXCandidato.findByNacional", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.nacional = :nacional"),
    @NamedQuery(name = "CapacitacionXCandidato.findByHorasRecibidas", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.horasRecibidas = :horasRecibidas"),
    @NamedQuery(name = "CapacitacionXCandidato.findByNomInstitucion", query = "SELECT c FROM CapacitacionXCandidato c WHERE c.nomInstitucion = :nomInstitucion")})
public class CapacitacionXCandidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitacionXCandidatoPK capacitacionXCandidatoPK;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    @Column(name = "FECHA", length = 30)
    private String fecha;
    @Column(name = "COD_INSTI")
    private Short codInsti;
    @Column(name = "TIPO", length = 2)
    private String tipo;
    @Column(name = "NACIONAL", length = 1)
    private String nacional;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HORAS_RECIBIDAS", precision = 5, scale = 2)
    private BigDecimal horasRecibidas;
    @Column(name = "NOM_INSTITUCION", length = 100)
    private String nomInstitucion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAPACITACION", referencedColumnName = "COD_CAPACITACION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Capacitacion capacitacion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public CapacitacionXCandidato() {
    }

    public CapacitacionXCandidato(CapacitacionXCandidatoPK capacitacionXCandidatoPK) {
        this.capacitacionXCandidatoPK = capacitacionXCandidatoPK;
    }

    public CapacitacionXCandidato(CapacitacionXCandidatoPK capacitacionXCandidatoPK, String descripcion) {
        this.capacitacionXCandidatoPK = capacitacionXCandidatoPK;
        this.descripcion = descripcion;
    }

    public CapacitacionXCandidato(short codCia, int codCandidato, int codCapacitacion) {
        this.capacitacionXCandidatoPK = new CapacitacionXCandidatoPK(codCia, codCandidato, codCapacitacion);
    }

    public CapacitacionXCandidatoPK getCapacitacionXCandidatoPK() {
        return capacitacionXCandidatoPK;
    }

    public void setCapacitacionXCandidatoPK(CapacitacionXCandidatoPK capacitacionXCandidatoPK) {
        this.capacitacionXCandidatoPK = capacitacionXCandidatoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Short getCodInsti() {
        return codInsti;
    }

    public void setCodInsti(Short codInsti) {
        this.codInsti = codInsti;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNacional() {
        return nacional;
    }

    public void setNacional(String nacional) {
        this.nacional = nacional;
    }

    public BigDecimal getHorasRecibidas() {
        return horasRecibidas;
    }

    public void setHorasRecibidas(BigDecimal horasRecibidas) {
        this.horasRecibidas = horasRecibidas;
    }

    public String getNomInstitucion() {
        return nomInstitucion;
    }

    public void setNomInstitucion(String nomInstitucion) {
        this.nomInstitucion = nomInstitucion;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capacitacionXCandidatoPK != null ? capacitacionXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionXCandidato)) {
            return false;
        }
        CapacitacionXCandidato other = (CapacitacionXCandidato) object;
        if ((this.capacitacionXCandidatoPK == null && other.capacitacionXCandidatoPK != null) || (this.capacitacionXCandidatoPK != null && !this.capacitacionXCandidatoPK.equals(other.capacitacionXCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CapacitacionXCandidato[ capacitacionXCandidatoPK=" + capacitacionXCandidatoPK + " ]";
    }
    
}
