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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PLANILLA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p"),
    @NamedQuery(name = "Planilla.findByCodCia", query = "SELECT p FROM Planilla p WHERE p.planillaPK.codCia = :codCia"),
    @NamedQuery(name = "Planilla.findByAnio", query = "SELECT p FROM Planilla p WHERE p.planillaPK.anio = :anio"),
    @NamedQuery(name = "Planilla.findByMes", query = "SELECT p FROM Planilla p WHERE p.planillaPK.mes = :mes"),
    @NamedQuery(name = "Planilla.findByNumPlanilla", query = "SELECT p FROM Planilla p WHERE p.planillaPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "Planilla.findByCodEmp", query = "SELECT p FROM Planilla p WHERE p.planillaPK.codEmp = :codEmp"),
    @NamedQuery(name = "Planilla.findByPrestaciones", query = "SELECT p FROM Planilla p WHERE p.prestaciones = :prestaciones"),
    @NamedQuery(name = "Planilla.findByDeducciones", query = "SELECT p FROM Planilla p WHERE p.deducciones = :deducciones"),
    @NamedQuery(name = "Planilla.findByComisiones", query = "SELECT p FROM Planilla p WHERE p.comisiones = :comisiones"),
    @NamedQuery(name = "Planilla.findBySueldoBase", query = "SELECT p FROM Planilla p WHERE p.sueldoBase = :sueldoBase"),
    @NamedQuery(name = "Planilla.findByBonificacion", query = "SELECT p FROM Planilla p WHERE p.bonificacion = :bonificacion"),
    @NamedQuery(name = "Planilla.findByDLaborados", query = "SELECT p FROM Planilla p WHERE p.dLaborados = :dLaborados"),
    @NamedQuery(name = "Planilla.findByChXsencilla", query = "SELECT p FROM Planilla p WHERE p.chXsencilla = :chXsencilla"),
    @NamedQuery(name = "Planilla.findByChXdoble", query = "SELECT p FROM Planilla p WHERE p.chXdoble = :chXdoble"),
    @NamedQuery(name = "Planilla.findByVhXsencilla", query = "SELECT p FROM Planilla p WHERE p.vhXsencilla = :vhXsencilla"),
    @NamedQuery(name = "Planilla.findByVhXdoble", query = "SELECT p FROM Planilla p WHERE p.vhXdoble = :vhXdoble"),
    @NamedQuery(name = "Planilla.findByTotDebenga", query = "SELECT p FROM Planilla p WHERE p.totDebenga = :totDebenga"),
    @NamedQuery(name = "Planilla.findByLiqRecibir", query = "SELECT p FROM Planilla p WHERE p.liqRecibir = :liqRecibir"),
    @NamedQuery(name = "Planilla.findByStatus", query = "SELECT p FROM Planilla p WHERE p.status = :status"),
    @NamedQuery(name = "Planilla.findByVhrNoche", query = "SELECT p FROM Planilla p WHERE p.vhrNoche = :vhrNoche"),
    @NamedQuery(name = "Planilla.findByChrNoche", query = "SELECT p FROM Planilla p WHERE p.chrNoche = :chrNoche"),
    @NamedQuery(name = "Planilla.findByCodTipopla", query = "SELECT p FROM Planilla p WHERE p.codTipopla = :codTipopla"),
    @NamedQuery(name = "Planilla.findByChX250", query = "SELECT p FROM Planilla p WHERE p.chX250 = :chX250"),
    @NamedQuery(name = "Planilla.findByVhX250", query = "SELECT p FROM Planilla p WHERE p.vhX250 = :vhX250"),
    @NamedQuery(name = "Planilla.findByChHora", query = "SELECT p FROM Planilla p WHERE p.chHora = :chHora"),
    @NamedQuery(name = "Planilla.findByVhHora", query = "SELECT p FROM Planilla p WHERE p.vhHora = :vhHora"),
    @NamedQuery(name = "Planilla.findByChX150", query = "SELECT p FROM Planilla p WHERE p.chX150 = :chX150"),
    @NamedQuery(name = "Planilla.findByVhX150", query = "SELECT p FROM Planilla p WHERE p.vhX150 = :vhX150"),
    @NamedQuery(name = "Planilla.findByCodDepto", query = "SELECT p FROM Planilla p WHERE p.codDepto = :codDepto"),
    @NamedQuery(name = "Planilla.findByCodAfp", query = "SELECT p FROM Planilla p WHERE p.codAfp = :codAfp"),
    @NamedQuery(name = "Planilla.findByFactorDp", query = "SELECT p FROM Planilla p WHERE p.factorDp = :factorDp"),
    @NamedQuery(name = "Planilla.findByEstado", query = "SELECT p FROM Planilla p WHERE p.estado = :estado"),
    @NamedQuery(name = "Planilla.findByFecha", query = "SELECT p FROM Planilla p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Planilla.findByCodSucursal", query = "SELECT p FROM Planilla p WHERE p.codSucursal = :codSucursal"),
    @NamedQuery(name = "Planilla.findByChequeDep", query = "SELECT p FROM Planilla p WHERE p.chequeDep = :chequeDep"),
    @NamedQuery(name = "Planilla.findByAntipag", query = "SELECT p FROM Planilla p WHERE p.antipag = :antipag"),
    @NamedQuery(name = "Planilla.findByCodSeccion", query = "SELECT p FROM Planilla p WHERE p.codSeccion = :codSeccion")})
public class Planilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanillaPK planillaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRESTACIONES", nullable = false, precision = 16, scale = 2)
    private BigDecimal prestaciones;
    @Basic(optional = false)
    @Column(name = "DEDUCCIONES", nullable = false, precision = 16, scale = 2)
    private BigDecimal deducciones;
    @Basic(optional = false)
    @Column(name = "COMISIONES", nullable = false, precision = 16, scale = 2)
    private BigDecimal comisiones;
    @Basic(optional = false)
    @Column(name = "SUELDO_BASE", nullable = false, precision = 16, scale = 2)
    private BigDecimal sueldoBase;
    @Basic(optional = false)
    @Column(name = "BONIFICACION", nullable = false, precision = 16, scale = 2)
    private BigDecimal bonificacion;
    @Basic(optional = false)
    @Column(name = "D_LABORADOS", nullable = false, precision = 16, scale = 2)
    private BigDecimal dLaborados;
    @Basic(optional = false)
    @Column(name = "CH_XSENCILLA", nullable = false, precision = 6, scale = 2)
    private BigDecimal chXsencilla;
    @Basic(optional = false)
    @Column(name = "CH_XDOBLE", nullable = false, precision = 6, scale = 2)
    private BigDecimal chXdoble;
    @Basic(optional = false)
    @Column(name = "VH_XSENCILLA", nullable = false, precision = 16, scale = 2)
    private BigDecimal vhXsencilla;
    @Basic(optional = false)
    @Column(name = "VH_XDOBLE", nullable = false, precision = 16, scale = 2)
    private BigDecimal vhXdoble;
    @Basic(optional = false)
    @Column(name = "TOT_DEBENGA", nullable = false, precision = 16, scale = 2)
    private BigDecimal totDebenga;
    @Basic(optional = false)
    @Column(name = "LIQ_RECIBIR", nullable = false, precision = 16, scale = 2)
    private BigDecimal liqRecibir;
    @Basic(optional = false)
    @Column(name = "STATUS", nullable = false, length = 1)
    private String status;
    @Column(name = "VHR_NOCHE", precision = 16, scale = 2)
    private BigDecimal vhrNoche;
    @Column(name = "CHR_NOCHE", precision = 8, scale = 2)
    private BigDecimal chrNoche;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @Column(name = "CH_X250", precision = 6, scale = 2)
    private BigDecimal chX250;
    @Column(name = "VH_X250", precision = 16, scale = 2)
    private BigDecimal vhX250;
    @Column(name = "CH_HORA", precision = 6, scale = 2)
    private BigDecimal chHora;
    @Column(name = "VH_HORA", precision = 16, scale = 2)
    private BigDecimal vhHora;
    @Column(name = "CH_X150", precision = 6, scale = 2)
    private BigDecimal chX150;
    @Column(name = "VH_X150", precision = 16, scale = 2)
    private BigDecimal vhX150;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "COD_AFP")
    private Integer codAfp;
    @Column(name = "FACTOR_DP", precision = 8, scale = 4)
    private BigDecimal factorDp;
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "COD_SUCURSAL", length = 2)
    private String codSucursal;
    @Column(name = "CHEQUE_DEP", length = 1)
    private String chequeDep;
    @Column(name = "ANTIPAG", precision = 16, scale = 2)
    private BigDecimal antipag;
    @Column(name = "COD_SECCION")
    private Short codSeccion;
    @Transient
    private String pkAsString;
    
    public Planilla() {
    }

    public Planilla(PlanillaPK planillaPK) {
        this.planillaPK = planillaPK;
    }

    public Planilla(PlanillaPK planillaPK, BigDecimal prestaciones, BigDecimal deducciones, BigDecimal comisiones, BigDecimal sueldoBase, BigDecimal bonificacion, BigDecimal dLaborados, BigDecimal chXsencilla, BigDecimal chXdoble, BigDecimal vhXsencilla, BigDecimal vhXdoble, BigDecimal totDebenga, BigDecimal liqRecibir, String status) {
        this.planillaPK = planillaPK;
        this.prestaciones = prestaciones;
        this.deducciones = deducciones;
        this.comisiones = comisiones;
        this.sueldoBase = sueldoBase;
        this.bonificacion = bonificacion;
        this.dLaborados = dLaborados;
        this.chXsencilla = chXsencilla;
        this.chXdoble = chXdoble;
        this.vhXsencilla = vhXsencilla;
        this.vhXdoble = vhXdoble;
        this.totDebenga = totDebenga;
        this.liqRecibir = liqRecibir;
        this.status = status;
    }

    public Planilla(short codCia, short anio, short mes, short numPlanilla, int codEmp) {
        this.planillaPK = new PlanillaPK(codCia, anio, mes, numPlanilla, codEmp);
    }

    public PlanillaPK getPlanillaPK() {
        return planillaPK;
    }

    public void setPlanillaPK(PlanillaPK planillaPK) {
        this.planillaPK = planillaPK;
    }

    public BigDecimal getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(BigDecimal prestaciones) {
        this.prestaciones = prestaciones;
    }

    public BigDecimal getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(BigDecimal deducciones) {
        this.deducciones = deducciones;
    }

    public BigDecimal getComisiones() {
        return comisiones;
    }

    public void setComisiones(BigDecimal comisiones) {
        this.comisiones = comisiones;
    }

    public BigDecimal getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(BigDecimal sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public BigDecimal getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(BigDecimal bonificacion) {
        this.bonificacion = bonificacion;
    }

    public BigDecimal getDLaborados() {
        return dLaborados;
    }

    public void setDLaborados(BigDecimal dLaborados) {
        this.dLaborados = dLaborados;
    }

    public BigDecimal getChXsencilla() {
        return chXsencilla;
    }

    public void setChXsencilla(BigDecimal chXsencilla) {
        this.chXsencilla = chXsencilla;
    }

    public BigDecimal getChXdoble() {
        return chXdoble;
    }

    public void setChXdoble(BigDecimal chXdoble) {
        this.chXdoble = chXdoble;
    }

    public BigDecimal getVhXsencilla() {
        return vhXsencilla;
    }

    public void setVhXsencilla(BigDecimal vhXsencilla) {
        this.vhXsencilla = vhXsencilla;
    }

    public BigDecimal getVhXdoble() {
        return vhXdoble;
    }

    public void setVhXdoble(BigDecimal vhXdoble) {
        this.vhXdoble = vhXdoble;
    }

    public BigDecimal getTotDebenga() {
        return totDebenga;
    }

    public void setTotDebenga(BigDecimal totDebenga) {
        this.totDebenga = totDebenga;
    }

    public BigDecimal getLiqRecibir() {
        return liqRecibir;
    }

    public void setLiqRecibir(BigDecimal liqRecibir) {
        this.liqRecibir = liqRecibir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getVhrNoche() {
        return vhrNoche;
    }

    public void setVhrNoche(BigDecimal vhrNoche) {
        this.vhrNoche = vhrNoche;
    }

    public BigDecimal getChrNoche() {
        return chrNoche;
    }

    public void setChrNoche(BigDecimal chrNoche) {
        this.chrNoche = chrNoche;
    }

    public Short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(Short codTipopla) {
        this.codTipopla = codTipopla;
    }

    public BigDecimal getChX250() {
        return chX250;
    }

    public void setChX250(BigDecimal chX250) {
        this.chX250 = chX250;
    }

    public BigDecimal getVhX250() {
        return vhX250;
    }

    public void setVhX250(BigDecimal vhX250) {
        this.vhX250 = vhX250;
    }

    public BigDecimal getChHora() {
        return chHora;
    }

    public void setChHora(BigDecimal chHora) {
        this.chHora = chHora;
    }

    public BigDecimal getVhHora() {
        return vhHora;
    }

    public void setVhHora(BigDecimal vhHora) {
        this.vhHora = vhHora;
    }

    public BigDecimal getChX150() {
        return chX150;
    }

    public void setChX150(BigDecimal chX150) {
        this.chX150 = chX150;
    }

    public BigDecimal getVhX150() {
        return vhX150;
    }

    public void setVhX150(BigDecimal vhX150) {
        this.vhX150 = vhX150;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public Integer getCodAfp() {
        return codAfp;
    }

    public void setCodAfp(Integer codAfp) {
        this.codAfp = codAfp;
    }

    public BigDecimal getFactorDp() {
        return factorDp;
    }

    public void setFactorDp(BigDecimal factorDp) {
        this.factorDp = factorDp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getChequeDep() {
        return chequeDep;
    }

    public void setChequeDep(String chequeDep) {
        this.chequeDep = chequeDep;
    }

    public BigDecimal getAntipag() {
        return antipag;
    }

    public void setAntipag(BigDecimal antipag) {
        this.antipag = antipag;
    }

    public Short getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(Short codSeccion) {
        this.codSeccion = codSeccion;
    }

    public String getPkAsString() {
        pkAsString = "" + this.planillaPK.getCodCia() + ":" + this.planillaPK.getAnio() + ":" + this.planillaPK.getMes() + ":" + this.planillaPK.getNumPlanilla() + ":" + this.planillaPK.getCodEmp() + ":" + this.getCodTipopla();
        return pkAsString;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planillaPK != null ? planillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.planillaPK == null && other.planillaPK != null) || (this.planillaPK != null && !this.planillaPK.equals(other.planillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Planilla[ planillaPK=" + planillaPK + " ]";
    }
    
}