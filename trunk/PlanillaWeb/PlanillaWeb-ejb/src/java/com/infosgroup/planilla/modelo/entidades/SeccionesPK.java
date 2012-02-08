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
public class SeccionesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_DEPTO", nullable = false)
    private short codDepto;
    @Basic(optional = false)
    @Column(name = "COD_SECCION", nullable = false)
    private short codSeccion;

    public SeccionesPK() {
    }

    public SeccionesPK(short codCia, short codDepto, short codSeccion) {
        this.codCia = codCia;
        this.codDepto = codDepto;
        this.codSeccion = codSeccion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(short codDepto) {
        this.codDepto = codDepto;
    }

    public short getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(short codSeccion) {
        this.codSeccion = codSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codDepto;
        hash += (int) codSeccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeccionesPK)) {
            return false;
        }
        SeccionesPK other = (SeccionesPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codDepto != other.codDepto) {
            return false;
        }
        if (this.codSeccion != other.codSeccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.SeccionesPK[ codCia=" + codCia + ", codDepto=" + codDepto + ", codSeccion=" + codSeccion + " ]";
    }
    
}
