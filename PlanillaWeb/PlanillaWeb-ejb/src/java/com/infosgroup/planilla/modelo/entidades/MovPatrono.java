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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "MOV_PATRONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovPatrono.findAll", query = "SELECT m FROM MovPatrono m"),
    @NamedQuery(name = "MovPatrono.findByCodCia", query = "SELECT m FROM MovPatrono m WHERE m.movPatronoPK.codCia = :codCia"),
    @NamedQuery(name = "MovPatrono.findByAnio", query = "SELECT m FROM MovPatrono m WHERE m.movPatronoPK.anio = :anio"),
    @NamedQuery(name = "MovPatrono.findByMes", query = "SELECT m FROM MovPatrono m WHERE m.movPatronoPK.mes = :mes"),
    @NamedQuery(name = "MovPatrono.findByNumPlanilla", query = "SELECT m FROM MovPatrono m WHERE m.movPatronoPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "MovPatrono.findByNoMovto", query = "SELECT m FROM MovPatrono m WHERE m.movPatronoPK.noMovto = :noMovto"),
    @NamedQuery(name = "MovPatrono.findByVpr", query = "SELECT m FROM MovPatrono m WHERE m.vpr = :vpr"),
    @NamedQuery(name = "MovPatrono.findByFactor", query = "SELECT m FROM MovPatrono m WHERE m.factor = :factor"),
    @NamedQuery(name = "MovPatrono.findByValor", query = "SELECT m FROM MovPatrono m WHERE m.valor = :valor"),
    @NamedQuery(name = "MovPatrono.findByBaseCalculo", query = "SELECT m FROM MovPatrono m WHERE m.baseCalculo = :baseCalculo"),
    @NamedQuery(name = "MovPatrono.findByFechaMovto", query = "SELECT m FROM MovPatrono m WHERE m.fechaMovto = :fechaMovto"),
    @NamedQuery(name = "MovPatrono.findBySumaResta", query = "SELECT m FROM MovPatrono m WHERE m.sumaResta = :sumaResta"),
    @NamedQuery(name = "MovPatrono.findByStatus", query = "SELECT m FROM MovPatrono m WHERE m.status = :status"),
    @NamedQuery(name = "MovPatrono.findBySecuencia", query = "SELECT m FROM MovPatrono m WHERE m.secuencia = :secuencia"),
    @NamedQuery(name = "MovPatrono.findByNumCheque", query = "SELECT m FROM MovPatrono m WHERE m.numCheque = :numCheque"),
    @NamedQuery(name = "MovPatrono.findByGenerado", query = "SELECT m FROM MovPatrono m WHERE m.generado = :generado"),
    @NamedQuery(name = "MovPatrono.findByCodPresta", query = "SELECT m FROM MovPatrono m WHERE m.codPresta = :codPresta"),
    @NamedQuery(name = "MovPatrono.findByCodTipopla", query = "SELECT m FROM MovPatrono m WHERE m.codTipopla = :codTipopla")})
public class MovPatrono implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovPatronoPK movPatronoPK;
    @Basic(optional = false)
    @Column(name = "VPR", nullable = false, length = 1)
    private String vpr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "FACTOR", nullable = false, precision = 8, scale = 4)
    private BigDecimal factor;
    @Basic(optional = false)
    @Column(name = "VALOR", nullable = false, precision = 16, scale = 2)
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "BASE_CALCULO", nullable = false, precision = 16, scale = 2)
    private BigDecimal baseCalculo;
    @Column(name = "FECHA_MOVTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovto;
    @Column(name = "SUMA_RESTA", length = 1)
    private String sumaResta;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "SECUENCIA")
    private Integer secuencia;
    @Column(name = "NUM_CHEQUE")
    private Integer numCheque;
    @Column(name = "GENERADO", length = 1)
    private String generado;
    @Column(name = "COD_PRESTA")
    private Integer codPresta;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DP", referencedColumnName = "COD_DP", nullable = false)})
    @ManyToOne(optional = false)
    private DeducPresta deducPresta;

    public MovPatrono() {
    }

    public MovPatrono(MovPatronoPK movPatronoPK) {
        this.movPatronoPK = movPatronoPK;
    }

    public MovPatrono(MovPatronoPK movPatronoPK, String vpr, BigDecimal factor, BigDecimal valor, BigDecimal baseCalculo) {
        this.movPatronoPK = movPatronoPK;
        this.vpr = vpr;
        this.factor = factor;
        this.valor = valor;
        this.baseCalculo = baseCalculo;
    }

    public MovPatrono(short codCia, short anio, short mes, short numPlanilla, int noMovto) {
        this.movPatronoPK = new MovPatronoPK(codCia, anio, mes, numPlanilla, noMovto);
    }

    public MovPatronoPK getMovPatronoPK() {
        return movPatronoPK;
    }

    public void setMovPatronoPK(MovPatronoPK movPatronoPK) {
        this.movPatronoPK = movPatronoPK;
    }

    public String getVpr() {
        return vpr;
    }

    public void setVpr(String vpr) {
        this.vpr = vpr;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(BigDecimal baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public Date getFechaMovto() {
        return fechaMovto;
    }

    public void setFechaMovto(Date fechaMovto) {
        this.fechaMovto = fechaMovto;
    }

    public String getSumaResta() {
        return sumaResta;
    }

    public void setSumaResta(String sumaResta) {
        this.sumaResta = sumaResta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public Integer getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(Integer numCheque) {
        this.numCheque = numCheque;
    }

    public String getGenerado() {
        return generado;
    }

    public void setGenerado(String generado) {
        this.generado = generado;
    }

    public Integer getCodPresta() {
        return codPresta;
    }

    public void setCodPresta(Integer codPresta) {
        this.codPresta = codPresta;
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

    public DeducPresta getDeducPresta() {
        return deducPresta;
    }

    public void setDeducPresta(DeducPresta deducPresta) {
        this.deducPresta = deducPresta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movPatronoPK != null ? movPatronoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovPatrono)) {
            return false;
        }
        MovPatrono other = (MovPatrono) object;
        if ((this.movPatronoPK == null && other.movPatronoPK != null) || (this.movPatronoPK != null && !this.movPatronoPK.equals(other.movPatronoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.MovPatrono[ movPatronoPK=" + movPatronoPK + " ]";
    }
    
}
