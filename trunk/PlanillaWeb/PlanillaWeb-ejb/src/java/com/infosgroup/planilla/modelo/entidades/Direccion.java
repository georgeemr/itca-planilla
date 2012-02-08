/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DIRECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByCodPais", query = "SELECT d FROM Direccion d WHERE d.direccionPK.codPais = :codPais"),
    @NamedQuery(name = "Direccion.findByCodProvincia", query = "SELECT d FROM Direccion d WHERE d.direccionPK.codProvincia = :codProvincia"),
    @NamedQuery(name = "Direccion.findByCodMunicipio", query = "SELECT d FROM Direccion d WHERE d.direccionPK.codMunicipio = :codMunicipio"),
    @NamedQuery(name = "Direccion.findByCodBarrio", query = "SELECT d FROM Direccion d WHERE d.direccionPK.codBarrio = :codBarrio"),
    @NamedQuery(name = "Direccion.findByNumCasa", query = "SELECT d FROM Direccion d WHERE d.direccionPK.numCasa = :numCasa"),
    @NamedQuery(name = "Direccion.findByNumCodpostal", query = "SELECT d FROM Direccion d WHERE d.numCodpostal = :numCodpostal"),
    @NamedQuery(name = "Direccion.findByDetDireccion", query = "SELECT d FROM Direccion d WHERE d.detDireccion = :detDireccion")})
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionPK direccionPK;
    @Column(name = "NUM_CODPOSTAL", length = 200)
    private String numCodpostal;
    @Column(name = "DET_DIRECCION", length = 200)
    private String detDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccion")
    private List<DireccionSucursal> direccionSucursalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccion")
    private List<DireccionEmpleado> direccionEmpleadoList;

    public Direccion() {
    }

    public Direccion(DireccionPK direccionPK) {
        this.direccionPK = direccionPK;
    }

    public Direccion(long codPais, long codProvincia, long codMunicipio, long codBarrio, String numCasa) {
        this.direccionPK = new DireccionPK(codPais, codProvincia, codMunicipio, codBarrio, numCasa);
    }

    public DireccionPK getDireccionPK() {
        return direccionPK;
    }

    public void setDireccionPK(DireccionPK direccionPK) {
        this.direccionPK = direccionPK;
    }

    public String getNumCodpostal() {
        return numCodpostal;
    }

    public void setNumCodpostal(String numCodpostal) {
        this.numCodpostal = numCodpostal;
    }

    public String getDetDireccion() {
        return detDireccion;
    }

    public void setDetDireccion(String detDireccion) {
        this.detDireccion = detDireccion;
    }

    @XmlTransient
    public List<DireccionSucursal> getDireccionSucursalList() {
        return direccionSucursalList;
    }

    public void setDireccionSucursalList(List<DireccionSucursal> direccionSucursalList) {
        this.direccionSucursalList = direccionSucursalList;
    }

    @XmlTransient
    public List<DireccionEmpleado> getDireccionEmpleadoList() {
        return direccionEmpleadoList;
    }

    public void setDireccionEmpleadoList(List<DireccionEmpleado> direccionEmpleadoList) {
        this.direccionEmpleadoList = direccionEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (direccionPK != null ? direccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.direccionPK == null && other.direccionPK != null) || (this.direccionPK != null && !this.direccionPK.equals(other.direccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Direccion[ direccionPK=" + direccionPK + " ]";
    }
    
}
