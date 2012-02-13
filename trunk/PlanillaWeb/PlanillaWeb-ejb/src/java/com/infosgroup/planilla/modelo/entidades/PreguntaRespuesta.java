/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PREGUNTA_RESPUESTA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaRespuesta.findAll", query = "SELECT p FROM PreguntaRespuesta p"),
    @NamedQuery(name = "PreguntaRespuesta.findByCodCia", query = "SELECT p FROM PreguntaRespuesta p WHERE p.preguntaRespuestaPK.codCia = :codCia"),
    @NamedQuery(name = "PreguntaRespuesta.findByCodFactor", query = "SELECT p FROM PreguntaRespuesta p WHERE p.preguntaRespuestaPK.codFactor = :codFactor"),
    @NamedQuery(name = "PreguntaRespuesta.findByCodPregunta", query = "SELECT p FROM PreguntaRespuesta p WHERE p.preguntaRespuestaPK.codPregunta = :codPregunta"),
    @NamedQuery(name = "PreguntaRespuesta.findByCodTipoRespuesta", query = "SELECT p FROM PreguntaRespuesta p WHERE p.preguntaRespuestaPK.codTipoRespuesta = :codTipoRespuesta"),
    @NamedQuery(name = "PreguntaRespuesta.findByCodRespuesta", query = "SELECT p FROM PreguntaRespuesta p WHERE p.preguntaRespuestaPK.codRespuesta = :codRespuesta")})
public class PreguntaRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreguntaRespuestaPK preguntaRespuestaPK;

    public PreguntaRespuesta() {
    }

    public PreguntaRespuesta(PreguntaRespuestaPK preguntaRespuestaPK) {
        this.preguntaRespuestaPK = preguntaRespuestaPK;
    }

    public PreguntaRespuesta(short codCia, short codFactor, String codPregunta, short codTipoRespuesta, short codRespuesta) {
        this.preguntaRespuestaPK = new PreguntaRespuestaPK(codCia, codFactor, codPregunta, codTipoRespuesta, codRespuesta);
    }

    public PreguntaRespuestaPK getPreguntaRespuestaPK() {
        return preguntaRespuestaPK;
    }

    public void setPreguntaRespuestaPK(PreguntaRespuestaPK preguntaRespuestaPK) {
        this.preguntaRespuestaPK = preguntaRespuestaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preguntaRespuestaPK != null ? preguntaRespuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaRespuesta)) {
            return false;
        }
        PreguntaRespuesta other = (PreguntaRespuesta) object;
        if ((this.preguntaRespuestaPK == null && other.preguntaRespuestaPK != null) || (this.preguntaRespuestaPK != null && !this.preguntaRespuestaPK.equals(other.preguntaRespuestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PreguntaRespuesta[ preguntaRespuestaPK=" + preguntaRespuestaPK + " ]";
    }
    
}
