/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "RETENCIONES_TERCEROS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RetencionesTerceros.findAll", query = "SELECT r FROM RetencionesTerceros r"),
    @NamedQuery(name = "RetencionesTerceros.findByCodCia", query = "SELECT r FROM RetencionesTerceros r WHERE r.retencionesTercerosPK.codCia = :codCia"),
    @NamedQuery(name = "RetencionesTerceros.findByCodEmp", query = "SELECT r FROM RetencionesTerceros r WHERE r.retencionesTercerosPK.codEmp = :codEmp"),
    @NamedQuery(name = "RetencionesTerceros.findByEmpleador", query = "SELECT r FROM RetencionesTerceros r WHERE r.empleador = :empleador"),
    @NamedQuery(name = "RetencionesTerceros.findByNit", query = "SELECT r FROM RetencionesTerceros r WHERE r.nit = :nit"),
    @NamedQuery(name = "RetencionesTerceros.findByValRenta", query = "SELECT r FROM RetencionesTerceros r WHERE r.valRenta = :valRenta"),
    @NamedQuery(name = "RetencionesTerceros.findByValRetencion", query = "SELECT r FROM RetencionesTerceros r WHERE r.valRetencion = :valRetencion"),
    @NamedQuery(name = "RetencionesTerceros.findByFecUltPago", query = "SELECT r FROM RetencionesTerceros r WHERE r.retencionesTercerosPK.fecUltPago = :fecUltPago")})
public class RetencionesTerceros implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RetencionesTercerosPK retencionesTercerosPK;
    @Basic(optional = false)
    @Column(name = "EMPLEADOR", nullable = false, length = 100)
    private String empleador;
    @Column(name = "NIT", length = 20)
    private String nit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VAL_RENTA", nullable = false, precision = 16, scale = 2)
    private BigDecimal valRenta;
    @Column(name = "VAL_RETENCION", precision = 16, scale = 2)
    private BigDecimal valRetencion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public RetencionesTerceros() {
    }

    public RetencionesTerceros(RetencionesTercerosPK retencionesTercerosPK) {
        this.retencionesTercerosPK = retencionesTercerosPK;
    }

    public RetencionesTerceros(RetencionesTercerosPK retencionesTercerosPK, String empleador, BigDecimal valRenta) {
        this.retencionesTercerosPK = retencionesTercerosPK;
        this.empleador = empleador;
        this.valRenta = valRenta;
    }

    public RetencionesTerceros(short codCia, int codEmp, Date fecUltPago) {
        this.retencionesTercerosPK = new RetencionesTercerosPK(codCia, codEmp, fecUltPago);
    }

    public RetencionesTercerosPK getRetencionesTercerosPK() {
        return retencionesTercerosPK;
    }

    public void setRetencionesTercerosPK(RetencionesTercerosPK retencionesTercerosPK) {
        this.retencionesTercerosPK = retencionesTercerosPK;
    }

    public String getEmpleador() {
        return empleador;
    }

    public void setEmpleador(String empleador) {
        this.empleador = empleador;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public BigDecimal getValRenta() {
        return valRenta;
    }

    public void setValRenta(BigDecimal valRenta) {
        this.valRenta = valRenta;
    }

    public BigDecimal getValRetencion() {
        return valRetencion;
    }

    public void setValRetencion(BigDecimal valRetencion) {
        this.valRetencion = valRetencion;
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
        hash += (retencionesTercerosPK != null ? retencionesTercerosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetencionesTerceros)) {
            return false;
        }
        RetencionesTerceros other = (RetencionesTerceros) object;
        if ((this.retencionesTercerosPK == null && other.retencionesTercerosPK != null) || (this.retencionesTercerosPK != null && !this.retencionesTercerosPK.equals(other.retencionesTercerosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RetencionesTerceros[ retencionesTercerosPK=" + retencionesTercerosPK + " ]";
    }
    
}
