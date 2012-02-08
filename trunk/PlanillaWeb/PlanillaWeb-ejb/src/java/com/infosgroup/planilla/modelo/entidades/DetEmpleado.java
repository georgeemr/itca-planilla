/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "DET_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetEmpleado.findAll", query = "SELECT d FROM DetEmpleado d"),
    @NamedQuery(name = "DetEmpleado.findByCodCia", query = "SELECT d FROM DetEmpleado d WHERE d.detEmpleadoPK.codCia = :codCia"),
    @NamedQuery(name = "DetEmpleado.findByCodEmp", query = "SELECT d FROM DetEmpleado d WHERE d.detEmpleadoPK.codEmp = :codEmp"),
    @NamedQuery(name = "DetEmpleado.findByCodDp", query = "SELECT d FROM DetEmpleado d WHERE d.detEmpleadoPK.codDp = :codDp"),
    @NamedQuery(name = "DetEmpleado.findByQuincena", query = "SELECT d FROM DetEmpleado d WHERE d.quincena = :quincena"),
    @NamedQuery(name = "DetEmpleado.findByCodDepto", query = "SELECT d FROM DetEmpleado d WHERE d.codDepto = :codDepto"),
    @NamedQuery(name = "DetEmpleado.findByValor", query = "SELECT d FROM DetEmpleado d WHERE d.valor = :valor"),
    @NamedQuery(name = "DetEmpleado.findByPorcentaje", query = "SELECT d FROM DetEmpleado d WHERE d.porcentaje = :porcentaje"),
    @NamedQuery(name = "DetEmpleado.findByCodTipopla", query = "SELECT d FROM DetEmpleado d WHERE d.codTipopla = :codTipopla"),
    @NamedQuery(name = "DetEmpleado.findByCorrelativo", query = "SELECT d FROM DetEmpleado d WHERE d.detEmpleadoPK.correlativo = :correlativo")})
public class DetEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetEmpleadoPK detEmpleadoPK;
    @Column(name = "QUINCENA")
    private Short quincena;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR", precision = 16, scale = 2)
    private BigDecimal valor;
    @Column(name = "PORCENTAJE", precision = 6, scale = 2)
    private BigDecimal porcentaje;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public DetEmpleado() {
    }

    public DetEmpleado(DetEmpleadoPK detEmpleadoPK) {
        this.detEmpleadoPK = detEmpleadoPK;
    }

    public DetEmpleado(short codCia, int codEmp, int codDp, short correlativo) {
        this.detEmpleadoPK = new DetEmpleadoPK(codCia, codEmp, codDp, correlativo);
    }

    public DetEmpleadoPK getDetEmpleadoPK() {
        return detEmpleadoPK;
    }

    public void setDetEmpleadoPK(DetEmpleadoPK detEmpleadoPK) {
        this.detEmpleadoPK = detEmpleadoPK;
    }

    public Short getQuincena() {
        return quincena;
    }

    public void setQuincena(Short quincena) {
        this.quincena = quincena;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(Short codTipopla) {
        this.codTipopla = codTipopla;
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
        hash += (detEmpleadoPK != null ? detEmpleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetEmpleado)) {
            return false;
        }
        DetEmpleado other = (DetEmpleado) object;
        if ((this.detEmpleadoPK == null && other.detEmpleadoPK != null) || (this.detEmpleadoPK != null && !this.detEmpleadoPK.equals(other.detEmpleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetEmpleado[ detEmpleadoPK=" + detEmpleadoPK + " ]";
    }
    
}
