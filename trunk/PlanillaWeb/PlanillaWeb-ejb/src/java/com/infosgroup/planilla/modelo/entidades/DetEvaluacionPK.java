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
public class DetEvaluacionPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO", nullable = false)
    private long periodo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CAMPANIA", nullable = false)
    private long codCampania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_EVALUACION", nullable = false)
    private long tipoEvaluacion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLEADO", nullable = false)
    private long empleado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DET_EVALUACION", nullable = false)
    private long codDetEvaluacion;

    public DetEvaluacionPK()
    {
    }

    public DetEvaluacionPK(long codCia, long periodo, long codCampania, long tipoEvaluacion, long empleado, long codDetEvaluacion)
    {
        this.codCia = codCia;
        this.periodo = periodo;
        this.codCampania = codCampania;
        this.tipoEvaluacion = tipoEvaluacion;
        this.empleado = empleado;
        this.codDetEvaluacion = codDetEvaluacion;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(long periodo)
    {
        this.periodo = periodo;
    }

    public long getCodCampania()
    {
        return codCampania;
    }

    public void setCodCampania(long codCampania)
    {
        this.codCampania = codCampania;
    }

    public long getTipoEvaluacion()
    {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(long tipoEvaluacion)
    {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public long getEmpleado()
    {
        return empleado;
    }

    public void setEmpleado(long empleado)
    {
        this.empleado = empleado;
    }

    public long getCodDetEvaluacion()
    {
        return codDetEvaluacion;
    }

    public void setCodDetEvaluacion(long codDetEvaluacion)
    {
        this.codDetEvaluacion = codDetEvaluacion;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) periodo;
        hash += (int) codCampania;
        hash += (int) tipoEvaluacion;
        hash += (int) empleado;
        hash += (int) codDetEvaluacion;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetEvaluacionPK))
            {
            return false;
            }
        DetEvaluacionPK other = (DetEvaluacionPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if (this.periodo != other.periodo)
            {
            return false;
            }
        if (this.codCampania != other.codCampania)
            {
            return false;
            }
        if (this.tipoEvaluacion != other.tipoEvaluacion)
            {
            return false;
            }
        if (this.empleado != other.empleado)
            {
            return false;
            }
        if (this.codDetEvaluacion != other.codDetEvaluacion)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.DetEvaluacionPK[ codCia=" + codCia + ", periodo=" + periodo + ", codCampania=" + codCampania + ", tipoEvaluacion=" + tipoEvaluacion + ", empleado=" + empleado + ", codDetEvaluacion=" + codDetEvaluacion + " ]";
    }
    
}
