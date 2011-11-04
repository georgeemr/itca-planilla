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
@Table(name = "det_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetEvaluacion.findAll", query = "SELECT d FROM DetEvaluacion d"),
    @NamedQuery(name = "DetEvaluacion.findByCodCia", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "DetEvaluacion.findByCodCampania", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codCampania = :codCampania"),
    @NamedQuery(name = "DetEvaluacion.findByCodEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codEvaluacion = :codEvaluacion"),
    @NamedQuery(name = "DetEvaluacion.findByCodDetEvaluacion", query = "SELECT d FROM DetEvaluacion d WHERE d.detEvaluacionPK.codDetEvaluacion = :codDetEvaluacion"),
    @NamedQuery(name = "DetEvaluacion.findByCodRespuesta", query = "SELECT d FROM DetEvaluacion d WHERE d.codRespuesta = :codRespuesta"),
    @NamedQuery(name = "DetEvaluacion.findByCodTipoRespuesta", query = "SELECT d FROM DetEvaluacion d WHERE d.codTipoRespuesta = :codTipoRespuesta"),
    @NamedQuery(name = "DetEvaluacion.findByTexto", query = "SELECT d FROM DetEvaluacion d WHERE d.texto = :texto")})
public class DetEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetEvaluacionPK detEvaluacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_respuesta", nullable = false)
    private int codRespuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo_respuesta", nullable = false)
    private int codTipoRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "texto", nullable = false, length = 2147483647)
    private String texto;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_factor", referencedColumnName = "cod_factor", nullable = false),
        @JoinColumn(name = "cod_pregunta", referencedColumnName = "cod_pregunta", nullable = false)})
    @ManyToOne(optional = false)
    private Pregunta pregunta;

    public DetEvaluacion() {
    }

    public DetEvaluacion(DetEvaluacionPK detEvaluacionPK) {
        this.detEvaluacionPK = detEvaluacionPK;
    }

    public DetEvaluacion(DetEvaluacionPK detEvaluacionPK, int codRespuesta, int codTipoRespuesta, String texto) {
        this.detEvaluacionPK = detEvaluacionPK;
        this.codRespuesta = codRespuesta;
        this.codTipoRespuesta = codTipoRespuesta;
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

    public int getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(int codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public int getCodTipoRespuesta() {
        return codTipoRespuesta;
    }

    public void setCodTipoRespuesta(int codTipoRespuesta) {
        this.codTipoRespuesta = codTipoRespuesta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
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
