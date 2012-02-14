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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_INGRESO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetIngreso.findAll", query = "SELECT d FROM DetIngreso d"),
    @NamedQuery(name = "DetIngreso.findByCodCia", query = "SELECT d FROM DetIngreso d WHERE d.detIngresoPK.codCia = :codCia"),
    @NamedQuery(name = "DetIngreso.findByCodEmp", query = "SELECT d FROM DetIngreso d WHERE d.detIngresoPK.codEmp = :codEmp"),
    @NamedQuery(name = "DetIngreso.findByTipoIngreso", query = "SELECT d FROM DetIngreso d WHERE d.detIngresoPK.tipoIngreso = :tipoIngreso"),
    @NamedQuery(name = "DetIngreso.findByValor", query = "SELECT d FROM DetIngreso d WHERE d.valor = :valor"),
    @NamedQuery(name = "DetIngreso.findByFechaIngreso", query = "SELECT d FROM DetIngreso d WHERE d.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "DetIngreso.findByEstado", query = "SELECT d FROM DetIngreso d WHERE d.detIngresoPK.estado = :estado"),
    @NamedQuery(name = "DetIngreso.findByFechaAplicacion", query = "SELECT d FROM DetIngreso d WHERE d.fechaAplicacion = :fechaAplicacion"),
    @NamedQuery(name = "DetIngreso.findByCorrelativo", query = "SELECT d FROM DetIngreso d WHERE d.correlativo = :correlativo"),
    @NamedQuery(name = "DetIngreso.findByPorcentaje", query = "SELECT d FROM DetIngreso d WHERE d.porcentaje = :porcentaje")})
public class DetIngreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetIngresoPK detIngresoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR", precision = 16, scale = 2)
    private BigDecimal valor;
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "FECHA_APLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAplicacion;
    @Column(name = "CORRELATIVO")
    private Long correlativo;
    @Column(name = "PORCENTAJE", precision = 6, scale = 3)
    private BigDecimal porcentaje;

    public DetIngreso() {
    }

    public DetIngreso(DetIngresoPK detIngresoPK) {
        this.detIngresoPK = detIngresoPK;
    }

    public DetIngreso(short codCia, int codEmp, short tipoIngreso, String estado) {
        this.detIngresoPK = new DetIngresoPK(codCia, codEmp, tipoIngreso, estado);
    }

    public DetIngresoPK getDetIngresoPK() {
        return detIngresoPK;
    }

    public void setDetIngresoPK(DetIngresoPK detIngresoPK) {
        this.detIngresoPK = detIngresoPK;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Long getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Long correlativo) {
        this.correlativo = correlativo;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detIngresoPK != null ? detIngresoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetIngreso)) {
            return false;
        }
        DetIngreso other = (DetIngreso) object;
        if ((this.detIngresoPK == null && other.detIngresoPK != null) || (this.detIngresoPK != null && !this.detIngresoPK.equals(other.detIngresoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetIngreso[ detIngresoPK=" + detIngresoPK + " ]";
    }
    
}
