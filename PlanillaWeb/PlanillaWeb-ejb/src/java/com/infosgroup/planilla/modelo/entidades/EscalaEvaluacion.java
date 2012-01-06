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
@Table(name = "ESCALA_EVALUACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscalaEvaluacion.findAll", query = "SELECT e FROM EscalaEvaluacion e"),
    @NamedQuery(name = "EscalaEvaluacion.findByCodCia", query = "SELECT e FROM EscalaEvaluacion e WHERE e.escalaEvaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "EscalaEvaluacion.findByTipoEvaluacion", query = "SELECT e FROM EscalaEvaluacion e WHERE e.escalaEvaluacionPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "EscalaEvaluacion.findByEscala", query = "SELECT e FROM EscalaEvaluacion e WHERE e.escalaEvaluacionPK.escala = :escala"),
    @NamedQuery(name = "EscalaEvaluacion.findByRangoInicial", query = "SELECT e FROM EscalaEvaluacion e WHERE e.rangoInicial = :rangoInicial"),
    @NamedQuery(name = "EscalaEvaluacion.findByRangoFinal", query = "SELECT e FROM EscalaEvaluacion e WHERE e.rangoFinal = :rangoFinal"),
    @NamedQuery(name = "EscalaEvaluacion.findByCalificacion", query = "SELECT e FROM EscalaEvaluacion e WHERE e.calificacion = :calificacion")})
public class EscalaEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscalaEvaluacionPK escalaEvaluacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RANGO_INICIAL", nullable = false)
    private short rangoInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RANGO_FINAL", nullable = false)
    private short rangoFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CALIFICACION", nullable = false, length = 25)
    private String calificacion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_EVALUACION", referencedColumnName = "COD_TIPO_EVALUACION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoEvaluacion tipoEvaluacion1;

    public EscalaEvaluacion() {
    }

    public EscalaEvaluacion(EscalaEvaluacionPK escalaEvaluacionPK) {
        this.escalaEvaluacionPK = escalaEvaluacionPK;
    }

    public EscalaEvaluacion(EscalaEvaluacionPK escalaEvaluacionPK, short rangoInicial, short rangoFinal, String calificacion) {
        this.escalaEvaluacionPK = escalaEvaluacionPK;
        this.rangoInicial = rangoInicial;
        this.rangoFinal = rangoFinal;
        this.calificacion = calificacion;
    }

    public EscalaEvaluacion(long codCia, long tipoEvaluacion, long escala) {
        this.escalaEvaluacionPK = new EscalaEvaluacionPK(codCia, tipoEvaluacion, escala);
    }

    public EscalaEvaluacionPK getEscalaEvaluacionPK() {
        return escalaEvaluacionPK;
    }

    public void setEscalaEvaluacionPK(EscalaEvaluacionPK escalaEvaluacionPK) {
        this.escalaEvaluacionPK = escalaEvaluacionPK;
    }

    public short getRangoInicial() {
        return rangoInicial;
    }

    public void setRangoInicial(short rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    public short getRangoFinal() {
        return rangoFinal;
    }

    public void setRangoFinal(short rangoFinal) {
        this.rangoFinal = rangoFinal;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public TipoEvaluacion getTipoEvaluacion1() {
        return tipoEvaluacion1;
    }

    public void setTipoEvaluacion1(TipoEvaluacion tipoEvaluacion1) {
        this.tipoEvaluacion1 = tipoEvaluacion1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escalaEvaluacionPK != null ? escalaEvaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscalaEvaluacion)) {
            return false;
        }
        EscalaEvaluacion other = (EscalaEvaluacion) object;
        if ((this.escalaEvaluacionPK == null && other.escalaEvaluacionPK != null) || (this.escalaEvaluacionPK != null && !this.escalaEvaluacionPK.equals(other.escalaEvaluacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EscalaEvaluacion[ escalaEvaluacionPK=" + escalaEvaluacionPK + " ]";
    }
    
}
