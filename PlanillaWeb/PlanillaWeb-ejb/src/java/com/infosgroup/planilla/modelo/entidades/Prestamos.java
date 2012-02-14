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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PRESTAMOS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamos.findAll", query = "SELECT p FROM Prestamos p"),
    @NamedQuery(name = "Prestamos.findByNumCheque", query = "SELECT p FROM Prestamos p WHERE p.numCheque = :numCheque"),
    @NamedQuery(name = "Prestamos.findByOPago", query = "SELECT p FROM Prestamos p WHERE p.oPago = :oPago"),
    @NamedQuery(name = "Prestamos.findByRefOPago", query = "SELECT p FROM Prestamos p WHERE p.refOPago = :refOPago"),
    @NamedQuery(name = "Prestamos.findByCodCia", query = "SELECT p FROM Prestamos p WHERE p.prestamosPK.codCia = :codCia"),
    @NamedQuery(name = "Prestamos.findByCodPresta", query = "SELECT p FROM Prestamos p WHERE p.prestamosPK.codPresta = :codPresta"),
    @NamedQuery(name = "Prestamos.findByCodEmp", query = "SELECT p FROM Prestamos p WHERE p.prestamosPK.codEmp = :codEmp"),
    @NamedQuery(name = "Prestamos.findByCodPres", query = "SELECT p FROM Prestamos p WHERE p.codPres = :codPres"),
    @NamedQuery(name = "Prestamos.findByCodDeduc", query = "SELECT p FROM Prestamos p WHERE p.codDeduc = :codDeduc"),
    @NamedQuery(name = "Prestamos.findByDescripcion", query = "SELECT p FROM Prestamos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Prestamos.findByValorPresta", query = "SELECT p FROM Prestamos p WHERE p.valorPresta = :valorPresta"),
    @NamedQuery(name = "Prestamos.findByNumPagos", query = "SELECT p FROM Prestamos p WHERE p.numPagos = :numPagos"),
    @NamedQuery(name = "Prestamos.findByPagosHechos", query = "SELECT p FROM Prestamos p WHERE p.pagosHechos = :pagosHechos"),
    @NamedQuery(name = "Prestamos.findByPPago", query = "SELECT p FROM Prestamos p WHERE p.pPago = :pPago"),
    @NamedQuery(name = "Prestamos.findByCuota", query = "SELECT p FROM Prestamos p WHERE p.cuota = :cuota"),
    @NamedQuery(name = "Prestamos.findByUPago", query = "SELECT p FROM Prestamos p WHERE p.uPago = :uPago"),
    @NamedQuery(name = "Prestamos.findBySaldoActual", query = "SELECT p FROM Prestamos p WHERE p.saldoActual = :saldoActual"),
    @NamedQuery(name = "Prestamos.findByObservacion", query = "SELECT p FROM Prestamos p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "Prestamos.findByUltimoMes", query = "SELECT p FROM Prestamos p WHERE p.ultimoMes = :ultimoMes"),
    @NamedQuery(name = "Prestamos.findByUltimoAnio", query = "SELECT p FROM Prestamos p WHERE p.ultimoAnio = :ultimoAnio"),
    @NamedQuery(name = "Prestamos.findBySecuencia", query = "SELECT p FROM Prestamos p WHERE p.secuencia = :secuencia"),
    @NamedQuery(name = "Prestamos.findByNumPrestamoref", query = "SELECT p FROM Prestamos p WHERE p.numPrestamoref = :numPrestamoref"),
    @NamedQuery(name = "Prestamos.findByDescQuinc", query = "SELECT p FROM Prestamos p WHERE p.descQuinc = :descQuinc"),
    @NamedQuery(name = "Prestamos.findByCuotaReal", query = "SELECT p FROM Prestamos p WHERE p.cuotaReal = :cuotaReal"),
    @NamedQuery(name = "Prestamos.findByFecha", query = "SELECT p FROM Prestamos p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Prestamos.findByUsuario", query = "SELECT p FROM Prestamos p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "Prestamos.findByModificadoPor", query = "SELECT p FROM Prestamos p WHERE p.modificadoPor = :modificadoPor"),
    @NamedQuery(name = "Prestamos.findByNoCuenta", query = "SELECT p FROM Prestamos p WHERE p.noCuenta = :noCuenta"),
    @NamedQuery(name = "Prestamos.findByCodCliente", query = "SELECT p FROM Prestamos p WHERE p.codCliente = :codCliente"),
    @NamedQuery(name = "Prestamos.findByFechaCancela", query = "SELECT p FROM Prestamos p WHERE p.fechaCancela = :fechaCancela")})
public class Prestamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrestamosPK prestamosPK;
    @Column(name = "NUM_CHEQUE")
    private Integer numCheque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "O_PAGO", precision = 10, scale = 2)
    private BigDecimal oPago;
    @Size(max = 60)
    @Column(name = "REF_O_PAGO", length = 60)
    private String refOPago;
    @Column(name = "COD_PRES")
    private Short codPres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DEDUC", nullable = false)
    private int codDeduc;
    @Size(max = 60)
    @Column(name = "DESCRIPCION", length = 60)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_PRESTA", nullable = false, precision = 16, scale = 2)
    private BigDecimal valorPresta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PAGOS", nullable = false)
    private short numPagos;
    @Column(name = "PAGOS_HECHOS")
    private Short pagosHechos;
    @Column(name = "P_PAGO", precision = 16, scale = 2)
    private BigDecimal pPago;
    @Column(name = "CUOTA", precision = 16, scale = 2)
    private BigDecimal cuota;
    @Column(name = "U_PAGO", precision = 16, scale = 2)
    private BigDecimal uPago;
    @Column(name = "SALDO_ACTUAL", precision = 16, scale = 2)
    private BigDecimal saldoActual;
    @Size(max = 200)
    @Column(name = "OBSERVACION", length = 200)
    private String observacion;
    @Column(name = "ULTIMO_MES")
    private Short ultimoMes;
    @Column(name = "ULTIMO_ANIO")
    private Short ultimoAnio;
    @Column(name = "SECUENCIA")
    private Integer secuencia;
    @Size(max = 25)
    @Column(name = "NUM_PRESTAMOREF", length = 25)
    private String numPrestamoref;
    @Column(name = "DESC_QUINC")
    private Short descQuinc;
    @Column(name = "CUOTA_REAL", precision = 8, scale = 2)
    private BigDecimal cuotaReal;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 20)
    @Column(name = "USUARIO", length = 20)
    private String usuario;
    @Size(max = 20)
    @Column(name = "MODIFICADO_POR", length = 20)
    private String modificadoPor;
    @Column(name = "NO_CUENTA")
    private Integer noCuenta;
    @Column(name = "COD_CLIENTE")
    private Long codCliente;
    @Column(name = "FECHA_CANCELA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancela;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA")})
    @ManyToOne(optional = false)
    private TiposPlanilla tiposPlanilla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public Prestamos() {
    }

    public Prestamos(PrestamosPK prestamosPK) {
        this.prestamosPK = prestamosPK;
    }

    public Prestamos(PrestamosPK prestamosPK, int codDeduc, BigDecimal valorPresta, short numPagos) {
        this.prestamosPK = prestamosPK;
        this.codDeduc = codDeduc;
        this.valorPresta = valorPresta;
        this.numPagos = numPagos;
    }

    public Prestamos(short codCia, int codPresta, int codEmp) {
        this.prestamosPK = new PrestamosPK(codCia, codPresta, codEmp);
    }

    public PrestamosPK getPrestamosPK() {
        return prestamosPK;
    }

    public void setPrestamosPK(PrestamosPK prestamosPK) {
        this.prestamosPK = prestamosPK;
    }

    public Integer getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(Integer numCheque) {
        this.numCheque = numCheque;
    }

    public BigDecimal getOPago() {
        return oPago;
    }

    public void setOPago(BigDecimal oPago) {
        this.oPago = oPago;
    }

    public String getRefOPago() {
        return refOPago;
    }

    public void setRefOPago(String refOPago) {
        this.refOPago = refOPago;
    }

    public Short getCodPres() {
        return codPres;
    }

    public void setCodPres(Short codPres) {
        this.codPres = codPres;
    }

    public int getCodDeduc() {
        return codDeduc;
    }

    public void setCodDeduc(int codDeduc) {
        this.codDeduc = codDeduc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorPresta() {
        return valorPresta;
    }

    public void setValorPresta(BigDecimal valorPresta) {
        this.valorPresta = valorPresta;
    }

    public short getNumPagos() {
        return numPagos;
    }

    public void setNumPagos(short numPagos) {
        this.numPagos = numPagos;
    }

    public Short getPagosHechos() {
        return pagosHechos;
    }

    public void setPagosHechos(Short pagosHechos) {
        this.pagosHechos = pagosHechos;
    }

    public BigDecimal getPPago() {
        return pPago;
    }

    public void setPPago(BigDecimal pPago) {
        this.pPago = pPago;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public BigDecimal getUPago() {
        return uPago;
    }

    public void setUPago(BigDecimal uPago) {
        this.uPago = uPago;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Short getUltimoMes() {
        return ultimoMes;
    }

    public void setUltimoMes(Short ultimoMes) {
        this.ultimoMes = ultimoMes;
    }

    public Short getUltimoAnio() {
        return ultimoAnio;
    }

    public void setUltimoAnio(Short ultimoAnio) {
        this.ultimoAnio = ultimoAnio;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getNumPrestamoref() {
        return numPrestamoref;
    }

    public void setNumPrestamoref(String numPrestamoref) {
        this.numPrestamoref = numPrestamoref;
    }

    public Short getDescQuinc() {
        return descQuinc;
    }

    public void setDescQuinc(Short descQuinc) {
        this.descQuinc = descQuinc;
    }

    public BigDecimal getCuotaReal() {
        return cuotaReal;
    }

    public void setCuotaReal(BigDecimal cuotaReal) {
        this.cuotaReal = cuotaReal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Integer getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(Integer noCuenta) {
        this.noCuenta = noCuenta;
    }

    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public Date getFechaCancela() {
        return fechaCancela;
    }

    public void setFechaCancela(Date fechaCancela) {
        this.fechaCancela = fechaCancela;
    }

    public TiposPlanilla getTiposPlanilla() {
        return tiposPlanilla;
    }

    public void setTiposPlanilla(TiposPlanilla tiposPlanilla) {
        this.tiposPlanilla = tiposPlanilla;
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
        hash += (prestamosPK != null ? prestamosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamos)) {
            return false;
        }
        Prestamos other = (Prestamos) object;
        if ((this.prestamosPK == null && other.prestamosPK != null) || (this.prestamosPK != null && !this.prestamosPK.equals(other.prestamosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Prestamos[ prestamosPK=" + prestamosPK + " ]";
    }
    
}
