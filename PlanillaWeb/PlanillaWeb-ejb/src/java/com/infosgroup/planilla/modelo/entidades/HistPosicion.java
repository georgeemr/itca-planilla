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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "HIST_POSICION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistPosicion.findAll", query = "SELECT h FROM HistPosicion h"),
    @NamedQuery(name = "HistPosicion.findByCodCia", query = "SELECT h FROM HistPosicion h WHERE h.histPosicionPK.codCia = :codCia"),
    @NamedQuery(name = "HistPosicion.findByCodHistPosicion", query = "SELECT h FROM HistPosicion h WHERE h.histPosicionPK.codHistPosicion = :codHistPosicion"),
    @NamedQuery(name = "HistPosicion.findByCodPosicion", query = "SELECT h FROM HistPosicion h WHERE h.histPosicionPK.codPosicion = :codPosicion"),
    @NamedQuery(name = "HistPosicion.findByCodEmp", query = "SELECT h FROM HistPosicion h WHERE h.codEmp = :codEmp"),
    @NamedQuery(name = "HistPosicion.findByRazon", query = "SELECT h FROM HistPosicion h WHERE h.razon = :razon"),
    @NamedQuery(name = "HistPosicion.findByNumActa", query = "SELECT h FROM HistPosicion h WHERE h.numActa = :numActa"),
    @NamedQuery(name = "HistPosicion.findByFechaActa", query = "SELECT h FROM HistPosicion h WHERE h.fechaActa = :fechaActa"),
    @NamedQuery(name = "HistPosicion.findByVigenciaDesde", query = "SELECT h FROM HistPosicion h WHERE h.vigenciaDesde = :vigenciaDesde"),
    @NamedQuery(name = "HistPosicion.findByVigenciaHasta", query = "SELECT h FROM HistPosicion h WHERE h.vigenciaHasta = :vigenciaHasta"),
    @NamedQuery(name = "HistPosicion.findByFecha", query = "SELECT h FROM HistPosicion h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HistPosicion.findByStatus", query = "SELECT h FROM HistPosicion h WHERE h.status = :status")})
public class HistPosicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistPosicionPK histPosicionPK;
    @Column(name = "COD_EMP")
    private Integer codEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "RAZON", nullable = false, length = 500)
    private String razon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUM_ACTA", nullable = false, length = 20)
    private String numActa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACTA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActa;
    @Column(name = "VIGENCIA_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenciaDesde;
    @Column(name = "VIGENCIA_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenciaHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS", nullable = false)
    private char status;

    public HistPosicion() {
    }

    public HistPosicion(HistPosicionPK histPosicionPK) {
        this.histPosicionPK = histPosicionPK;
    }

    public HistPosicion(HistPosicionPK histPosicionPK, String razon, String numActa, Date fechaActa, Date fecha, char status) {
        this.histPosicionPK = histPosicionPK;
        this.razon = razon;
        this.numActa = numActa;
        this.fechaActa = fechaActa;
        this.fecha = fecha;
        this.status = status;
    }

    public HistPosicion(short codCia, short codHistPosicion, short codPosicion) {
        this.histPosicionPK = new HistPosicionPK(codCia, codHistPosicion, codPosicion);
    }

    public HistPosicionPK getHistPosicionPK() {
        return histPosicionPK;
    }

    public void setHistPosicionPK(HistPosicionPK histPosicionPK) {
        this.histPosicionPK = histPosicionPK;
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

    public Date getVigenciaDesde() {
        return vigenciaDesde;
    }

    public void setVigenciaDesde(Date vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }

    public Date getVigenciaHasta() {
        return vigenciaHasta;
    }

    public void setVigenciaHasta(Date vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (histPosicionPK != null ? histPosicionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistPosicion)) {
            return false;
        }
        HistPosicion other = (HistPosicion) object;
        if ((this.histPosicionPK == null && other.histPosicionPK != null) || (this.histPosicionPK != null && !this.histPosicionPK.equals(other.histPosicionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.HistPosicion[ histPosicionPK=" + histPosicionPK + " ]";
    }
    
}
