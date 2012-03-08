/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
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
    @NamedQuery(name = "MovDp.findByVpr", query = "SELECT m FROM MovDp m WHERE m.vpr = :vpr"),
    @NamedQuery(name = "MovDp.findByFactor", query = "SELECT m FROM MovDp m WHERE m.factor = :factor"),
    @NamedQuery(name = "MovDp.findByValor", query = "SELECT m FROM MovDp m WHERE m.valor = :valor"),
    @NamedQuery(name = "MovDp.findByBaseCalculo", query = "SELECT m FROM MovDp m WHERE m.baseCalculo = :baseCalculo"),
    @NamedQuery(name = "MovDp.findByFechaMovto", query = "SELECT m FROM MovDp m WHERE m.fechaMovto = :fechaMovto"),
    @NamedQuery(name = "MovDp.findBySumaResta", query = "SELECT m FROM MovDp m WHERE m.sumaResta = :sumaResta"),
    @NamedQuery(name = "MovDp.findByStatus", query = "SELECT m FROM MovDp m WHERE m.status = :status"),
    @NamedQuery(name = "MovDp.findBySecuencia", query = "SELECT m FROM MovDp m WHERE m.secuencia = :secuencia"),
    @NamedQuery(name = "MovDp.findByNumCheque", query = "SELECT m FROM MovDp m WHERE m.numCheque = :numCheque"),
    @NamedQuery(name = "MovDp.findByGenerado", query = "SELECT m FROM MovDp m WHERE m.generado = :generado"),
    @NamedQuery(name = "MovDp.findByCodPresta", query = "SELECT m FROM MovDp m WHERE m.codPresta = :codPresta"),
    @NamedQuery(name = "MovDp.findByConstancia", query = "SELECT m FROM MovDp m WHERE m.constancia = :constancia")})
public class MovDp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovDpPK movDpPK;
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
    @Basic(optional = false)
    @Column(name = "FECHA_MOVTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovto;
    @Basic(optional = false)
    @Column(name = "SUMA_RESTA", nullable = false, length = 1)
    private String sumaResta;
    @Basic(optional = false)
    @Column(name = "STATUS", nullable = false, length = 1)
    private String status;
    @Column(name = "SECUENCIA")
    private Integer secuencia;
    @Column(name = "NUM_CHEQUE")
    private Integer numCheque;
    @Column(name = "GENERADO", length = 1)
    private String generado;
    @Column(name = "COD_PRESTA")
    private Short codPresta;
    @Column(name = "CONSTANCIA", length = 1)
    private String constancia;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "MES", referencedColumnName = "MES", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA"),
        @JoinColumn(name = "NUM_PLANILLA", referencedColumnName = "NUM_PLANILLA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false)})
    @ManyToOne(optional = false)
    private ResumenAsistencia resumenAsistencia;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO")})
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DP", referencedColumnName = "COD_DP", nullable = false)})
    @ManyToOne(optional = false)
    private DeducPresta deducPresta;

    public MovDp() {
    }

    public MovDp(MovDpPK movDpPK) {
        this.movDpPK = movDpPK;
    }

    public MovDp(MovDpPK movDpPK, String vpr, BigDecimal factor, BigDecimal valor, BigDecimal baseCalculo, Date fechaMovto, String sumaResta, String status) {
        this.movDpPK = movDpPK;
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

    public Short getCodPresta() {
        return codPresta;
    }

    public void setCodPresta(Short codPresta) {
        this.codPresta = codPresta;
    }

    public String getConstancia() {
        return constancia;
    }

    public void setConstancia(String constancia) {
        this.constancia = constancia;
    }

    public ResumenAsistencia getResumenAsistencia() {
        return resumenAsistencia;
    }

    public void setResumenAsistencia(ResumenAsistencia resumenAsistencia) {
        this.resumenAsistencia = resumenAsistencia;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
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
