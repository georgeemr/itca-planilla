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
public class PrograCampaniaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_CAMPANIA", nullable = false)
    private short codCampania;
    @Basic(optional = false)
    @Column(name = "PERIODO", nullable = false)
    private int periodo;
    @Basic(optional = false)
    @Column(name = "CORRELATIVO", nullable = false)
    private long correlativo;

    public PrograCampaniaPK() {
    }

    public PrograCampaniaPK(short codCia, short codCampania, int periodo, long correlativo) {
        this.codCia = codCia;
        this.codCampania = codCampania;
        this.periodo = periodo;
        this.correlativo = correlativo;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodCampania() {
        return codCampania;
    }

    public void setCodCampania(short codCampania) {
        this.codCampania = codCampania;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public long getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(long correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codCampania;
        hash += (int) periodo;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrograCampaniaPK)) {
            return false;
        }
        PrograCampaniaPK other = (PrograCampaniaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codCampania != other.codCampania) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PrograCampaniaPK[ codCia=" + codCia + ", codCampania=" + codCampania + ", periodo=" + periodo + ", correlativo=" + correlativo + " ]";
    }
    
}
