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
public class InstitucionesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_INSTI", nullable = false)
    private short codInsti;

    public InstitucionesPK() {
    }

    public InstitucionesPK(short codCia, short codInsti) {
        this.codCia = codCia;
        this.codInsti = codInsti;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodInsti() {
        return codInsti;
    }

    public void setCodInsti(short codInsti) {
        this.codInsti = codInsti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codInsti;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionesPK)) {
            return false;
        }
        InstitucionesPK other = (InstitucionesPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codInsti != other.codInsti) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.InstitucionesPK[ codCia=" + codCia + ", codInsti=" + codInsti + " ]";
    }
    
}
