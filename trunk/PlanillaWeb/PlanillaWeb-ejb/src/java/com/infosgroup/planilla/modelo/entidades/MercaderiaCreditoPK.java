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
public class MercaderiaCreditoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
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
    @Column(name = "CREDITO", nullable = false)
    private int credito;

    public MercaderiaCreditoPK() {
    }

    public MercaderiaCreditoPK(short codCia, short anio, short mes, int credito) {
        this.codCia = codCia;
        this.anio = anio;
        this.mes = mes;
        this.credito = credito;
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

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) anio;
        hash += (int) mes;
        hash += (int) credito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MercaderiaCreditoPK)) {
            return false;
        }
        MercaderiaCreditoPK other = (MercaderiaCreditoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.credito != other.credito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.MercaderiaCreditoPK[ codCia=" + codCia + ", anio=" + anio + ", mes=" + mes + ", credito=" + credito + " ]";
    }
    
}
