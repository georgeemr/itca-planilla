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
public class DeduccionesPrestacionesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private int idCompania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_cuenta", nullable = false)
    private int idTipoCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuenta", nullable = false)
    private int idCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prestacion", nullable = false)
    private int idPrestacion;

    public DeduccionesPrestacionesPK() {
    }

    public DeduccionesPrestacionesPK(int idCompania, int idTipoCuenta, int idCuenta, int idPrestacion) {
        this.idCompania = idCompania;
        this.idTipoCuenta = idTipoCuenta;
        this.idCuenta = idCuenta;
        this.idPrestacion = idPrestacion;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdPrestacion() {
        return idPrestacion;
    }

    public void setIdPrestacion(int idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompania;
        hash += (int) idTipoCuenta;
        hash += (int) idCuenta;
        hash += (int) idPrestacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeduccionesPrestacionesPK)) {
            return false;
        }
        DeduccionesPrestacionesPK other = (DeduccionesPrestacionesPK) object;
        if (this.idCompania != other.idCompania) {
            return false;
        }
        if (this.idTipoCuenta != other.idTipoCuenta) {
            return false;
        }
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        if (this.idPrestacion != other.idPrestacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DeduccionesPrestacionesPK[ idCompania=" + idCompania + ", idTipoCuenta=" + idTipoCuenta + ", idCuenta=" + idCuenta + ", idPrestacion=" + idPrestacion + " ]";
    }
    
}
