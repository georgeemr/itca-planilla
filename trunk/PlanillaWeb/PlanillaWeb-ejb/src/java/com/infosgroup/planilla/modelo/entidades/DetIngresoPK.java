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
public class DetIngresoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private int codEmp;
    @Basic(optional = false)
    @Column(name = "TIPO_INGRESO", nullable = false)
    private short tipoIngreso;
    @Basic(optional = false)
    @Column(name = "ESTADO", nullable = false, length = 1)
    private String estado;

    public DetIngresoPK() {
    }

    public DetIngresoPK(short codCia, int codEmp, short tipoIngreso, String estado) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.tipoIngreso = tipoIngreso;
        this.estado = estado;
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

    public short getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(short tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        hash += (int) tipoIngreso;
        hash += (estado != null ? estado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetIngresoPK)) {
            return false;
        }
        DetIngresoPK other = (DetIngresoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if (this.tipoIngreso != other.tipoIngreso) {
            return false;
        }
        if ((this.estado == null && other.estado != null) || (this.estado != null && !this.estado.equals(other.estado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetIngresoPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", tipoIngreso=" + tipoIngreso + ", estado=" + estado + " ]";
    }
    
}
