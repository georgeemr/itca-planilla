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

 @author root
 */
@Embeddable
public class PreEvaluacionPK implements Serializable
{
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO", nullable = false)
    private int periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CAMPANIA", nullable = false)
    private short codCampania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_EVALUACION", nullable = false)
    private short tipoEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLANTILLA", nullable = false)
    private long plantilla;

    public PreEvaluacionPK()
    {
    }

    public PreEvaluacionPK(short codCia, short periodo, short codCampania, short tipoEvaluacion, long plantilla)
    {
        this.codCia = codCia;
        this.periodo = periodo;
        this.codCampania = codCampania;
        this.tipoEvaluacion = tipoEvaluacion;
        this.plantilla = plantilla;
    }

    public short getCodCia()
    {
        return codCia;
    }

    public void setCodCia(short codCia)
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

    public short getCodCampania()
    {
        return codCampania;
    }

    public void setCodCampania(short codCampania)
    {
        this.codCampania = codCampania;
    }

    public short getTipoEvaluacion()
    {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(short tipoEvaluacion)
    {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public long getPlantilla()
    {
        return plantilla;
    }

    public void setPlantilla(long plantilla)
    {
        this.plantilla = plantilla;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) periodo;
        hash += (int) codCampania;
        hash += (int) tipoEvaluacion;
        hash += (int) plantilla;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreEvaluacionPK))
            {
            return false;
            }
        PreEvaluacionPK other = (PreEvaluacionPK) object;
        if (this.codCia != other.codCia) return false;
        if (this.periodo != other.periodo) return false;
        if (this.codCampania != other.codCampania) return false;
        if (this.tipoEvaluacion != other.tipoEvaluacion) return false;
        if (this.plantilla != other.plantilla) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.PreEvaluacionPK[ codCia=" + codCia + ", periodo=" + periodo + ", codCampania=" + codCampania + ", tipoEvaluacion=" + tipoEvaluacion + ", plantilla=" + plantilla + " ]";
    }
    
}
