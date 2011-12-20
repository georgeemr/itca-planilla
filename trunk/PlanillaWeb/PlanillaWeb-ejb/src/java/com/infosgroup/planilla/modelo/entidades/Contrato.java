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
import javax.persistence.FetchType;
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
    @NamedQuery(name = "Contrato.findByCodCia", query = "SELECT c FROM Contrato c WHERE c.contratoPK.codCia = :codCia"),
    @NamedQuery(name = "Contrato.findByCodigo", query = "SELECT c FROM Contrato c WHERE c.contratoPK.codigo = :codigo"),
    @NamedQuery(name = "Contrato.findByCandidato", query = "SELECT c FROM Contrato c WHERE c.contratoPK.candidato = :candidato"),
    @NamedQuery(name = "Contrato.findByFechaAcuerdo", query = "SELECT c FROM Contrato c WHERE c.fechaAcuerdo = :fechaAcuerdo"),
    @NamedQuery(name = "Contrato.findByObservacion", query = "SELECT c FROM Contrato c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "Contrato.findByActa", query = "SELECT c FROM Contrato c WHERE c.acta = :acta"),
    @NamedQuery(name = "Contrato.findBySalario", query = "SELECT c FROM Contrato c WHERE c.salario = :salario"),
    @NamedQuery(name = "Contrato.findByFechaInicio", query = "SELECT c FROM Contrato c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Contrato.findByFechaFinal", query = "SELECT c FROM Contrato c WHERE c.fechaFinal = :fechaFinal")
    })
public class Contrato implements Serializable
{
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACUERDO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAcuerdo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ESTADO", referencedColumnName = "CODIGO", nullable = false)})
    @ManyToOne(optional = false)
    private EstadoContrato estadoContrato;

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ContratoPK contratoPK;

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

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_PLANILLA", referencedColumnName = "ID_TIPO_PLANILLA")
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoPlanilla tipoPlanilla;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO", referencedColumnName = "CODIGO")
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoContrato tipoContrato;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "SUCURSAL", referencedColumnName = "ID_SUCURSAL")
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sucursal sucursal;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PUESTO", referencedColumnName = "COD_PUESTO", nullable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Puesto puesto;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "EMPLEADO", referencedColumnName = "COD_EMP", nullable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Candidato candidato1;

    public Contrato()
    {
    }

    public Contrato(ContratoPK contratoPK)
    {
        this.contratoPK = contratoPK;
    }

    public Contrato(ContratoPK contratoPK, Date fechaAcuerdo, BigDecimal salario, Date fechaInicio)
    {
        this.contratoPK = contratoPK;
        this.fechaAcuerdo = fechaAcuerdo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    public Contrato(long codCia, long codigo, long candidato)
    {
        this.contratoPK = new ContratoPK(codCia, codigo, candidato);
    }

    public ContratoPK getContratoPK()
    {
        return contratoPK;
    }

    public void setContratoPK(ContratoPK contratoPK)
    {
        this.contratoPK = contratoPK;
    }

    public Date getFechaAcuerdo()
    {
        return fechaAcuerdo;
    }

    public void setFechaAcuerdo(Date fechaAcuerdo)
    {
        this.fechaAcuerdo = fechaAcuerdo;
    }

    public String getObservacion()
    {
        return observacion;
    }

    public void setObservacion(String observacion)
    {
        this.observacion = observacion;
    }

    public String getActa()
    {
        return acta;
    }

    public void setActa(String acta)
    {
        this.acta = acta;
    }

    public BigDecimal getSalario()
    {
        return salario;
    }

    public void setSalario(BigDecimal salario)
    {
        this.salario = salario;
    }

    public Date getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }

    public TipoPlanilla getTipoPlanilla()
    {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(TipoPlanilla tipoPlanilla)
    {
        this.tipoPlanilla = tipoPlanilla;
    }

    public TipoContrato getTipoContrato()
    {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato)
    {
        this.tipoContrato = tipoContrato;
    }

    public Sucursal getSucursal()
    {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal)
    {
        this.sucursal = sucursal;
    }

    public Puesto getPuesto()
    {
        return puesto;
    }

    public void setPuesto(Puesto puesto)
    {
        this.puesto = puesto;
    }

    public Empleado getEmpleado()
    {
        return empleado;
    }

    public void setEmpleado(Empleado empleado)
    {
        this.empleado = empleado;
    }

    public Candidato getCandidato1()
    {
        return candidato1;
    }

    public void setCandidato1(Candidato candidato1)
    {
        this.candidato1 = candidato1;
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
        if ((this.contratoPK == null && other.contratoPK != null) || (this.contratoPK != null && !this.contratoPK.equals(other.contratoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Contrato[ contratoPK=" + contratoPK + " ]";
    }

    public EstadoContrato getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(EstadoContrato estadoContrato) {
        this.estadoContrato = estadoContrato;
    }
    
}
