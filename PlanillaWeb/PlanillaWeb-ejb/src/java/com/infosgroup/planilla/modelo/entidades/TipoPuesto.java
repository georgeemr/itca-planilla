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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "tipo_puesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPuesto.findAll", query = "SELECT t FROM TipoPuesto t"),
    @NamedQuery(name = "TipoPuesto.findByIdTipoPuesto", query = "SELECT t FROM TipoPuesto t WHERE t.idTipoPuesto = :idTipoPuesto"),
    @NamedQuery(name = "TipoPuesto.findByNomTipoPuesto", query = "SELECT t FROM TipoPuesto t WHERE t.nomTipoPuesto = :nomTipoPuesto"),
    @NamedQuery(name = "TipoPuesto.findByDetTipoPuesto", query = "SELECT t FROM TipoPuesto t WHERE t.detTipoPuesto = :detTipoPuesto")})
public class TipoPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_puesto", nullable = false)
    private Integer idTipoPuesto;
    @Size(max = 100)
    @Column(name = "nom_tipo_puesto", length = 100)
    private String nomTipoPuesto;
    @Size(max = 400)
    @Column(name = "det_tipo_puesto", length = 400)
    private String detTipoPuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPuesto", fetch = FetchType.EAGER)
    private List<Puesto> puestoList;

    public TipoPuesto() {
    }

    public TipoPuesto(Integer idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    public Integer getIdTipoPuesto() {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(Integer idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    public String getNomTipoPuesto() {
        return nomTipoPuesto;
    }

    public void setNomTipoPuesto(String nomTipoPuesto) {
        this.nomTipoPuesto = nomTipoPuesto;
    }

    public String getDetTipoPuesto() {
        return detTipoPuesto;
    }

    public void setDetTipoPuesto(String detTipoPuesto) {
        this.detTipoPuesto = detTipoPuesto;
    }

    @XmlTransient
    public List<Puesto> getPuestoList() {
        return puestoList;
    }

    public void setPuestoList(List<Puesto> puestoList) {
        this.puestoList = puestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPuesto != null ? idTipoPuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPuesto)) {
            return false;
        }
        TipoPuesto other = (TipoPuesto) object;
        if ((this.idTipoPuesto == null && other.idTipoPuesto != null) || (this.idTipoPuesto != null && !this.idTipoPuesto.equals(other.idTipoPuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoPuesto[ idTipoPuesto=" + idTipoPuesto + " ]";
    }
    
}
