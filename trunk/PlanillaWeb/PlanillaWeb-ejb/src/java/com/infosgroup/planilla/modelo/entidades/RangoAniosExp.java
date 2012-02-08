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
@Table(name = "RANGO_ANIOS_EXP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RangoAniosExp.findAll", query = "SELECT r FROM RangoAniosExp r"),
    @NamedQuery(name = "RangoAniosExp.findByCodRangoAnios", query = "SELECT r FROM RangoAniosExp r WHERE r.codRangoAnios = :codRangoAnios"),
    @NamedQuery(name = "RangoAniosExp.findByDescRango", query = "SELECT r FROM RangoAniosExp r WHERE r.descRango = :descRango")})
public class RangoAniosExp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_RANGO_ANIOS", nullable = false)
    private Long codRangoAnios;
    @Column(name = "DESC_RANGO", length = 50)
    private String descRango;
    @OneToMany(mappedBy = "codRangoAnios")
    private List<Puestos> puestosList;

    public RangoAniosExp() {
    }

    public RangoAniosExp(Long codRangoAnios) {
        this.codRangoAnios = codRangoAnios;
    }

    public Long getCodRangoAnios() {
        return codRangoAnios;
    }

    public void setCodRangoAnios(Long codRangoAnios) {
        this.codRangoAnios = codRangoAnios;
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
        hash += (codRangoAnios != null ? codRangoAnios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RangoAniosExp)) {
            return false;
        }
        RangoAniosExp other = (RangoAniosExp) object;
        if ((this.codRangoAnios == null && other.codRangoAnios != null) || (this.codRangoAnios != null && !this.codRangoAnios.equals(other.codRangoAnios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RangoAniosExp[ codRangoAnios=" + codRangoAnios + " ]";
    }
    
}
