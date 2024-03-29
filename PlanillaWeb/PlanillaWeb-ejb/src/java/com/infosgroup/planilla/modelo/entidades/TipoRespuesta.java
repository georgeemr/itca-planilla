/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_RESPUESTA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRespuesta.findAll", query = "SELECT t FROM TipoRespuesta t"),
    @NamedQuery(name = "TipoRespuesta.findByCodCia", query = "SELECT t FROM TipoRespuesta t WHERE t.tipoRespuestaPK.codCia = :codCia"),
    @NamedQuery(name = "TipoRespuesta.findByCodTipoRespuesta", query = "SELECT t FROM TipoRespuesta t WHERE t.tipoRespuestaPK.codTipoRespuesta = :codTipoRespuesta"),
    @NamedQuery(name = "TipoRespuesta.findByNomTipoRespuesta", query = "SELECT t FROM TipoRespuesta t WHERE t.nomTipoRespuesta = :nomTipoRespuesta")})
public class TipoRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoRespuestaPK tipoRespuestaPK;
    @Basic(optional = false)
    @Column(name = "NOM_TIPO_RESPUESTA", nullable = false, length = 300)
    private String nomTipoRespuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRespuesta")
    private List<Respuesta> respuestaList;

    public TipoRespuesta() {
    }

    public TipoRespuesta(TipoRespuestaPK tipoRespuestaPK) {
        this.tipoRespuestaPK = tipoRespuestaPK;
    }

    public TipoRespuesta(TipoRespuestaPK tipoRespuestaPK, String nomTipoRespuesta) {
        this.tipoRespuestaPK = tipoRespuestaPK;
        this.nomTipoRespuesta = nomTipoRespuesta;
    }

    public TipoRespuesta(short codCia, short codTipoRespuesta) {
        this.tipoRespuestaPK = new TipoRespuestaPK(codCia, codTipoRespuesta);
    }

    public TipoRespuestaPK getTipoRespuestaPK() {
        return tipoRespuestaPK;
    }

    public void setTipoRespuestaPK(TipoRespuestaPK tipoRespuestaPK) {
        this.tipoRespuestaPK = tipoRespuestaPK;
    }

    public String getNomTipoRespuesta() {
        return nomTipoRespuesta;
    }

    public void setNomTipoRespuesta(String nomTipoRespuesta) {
        this.nomTipoRespuesta = nomTipoRespuesta;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoRespuestaPK != null ? tipoRespuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRespuesta)) {
            return false;
        }
        TipoRespuesta other = (TipoRespuesta) object;
        if ((this.tipoRespuestaPK == null && other.tipoRespuestaPK != null) || (this.tipoRespuestaPK != null && !this.tipoRespuestaPK.equals(other.tipoRespuestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoRespuesta[ tipoRespuestaPK=" + tipoRespuestaPK + " ]";
    }
    
}
