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
    @Column(name = "cod_cia", nullable = false)
    private int codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo", nullable = false)
    private int periodo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_campania", nullable = false)
    private int codCampania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "empleado", nullable = false)
    private int empleado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_evaluacion", nullable = false)
    private int tipoEvaluacion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_det_evaluacion", nullable = false)
    private int codDetEvaluacion;

    public DetEvaluacionPK()
    {
    }

    public DetEvaluacionPK(int codCia, int periodo, int codCampania, int empleado, int tipoEvaluacion, int codDetEvaluacion)
    {
        this.codCia = codCia;
        this.periodo = periodo;
        this.codCampania = codCampania;
        this.empleado = empleado;
        this.tipoEvaluacion = tipoEvaluacion;
        this.codDetEvaluacion = codDetEvaluacion;
    }

    public int getCodCia()
    {
        return codCia;
    }

    public void setCodCia(int codCia)
    {
        this.codCia = codCia;
    }

    public int getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(int periodo)
    {
        this.periodo = periodo;
    }

    public int getCodCampania()
    {
        return codCampania;
    }

    public void setCodCampania(int codCampania)
    {
        this.codCampania = codCampania;
    }

    public int getEmpleado()
    {
        return empleado;
    }

    public void setEmpleado(int empleado)
    {
        this.empleado = empleado;
    }

    public int getTipoEvaluacion()
    {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(int tipoEvaluacion)
    {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public int getCodDetEvaluacion()
    {
        return codDetEvaluacion;
    }

    public void setCodDetEvaluacion(int codDetEvaluacion)
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
        hash += (int) empleado;
        hash += (int) tipoEvaluacion;
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
        if (this.empleado != other.empleado)
            {
            return false;
            }
        if (this.tipoEvaluacion != other.tipoEvaluacion)
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
        return "com.infosgroup.planilla.modelo.entidades.DetEvaluacionPK[ codCia=" + codCia + ", periodo=" + periodo + ", codCampania=" + codCampania + ", empleado=" + empleado + ", tipoEvaluacion=" + tipoEvaluacion + ", codDetEvaluacion=" + codDetEvaluacion + " ]";
    }
    
}
