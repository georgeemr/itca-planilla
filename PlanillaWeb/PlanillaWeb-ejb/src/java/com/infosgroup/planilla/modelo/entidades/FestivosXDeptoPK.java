/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class FestivosXDeptoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_PAIS", nullable = false)
    private short codPais;
    @Basic(optional = false)
    @Column(name = "COD_DEPTO", nullable = false)
    private short codDepto;
    @Basic(optional = false)
    @Column(name = "ANIO", nullable = false)
    private short anio;
    @Basic(optional = false)
    @Column(name = "DIA", nullable = false)
    private short dia;
    @Basic(optional = false)
    @Column(name = "MES", nullable = false)
    private short mes;

    public FestivosXDeptoPK() {
    }

    public FestivosXDeptoPK(short codCia, short codPais, short codDepto, short anio, short dia, short mes) {
        this.codCia = codCia;
        this.codPais = codPais;
        this.codDepto = codDepto;
        this.anio = anio;
        this.dia = dia;
        this.mes = mes;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodPais() {
        return codPais;
    }

    public void setCodPais(short codPais) {
        this.codPais = codPais;
    }

    public short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(short codDepto) {
        this.codDepto = codDepto;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public short getDia() {
        return dia;
    }

    public void setDia(short dia) {
        this.dia = dia;
    }

    public short getMes() {
        return mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codPais;
        hash += (int) codDepto;
        hash += (int) anio;
        hash += (int) dia;
        hash += (int) mes;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FestivosXDeptoPK)) {
            return false;
        }
        FestivosXDeptoPK other = (FestivosXDeptoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codPais != other.codPais) {
            return false;
        }
        if (this.codDepto != other.codDepto) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.dia != other.dia) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.FestivosXDeptoPK[ codCia=" + codCia + ", codPais=" + codPais + ", codDepto=" + codDepto + ", anio=" + anio + ", dia=" + dia + ", mes=" + mes + " ]";
    }
    
}
