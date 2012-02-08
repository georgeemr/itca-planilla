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
import javax.persistence.JoinColumns;
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
@Table(name = "MUNICIPIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByCodPais", query = "SELECT m FROM Municipio m WHERE m.municipioPK.codPais = :codPais"),
    @NamedQuery(name = "Municipio.findByCodProvincia", query = "SELECT m FROM Municipio m WHERE m.municipioPK.codProvincia = :codProvincia"),
    @NamedQuery(name = "Municipio.findByCodMunicipio", query = "SELECT m FROM Municipio m WHERE m.municipioPK.codMunicipio = :codMunicipio"),
    @NamedQuery(name = "Municipio.findByNomMunicipio", query = "SELECT m FROM Municipio m WHERE m.nomMunicipio = :nomMunicipio"),
    @NamedQuery(name = "Municipio.findByDetMunicipio", query = "SELECT m FROM Municipio m WHERE m.detMunicipio = :detMunicipio")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MunicipioPK municipioPK;
    @Column(name = "NOM_MUNICIPIO", length = 200)
    private String nomMunicipio;
    @Column(name = "DET_MUNICIPIO", length = 200)
    private String detMunicipio;
    @JoinColumns({
        @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PROVINCIA", referencedColumnName = "COD_PROVINCIA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Provincia provincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipio")
    private List<Barrio> barrioList;

    public Municipio() {
    }

    public Municipio(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public Municipio(long codPais, long codProvincia, long codMunicipio) {
        this.municipioPK = new MunicipioPK(codPais, codProvincia, codMunicipio);
    }

    public MunicipioPK getMunicipioPK() {
        return municipioPK;
    }

    public void setMunicipioPK(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public String getNomMunicipio() {
        return nomMunicipio;
    }

    public void setNomMunicipio(String nomMunicipio) {
        this.nomMunicipio = nomMunicipio;
    }

    public String getDetMunicipio() {
        return detMunicipio;
    }

    public void setDetMunicipio(String detMunicipio) {
        this.detMunicipio = detMunicipio;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @XmlTransient
    public List<Barrio> getBarrioList() {
        return barrioList;
    }

    public void setBarrioList(List<Barrio> barrioList) {
        this.barrioList = barrioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioPK != null ? municipioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.municipioPK == null && other.municipioPK != null) || (this.municipioPK != null && !this.municipioPK.equals(other.municipioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Municipio[ municipioPK=" + municipioPK + " ]";
    }
    
}
