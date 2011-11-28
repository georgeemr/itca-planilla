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
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Embeddable
public class PreguntaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_factor", nullable = false)
    private int codFactor;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cod_pregunta", nullable = false, length = 2147483647)
    private String codPregunta;

    public PreguntaPK()
    {
    }

    public PreguntaPK(int codCia, int codFactor, String codPregunta)
    {
        this.codCia = codCia;
        this.codFactor = codFactor;
        this.codPregunta = codPregunta;
    }

    public int getCodCia()
    {
        return codCia;
    }

    public void setCodCia(int codCia)
    {
        this.codCia = codCia;
    }

    public int getCodFactor()
    {
        return codFactor;
    }

    public void setCodFactor(int codFactor)
    {
        this.codFactor = codFactor;
    }

    public String getCodPregunta()
    {
        return codPregunta;
    }

    public void setCodPregunta(String codPregunta)
    {
        this.codPregunta = codPregunta;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codFactor;
        hash += (codPregunta != null ? codPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaPK))
            {
            return false;
            }
        PreguntaPK other = (PreguntaPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if (this.codFactor != other.codFactor)
            {
            return false;
            }
        if ((this.codPregunta == null && other.codPregunta != null) || (this.codPregunta != null && !this.codPregunta.equals(other.codPregunta)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.PreguntaPK[ codCia=" + codCia + ", codFactor=" + codFactor + ", codPregunta=" + codPregunta + " ]";
    }
    
}
