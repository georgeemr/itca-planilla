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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DESCUENTO_PRESTAMOS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescuentoPrestamos.findAll", query = "SELECT d FROM DescuentoPrestamos d"),
    @NamedQuery(name = "DescuentoPrestamos.findByCodCia", query = "SELECT d FROM DescuentoPrestamos d WHERE d.descuentoPrestamosPK.codCia = :codCia"),
    @NamedQuery(name = "DescuentoPrestamos.findByAnio", query = "SELECT d FROM DescuentoPrestamos d WHERE d.descuentoPrestamosPK.anio = :anio"),
    @NamedQuery(name = "DescuentoPrestamos.findByMes", query = "SELECT d FROM DescuentoPrestamos d WHERE d.descuentoPrestamosPK.mes = :mes"),
    @NamedQuery(name = "DescuentoPrestamos.findByCodTipopla", query = "SELECT d FROM DescuentoPrestamos d WHERE d.descuentoPrestamosPK.codTipopla = :codTipopla"),
    @NamedQuery(name = "DescuentoPrestamos.findByNumPlanilla", query = "SELECT d FROM DescuentoPrestamos d WHERE d.descuentoPrestamosPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "DescuentoPrestamos.findByCorrelativo", query = "SELECT d FROM DescuentoPrestamos d WHERE d.descuentoPrestamosPK.correlativo = :correlativo"),
    @NamedQuery(name = "DescuentoPrestamos.findByCodPresta", query = "SELECT d FROM DescuentoPrestamos d WHERE d.codPresta = :codPresta"),
    @NamedQuery(name = "DescuentoPrestamos.findByCodEmp", query = "SELECT d FROM DescuentoPrestamos d WHERE d.codEmp = :codEmp"),
    @NamedQuery(name = "DescuentoPrestamos.findByNomEmpleado", query = "SELECT d FROM DescuentoPrestamos d WHERE d.nomEmpleado = :nomEmpleado"),
    @NamedQuery(name = "DescuentoPrestamos.findByCuotaApagar", query = "SELECT d FROM DescuentoPrestamos d WHERE d.cuotaApagar = :cuotaApagar"),
    @NamedQuery(name = "DescuentoPrestamos.findByNumPagos", query = "SELECT d FROM DescuentoPrestamos d WHERE d.numPagos = :numPagos"),
    @NamedQuery(name = "DescuentoPrestamos.findByPaga", query = "SELECT d FROM DescuentoPrestamos d WHERE d.paga = :paga"),
    @NamedQuery(name = "DescuentoPrestamos.findByCodDeduc", query = "SELECT d FROM DescuentoPrestamos d WHERE d.codDeduc = :codDeduc"),
    @NamedQuery(name = "DescuentoPrestamos.findByValorPresta", query = "SELECT d FROM DescuentoPrestamos d WHERE d.valorPresta = :valorPresta"),
    @NamedQuery(name = "DescuentoPrestamos.findByPPago", query = "SELECT d FROM DescuentoPrestamos d WHERE d.pPago = :pPago"),
    @NamedQuery(name = "DescuentoPrestamos.findByCuota", query = "SELECT d FROM DescuentoPrestamos d WHERE d.cuota = :cuota"),
    @NamedQuery(name = "DescuentoPrestamos.findByUPago", query = "SELECT d FROM DescuentoPrestamos d WHERE d.uPago = :uPago"),
    @NamedQuery(name = "DescuentoPrestamos.findBySaldoActual", query = "SELECT d FROM DescuentoPrestamos d WHERE d.saldoActual = :saldoActual"),
    @NamedQuery(name = "DescuentoPrestamos.findByCodDepto", query = "SELECT d FROM DescuentoPrestamos d WHERE d.codDepto = :codDepto"),
    @NamedQuery(name = "DescuentoPrestamos.findByPagosHechos", query = "SELECT d FROM DescuentoPrestamos d WHERE d.pagosHechos = :pagosHechos")})
public class DescuentoPrestamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DescuentoPrestamosPK descuentoPrestamosPK;
    @Column(name = "COD_PRESTA")
    private Integer codPresta;
    @Column(name = "COD_EMP")
    private Integer codEmp;
    @Size(max = 100)
    @Column(name = "NOM_EMPLEADO", length = 100)
    private String nomEmpleado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CUOTA_APAGAR", precision = 12, scale = 2)
    private BigDecimal cuotaApagar;
    @Column(name = "NUM_PAGOS")
    private Short numPagos;
    @Size(max = 1)
    @Column(name = "PAGA", length = 1)
    private String paga;
    @Column(name = "COD_DEDUC")
    private Integer codDeduc;
    @Column(name = "VALOR_PRESTA", precision = 12, scale = 2)
    private BigDecimal valorPresta;
    @Column(name = "P_PAGO")
    private Long pPago;
    @Column(name = "CUOTA")
    private Long cuota;
    @Column(name = "U_PAGO")
    private Long uPago;
    @Column(name = "SALDO_ACTUAL", precision = 12, scale = 2)
    private BigDecimal saldoActual;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "PAGOS_HECHOS")
    private Long pagosHechos;

    public DescuentoPrestamos() {
    }

    public DescuentoPrestamos(DescuentoPrestamosPK descuentoPrestamosPK) {
        this.descuentoPrestamosPK = descuentoPrestamosPK;
    }

    public DescuentoPrestamos(short codCia, short anio, short mes, short codTipopla, short numPlanilla, int correlativo) {
        this.descuentoPrestamosPK = new DescuentoPrestamosPK(codCia, anio, mes, codTipopla, numPlanilla, correlativo);
    }

    public DescuentoPrestamosPK getDescuentoPrestamosPK() {
        return descuentoPrestamosPK;
    }

    public void setDescuentoPrestamosPK(DescuentoPrestamosPK descuentoPrestamosPK) {
        this.descuentoPrestamosPK = descuentoPrestamosPK;
    }

    public Integer getCodPresta() {
        return codPresta;
    }

    public void setCodPresta(Integer codPresta) {
        this.codPresta = codPresta;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public BigDecimal getCuotaApagar() {
        return cuotaApagar;
    }

    public void setCuotaApagar(BigDecimal cuotaApagar) {
        this.cuotaApagar = cuotaApagar;
    }

    public Short getNumPagos() {
        return numPagos;
    }

    public void setNumPagos(Short numPagos) {
        this.numPagos = numPagos;
    }

    public String getPaga() {
        return paga;
    }

    public void setPaga(String paga) {
        this.paga = paga;
    }

    public Integer getCodDeduc() {
        return codDeduc;
    }

    public void setCodDeduc(Integer codDeduc) {
        this.codDeduc = codDeduc;
    }

    public BigDecimal getValorPresta() {
        return valorPresta;
    }

    public void setValorPresta(BigDecimal valorPresta) {
        this.valorPresta = valorPresta;
    }

    public Long getPPago() {
        return pPago;
    }

    public void setPPago(Long pPago) {
        this.pPago = pPago;
    }

    public Long getCuota() {
        return cuota;
    }

    public void setCuota(Long cuota) {
        this.cuota = cuota;
    }

    public Long getUPago() {
        return uPago;
    }

    public void setUPago(Long uPago) {
        this.uPago = uPago;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public Long getPagosHechos() {
        return pagosHechos;
    }

    public void setPagosHechos(Long pagosHechos) {
        this.pagosHechos = pagosHechos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descuentoPrestamosPK != null ? descuentoPrestamosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescuentoPrestamos)) {
            return false;
        }
        DescuentoPrestamos other = (DescuentoPrestamos) object;
        if ((this.descuentoPrestamosPK == null && other.descuentoPrestamosPK != null) || (this.descuentoPrestamosPK != null && !this.descuentoPrestamosPK.equals(other.descuentoPrestamosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DescuentoPrestamos[ descuentoPrestamosPK=" + descuentoPrestamosPK + " ]";
    }
    
}
