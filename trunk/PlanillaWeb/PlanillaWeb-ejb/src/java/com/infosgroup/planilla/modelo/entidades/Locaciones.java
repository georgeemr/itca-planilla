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
@Table(name = "LOCACIONES", catalog = "", schema = "ACTIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locaciones.findAll", query = "SELECT l FROM Locaciones l"),
    @NamedQuery(name = "Locaciones.findByCodCia", query = "SELECT l FROM Locaciones l WHERE l.locacionesPK.codCia = :codCia"),
    @NamedQuery(name = "Locaciones.findByCodLocacion", query = "SELECT l FROM Locaciones l WHERE l.locacionesPK.codLocacion = :codLocacion"),
    @NamedQuery(name = "Locaciones.findByDesLocacion", query = "SELECT l FROM Locaciones l WHERE l.desLocacion = :desLocacion"),
    @NamedQuery(name = "Locaciones.findByStatus", query = "SELECT l FROM Locaciones l WHERE l.status = :status"),
    @NamedQuery(name = "Locaciones.findByFecStatus", query = "SELECT l FROM Locaciones l WHERE l.fecStatus = :fecStatus")})
public class Locaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocacionesPK locacionesPK;
    @Column(name = "DES_LOCACION", length = 60)
    private String desLocacion;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "FEC_STATUS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecStatus;

    public Locaciones() {
    }

    public Locaciones(LocacionesPK locacionesPK) {
        this.locacionesPK = locacionesPK;
    }

    public Locaciones(short codCia, short codLocacion) {
        this.locacionesPK = new LocacionesPK(codCia, codLocacion);
    }

    public LocacionesPK getLocacionesPK() {
        return locacionesPK;
    }

    public void setLocacionesPK(LocacionesPK locacionesPK) {
        this.locacionesPK = locacionesPK;
    }

    public String getDesLocacion() {
        return desLocacion;
    }

    public void setDesLocacion(String desLocacion) {
        this.desLocacion = desLocacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFecStatus() {
        return fecStatus;
    }

    public void setFecStatus(Date fecStatus) {
        this.fecStatus = fecStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locacionesPK != null ? locacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locaciones)) {
            return false;
        }
        Locaciones other = (Locaciones) object;
        if ((this.locacionesPK == null && other.locacionesPK != null) || (this.locacionesPK != null && !this.locacionesPK.equals(other.locacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.activos.Locaciones[ locacionesPK=" + locacionesPK + " ]";
    }
    
}
