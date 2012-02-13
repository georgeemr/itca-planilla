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
public class CausasRenunciaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPORENUNCIA", nullable = false)
    private short codTiporenuncia;

    public CausasRenunciaPK() {
    }

    public CausasRenunciaPK(short codCia, short codTiporenuncia) {
        this.codCia = codCia;
        this.codTiporenuncia = codTiporenuncia;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodTiporenuncia() {
        return codTiporenuncia;
    }

    public void setCodTiporenuncia(short codTiporenuncia) {
        this.codTiporenuncia = codTiporenuncia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTiporenuncia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CausasRenunciaPK)) {
            return false;
        }
        CausasRenunciaPK other = (CausasRenunciaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTiporenuncia != other.codTiporenuncia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CausasRenunciaPK[ codCia=" + codCia + ", codTiporenuncia=" + codTiporenuncia + " ]";
    }
    
}
