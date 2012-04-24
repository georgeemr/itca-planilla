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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author infosgroup
 */
@Entity
@Table(name = "CAPACITACION_ASISTENCIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapacitacionAsistencia.findAll", query = "SELECT c FROM CapacitacionAsistencia c"),
    @NamedQuery(name = "CapacitacionAsistencia.findByCodCia", query = "SELECT c FROM CapacitacionAsistencia c WHERE c.capacitacionAsistenciaPK.codCia = :codCia"),
    @NamedQuery(name = "CapacitacionAsistencia.findByCodCapacitacion", query = "SELECT c FROM CapacitacionAsistencia c WHERE c.capacitacionAsistenciaPK.codCapacitacion = :codCapacitacion"),
    @NamedQuery(name = "CapacitacionAsistencia.findByCodEmp", query = "SELECT c FROM CapacitacionAsistencia c WHERE c.capacitacionAsistenciaPK.codEmp = :codEmp"),
    @NamedQuery(name = "CapacitacionAsistencia.findByFecha", query = "SELECT c FROM CapacitacionAsistencia c WHERE c.capacitacionAsistenciaPK.fecha = :fecha"),
    @NamedQuery(name = "CapacitacionAsistencia.findByAsistio", query = "SELECT c FROM CapacitacionAsistencia c WHERE c.asistio = :asistio")})
public class CapacitacionAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitacionAsistenciaPK capacitacionAsistenciaPK;
    @Column(name = "ASISTIO", length = 1)
    private String asistio;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAPACITACION", referencedColumnName = "COD_CAPACITACION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Capacitacion capacitacion;
    @Transient
    private String asiste;

    public CapacitacionAsistencia() {
    }

    public CapacitacionAsistencia(CapacitacionAsistenciaPK capacitacionAsistenciaPK) {
        this.capacitacionAsistenciaPK = capacitacionAsistenciaPK;
    }

    public CapacitacionAsistencia(short codCia, int codCapacitacion, int codEmp, Date fecha) {
        this.capacitacionAsistenciaPK = new CapacitacionAsistenciaPK(codCia, codCapacitacion, codEmp, fecha);
    }

    public CapacitacionAsistenciaPK getCapacitacionAsistenciaPK() {
        return capacitacionAsistenciaPK;
    }

    public void setCapacitacionAsistenciaPK(CapacitacionAsistenciaPK capacitacionAsistenciaPK) {
        this.capacitacionAsistenciaPK = capacitacionAsistenciaPK;
    }

    public String getAsistio() {
        return asistio;
    }

    public void setAsistio(String asistio) {
        this.asistio = asistio;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capacitacionAsistenciaPK != null ? capacitacionAsistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionAsistencia)) {
            return false;
        }
        CapacitacionAsistencia other = (CapacitacionAsistencia) object;
        if ((this.capacitacionAsistenciaPK == null && other.capacitacionAsistenciaPK != null) || (this.capacitacionAsistenciaPK != null && !this.capacitacionAsistenciaPK.equals(other.capacitacionAsistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitdadesplanilla.CapacitacionAsistencia[ capacitacionAsistenciaPK=" + capacitacionAsistenciaPK + " ]";
    }

    @XmlTransient
    public String getAsiste() {
        if (asistio==null || asistio.equals("N")) {
            asiste = "No";
        } else {
            if (asistio.equals("S")) {
                asiste = "Si";
            }
        }
        return asiste;
    }

    public void setAsiste(String asiste) {
        this.asiste = asiste;
    }
}
