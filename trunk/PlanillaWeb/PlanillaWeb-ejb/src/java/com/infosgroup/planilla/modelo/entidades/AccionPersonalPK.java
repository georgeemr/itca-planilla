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
public class AccionPersonalPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPOACCION", nullable = false)
    private short codTipoaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO", nullable = false)
    private int correlativo;

    public AccionPersonalPK() {
    }

    public AccionPersonalPK(short codCia, int codEmp, short codTipoaccion, int correlativo) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.codTipoaccion = codTipoaccion;
        this.correlativo = correlativo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public Short getCodTipoaccion() {
        return codTipoaccion;
    }

    public void setCodTipoaccion(short codTipoaccion) {
        this.codTipoaccion = codTipoaccion;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        hash += (int) codTipoaccion;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccionPersonalPK)) {
            return false;
        }
        AccionPersonalPK other = (AccionPersonalPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (this.codTipoaccion != other.codTipoaccion) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.AccionPersonalPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", codTipoaccion=" + codTipoaccion + ", correlativo=" + correlativo + " ]";
    }
    
}
