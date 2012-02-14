/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_ACTIVIDAD", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActividad.findAll", query = "SELECT t FROM TipoActividad t"),
    @NamedQuery(name = "TipoActividad.findByCodCia", query = "SELECT t FROM TipoActividad t WHERE t.tipoActividadPK.codCia = :codCia"),
    @NamedQuery(name = "TipoActividad.findByTipoActividad", query = "SELECT t FROM TipoActividad t WHERE t.tipoActividadPK.tipoActividad = :tipoActividad"),
    @NamedQuery(name = "TipoActividad.findByDescripcion", query = "SELECT t FROM TipoActividad t WHERE t.descripcion = :descripcion")})
public class TipoActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoActividadPK tipoActividadPK;
    @Size(max = 200)
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoActividad")
    private List<PrograCampania> prograCampaniaList;

    public TipoActividad() {
    }

    public TipoActividad(TipoActividadPK tipoActividadPK) {
        this.tipoActividadPK = tipoActividadPK;
    }

    public TipoActividad(short codCia, long tipoActividad) {
        this.tipoActividadPK = new TipoActividadPK(codCia, tipoActividad);
    }

    public TipoActividadPK getTipoActividadPK() {
        return tipoActividadPK;
    }

    public void setTipoActividadPK(TipoActividadPK tipoActividadPK) {
        this.tipoActividadPK = tipoActividadPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<PrograCampania> getPrograCampaniaList() {
        return prograCampaniaList;
    }

    public void setPrograCampaniaList(List<PrograCampania> prograCampaniaList) {
        this.prograCampaniaList = prograCampaniaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoActividadPK != null ? tipoActividadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividad)) {
            return false;
        }
        TipoActividad other = (TipoActividad) object;
        if ((this.tipoActividadPK == null && other.tipoActividadPK != null) || (this.tipoActividadPK != null && !this.tipoActividadPK.equals(other.tipoActividadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoActividad[ tipoActividadPK=" + tipoActividadPK + " ]";
    }
    
}
