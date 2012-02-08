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
@Table(name = "BARRIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b"),
    @NamedQuery(name = "Barrio.findByCodPais", query = "SELECT b FROM Barrio b WHERE b.barrioPK.codPais = :codPais"),
    @NamedQuery(name = "Barrio.findByCodProvincia", query = "SELECT b FROM Barrio b WHERE b.barrioPK.codProvincia = :codProvincia"),
    @NamedQuery(name = "Barrio.findByCodMunicipio", query = "SELECT b FROM Barrio b WHERE b.barrioPK.codMunicipio = :codMunicipio"),
    @NamedQuery(name = "Barrio.findByCodBarrio", query = "SELECT b FROM Barrio b WHERE b.barrioPK.codBarrio = :codBarrio"),
    @NamedQuery(name = "Barrio.findByNomBarrio", query = "SELECT b FROM Barrio b WHERE b.nomBarrio = :nomBarrio"),
    @NamedQuery(name = "Barrio.findByDetBarrio", query = "SELECT b FROM Barrio b WHERE b.detBarrio = :detBarrio")})
public class Barrio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BarrioPK barrioPK;
    @Column(name = "NOM_BARRIO", length = 200)
    private String nomBarrio;
    @Column(name = "DET_BARRIO", length = 200)
    private String detBarrio;
    @JoinColumns({
        @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PROVINCIA", referencedColumnName = "COD_PROVINCIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_MUNICIPIO", referencedColumnName = "COD_MUNICIPIO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Municipio municipio;

    public Barrio() {
    }

    public Barrio(BarrioPK barrioPK) {
        this.barrioPK = barrioPK;
    }

    public Barrio(long codPais, long codProvincia, long codMunicipio, long codBarrio) {
        this.barrioPK = new BarrioPK(codPais, codProvincia, codMunicipio, codBarrio);
    }

    public BarrioPK getBarrioPK() {
        return barrioPK;
    }

    public void setBarrioPK(BarrioPK barrioPK) {
        this.barrioPK = barrioPK;
    }

    public String getNomBarrio() {
        return nomBarrio;
    }

    public void setNomBarrio(String nomBarrio) {
        this.nomBarrio = nomBarrio;
    }

    public String getDetBarrio() {
        return detBarrio;
    }

    public void setDetBarrio(String detBarrio) {
        this.detBarrio = detBarrio;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barrioPK != null ? barrioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.barrioPK == null && other.barrioPK != null) || (this.barrioPK != null && !this.barrioPK.equals(other.barrioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Barrio[ barrioPK=" + barrioPK + " ]";
    }
    
}
