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

/**
 *
 * @author root
 */
@Entity
@Table(name = "tipo_puesto")
@NamedQueries({
    @NamedQuery(name = "TipoPuesto.findAll", query = "SELECT t FROM TipoPuesto t"),
    @NamedQuery(name = "TipoPuesto.findByCodCia", query = "SELECT t FROM TipoPuesto t WHERE t.tipoPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "TipoPuesto.findByCodTipoPuesto", query = "SELECT t FROM TipoPuesto t WHERE t.tipoPuestoPK.codTipoPuesto = :codTipoPuesto"),
    @NamedQuery(name = "TipoPuesto.findByNombre", query = "SELECT t FROM TipoPuesto t WHERE t.nombre = :nombre")})
public class TipoPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoPuestoPK tipoPuestoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPuesto")
    private List<Puesto> puestoList;
    @JoinColumn(name = "cod_cia", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public TipoPuesto() {
    }

    public TipoPuesto(TipoPuestoPK tipoPuestoPK) {
        this.tipoPuestoPK = tipoPuestoPK;
    }

    public TipoPuesto(TipoPuestoPK tipoPuestoPK, String nombre) {
        this.tipoPuestoPK = tipoPuestoPK;
        this.nombre = nombre;
    }

    public TipoPuesto(int codCia, int codTipoPuesto) {
        this.tipoPuestoPK = new TipoPuestoPK(codCia, codTipoPuesto);
    }

    public TipoPuestoPK getTipoPuestoPK() {
        return tipoPuestoPK;
    }

    public void setTipoPuestoPK(TipoPuestoPK tipoPuestoPK) {
        this.tipoPuestoPK = tipoPuestoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Puesto> getPuestoList() {
        return puestoList;
    }

    public void setPuestoList(List<Puesto> puestoList) {
        this.puestoList = puestoList;
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
        hash += (tipoPuestoPK != null ? tipoPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPuesto)) {
            return false;
        }
        TipoPuesto other = (TipoPuesto) object;
        if ((this.tipoPuestoPK == null && other.tipoPuestoPK != null) || (this.tipoPuestoPK != null && !this.tipoPuestoPK.equals(other.tipoPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoPuesto[ tipoPuestoPK=" + tipoPuestoPK + " ]";
    }
    
}
