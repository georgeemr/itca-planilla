/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "SALARIO_BASE")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "SalarioBase.findAll", query = "SELECT s FROM SalarioBase s"),
    @NamedQuery(name = "SalarioBase.findByIdCompania", query = "SELECT s FROM SalarioBase s WHERE s.salarioBasePK.idCompania = :idCompania"),
    @NamedQuery(name = "SalarioBase.findByIdSucursal", query = "SELECT s FROM SalarioBase s WHERE s.salarioBasePK.idSucursal = :idSucursal"),
    @NamedQuery(name = "SalarioBase.findByIdEmpleado", query = "SELECT s FROM SalarioBase s WHERE s.salarioBasePK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "SalarioBase.findByIdSalario", query = "SELECT s FROM SalarioBase s WHERE s.salarioBasePK.idSalario = :idSalario"),
    @NamedQuery(name = "SalarioBase.findByMonto", query = "SELECT s FROM SalarioBase s WHERE s.monto = :monto"),
    @NamedQuery(name = "SalarioBase.findByFechaAsignacion", query = "SELECT s FROM SalarioBase s WHERE s.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "SalarioBase.findByDetSalario", query = "SELECT s FROM SalarioBase s WHERE s.detSalario = :detSalario")
    })
public class SalarioBase implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SalarioBasePK salarioBasePK;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO", precision = 11, scale = 3)
    private BigDecimal monto;

    @Column(name = "FECHA_ASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;

    @Size(max = 200)
    @Column(name = "DET_SALARIO", length = 200)
    private String detSalario;

    public SalarioBase()
    {
    }

    public SalarioBase(SalarioBasePK salarioBasePK)
    {
        this.salarioBasePK = salarioBasePK;
    }

    public SalarioBase(long idCompania, long idSucursal, long idEmpleado, long idSalario)
    {
        this.salarioBasePK = new SalarioBasePK(idCompania, idSucursal, idEmpleado, idSalario);
    }

    public SalarioBasePK getSalarioBasePK()
    {
        return salarioBasePK;
    }

    public void setSalarioBasePK(SalarioBasePK salarioBasePK)
    {
        this.salarioBasePK = salarioBasePK;
    }

    public BigDecimal getMonto()
    {
        return monto;
    }

    public void setMonto(BigDecimal monto)
    {
        this.monto = monto;
    }

    public Date getFechaAsignacion()
    {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion)
    {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getDetSalario()
    {
        return detSalario;
    }

    public void setDetSalario(String detSalario)
    {
        this.detSalario = detSalario;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (salarioBasePK != null ? salarioBasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalarioBase))
            {
            return false;
            }
        SalarioBase other = (SalarioBase) object;
        if ((this.salarioBasePK == null && other.salarioBasePK != null) || (this.salarioBasePK != null && !this.salarioBasePK.equals(other.salarioBasePK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.SalarioBase[ salarioBasePK=" + salarioBasePK + " ]";
    }
    
}
