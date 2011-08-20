/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tipo_planilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPlanilla.findAll", query = "SELECT t FROM TipoPlanilla t"),
    @NamedQuery(name = "TipoPlanilla.findByIdCompania", query = "SELECT t FROM TipoPlanilla t WHERE t.tipoPlanillaPK.idCompania = :idCompania"),
    @NamedQuery(name = "TipoPlanilla.findByIdTipoPlanilla", query = "SELECT t FROM TipoPlanilla t WHERE t.tipoPlanillaPK.idTipoPlanilla = :idTipoPlanilla"),
    @NamedQuery(name = "TipoPlanilla.findByNomTipoPlanilla", query = "SELECT t FROM TipoPlanilla t WHERE t.nomTipoPlanilla = :nomTipoPlanilla")})
public class TipoPlanilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoPlanillaPK tipoPlanillaPK;
    @Size(max = 100)
    @Column(name = "nom_tipo_planilla", length = 100)
    private String nomTipoPlanilla;
    @ManyToMany(mappedBy = "tipoPlanillaList", fetch = FetchType.EAGER)
    private List<Empleado> empleadoList;
    @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compania compania;

    public TipoPlanilla() {
    }

    public TipoPlanilla(TipoPlanillaPK tipoPlanillaPK) {
        this.tipoPlanillaPK = tipoPlanillaPK;
    }

    public TipoPlanilla(int idCompania, int idTipoPlanilla) {
        this.tipoPlanillaPK = new TipoPlanillaPK(idCompania, idTipoPlanilla);
    }

    public TipoPlanillaPK getTipoPlanillaPK() {
        return tipoPlanillaPK;
    }

    public void setTipoPlanillaPK(TipoPlanillaPK tipoPlanillaPK) {
        this.tipoPlanillaPK = tipoPlanillaPK;
    }

    public String getNomTipoPlanilla() {
        return nomTipoPlanilla;
    }

    public void setNomTipoPlanilla(String nomTipoPlanilla) {
        this.nomTipoPlanilla = nomTipoPlanilla;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPlanillaPK != null ? tipoPlanillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlanilla)) {
            return false;
        }
        TipoPlanilla other = (TipoPlanilla) object;
        if ((this.tipoPlanillaPK == null && other.tipoPlanillaPK != null) || (this.tipoPlanillaPK != null && !this.tipoPlanillaPK.equals(other.tipoPlanillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoPlanilla[ tipoPlanillaPK=" + tipoPlanillaPK + " ]";
    }
    
}
