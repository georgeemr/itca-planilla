/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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

/**
 *
 * @author root
 */
@Entity
@Table(name = "CONTRATO")
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

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ContratoPK contratoPK;

    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

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
    
}
