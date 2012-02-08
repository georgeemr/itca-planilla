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
public class BancosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_BANCO", nullable = false, length = 4)
    private String codBanco;

    public BancosPK() {
    }

    public BancosPK(short codCia, String codBanco) {
        this.codCia = codCia;
        this.codBanco = codBanco;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (codBanco != null ? codBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BancosPK)) {
            return false;
        }
        BancosPK other = (BancosPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.codBanco == null && other.codBanco != null) || (this.codBanco != null && !this.codBanco.equals(other.codBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.BancosPK[ codCia=" + codCia + ", codBanco=" + codBanco + " ]";
    }
    
}
