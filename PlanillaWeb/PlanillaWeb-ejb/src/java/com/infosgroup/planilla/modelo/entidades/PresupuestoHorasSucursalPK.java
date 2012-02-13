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
public class PresupuestoHorasSucursalPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "ANIO", nullable = false)
    private short anio;
    @Basic(optional = false)
    @Column(name = "MES", nullable = false)
    private short mes;
    @Basic(optional = false)
    @Column(name = "CORRELAT", nullable = false)
    private int correlat;

    public PresupuestoHorasSucursalPK() {
    }

    public PresupuestoHorasSucursalPK(short codCia, short anio, short mes, int correlat) {
        this.codCia = codCia;
        this.anio = anio;
        this.mes = mes;
        this.correlat = correlat;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
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

    public int getCorrelat() {
        return correlat;
    }

    public void setCorrelat(int correlat) {
        this.correlat = correlat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) anio;
        hash += (int) mes;
        hash += (int) correlat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoHorasSucursalPK)) {
            return false;
        }
        PresupuestoHorasSucursalPK other = (PresupuestoHorasSucursalPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.correlat != other.correlat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PresupuestoHorasSucursalPK[ codCia=" + codCia + ", anio=" + anio + ", mes=" + mes + ", correlat=" + correlat + " ]";
    }
    
}
