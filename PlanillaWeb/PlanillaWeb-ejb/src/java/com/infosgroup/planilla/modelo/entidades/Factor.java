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
@Table(name = "factor")
@NamedQueries({
    @NamedQuery(name = "Factor.findAll", query = "SELECT f FROM Factor f"),
    @NamedQuery(name = "Factor.findByCodCia", query = "SELECT f FROM Factor f WHERE f.factorPK.codCia = :codCia"),
    @NamedQuery(name = "Factor.findByCodFactor", query = "SELECT f FROM Factor f WHERE f.factorPK.codFactor = :codFactor"),
    @NamedQuery(name = "Factor.findByNombre", query = "SELECT f FROM Factor f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Factor.findByPonderacion", query = "SELECT f FROM Factor f WHERE f.ponderacion = :ponderacion")})
public class Factor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FactorPK factorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ponderacion", nullable = false)
    private int ponderacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factor")
    private List<Pregunta> preguntaList;
    @JoinColumn(name = "cod_cia", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public Factor() {
    }

    public Factor(FactorPK factorPK) {
        this.factorPK = factorPK;
    }

    public Factor(FactorPK factorPK, String nombre, int ponderacion) {
        this.factorPK = factorPK;
        this.nombre = nombre;
        this.ponderacion = ponderacion;
    }

    public Factor(int codCia, int codFactor) {
        this.factorPK = new FactorPK(codCia, codFactor);
    }

    public FactorPK getFactorPK() {
        return factorPK;
    }

    public void setFactorPK(FactorPK factorPK) {
        this.factorPK = factorPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }

    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
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
        hash += (factorPK != null ? factorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factor)) {
            return false;
        }
        Factor other = (Factor) object;
        if ((this.factorPK == null && other.factorPK != null) || (this.factorPK != null && !this.factorPK.equals(other.factorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Factor[ factorPK=" + factorPK + " ]";
    }
    
}
