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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PREGUNTA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByCodCia", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.codCia = :codCia"),
    @NamedQuery(name = "Pregunta.findByCodFactor", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.codFactor = :codFactor"),
    @NamedQuery(name = "Pregunta.findByCodPregunta", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.codPregunta = :codPregunta"),
    @NamedQuery(name = "Pregunta.findByDescripcion", query = "SELECT p FROM Pregunta p WHERE p.descripcion = :descripcion")})
public class Pregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreguntaPK preguntaPK;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 300)
    private String descripcion;

    public Pregunta() {
    }

    public Pregunta(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public Pregunta(PreguntaPK preguntaPK, String descripcion) {
        this.preguntaPK = preguntaPK;
        this.descripcion = descripcion;
    }

    public Pregunta(short codCia, short codFactor, String codPregunta) {
        this.preguntaPK = new PreguntaPK(codCia, codFactor, codPregunta);
    }

    public PreguntaPK getPreguntaPK() {
        return preguntaPK;
    }

    public void setPreguntaPK(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preguntaPK != null ? preguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preguntaPK == null && other.preguntaPK != null) || (this.preguntaPK != null && !this.preguntaPK.equals(other.preguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Pregunta[ preguntaPK=" + preguntaPK + " ]";
    }
    
}
