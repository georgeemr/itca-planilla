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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PLAN_CARRERA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanCarrera.findAll", query = "SELECT p FROM PlanCarrera p"),
    @NamedQuery(name = "PlanCarrera.findByCodCia", query = "SELECT p FROM PlanCarrera p WHERE p.planCarreraPK.codCia = :codCia"),
    @NamedQuery(name = "PlanCarrera.findByPeriodo", query = "SELECT p FROM PlanCarrera p WHERE p.planCarreraPK.periodo = :periodo"),
    @NamedQuery(name = "PlanCarrera.findByCorrelativo", query = "SELECT p FROM PlanCarrera p WHERE p.planCarreraPK.correlativo = :correlativo"),
    @NamedQuery(name = "PlanCarrera.findByCodPuestoMeta", query = "SELECT p FROM PlanCarrera p WHERE p.codPuestoMeta = :codPuestoMeta"),
    @NamedQuery(name = "PlanCarrera.findByCodPuestoBase", query = "SELECT p FROM PlanCarrera p WHERE p.codPuestoBase = :codPuestoBase"),
    @NamedQuery(name = "PlanCarrera.findByCodEmp", query = "SELECT p FROM PlanCarrera p WHERE p.codEmp = :codEmp"),
    @NamedQuery(name = "PlanCarrera.findByFechaInicio", query = "SELECT p FROM PlanCarrera p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "PlanCarrera.findByObservacion", query = "SELECT p FROM PlanCarrera p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PlanCarrera.findByEstado", query = "SELECT p FROM PlanCarrera p WHERE p.estado = :estado"),
    @NamedQuery(name = "PlanCarrera.findByFechaRevision", query = "SELECT p FROM PlanCarrera p WHERE p.fechaRevision = :fechaRevision")})
public class PlanCarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanCarreraPK planCarreraPK;
    @Basic(optional = false)
    @Column(name = "COD_PUESTO_META", nullable = false)
    private short codPuestoMeta;
    @Basic(optional = false)
    @Column(name = "COD_PUESTO_BASE", nullable = false)
    private short codPuestoBase;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "OBSERVACION", length = 100)
    private String observacion;
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @Column(name = "FECHA_REVISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRevision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planCarrera")
    private List<DetPlanCarrera> detPlanCarreraList;

    public PlanCarrera() {
    }

    public PlanCarrera(PlanCarreraPK planCarreraPK) {
        this.planCarreraPK = planCarreraPK;
    }

    public PlanCarrera(PlanCarreraPK planCarreraPK, short codPuestoMeta, short codPuestoBase, int codEmp, Date fechaInicio) {
        this.planCarreraPK = planCarreraPK;
        this.codPuestoMeta = codPuestoMeta;
        this.codPuestoBase = codPuestoBase;
        this.codEmp = codEmp;
        this.fechaInicio = fechaInicio;
    }

    public PlanCarrera(short codCia, short periodo, short correlativo) {
        this.planCarreraPK = new PlanCarreraPK(codCia, periodo, correlativo);
    }

    public PlanCarreraPK getPlanCarreraPK() {
        return planCarreraPK;
    }

    public void setPlanCarreraPK(PlanCarreraPK planCarreraPK) {
        this.planCarreraPK = planCarreraPK;
    }

    public short getCodPuestoMeta() {
        return codPuestoMeta;
    }

    public void setCodPuestoMeta(short codPuestoMeta) {
        this.codPuestoMeta = codPuestoMeta;
    }

    public short getCodPuestoBase() {
        return codPuestoBase;
    }

    public void setCodPuestoBase(short codPuestoBase) {
        this.codPuestoBase = codPuestoBase;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    @XmlTransient
    public List<DetPlanCarrera> getDetPlanCarreraList() {
        return detPlanCarreraList;
    }

    public void setDetPlanCarreraList(List<DetPlanCarrera> detPlanCarreraList) {
        this.detPlanCarreraList = detPlanCarreraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planCarreraPK != null ? planCarreraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanCarrera)) {
            return false;
        }
        PlanCarrera other = (PlanCarrera) object;
        if ((this.planCarreraPK == null && other.planCarreraPK != null) || (this.planCarreraPK != null && !this.planCarreraPK.equals(other.planCarreraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PlanCarrera[ planCarreraPK=" + planCarreraPK + " ]";
    }
    
}
