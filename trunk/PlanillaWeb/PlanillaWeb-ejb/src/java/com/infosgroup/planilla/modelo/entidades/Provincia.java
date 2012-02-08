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
import javax.persistence.ManyToOne;
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
@Table(name = "PROVINCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByCodPais", query = "SELECT p FROM Provincia p WHERE p.provinciaPK.codPais = :codPais"),
    @NamedQuery(name = "Provincia.findByCodProvincia", query = "SELECT p FROM Provincia p WHERE p.provinciaPK.codProvincia = :codProvincia"),
    @NamedQuery(name = "Provincia.findByNomProvincia", query = "SELECT p FROM Provincia p WHERE p.nomProvincia = :nomProvincia"),
    @NamedQuery(name = "Provincia.findByDetProvincia", query = "SELECT p FROM Provincia p WHERE p.detProvincia = :detProvincia")})
public class Provincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProvinciaPK provinciaPK;
    @Column(name = "NOM_PROVINCIA", length = 200)
    private String nomProvincia;
    @Column(name = "DET_PROVINCIA", length = 200)
    private String detProvincia;
    @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pais pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
    private List<Municipio> municipioList;

    public Provincia() {
    }

    public Provincia(ProvinciaPK provinciaPK) {
        this.provinciaPK = provinciaPK;
    }

    public Provincia(long codPais, long codProvincia) {
        this.provinciaPK = new ProvinciaPK(codPais, codProvincia);
    }

    public ProvinciaPK getProvinciaPK() {
        return provinciaPK;
    }

    public void setProvinciaPK(ProvinciaPK provinciaPK) {
        this.provinciaPK = provinciaPK;
    }

    public String getNomProvincia() {
        return nomProvincia;
    }

    public void setNomProvincia(String nomProvincia) {
        this.nomProvincia = nomProvincia;
    }

    public String getDetProvincia() {
        return detProvincia;
    }

    public void setDetProvincia(String detProvincia) {
        this.detProvincia = detProvincia;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @XmlTransient
    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinciaPK != null ? provinciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.provinciaPK == null && other.provinciaPK != null) || (this.provinciaPK != null && !this.provinciaPK.equals(other.provinciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Provincia[ provinciaPK=" + provinciaPK + " ]";
    }
    
}
