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
public class CampaniaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_campania", nullable = false)
    private int codCampania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo", nullable = false)
    private int periodo;

    public CampaniaPK()
    {
    }

    public CampaniaPK(int codCia, int codCampania, int periodo)
    {
        this.codCia = codCia;
        this.codCampania = codCampania;
        this.periodo = periodo;
    }

    public int getCodCia()
    {
        return codCia;
    }

    public void setCodCia(int codCia)
    {
        this.codCia = codCia;
    }

    public int getCodCampania()
    {
        return codCampania;
    }

    public void setCodCampania(int codCampania)
    {
        this.codCampania = codCampania;
    }

    public int getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(int periodo)
    {
        this.periodo = periodo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCampania;
        hash += (int) periodo;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampaniaPK))
            {
            return false;
            }
        CampaniaPK other = (CampaniaPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if (this.codCampania != other.codCampania)
            {
            return false;
            }
        if (this.periodo != other.periodo)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.CampaniaPK[ codCia=" + codCia + ", codCampania=" + codCampania + ", periodo=" + periodo + " ]";
    }
    
}
