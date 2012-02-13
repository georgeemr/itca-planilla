/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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
@Table(name = "COMISION_MES", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComisionMes.findAll", query = "SELECT c FROM ComisionMes c"),
    @NamedQuery(name = "ComisionMes.findByCodCia", query = "SELECT c FROM ComisionMes c WHERE c.comisionMesPK.codCia = :codCia"),
    @NamedQuery(name = "ComisionMes.findByAnio", query = "SELECT c FROM ComisionMes c WHERE c.comisionMesPK.anio = :anio"),
    @NamedQuery(name = "ComisionMes.findByMes", query = "SELECT c FROM ComisionMes c WHERE c.comisionMesPK.mes = :mes"),
    @NamedQuery(name = "ComisionMes.findByCodEmp", query = "SELECT c FROM ComisionMes c WHERE c.comisionMesPK.codEmp = :codEmp"),
    @NamedQuery(name = "ComisionMes.findByComProducto", query = "SELECT c FROM ComisionMes c WHERE c.comProducto = :comProducto"),
    @NamedQuery(name = "ComisionMes.findByComObra", query = "SELECT c FROM ComisionMes c WHERE c.comObra = :comObra"),
    @NamedQuery(name = "ComisionMes.findByTotComision", query = "SELECT c FROM ComisionMes c WHERE c.totComision = :totComision")})
public class ComisionMes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComisionMesPK comisionMesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "COM_PRODUCTO", nullable = false, precision = 16, scale = 2)
    private BigDecimal comProducto;
    @Basic(optional = false)
    @Column(name = "COM_OBRA", nullable = false, precision = 16, scale = 2)
    private BigDecimal comObra;
    @Basic(optional = false)
    @Column(name = "TOT_COMISION", nullable = false, precision = 16, scale = 2)
    private BigDecimal totComision;

    public ComisionMes() {
    }

    public ComisionMes(ComisionMesPK comisionMesPK) {
        this.comisionMesPK = comisionMesPK;
    }

    public ComisionMes(ComisionMesPK comisionMesPK, BigDecimal comProducto, BigDecimal comObra, BigDecimal totComision) {
        this.comisionMesPK = comisionMesPK;
        this.comProducto = comProducto;
        this.comObra = comObra;
        this.totComision = totComision;
    }

    public ComisionMes(short codCia, short anio, short mes, int codEmp) {
        this.comisionMesPK = new ComisionMesPK(codCia, anio, mes, codEmp);
    }

    public ComisionMesPK getComisionMesPK() {
        return comisionMesPK;
    }

    public void setComisionMesPK(ComisionMesPK comisionMesPK) {
        this.comisionMesPK = comisionMesPK;
    }

    public BigDecimal getComProducto() {
        return comProducto;
    }

    public void setComProducto(BigDecimal comProducto) {
        this.comProducto = comProducto;
    }

    public BigDecimal getComObra() {
        return comObra;
    }

    public void setComObra(BigDecimal comObra) {
        this.comObra = comObra;
    }

    public BigDecimal getTotComision() {
        return totComision;
    }

    public void setTotComision(BigDecimal totComision) {
        this.totComision = totComision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comisionMesPK != null ? comisionMesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionMes)) {
            return false;
        }
        ComisionMes other = (ComisionMes) object;
        if ((this.comisionMesPK == null && other.comisionMesPK != null) || (this.comisionMesPK != null && !this.comisionMesPK.equals(other.comisionMesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ComisionMes[ comisionMesPK=" + comisionMesPK + " ]";
    }
    
}
