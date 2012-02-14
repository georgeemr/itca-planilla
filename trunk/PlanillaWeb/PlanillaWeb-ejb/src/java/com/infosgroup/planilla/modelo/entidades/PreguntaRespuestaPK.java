/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Embeddable
public class PreguntaRespuestaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_FACTOR", nullable = false)
    private short codFactor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "COD_PREGUNTA", nullable = false, length = 1)
    private String codPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_RESPUESTA", nullable = false)
    private short codTipoRespuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_RESPUESTA", nullable = false)
    private short codRespuesta;

    public PreguntaRespuestaPK() {
    }

    public PreguntaRespuestaPK(short codCia, short codFactor, String codPregunta, short codTipoRespuesta, short codRespuesta) {
        this.codCia = codCia;
        this.codFactor = codFactor;
        this.codPregunta = codPregunta;
        this.codTipoRespuesta = codTipoRespuesta;
        this.codRespuesta = codRespuesta;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
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

    public short getCodTipoRespuesta() {
        return codTipoRespuesta;
    }

    public void setCodTipoRespuesta(short codTipoRespuesta) {
        this.codTipoRespuesta = codTipoRespuesta;
    }

    public short getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(short codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codFactor;
        hash += (codPregunta != null ? codPregunta.hashCode() : 0);
        hash += (int) codTipoRespuesta;
        hash += (int) codRespuesta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaRespuestaPK)) {
            return false;
        }
        PreguntaRespuestaPK other = (PreguntaRespuestaPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codFactor != other.codFactor) {
            return false;
        }
        if ((this.codPregunta == null && other.codPregunta != null) || (this.codPregunta != null && !this.codPregunta.equals(other.codPregunta))) {
            return false;
        }
        if (this.codTipoRespuesta != other.codTipoRespuesta) {
            return false;
        }
        if (this.codRespuesta != other.codRespuesta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.PreguntaRespuestaPK[ codCia=" + codCia + ", codFactor=" + codFactor + ", codPregunta=" + codPregunta + ", codTipoRespuesta=" + codTipoRespuesta + ", codRespuesta=" + codRespuesta + " ]";
    }
    
}
