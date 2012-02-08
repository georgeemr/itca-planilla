/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "RANGO_EDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RangoEdad.findAll", query = "SELECT r FROM RangoEdad r"),
    @NamedQuery(name = "RangoEdad.findByCodRangoEdad", query = "SELECT r FROM RangoEdad r WHERE r.codRangoEdad = :codRangoEdad"),
    @NamedQuery(name = "RangoEdad.findByDescRango", query = "SELECT r FROM RangoEdad r WHERE r.descRango = :descRango")})
public class RangoEdad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_RANGO_EDAD", nullable = false)
    private Long codRangoEdad;
    @Column(name = "DESC_RANGO", length = 50)
    private String descRango;
    @OneToMany(mappedBy = "codRangoEdad")
    private List<Puestos> puestosList;

    public RangoEdad() {
    }

    public RangoEdad(Long codRangoEdad) {
        this.codRangoEdad = codRangoEdad;
    }

    public Long getCodRangoEdad() {
        return codRangoEdad;
    }

    public void setCodRangoEdad(Long codRangoEdad) {
        this.codRangoEdad = codRangoEdad;
    }

    public String getDescRango() {
        return descRango;
    }

    public void setDescRango(String descRango) {
        this.descRango = descRango;
    }

    @XmlTransient
    public List<Puestos> getPuestosList() {
        return puestosList;
    }

    public void setPuestosList(List<Puestos> puestosList) {
        this.puestosList = puestosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRangoEdad != null ? codRangoEdad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RangoEdad)) {
            return false;
        }
        RangoEdad other = (RangoEdad) object;
        if ((this.codRangoEdad == null && other.codRangoEdad != null) || (this.codRangoEdad != null && !this.codRangoEdad.equals(other.codRangoEdad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RangoEdad[ codRangoEdad=" + codRangoEdad + " ]";
    }
    
}
