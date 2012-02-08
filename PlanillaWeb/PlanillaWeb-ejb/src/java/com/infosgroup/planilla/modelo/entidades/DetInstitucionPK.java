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
public class DetInstitucionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_INSTI", nullable = false)
    private short codInsti;
    @Basic(optional = false)
    @Column(name = "COD_PAIS", nullable = false)
    private short codPais;
    @Basic(optional = false)
    @Column(name = "COD_DEPARTAMENTO", nullable = false)
    private short codDepartamento;

    public DetInstitucionPK() {
    }

    public DetInstitucionPK(short codCia, short codInsti, short codPais, short codDepartamento) {
        this.codCia = codCia;
        this.codInsti = codInsti;
        this.codPais = codPais;
        this.codDepartamento = codDepartamento;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodInsti() {
        return codInsti;
    }

    public void setCodInsti(short codInsti) {
        this.codInsti = codInsti;
    }

    public short getCodPais() {
        return codPais;
    }

    public void setCodPais(short codPais) {
        this.codPais = codPais;
    }

    public short getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(short codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codInsti;
        hash += (int) codPais;
        hash += (int) codDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetInstitucionPK)) {
            return false;
        }
        DetInstitucionPK other = (DetInstitucionPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codInsti != other.codInsti) {
            return false;
        }
        if (this.codPais != other.codPais) {
            return false;
        }
        if (this.codDepartamento != other.codDepartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetInstitucionPK[ codCia=" + codCia + ", codInsti=" + codInsti + ", codPais=" + codPais + ", codDepartamento=" + codDepartamento + " ]";
    }
    
}
