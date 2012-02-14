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
@Table(name = "MOV_DP", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovDp.findAll", query = "SELECT m FROM MovDp m"),
    @NamedQuery(name = "MovDp.findByCodCia", query = "SELECT m FROM MovDp m WHERE m.movDpPK.codCia = :codCia"),
    @NamedQuery(name = "MovDp.findByAnio", query = "SELECT m FROM MovDp m WHERE m.movDpPK.anio = :anio"),
    @NamedQuery(name = "MovDp.findByMes", query = "SELECT m FROM MovDp m WHERE m.movDpPK.mes = :mes"),
    @NamedQuery(name = "MovDp.findByNumPlanilla", query = "SELECT m FROM MovDp m WHERE m.movDpPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "MovDp.findByNoMovto", query = "SELECT m FROM MovDp m WHERE m.movDpPK.noMovto = :noMovto"),
    @NamedQuery(name = "MovDp.findByCodEmp", query = "SELECT m FROM MovDp m WHERE m.codEmp = :codEmp"),
    @NamedQuery(name = "MovDp.findByCodDp", query = "SELECT m FROM MovDp m WHERE m.codDp = :codDp"),
    @NamedQuery(name = "MovDp.findByVpr", query = "SELECT m FROM MovDp m WHERE m.vpr = :vpr"),
    @NamedQuery(name = "MovDp.findByFactor", query = "SELECT m FROM MovDp m WHERE m.factor = :factor"),
    @NamedQuery(name = "MovDp.findByValor", query = "SELECT m FROM MovDp m WHERE m.valor = :valor"),
    @NamedQuery(name = "MovDp.findByBaseCalculo", query = "SELECT m FROM MovDp m WHERE m.baseCalculo = :baseCalculo"),
    @NamedQuery(name = "MovDp.findByFechaMovto", query = "SELECT m FROM MovDp m WHERE m.fechaMovto = :fechaMovto"),
    @NamedQuery(name = "MovDp.findBySumaResta", query = "SELECT m FROM MovDp m WHERE m.sumaResta = :sumaResta"),
    @NamedQuery(name = "MovDp.findByStatus", query = "SELECT m FROM MovDp m WHERE m.status = :status"),
    @NamedQuery(name = "MovDp.findBySecuencia", query = "SELECT m FROM MovDp m WHERE m.secuencia = :secuencia"),
    @NamedQuery(name = "MovDp.findByNumCheque", query = "SELECT m FROM MovDp m WHERE m.numCheque = :numCheque"),
    @NamedQuery(name = "MovDp.findByCodDepto", query = "SELECT m FROM MovDp m WHERE m.codDepto = :codDepto"),
    @NamedQuery(name = "MovDp.findByGenerado", query = "SELECT m FROM MovDp m WHERE m.generado = :generado"),
    @NamedQuery(name = "MovDp.findByCodPresta", query = "SELECT m FROM MovDp m WHERE m.codPresta = :codPresta"),
    @NamedQuery(name = "MovDp.findByCodTipopla", query = "SELECT m FROM MovDp m WHERE m.codTipopla = :codTipopla"),
    @NamedQuery(name = "MovDp.findByConstancia", query = "SELECT m FROM MovDp m WHERE m.constancia = :constancia")})
public class MovDp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovDpPK movDpPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DP", nullable = false)
    private int codDp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "VPR", nullable = false, length = 1)
    private String vpr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "FACTOR", nullable = false, precision = 8, scale = 4)
    private BigDecimal factor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR", nullable = false, precision = 16, scale = 2)
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BASE_CALCULO", nullable = false, precision = 16, scale = 2)
    private BigDecimal baseCalculo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MOVTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SUMA_RESTA", nullable = false, length = 1)
    private String sumaResta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS", nullable = false, length = 1)
    private String status;
    @Column(name = "SECUENCIA")
    private Integer secuencia;
    @Column(name = "NUM_CHEQUE")
    private Integer numCheque;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Size(max = 1)
    @Column(name = "GENERADO", length = 1)
    private String generado;
    @Column(name = "COD_PRESTA")
    private Short codPresta;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @Size(max = 1)
    @Column(name = "CONSTANCIA", length = 1)
    private String constancia;

    public MovDp() {
    }

    public MovDp(MovDpPK movDpPK) {
        this.movDpPK = movDpPK;
    }

    public MovDp(MovDpPK movDpPK, int codEmp, int codDp, String vpr, BigDecimal factor, BigDecimal valor, BigDecimal baseCalculo, Date fechaMovto, String sumaResta, String status) {
        this.movDpPK = movDpPK;
        this.codEmp = codEmp;
        this.codDp = codDp;
        this.vpr = vpr;
        this.factor = factor;
        this.valor = valor;
        this.baseCalculo = baseCalculo;
        this.fechaMovto = fechaMovto;
        this.sumaResta = sumaResta;
        this.status = status;
    }

    public MovDp(short codCia, short anio, short mes, short numPlanilla, int noMovto) {
        this.movDpPK = new MovDpPK(codCia, anio, mes, numPlanilla, noMovto);
    }

    public MovDpPK getMovDpPK() {
        return movDpPK;
    }

    public void setMovDpPK(MovDpPK movDpPK) {
        this.movDpPK = movDpPK;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public int getCodDp() {
        return codDp;
    }

    public void setCodDp(int codDp) {
        this.codDp = codDp;
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

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public String getGenerado() {
        return generado;
    }

    public void setGenerado(String generado) {
        this.generado = generado;
    }

    public Short getCodPresta() {
        return codPresta;
    }

    public void setCodPresta(Short codPresta) {
        this.codPresta = codPresta;
    }

    public Short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(Short codTipopla) {
        this.codTipopla = codTipopla;
    }

    public String getConstancia() {
        return constancia;
    }

    public void setConstancia(String constancia) {
        this.constancia = constancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movDpPK != null ? movDpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovDp)) {
            return false;
        }
        MovDp other = (MovDp) object;
        if ((this.movDpPK == null && other.movDpPK != null) || (this.movDpPK != null && !this.movDpPK.equals(other.movDpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.MovDp[ movDpPK=" + movDpPK + " ]";
    }
    
}
