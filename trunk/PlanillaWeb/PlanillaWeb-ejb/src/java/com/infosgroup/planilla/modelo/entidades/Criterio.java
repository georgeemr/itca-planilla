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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "criterio")
@NamedQueries({
    @NamedQuery(name = "Criterio.findAll", query = "SELECT c FROM Criterio c"),
    @NamedQuery(name = "Criterio.findByCodCia", query = "SELECT c FROM Criterio c WHERE c.criterioPK.codCia = :codCia"),
    @NamedQuery(name = "Criterio.findByCodCriterio", query = "SELECT c FROM Criterio c WHERE c.criterioPK.codCriterio = :codCriterio"),
    @NamedQuery(name = "Criterio.findByNombre", query = "SELECT c FROM Criterio c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Criterio.findByRango", query = "SELECT c FROM Criterio c WHERE c.rango = :rango"),
    @NamedQuery(name = "Criterio.findByTipo", query = "SELECT c FROM Criterio c WHERE c.tipo = :tipo")})
public class Criterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriterioPK criterioPK;
    @Size(max = 2147483647)
    @Column(name = "nombre", length = 2147483647)
    private String nombre;
    @Column(name = "rango")
    private Integer rango;
    @Column(name = "tipo")
    private Integer tipo;
    @JoinColumn(name = "cod_cia", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criterio1")
    private List<CriteriosXPuesto> criteriosXPuestoList;

    public Criterio() {
    }

    public Criterio(CriterioPK criterioPK) {
        this.criterioPK = criterioPK;
    }

    public Criterio(int codCia, int codCriterio) {
        this.criterioPK = new CriterioPK(codCia, codCriterio);
    }

    public CriterioPK getCriterioPK() {
        return criterioPK;
    }

    public void setCriterioPK(CriterioPK criterioPK) {
        this.criterioPK = criterioPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRango() {
        return rango;
    }

    public void setRango(Integer rango) {
        this.rango = rango;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public List<CriteriosXPuesto> getCriteriosXPuestoList() {
        return criteriosXPuestoList;
    }

    public void setCriteriosXPuestoList(List<CriteriosXPuesto> criteriosXPuestoList) {
        this.criteriosXPuestoList = criteriosXPuestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criterioPK != null ? criterioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterio)) {
            return false;
        }
        Criterio other = (Criterio) object;
        if ((this.criterioPK == null && other.criterioPK != null) || (this.criterioPK != null && !this.criterioPK.equals(other.criterioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Criterio[ criterioPK=" + criterioPK + " ]";
    }
    
}
