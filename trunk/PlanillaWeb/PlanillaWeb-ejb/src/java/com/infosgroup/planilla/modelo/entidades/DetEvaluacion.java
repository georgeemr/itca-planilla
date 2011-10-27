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

/**
 *
 * @author root
 */
@Entity
@Table(name = "det_evaluacion", catalog = "planilla", schema = "public")
@NamedQueries({
    @NamedQuery(name = "DetEvaluacion.findAll", query = "SELECT d FROM DetEvaluacion d"),
    @NamedQuery(name = "DetEvaluacion.findByCodCia", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "DetEvaluacion.findByCodCampania", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCampania = :codCampania"),
    @NamedQuery(name = "DetEvaluacion.findByCodEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codEvaluacion = :codEvaluacion"),
    @NamedQuery(name = "DetEvaluacion.findByCodDetEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codDetEvaluacion = :codDetEvaluacion"),
    @NamedQuery(name = "DetEvaluacion.findByTexto", query = "SELECT d FROM DetEvaluacion d WHERE d.texto = :texto")})
public class DetEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetEvaluacionPK detEvaluacionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "texto", nullable = false, length = 2147483647)
    private String texto;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_tipo_respuesta", referencedColumnName = "cod_tipo_respuesta", nullable = false),
        @JoinColumn(name = "cod_respuesta", referencedColumnName = "cod_respuesta", nullable = false)})
    @ManyToOne(optional = false)
    private Respuesta respuesta;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_factor", referencedColumnName = "cod_factor", nullable = false),
        @JoinColumn(name = "cod_pregunta", referencedColumnName = "cod_pregunta", nullable = false)})
    @ManyToOne(optional = false)
    private Pregunta pregunta;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_campania", referencedColumnName = "cod_campania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_evaluacion", referencedColumnName = "cod_evaluacion", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Evaluacion evaluacion;

    public DetEvaluacion() {
    }

    public DetEvaluacion(DetEvaluacionPK detEvaluacionPK) {
        this.detEvaluacionPK = detEvaluacionPK;
    }

    public DetEvaluacion(DetEvaluacionPK detEvaluacionPK, String texto) {
        this.detEvaluacionPK = detEvaluacionPK;
        this.texto = texto;
    }

    public DetEvaluacion(int codCia, int codCampania, int codEvaluacion, int codDetEvaluacion) {
        this.detEvaluacionPK = new DetEvaluacionPK(codCia, codCampania, codEvaluacion, codDetEvaluacion);
    }

    public DetEvaluacionPK getDetEvaluacionPK() {
        return detEvaluacionPK;
    }

    public void setDetEvaluacionPK(DetEvaluacionPK detEvaluacionPK) {
        this.detEvaluacionPK = detEvaluacionPK;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
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
        return "com.infosgroup.planilla.modelo.entidades.DetEvaluacion[ detEvaluacionPK=" + detEvaluacionPK + " ]";
    }
    
}
