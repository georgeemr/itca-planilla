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
@Table(name = "CONTRATO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findByIdCompania", query = "SELECT c FROM Contrato c WHERE c.contratoPK.idCompania = :idCompania"),
    @NamedQuery(name = "Contrato.findByIdSucursal", query = "SELECT c FROM Contrato c WHERE c.contratoPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "Contrato.findByIdEmpleado", query = "SELECT c FROM Contrato c WHERE c.contratoPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Contrato.findByIdContrato", query = "SELECT c FROM Contrato c WHERE c.contratoPK.idContrato = :idContrato"),
    @NamedQuery(name = "Contrato.findByFechaInicio", query = "SELECT c FROM Contrato c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Contrato.findByFechaFin", query = "SELECT c FROM Contrato c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "Contrato.findByTetContrato", query = "SELECT c FROM Contrato c WHERE c.tetContrato = :tetContrato")
    })
public class Contrato implements Serializable
{
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACUERDO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAcuerdo;
    @Size(max = 500)
    @Column(name = "OBSERVACION", length = 500)
    private String observacion;
    @Size(max = 25)
    @Column(name = "ACTA", length = 25)
    private String acta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIO", nullable = false, precision = 16, scale = 2)
    private BigDecimal salario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "ESTADO")
    private Long estado;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_PLANILLA", referencedColumnName = "ID_TIPO_PLANILLA")})
    @ManyToOne(optional = false)
    private TipoPlanilla tipoPlanilla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO", referencedColumnName = "CODIGO")})
    @ManyToOne(optional = false)
    private TipoContrato tipoContrato;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "SUCURSAL", referencedColumnName = "ID_SUCURSAL")})
    @ManyToOne(optional = false)
    private Sucursal sucursal;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PUESTO", referencedColumnName = "COD_PUESTO", nullable = false)})
    @ManyToOne(optional = false)
    private Puesto puesto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "EMPLEADO", referencedColumnName = "COD_EMP", nullable = false)})
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato1;

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ContratoPK contratoPK;

    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Size(max = 200)
    @Column(name = "TET_CONTRATO", length = 200)
    private String tetContrato;

    public Contrato()
    {
    }

    public Contrato(ContratoPK contratoPK)
    {
        this.contratoPK = contratoPK;
    }

    public Contrato(long idCompania, long idSucursal, long idEmpleado, long idContrato)
    {
        this.contratoPK = new ContratoPK(idCompania, idSucursal, idEmpleado, idContrato);
    }

    public ContratoPK getContratoPK()
    {
        return contratoPK;
    }

    public void setContratoPK(ContratoPK contratoPK)
    {
        this.contratoPK = contratoPK;
    }

    public Date getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin()
    {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin)
    {
        this.fechaFin = fechaFin;
    }

    public String getTetContrato()
    {
        return tetContrato;
    }

    public void setTetContrato(String tetContrato)
    {
        this.tetContrato = tetContrato;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (contratoPK != null ? contratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato))
            {
            return false;
            }
        Contrato other = (Contrato) object;
        if ((this.contratoPK == null && other.contratoPK != null) || (this.contratoPK != null && !this.contratoPK.equals(other.contratoPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Contrato[ contratoPK=" + contratoPK + " ]";
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

    public String getActa() {
        return acta;
    }

    public void setActa(String acta) {
        this.acta = acta;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public TipoPlanilla getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(TipoPlanilla tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Candidato getCandidato1() {
        return candidato1;
    }

    public void setCandidato1(Candidato candidato1) {
        this.candidato1 = candidato1;
    }
    
}
