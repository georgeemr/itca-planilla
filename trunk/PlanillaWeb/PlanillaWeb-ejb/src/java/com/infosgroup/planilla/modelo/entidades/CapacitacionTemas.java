/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author infosgroup
 */
@Entity
@Table(name = "CAPACITACION_TEMAS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapacitacionTemas.findAll", query = "SELECT c FROM CapacitacionTemas c"),
    @NamedQuery(name = "CapacitacionTemas.findByCodCia", query = "SELECT c FROM CapacitacionTemas c WHERE c.capacitacionTemasPK.codCia = :codCia"),
    @NamedQuery(name = "CapacitacionTemas.findByCodArea", query = "SELECT c FROM CapacitacionTemas c WHERE c.capacitacionTemasPK.codArea = :codArea"),
    @NamedQuery(name = "CapacitacionTemas.findByCodTema", query = "SELECT c FROM CapacitacionTemas c WHERE c.capacitacionTemasPK.codTema = :codTema"),
    @NamedQuery(name = "CapacitacionTemas.findByNomTema", query = "SELECT c FROM CapacitacionTemas c WHERE c.nomTema = :nomTema")})
public class CapacitacionTemas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitacionTemasPK capacitacionTemasPK;
    @Basic(optional = false)
    @Column(name = "NOM_TEMA", nullable = false, length = 200)
    private String nomTema;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_AREA", referencedColumnName = "COD_AREA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CapacitacionAreas capacitacionAreas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacionTemas")
    private List<Capacitacion> capacitacionList;

    public CapacitacionTemas() {
    }

    public CapacitacionTemas(CapacitacionTemasPK capacitacionTemasPK) {
        this.capacitacionTemasPK = capacitacionTemasPK;
    }

    public CapacitacionTemas(CapacitacionTemasPK capacitacionTemasPK, String nomTema) {
        this.capacitacionTemasPK = capacitacionTemasPK;
        this.nomTema = nomTema;
    }

    public CapacitacionTemas(short codCia, int codArea, int codTema) {
        this.capacitacionTemasPK = new CapacitacionTemasPK(codCia, codArea, codTema);
    }

    public CapacitacionTemasPK getCapacitacionTemasPK() {
        return capacitacionTemasPK;
    }

    public void setCapacitacionTemasPK(CapacitacionTemasPK capacitacionTemasPK) {
        this.capacitacionTemasPK = capacitacionTemasPK;
    }

    public String getNomTema() {
        return nomTema;
    }

    public void setNomTema(String nomTema) {
        this.nomTema = nomTema;
    }

    public CapacitacionAreas getCapacitacionAreas() {
        return capacitacionAreas;
    }

    public void setCapacitacionAreas(CapacitacionAreas capacitacionAreas) {
        this.capacitacionAreas = capacitacionAreas;
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
        hash += (capacitacionTemasPK != null ? capacitacionTemasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionTemas)) {
            return false;
        }
        CapacitacionTemas other = (CapacitacionTemas) object;
        if ((this.capacitacionTemasPK == null && other.capacitacionTemasPK != null) || (this.capacitacionTemasPK != null && !this.capacitacionTemasPK.equals(other.capacitacionTemasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitdadesplanilla.CapacitacionTemas[ capacitacionTemasPK=" + capacitacionTemasPK + " ]";
    }
    
}
