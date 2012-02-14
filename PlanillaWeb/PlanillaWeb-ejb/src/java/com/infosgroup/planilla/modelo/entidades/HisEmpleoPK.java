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
public class HisEmpleoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_HIS_EMPLEO", nullable = false)
    private int codHisEmpleo;

    public HisEmpleoPK() {
    }

    public HisEmpleoPK(short codCia, int codHisEmpleo) {
        this.codCia = codCia;
        this.codHisEmpleo = codHisEmpleo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodHisEmpleo() {
        return codHisEmpleo;
    }

    public void setCodHisEmpleo(int codHisEmpleo) {
        this.codHisEmpleo = codHisEmpleo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codHisEmpleo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HisEmpleoPK)) {
            return false;
        }
        HisEmpleoPK other = (HisEmpleoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codHisEmpleo != other.codHisEmpleo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.HisEmpleoPK[ codCia=" + codCia + ", codHisEmpleo=" + codHisEmpleo + " ]";
    }
    
}
