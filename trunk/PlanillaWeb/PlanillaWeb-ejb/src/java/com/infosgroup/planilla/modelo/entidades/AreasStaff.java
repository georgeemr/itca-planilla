/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "AREAS_STAFF", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreasStaff.findAll", query = "SELECT a FROM AreasStaff a"),
    @NamedQuery(name = "AreasStaff.findByCodArea", query = "SELECT a FROM AreasStaff a WHERE a.codArea = :codArea"),
    @NamedQuery(name = "AreasStaff.findByNomArea", query = "SELECT a FROM AreasStaff a WHERE a.nomArea = :nomArea"),
    @NamedQuery(name = "AreasStaff.findByCodCia", query = "SELECT a FROM AreasStaff a WHERE a.codCia = :codCia")})
public class AreasStaff implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "COD_AREA", nullable = false, precision = 0, scale = -127)
    private BigDecimal codArea;
    @Column(name = "NOM_AREA", length = 50)
    private String nomArea;
    @Column(name = "COD_CIA")
    private Short codCia;
    @OneToMany(mappedBy = "codArea")
    private List<Departamentos> departamentosList;

    public AreasStaff() {
    }

    public AreasStaff(BigDecimal codArea) {
        this.codArea = codArea;
    }

    public BigDecimal getCodArea() {
        return codArea;
    }

    public void setCodArea(BigDecimal codArea) {
        this.codArea = codArea;
    }

    public String getNomArea() {
        return nomArea;
    }

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
    }

    public Short getCodCia() {
        return codCia;
    }

    public void setCodCia(Short codCia) {
        this.codCia = codCia;
    }

    @XmlTransient
    public List<Departamentos> getDepartamentosList() {
        return departamentosList;
    }

    public void setDepartamentosList(List<Departamentos> departamentosList) {
        this.departamentosList = departamentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArea != null ? codArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreasStaff)) {
            return false;
        }
        AreasStaff other = (AreasStaff) object;
        if ((this.codArea == null && other.codArea != null) || (this.codArea != null && !this.codArea.equals(other.codArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.AreasStaff[ codArea=" + codArea + " ]";
    }
    
}
