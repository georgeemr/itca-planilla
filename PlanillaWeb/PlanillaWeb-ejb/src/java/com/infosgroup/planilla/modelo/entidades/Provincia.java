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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "provincia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByIdPais", query = "SELECT p FROM Provincia p WHERE p.provinciaPK.idPais = :idPais"),
    @NamedQuery(name = "Provincia.findByIdProvincia", query = "SELECT p FROM Provincia p WHERE p.provinciaPK.idProvincia = :idProvincia"),
    @NamedQuery(name = "Provincia.findByNomProvincia", query = "SELECT p FROM Provincia p WHERE p.nomProvincia = :nomProvincia"),
    @NamedQuery(name = "Provincia.findByDetProvincia", query = "SELECT p FROM Provincia p WHERE p.detProvincia = :detProvincia")})
public class Provincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProvinciaPK provinciaPK;
    @Size(max = 100)
    @Column(name = "nom_provincia", length = 100)
    private String nomProvincia;
    @Size(max = 200)
    @Column(name = "det_provincia", length = 200)
    private String detProvincia;
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pais pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
    private List<Municipio> municipioList;

    public Provincia() {
    }

    public Provincia(ProvinciaPK provinciaPK) {
        this.provinciaPK = provinciaPK;
    }

    public Provincia(int idPais, int idProvincia) {
        this.provinciaPK = new ProvinciaPK(idPais, idProvincia);
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
