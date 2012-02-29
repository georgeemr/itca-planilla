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
 * @author infosgroup
 */
@Entity
@Table(name = "CAPACITACION_AREAS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapacitacionAreas.findAll", query = "SELECT c FROM CapacitacionAreas c"),
    @NamedQuery(name = "CapacitacionAreas.findByCodCia", query = "SELECT c FROM CapacitacionAreas c WHERE c.capacitacionAreasPK.codCia = :codCia"),
    @NamedQuery(name = "CapacitacionAreas.findByCodArea", query = "SELECT c FROM CapacitacionAreas c WHERE c.capacitacionAreasPK.codArea = :codArea"),
    @NamedQuery(name = "CapacitacionAreas.findByNomArea", query = "SELECT c FROM CapacitacionAreas c WHERE c.nomArea = :nomArea")})
public class CapacitacionAreas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitacionAreasPK capacitacionAreasPK;
    @Column(name = "NOM_AREA", length = 200)
    private String nomArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacionAreas")
    private List<CapacitacionTemas> capacitacionTemasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacionAreas")
    private List<Capacitacion> capacitacionList;

    public CapacitacionAreas() {
    }

    public CapacitacionAreas(CapacitacionAreasPK capacitacionAreasPK) {
        this.capacitacionAreasPK = capacitacionAreasPK;
    }

    public CapacitacionAreas(short codCia, int codArea) {
        this.capacitacionAreasPK = new CapacitacionAreasPK(codCia, codArea);
    }

    public CapacitacionAreasPK getCapacitacionAreasPK() {
        return capacitacionAreasPK;
    }

    public void setCapacitacionAreasPK(CapacitacionAreasPK capacitacionAreasPK) {
        this.capacitacionAreasPK = capacitacionAreasPK;
    }

    public String getNomArea() {
        return nomArea;
    }

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
    }

    @XmlTransient
    public List<CapacitacionTemas> getCapacitacionTemasList() {
        return capacitacionTemasList;
    }

    public void setCapacitacionTemasList(List<CapacitacionTemas> capacitacionTemasList) {
        this.capacitacionTemasList = capacitacionTemasList;
    }

    @XmlTransient
    public List<Capacitacion> getCapacitacionList() {
        return capacitacionList;
    }

    public void setCapacitacionList(List<Capacitacion> capacitacionList) {
        this.capacitacionList = capacitacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capacitacionAreasPK != null ? capacitacionAreasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionAreas)) {
            return false;
        }
        CapacitacionAreas other = (CapacitacionAreas) object;
        if ((this.capacitacionAreasPK == null && other.capacitacionAreasPK != null) || (this.capacitacionAreasPK != null && !this.capacitacionAreasPK.equals(other.capacitacionAreasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitdadesplanilla.CapacitacionAreas[ capacitacionAreasPK=" + capacitacionAreasPK + " ]";
    }
    
}
