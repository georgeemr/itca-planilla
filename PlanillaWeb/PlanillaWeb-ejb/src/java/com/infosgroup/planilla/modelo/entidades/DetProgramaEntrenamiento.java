/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_PROGRAMA_ENTRENAMIENTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetProgramaEntrenamiento.findAll", query = "SELECT d FROM DetProgramaEntrenamiento d"),
    @NamedQuery(name = "DetProgramaEntrenamiento.findByCodCia", query = "SELECT d FROM DetProgramaEntrenamiento d WHERE d.detProgramaEntrenamientoPK.codCia = :codCia"),
    @NamedQuery(name = "DetProgramaEntrenamiento.findByPeriodo", query = "SELECT d FROM DetProgramaEntrenamiento d WHERE d.detProgramaEntrenamientoPK.periodo = :periodo"),
    @NamedQuery(name = "DetProgramaEntrenamiento.findByCodDepto", query = "SELECT d FROM DetProgramaEntrenamiento d WHERE d.detProgramaEntrenamientoPK.codDepto = :codDepto"),
    @NamedQuery(name = "DetProgramaEntrenamiento.findByCorrelativo", query = "SELECT d FROM DetProgramaEntrenamiento d WHERE d.detProgramaEntrenamientoPK.correlativo = :correlativo"),
    @NamedQuery(name = "DetProgramaEntrenamiento.findByAreaNecesidad", query = "SELECT d FROM DetProgramaEntrenamiento d WHERE d.areaNecesidad = :areaNecesidad"),
    @NamedQuery(name = "DetProgramaEntrenamiento.findByFecha", query = "SELECT d FROM DetProgramaEntrenamiento d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DetProgramaEntrenamiento.findByEstado", query = "SELECT d FROM DetProgramaEntrenamiento d WHERE d.estado = :estado")})
public class DetProgramaEntrenamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetProgramaEntrenamientoPK detProgramaEntrenamientoPK;
    @Size(max = 200)
    @Column(name = "AREA_NECESIDAD", length = 200)
    private String areaNecesidad;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 1)
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ProgramaEntrenamiento programaEntrenamiento;

    public DetProgramaEntrenamiento() {
    }

    public DetProgramaEntrenamiento(DetProgramaEntrenamientoPK detProgramaEntrenamientoPK) {
        this.detProgramaEntrenamientoPK = detProgramaEntrenamientoPK;
    }

    public DetProgramaEntrenamiento(short codCia, short periodo, short codDepto, short correlativo) {
        this.detProgramaEntrenamientoPK = new DetProgramaEntrenamientoPK(codCia, periodo, codDepto, correlativo);
    }

    public DetProgramaEntrenamientoPK getDetProgramaEntrenamientoPK() {
        return detProgramaEntrenamientoPK;
    }

    public void setDetProgramaEntrenamientoPK(DetProgramaEntrenamientoPK detProgramaEntrenamientoPK) {
        this.detProgramaEntrenamientoPK = detProgramaEntrenamientoPK;
    }

    public String getAreaNecesidad() {
        return areaNecesidad;
    }

    public void setAreaNecesidad(String areaNecesidad) {
        this.areaNecesidad = areaNecesidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ProgramaEntrenamiento getProgramaEntrenamiento() {
        return programaEntrenamiento;
    }

    public void setProgramaEntrenamiento(ProgramaEntrenamiento programaEntrenamiento) {
        this.programaEntrenamiento = programaEntrenamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detProgramaEntrenamientoPK != null ? detProgramaEntrenamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetProgramaEntrenamiento)) {
            return false;
        }
        DetProgramaEntrenamiento other = (DetProgramaEntrenamiento) object;
        if ((this.detProgramaEntrenamientoPK == null && other.detProgramaEntrenamientoPK != null) || (this.detProgramaEntrenamientoPK != null && !this.detProgramaEntrenamientoPK.equals(other.detProgramaEntrenamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetProgramaEntrenamiento[ detProgramaEntrenamientoPK=" + detProgramaEntrenamientoPK + " ]";
    }
    
}
