/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class AccionPersonalPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO", nullable = false)
    private long anio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "MES", nullable = false)
    private long mes;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PLANILLA", nullable = false)
    private long numPlanilla;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUCURSAL", nullable = false)
    private long idSucursal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO", nullable = false)
    private long idEmpleado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PUESTO", nullable = false)
    private long idTipoPuesto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PUESTO", nullable = false)
    private long idPuesto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPOACCION", nullable = false)
    private long codTipoaccion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO", nullable = false)
    private long correlativo;

    public AccionPersonalPK()
    {
    }

    public AccionPersonalPK(long codCia, long anio, long mes, long numPlanilla, long idSucursal, long idEmpleado, long idTipoPuesto, long idPuesto, long codTipoaccion, long correlativo)
    {
        this.codCia = codCia;
        this.anio = anio;
        this.mes = mes;
        this.numPlanilla = numPlanilla;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
        this.idTipoPuesto = idTipoPuesto;
        this.idPuesto = idPuesto;
        this.codTipoaccion = codTipoaccion;
        this.correlativo = correlativo;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getAnio()
    {
        return anio;
    }

    public void setAnio(long anio)
    {
        this.anio = anio;
    }

    public long getMes()
    {
        return mes;
    }

    public void setMes(long mes)
    {
        this.mes = mes;
    }

    public long getNumPlanilla()
    {
        return numPlanilla;
    }

    public void setNumPlanilla(long numPlanilla)
    {
        this.numPlanilla = numPlanilla;
    }

    public long getIdSucursal()
    {
        return idSucursal;
    }

    public void setIdSucursal(long idSucursal)
    {
        this.idSucursal = idSucursal;
    }

    public long getIdEmpleado()
    {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado)
    {
        this.idEmpleado = idEmpleado;
    }

    public long getIdTipoPuesto()
    {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(long idTipoPuesto)
    {
        this.idTipoPuesto = idTipoPuesto;
    }

    public long getIdPuesto()
    {
        return idPuesto;
    }

    public void setIdPuesto(long idPuesto)
    {
        this.idPuesto = idPuesto;
    }

    public long getCodTipoaccion()
    {
        return codTipoaccion;
    }

    public void setCodTipoaccion(long codTipoaccion)
    {
        this.codTipoaccion = codTipoaccion;
    }

    public long getCorrelativo()
    {
        return correlativo;
    }

    public void setCorrelativo(long correlativo)
    {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) anio;
        hash += (int) mes;
        hash += (int) numPlanilla;
        hash += (int) idSucursal;
        hash += (int) idEmpleado;
        hash += (int) idTipoPuesto;
        hash += (int) idPuesto;
        hash += (int) codTipoaccion;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccionPersonalPK))
            {
            return false;
            }
        AccionPersonalPK other = (AccionPersonalPK) object;
        if (this.codCia != other.codCia) return false;
        if (this.anio != other.anio) return false;
        if (this.mes != other.mes) return false;
        if (this.numPlanilla != other.numPlanilla) return false;
        if (this.idSucursal != other.idSucursal) return false;
        if (this.idEmpleado != other.idEmpleado) return false;
        if (this.idTipoPuesto != other.idTipoPuesto) return false;
        if (this.idPuesto != other.idPuesto) return false;
        if (this.codTipoaccion != other.codTipoaccion) return false;
        if (this.correlativo != other.correlativo) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.AccionPersonalPK[ codCia=" + codCia + ", anio=" + anio + ", mes=" + mes + ", numPlanilla=" + numPlanilla + ", idSucursal=" + idSucursal + ", idEmpleado=" + idEmpleado + ", idTipoPuesto=" + idTipoPuesto + ", idPuesto=" + idPuesto + ", codTipoaccion=" + codTipoaccion + ", correlativo=" + correlativo + " ]";
    }
    
}
