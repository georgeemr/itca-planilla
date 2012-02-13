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
@Table(name = "HIS_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HisPuesto.findAll", query = "SELECT h FROM HisPuesto h"),
    @NamedQuery(name = "HisPuesto.findByCodCia", query = "SELECT h FROM HisPuesto h WHERE h.hisPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "HisPuesto.findByCodHistPuesto", query = "SELECT h FROM HisPuesto h WHERE h.hisPuestoPK.codHistPuesto = :codHistPuesto"),
    @NamedQuery(name = "HisPuesto.findByCodEmp", query = "SELECT h FROM HisPuesto h WHERE h.codEmp = :codEmp"),
    @NamedQuery(name = "HisPuesto.findByRazon", query = "SELECT h FROM HisPuesto h WHERE h.razon = :razon"),
    @NamedQuery(name = "HisPuesto.findByStatus", query = "SELECT h FROM HisPuesto h WHERE h.status = :status"),
    @NamedQuery(name = "HisPuesto.findByFecha", query = "SELECT h FROM HisPuesto h WHERE h.fecha = :fecha")})
public class HisPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HisPuestoPK hisPuestoPK;
    @Column(name = "COD_EMP")
    private Integer codEmp;
    @Basic(optional = false)
    @Column(name = "RAZON", nullable = false, length = 500)
    private String razon;
    @Basic(optional = false)
    @Column(name = "STATUS", nullable = false)
    private char status;
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO")})
    @ManyToOne(optional = false)
    private Puestos puestos;

    public HisPuesto() {
    }

    public HisPuesto(HisPuestoPK hisPuestoPK) {
        this.hisPuestoPK = hisPuestoPK;
    }

    public HisPuesto(HisPuestoPK hisPuestoPK, String razon, char status, Date fecha) {
        this.hisPuestoPK = hisPuestoPK;
        this.razon = razon;
        this.status = status;
        this.fecha = fecha;
    }

    public HisPuesto(short codCia, int codHistPuesto) {
        this.hisPuestoPK = new HisPuestoPK(codCia, codHistPuesto);
    }

    public HisPuestoPK getHisPuestoPK() {
        return hisPuestoPK;
    }

    public void setHisPuestoPK(HisPuestoPK hisPuestoPK) {
        this.hisPuestoPK = hisPuestoPK;
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hisPuestoPK != null ? hisPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HisPuesto)) {
            return false;
        }
        HisPuesto other = (HisPuesto) object;
        if ((this.hisPuestoPK == null && other.hisPuestoPK != null) || (this.hisPuestoPK != null && !this.hisPuestoPK.equals(other.hisPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.HisPuesto[ hisPuestoPK=" + hisPuestoPK + " ]";
    }
    
}
