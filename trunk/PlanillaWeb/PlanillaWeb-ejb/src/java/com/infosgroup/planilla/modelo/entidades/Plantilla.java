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
 * @author root
 */
@Entity
@Table(name = "PLANTILLA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantilla.findAll", query = "SELECT p FROM Plantilla p"),
    @NamedQuery(name = "Plantilla.findByCodCia", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.codCia = :codCia"),
    @NamedQuery(name = "Plantilla.findByCodTipoEvaluacion", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.codTipoEvaluacion = :codTipoEvaluacion"),
    @NamedQuery(name = "Plantilla.findByPeriodo", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.periodo = :periodo"),
    @NamedQuery(name = "Plantilla.findByCodPlantilla", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.codPlantilla = :codPlantilla"),
    @NamedQuery(name = "Plantilla.findByNomPlantilla", query = "SELECT p FROM Plantilla p WHERE p.nomPlantilla = :nomPlantilla")})
public class Plantilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlantillaPK plantillaPK;
    @Column(name = "NOM_PLANTILLA", length = 60)
    private String nomPlantilla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantilla")
    private List<DetPlantilla> detPlantillaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantilla")
    private List<Evaluacion> evaluacionList;

    public Plantilla() {
    }

    public Plantilla(PlantillaPK plantillaPK) {
        this.plantillaPK = plantillaPK;
    }

    public Plantilla(short codCia, short codTipoEvaluacion, int periodo, short codPlantilla) {
        this.plantillaPK = new PlantillaPK(codCia, codTipoEvaluacion, periodo, codPlantilla);
    }

    public PlantillaPK getPlantillaPK() {
        return plantillaPK;
    }

    public void setPlantillaPK(PlantillaPK plantillaPK) {
        this.plantillaPK = plantillaPK;
    }

    public String getNomPlantilla() {
        return nomPlantilla;
    }

    public void setNomPlantilla(String nomPlantilla) {
        this.nomPlantilla = nomPlantilla;
    }

    @XmlTransient
    public List<DetPlantilla> getDetPlantillaList() {
        return detPlantillaList;
    }

    public void setDetPlantillaList(List<DetPlantilla> detPlantillaList) {
        this.detPlantillaList = detPlantillaList;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plantillaPK != null ? plantillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantilla)) {
            return false;
        }
        Plantilla other = (Plantilla) object;
        if ((this.plantillaPK == null && other.plantillaPK != null) || (this.plantillaPK != null && !this.plantillaPK.equals(other.plantillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Plantilla[ plantillaPK=" + plantillaPK + " ]";
    }
    
}
