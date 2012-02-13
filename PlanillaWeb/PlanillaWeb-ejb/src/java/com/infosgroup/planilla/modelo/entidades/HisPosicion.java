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
@Table(name = "HIS_POSICION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HisPosicion.findAll", query = "SELECT h FROM HisPosicion h"),
    @NamedQuery(name = "HisPosicion.findByCodCia", query = "SELECT h FROM HisPosicion h WHERE h.hisPosicionPK.codCia = :codCia"),
    @NamedQuery(name = "HisPosicion.findByCodHistPosicion", query = "SELECT h FROM HisPosicion h WHERE h.hisPosicionPK.codHistPosicion = :codHistPosicion"),
    @NamedQuery(name = "HisPosicion.findByCodEmp", query = "SELECT h FROM HisPosicion h WHERE h.codEmp = :codEmp"),
    @NamedQuery(name = "HisPosicion.findByCodPosicion", query = "SELECT h FROM HisPosicion h WHERE h.hisPosicionPK.codPosicion = :codPosicion"),
    @NamedQuery(name = "HisPosicion.findByRazon", query = "SELECT h FROM HisPosicion h WHERE h.razon = :razon"),
    @NamedQuery(name = "HisPosicion.findByStatus", query = "SELECT h FROM HisPosicion h WHERE h.status = :status"),
    @NamedQuery(name = "HisPosicion.findByFecha", query = "SELECT h FROM HisPosicion h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HisPosicion.findByNumActa", query = "SELECT h FROM HisPosicion h WHERE h.numActa = :numActa"),
    @NamedQuery(name = "HisPosicion.findByFechaActa", query = "SELECT h FROM HisPosicion h WHERE h.fechaActa = :fechaActa"),
    @NamedQuery(name = "HisPosicion.findByCodAutoriza", query = "SELECT h FROM HisPosicion h WHERE h.codAutoriza = :codAutoriza")})
public class HisPosicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HisPosicionPK hisPosicionPK;
    @Column(name = "COD_EMP")
    private Integer codEmp;
    @Basic(optional = false)
    @Column(name = "RAZON", nullable = false, length = 500)
    private String razon;
    @Basic(optional = false)
    @Column(name = "STATUS", nullable = false, length = 1)
    private String status;
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "NUM_ACTA", length = 30)
    private String numActa;
    @Basic(optional = false)
    @Column(name = "FECHA_ACTA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActa;
    @Column(name = "COD_AUTORIZA")
    private Integer codAutoriza;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_POSICION", referencedColumnName = "COD_POSICION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Posicion posicion;

    public HisPosicion() {
    }

    public HisPosicion(HisPosicionPK hisPosicionPK) {
        this.hisPosicionPK = hisPosicionPK;
    }

    public HisPosicion(HisPosicionPK hisPosicionPK, String razon, String status, Date fecha, Date fechaActa) {
        this.hisPosicionPK = hisPosicionPK;
        this.razon = razon;
        this.status = status;
        this.fecha = fecha;
        this.fechaActa = fechaActa;
    }

    public HisPosicion(short codCia, int codHistPosicion, short codPosicion) {
        this.hisPosicionPK = new HisPosicionPK(codCia, codHistPosicion, codPosicion);
    }

    public HisPosicionPK getHisPosicionPK() {
        return hisPosicionPK;
    }

    public void setHisPosicionPK(HisPosicionPK hisPosicionPK) {
        this.hisPosicionPK = hisPosicionPK;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumActa() {
        return numActa;
    }

    public void setNumActa(String numActa) {
        this.numActa = numActa;
    }

    public Date getFechaActa() {
        return fechaActa;
    }

    public void setFechaActa(Date fechaActa) {
        this.fechaActa = fechaActa;
    }

    public Integer getCodAutoriza() {
        return codAutoriza;
    }

    public void setCodAutoriza(Integer codAutoriza) {
        this.codAutoriza = codAutoriza;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hisPosicionPK != null ? hisPosicionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HisPosicion)) {
            return false;
        }
        HisPosicion other = (HisPosicion) object;
        if ((this.hisPosicionPK == null && other.hisPosicionPK != null) || (this.hisPosicionPK != null && !this.hisPosicionPK.equals(other.hisPosicionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.HisPosicion[ hisPosicionPK=" + hisPosicionPK + " ]";
    }
    
}
