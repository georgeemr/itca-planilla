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
public class DireccionSucursalPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_SUCURSAL", nullable = false)
    private long codSucursal;
    @Basic(optional = false)
    @Column(name = "COD_PAIS", nullable = false)
    private long codPais;
    @Basic(optional = false)
    @Column(name = "COD_PROVINCIA", nullable = false)
    private long codProvincia;
    @Basic(optional = false)
    @Column(name = "COD_MUNICIPIO", nullable = false)
    private long codMunicipio;
    @Basic(optional = false)
    @Column(name = "COD_BARRIO", nullable = false)
    private long codBarrio;
    @Basic(optional = false)
    @Column(name = "NUM_CASA", nullable = false, length = 100)
    private String numCasa;

    public DireccionSucursalPK() {
    }

    public DireccionSucursalPK(long codCia, long codSucursal, long codPais, long codProvincia, long codMunicipio, long codBarrio, String numCasa) {
        this.codCia = codCia;
        this.codSucursal = codSucursal;
        this.codPais = codPais;
        this.codProvincia = codProvincia;
        this.codMunicipio = codMunicipio;
        this.codBarrio = codBarrio;
        this.numCasa = numCasa;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(long codSucursal) {
        this.codSucursal = codSucursal;
    }

    public long getCodPais() {
        return codPais;
    }

    public void setCodPais(long codPais) {
        this.codPais = codPais;
    }

    public long getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(long codProvincia) {
        this.codProvincia = codProvincia;
    }

    public long getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(long codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public long getCodBarrio() {
        return codBarrio;
    }

    public void setCodBarrio(long codBarrio) {
        this.codBarrio = codBarrio;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codSucursal;
        hash += (int) codPais;
        hash += (int) codProvincia;
        hash += (int) codMunicipio;
        hash += (int) codBarrio;
        hash += (numCasa != null ? numCasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionSucursalPK)) {
            return false;
        }
        DireccionSucursalPK other = (DireccionSucursalPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codSucursal != other.codSucursal) {
            return false;
        }
        if (this.codPais != other.codPais) {
            return false;
        }
        if (this.codProvincia != other.codProvincia) {
            return false;
        }
        if (this.codMunicipio != other.codMunicipio) {
            return false;
        }
        if (this.codBarrio != other.codBarrio) {
            return false;
        }
        if ((this.numCasa == null && other.numCasa != null) || (this.numCasa != null && !this.numCasa.equals(other.numCasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DireccionSucursalPK[ codCia=" + codCia + ", codSucursal=" + codSucursal + ", codPais=" + codPais + ", codProvincia=" + codProvincia + ", codMunicipio=" + codMunicipio + ", codBarrio=" + codBarrio + ", numCasa=" + numCasa + " ]";
    }
    
}