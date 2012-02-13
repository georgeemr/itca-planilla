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
public class DetProgramaEntrenamientoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "PERIODO", nullable = false)
    private short periodo;
    @Basic(optional = false)
    @Column(name = "COD_DEPTO", nullable = false)
    private short codDepto;
    @Basic(optional = false)
    @Column(name = "CORRELATIVO", nullable = false)
    private short correlativo;

    public DetProgramaEntrenamientoPK() {
    }

    public DetProgramaEntrenamientoPK(short codCia, short periodo, short codDepto, short correlativo) {
        this.codCia = codCia;
        this.periodo = periodo;
        this.codDepto = codDepto;
        this.correlativo = correlativo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getPeriodo() {
        return periodo;
    }

    public void setPeriodo(short periodo) {
        this.periodo = periodo;
    }

    public short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(short codDepto) {
        this.codDepto = codDepto;
    }

    public short getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(short correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) periodo;
        hash += (int) codDepto;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetProgramaEntrenamientoPK)) {
            return false;
        }
        DetProgramaEntrenamientoPK other = (DetProgramaEntrenamientoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.codDepto != other.codDepto) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetProgramaEntrenamientoPK[ codCia=" + codCia + ", periodo=" + periodo + ", codDepto=" + codDepto + ", correlativo=" + correlativo + " ]";
    }
    
}
