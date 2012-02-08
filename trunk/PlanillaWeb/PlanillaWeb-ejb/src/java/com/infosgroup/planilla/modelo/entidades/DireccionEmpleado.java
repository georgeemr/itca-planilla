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
@Table(name = "DIRECCION_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionEmpleado.findAll", query = "SELECT d FROM DireccionEmpleado d"),
    @NamedQuery(name = "DireccionEmpleado.findByCodCia", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.codCia = :codCia"),
    @NamedQuery(name = "DireccionEmpleado.findByCodSucursal", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.codSucursal = :codSucursal"),
    @NamedQuery(name = "DireccionEmpleado.findByCodEmpleado", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.codEmpleado = :codEmpleado"),
    @NamedQuery(name = "DireccionEmpleado.findByCodPais", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.codPais = :codPais"),
    @NamedQuery(name = "DireccionEmpleado.findByCodProvincia", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.codProvincia = :codProvincia"),
    @NamedQuery(name = "DireccionEmpleado.findByCodMunicipio", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.codMunicipio = :codMunicipio"),
    @NamedQuery(name = "DireccionEmpleado.findByCodBarrio", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.codBarrio = :codBarrio"),
    @NamedQuery(name = "DireccionEmpleado.findByNumCasa", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.numCasa = :numCasa")})
public class DireccionEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionEmpleadoPK direccionEmpleadoPK;
    @JoinColumns({
        @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PROVINCIA", referencedColumnName = "COD_PROVINCIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_MUNICIPIO", referencedColumnName = "COD_MUNICIPIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_BARRIO", referencedColumnName = "COD_BARRIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NUM_CASA", referencedColumnName = "NUM_CASA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Direccion direccion;

    public DireccionEmpleado() {
    }

    public DireccionEmpleado(DireccionEmpleadoPK direccionEmpleadoPK) {
        this.direccionEmpleadoPK = direccionEmpleadoPK;
    }

    public DireccionEmpleado(long codCia, long codSucursal, long codEmpleado, long codPais, long codProvincia, long codMunicipio, long codBarrio, String numCasa) {
        this.direccionEmpleadoPK = new DireccionEmpleadoPK(codCia, codSucursal, codEmpleado, codPais, codProvincia, codMunicipio, codBarrio, numCasa);
    }

    public DireccionEmpleadoPK getDireccionEmpleadoPK() {
        return direccionEmpleadoPK;
    }

    public void setDireccionEmpleadoPK(DireccionEmpleadoPK direccionEmpleadoPK) {
        this.direccionEmpleadoPK = direccionEmpleadoPK;
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
        hash += (direccionEmpleadoPK != null ? direccionEmpleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionEmpleado)) {
            return false;
        }
        DireccionEmpleado other = (DireccionEmpleado) object;
        if ((this.direccionEmpleadoPK == null && other.direccionEmpleadoPK != null) || (this.direccionEmpleadoPK != null && !this.direccionEmpleadoPK.equals(other.direccionEmpleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DireccionEmpleado[ direccionEmpleadoPK=" + direccionEmpleadoPK + " ]";
    }
    
}
