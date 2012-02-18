/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "AREAS_STAFF", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreasStaff.findAll", query = "SELECT a FROM AreasStaff a"),
    @NamedQuery(name = "AreasStaff.findByCodArea", query = "SELECT a FROM AreasStaff a WHERE a.areasStaffPK.codArea = :codArea"),
    @NamedQuery(name = "AreasStaff.findByNomArea", query = "SELECT a FROM AreasStaff a WHERE a.nomArea = :nomArea"),
    @NamedQuery(name = "AreasStaff.findByCodCia", query = "SELECT a FROM AreasStaff a WHERE a.areasStaffPK.codCia = :codCia")})
public class AreasStaff implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AreasStaffPK areasStaffPK;
    @Column(name = "NOM_AREA", length = 50)
    private String nomArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areasStaff")
    private List<Puestos> puestosList;

    public AreasStaff() {
    }

    public AreasStaff(AreasStaffPK areasStaffPK) {
        this.areasStaffPK = areasStaffPK;
    }

    public AreasStaff(int codArea, short codCia) {
        this.areasStaffPK = new AreasStaffPK(codCia, codArea);
    }

    public AreasStaffPK getAreasStaffPK() {
        return areasStaffPK;
    }

    public void setAreasStaffPK(AreasStaffPK areasStaffPK) {
        this.areasStaffPK = areasStaffPK;
    }

    public String getNomArea() {
        return nomArea;
    }

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
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
        hash += (areasStaffPK != null ? areasStaffPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreasStaff)) {
            return false;
        }
        AreasStaff other = (AreasStaff) object;
        if ((this.areasStaffPK == null && other.areasStaffPK != null) || (this.areasStaffPK != null && !this.areasStaffPK.equals(other.areasStaffPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.AreasStaff[ areasStaffPK=" + areasStaffPK + " ]";
    }
    
}