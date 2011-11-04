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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tipo_respuesta")
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
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nom_tipo_respuesta", nullable = false, length = 2147483647)
    private String nomTipoRespuesta;
    @JoinColumn(name = "cod_cia", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;
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

    public TipoRespuesta(int codCia, int codTipoRespuesta) {
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

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
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
        return "com.infosgroup.planilla.modelo.entidades.TipoRespuesta[ tipoRespuestaPK=" + tipoRespuestaPK + " ]";
    }
    
}
