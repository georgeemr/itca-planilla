/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_PLANTILLA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetPlantilla.findAll", query = "SELECT d FROM DetPlantilla d"),
    @NamedQuery(name = "DetPlantilla.findByCodCia", query = "SELECT d FROM DetPlantilla d WHERE d.detPlantillaPK.codCia = :codCia"),
    @NamedQuery(name = "DetPlantilla.findByCodTipoEvaluacion", query = "SELECT d FROM DetPlantilla d WHERE d.detPlantillaPK.codTipoEvaluacion = :codTipoEvaluacion"),
    @NamedQuery(name = "DetPlantilla.findByPeriodo", query = "SELECT d FROM DetPlantilla d WHERE d.detPlantillaPK.periodo = :periodo"),
    @NamedQuery(name = "DetPlantilla.findByCodPlantilla", query = "SELECT d FROM DetPlantilla d WHERE d.detPlantillaPK.codPlantilla = :codPlantilla"),
    @NamedQuery(name = "DetPlantilla.findByCodDetPlantilla", query = "SELECT d FROM DetPlantilla d WHERE d.detPlantillaPK.codDetPlantilla = :codDetPlantilla"),
    @NamedQuery(name = "DetPlantilla.findByCodFactor", query = "SELECT d FROM DetPlantilla d WHERE d.codFactor = :codFactor"),
    @NamedQuery(name = "DetPlantilla.findByCodPregunta", query = "SELECT d FROM DetPlantilla d WHERE d.codPregunta = :codPregunta")})
public class DetPlantilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetPlantillaPK detPlantillaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_FACTOR", nullable = false)
    private short codFactor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "COD_PREGUNTA", nullable = false, length = 1)
    private String codPregunta;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_EVALUACION", referencedColumnName = "COD_TIPO_EVALUACION", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PLANTILLA", referencedColumnName = "COD_PLANTILLA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Plantilla plantilla;

    public DetPlantilla() {
    }

    public DetPlantilla(DetPlantillaPK detPlantillaPK) {
        this.detPlantillaPK = detPlantillaPK;
    }

    public DetPlantilla(DetPlantillaPK detPlantillaPK, short codFactor, String codPregunta) {
        this.detPlantillaPK = detPlantillaPK;
        this.codFactor = codFactor;
        this.codPregunta = codPregunta;
    }

    public DetPlantilla(short codCia, short codTipoEvaluacion, int periodo, short codPlantilla, short codDetPlantilla) {
        this.detPlantillaPK = new DetPlantillaPK(codCia, codTipoEvaluacion, periodo, codPlantilla, codDetPlantilla);
    }

    public DetPlantillaPK getDetPlantillaPK() {
        return detPlantillaPK;
    }

    public void setDetPlantillaPK(DetPlantillaPK detPlantillaPK) {
        this.detPlantillaPK = detPlantillaPK;
    }

    public short getCodFactor() {
        return codFactor;
    }

    public void setCodFactor(short codFactor) {
        this.codFactor = codFactor;
    }

    public String getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(String codPregunta) {
        this.codPregunta = codPregunta;
    }

    public Plantilla getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(Plantilla plantilla) {
        this.plantilla = plantilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detPlantillaPK != null ? detPlantillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetPlantilla)) {
            return false;
        }
        DetPlantilla other = (DetPlantilla) object;
        if ((this.detPlantillaPK == null && other.detPlantillaPK != null) || (this.detPlantillaPK != null && !this.detPlantillaPK.equals(other.detPlantillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DetPlantilla[ detPlantillaPK=" + detPlantillaPK + " ]";
    }
    
}
