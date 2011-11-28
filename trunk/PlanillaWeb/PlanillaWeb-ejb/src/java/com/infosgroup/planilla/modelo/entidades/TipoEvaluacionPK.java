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
public class TipoEvaluacionPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_evaluacion", nullable = false)
    private int codTipoEvaluacion;

    public TipoEvaluacionPK()
    {
    }

    public TipoEvaluacionPK(int codCia, int codTipoEvaluacion)
    {
        this.codCia = codCia;
        this.codTipoEvaluacion = codTipoEvaluacion;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoEvaluacion;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvaluacionPK))
            {
            return false;
            }
        TipoEvaluacionPK other = (TipoEvaluacionPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if (this.codTipoEvaluacion != other.codTipoEvaluacion)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.TipoEvaluacionPK[ codCia=" + codCia + ", codTipoEvaluacion=" + codTipoEvaluacion + " ]";
    }
    
}
