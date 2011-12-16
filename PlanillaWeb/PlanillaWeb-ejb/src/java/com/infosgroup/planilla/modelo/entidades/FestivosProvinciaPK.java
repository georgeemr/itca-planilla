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
public class FestivosProvinciaPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private short idCompania;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAIS", nullable = false)
    private short idPais;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROVINCIA", nullable = false)
    private int idProvincia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO", nullable = false)
    private short anio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "MES", nullable = false)
    private short mes;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DIA", nullable = false)
    private short dia;

    public FestivosProvinciaPK()
    {
    }

    public FestivosProvinciaPK(short idCompania, short idPais, int idProvincia, short anio, short mes, short dia)
    {
        this.idCompania = idCompania;
        this.idPais = idPais;
        this.idProvincia = idProvincia;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public short getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(short idCompania)
    {
        this.idCompania = idCompania;
    }

    public short getIdPais()
    {
        return idPais;
    }

    public void setIdPais(short idPais)
    {
        this.idPais = idPais;
    }

    public int getIdProvincia()
    {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia)
    {
        this.idProvincia = idProvincia;
    }

    public short getAnio()
    {
        return anio;
    }

    public void setAnio(short anio)
    {
        this.anio = anio;
    }

    public short getMes()
    {
        return mes;
    }

    public void setMes(short mes)
    {
        this.mes = mes;
    }

    public short getDia()
    {
        return dia;
    }

    public void setDia(short dia)
    {
        this.dia = dia;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idPais;
        hash += (int) idProvincia;
        hash += (int) anio;
        hash += (int) mes;
        hash += (int) dia;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FestivosProvinciaPK))
            {
            return false;
            }
        FestivosProvinciaPK other = (FestivosProvinciaPK) object;
        if (this.idCompania != other.idCompania) return false;
        if (this.idPais != other.idPais) return false;
        if (this.idProvincia != other.idProvincia) return false;
        if (this.anio != other.anio) return false;
        if (this.mes != other.mes) return false;
        if (this.dia != other.dia) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.FestivosProvinciaPK[ idCompania=" + idCompania + ", idPais=" + idPais + ", idProvincia=" + idProvincia + ", anio=" + anio + ", mes=" + mes + ", dia=" + dia + " ]";
    }
    
}
