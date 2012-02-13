/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PROCESO_DEGRADACION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoDegradacion.findAll", query = "SELECT p FROM ProcesoDegradacion p"),
    @NamedQuery(name = "ProcesoDegradacion.findByCodCia", query = "SELECT p FROM ProcesoDegradacion p WHERE p.procesoDegradacionPK.codCia = :codCia"),
    @NamedQuery(name = "ProcesoDegradacion.findByFecha", query = "SELECT p FROM ProcesoDegradacion p WHERE p.procesoDegradacionPK.fecha = :fecha"),
    @NamedQuery(name = "ProcesoDegradacion.findByCodPuesto", query = "SELECT p FROM ProcesoDegradacion p WHERE p.procesoDegradacionPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "ProcesoDegradacion.findByCantidad", query = "SELECT p FROM ProcesoDegradacion p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "ProcesoDegradacion.findByObservacion", query = "SELECT p FROM ProcesoDegradacion p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "ProcesoDegradacion.findByEstado", query = "SELECT p FROM ProcesoDegradacion p WHERE p.estado = :estado")})
public class ProcesoDegradacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesoDegradacionPK procesoDegradacionPK;
    @Column(name = "CANTIDAD")
    private Short cantidad;
    @Column(name = "OBSERVACION", length = 200)
    private String observacion;
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesoDegradacion")
    private List<DetProcesoDegradacion> detProcesoDegradacionList;

    public ProcesoDegradacion() {
    }

    public ProcesoDegradacion(ProcesoDegradacionPK procesoDegradacionPK) {
        this.procesoDegradacionPK = procesoDegradacionPK;
    }

    public ProcesoDegradacion(short codCia, Date fecha, short codPuesto) {
        this.procesoDegradacionPK = new ProcesoDegradacionPK(codCia, fecha, codPuesto);
    }

    public ProcesoDegradacionPK getProcesoDegradacionPK() {
        return procesoDegradacionPK;
    }

    public void setProcesoDegradacionPK(ProcesoDegradacionPK procesoDegradacionPK) {
        this.procesoDegradacionPK = procesoDegradacionPK;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
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

    @XmlTransient
    public List<DetProcesoDegradacion> getDetProcesoDegradacionList() {
        return detProcesoDegradacionList;
    }

    public void setDetProcesoDegradacionList(List<DetProcesoDegradacion> detProcesoDegradacionList) {
        this.detProcesoDegradacionList = detProcesoDegradacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesoDegradacionPK != null ? procesoDegradacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoDegradacion)) {
            return false;
        }
        ProcesoDegradacion other = (ProcesoDegradacion) object;
        if ((this.procesoDegradacionPK == null && other.procesoDegradacionPK != null) || (this.procesoDegradacionPK != null && !this.procesoDegradacionPK.equals(other.procesoDegradacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ProcesoDegradacion[ procesoDegradacionPK=" + procesoDegradacionPK + " ]";
    }
    
}
