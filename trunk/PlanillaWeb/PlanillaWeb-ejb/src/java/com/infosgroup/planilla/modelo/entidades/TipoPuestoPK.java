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
public class TipoPuestoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_puesto", nullable = false)
    private int codTipoPuesto;

    public TipoPuestoPK() {
    }

    public TipoPuestoPK(int codCia, int codTipoPuesto) {
        this.codCia = codCia;
        this.codTipoPuesto = codTipoPuesto;
    }

    public int getCodCia() {
        return codCia;
    }

    public void setCodCia(int codCia) {
        this.codCia = codCia;
    }

    public int getCodTipoPuesto() {
        return codTipoPuesto;
    }

    public void setCodTipoPuesto(int codTipoPuesto) {
        this.codTipoPuesto = codTipoPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipoPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPuestoPK)) {
            return false;
        }
        TipoPuestoPK other = (TipoPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipoPuesto != other.codTipoPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoPuestoPK[ codCia=" + codCia + ", codTipoPuesto=" + codTipoPuesto + " ]";
    }
    
}