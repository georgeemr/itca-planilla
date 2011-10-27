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
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "plantilla", catalog = "planilla", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Plantilla.findAll", query = "SELECT p FROM Plantilla p"),
    @NamedQuery(name = "Plantilla.findByCodCia", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.codCia = :codCia"),
    @NamedQuery(name = "Plantilla.findByCodTipoEvaluacion", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.codTipoEvaluacion = :codTipoEvaluacion"),
    @NamedQuery(name = "Plantilla.findByPeriodo", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.periodo = :periodo"),
    @NamedQuery(name = "Plantilla.findByCodPlantilla", query = "SELECT p FROM Plantilla p WHERE p.plantillaPK.codPlantilla = :codPlantilla"),
    @NamedQuery(name = "Plantilla.findByNomPlantilla", query = "SELECT p FROM Plantilla p WHERE p.nomPlantilla = :nomPlantilla"),
    @NamedQuery(name = "Plantilla.findByIncluyeObjetivos", query = "SELECT p FROM Plantilla p WHERE p.incluyeObjetivos = :incluyeObjetivos"),
    @NamedQuery(name = "Plantilla.findByIncluyeCompetencias", query = "SELECT p FROM Plantilla p WHERE p.incluyeCompetencias = :incluyeCompetencias")})
public class Plantilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlantillaPK plantillaPK;
    @Size(max = 2147483647)
    @Column(name = "nom_plantilla", length = 2147483647)
    private String nomPlantilla;
    @Size(max = 2147483647)
    @Column(name = "incluye_objetivos", length = 2147483647)
    private String incluyeObjetivos;
    @Size(max = 2147483647)
    @Column(name = "incluye_competencias", length = 2147483647)
    private String incluyeCompetencias;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_tipo_evaluacion", referencedColumnName = "cod_tipo_evaluacion", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoEvaluacion tipoEvaluacion;

    public Plantilla() {
    }

    public Plantilla(PlantillaPK plantillaPK) {
        this.plantillaPK = plantillaPK;
    }

    public Plantilla(int codCia, int codTipoEvaluacion, int periodo, int codPlantilla) {
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

    public String getIncluyeObjetivos() {
        return incluyeObjetivos;
    }

    public void setIncluyeObjetivos(String incluyeObjetivos) {
        this.incluyeObjetivos = incluyeObjetivos;
    }

    public String getIncluyeCompetencias() {
        return incluyeCompetencias;
    }

    public void setIncluyeCompetencias(String incluyeCompetencias) {
        this.incluyeCompetencias = incluyeCompetencias;
    }

    public TipoEvaluacion getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
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
        return "com.infosgroup.planilla.modelo.entidades.Plantilla[ plantillaPK=" + plantillaPK + " ]";
    }
    
}
