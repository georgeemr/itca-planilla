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
@Table(name = "direccion_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionEmpleado.findAll", query = "SELECT d FROM DireccionEmpleado d"),
    @NamedQuery(name = "DireccionEmpleado.findByIdCompania", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.idCompania = :idCompania"),
    @NamedQuery(name = "DireccionEmpleado.findByIdSucursal", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "DireccionEmpleado.findByIdEmpleado", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "DireccionEmpleado.findByIdPais", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.idPais = :idPais"),
    @NamedQuery(name = "DireccionEmpleado.findByIdProvincia", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.idProvincia = :idProvincia"),
    @NamedQuery(name = "DireccionEmpleado.findByIdMunicipio", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "DireccionEmpleado.findByIdBarrio", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.idBarrio = :idBarrio"),
    @NamedQuery(name = "DireccionEmpleado.findByNumCasa", query = "SELECT d FROM DireccionEmpleado d WHERE d.direccionEmpleadoPK.numCasa = :numCasa")})
public class DireccionEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionEmpleadoPK direccionEmpleadoPK;
    @JoinColumns({
        @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "num_casa", referencedColumnName = "num_casa", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Direccion direccion;

    public DireccionEmpleado() {
    }

    public DireccionEmpleado(DireccionEmpleadoPK direccionEmpleadoPK) {
        this.direccionEmpleadoPK = direccionEmpleadoPK;
    }

    public DireccionEmpleado(int idCompania, int idSucursal, int idEmpleado, int idPais, int idProvincia, int idMunicipio, int idBarrio, String numCasa) {
        this.direccionEmpleadoPK = new DireccionEmpleadoPK(idCompania, idSucursal, idEmpleado, idPais, idProvincia, idMunicipio, idBarrio, numCasa);
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
