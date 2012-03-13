/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PROGRAMACION_PLA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramacionPla.findAll", query = "SELECT p FROM ProgramacionPla p"),
    @NamedQuery(name = "ProgramacionPla.findByCodCia", query = "SELECT p FROM ProgramacionPla p WHERE p.programacionPlaPK.codCia = :codCia"),
    @NamedQuery(name = "ProgramacionPla.findByPeriodo", query = "SELECT p FROM ProgramacionPla p WHERE p.programacionPlaPK.periodo = :periodo"),
    @NamedQuery(name = "ProgramacionPla.findBySecuencia", query = "SELECT p FROM ProgramacionPla p WHERE p.programacionPlaPK.secuencia = :secuencia"),
    @NamedQuery(name = "ProgramacionPla.findByCodTipopla", query = "SELECT p FROM ProgramacionPla p WHERE p.programacionPlaPK.codTipopla = :codTipopla"),
    @NamedQuery(name = "ProgramacionPla.findByQuincena", query = "SELECT p FROM ProgramacionPla p WHERE p.quincena = :quincena"),
    @NamedQuery(name = "ProgramacionPla.findByStatus", query = "SELECT p FROM ProgramacionPla p WHERE p.status = :status"),
    @NamedQuery(name = "ProgramacionPla.findByFechaPago", query = "SELECT p FROM ProgramacionPla p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "ProgramacionPla.findByNumPlanilla", query = "SELECT p FROM ProgramacionPla p WHERE p.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "ProgramacionPla.findByAnio", query = "SELECT p FROM ProgramacionPla p WHERE p.anio = :anio"),
    @NamedQuery(name = "ProgramacionPla.findByMes", query = "SELECT p FROM ProgramacionPla p WHERE p.mes = :mes"),
    @NamedQuery(name = "ProgramacionPla.findByFechaFinal", query = "SELECT p FROM ProgramacionPla p WHERE p.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "ProgramacionPla.findByFechaInicial", query = "SELECT p FROM ProgramacionPla p WHERE p.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "ProgramacionPla.findByObservacion", query = "SELECT p FROM ProgramacionPla p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "ProgramacionPla.findByFecha", query = "SELECT p FROM ProgramacionPla p WHERE p.fecha = :fecha")})
public class ProgramacionPla implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramacionPlaPK programacionPlaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUINCENA", nullable = false)
    private short quincena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS", nullable = false, length = 1)
    private String status;
    @Column(name = "FECHA_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Column(name = "NUM_PLANILLA")
    private Short numPlanilla;
    @Column(name = "ANIO")
    private Short anio;
    @Column(name = "MES")
    private Short mes;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Column(name = "FECHA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Size(max = 100)
    @Column(name = "OBSERVACION", length = 100)
    private String observacion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TiposPlanilla tiposPlanilla;
    @Transient
    private String pkAsString;

    public ProgramacionPla() {
    }

    public ProgramacionPla(ProgramacionPlaPK programacionPlaPK) {
        this.programacionPlaPK = programacionPlaPK;
    }

    public ProgramacionPla(ProgramacionPlaPK programacionPlaPK, short quincena, String status) {
        this.programacionPlaPK = programacionPlaPK;
        this.quincena = quincena;
        this.status = status;
    }

    public ProgramacionPla(short codCia, short periodo, int secuencia, short codTipopla) {
        this.programacionPlaPK = new ProgramacionPlaPK(codCia, periodo, secuencia, codTipopla);
    }

    public ProgramacionPlaPK getProgramacionPlaPK() {
        return programacionPlaPK;
    }

    public void setProgramacionPlaPK(ProgramacionPlaPK programacionPlaPK) {
        this.programacionPlaPK = programacionPlaPK;
    }

    public short getQuincena() {
        return quincena;
    }

    public void setQuincena(short quincena) {
        this.quincena = quincena;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Short getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(Short numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public Short getMes() {
        return mes;
    }

    public void setMes(Short mes) {
        this.mes = mes;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPkAsString() {
        pkAsString = "" + programacionPlaPK.getCodCia() + ":" + anio + ":" + mes + ":" + numPlanilla + ":" + programacionPlaPK.getCodTipopla();
        return pkAsString;
    }

    public void setPkAsString(String pkAsString) {
        this.pkAsString = pkAsString;
    }
    
    public TiposPlanilla getTiposPlanilla() {
        return tiposPlanilla;
    }

    public void setTiposPlanilla(TiposPlanilla tiposPlanilla) {
        this.tiposPlanilla = tiposPlanilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programacionPlaPK != null ? programacionPlaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramacionPla)) {
            return false;
        }
        ProgramacionPla other = (ProgramacionPla) object;
        if ((this.programacionPlaPK == null && other.programacionPlaPK != null) || (this.programacionPlaPK != null && !this.programacionPlaPK.equals(other.programacionPlaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ProgramacionPla[ programacionPlaPK=" + programacionPlaPK + " ]";
    }
}
