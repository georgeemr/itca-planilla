/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EVALUACION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByCodCia", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "Evaluacion.findByCodCampania", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.codCampania = :codCampania"),
    @NamedQuery(name = "Evaluacion.findByCodEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.evaluacionPK.codEvaluacion = :codEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByCodEmp", query = "SELECT e FROM Evaluacion e WHERE e.codEmp = :codEmp"),
    @NamedQuery(name = "Evaluacion.findByFecha", query = "SELECT e FROM Evaluacion e WHERE e.fecha = :fecha")})
public class Evaluacion implements Serializable {
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_EVALUACION", referencedColumnName = "COD_TIPO_EVALUACION", nullable = false)})
    @ManyToOne(optional = false)
    private TipoEvaluacion tipoEvaluacion;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluacionPK evaluacionPK;
    @Basic(optional = false)
    @Column(name = "COD_EMP", nullable = false)
    private short codEmp;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_EVALUACION", referencedColumnName = "COD_TIPO_EVALUACION", nullable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false),
        @JoinColumn(name = "COD_PLANTILLA", referencedColumnName = "COD_PLANTILLA", nullable = false)})
    @ManyToOne(optional = false)
    private Plantilla plantilla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion")
    private List<DetEvaluacion> detEvaluacionList;

    public Evaluacion() {
    }

    public Evaluacion(EvaluacionPK evaluacionPK) {
        this.evaluacionPK = evaluacionPK;
    }

    public Evaluacion(EvaluacionPK evaluacionPK, short codEmp, Date fecha) {
        this.evaluacionPK = evaluacionPK;
        this.codEmp = codEmp;
        this.fecha = fecha;
    }

    public Evaluacion(short codCia, short codCampania, short codEvaluacion) {
        this.evaluacionPK = new EvaluacionPK(codCia, codCampania, codEvaluacion);
    }

    public EvaluacionPK getEvaluacionPK() {
        return evaluacionPK;
    }

    public void setEvaluacionPK(EvaluacionPK evaluacionPK) {
        this.evaluacionPK = evaluacionPK;
    }

    public short getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(short codEmp) {
        this.codEmp = codEmp;
    }

    public Plantilla getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(Plantilla plantilla) {
        this.plantilla = plantilla;
    }

    @XmlTransient
    public List<DetEvaluacion> getDetEvaluacionList() {
        return detEvaluacionList;
    }

    public void setDetEvaluacionList(List<DetEvaluacion> detEvaluacionList) {
        this.detEvaluacionList = detEvaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacionPK != null ? evaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.evaluacionPK == null && other.evaluacionPK != null) || (this.evaluacionPK != null && !this.evaluacionPK.equals(other.evaluacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Evaluacion[ evaluacionPK=" + evaluacionPK + " ]";
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoEvaluacion getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }
    
}
