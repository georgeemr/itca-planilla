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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_EVALUACION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetEvaluacion.findAll", query = "SELECT d FROM DetEvaluacion d"),
    @NamedQuery(name = "DetEvaluacion.findByCodCia", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "DetEvaluacion.findByCodCampania", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCampania = :codCampania"),
    @NamedQuery(name = "DetEvaluacion.findByCodEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codEvaluacion = :codEvaluacion"),
    @NamedQuery(name = "DetEvaluacion.findByCodDetEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codDetEvaluacion = :codDetEvaluacion"),
    @NamedQuery(name = "DetEvaluacion.findByCodFactor", query = "SELECT d FROM DetEvaluacion d WHERE d.codFactor = :codFactor"),
    @NamedQuery(name = "DetEvaluacion.findByCodPregunta", query = "SELECT d FROM DetEvaluacion d WHERE d.codPregunta = :codPregunta"),
    @NamedQuery(name = "DetEvaluacion.findByCodRespuesta", query = "SELECT d FROM DetEvaluacion d WHERE d.codRespuesta = :codRespuesta"),
    @NamedQuery(name = "DetEvaluacion.findByTexto", query = "SELECT d FROM DetEvaluacion d WHERE d.texto = :texto")})
public class DetEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetEvaluacionPK detEvaluacionPK;
    @Basic(optional = false)
    @Column(name = "COD_FACTOR", nullable = false)
    private short codFactor;
    @Basic(optional = false)
    @Column(name = "COD_PREGUNTA", nullable = false, length = 1)
    private String codPregunta;
    @Basic(optional = false)
    @Column(name = "COD_RESPUESTA", nullable = false)
    private short codRespuesta;
    @Basic(optional = false)
    @Column(name = "TEXTO", nullable = false, length = 300)
    private String texto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAMPANIA", referencedColumnName = "COD_CAMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EVALUACION", referencedColumnName = "COD_EVALUACION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Evaluacion evaluacion;

    public DetEvaluacion() {
    }

    public DetEvaluacion(DetEvaluacionPK detEvaluacionPK) {
        this.detEvaluacionPK = detEvaluacionPK;
    }

    public DetEvaluacion(DetEvaluacionPK detEvaluacionPK, short codFactor, String codPregunta, short codRespuesta, String texto) {
        this.detEvaluacionPK = detEvaluacionPK;
        this.codFactor = codFactor;
        this.codPregunta = codPregunta;
        this.codRespuesta = codRespuesta;
        this.texto = texto;
    }

    public DetEvaluacion(short codCia, short codCampania, short codEvaluacion, short codDetEvaluacion) {
        this.detEvaluacionPK = new DetEvaluacionPK(codCia, codCampania, codEvaluacion, codDetEvaluacion);
    }

    public DetEvaluacionPK getDetEvaluacionPK() {
        return detEvaluacionPK;
    }

    public void setDetEvaluacionPK(DetEvaluacionPK detEvaluacionPK) {
        this.detEvaluacionPK = detEvaluacionPK;
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

    public short getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(short codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detEvaluacionPK != null ? detEvaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetEvaluacion)) {
            return false;
        }
        DetEvaluacion other = (DetEvaluacion) object;
        if ((this.detEvaluacionPK == null && other.detEvaluacionPK != null) || (this.detEvaluacionPK != null && !this.detEvaluacionPK.equals(other.detEvaluacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetEvaluacion[ detEvaluacionPK=" + detEvaluacionPK + " ]";
    }
    
}
