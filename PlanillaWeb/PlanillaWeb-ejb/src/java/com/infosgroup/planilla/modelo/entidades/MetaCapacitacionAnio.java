/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "META_CAPACITACION_ANIO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetaCapacitacionAnio.findAll", query = "SELECT m FROM MetaCapacitacionAnio m"),
    @NamedQuery(name = "MetaCapacitacionAnio.findByCodCia", query = "SELECT m FROM MetaCapacitacionAnio m WHERE m.metaCapacitacionAnioPK.codCia = :codCia"),
    @NamedQuery(name = "MetaCapacitacionAnio.findByPeriodo", query = "SELECT m FROM MetaCapacitacionAnio m WHERE m.metaCapacitacionAnioPK.periodo = :periodo"),
    @NamedQuery(name = "MetaCapacitacionAnio.findByObservaciones", query = "SELECT m FROM MetaCapacitacionAnio m WHERE m.observaciones = :observaciones"),
    @NamedQuery(name = "MetaCapacitacionAnio.findByCantHoras", query = "SELECT m FROM MetaCapacitacionAnio m WHERE m.cantHoras = :cantHoras")})
public class MetaCapacitacionAnio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MetaCapacitacionAnioPK metaCapacitacionAnioPK;
    @Column(name = "OBSERVACIONES", length = 200)
    private String observaciones;
    @Column(name = "CANT_HORAS")
    private Integer cantHoras;

    public MetaCapacitacionAnio() {
    }

    public MetaCapacitacionAnio(MetaCapacitacionAnioPK metaCapacitacionAnioPK) {
        this.metaCapacitacionAnioPK = metaCapacitacionAnioPK;
    }

    public MetaCapacitacionAnio(short codCia, short periodo) {
        this.metaCapacitacionAnioPK = new MetaCapacitacionAnioPK(codCia, periodo);
    }

    public MetaCapacitacionAnioPK getMetaCapacitacionAnioPK() {
        return metaCapacitacionAnioPK;
    }

    public void setMetaCapacitacionAnioPK(MetaCapacitacionAnioPK metaCapacitacionAnioPK) {
        this.metaCapacitacionAnioPK = metaCapacitacionAnioPK;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(Integer cantHoras) {
        this.cantHoras = cantHoras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metaCapacitacionAnioPK != null ? metaCapacitacionAnioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetaCapacitacionAnio)) {
            return false;
        }
        MetaCapacitacionAnio other = (MetaCapacitacionAnio) object;
        if ((this.metaCapacitacionAnioPK == null && other.metaCapacitacionAnioPK != null) || (this.metaCapacitacionAnioPK != null && !this.metaCapacitacionAnioPK.equals(other.metaCapacitacionAnioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.MetaCapacitacionAnio[ metaCapacitacionAnioPK=" + metaCapacitacionAnioPK + " ]";
    }
    
}
