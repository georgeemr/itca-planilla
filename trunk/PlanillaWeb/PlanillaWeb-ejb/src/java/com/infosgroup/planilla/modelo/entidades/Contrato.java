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
@Table(name = "CONTRATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findByCodCia", query = "SELECT c FROM Contrato c WHERE c.contratoPK.codCia = :codCia"),
    @NamedQuery(name = "Contrato.findByCodContrato", query = "SELECT c FROM Contrato c WHERE c.contratoPK.codContrato = :codContrato"),
    @NamedQuery(name = "Contrato.findByCodCandidato", query = "SELECT c FROM Contrato c WHERE c.contratoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "Contrato.findByFechaAcuerdo", query = "SELECT c FROM Contrato c WHERE c.fechaAcuerdo = :fechaAcuerdo"),
    @NamedQuery(name = "Contrato.findByObservacion", query = "SELECT c FROM Contrato c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "Contrato.findByTipo", query = "SELECT c FROM Contrato c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Contrato.findByNumActa", query = "SELECT c FROM Contrato c WHERE c.numActa = :numActa"),
    @NamedQuery(name = "Contrato.findByCodSucursal", query = "SELECT c FROM Contrato c WHERE c.codSucursal = :codSucursal"),
    @NamedQuery(name = "Contrato.findBySalario", query = "SELECT c FROM Contrato c WHERE c.salario = :salario"),
    @NamedQuery(name = "Contrato.findByFechaInicio", query = "SELECT c FROM Contrato c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Contrato.findByEstado", query = "SELECT c FROM Contrato c WHERE c.estado = :estado"),
    @NamedQuery(name = "Contrato.findByFechaFinal", query = "SELECT c FROM Contrato c WHERE c.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "Contrato.findByCodAgencia", query = "SELECT c FROM Contrato c WHERE c.codAgencia = :codAgencia")})
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContratoPK contratoPK;
    @Basic(optional = false)
    @Column(name = "FECHA_ACUERDO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAcuerdo;
    @Column(name = "OBSERVACION", length = 500)
    private String observacion;
    @Basic(optional = false)
    @Column(name = "TIPO", nullable = false, length = 2)
    private String tipo;
    @Column(name = "NUM_ACTA", length = 25)
    private String numActa;
    @Column(name = "COD_SUCURSAL")
    private Short codSucursal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SALARIO", nullable = false, precision = 16, scale = 2)
    private BigDecimal salario;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Column(name = "COD_AGENCIA")
    private Short codAgencia;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA")})
    @ManyToOne(optional = false)
    private TiposPlanilla tiposPlanilla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false)})
    @ManyToOne(optional = false)
    private Puestos puestos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public Contrato() {
    }

    public Contrato(ContratoPK contratoPK) {
        this.contratoPK = contratoPK;
    }

    public Contrato(ContratoPK contratoPK, Date fechaAcuerdo, String tipo, BigDecimal salario, Date fechaInicio) {
        this.contratoPK = contratoPK;
        this.fechaAcuerdo = fechaAcuerdo;
        this.tipo = tipo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    public Contrato(short codCia, int codContrato, int codCandidato) {
        this.contratoPK = new ContratoPK(codCia, codContrato, codCandidato);
    }

    public ContratoPK getContratoPK() {
        return contratoPK;
    }

    public void setContratoPK(ContratoPK contratoPK) {
        this.contratoPK = contratoPK;
    }

    public Date getFechaAcuerdo() {
        return fechaAcuerdo;
    }

    public void setFechaAcuerdo(Date fechaAcuerdo) {
        this.fechaAcuerdo = fechaAcuerdo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumActa() {
        return numActa;
    }

    public void setNumActa(String numActa) {
        this.numActa = numActa;
    }

    public Short getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Short codSucursal) {
        this.codSucursal = codSucursal;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Short getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(Short codAgencia) {
        this.codAgencia = codAgencia;
    }

    public TiposPlanilla getTiposPlanilla() {
        return tiposPlanilla;
    }

    public void setTiposPlanilla(TiposPlanilla tiposPlanilla) {
        this.tiposPlanilla = tiposPlanilla;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contratoPK != null ? contratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.contratoPK == null && other.contratoPK != null) || (this.contratoPK != null && !this.contratoPK.equals(other.contratoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Contrato[ contratoPK=" + contratoPK + " ]";
    }
    
}
