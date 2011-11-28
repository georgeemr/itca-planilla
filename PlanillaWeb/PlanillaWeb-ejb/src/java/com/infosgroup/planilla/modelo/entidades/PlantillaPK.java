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
public class PlantillaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_evaluacion", nullable = false)
    private int codTipoEvaluacion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_plantilla", nullable = false)
    private int codPlantilla;

    public PlantillaPK()
    {
    }

    public PlantillaPK(int codCia, int codTipoEvaluacion, int codPlantilla)
    {
        this.codCia = codCia;
        this.codTipoEvaluacion = codTipoEvaluacion;
        this.codPlantilla = codPlantilla;
    }

    public int getCodCia()
    {
        return codCia;
    }

    public void setCodCia(int codCia)
    {
        this.codCia = codCia;
    }

    public int getCodTipoEvaluacion()
    {
        return codTipoEvaluacion;
    }

    public void setCodTipoEvaluacion(int codTipoEvaluacion)
    {
        this.codTipoEvaluacion = codTipoEvaluacion;
    }

    public int getCodPlantilla()
    {
        return codPlantilla;
    }

    public void setCodPlantilla(int codPlantilla)
    {
        this.codPlantilla = codPlantilla;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoEvaluacion;
        hash += (int) codPlantilla;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantillaPK))
            {
            return false;
            }
        PlantillaPK other = (PlantillaPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if (this.codTipoEvaluacion != other.codTipoEvaluacion)
            {
            return false;
            }
        if (this.codPlantilla != other.codPlantilla)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.PlantillaPK[ codCia=" + codCia + ", codTipoEvaluacion=" + codTipoEvaluacion + ", codPlantilla=" + codPlantilla + " ]";
    }
    
}
