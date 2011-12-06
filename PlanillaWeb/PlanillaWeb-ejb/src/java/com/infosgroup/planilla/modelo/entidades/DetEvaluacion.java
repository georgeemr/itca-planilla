/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "det_evaluacion")
@NamedQueries({
    @NamedQuery(name = "DetEvaluacion.findAll", query = "SELECT d FROM DetEvaluacion d"),
    @NamedQuery(name = "DetEvaluacion.findByCodCia", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "DetEvaluacion.findByPeriodo", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.periodo = :periodo"),
    @NamedQuery(name = "DetEvaluacion.findByCodCampania", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCampania = :codCampania"),
    @NamedQuery(name = "DetEvaluacion.findByEmpleado", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.empleado = :empleado"),
    @NamedQuery(name = "DetEvaluacion.findByTipoEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "DetEvaluacion.findByCodDetEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codDetEvaluacion = :codDetEvaluacion")})
public class DetEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetEvaluacionPK detEvaluacionPK;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_tipo_respuesta", referencedColumnName = "cod_tipo_respuesta", nullable = false),
        @JoinColumn(name = "grupo_respuesta", referencedColumnName = "grupo_respuesta", nullable = false),
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
        @JoinColumn(name = "periodo", referencedColumnName = "periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_campania", referencedColumnName = "cod_campania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "empleado", referencedColumnName = "empleado", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "tipo_evaluacion", referencedColumnName = "tipo_evaluacion", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Evaluacion evaluacion;

    public DetEvaluacion() {
    }

    public DetEvaluacion(DetEvaluacionPK detEvaluacionPK) {
        this.detEvaluacionPK = detEvaluacionPK;
    }

    public DetEvaluacion(int codCia, int periodo, int codCampania, int empleado, int tipoEvaluacion, int codDetEvaluacion) {
        this.detEvaluacionPK = new DetEvaluacionPK(codCia, periodo, codCampania, empleado, tipoEvaluacion, codDetEvaluacion);
    }

    public DetEvaluacionPK getDetEvaluacionPK() {
        return detEvaluacionPK;
    }

    public void setDetEvaluacionPK(DetEvaluacionPK detEvaluacionPK) {
        this.detEvaluacionPK = detEvaluacionPK;
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
