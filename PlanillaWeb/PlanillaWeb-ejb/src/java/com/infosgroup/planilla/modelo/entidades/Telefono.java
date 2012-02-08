/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TELEFONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByCodTelefono", query = "SELECT t FROM Telefono t WHERE t.codTelefono = :codTelefono"),
    @NamedQuery(name = "Telefono.findByNumTelefono", query = "SELECT t FROM Telefono t WHERE t.numTelefono = :numTelefono")})
public class Telefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_TELEFONO", nullable = false)
    private Long codTelefono;
    @Column(name = "NUM_TELEFONO", length = 20)
    private String numTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telefono")
    private List<EmpleadoTelefono> empleadoTelefonoList;

    public Telefono() {
    }

    public Telefono(Long codTelefono) {
        this.codTelefono = codTelefono;
    }

    public Long getCodTelefono() {
        return codTelefono;
    }

    public void setCodTelefono(Long codTelefono) {
        this.codTelefono = codTelefono;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    @XmlTransient
    public List<EmpleadoTelefono> getEmpleadoTelefonoList() {
        return empleadoTelefonoList;
    }

    public void setEmpleadoTelefonoList(List<EmpleadoTelefono> empleadoTelefonoList) {
        this.empleadoTelefonoList = empleadoTelefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTelefono != null ? codTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.codTelefono == null && other.codTelefono != null) || (this.codTelefono != null && !this.codTelefono.equals(other.codTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Telefono[ codTelefono=" + codTelefono + " ]";
    }
    
}
