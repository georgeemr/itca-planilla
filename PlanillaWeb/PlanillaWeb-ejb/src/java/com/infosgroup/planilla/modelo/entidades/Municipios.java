/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(schema="PARAMETROS", name = "MUNICIPIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByCodPais", query = "SELECT m FROM Municipios m WHERE m.municipiosPK.codPais = :codPais"),
    @NamedQuery(name = "Municipios.findByCodDepto", query = "SELECT m FROM Municipios m WHERE m.municipiosPK.codDepto = :codDepto"),
    @NamedQuery(name = "Municipios.findByCodMuni", query = "SELECT m FROM Municipios m WHERE m.municipiosPK.codMuni = :codMuni"),
    @NamedQuery(name = "Municipios.findByNomMuni", query = "SELECT m FROM Municipios m WHERE m.nomMuni = :nomMuni"),
    @NamedQuery(name = "Municipios.findByZona", query = "SELECT m FROM Municipios m WHERE m.zona = :zona")})
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MunicipiosPK municipiosPK;
    @Column(name = "NOM_MUNI", length = 30)
    private String nomMuni;
    @Column(name = "ZONA", length = 1)
    private String zona;
    @JoinColumns({
        @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Deptos deptos;

    public Municipios() {
    }

    public Municipios(MunicipiosPK municipiosPK) {
        this.municipiosPK = municipiosPK;
    }

    public Municipios(short codPais, short codDepto, short codMuni) {
        this.municipiosPK = new MunicipiosPK(codPais, codDepto, codMuni);
    }

    public MunicipiosPK getMunicipiosPK() {
        return municipiosPK;
    }

    public void setMunicipiosPK(MunicipiosPK municipiosPK) {
        this.municipiosPK = municipiosPK;
    }

    public String getNomMuni() {
        return nomMuni;
    }

    public void setNomMuni(String nomMuni) {
        this.nomMuni = nomMuni;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Deptos getDeptos() {
        return deptos;
    }

    public void setDeptos(Deptos deptos) {
        this.deptos = deptos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipiosPK != null ? municipiosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.municipiosPK == null && other.municipiosPK != null) || (this.municipiosPK != null && !this.municipiosPK.equals(other.municipiosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.parametros.Municipios[ municipiosPK=" + municipiosPK + " ]";
    }
    
}
