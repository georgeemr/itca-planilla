/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DIRECCION_SUCURSAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionSucursal.findAll", query = "SELECT d FROM DireccionSucursal d"),
    @NamedQuery(name = "DireccionSucursal.findByCodCia", query = "SELECT d FROM DireccionSucursal d WHERE d.direccionSucursalPK.codCia = :codCia"),
    @NamedQuery(name = "DireccionSucursal.findByCodSucursal", query = "SELECT d FROM DireccionSucursal d WHERE d.direccionSucursalPK.codSucursal = :codSucursal"),
    @NamedQuery(name = "DireccionSucursal.findByCodPais", query = "SELECT d FROM DireccionSucursal d WHERE d.direccionSucursalPK.codPais = :codPais"),
    @NamedQuery(name = "DireccionSucursal.findByCodProvincia", query = "SELECT d FROM DireccionSucursal d WHERE d.direccionSucursalPK.codProvincia = :codProvincia"),
    @NamedQuery(name = "DireccionSucursal.findByCodMunicipio", query = "SELECT d FROM DireccionSucursal d WHERE d.direccionSucursalPK.codMunicipio = :codMunicipio"),
    @NamedQuery(name = "DireccionSucursal.findByCodBarrio", query = "SELECT d FROM DireccionSucursal d WHERE d.direccionSucursalPK.codBarrio = :codBarrio"),
    @NamedQuery(name = "DireccionSucursal.findByNumCasa", query = "SELECT d FROM DireccionSucursal d WHERE d.direccionSucursalPK.numCasa = :numCasa")})
public class DireccionSucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionSucursalPK direccionSucursalPK;
    @JoinColumns({
        @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PROVINCIA", referencedColumnName = "COD_PROVINCIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_MUNICIPIO", referencedColumnName = "COD_MUNICIPIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_BARRIO", referencedColumnName = "COD_BARRIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NUM_CASA", referencedColumnName = "NUM_CASA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Direccion direccion;

    public DireccionSucursal() {
    }

    public DireccionSucursal(DireccionSucursalPK direccionSucursalPK) {
        this.direccionSucursalPK = direccionSucursalPK;
    }

    public DireccionSucursal(long codCia, long codSucursal, long codPais, long codProvincia, long codMunicipio, long codBarrio, String numCasa) {
        this.direccionSucursalPK = new DireccionSucursalPK(codCia, codSucursal, codPais, codProvincia, codMunicipio, codBarrio, numCasa);
    }

    public DireccionSucursalPK getDireccionSucursalPK() {
        return direccionSucursalPK;
    }

    public void setDireccionSucursalPK(DireccionSucursalPK direccionSucursalPK) {
        this.direccionSucursalPK = direccionSucursalPK;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (direccionSucursalPK != null ? direccionSucursalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionSucursal)) {
            return false;
        }
        DireccionSucursal other = (DireccionSucursal) object;
        if ((this.direccionSucursalPK == null && other.direccionSucursalPK != null) || (this.direccionSucursalPK != null && !this.direccionSucursalPK.equals(other.direccionSucursalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DireccionSucursal[ direccionSucursalPK=" + direccionSucursalPK + " ]";
    }
    
}
