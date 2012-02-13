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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_PLAN_CARRERA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetPlanCarrera.findAll", query = "SELECT d FROM DetPlanCarrera d"),
    @NamedQuery(name = "DetPlanCarrera.findByCodCia", query = "SELECT d FROM DetPlanCarrera d WHERE d.detPlanCarreraPK.codCia = :codCia"),
    @NamedQuery(name = "DetPlanCarrera.findByPeriodo", query = "SELECT d FROM DetPlanCarrera d WHERE d.detPlanCarreraPK.periodo = :periodo"),
    @NamedQuery(name = "DetPlanCarrera.findByCorrelativo", query = "SELECT d FROM DetPlanCarrera d WHERE d.detPlanCarreraPK.correlativo = :correlativo"),
    @NamedQuery(name = "DetPlanCarrera.findByDetPlan", query = "SELECT d FROM DetPlanCarrera d WHERE d.detPlanCarreraPK.detPlan = :detPlan"),
    @NamedQuery(name = "DetPlanCarrera.findByTiempo", query = "SELECT d FROM DetPlanCarrera d WHERE d.tiempo = :tiempo"),
    @NamedQuery(name = "DetPlanCarrera.findByActividad", query = "SELECT d FROM DetPlanCarrera d WHERE d.actividad = :actividad"),
    @NamedQuery(name = "DetPlanCarrera.findByResultado", query = "SELECT d FROM DetPlanCarrera d WHERE d.resultado = :resultado"),
    @NamedQuery(name = "DetPlanCarrera.findByFecha", query = "SELECT d FROM DetPlanCarrera d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DetPlanCarrera.findByObservacion", query = "SELECT d FROM DetPlanCarrera d WHERE d.observacion = :observacion")})
public class DetPlanCarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetPlanCarreraPK detPlanCarreraPK;
    @Basic(optional = false)
    @Column(name = "TIEMPO", nullable = false)
    private short tiempo;
    @Basic(optional = false)
    @Column(name = "ACTIVIDAD", nullable = false, length = 200)
    private String actividad;
    @Column(name = "RESULTADO", length = 200)
    private String resultado;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "OBSERVACION", length = 200)
    private String observacion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CORRELATIVO", referencedColumnName = "CORRELATIVO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PlanCarrera planCarrera;

    public DetPlanCarrera() {
    }

    public DetPlanCarrera(DetPlanCarreraPK detPlanCarreraPK) {
        this.detPlanCarreraPK = detPlanCarreraPK;
    }

    public DetPlanCarrera(DetPlanCarreraPK detPlanCarreraPK, short tiempo, String actividad) {
        this.detPlanCarreraPK = detPlanCarreraPK;
        this.tiempo = tiempo;
        this.actividad = actividad;
    }

    public DetPlanCarrera(short codCia, short periodo, short correlativo, short detPlan) {
        this.detPlanCarreraPK = new DetPlanCarreraPK(codCia, periodo, correlativo, detPlan);
    }

    public DetPlanCarreraPK getDetPlanCarreraPK() {
        return detPlanCarreraPK;
    }

    public void setDetPlanCarreraPK(DetPlanCarreraPK detPlanCarreraPK) {
        this.detPlanCarreraPK = detPlanCarreraPK;
    }

    public short getTiempo() {
        return tiempo;
    }

    public void setTiempo(short tiempo) {
        this.tiempo = tiempo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public PlanCarrera getPlanCarrera() {
        return planCarrera;
    }

    public void setPlanCarrera(PlanCarrera planCarrera) {
        this.planCarrera = planCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detPlanCarreraPK != null ? detPlanCarreraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPlanCarrera)) {
            return false;
        }
        DetPlanCarrera other = (DetPlanCarrera) object;
        if ((this.detPlanCarreraPK == null && other.detPlanCarreraPK != null) || (this.detPlanCarreraPK != null && !this.detPlanCarreraPK.equals(other.detPlanCarreraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetPlanCarrera[ detPlanCarreraPK=" + detPlanCarreraPK + " ]";
    }
    
}
