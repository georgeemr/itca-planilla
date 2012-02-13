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
public class PasatiempoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_PASATIEMPO", nullable = false)
    private short codPasatiempo;

    public PasatiempoPK() {
    }

    public PasatiempoPK(short codCia, short codPasatiempo) {
        this.codCia = codCia;
        this.codPasatiempo = codPasatiempo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodPasatiempo() {
        return codPasatiempo;
    }

    public void setCodPasatiempo(short codPasatiempo) {
        this.codPasatiempo = codPasatiempo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codPasatiempo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasatiempoPK)) {
            return false;
        }
        PasatiempoPK other = (PasatiempoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codPasatiempo != other.codPasatiempo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PasatiempoPK[ codCia=" + codCia + ", codPasatiempo=" + codPasatiempo + " ]";
    }
    
}
