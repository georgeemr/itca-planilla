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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "sucursal")
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByIdCompania", query = "SELECT s FROM Sucursal s WHERE s.sucursalPK.idCompania = :idCompania"),
    @NamedQuery(name = "Sucursal.findByIdSucursal", query = "SELECT s FROM Sucursal s WHERE s.sucursalPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "Sucursal.findByNomSucursal", query = "SELECT s FROM Sucursal s WHERE s.nomSucursal = :nomSucursal"),
    @NamedQuery(name = "Sucursal.findByDetSucursal", query = "SELECT s FROM Sucursal s WHERE s.detSucursal = :detSucursal")})
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SucursalPK sucursalPK;
    @Size(max = 100)
    @Column(name = "nom_sucursal", length = 100)
    private String nomSucursal;
    @Size(max = 200)
    @Column(name = "det_sucursal", length = 200)
    private String detSucursal;
    @ManyToMany(mappedBy = "sucursalList")
    private List<Direccion> direccionList;
    @JoinTable(name = "sucursal_telefono", joinColumns = {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_telefono", referencedColumnName = "id_telefono", nullable = false)})
    @ManyToMany
    private List<Telefono> telefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    private List<PuestoEmpleado> puestoEmpleadoList;
    @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public Sucursal() {
    }

    public Sucursal(SucursalPK sucursalPK) {
        this.sucursalPK = sucursalPK;
    }

    public Sucursal(int idCompania, int idSucursal) {
        this.sucursalPK = new SucursalPK(idCompania, idSucursal);
    }

    public SucursalPK getSucursalPK() {
        return sucursalPK;
    }

    public void setSucursalPK(SucursalPK sucursalPK) {
        this.sucursalPK = sucursalPK;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getDetSucursal() {
        return detSucursal;
    }

    public void setDetSucursal(String detSucursal) {
        this.detSucursal = detSucursal;
    }

    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    public List<PuestoEmpleado> getPuestoEmpleadoList() {
        return puestoEmpleadoList;
    }

    public void setPuestoEmpleadoList(List<PuestoEmpleado> puestoEmpleadoList) {
        this.puestoEmpleadoList = puestoEmpleadoList;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sucursalPK != null ? sucursalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.sucursalPK == null && other.sucursalPK != null) || (this.sucursalPK != null && !this.sucursalPK.equals(other.sucursalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Sucursal[ sucursalPK=" + sucursalPK + " ]";
    }
    
}
