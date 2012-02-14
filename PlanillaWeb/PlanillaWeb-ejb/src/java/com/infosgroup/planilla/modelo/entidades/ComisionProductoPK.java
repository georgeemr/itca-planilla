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
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Embeddable
public class ComisionProductoPK implements Serializable {
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
    @Size(min = 1, max = 2)
    @Column(name = "CAT_PRODUCTO", nullable = false, length = 2)
    private String catProducto;

    public ComisionProductoPK() {
    }

    public ComisionProductoPK(short codCia, int codEmp, String catProducto) {
        this.codCia = codCia;
        this.codEmp = codEmp;
        this.catProducto = catProducto;
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

    public String getCatProducto() {
        return catProducto;
    }

    public void setCatProducto(String catProducto) {
        this.catProducto = catProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codEmp;
        hash += (catProducto != null ? catProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionProductoPK)) {
            return false;
        }
        ComisionProductoPK other = (ComisionProductoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codEmp != other.codEmp) {
            return false;
        }
        if ((this.catProducto == null && other.catProducto != null) || (this.catProducto != null && !this.catProducto.equals(other.catProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ComisionProductoPK[ codCia=" + codCia + ", codEmp=" + codEmp + ", catProducto=" + catProducto + " ]";
    }
    
}
