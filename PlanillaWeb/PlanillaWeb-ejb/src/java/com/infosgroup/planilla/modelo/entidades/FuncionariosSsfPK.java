/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class FuncionariosSsfPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "NIU", nullable = false)
    private BigInteger niu;
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "ANIO", nullable = false)
    private short anio;
    @Basic(optional = false)
    @Column(name = "MES", nullable = false)
    private short mes;

    public FuncionariosSsfPK() {
    }

    public FuncionariosSsfPK(BigInteger niu, short codCia, short anio, short mes) {
        this.niu = niu;
        this.codCia = codCia;
        this.anio = anio;
        this.mes = mes;
    }

    public BigInteger getNiu() {
        return niu;
    }

    public void setNiu(BigInteger niu) {
        this.niu = niu;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
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
        hash += (niu != null ? niu.hashCode() : 0);
        hash += (int) codCia;
        hash += (int) anio;
        hash += (int) mes;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionariosSsfPK)) {
            return false;
        }
        FuncionariosSsfPK other = (FuncionariosSsfPK) object;
        if ((this.niu == null && other.niu != null) || (this.niu != null && !this.niu.equals(other.niu))) {
            return false;
        }
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.FuncionariosSsfPK[ niu=" + niu + ", codCia=" + codCia + ", anio=" + anio + ", mes=" + mes + " ]";
    }
    
}
