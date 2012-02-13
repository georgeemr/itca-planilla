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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_PROCESO_DEGRADACION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetProcesoDegradacion.findAll", query = "SELECT d FROM DetProcesoDegradacion d"),
    @NamedQuery(name = "DetProcesoDegradacion.findByCodCia", query = "SELECT d FROM DetProcesoDegradacion d WHERE d.detProcesoDegradacionPK.codCia = :codCia"),
    @NamedQuery(name = "DetProcesoDegradacion.findByFecha", query = "SELECT d FROM DetProcesoDegradacion d WHERE d.detProcesoDegradacionPK.fecha = :fecha"),
    @NamedQuery(name = "DetProcesoDegradacion.findByCodPuesto", query = "SELECT d FROM DetProcesoDegradacion d WHERE d.detProcesoDegradacionPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "DetProcesoDegradacion.findByCodActividad", query = "SELECT d FROM DetProcesoDegradacion d WHERE d.detProcesoDegradacionPK.codActividad = :codActividad"),
    @NamedQuery(name = "DetProcesoDegradacion.findByCantidad", query = "SELECT d FROM DetProcesoDegradacion d WHERE d.cantidad = :cantidad")})
public class DetProcesoDegradacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetProcesoDegradacionPK detProcesoDegradacionPK;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false)
    private short cantidad;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "FECHA", referencedColumnName = "FECHA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ProcesoDegradacion procesoDegradacion;

    public DetProcesoDegradacion() {
    }

    public DetProcesoDegradacion(DetProcesoDegradacionPK detProcesoDegradacionPK) {
        this.detProcesoDegradacionPK = detProcesoDegradacionPK;
    }

    public DetProcesoDegradacion(DetProcesoDegradacionPK detProcesoDegradacionPK, short cantidad) {
        this.detProcesoDegradacionPK = detProcesoDegradacionPK;
        this.cantidad = cantidad;
    }

    public DetProcesoDegradacion(short codCia, Date fecha, short codPuesto, int codActividad) {
        this.detProcesoDegradacionPK = new DetProcesoDegradacionPK(codCia, fecha, codPuesto, codActividad);
    }

    public DetProcesoDegradacionPK getDetProcesoDegradacionPK() {
        return detProcesoDegradacionPK;
    }

    public void setDetProcesoDegradacionPK(DetProcesoDegradacionPK detProcesoDegradacionPK) {
        this.detProcesoDegradacionPK = detProcesoDegradacionPK;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public ProcesoDegradacion getProcesoDegradacion() {
        return procesoDegradacion;
    }

    public void setProcesoDegradacion(ProcesoDegradacion procesoDegradacion) {
        this.procesoDegradacion = procesoDegradacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detProcesoDegradacionPK != null ? detProcesoDegradacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetProcesoDegradacion)) {
            return false;
        }
        DetProcesoDegradacion other = (DetProcesoDegradacion) object;
        if ((this.detProcesoDegradacionPK == null && other.detProcesoDegradacionPK != null) || (this.detProcesoDegradacionPK != null && !this.detProcesoDegradacionPK.equals(other.detProcesoDegradacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetProcesoDegradacion[ detProcesoDegradacionPK=" + detProcesoDegradacionPK + " ]";
    }
    
}
