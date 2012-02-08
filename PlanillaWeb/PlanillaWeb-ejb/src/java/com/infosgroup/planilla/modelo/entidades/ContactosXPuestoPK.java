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
public class ContactosXPuestoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CONTACTO", nullable = false)
    private short codContacto;
    @Basic(optional = false)
    @Column(name = "COD_PUESTO", nullable = false)
    private short codPuesto;

    public ContactosXPuestoPK() {
    }

    public ContactosXPuestoPK(short codCia, short codContacto, short codPuesto) {
        this.codCia = codCia;
        this.codContacto = codContacto;
        this.codPuesto = codPuesto;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodContacto() {
        return codContacto;
    }

    public void setCodContacto(short codContacto) {
        this.codContacto = codContacto;
    }

    public short getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(short codPuesto) {
        this.codPuesto = codPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codContacto;
        hash += (int) codPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactosXPuestoPK)) {
            return false;
        }
        ContactosXPuestoPK other = (ContactosXPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codContacto != other.codContacto) {
            return false;
        }
        if (this.codPuesto != other.codPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ContactosXPuestoPK[ codCia=" + codCia + ", codContacto=" + codContacto + ", codPuesto=" + codPuesto + " ]";
    }
    
}
