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
public class MovDpPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_TIPOPLA", nullable = false)
    private short codTipopla;
    @Basic(optional = false)
    @Column(name = "ANIO", nullable = false)
    private short anio;
    @Basic(optional = false)
    @Column(name = "MES", nullable = false)
    private short mes;
    @Basic(optional = false)
    @Column(name = "NUM_PLANILLA", nullable = false)
    private short numPlanilla;
    @Basic(optional = false)
    @Column(name = "NO_MOVTO", nullable = false)
    private int noMovto;

    public MovDpPK() {
    }

    public MovDpPK(short codCia, short codTipopla, short anio, short mes, short numPlanilla, int noMovto) {
        this.codCia = codCia;
        this.codTipopla = codTipopla;
        this.anio = anio;
        this.mes = mes;
        this.numPlanilla = numPlanilla;
        this.noMovto = noMovto;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(short codTipopla) {
        this.codTipopla = codTipopla;
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

    public short getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(short numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public int getNoMovto() {
        return noMovto;
    }

    public void setNoMovto(int noMovto) {
        this.noMovto = noMovto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codTipopla;
        hash += (int) anio;
        hash += (int) mes;
        hash += (int) numPlanilla;
        hash += (int) noMovto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovDpPK)) {
            return false;
        }
        MovDpPK other = (MovDpPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codTipopla != other.codTipopla) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.numPlanilla != other.numPlanilla) {
            return false;
        }
        if (this.noMovto != other.noMovto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.MovDpPK[ codCia=" + codCia + ", codTipopla=" + codTipopla + ", anio=" + anio + ", mes=" + mes + ", numPlanilla=" + numPlanilla + ", noMovto=" + noMovto + " ]";
    }
    
}
