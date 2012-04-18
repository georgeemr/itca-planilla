/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_EVALUACION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvaluacion.findAll", query = "SELECT t FROM TipoEvaluacion t"),
    @NamedQuery(name = "TipoEvaluacion.findByCodCia", query = "SELECT t FROM TipoEvaluacion t WHERE t.tipoEvaluacionPK.codCia = :codCia"),
    @NamedQuery(name = "TipoEvaluacion.findByCodTipoEvaluacion", query = "SELECT t FROM TipoEvaluacion t WHERE t.tipoEvaluacionPK.codTipoEvaluacion = :codTipoEvaluacion"),
    @NamedQuery(name = "TipoEvaluacion.findByNomTipoEvaluacion", query = "SELECT t FROM TipoEvaluacion t WHERE t.nomTipoEvaluacion = :nomTipoEvaluacion")
})
public class TipoEvaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoEvaluacionPK tipoEvaluacionPK;
    @Basic(optional = false)
    @Column(name = "NOM_TIPO_EVALUACION", nullable = false, length = 100)
    private String nomTipoEvaluacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEvaluacion1")
    private List<Evaluacion> evaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEvaluacion")
    private List<Plantilla> plantillaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEvaluacion1")
    private List<PreEvaluacion> preEvaluacionList;

    @Transient
    private String seleccionado = "N";

    public String getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(String seleccionado) {
        this.seleccionado = seleccionado;
    }
            
    public TipoEvaluacion() {
    }

    public TipoEvaluacion(TipoEvaluacionPK tipoEvaluacionPK) {
        this.tipoEvaluacionPK = tipoEvaluacionPK;
    }

    public TipoEvaluacion(TipoEvaluacionPK tipoEvaluacionPK, String nomTipoEvaluacion) {
        this.tipoEvaluacionPK = tipoEvaluacionPK;
        this.nomTipoEvaluacion = nomTipoEvaluacion;
    }

    public TipoEvaluacion(short codCia, short codTipoEvaluacion) {
        this.tipoEvaluacionPK = new TipoEvaluacionPK(codCia, codTipoEvaluacion);
    }

    public TipoEvaluacionPK getTipoEvaluacionPK() {
        return tipoEvaluacionPK;
    }

    public void setTipoEvaluacionPK(TipoEvaluacionPK tipoEvaluacionPK) {
        this.tipoEvaluacionPK = tipoEvaluacionPK;
    }

    public String getNomTipoEvaluacion() {
        return nomTipoEvaluacion;
    }

    public void setNomTipoEvaluacion(String nomTipoEvaluacion) {
        this.nomTipoEvaluacion = nomTipoEvaluacion;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @XmlTransient
    public List<Plantilla> getPlantillaList() {
        return plantillaList;
    }

    public void setPlantillaList(List<Plantilla> plantillaList) {
        this.plantillaList = plantillaList;
    }

    @XmlTransient
    public List<PreEvaluacion> getPreEvaluacionList() {
        return preEvaluacionList;
    }

    public void setPreEvaluacionList(List<PreEvaluacion> preEvaluacionList) {
        this.preEvaluacionList = preEvaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoEvaluacionPK != null ? tipoEvaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvaluacion)) {
            return false;
        }
        TipoEvaluacion other = (TipoEvaluacion) object;
        if ((this.tipoEvaluacionPK == null && other.tipoEvaluacionPK != null) || (this.tipoEvaluacionPK != null && !this.tipoEvaluacionPK.equals(other.tipoEvaluacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoEvaluacion[ tipoEvaluacionPK=" + tipoEvaluacionPK + " ]";
    }
}
