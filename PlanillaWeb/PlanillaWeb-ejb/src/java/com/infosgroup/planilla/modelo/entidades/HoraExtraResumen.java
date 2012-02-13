/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "HORA_EXTRA_RESUMEN", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoraExtraResumen.findAll", query = "SELECT h FROM HoraExtraResumen h"),
    @NamedQuery(name = "HoraExtraResumen.findByCodCia", query = "SELECT h FROM HoraExtraResumen h WHERE h.horaExtraResumenPK.codCia = :codCia"),
    @NamedQuery(name = "HoraExtraResumen.findByCodEmp", query = "SELECT h FROM HoraExtraResumen h WHERE h.horaExtraResumenPK.codEmp = :codEmp"),
    @NamedQuery(name = "HoraExtraResumen.findByFechaInicial", query = "SELECT h FROM HoraExtraResumen h WHERE h.horaExtraResumenPK.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "HoraExtraResumen.findByFechaFinal", query = "SELECT h FROM HoraExtraResumen h WHERE h.horaExtraResumenPK.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "HoraExtraResumen.findByCodDepto", query = "SELECT h FROM HoraExtraResumen h WHERE h.codDepto = :codDepto"),
    @NamedQuery(name = "HoraExtraResumen.findByCodSucursal", query = "SELECT h FROM HoraExtraResumen h WHERE h.codSucursal = :codSucursal"),
    @NamedQuery(name = "HoraExtraResumen.findByHXsencillas", query = "SELECT h FROM HoraExtraResumen h WHERE h.hXsencillas = :hXsencillas"),
    @NamedQuery(name = "HoraExtraResumen.findByHXdobles", query = "SELECT h FROM HoraExtraResumen h WHERE h.hXdobles = :hXdobles"),
    @NamedQuery(name = "HoraExtraResumen.findByHXf150", query = "SELECT h FROM HoraExtraResumen h WHERE h.hXf150 = :hXf150"),
    @NamedQuery(name = "HoraExtraResumen.findByHXf250", query = "SELECT h FROM HoraExtraResumen h WHERE h.hXf250 = :hXf250"),
    @NamedQuery(name = "HoraExtraResumen.findByEstado", query = "SELECT h FROM HoraExtraResumen h WHERE h.estado = :estado")})
public class HoraExtraResumen implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HoraExtraResumenPK horaExtraResumenPK;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "COD_SUCURSAL", length = 2)
    private String codSucursal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "H_XSENCILLAS", precision = 6, scale = 2)
    private BigDecimal hXsencillas;
    @Column(name = "H_XDOBLES", precision = 6, scale = 2)
    private BigDecimal hXdobles;
    @Column(name = "H_XF150", precision = 6, scale = 2)
    private BigDecimal hXf150;
    @Column(name = "H_XF250", precision = 6, scale = 2)
    private BigDecimal hXf250;
    @Column(name = "ESTADO", length = 1)
    private String estado;

    public HoraExtraResumen() {
    }

    public HoraExtraResumen(HoraExtraResumenPK horaExtraResumenPK) {
        this.horaExtraResumenPK = horaExtraResumenPK;
    }

    public HoraExtraResumen(short codCia, int codEmp, Date fechaInicial, Date fechaFinal) {
        this.horaExtraResumenPK = new HoraExtraResumenPK(codCia, codEmp, fechaInicial, fechaFinal);
    }

    public HoraExtraResumenPK getHoraExtraResumenPK() {
        return horaExtraResumenPK;
    }

    public void setHoraExtraResumenPK(HoraExtraResumenPK horaExtraResumenPK) {
        this.horaExtraResumenPK = horaExtraResumenPK;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public BigDecimal getHXsencillas() {
        return hXsencillas;
    }

    public void setHXsencillas(BigDecimal hXsencillas) {
        this.hXsencillas = hXsencillas;
    }

    public BigDecimal getHXdobles() {
        return hXdobles;
    }

    public void setHXdobles(BigDecimal hXdobles) {
        this.hXdobles = hXdobles;
    }

    public BigDecimal getHXf150() {
        return hXf150;
    }

    public void setHXf150(BigDecimal hXf150) {
        this.hXf150 = hXf150;
    }

    public BigDecimal getHXf250() {
        return hXf250;
    }

    public void setHXf250(BigDecimal hXf250) {
        this.hXf250 = hXf250;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horaExtraResumenPK != null ? horaExtraResumenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoraExtraResumen)) {
            return false;
        }
        HoraExtraResumen other = (HoraExtraResumen) object;
        if ((this.horaExtraResumenPK == null && other.horaExtraResumenPK != null) || (this.horaExtraResumenPK != null && !this.horaExtraResumenPK.equals(other.horaExtraResumenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.HoraExtraResumen[ horaExtraResumenPK=" + horaExtraResumenPK + " ]";
    }
    
}
