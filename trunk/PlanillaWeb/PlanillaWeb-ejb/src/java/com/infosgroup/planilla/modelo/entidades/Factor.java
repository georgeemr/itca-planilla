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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "FACTOR")
@XmlRootElement
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
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "PONDERACION", nullable = false)
    private long ponderacion;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factor")
    private List<Pregunta> preguntaList;

    public Factor() {
    }

    public Factor(FactorPK factorPK) {
        this.factorPK = factorPK;
    }

    public Factor(FactorPK factorPK, String nombre, long ponderacion) {
        this.factorPK = factorPK;
        this.nombre = nombre;
        this.ponderacion = ponderacion;
    }

    public Factor(long codCia, long codFactor) {
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

    public long getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(long ponderacion) {
        this.ponderacion = ponderacion;
    }

    public Cias getCias() {
        return cias;
    }

    public void setCias(Cias cias) {
        this.cias = cias;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
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
