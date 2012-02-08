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
public class FuncionPuestoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_FUNCION", nullable = false)
    private int codFuncion;

    public FuncionPuestoPK() {
    }

    public FuncionPuestoPK(short codCia, int codFuncion) {
        this.codCia = codCia;
        this.codFuncion = codFuncion;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodFuncion() {
        return codFuncion;
    }

    public void setCodFuncion(int codFuncion) {
        this.codFuncion = codFuncion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codFuncion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionPuestoPK)) {
            return false;
        }
        FuncionPuestoPK other = (FuncionPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codFuncion != other.codFuncion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.FuncionPuestoPK[ codCia=" + codCia + ", codFuncion=" + codFuncion + " ]";
    }
    
}
