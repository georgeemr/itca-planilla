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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EMPLEADO_ENFERMEDADES", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoEnfermedades.findAll", query = "SELECT e FROM EmpleadoEnfermedades e"),
    @NamedQuery(name = "EmpleadoEnfermedades.findByCodCia", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.empleadoEnfermedadesPK.codCia = :codCia"),
    @NamedQuery(name = "EmpleadoEnfermedades.findByCodEmp", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.empleadoEnfermedadesPK.codEmp = :codEmp"),
    @NamedQuery(name = "EmpleadoEnfermedades.findByCorrelativo", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.empleadoEnfermedadesPK.correlativo = :correlativo"),
    @NamedQuery(name = "EmpleadoEnfermedades.findByFecha", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EmpleadoEnfermedades.findByObservaciones", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.observaciones = :observaciones"),
    @NamedQuery(name = "EmpleadoEnfermedades.findBySintomas", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.sintomas = :sintomas"),
    @NamedQuery(name = "EmpleadoEnfermedades.findByDesdeCuandoPadece", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.desdeCuandoPadece = :desdeCuandoPadece"),
    @NamedQuery(name = "EmpleadoEnfermedades.findByFecProxVisit", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.fecProxVisit = :fecProxVisit"),
    @NamedQuery(name = "EmpleadoEnfermedades.findByIncapacidad", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.incapacidad = :incapacidad"),
    @NamedQuery(name = "EmpleadoEnfermedades.findByTiempoIncapacidad", query = "SELECT e FROM EmpleadoEnfermedades e WHERE e.tiempoIncapacidad = :tiempoIncapacidad")})
public class EmpleadoEnfermedades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoEnfermedadesPK empleadoEnfermedadesPK;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "OBSERVACIONES", length = 200)
    private String observaciones;
    @Column(name = "SINTOMAS", length = 300)
    private String sintomas;
    @Column(name = "DESDE_CUANDO_PADECE", length = 50)
    private String desdeCuandoPadece;
    @Column(name = "FEC_PROX_VISIT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecProxVisit;
    @Column(name = "INCAPACIDAD", length = 1)
    private String incapacidad;
    @Column(name = "TIEMPO_INCAPACIDAD", length = 100)
    private String tiempoIncapacidad;
    @JoinColumn(name = "COD_ENFERMEDAD", referencedColumnName = "COD_ENFERMEDAD")
    @ManyToOne
    private Enfermedades codEnfermedad;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public EmpleadoEnfermedades() {
    }

    public EmpleadoEnfermedades(EmpleadoEnfermedadesPK empleadoEnfermedadesPK) {
        this.empleadoEnfermedadesPK = empleadoEnfermedadesPK;
    }

    public EmpleadoEnfermedades(short codCia, int codEmp, int correlativo) {
        this.empleadoEnfermedadesPK = new EmpleadoEnfermedadesPK(codCia, codEmp, correlativo);
    }

    public EmpleadoEnfermedadesPK getEmpleadoEnfermedadesPK() {
        return empleadoEnfermedadesPK;
    }

    public void setEmpleadoEnfermedadesPK(EmpleadoEnfermedadesPK empleadoEnfermedadesPK) {
        this.empleadoEnfermedadesPK = empleadoEnfermedadesPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDesdeCuandoPadece() {
        return desdeCuandoPadece;
    }

    public void setDesdeCuandoPadece(String desdeCuandoPadece) {
        this.desdeCuandoPadece = desdeCuandoPadece;
    }

    public Date getFecProxVisit() {
        return fecProxVisit;
    }

    public void setFecProxVisit(Date fecProxVisit) {
        this.fecProxVisit = fecProxVisit;
    }

    public String getIncapacidad() {
        return incapacidad;
    }

    public void setIncapacidad(String incapacidad) {
        this.incapacidad = incapacidad;
    }

    public String getTiempoIncapacidad() {
        return tiempoIncapacidad;
    }

    public void setTiempoIncapacidad(String tiempoIncapacidad) {
        this.tiempoIncapacidad = tiempoIncapacidad;
    }

    public Enfermedades getCodEnfermedad() {
        return codEnfermedad;
    }

    public void setCodEnfermedad(Enfermedades codEnfermedad) {
        this.codEnfermedad = codEnfermedad;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoEnfermedadesPK != null ? empleadoEnfermedadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoEnfermedades)) {
            return false;
        }
        EmpleadoEnfermedades other = (EmpleadoEnfermedades) object;
        if ((this.empleadoEnfermedadesPK == null && other.empleadoEnfermedadesPK != null) || (this.empleadoEnfermedadesPK != null && !this.empleadoEnfermedadesPK.equals(other.empleadoEnfermedadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.EmpleadoEnfermedades[ empleadoEnfermedadesPK=" + empleadoEnfermedadesPK + " ]";
    }
    
}
