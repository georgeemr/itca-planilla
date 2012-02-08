/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ROTACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rotacion.findAll", query = "SELECT r FROM Rotacion r"),
    @NamedQuery(name = "Rotacion.findByCodRot", query = "SELECT r FROM Rotacion r WHERE r.codRot = :codRot"),
    @NamedQuery(name = "Rotacion.findByDescripRot", query = "SELECT r FROM Rotacion r WHERE r.descripRot = :descripRot")})
public class Rotacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_ROT", nullable = false, length = 1)
    private String codRot;
    @Column(name = "DESCRIP_ROT", length = 100)
    private String descripRot;

    public Rotacion() {
    }

    public Rotacion(String codRot) {
        this.codRot = codRot;
    }

    public String getCodRot() {
        return codRot;
    }

    public void setCodRot(String codRot) {
        this.codRot = codRot;
    }

    public String getDescripRot() {
        return descripRot;
    }

    public void setDescripRot(String descripRot) {
        this.descripRot = descripRot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRot != null ? codRot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rotacion)) {
            return false;
        }
        Rotacion other = (Rotacion) object;
        if ((this.codRot == null && other.codRot != null) || (this.codRot != null && !this.codRot.equals(other.codRot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Rotacion[ codRot=" + codRot + " ]";
    }
    
}
